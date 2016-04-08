package cn.springmvc.model;
/**
 * 项目类型申请条件
 * @author 刘利
 *
 */
public class ProjectTypeDatumEntity {
	/**
	 * 项目类型ID
	 */
	private long  projectType;	
	/**
	 * 认证类型 0 企业认证 1 个人认证
	 */
	private int attestType;
	/**
	 * 认证项类型ID	
	 */
	private long attestTypeID;
	public long getProjectType() {
		return projectType;
	}
	public void setProjectType(long projectType) {
		this.projectType = projectType;
	}
	public int getAttestType() {
		return attestType;
	}
	public void setAttestType(int attestType) {
		this.attestType = attestType;
	}
	public long getAttestTypeID() {
		return attestTypeID;
	}
	public void setAttestTypeID(long attestTypeID) {
		this.attestTypeID = attestTypeID;
	} 
}
