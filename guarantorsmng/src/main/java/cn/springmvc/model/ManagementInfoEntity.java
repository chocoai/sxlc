
package cn.springmvc.model; 

/**
 * 资产管理方信息 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午9:08:32  */
public class ManagementInfoEntity {
	private long managementID;//资产管理方ID
	private long personalID;//法人信息ID
	private String managementNO;//资产管理方编号
	private String managementName;//资产管理机构名称
	private String companyeBLN;//营业执照号码
	private String companyOC;//组织机构代码
	private String taxRegNo;//税务登记号
	private String establishments;//经营场所
	private String companyCapital;//注册资本
	private String companyAddress;//注册地址
	private String companySource;//注册资本来源
	private String companyBusiness;//经营范围
	private String companyProfile;//公司简介
	private String contactName;//联系人姓名
	private String contactPhone;//联系人手机号
	private String contactEmail;//联系人邮箱
	private String managementType;//资产管理方证件类型
	private String managementURL;//资产管理方证件路径
	private String addTime;//添加时间
	private int recordStatus;//记录状态
	private int deleteFlag;//删除标记
	public long getManagementID() {
		return managementID;
	}
	public void setManagementID(long managementID) {
		this.managementID = managementID;
	}
	public long getPersonalID() {
		return personalID;
	}
	public void setPersonalID(long personalID) {
		this.personalID = personalID;
	}
	public String getManagementNO() {
		return managementNO;
	}
	public void setManagementNO(String managementNO) {
		this.managementNO = managementNO;
	}
	public String getManagementName() {
		return managementName;
	}
	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}
	public String getCompanyeBLN() {
		return companyeBLN;
	}
	public void setCompanyeBLN(String companyeBLN) {
		this.companyeBLN = companyeBLN;
	}
	public String getCompanyOC() {
		return companyOC;
	}
	public void setCompanyOC(String companyOC) {
		this.companyOC = companyOC;
	}
	public String getTaxRegNo() {
		return taxRegNo;
	}
	public void setTaxRegNo(String taxRegNo) {
		this.taxRegNo = taxRegNo;
	}
	public String getEstablishments() {
		return establishments;
	}
	public void setEstablishments(String establishments) {
		this.establishments = establishments;
	}
	public String getCompanyCapital() {
		return companyCapital;
	}
	public void setCompanyCapital(String companyCapital) {
		this.companyCapital = companyCapital;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanySource() {
		return companySource;
	}
	public void setCompanySource(String companySource) {
		this.companySource = companySource;
	}
	public String getCompanyBusiness() {
		return companyBusiness;
	}
	public void setCompanyBusiness(String companyBusiness) {
		this.companyBusiness = companyBusiness;
	}
	public String getCompanyProfile() {
		return companyProfile;
	}
	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getManagementType() {
		return managementType;
	}
	public void setManagementType(String managementType) {
		this.managementType = managementType;
	}
	public String getManagementURL() {
		return managementURL;
	}
	public void setManagementURL(String managementURL) {
		this.managementURL = managementURL;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}

