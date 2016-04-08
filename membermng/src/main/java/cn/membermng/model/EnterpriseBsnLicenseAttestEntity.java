
package cn.membermng.model; 

/** 
 * 企业会员工商执照认证信息
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午3:46:12  */
public class EnterpriseBsnLicenseAttestEntity {
	private long certificationID;//认证记录ID
	private String memberNo;//会员编号
	private long memberID;//会员id
	private String logname;//会员登录名
	private String recordDate;//提交申请时间
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
	private String regDate;//注册时间
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
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	public String getStatuname() {
		return statuname;
	}
	public void setStatuname(String statuname) {
		this.statuname = statuname;
	}
	
}

