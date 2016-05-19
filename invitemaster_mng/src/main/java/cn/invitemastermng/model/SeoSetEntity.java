

/** 
* @Title: SeoSetEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-16 下午2:12:37 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: SEO设置信息实体
 * @since 
 * @date 2016-4-16 下午2:12:37  */

public class SeoSetEntity {
	private long   seoSetID;
	private long   seoTypeID;//类型ID
	private String seoTitle;//title内容
	private String seoDescription;//描述
	private String seoKeyword;//关键词
	private String seoTypeName;//关联类型
	private String optDate;//操作时间
	private String adminName;//最近一次操作管理员
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	public String getSeoKeyword() {
		return seoKeyword;
	}
	public void setSeoKeyword(String seoKeyword) {
		this.seoKeyword = seoKeyword;
	}
	public String getSeoTypeName() {
		return seoTypeName;
	}
	public void setSeoTypeName(String seoTypeName) {
		this.seoTypeName = seoTypeName;
	}
	public String getOptDate() {
		return optDate;
	}
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getSeoTypeID() {
		return seoTypeID;
	}
	public void setSeoTypeID(long seoTypeID) {
		this.seoTypeID = seoTypeID;
	}
	public long getSeoSetID() {
		return seoSetID;
	}
	public void setSeoSetID(long seoSetID) {
		this.seoSetID = seoSetID;
	}

}

