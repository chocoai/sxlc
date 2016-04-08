

/** 
* @Title: ProjectCheckAttachDealEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午6:13:48 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 审核附件操作实体
 * @since 
 * @date 2016-3-23 下午6:13:48  */

public class ProjectCheckAttachDealEntity {
	/**
	 * 申请审核ID 空表示：非审核阶段上传	
	 */
	private long appCheckId; 
	/**
	 *  附件编号	
	 */
	private int attachIndex;
	/**
	 * 管理员ID	
	 */
	private long adminID; 
	/**
	 * 操作类型 0：添加 1：删除
	 */
	private int dealType; 
	/**
	 * 操作时间
	 */
	private String dealDate;
    /**
     * 备注
     */
    private String dealRecord;
    /**
     * 审批点ID
     */
    private int processID;
	public long getAppCheckId() {
		return appCheckId;
	}
	public void setAppCheckId(long appCheckId) {
		this.appCheckId = appCheckId;
	}
	public int getAttachIndex() {
		return attachIndex;
	}
	public void setAttachIndex(int attachIndex) {
		this.attachIndex = attachIndex;
	}
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public int getDealType() {
		return dealType;
	}
	public void setDealType(int dealType) {
		this.dealType = dealType;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealRecord() {
		return dealRecord;
	}
	public void setDealRecord(String dealRecord) {
		this.dealRecord = dealRecord;
	}
	public int getProcessID() {
		return processID;
	}
	public void setProcessID(int processID) {
		this.processID = processID;
	}	 	

}

