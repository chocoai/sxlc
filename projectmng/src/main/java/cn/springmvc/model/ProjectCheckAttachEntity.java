

/** 
* @Title: ProjectCheckAttachEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 上午11:18:06 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 项目申请审核附件
 * @since 
 * @date 2016-3-22 上午11:18:06  */

public class ProjectCheckAttachEntity {
	/**
	 * 申请审核ID 空表示：非审核阶段上传
	 */
	private long appCheckId; 
	/**
	 * 附件编号
	 */
	private int attachIndex; 
	/**
	 * 附件名称
	 */
	private String attachTitle;
	/**
	 * 附件路径
	 */
	private String attachUrl;
	/**
	 * 是否显示在前台 0：否 1：是
	 */
	private int displayStatu; 
	/**
	 * 是否有效 0:无效 1：有效
	 */
	private int typeStatu;
	/**
	 * 附件操作类型 0：添加 1：删除
	 */
	private int dealType;
	/**
	 * 审核时间
	 */
	private String dealDate;
	/**
	 * 管理员名称
	 */
	private String adminName;
	/**
	 * 删除附件审批点名称
	 */
    private String deleteapName; 
    /**
	 * 上传附件审批点名称
	 */
    private String  addapName;
    /**
     * 操作员ID
     */
    private int adminID;
    /**
     * 备注
     */
    private String dealRecord;
    /**
     * 审批点ID
     */
    private int processID;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
 
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
	public String getAttachTitle() {
		return attachTitle;
	}
	public void setAttachTitle(String attachTitle) {
		this.attachTitle = attachTitle;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
	public int getDisplayStatu() {
		return displayStatu;
	}
	public void setDisplayStatu(int displayStatu) {
		this.displayStatu = displayStatu;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	}
	public String getAddapName() {
		return addapName;
	}
	public void setAddapName(String addapName) {
		this.addapName = addapName;
	}
	public String getDeleteapName() {
		return deleteapName;
	}
	public void setDeleteapName(String deleteapName) {
		this.deleteapName = deleteapName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
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

