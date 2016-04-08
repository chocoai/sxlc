

/** 
* @Title: SendSetEntity.java 
* @Package cn.membermsgrecord.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 上午9:58:44 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 消息提醒设置
 * @since 
 * @date 2016-3-30 上午9:58:44  */

public class SendSetEntity {
	/**
	 * 消息发送会员ID	
	 */
	private long memberID; 
	/**
	 * 
	 */
	private long typeID;  
	/**
	 *  是否发送 0：不发送 1：发送	
	 */
	private int statu;
	/**
	 * 消息发送类型名称
	 */
	private String typeName;
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	

}

