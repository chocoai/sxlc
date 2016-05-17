
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典 ： 县区实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 下午2:23:47
 */
public class CountyInfoEntity implements Serializable{

	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	
	private static final long serialVersionUID = 4454993226350444721L;

	//县id
	private int xId;
	
	//市id
	private int cId;
	
	//县名称
	private String xName;
	
	//县no
	private String xNo;

	public int getxId() {
		return xId;
	}

	public void setxId(int xId) {
		this.xId = xId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getxName() {
		return xName;
	}

	public void setxName(String xName) {
		this.xName = xName;
	}

	public String getxNo() {
		return xNo;
	}

	public void setxNo(String xNo) {
		this.xNo = xNo;
	}
	
	
	
}

