

/** 
* @Title: ProvinceDictionaryEntity.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午11:33:58 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 省信息实体
 * @since 
 * @date 2016-3-28 上午11:33:58  */

public class ProvinceDictionaryEntity {
	private long provinceId;
	/**
	 * 省名字
	 */
	private String provinceName; 	
	/**
	 * 省编号（行政编码）	
	 */
	private String provinceNo;
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}	
	@Override
	public String toString() {
		
		 return "ProvinceDictionaryEntity [provinceId=" + provinceId + ", provinceNo=" + provinceNo  
	                + ", provinceName=" + provinceName + "]"; 
		
	} 	
}

