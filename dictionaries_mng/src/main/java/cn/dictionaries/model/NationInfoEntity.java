
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典：民族实体类
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:45:44
 */
public class NationInfoEntity implements Serializable{
	
	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	private static final long serialVersionUID = -6013856800721689632L;
	private int iId;			//id
	private String sName;		//民族名称
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
}

