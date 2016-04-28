
package cn.sxlc.account.manager.model; 

/** 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-18 下午2:43:25  */
public class SurpriseRedEntity {
	private long memberId;//会员名称
	private long amount;//惊喜红包金额
	private long investId;//投资记录id
	private long irtid;//临时投资记录id
	public long getIrtid() {
		return irtid;
	}
	public void setIrtid(long irtid) {
		this.irtid = irtid;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	
}

