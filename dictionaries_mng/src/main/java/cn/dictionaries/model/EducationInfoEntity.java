
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典：学历实体
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:47:17
 */
public class EducationInfoEntity implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	private static final long serialVersionUID = -8837128442155435195L;
	private int iId;			//id
	private String sEducationName;	//学历名称
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getsEducationName() {
		return sEducationName;
	}
	public void setsEducationName(String sEducationName) {
		this.sEducationName = sEducationName;
	}
}

