package cn.sxlc.account.manager.model;






/** 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-14 上午9:58:50  */
public class InvestRecordEntity{
	private long investId;					//投资记录id
	private long applyId;			//项目ID 相关id
	private int memberType=0;			//会员类型 0：会员
	private int memberID;			//会员ID
	private long investAmountValid;		//投资总金额
	private String sInvestAmount;	//投资总金额
	
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
	}
	public String getsInvestAmount() {
		return sInvestAmount;
	}
	public void setsInvestAmount(String sInvestAmount) {
		this.sInvestAmount = sInvestAmount;
	}
	
}
