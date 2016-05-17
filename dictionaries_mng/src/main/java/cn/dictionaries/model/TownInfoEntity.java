
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典：乡镇实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 上午11:44:31
 */
public class TownInfoEntity implements Serializable{
	
	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	
	private static final long serialVersionUID = -9110728536784620617L;

	//乡id
	private int tId;
	
	//县id
	private int xId;
	
	//乡镇名称
	private String tName;
	
	//乡no
	private String tNo;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getxId() {
		return xId;
	}

	public void setxId(int xId) {
		this.xId = xId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	

}

