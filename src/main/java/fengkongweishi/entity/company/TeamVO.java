package fengkongweishi.entity.company;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fengkongweishi.handle.DateTimeSerializer;

import java.util.Date;

/**
 * @author duyiting
 * @date 2018/01/24
 */
public class TeamVO {

    private String teamName;
    private String managerName;
    private String managerMobile;
    private Integer employeeCount;
    private Integer remainder;
    private String createdByName;
    private Date createdAt;

    public TeamVO(Company company) {
        this.teamName = company.getCompanyName();
        this.managerName = company.getManager() == null ? "" : company.getManager().getNickname();
        this.managerMobile = company.getManager() == null ? "" : company.getManager().getUsername();
        this.employeeCount = company.getEmployees() == null ? 0 : company.getEmployees().size();
        this.remainder = company.getRemainder();
        this.createdByName = company.getCreatedByName();
        this.createdAt = company.getCreateTime();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managername) {
        this.managerName = managername;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
