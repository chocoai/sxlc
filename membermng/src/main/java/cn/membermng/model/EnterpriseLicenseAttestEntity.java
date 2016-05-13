package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * 企业会员营业执照认证信息
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午3:46:12  */
public class EnterpriseLicenseAttestEntity {
	private long certificationID;//认证记录ID
	private String memberNo;//会员编号
	private long memberID;//会员id
	private String logname;//会员登录名
	private String sRecordDate;//提交申请时间
	private Date   recordDate;
	private String company;//企业名称
	private int status;//认证状态0	未提交1审核中2已认证3已打回4已过期
	private long attestTypeID;//会员认证ID
	private String attestTypeName;//认证项类型名称
	private String statuname;//认证状态名称
	
	private String firmBLN;//营业执照号码
	private String firmAddress;//注册地址
	private String firmLegal;//注册法人
	private String regCapital;//注册资金
	private String regBusiness;//经营范围
	private String firmType;//公司类型
	private String sRegDate;//注册时间\颁发时间
	private Date    regDate ;
	
	
	/**房产认证*/
	private String address;//房产位置
	private int area;//面积(单位：平方米)
	private String value;//价值
	private int isMortgage;//是否已抵押 0：否  1：是
	/**车产认证*/
	private String brand;//品牌
	private String model;//型号
	private String licensePlate;//	车牌号
	
	private String residence;//住所
	private String realCapital;//实收资本
	private String sSetUpDate;//成立日期
	private Date   setUpDate;
	
	private String firmOC;//组织机构代码
	
	private String permitsCode;//开户许可证编号
	private String permitsBank;//开户银行
	private String bankNo;//银行账号
	
	
	private Date    endDate;	//有效期
	private String sEndDate;	//有效期
	
	/**税务登记证*/
	private String credentialsNO;//证件编号
	private String issueOrgan;//颁发机关
	public long getCertificationID() {
		return certificationID;
	}
	public void setCertificationID(long certificationID) {
		this.certificationID = certificationID;
	}
	public String getFirmBLN() {
		return firmBLN;
	}
	public void setFirmBLN(String firmBLN) {
		this.firmBLN = firmBLN;
	}
	public String getFirmAddress() {
		return firmAddress;
	}
	public void setFirmAddress(String firmAddress) {
		this.firmAddress = firmAddress;
	}
	public String getFirmLegal() {
		return firmLegal;
	}
	public void setFirmLegal(String firmLegal) {
		this.firmLegal = firmLegal;
	}
	public String getRegCapital() {
		return regCapital;
	}
	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}
	public String getRegBusiness() {
		return regBusiness;
	}
	public void setRegBusiness(String regBusiness) {
		this.regBusiness = regBusiness;
	}
	public String getFirmType() {
		return firmType;
	}
	public void setFirmType(String firmType) {
		this.firmType = firmType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getAttestTypeID() {
		return attestTypeID;
	}
	public void setAttestTypeID(long attestTypeID) {
		this.attestTypeID = attestTypeID;
	}
	public String getAttestTypeName() {
		return attestTypeName;
	}
	public String getFirmOC() {
		return firmOC;
	}
	public void setFirmOC(String firmOC) {
		this.firmOC = firmOC;
	}
	public String getPermitsCode() {
		return permitsCode;
	}
	public void setPermitsCode(String permitsCode) {
		this.permitsCode = permitsCode;
	}
	public String getPermitsBank() {
		return permitsBank;
	}
	public void setPermitsBank(String permitsBank) {
		this.permitsBank = permitsBank;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	public String getStatuname() {
		return statuname;
	}
	public void setStatuname(String statuname) {
		this.statuname = statuname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getRealCapital() {
		return realCapital;
	}
	public void setRealCapital(String realCapital) {
		this.realCapital = realCapital;
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate = TimestampAndString.DateToString2(recordDate);
	}
	public String getsRegDate() {
		return sRegDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		this.sRegDate =TimestampAndString.DateToString2(regDate);
	}
	public String getsSetUpDate() {
		return sSetUpDate;
	}
	public Date getSetUpDate() {
		return setUpDate;
	}
	public void setSetUpDate(Date setUpDate) {
		this.setUpDate = setUpDate;
		this.sSetUpDate =TimestampAndString.DateToString2(setUpDate);
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		this.sEndDate = TimestampAndString.DateToString2(endDate);;
	}
	public String getsEndDate() {
		return sEndDate;
	}
	public String getCredentialsNO() {
		return credentialsNO;
	}
	public void setCredentialsNO(String credentialsNO) {
		this.credentialsNO = credentialsNO;
	}
	public String getIssueOrgan() {
		return issueOrgan;
	}
	public void setIssueOrgan(String issueOrgan) {
		this.issueOrgan = issueOrgan;
	}
	public void setsRecordDate(String sRecordDate) {
		this.sRecordDate = sRecordDate;
	}
	public void setsRegDate(String sRegDate) {
		this.sRegDate = sRegDate;
	}
	public void setsSetUpDate(String sSetUpDate) {
		this.sSetUpDate = sSetUpDate;
	}
	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getIsMortgage() {
		return isMortgage;
	}
	public void setIsMortgage(int isMortgage) {
		this.isMortgage = isMortgage;
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
	
}

