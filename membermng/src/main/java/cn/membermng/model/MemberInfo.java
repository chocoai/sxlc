package cn.membermng.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;





/***
 * 会员对象实体
 * @author LiJie
 *
 */
public class MemberInfo {
	
	
	private Long 		id;						//序号
	private Integer		memberType;				//会员类型
	private String		memberNo;				//会员编号
	@NotNull(message="用户名必须填写")
	@Pattern(regexp="^(([0-9]{1,}(?=[a-zA-z_]+))|([a-zA-Z]{1,}(?=[0-9_]+)))",message="用户名由6~16位的数字、字母、或汉字至少包含2种组成")
	private String		logname;				//会员登录名
	@NotNull(message="密码不能为空")
	private String		memberPwd;				//会员密码
	@NotNull(message="确认密码不能为空")
	private String		confirmPassword;		//会员密码
	private String		safePwd;				//会员安全密码
	private Long		companyId;				//企业信息编号
	private CompanyInfo	companyInfo;
	private Long		personalId;				//个人信息编号
	private PersonalBaseInfo baseInfo;
	private String		path;					//头像路径
	private Date		regDate;				//注册时间
	private String		invitateCode;			//邀请码
	private String		beinvitateCode;			//被邀请码
	private Integer		provinceId;				//所属省份
	private String		provinceName;			//
	private Integer		cityId;					//所属市区
	private String		cityName;				//
	private Integer		countyId;				//所属区县
	private String		countyName;				//
	private Integer		townId;					//所属乡镇
	private String		townName;				//
	private Integer		integral;				//当前积分
	private Integer		creditIntegral;			//当前信用积分
	
	
	
	private String		recordDate;				//第三方开通时间
	
	
	public MemberInfo() {}


	public MemberInfo(Long id, Integer memberType, String memberNo,
			String logname, String memberPwd, String safePwd, Long companyId,
			Long personalId, String path, Date regDate, String invitateCode,
			String beinvitateCode, Integer provinceId, Integer cityId,
			Integer countyId, Integer townId, Integer integral,
			Integer creditIntegral) {
		super();
		this.id = id;
		this.memberType = memberType;
		this.memberNo = memberNo;
		this.logname = logname;
		this.memberPwd = memberPwd;
		this.safePwd = safePwd;
		this.companyId = companyId;
		this.personalId = personalId;
		this.path = path;
		this.regDate = regDate;
		this.invitateCode = invitateCode;
		this.beinvitateCode = beinvitateCode;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.countyId = countyId;
		this.townId = townId;
		this.integral = integral;
		this.creditIntegral = creditIntegral;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getMemberType() {
		return memberType;
	}


	public void setMemberType(Integer memberType) {
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


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public Long getPersonalId() {
		return personalId;
	}


	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
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


	public Integer getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public Integer getCountyId() {
		return countyId;
	}


	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}


	public Integer getTownId() {
		return townId;
	}


	public void setTownId(Integer townId) {
		this.townId = townId;
	}


	public Integer getIntegral() {
		return integral;
	}


	public void setIntegral(Integer integral) {
		this.integral = integral;
	}


	public Integer getCreditIntegral() {
		return creditIntegral;
	}


	public void setCreditIntegral(Integer creditIntegral) {
		this.creditIntegral = creditIntegral;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public PersonalBaseInfo getBaseInfo() {
		return baseInfo;
	}


	public void setBaseInfo(PersonalBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}


	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}


	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}


	public String getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
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


	public String getCountyName() {
		return countyName;
	}


	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}


	public String getTownName() {
		return townName;
	}


	public void setTownName(String townName) {
		this.townName = townName;
	}
	
	
}
