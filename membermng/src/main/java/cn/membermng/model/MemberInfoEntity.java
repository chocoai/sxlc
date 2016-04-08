

/** 
* @Title: MemberInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午8:52:28 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员实体类
 * @since 
 * @date 2016-3-21 上午8:52:28  */

public class MemberInfoEntity {
	private long id;
	/**
	 * 0：个人会员 1：企业会员	
	 */
	private int memberType; 
	/**
	 * 会员编号	
	 */
	private String memberNo; 
	/**
	 * 登录用户名	
	 */
	private String logname;
	/**
	 * 登录密码
	 */
	private String memberPwd; 	
	/**
	 * 用户安全密码
	 */
	private String safePwd	;
	/**
	 * 企业信息ID
	 */
	private long companyID; 
	/**
	 * 企业会员实体类
	 */
	private CompanyInfoEntity companyInfoEntity;
	/**
	 * 联系人信息ID/个人信息ID
	 */
	private long personalID; 	
	/**
	 * 联系人信息实体
	 */
	private PersonalBaseInfoEntity personalBaseInfoEntity;
	/**
	 * 头像路径	
	 */
	private String path	;
	/**
	 * 注册时间	
	 */
	private String regDate; 
	/**
	 * 邀请码
	 */
	private String invitateCode;
	/**
	 * 被邀请码
	 */
	private String beinvitateCode;	
	/**
	 * 所属省份	
	 */
	private int provinceId; 
	/**
	 * 所属地市
	 */
	private int cityId; 
	/**
	 * 所属县区
	 */
	private int countyId;
	/**
	 * 所属乡镇
	 */
	private int townId;
	/**
	 * 当前积分（积分商城积分） 			
	 */
	private int integral;
	/**
	 * 当前信用积分
	 */
	private int creditIntegral;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getSafePwd() {
		return safePwd;
	}
	public void setSafePwd(String safePwd) {
		this.safePwd = safePwd;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getInvitateCode() {
		return invitateCode;
	}
	public void setInvitateCode(String invitateCode) {
		this.invitateCode = invitateCode;
	}
	public String getBeinvitateCode() {
		return beinvitateCode;
	}
	public void setBeinvitateCode(String beinvitateCode) {
		this.beinvitateCode = beinvitateCode;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getCountyId() {
		return countyId;
	}
	public void setCountyId(int countyId) {
		this.countyId = countyId;
	}
	public int getTownId() {
		return townId;
	}
	public void setTownId(int townId) {
		this.townId = townId;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public int getCreditIntegral() {
		return creditIntegral;
	}
	public void setCreditIntegral(int creditIntegral) {
		this.creditIntegral = creditIntegral;
	}
	public PersonalBaseInfoEntity getPersonalBaseInfoEntity() {
		return personalBaseInfoEntity;
	}
	public void setPersonalBaseInfoEntity(PersonalBaseInfoEntity personalBaseInfoEntity) {
		this.personalBaseInfoEntity = personalBaseInfoEntity;
	}
	public CompanyInfoEntity getCompanyInfoEntity() {
		return companyInfoEntity;
	}
	public void setCompanyInfoEntity(CompanyInfoEntity companyInfoEntity) {
		this.companyInfoEntity = companyInfoEntity;
	}		

}

