package fengkongweishi.entity.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fengkongweishi.entity.company.Company;
import fengkongweishi.entity.companyremainderlog.CompanyRemainderLogRepository;
import fengkongweishi.entity.personreport.PersonReportRepository;
import fengkongweishi.entity.role.Role;
import fengkongweishi.handle.DateTimeSerializer;

import java.util.Date;

/**
 * Employees View Object
 *
 * @author duyiting
 * @date 2018/01/12
 */
public class EmployeeVO {


    private Integer id;
    private Integer companyId;
    private String nickname;
    private String companyName;
    private String username;
    private Integer queryCount;
    private Date joinCompanyTime;
    private Role role;
    private Boolean superiorMember;
    public EmployeeVO(User user, PersonReportRepository personReportRepository) {
        Company company = user.getCompany();
        this.id = user.getId();
        this.companyId = company.getId();
        this.nickname = user.getNickname();
        this.username = user.getUsername();
//        Integer count = companyRemainderLogRepository.findByCompanyAndUser(user.getCompany(),user);
        Company parent = company.getParent();
        if(parent == null){
            this.companyName = "--";
            this.superiorMember = true;
        }else{
            this.companyName = company.getCompanyName();
            this.superiorMember = false;
        }
//        this.companyName = company.getCompanyName();
        this.queryCount = personReportRepository.countByCreateByCompanyAndCreateBy(company,user);
        this.joinCompanyTime = user.getJoinCompanyTime();
        this.role = user.getRole();

    }

    public Boolean getSuperiorMember() {
        return superiorMember;
    }

    public void setSuperiorMember(Boolean superiorMember) {
        this.superiorMember = superiorMember;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    public Date getJoinCompanyTime() {
        return joinCompanyTime;
    }

    public void setJoinCompanyTime(Date joinCompanyTime) {
        this.joinCompanyTime = joinCompanyTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
