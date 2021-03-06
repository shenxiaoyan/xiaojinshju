package fengkongweishi.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import fengkongweishi.entity.company.CompanyRepository;
import fengkongweishi.entity.moxiecallbacklog.MoxieCallbackLog;
import fengkongweishi.entity.moxiecallbacklog.MoxieCallbackLogRepository;
import fengkongweishi.entity.personreport.PersonReport;
import fengkongweishi.entity.personreport.PersonReportRepository;
import fengkongweishi.entity.personreport.po.CarrierPO;
import fengkongweishi.enums.Color;
import fengkongweishi.enums.MoxieTaskStatusEnum;
import fengkongweishi.service.CompanyService;
import fengkongweishi.service.CustomerService;
import fengkongweishi.service.report.MoxieCarrierReportService;
import fengkongweishi.service.report.MoxieTaobaoReportService;
import fengkongweishi.thread.MoxieCarrierReportThread;
import fengkongweishi.thread.MoxieTaobaoReportThread;
import fengkongweishi.websocket.ReportSocket;
import fengkongweishi.websocket.reportSocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 魔蝎回调接口</br>
 * <a href="https://docs.51datakey.com/docs/carrier/350">魔蝎运营商接口文档</a> </br>
 * <a href="https://docs.51datakey.com/docs/taobao/294">魔蝎淘宝接口文档</a>
 *
 * @author huanghengkun
 * @date 2018/01/19
 */
@RestController
@RequestMapping(value = "/callback")
public class MoxieCallbackController {

    /**
     * 任务创建通知
     */
    public static final String EVENT_TASK_SUBMIT = "task.submit";
    /**
     * 任务授权登录结果通知
     */
    public static final String EVENT_TASK = "task";
    /**
     * 任务采集失败通知
     */
    public static final String EVENT_TASK_FAIL = "task.fail";
    /**
     * 账单通知
     */
    public static final String EVENT_BILL = "bill";
    /**
     * 用户报告通知
     */
    public static final String EVENT_REPORT = "report";

    @Autowired
    MoxieCallbackLogRepository moxieCallbackLogRepository;
    @Autowired
    PersonReportRepository personReportRepository;
    @Autowired
    MoxieCarrierReportService moxieCarrierReportService;
    @Autowired
    MoxieTaobaoReportService moxieTaobaoReportService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value = "/taobao/tasksubmit", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void taobaoTaskCreated(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "taobao", EVENT_TASK_SUBMIT,
                MoxieTaskStatusEnum.CREATED, JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskTaobao(taskId);
                report.setMoxieTaskTaobaoStatus(MoxieTaskStatusEnum.CREATED);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        response.setStatus(201);
    }

    @RequestMapping(value = "/carrier/tasksubmit", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void carrierTaskCreated(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "carrier", EVENT_TASK_SUBMIT,
                MoxieTaskStatusEnum.CREATED, JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskCarrier(taskId);
                report.setMoxieTaskCarrierStatus(MoxieTaskStatusEnum.CREATED);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }

        // 状态码设置为201,表示已接收数据
        response.setStatus(201);
    }

    @RequestMapping(value = "/taobao/task", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void taobaoTask(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        boolean result = (boolean) body.get("result");
        MoxieTaskStatusEnum status;
        if (result) {
            status = MoxieTaskStatusEnum.LOGIN_SUCCESS;
        } else {
            status = MoxieTaskStatusEnum.LOGIN_FAIL;
        }
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "taobao", EVENT_TASK, status, JSON.toJSONString(header),
                JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskTaobao(taskId);
                report.setMoxieTaskTaobaoStatus(status);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        response.setStatus(201);
    }

    @RequestMapping(value = "/carrier/task", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void carrierTask(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        boolean result = (boolean) body.get("result");
        MoxieTaskStatusEnum status;
        if (result) {
            status = MoxieTaskStatusEnum.LOGIN_SUCCESS;
        } else {
            status = MoxieTaskStatusEnum.LOGIN_FAIL;
        }
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "carrier", EVENT_TASK, status,
                JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskCarrier(taskId);
                report.setMoxieTaskCarrierStatus(status);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        // 状态码设置为201,表示已接收数据
        response.setStatus(201);
    }

    @RequestMapping(value = "/carrier/taskfail", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void carrierTaskFail(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "carrier", EVENT_TASK_FAIL,
                MoxieTaskStatusEnum.FETCH_FAIL, JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskCarrier(taskId);
                report.setMoxieTaskCarrierStatus(MoxieTaskStatusEnum.FETCH_FAIL);
                report.setCarrierPO(new CarrierPO(Color.ERROR));
                personReportRepository.save(report);
                // 发送通知
                ReportSocket.sendMessage(new reportSocketMessage(report.getId(), false));
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        // 状态码设置为201,表示已接收数据
        response.setStatus(201);
    }

    @RequestMapping(value = "/taobao/bill", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void taobaoBill(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "taobao", EVENT_BILL, MoxieTaskStatusEnum.FETCH_SUCCESS,
                JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskTaobao(taskId);
                report.setMoxieTaskTaobaoStatus(MoxieTaskStatusEnum.FETCH_SUCCESS);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        response.setStatus(201);
    }

    @RequestMapping(value = "/carrier/bill", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void carrierBill(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "carrier", EVENT_BILL,
                MoxieTaskStatusEnum.FETCH_SUCCESS, JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        try {
            PersonReport report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskCarrier(taskId);
                report.setMoxieTaskCarrierStatus(MoxieTaskStatusEnum.FETCH_SUCCESS);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        // 状态码设置为201,表示已接收数据
        response.setStatus(201);
    }

    @RequestMapping(value = "/taobao/report", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void taobaoReport(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        boolean result = (boolean) body.get("result");
        MoxieTaskStatusEnum status;
        if (result) {
            status = MoxieTaskStatusEnum.REPORT_SUCCESS;
        } else {
            status = MoxieTaskStatusEnum.REPORT_FAIL;
        }
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "taobao", EVENT_REPORT, status,
                JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        PersonReport report = null;
        try {
            report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskTaobao(taskId);
                report.setMoxieTaskTaobaoStatus(status);
                personReportRepository.save(report);
            }
        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        response.setStatus(201);

        if (report != null) {
            // 另开一线程处理报告 魔蝎报告失败也继续
            MoxieTaobaoReportThread mobileReportThread = new MoxieTaobaoReportThread(report, moxieTaobaoReportService);
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("premiumAccurateThreadPool").build();
            ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
            singleThreadPool.execute(mobileReportThread);
        }
    }

    @RequestMapping(value = "/carrier/report", method = RequestMethod.POST)
    @Transactional(rollbackOn = Exception.class)
    public void carrierReport(@RequestHeader Map header, @RequestBody Map body, HttpServletResponse response) {
        String taskId = getTaskIdFromBody(body);
        String userId = getUserIdFromBody(body);
        boolean result = (boolean) body.get("result");
        MoxieTaskStatusEnum status;
        if (result) {
            status = MoxieTaskStatusEnum.REPORT_SUCCESS;
        } else {
            status = MoxieTaskStatusEnum.REPORT_FAIL;
        }
        MoxieCallbackLog callbackLog = new MoxieCallbackLog(taskId, "carrier", EVENT_REPORT, status,
                JSON.toJSONString(header), JSON.toJSONString(body));
        moxieCallbackLogRepository.save(callbackLog);
        PersonReport report =  null;
        try {
            report = personReportRepository.findOne(Integer.valueOf(userId));
            if (report != null) {
                report.setMoxieTaskCarrier(taskId);
                report.setMoxieTaskCarrierStatus(status);
                personReportRepository.save(report);
            }

        } catch (Exception e) {
            System.out.println("魔蝎回调获取报告异常");
            System.out.println(e.getMessage());
        }
        // 状态码设置为201,表示已接收数据
        response.setStatus(201);

        if (report != null) {
            // 另开一线程处理报告 魔蝎报告失败也继续
            MoxieCarrierReportThread mobileReportThread = new MoxieCarrierReportThread(report, moxieCarrierReportService);
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("premiumAccurateThreadPool").build();
            ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
            singleThreadPool.execute(mobileReportThread);
        }
    }

    private String getTypeFromBody(Map body) {
        return body.get("type").toString();
    }

    private String getTaskIdFromBody(Map body) {
        return body.get("task_id").toString();
    }

    private String getUserIdFromBody(Map body) {
        return body.get("user_id").toString();
    }

    private String getEventFromHeader(Map header) {
        return header.get("x-moxie-event").toString();
    }

    private String getTypeFromHeader(Map header) {
        return header.get("x-moxie-type").toString();
    }

    private String getSignatureFromHeader(Map header) {
        return header.get("x-moxie-signature").toString();
    }

    private String getUidFromHeader(Map header) {
        return header.get("x-moxie-uid").toString();
    }
}
