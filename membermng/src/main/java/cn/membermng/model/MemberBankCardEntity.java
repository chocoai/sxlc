

/** 
* @Title: MemberBankCardEntity.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午10:59:07 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员银行卡实体
 * @since 
 * @date 2016-3-28 上午10:59:07  */

public class MemberBankCardEntity {
	private long receiveCard;
	/**
	 * 会员类型 0：会员 1：担保机构 2：平台
	 */
	private int memberType;
	/**
	 * 会员ID
	 */
	private long memberID; 
    /**
     * 银行卡ID	
     */
	private long bankCardId;
	/**
	 * 银行卡信息ID
	 */
	private BankCardInfoEntity bankCardInfoEntity;
	/**
	 * 添加时间
	 */
	private String recordDate;
	/**
	 * 移除时间	
	 */
	private String removeDate;	
	/**
	 *  银行卡状态 0：无效 1：有效 
	 */
	private int statu;
	public long getReceiveCard() {
		return receiveCard;
	}
	public void setReceiveCard(long receiveCard) {
		this.receiveCard = receiveCard;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public BankCardInfoEntity getBankCardInfoEntity() {
		return bankCardInfoEntity;
	}
	public void setBankCardInfoEntity(BankCardInfoEntity bankCardInfoEntity) {
		this.bankCardInfoEntity = bankCardInfoEntity;
	}
	@Override
	public String toString() {
		return "MemberBankCardEntity [receiveCard=" + receiveCard
				+ ", memberType=" + memberType + ", memberID=" + memberID
				+ ", bankCardId=" + bankCardId + ", bankCardInfoEntity="
				+ bankCardInfoEntity + ", recordDate=" + recordDate
				+ ", removeDate=" + removeDate + ", statu=" + statu + "]";
	}		

}

