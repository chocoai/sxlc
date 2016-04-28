

/** 
* @Title: ProjectAfterLoanInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 上午11:50:23 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 项目贷后信息记录实体
 * @since 
 * @date 2016-3-22 上午11:50:23  */

public class ProjectAfterLoanInfoEntity {
	private long id;	
	/**
	 * 项目申请ID	
	 */
	private long  applyId;
	/**
	 * 管理员ID
	 */
	private long  adminID;	
	/**
	 * 回复时间
	 */
	private long  recordDate; 
	/**
	 * 摘要	
	 */
	private long  abstracts;
	/**
	 * 详情描述
	 */
	private long  detail;
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
	public long getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(long recordDate) {
		this.recordDate = recordDate;
	}
	public long getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(long abstracts) {
		this.abstracts = abstracts;
	}
	public long getDetail() {
		return detail;
	}
	public void setDetail(long detail) {
		this.detail = detail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ProjectAfterLoanInfoEntity [id=" + id + ", applyId=" + applyId
				+ ", adminID=" + adminID + ", recordDate=" + recordDate
				+ ", abstracts=" + abstracts + ", detail=" + detail + "]";
	}		

}

