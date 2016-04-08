package cn.springmvc.model;



/***
 * 角色权限
 * @autho pengran
 *
 */
public class RoleAuth {
	
	private 	long	 roleId; 		//角色ID
	private 	long 	 moduleId; 		//模块ID
	private 	long 	 optId;  		//操作ID
	
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	public long getOptId() {
		return optId;
	}
	public void setOptId(long optId) {
		this.optId = optId;
	}

}
