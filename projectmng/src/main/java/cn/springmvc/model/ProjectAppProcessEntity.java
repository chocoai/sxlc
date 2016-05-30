

/** 
* @Title: ProjectAppProcessEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午11:32:25 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 项目进程记录实体类
 * @since 
 * @date 2016-3-21 上午11:32:25  */

public class ProjectAppProcessEntity {
	/**
	 * 项目ID
	 */
	private long projectID;
	/**
	 * 项目申请记录实体
	 */
	private ProjectAppRecordEntity projectAppRecordEntity;
	/**
	 * 提交申请时间
	 */
	private String recordDate;
	/**
	 * 借款发布时间.审核通过
	 */
	private String releaseDate;
	/**
	 * 投标开始时间
	 */
	private String startDate;
	/**
	 * 投标结束时间
	 */
	private String endDate; 
	/**
	 * 实际投标结束时间	
	 */
	private String realEndDate; 
	/**
	 * 放款时间
	 */
	private String holdDate;
    /**
     * 	借款到期时间		
     */
	private String proEndDate;
	private String settleDate;
	private int result;
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public String getProEndDate() {
		return proEndDate;
	}
	public void setProEndDate(String proEndDate) {
		this.proEndDate = proEndDate;
	}
	public ProjectAppRecordEntity getProjectAppRecordEntity() {
		return projectAppRecordEntity;
	}
	public void setProjectAppRecordEntity(ProjectAppRecordEntity projectAppRecordEntity) {
		this.projectAppRecordEntity = projectAppRecordEntity;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}	 	

}

