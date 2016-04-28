package cn.springmvc.model;
/**
 * 项目类型期限配置实体
 * @author 刘利
 *
 */
public class ProjectTypeTermEntity {
	/**
	 * 项目类型ID
	 */
	private long projectType;	
	/**
	 * 单位(0：天 1：月 2：年)
	 */
	private int unit;
	/**
	 * 最小借款时间
	 */
	private int minDaytime	;
	/**
	 * 最大借款时间 0：表示无上限	
	 */
	private int maxDaytime	;
	public long getProjectType() {
		return projectType;
	}
	public void setProjectType(long projectType) {
		this.projectType = projectType;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getMinDaytime() {
		return minDaytime;
	}
	public void setMinDaytime(int minDaytime) {
		this.minDaytime = minDaytime;
	}
	public int getMaxDaytime() {
		return maxDaytime;
	}
	public void setMaxDaytime(int maxDaytime) {
		this.maxDaytime = maxDaytime;
	}
	@Override
	public String toString() {
		return "ProjectTypeTermEntity [projectType=" + projectType + ", unit="
				+ unit + ", minDaytime=" + minDaytime + ", maxDaytime="
				+ maxDaytime + "]";
	}		

}
