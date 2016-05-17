
package cn.springmvc.model; 

/** 
 * 担保机构管理员
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-17 下午5:15:37  */
public class AdminGMEntity {
	private String adminName; 
	private String adminPwd;
	private String adminRemark; 
	private long adminId;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminRemark() {
		return adminRemark;
	}
	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	
}

