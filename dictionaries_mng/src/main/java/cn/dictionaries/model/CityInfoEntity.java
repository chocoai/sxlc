
package cn.dictionaries.model; 
/**
 * 字典：乡镇实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 上午11:45:12
 */
public class CityInfoEntity {
	
	//id
	private int cId;
	
	//pId
	private int pId;
	
	//城市名称
	private String cName;
	
	//城市编号
	private String cNo;
	
	//城市code
	private String cCode;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
	
}

