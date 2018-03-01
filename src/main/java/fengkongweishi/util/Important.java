package fengkongweishi.util;

import java.util.Date;

import fengkongweishi.entity.company.Company;
import fengkongweishi.entity.user.User;

public interface Important {

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseEducation()
	 * 
	 * 
	 */
	
	Integer getId();
	
	String getAnalyseEducation();

	void setAnalyseEducation(String analyseEducation);

	boolean isEnableEducation();

	void setEnableEducation(boolean enableEducation);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseCourtJudgment()
	 */
	String getAnalyseCourtJudgment();

	void setAnalyseCourtJudgment(String analyseCourtJudgment);

	boolean isEnableCache();

	void setEnableCache(boolean enableCache);

	boolean isCache();

	void setCache(boolean cache);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseZhimaScore()
	 */
	String getAnalyseZhimaScore();

	void setAnalyseZhimaScore(String analyseZhimaScore);

	String getStatus();

	void setStatus(String status);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseAntifraud()
	 */
	String getAnalyseAntifraud();

	void setAnalyseAntifraud(String analyseAntifraud);

	String getArea();

	void setArea(String area);

	String getSex();

	void setSex(String sex);

	String getBirth();

	void setBirth(String birth);

	Integer getAge();

	void setAge(Integer age);

	String getMobileCompany();

	void setMobileCompany(String mobileCompany);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseIdCard()
	 */
	String getAnalyseIdCard();

	void setAnalyseIdCard(String analyseIdCard);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseCellphone()
	 */
	String getAnalyseCellphone();

	void setAnalyseCellphone(String analyseCellphone);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseDishonestBlacklist()
	 */
	String getAnalyseDishonestBlacklist();

	void setAnalyseDishonestBlacklist(String analyseDishonestBlacklist);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseCriminal()
	 */
	String getAnalyseCriminal();

	void setAnalyseCriminal(String analyseCriminal);

	/* (non-Javadoc)
	 * @see apifengkong.entity.Ab#getAnalyseMultipleHeadLend()
	 */
	String getAnalyseMultipleHeadLend();

	void setAnalyseMultipleHeadLend(String analyseMultipleHeadLend);

	User getUser();

	void setUser(User user);

	Company getCompany();

	void setCompany(Company company);

	String getName();

	void setName(String name);

	String getMobile();

	void setMobile(String mobile);

	String getIdCard();

	void setIdCard(String idCard);

	String getBankCard();

	void setBankCard(String bankCard);

	String getCommonAddress();

	void setCommonAddress(String commonAddress);

	Date getCreateAt();

	void setCreateAt(Date createAt);
	
	public String getAnalyseWatchlist();

	public void setAnalyseWatchlist(String analyseWatchlist);

}