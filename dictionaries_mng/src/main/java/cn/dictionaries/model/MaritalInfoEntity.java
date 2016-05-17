
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 字典：婚姻状况实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 下午2:46:01
 */
public class MaritalInfoEntity implements Serializable{

	
	/** 
	* @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么） 
	*/
	
	private static final long serialVersionUID = -3791410848486535259L;

	//婚姻状况id
	private int mId;
	
	//婚姻状况
	private String isOrNo;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getIsOrNo() {
		return isOrNo;
	}

	public void setIsOrNo(String isOrNo) {
		this.isOrNo = isOrNo;
	}
	
	
	
}

