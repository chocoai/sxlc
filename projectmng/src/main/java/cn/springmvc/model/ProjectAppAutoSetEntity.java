
package cn.springmvc.model; 

/** 
 * 项目自动投标比例设置
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午4:53:03  */
public class ProjectAppAutoSetEntity {
	private long projectID;//项目ID
	private int autoStart;//自动投标开始时间（投标开始N分钟后才能开始自动投标）
	private int autoInvestMax;//自动投标最大比例（所有自动投标所占借款总金额的最大比例，单位：一百万分之）	
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public int getAutoStart() {
		return autoStart;
	}
	public void setAutoStart(int autoStart) {
		this.autoStart = autoStart;
	}
	public int getAutoInvestMax() {
		return autoInvestMax;
	}
	public void setAutoInvestMax(int autoInvestMax) {
		this.autoInvestMax = autoInvestMax;
	}
	
}

