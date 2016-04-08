
package cn.springmvc.model; 



/** 
 * 资产管理方担保证件管理
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午10:51:31  */
public class ManagementCertificateEntity {
	private long managementID;//资产管理方ID
	private int managementType;//资产管理方证件类型
	private String managementTypeName;//资产管理方证件类型名称
	private String managementCertificateName;//资产管理方证件名称
	private String managementURL;//担保证件路径
	public long getManagementID() {
		return managementID;
	}
	public void setManagementID(long managementID) {
		this.managementID = managementID;
	}
	public int getManagementType() {
		return managementType;
	}
	public void setManagementType(int managementType) {
		this.managementType = managementType;
	}
	public String getManagementTypeName() {
		return managementTypeName;
	}
	public void setManagementTypeName(String managementTypeName) {
		this.managementTypeName = managementTypeName;
	}
	public String getManagementCertificateName() {
		return managementCertificateName;
	}
	public void setManagementCertificateName(String managementCertificateName) {
		this.managementCertificateName = managementCertificateName;
	}
	public String getManagementURL() {
		return managementURL;
	}
	public void setManagementURL(String managementURL) {
		this.managementURL = managementURL;
	}
	
}

