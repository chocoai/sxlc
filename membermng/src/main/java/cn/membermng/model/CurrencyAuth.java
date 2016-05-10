package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;


/**
 * @author pengran
 * 认证详情 
 * @date:2016-5-4 下午3:13:59
 **/

public class CurrencyAuth {

	
	private long                memberId;		//会员id
	private long                rid;			//认证id
	private String              logName;		//登录名
	private String              realName;		//真实姓名
	private Date				endDate;		//有效期
	private String              sEndDate;		//有效期
	private String              address;		//住址
	private int                 attachType;	 	//附件类型	
	private String				attachName;		//附件名称
	private String				attachPath;		//附件路径
	private int					status;			//认证状态
	
	private String              homeAddress;	//房产位置
	private int           		area;			//房产面积 平方米
	private String              value;			//车或房子价值
	
	private String              brand;			//车品牌
	private String 				model;			//车型号
	private String				licensePlate;	//车牌号
 
	private int                 isMarried;		//结婚状态
	private String              maritalName;		//结婚
	
	private int                 education;		//学历
	private String              educationName;	//学历
	
	private String				attachPrefix;  //附件访问前缀url
	
	
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public String getMaritalName() {
		return maritalName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}
	public int getIsMarried() {
		return isMarried;
	}
	public void setIsMarried(int isMarried) {
		this.isMarried = isMarried;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getAttachType() {
		return attachType;
	}
	public void setAttachType(int attachType) {
		this.attachType = attachType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		this.sEndDate = TimestampAndString.DateToString(endDate);
	}
	public String getsEndDate() {
		return sEndDate;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAttachPrefix() {
		return attachPrefix;
	}
	public void setAttachPrefix(String attachPrefix) {
		this.attachPrefix = attachPrefix;
	}
	
	
	
}

