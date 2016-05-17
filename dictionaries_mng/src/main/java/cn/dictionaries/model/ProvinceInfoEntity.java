
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典：省份实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 上午10:47:05
 */
public class ProvinceInfoEntity implements Serializable{
	
	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	
	private static final long serialVersionUID = 6751916203903353758L;

	//id
	private int pId;
	
	//省份名称
	private String pName;
	
	//省份no
	private String pNo;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	
	
}

