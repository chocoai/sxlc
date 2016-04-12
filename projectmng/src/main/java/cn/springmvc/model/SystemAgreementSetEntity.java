package cn.springmvc.model;
/**
 * 系统协议实体类
 * @author 刘利
 *
 */
public class SystemAgreementSetEntity {
	/**
	 * 协议类型 0：注册协议 1：借款协议 2：投资协议 3：债权转让协议 4：债权转让投资	
	 */
	private int agreementType; 	
	/**
	 * 协议内容
	 */
	private String agreementDetail;
	/**
	 * 状态 0：无效 1：有效
	 */
	private int agreementStatu;
	public int getAgreementStatu() {
		return agreementStatu;
	}
	public void setAgreementStatu(int agreementStatu) {
		this.agreementStatu = agreementStatu;
	}
	public String getAgreementDetail() {
		return agreementDetail;
	}
	public void setAgreementDetail(String agreementDetail) {
		this.agreementDetail = agreementDetail;
	}
	public int getAgreementType() {
		return agreementType;
	}
	public void setAgreementType(int agreementType) {
		this.agreementType = agreementType;
	}			

}
