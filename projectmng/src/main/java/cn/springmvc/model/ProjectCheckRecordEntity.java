

/** 
* @Title: ProjectCheckRecordEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午4:21:51 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 项目申请审核记录实体 
 * @since 
 * @date 2016-3-23 下午4:21:51  */

public class ProjectCheckRecordEntity {
	/**
	 * 项目申请审核记录id
	 */
	private long appCheckId;
	/**
	 * 项目申请ID
	 */
	private long applyId;	
	/**
	 * 管理员ID
	 */
	private long adminID; 
	/**
	 * 审批活动点ID
	 */
	private int processID; 
	/**
	 * 审核时间	
	 */
	private String checkDate;
	/**
	 * 审核状态 1：通过 -1：打回  -2：已通过审核且返回补充材料  -3：需补充材料	
	 */
	private int checkStatu; 
	/**
	 * 审核意见、备注	
	 */
	private String checkRemark;
	/**
	 * 管理员名称
	 */
	private String adminName;
	/**
	 * 审核状态
	 */
	private String checkStatus;
	/**
	 * 审批点名称
	 */
	private String apName;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getApName() {
		return apName;
	}
	public void setApName(String apName) {
		this.apName = apName;
	}
	public long getAppCheckId() {
		return appCheckId;
	}
	public void setAppCheckId(long appCheckId) {
		this.appCheckId = appCheckId;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public int getProcessID() {
		return processID;
	}
	public void setProcessID(int processID) {
		this.processID = processID;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public String getCheckRemark() {
		return checkRemark;
	}
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	} 	

}

