

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

import java.util.List;

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
	private String  recordDate; 
	/**
	 * 摘要	
	 */
	private String  abstracts;
	/**
	 * 详情描述
	 */
	private String  detail;
	/**
	 * 附件信息
	 * @author TGF 用于贷后管理贷后信息查询
	 */
	private List<ProjectAfterLoanAttachmentEntity> attaches;
	
	public List<ProjectAfterLoanAttachmentEntity> getAttaches() {
		return attaches;
	}
	public void setAttaches(List<ProjectAfterLoanAttachmentEntity> attaches) {
		this.attaches = attaches;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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

