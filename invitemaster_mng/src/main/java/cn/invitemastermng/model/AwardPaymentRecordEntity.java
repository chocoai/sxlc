

/** 
* @Title: AwardPaymentRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午2:58:42 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 推荐达人-理财顾问-佣金发放记录
 * @since 
 * @date 2016-4-5 下午2:58:42  */

public class AwardPaymentRecordEntity {
	
	private String personalName;//姓名
	private String logname;//用户名
	private String memberNo;//会员编号
	private String personalPhone;//联系电话
	private String personalIDCard;//身份证号
	private String startDate;//统计开始时间
	private String endDate;//统计结束时间
	private long borrowAward;//推荐借款提奖
	private long investAward;//推荐投资提奖
	private long vipAward;//推荐购买VIP提奖
	private long repayAward;//推荐还本提奖
	private long awardAmount;//推荐提奖总额
	private long realAmount;//实际发放金额
	private String payDate;//佣金发放时间
	private String borrowAwards;//推荐借款提奖
	private String investAwards;//推荐投资提奖
	private String vipAwards;//推荐购买VIP提奖
	private String repayAwards;//推荐还本提奖
	private String awardAmounts;//推荐提奖总额
	private String realAmounts;//实际发放金额
	
	
	private long     borrowAmount;//当期累计推荐借款总金额
	private long     investAmount;//当期累计推荐投资总金额
	private long     vipAmount;//当期累计推荐购买VIP总金额
	private long     repayAmount;// 当期累计推荐还本总金额
	private String   borrowAmounts;//当期累计推荐借款总金额
	private String   investAmounts;//当期累计推荐投资总金额
	private String   vipAmounts;//当期累计推荐购买VIP总金额
	private String   repayAmounts;// 当期累计推荐还本总金额
	private int         payStatu;//发放状态 -1：发放失败 0：未发放 1：发放中 2：发放成功
	private String      payStatus;//发放状态
	public long getBorrowAmount() {
		return borrowAmount;
	}
	public void setBorrowAmount(long borrowAmount) {
		this.borrowAmount = borrowAmount;
		this.borrowAmounts= IntegerAndString.LongToString(borrowAmount);
	}
	public long getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(long investAmount) {
		this.investAmount = investAmount;
		this.investAmounts = IntegerAndString.LongToString(investAmount);
	}
	public long getVipAmount() {
		return vipAmount;
	}
	public void setVipAmount(long vipAmount) {
		this.vipAmount = vipAmount;
		this.vipAmounts = IntegerAndString.LongToString(vipAmount);
	}
	public long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
		this.repayAmounts = IntegerAndString.LongToString(repayAmount);
	}
	public String getBorrowAmounts() {
		return borrowAmounts;
	}
	public void setBorrowAmounts(String borrowAmounts) {
		this.borrowAmounts = borrowAmounts;
	}
	public String getInvestAmounts() {
		return investAmounts;
	}
	public void setInvestAmounts(String investAmounts) {
		this.investAmounts = investAmounts;
	}
	public String getVipAmounts() {
		return vipAmounts;
	}
	public void setVipAmounts(String vipAmounts) {
		this.vipAmounts = vipAmounts;
	}
	public String getRepayAmounts() {
		return repayAmounts;
	}
	public void setRepayAmounts(String repayAmounts) {
		this.repayAmounts = repayAmounts;
	}
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
		this.borrowAwards= IntegerAndString.LongToString(borrowAward);
	}
	public long getInvestAward() {
		return investAward;
	}
	public void setInvestAward(long investAward) {
		this.investAward = investAward;
		this.investAwards= IntegerAndString.LongToString(investAward);
	}
	public long getVipAward() {
		return vipAward;
	}
	public void setVipAward(long vipAward) {
		this.vipAward = vipAward;
		this.vipAwards= IntegerAndString.LongToString(vipAward);
	}
	public long getRepayAward() {
		return repayAward;
	}
	public void setRepayAward(long repayAward) {
		this.repayAward = repayAward;
		this.repayAwards= IntegerAndString.LongToString(repayAward);
	}
	public long getAwardAmount() {
		return awardAmount;
	}
	public void setAwardAmount(long awardAmount) {
		this.awardAmount = awardAmount;
		this.awardAmounts= IntegerAndString.LongToString(awardAmount);
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts= IntegerAndString.LongToString(realAmount);
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getBorrowAwards() {
		return borrowAwards;
	}
	public void setBorrowAwards(String borrowAwards) {
		this.borrowAwards = borrowAwards;
	}
	public String getInvestAwards() {
		return investAwards;
	}
	public void setInvestAwards(String investAwards) {
		this.investAwards = investAwards;
	}
	public String getVipAwards() {
		return vipAwards;
	}
	public void setVipAwards(String vipAwards) {
		this.vipAwards = vipAwards;
	}
	public String getRepayAwards() {
		return repayAwards;
	}
	public void setRepayAwards(String repayAwards) {
		this.repayAwards = repayAwards;
	}
	public String getAwardAmounts() {
		return awardAmounts;
	}
	public void setAwardAmounts(String awardAmounts) {
		this.awardAmounts = awardAmounts;
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}

	public int getPayStatu() {
		return payStatu;
	}
	public void setPayStatu(int payStatu) {
		this.payStatu = payStatu;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	


}

