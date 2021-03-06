package fengkongweishi.controller;

import fengkongweishi.entity.company.Company;
import fengkongweishi.entity.company.CompanyRepository;
import fengkongweishi.entity.role.Role;
import fengkongweishi.entity.role.RoleRepository;
import fengkongweishi.entity.user.User;
import fengkongweishi.entity.user.UserRegister;
import fengkongweishi.entity.user.UserRepository;
import fengkongweishi.entity.user.UserVO;
import fengkongweishi.enums.ExceptionEnum;
import fengkongweishi.enums.PlatformEnum;
import fengkongweishi.service.SmsService;
import fengkongweishi.service.UserService;
import fengkongweishi.util.*;
import fengkongweishi.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户Controller
 *
 * @author XXX
 * @date 2018/1/2
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @Autowired
    SmsService smsService;

    @Value("${alipay.url}")
    private String url;
    @Value("${alipay.appId}")
    private String appId;
    @Value("${alipay.appPrivateKey}")
    private String appPrivateKey;
    @Value("${alipay.format}")
    private String format;
    @Value("${alipay.charset}")
    private String charset;
    @Value("${alipay.alipayPublicKey}")
    private String alipayPublicKey;
    @Value("${alipay.signType}")
    private String signType;

    @RequestMapping(value = "/myInfo")
    public ResponseBody info() {
        Common.UserDetailsImpl currentUser = Common.getPrincipal();
        if (currentUser == null) {
            throw new FailResponse(ExceptionEnum.NOT_LOGGED_IN);
        }
        User findOne = userRepository.findOne(currentUser.getId());
        UserVO userVO = new UserVO(findOne);
        return new ResponseBody(userVO);
    }

    /**
     * 用户角色转换
     */
    @RequestMapping(value = "/roleUpdate/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MANAGER') or hasRole('LEADER')")
    public ResponseBody roleUpdate(@PathVariable Integer id) {
        Common.UserDetailsImpl currentUser = Common.getPrincipal();
        if (currentUser == null) {
            throw new FailResponse(ExceptionEnum.NOT_LOGGED_IN);
        }
        if (!Role.defaultRole.MANAGER.getName().equals(currentUser.getUser().getRole().getName())) {
            throw new FailResponse(ExceptionEnum.NOT_HAVE_POWER);
        }
        Company company = companyRepository.findOne(currentUser.getCompany().getId());
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new FailResponse(ExceptionEnum.USER_NOT_EXIST);
        }
        if (!company.equals(user.getCompany())) {
            throw new FailResponse(ExceptionEnum.COMPANY_TEAMMOVING_USERROLE_ERROR);
        }
        userService.roleUpdate(user);
        // 角色变更,session设置超时,强制重登
        userService.invalidateSession(user.getUsername());
        return new ResponseBody("");
    }

    @RequestMapping(value = "/registerSms")
    public ResponseBody registerSms(HttpServletRequest httpServletRequest, String username) {
        if (username == null) {
            throw new FailResponse(6699, "没有手机号");
        }
        smsService.sendSms(httpServletRequest.getRemoteAddr(), username);
        return new ResponseBody();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public ResponseBody register(@RequestBody @Valid UserRegister userForm, BindingResult result) {
        if (result.hasErrors()) {
            ValidUtils.getFirstErrorInfo(result);
        }
        User user = userService.register(userForm);
        return new ResponseBody(new UserVO(user));
    }

    @RequestMapping(value = "/rePasswordSms")
    public ResponseBody rePasswordSms(HttpServletRequest httpServletRequest, String username) {
        if (username == null) {
            throw new FailResponse(6699, "没有手机号");
        }
        smsService.sendSms(httpServletRequest.getRemoteAddr(), username);
        return new ResponseBody();
    }

    @RequestMapping(value = "/rePassword", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public ResponseBody rePassword(@RequestBody @Valid UserRegister form, BindingResult result) {
        if (result.hasErrors()) {
            return ValidUtils.getFirstErrorInfo(result);
        }

        if (!form.getPassword1().equals(form.getPassword2())) {
            throw new FailResponse(5419, "两个密码不一致");
        }
        if (!smsService.checkSms(form.getUsername(), form.getSms())) {
            throw new FailResponse(ExceptionEnum.SMS_ERROR);
        }
        User user = userRepository.findByUsername(form.getUsername());

        if (user == null) {
            throw new FailResponse(7911, "用户不存在");
        }
        user.setPassword(MD5Util.encode(form.getPassword1()));
        try {
            User save = userRepository.save(user);
            return new ResponseBody(new UserVO(save));
        } catch (Exception e) {
            throw new FailResponse(3864, "手机号已经存在");
        }

    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseBody deposit(HttpServletRequest httpRequest, HttpServletResponse httpResponse, @Valid @RequestBody ChargeForm form, BindingResult result) {

        if (result.hasErrors()) {
            return ValidUtils.getFirstErrorInfo(result);
        }

        if (form.getPlatform().equals(PlatformEnum.ALIPAY)) {
            String returnForm = userService.taobaoDeposit(form.getAmount());
            HttpUtils.writeResponseWithUtf8(httpResponse, returnForm);
        }
        return new ResponseBody();
    }


    public static class ChargeForm {

        @NotNull
        private PlatformEnum platform;
        @Min(value = 1)
        @Max(value = 10000)
        private Integer amount;


        public PlatformEnum getPlatform() {
            return platform;
        }

        public void setPlatform(PlatformEnum platform) {
            this.platform = platform;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

    }

}
