
package cn.springmvc.model; 

/** 
 * 担保机构管理员
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-20 上午10:21:30  */
public class GuaranteeAdminEntity {
	private long adminID;//管理员id
	private String adminName;//管理员姓名
	private String addTime;//管理员添加时间
	private int status;//有效无效
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

