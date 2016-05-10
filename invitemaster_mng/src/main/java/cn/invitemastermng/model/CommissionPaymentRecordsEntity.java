
package cn.invitemastermng.model; 

/** 
 * 佣金发放记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-26 上午10:45:58  */
public class CommissionPaymentRecordsEntity {
	private String personalName;//姓名
	private String logname;//用户名（会员用户名）
	private Long memberID;//会员ID
	private String memberNo;//会员编号
	private String personalPhone;//联系电话
	private String personalIDCard;//身份证号
	private String startDate;//提奖时间段
	private String endDate;//
	private long borrowAward;//推荐借款提奖
	private long investAward;//推荐投资提奖
	private long vipAward;//推荐购买VIP提奖
	private long repayAward;//推荐还本提奖
	private long allmonay;//应发总金额
	private long realAmount;//实际发放金额
	private String payDate;//佣金发放时间
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalIDCard() {
		return personalIDCard;
	}
	public void setPersonalIDCard(String personalIDCard) {
		this.personalIDCard = personalIDCard;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public long getBorrowAward() {
		return borrowAward;
	}
	public void setBorrowAward(long borrowAward) {
		this.borrowAward = borrowAward;
	}
	public long getInvestAward() {
		return investAward;
	}
	public void setInvestAward(long investAward) {
		this.investAward = investAward;
	}
	public long getVipAward() {
		return vipAward;
	}
	public void setVipAward(long vipAward) {
		this.vipAward = vipAward;
	}
	public long getRepayAward() {
		return repayAward;
	}
	public void setRepayAward(long repayAward) {
		this.repayAward = repayAward;
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public long getAllmonay() {
		return allmonay;
	}
	public void setAllmonay(long allmonay) {
		this.allmonay = allmonay;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public Long getMemberID() {
		return memberID;
	}
	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}
	
	
}

