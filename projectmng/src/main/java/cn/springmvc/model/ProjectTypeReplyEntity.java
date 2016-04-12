package cn.springmvc.model;
/**
 * 项目类型还款指南
 * @author 刘利
 *
 */
public class ProjectTypeReplyEntity {
	/**
	 * 项目类型ID
	 */
	private long  projectType;	
	/**
	 * 指南内容
	 */
	private String content;
	/**
	 * 指南序号，备注：不能重复，依次增加	
	 */
	private int ptIndex;
	public long getProjectType() {
		return projectType;
	}
	public void setProjectType(long projectType) {
		this.projectType = projectType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPtIndex() {
		return ptIndex;
	}
	public void setPtIndex(int ptIndex) {
		this.ptIndex = ptIndex;
	}
}
