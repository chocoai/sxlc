package cn.springmvc.model; 

import java.util.Date;




/***
* 会员银行卡实体
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-18 下午7:21:10
*/
public class MemberBankCard {

	
	private Long		receiveCard;			//会员银行卡信息序号
	private	Integer		memberType;				//会员类型
	private Long 		memberId;				//会员编号
	private Long		bankCardId;				//银行卡信息编号
	private Date 		recordDate;				//添加时间
	private Date 		removeDate;				//移除时间
	private Integer		statu;					//状态
	private BankCardInfo cardInfo;
	
	
	public MemberBankCard() {}

	

	public MemberBankCard(Long receiveCard, Integer memberType, Long memberId,
			Long bankCardId, Date recordDate, Date removeDate, Integer statu,
			BankCardInfo cardInfo) {
		super();
		this.receiveCard = receiveCard;
		this.memberType = memberType;
		this.memberId = memberId;
		this.bankCardId = bankCardId;
		this.recordDate = recordDate;
		this.removeDate = removeDate;
		this.statu = statu;
		this.cardInfo = cardInfo;
	}



	public Long getReceiveCard() {
		return receiveCard;
	}

	public void setReceiveCard(Long receiveCard) {
		this.receiveCard = receiveCard;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public BankCardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(BankCardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	
}

