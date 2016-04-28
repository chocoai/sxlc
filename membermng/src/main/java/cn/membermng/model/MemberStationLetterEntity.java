

/** 
* @Title: MemberStationLetterEntity.java 
* @Package cn.securitycenter.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午2:43:27 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员站内信记录实体
 * @since 
 * @date 2016-3-29 下午2:43:27  */

public class MemberStationLetterEntity {
	/**
	 * 会员站内信记录ID
	 */
	private long letterID;	
	/**
	 * 消息发送会员ID	
	 */
	private long memberID; 
	/**
	 * 接收会员ID
	 */
	private long memberIDRec;	
	/**
	 * 回复消息
	 */
	private long preID	;
	/**
	 * 标题
	 */
	private String title; 
	/**
	 * 内容
	 */
	private String detail; 
	/**
	 * 发送时间
	 */
	private String sendDate; 
	/**
	 * 是否阅读 0：否 1：是	
	 */
	private int isRead; 
	/**
	 * 阅读时间
	 */
	private String readDate;
	/**
	 * 发送方删除标识 0：未删除 1：已删除	
	 */
	private int deleteFlagSend; 
	/**
	 * 接收方删除标识 0：未删除 1：已删除 
	 */
	private int deleteFlagRecieve;
	/**
	 * 发件人名称
	 */
	private String membername;
	private String  logname;
	public long getLetterID() {
		return letterID;
	}
	public void setLetterID(long letterID) {
		this.letterID = letterID;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getMemberIDRec() {
		return memberIDRec;
	}
	public void setMemberIDRec(long memberIDRec) {
		this.memberIDRec = memberIDRec;
	}
	public long getPreID() {
		return preID;
	}
	public void setPreID(long preID) {
		this.preID = preID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public int getDeleteFlagSend() {
		return deleteFlagSend;
	}
	public void setDeleteFlagSend(int deleteFlagSend) {
		this.deleteFlagSend = deleteFlagSend;
	}
	public int getDeleteFlagRecieve() {
		return deleteFlagRecieve;
	}
	public void setDeleteFlagRecieve(int deleteFlagRecieve) {
		this.deleteFlagRecieve = deleteFlagRecieve;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	@Override
	public String toString() {
		return "MemberStationLetterEntity [letterID=" + letterID
				+ ", memberID=" + memberID + ", memberIDRec=" + memberIDRec
				+ ", preID=" + preID + ", title=" + title + ", detail="
				+ detail + ", sendDate=" + sendDate + ", isRead=" + isRead
				+ ", readDate=" + readDate + ", deleteFlagSend="
				+ deleteFlagSend + ", deleteFlagRecieve=" + deleteFlagRecieve
				+ ", membername=" + membername + "]";
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}	

}

