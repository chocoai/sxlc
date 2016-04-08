
package cn.springmvc.model; 

/** 
 * 担保机构担保证件管理
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-18 下午3:23:32  */
public class GuaranteeCertificateEntity {
	private long guaranteeID;//担保机构ID
	private int guaranteeType;//担保证件类型
	private String guaranteeTypeName;//担保证件类型名称
	private String guaranteeCertificateName;//担保证件名称
	private String guaranteeURL;//担保证件路径
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	public int getGuaranteeType() {
		return guaranteeType;
	}
	public void setGuaranteeType(int guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	public String getGuaranteeCertificateName() {
		return guaranteeCertificateName;
	}
	public void setGuaranteeCertificateName(String guaranteeCertificateName) {
		this.guaranteeCertificateName = guaranteeCertificateName;
	}
	public String getGuaranteeURL() {
		return guaranteeURL;
	}
	public void setGuaranteeURL(String guaranteeURL) {
		this.guaranteeURL = guaranteeURL;
	}
	public String getGuaranteeTypeName() {
		return guaranteeTypeName;
	}
	public void setGuaranteeTypeName(String guaranteeTypeName) {
		this.guaranteeTypeName = guaranteeTypeName;
	}
	
}

