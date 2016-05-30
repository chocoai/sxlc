package cn.membermng.model; 

/**
 * 双乾 银行卡地区信息
* @author 邱陈东 
* @since 
* @date 2016-5-30 下午2:36:18
 */
public class CityInfoEntity {
	int id;		
	String cityName;		//地区名称	
	int parentId;				//上级地区ID	
	int typeStatu;			//是否有效 0:无效 1：有效	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	}
	
}

