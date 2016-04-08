

/** 
* @Title: MemberMsgRecordEntity.java 
* @Package cn.membermsgrecord.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午5:16:18 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 站内消息
 * @since 
 * @date 2016-3-29 下午5:16:18  */

public class MemberMsgRecordEntity {
	/**
	 * 会员ID
	 */
	private long memberID;	
	/**
	 * 消息类型 0：短信 1：邮件 2：站内信
	 */
	private int  msgType; 
	/**
	 * 消息内容
	 */
	private String msgDetail;
	/**
	 * 手机号、邮件
	 */
	private String shortPhone; 
	/**
	 * 生成时间
	 */
	private String recordDate;	
	/**
	 * 状态 0：成功、1：失败 	
	 */
	private int statu;
	/**
	 * 阅读时间
	 */
	private String readDate;
	/**
	 * 1已读，0未读
	 */
	private int readStatu;
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public String getMsgDetail() {
		return msgDetail;
	}
	public void setMsgDetail(String msgDetail) {
		this.msgDetail = msgDetail;
	}
	public String getShortPhone() {
		return shortPhone;
	}
	public void setShortPhone(String shortPhone) {
		this.shortPhone = shortPhone;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public int getReadStatu() {
		return readStatu;
	}
	public void setReadStatu(int readStatu) {
		this.readStatu = readStatu;
	}
	@Override
	public String toString() {
		return "MemberMsgRecordEntity [memberID=" + memberID + ", msgType="
				+ msgType + ", msgDetail=" + msgDetail + ", shortPhone="
				+ shortPhone + ", recordDate=" + recordDate + ", statu="
				+ statu + ", readDate=" + readDate + ", readStatu=" + readStatu
				+ "]";
	}	

}

