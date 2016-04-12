

/** 
* @Title: CompanyInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午3:37:54 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 企业会员实体类
 * @since 
 * @date 2016-3-22 下午3:37:54  */

public class CompanyInfoEntity {
	private long id	; 
	/**
	 * 企业名称
	 */
	private String compangName	;	
	/**
	 * 营业执照号码/工商执照号
	 */
	private String companyeBLN	;
	/**
	 * 组织机构代码	
	 */
	private String companyOC;
	/**
	 * 税务登记号
	 */
	private String taxRegNo;
	/**
	 * 经营范围	
	 */
	private String companyBusiness;
	/**
	 * 经营场所
	 */
	private String establishments;
	/**
	 * 注册地址
	 */
	private String companyAddress;
	/**
	 * 公司简介
	 */
	private String companyProfile;	
	/**
	 * 法人信息
	 */
	private long legalID;
	/**
	 * 注册资本
	 */
	private String companyCapital;	
	/**
	 * 注册资本来源	
	 */
	private String companySource;
	/**
	 * 所属行业	
	 */
	private String companyIndustry	;
	/**
	 * 公司规模
	 */
	private String companySize	;
	/**
	 * 公司年限
	 */
	private int companyLife;		

	public int getCompanyLife() {
		return companyLife;
	}
	public void setCompanyLife(int companyLife) {
		this.companyLife = companyLife;
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
	public long getLegalID() {
		return legalID;
	}
	public void setLegalID(long legalID) {
		this.legalID = legalID;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	

}

