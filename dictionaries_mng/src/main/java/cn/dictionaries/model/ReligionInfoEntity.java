
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典 ： 宗教信仰实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 下午2:55:04
 */
public class ReligionInfoEntity implements Serializable{

	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	
	private static final long serialVersionUID = -5752022304995559172L;

	//宗教类型Id
	private int rId;
	
	//类型名称
	private String 	rName;

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
	
	
}

