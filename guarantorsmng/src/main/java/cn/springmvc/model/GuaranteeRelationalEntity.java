
package cn.springmvc.model; 

/**
 * 担保机构担保项目 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 下午4:47:56  */
public class GuaranteeRelationalEntity {
	private long projectID;//项目类型ID
	private String projectName;//项目类型名称
	private long guaranteeID;//担保机构ID
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	
}

