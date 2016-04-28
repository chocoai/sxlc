

/** 
* @Title: SeoSetTypeEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-18 下午5:42:19 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: SEO类型
 * @since 
 * @date 2016-4-18 下午5:42:19  */

public class SeoSetTypeEntity {
	private long seoTypeID;//ID																					
	private String seoTypeName;//	 类型名称																					
	public long getSeoTypeID() {
		return seoTypeID;
	}
	public void setSeoTypeID(long seoTypeID) {
		this.seoTypeID = seoTypeID;
	}
	public String getSeoTypeName() {
		return seoTypeName;
	}
	public void setSeoTypeName(String seoTypeName) {
		this.seoTypeName = seoTypeName;
	}
	private int statu;//状态 0：无效 1：有效		
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}

}

