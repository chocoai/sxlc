

/** 
* @Title: PersonalBaseInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午2:54:00 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员基本信息实体 
 * @since 
 * @date 2016-3-21 下午2:54:00  */

public class PersonalBaseInfoEntity {
	/**
	 * 会员基本信息id
	 */
	private long id;
	/**
	 * 姓名
	 */
	private String personalName;
	/**
	 * 联系人身份证
	 */
	private String personalIDCard;
	/**
	 * 性别 0 男 \ 1女
	 */
	private int sexID; 
	/**
	 * 婚姻状况
	 */
	private int maritalStatus;
	/**
	 * 婚姻状况实体
	 */
	private MaritalInfoEntity maritalInfoEntity;
	/**
	 * 最高学历	
	 */
	private int education;
	/**
	 * 毕业学校
	 */
	private String graduatedSchool; 
	/**
	 * 毕业专业	
	 */
	private String graduatedProfessionals;
	/**
	 * 毕业时间
	 */
	private String graduatedDATE	; 
	/**
	 * 民族	
	 */
	private int  nationId; 
	/**
	 * 籍贯
	 */
	private String homeTown;
	/**
	 * 户口所在地	
	 */
	private String census;
	/**
	 * 月均收入
	 */
	private String monthlyIncome;	
	/**
	 * 身份证正面
	 */
	private String legalIdCardUrl1;
	/**
	 * 身份证背面	
	 */
	private String legalIdCardUrl2;
	/**
	 * 血型 0：O型 1：A型 2：B型 3：AB型
	 */
	private int bloodType;
	/**
	 * 身高 cm	
	 */
	private int height; 
	/**
	 * 体重 斤	
	 */
	private int weight; 
	/**
	 * 宗教信仰	
	 */
	private int religionId	;
	/**
	 * 现居住地	
	 */
	private String houseAddress;
	/**
	 * 通讯地址	
	 */
	private String mailingAddress;	 
	/**
	 * 邮政编码
	 */
	private String zipCode;	
	/**
	 * 家庭地址	
	 */
	private String homeAddress; 
	/**
	 * 手机号
	 */
	private String personalPhone; 	
	/**
	 * 固定电话	
	 */
	private String personalFixPhone;
	/**
	 * 邮箱	
	 */
	private String personalEmail; 
	/**
	 * 联系qq
	 */
	private String qq;
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
	 * 工作年限
	 */
	private String workYear;
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
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalIDCard() {
		return personalIDCard;
	}
	public void setPersonalIDCard(String personalIDCard) {
		this.personalIDCard = personalIDCard;
	}
	public int getSexID() {
		return sexID;
	}
	public void setSexID(int sexID) {
		this.sexID = sexID;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getGraduatedSchool() {
		return graduatedSchool;
	}
	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}
	public String getGraduatedProfessionals() {
		return graduatedProfessionals;
	}
	public void setGraduatedProfessionals(String graduatedProfessionals) {
		this.graduatedProfessionals = graduatedProfessionals;
	}
	public String getGraduatedDATE() {
		return graduatedDATE;
	}
	public void setGraduatedDATE(String graduatedDATE) {
		this.graduatedDATE = graduatedDATE;
	}
	public int getNationId() {
		return nationId;
	}
	public void setNationId(int nationId) {
		this.nationId = nationId;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getCensus() {
		return census;
	}
	public void setCensus(String census) {
		this.census = census;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getLegalIdCardUrl1() {
		return legalIdCardUrl1;
	}
	public void setLegalIdCardUrl1(String legalIdCardUrl1) {
		this.legalIdCardUrl1 = legalIdCardUrl1;
	}
	public String getLegalIdCardUrl2() {
		return legalIdCardUrl2;
	}
	public void setLegalIdCardUrl2(String legalIdCardUrl2) {
		this.legalIdCardUrl2 = legalIdCardUrl2;
	}
	public int getBloodType() {
		return bloodType;
	}
	public void setBloodType(int bloodType) {
		this.bloodType = bloodType;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getReligionId() {
		return religionId;
	}
	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalFixPhone() {
		return personalFixPhone;
	}
	public void setPersonalFixPhone(String personalFixPhone) {
		this.personalFixPhone = personalFixPhone;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public MaritalInfoEntity getMaritalInfoEntity() {
		return maritalInfoEntity;
	}
	public void setMaritalInfoEntity(MaritalInfoEntity maritalInfoEntity) {
		this.maritalInfoEntity = maritalInfoEntity;
	}		

}

