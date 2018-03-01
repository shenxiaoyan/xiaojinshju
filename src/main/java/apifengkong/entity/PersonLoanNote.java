/*
package apifengkong.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jinrongfengkong.entity.base.BaseEntity;

@Entity
public class PersonLoanNote  extends BaseEntity {

	@ManyToOne
	@JsonIgnore
	private PersonLoan personLoan;
	
	@Transient
	@NotNull
	private Integer personLoanId;
	
	
	private String level;
	
	@Lob
	private String content;
	
	@ManyToOne
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;


	public Integer getPersonLoanId() {
		return personLoanId;
	}


	public void setPersonLoanId(Integer personLoanId) {
		this.personLoanId = personLoanId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public PersonLoan getPersonLoan() {
		return personLoan;
	}


	public void setPersonLoan(PersonLoan personLoan) {
		this.personLoan = personLoan;
	}



	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	
	
}
*/
