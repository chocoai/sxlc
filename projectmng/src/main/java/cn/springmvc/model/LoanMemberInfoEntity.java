

/** 
* @Title: LoanMemberInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-29 下午7:23:38 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 借款会员实体
 * @since 
 * @date 2016-4-29 下午7:23:38  */

public class LoanMemberInfoEntity { 
	   private long    memberID;							//
	   private String  logname;								// 用户名
	   private String  memberType;							//0：个人会员 1：企业会员
	   private long    companyID;							//企业信息ID
	   private long    personalID;							//联系人信息ID/个人信息ID
	   private String  regDate;								//注册时间
	   private String  provinceName;						//省
	   private String  cityName ;							//市
	   private int     sexID;								// 性别 0 男 \ 1女
	   private String  educationName;						// educationName
	   private String  pbiCompanyIndustry;					// 个人会员公司行业
	   private String  pbiCompanySize;						//个人会员公司规模
	   private String  position;							//职位
	   private String  startDate;							//开始工作时间
	   private String  maritalName;							//婚姻状况
	   private String  houseAddress; 						//现居住地
	   private String  companyIndustry;						//企业会员公司行业
       private String  companySize;							//企业会员公司规模
       private String  companyLife;							//公司年限
	   private String  companyCapital;						//注册资本
	   private String  personalName;						//姓名/公司名称
       private String  personalPhone;						//手机号 
   	   private String  monthlyIncome;						//月均收入	 
   	   private String  establishments;						//经营场所 
   	   private String  companyAddress;						//注册地址
   	   private int     workYear;							//工作年限
	
   	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	public long getPersonalID() {
		return personalID;
	}
	public void setPersonalID(long personalID) {
		this.personalID = personalID;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getSexID() {
		return sexID;
	}
	public void setSexID(int sexID) {
		this.sexID = sexID;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getPbiCompanyIndustry() {
		return pbiCompanyIndustry;
	}
	public void setPbiCompanyIndustry(String pbiCompanyIndustry) {
		this.pbiCompanyIndustry = pbiCompanyIndustry;
	}
	public String getPbiCompanySize() {
		return pbiCompanySize;
	}
	public void setPbiCompanySize(String pbiCompanySize) {
		this.pbiCompanySize = pbiCompanySize;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getMaritalName() {
		return maritalName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
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
	public String getCompanyLife() {
		return companyLife;
	}
	public void setCompanyLife(String companyLife) {
		this.companyLife = companyLife;
	}
	public String getCompanyCapital() {
		return companyCapital;
	}
	public void setCompanyCapital(String companyCapital) {
		this.companyCapital = companyCapital;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getEstablishments() {
		return establishments;
	}
	public void setEstablishments(String establishments) {
		this.establishments = establishments;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getWorkYear() {
		return workYear;
	}
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

}

