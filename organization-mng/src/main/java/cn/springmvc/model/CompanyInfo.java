package cn.springmvc.model;


/***
 * 企业信息实体
 * @author LiJie
 *
 */
public class CompanyInfo {

	private 		Long		id;					//序号
	private 		String		compangName;		//企业名称
	private 		String		companyeBLN;		//营业执照号码、工商执照号码
	private 		String		companyOC;			//组织机构代码
	private 		String		taxRegNo;			//税务登记号码
	private 		String		companyBusiness;	//经营范围
	private 		String		establishments;		//经营场所
	private 		String		companyAddress;		//注册地址
	private 		String		companyProfile;		//公司简介
	private 		Long		legalId;			//法人信息
	private 		String		companyCapital;		//注册资本
	private			String		companySource;		//注册资本来源
	
	
	public CompanyInfo() {}


	public CompanyInfo(Long id, String compangName, String companyeBLN,
			String companyOC, String taxRegNo, String companyBusiness,
			String establishments, String companyAddress,
			String companyProfile, Long legalId, String companyCapital,
			String companySource) {
		super();
		this.id = id;
		this.compangName = compangName;
		this.companyeBLN = companyeBLN;
		this.companyOC = companyOC;
		this.taxRegNo = taxRegNo;
		this.companyBusiness = companyBusiness;
		this.establishments = establishments;
		this.companyAddress = companyAddress;
		this.companyProfile = companyProfile;
		this.legalId = legalId;
		this.companyCapital = companyCapital;
		this.companySource = companySource;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCompangName() {
		return compangName;
	}


	public void setCompangName(String compangName) {
		this.compangName = compangName;
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


	public String getCompanyBusiness() {
		return companyBusiness;
	}


	public void setCompanyBusiness(String companyBusiness) {
		this.companyBusiness = companyBusiness;
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


	public String getCompanyProfile() {
		return companyProfile;
	}


	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}


	public Long getLegalId() {
		return legalId;
	}


	public void setLegalId(Long legalId) {
		this.legalId = legalId;
	}


	public String getCompanyCapital() {
		return companyCapital;
	}


	public void setCompanyCapital(String companyCapital) {
		this.companyCapital = companyCapital;
	}


	public String getCompanySource() {
		return companySource;
	}


	public void setCompanySource(String companySource) {
		this.companySource = companySource;
	}
}
