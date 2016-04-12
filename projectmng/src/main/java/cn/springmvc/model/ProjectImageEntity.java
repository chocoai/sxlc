

/** 
* @Title: ProjectImageEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午8:32:13 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 企业形象图
 * @since 
 * @date 2016-3-23 下午8:32:13  */

public class ProjectImageEntity {
	/**
	 * 项目申请ID
	 */
	private long applyId;	 
	/**
	 * 形象图片编号	
	 */
	private int imageIndex;
	/**
	 * 形象图片路径
	 */
	private String imageUrl;
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public int getImageIndex() {
		return imageIndex;
	}
	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	} 			

}

