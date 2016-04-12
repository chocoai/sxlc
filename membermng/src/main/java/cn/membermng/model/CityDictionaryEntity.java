

/** 
* @Title: CityDictionaryEntity.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午11:36:04 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 市信息实体
 * @since 
 * @date 2016-3-28 上午11:36:04  */

public class CityDictionaryEntity {
	/**
	 * 市信息ID
	 */
	private int cityId;
	/**
	 * 省份ID	
	 */
	private int provinceId;
	/**
	 * 地市名称
	 */
	private String  cityName ;	
	/**
	 *  地市编号（行政编码）	
	 */
	private String cityNo;	
	/**
	 * 地市电话区号	
	 */
	private String cityCode;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Override
	public String toString() {
		return "CityDictionaryEntity [cityId=" + cityId + ", provinceId="
				+ provinceId + ", cityName=" + cityName + ", cityNo=" + cityNo
				+ ", cityCode=" + cityCode + "]";
	} 	
  	
}

