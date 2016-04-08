

/** 
* @Title: ProjectAfterLoanAttachmentEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 上午11:53:27 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 项目贷后信息附件资料
 * @since 
 * @date 2016-3-22 上午11:53:27  */

public class ProjectAfterLoanAttachmentEntity {
	/**
	 * 记录ID	
	 */
	private long infoId;
	/**
	 * 项目贷后信息记录实体
	 */
	private ProjectAfterLoanInfoEntity projectAfterLoanInfoEntity;
	/**
	 * 附件标题
	 */
	private String attachTitle;
	/**
	 * 附件路径
	 */
	private String attachUrl;
	public long getInfoId() {
		return infoId;
	}
	public void setInfoId(long infoId) {
		this.infoId = infoId;
	}
	public ProjectAfterLoanInfoEntity getProjectAfterLoanInfoEntity() {
		return projectAfterLoanInfoEntity;
	}
	public void setProjectAfterLoanInfoEntity(
			ProjectAfterLoanInfoEntity projectAfterLoanInfoEntity) {
		this.projectAfterLoanInfoEntity = projectAfterLoanInfoEntity;
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

}

