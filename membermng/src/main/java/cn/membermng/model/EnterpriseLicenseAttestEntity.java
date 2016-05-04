package cn.membermng.model; 

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
	private String recordDate;//提交申请时间
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
	private String regDate;//注册时间\颁发时间
	
	private String residence;//住所
	private String realCapital;//实收资本
	private String setUpDate;//成立日期
	
	private String firmOC;//组织机构代码
	
	private String permitsCode;//开户许可证编号
	private String permitsBank;//开户银行
	private String bankNo;//银行账号
	
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
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
	public String getSetUpDate() {
		return setUpDate;
	}
	public void setSetUpDate(String setUpDate) {
		this.setUpDate = setUpDate;
	}
	
}

