

/** 
* @Title: MaritalInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午3:29:32 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 会员婚姻状况实体 
 * @since 
 * @date 2016-3-21 下午3:29:32  */

public class MaritalInfoEntity {
	/**
	 * 婚姻状况id
	 */
	private int id;	 
	/**
	 * 婚姻状况 未婚\已婚\离婚\丧偶		
	 */
	private String maritalName;	
	/**
	 * 是否有效 0:无效 1：有效	
	 */
	private int typeStatu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaritalName() {
		return maritalName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	}	 	

}

