package cn.membermng.model; 

/***
 * 后台配置协议
 * 
 * @author 李杰
 * @since 
 * @date 2016-5-24 上午10:02:58 
 *
 */
public class Agreement {

	
	private int 		agreementType;					//类型编号
	private String		agreementDetail;				//类容
	private int			agreementStatu;					//状态
	private String		agreementTitle;					//标头
	
	
	
	public int getAgreementType() {
		return agreementType;
	}
	public void setAgreementType(int agreementType) {
		this.agreementType = agreementType;
	}
	public String getAgreementDetail() {
		return agreementDetail;
	}
	public void setAgreementDetail(String agreementDetail) {
		this.agreementDetail = agreementDetail;
	}
	public int getAgreementStatu() {
		return agreementStatu;
	}
	public void setAgreementStatu(int agreementStatu) {
		this.agreementStatu = agreementStatu;
	}
	public String getAgreementTitle() {
		return agreementTitle;
	}
	public void setAgreementTitle(String agreementTitle) {
		this.agreementTitle = agreementTitle;
	}
	
	
	
	
	
	
	
	
	
	
}

