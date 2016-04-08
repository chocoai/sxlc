

/** 
* @Title: PersonalJobInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午7:44:52 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 个人工作信息实体类
 * @since 
 * @date 2016-3-21 下午7:44:52  */

public class PersonalJobInfoEntity {
	/**
	 * 个人基础信息ID
	 */
	private long personalID;
	/**
	 * 会员基本信息实体
	 */
	private PersonalBaseInfoEntity personalBaseInfoEntity;
	/**
	 * 月均收入
	 */
	private String  monthlyIncome;	
	/**
	 * 公司行业
	 */
	private String companyIndustry;	
	 /**
	  * 公司规模
	  */
	private String companySize;
	/**
	 * 职位	
	 */
	private String position;
	/**
	 * 开始工作时间
	 */
	private String	sStartDate ;
	public long getPersonalID() {
		return personalID;
	}
	public void setPersonalID(long personalID) {
		this.personalID = personalID;
	}
	public PersonalBaseInfoEntity getPersonalBaseInfoEntity() {
		return personalBaseInfoEntity;
	}
	public void setPersonalBaseInfoEntity(
			PersonalBaseInfoEntity personalBaseInfoEntity) {
		this.personalBaseInfoEntity = personalBaseInfoEntity;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getCompanyIndustry() {
		return companyIndustry;
	}
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getsStartDate() {
		return sStartDate;
	}
	public void setsStartDate(String sStartDate) {
		this.sStartDate = sStartDate;
	}		

}

