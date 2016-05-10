

/** 
* @Title: InviteMasterAwardRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-28 下午8:05:59 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 推荐达人提奖记录
 * @since 
 * @date 2016-4-28 下午8:05:59  */

public class InviteMasterAwardRecordEntity {
	private String 			logname;//被推荐人用户名
	private String 			memberName;//被推荐人名称
	private long 			loanTotalAmount;//推荐借款总金额
	private String 			loanTotalAmounts;//推荐借款总金额
	private long 			investTotalAmountValid;//推荐借款总金额
	private String 			investTotalAmountValids;//推荐有效投资总金额
	private long  			countPayVIP;//推荐购买VIP次数 
	private long  			replayPrincipal;//推荐成功还本总金额
	private String  		replayPrincipals;//推荐成功还本总金额
	private long  			loanAward;//推荐借款提奖金额
	private String  		loanAwards;//推荐借款提奖金额
	private long  			investAward;//推荐投资提奖金额
	private String  		investAwards;//推荐投资提奖金额
	private long  			vipAward;//推荐购买VIP提奖金额
	private String  		vipAwards;//推荐购买VIP提奖金额
	private long  			repayAward;//推荐还本提奖金额
	private String  		repayAwards;//推荐还本提奖金额
	private long            totalPayVIP;//推荐购买VIP总额
	private String          totalPayVIPs;//推荐购买VIP总额
	private long            awardTotal;//提奖总额
	private String          awardTotals;//提奖总额
	public long getTotalPayVIP() {
		return totalPayVIP;
	}
	public void setTotalPayVIP(long totalPayVIP) {
		this.totalPayVIP = totalPayVIP;
		this.totalPayVIPs= IntegerAndString.LongToString(totalPayVIP);
	}
	public String getTotalPayVIPs() {
		return totalPayVIPs;
	}
	public void setTotalPayVIPs(String totalPayVIPs) {
		this.totalPayVIPs = totalPayVIPs;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public long getLoanTotalAmount() {
		return loanTotalAmount;
	}
	public void setLoanTotalAmount(long loanTotalAmount) {
		this.loanTotalAmount = loanTotalAmount;
		this.loanTotalAmounts= IntegerAndString.LongToString(loanTotalAmount);
	}
	public String getLoanTotalAmounts() {
		return loanTotalAmounts;
	}
	public void setLoanTotalAmounts(String loanTotalAmounts) {
		this.loanTotalAmounts = loanTotalAmounts;
	}
	public long getInvestTotalAmountValid() {
		return investTotalAmountValid;
	}
	public void setInvestTotalAmountValid(long investTotalAmountValid) {
		this.investTotalAmountValid = investTotalAmountValid;
		this.investTotalAmountValids= IntegerAndString.LongToString(investTotalAmountValid);
	}
	public String getInvestTotalAmountValids() {
		return investTotalAmountValids;
	}
	public void setInvestTotalAmountValids(String investTotalAmountValids) {
		this.investTotalAmountValids = investTotalAmountValids;
	}
	public long getCountPayVIP() {
		return countPayVIP;
	}
	public void setCountPayVIP(long countPayVIP) {
		this.countPayVIP = countPayVIP;
	} 
	public long getReplayPrincipal() {
		return replayPrincipal;
	}
	public void setReplayPrincipal(long replayPrincipal) {
		this.replayPrincipal = replayPrincipal;
		this.replayPrincipals= IntegerAndString.LongToString(replayPrincipal);
	}
	public String getReplayPrincipals() {
		return replayPrincipals;
	}
	public void setReplayPrincipals(String replayPrincipals) {
		this.replayPrincipals = replayPrincipals;
	}
	public long getLoanAward() {
		return loanAward;
	}
	public void setLoanAward(long loanAward) {
		this.loanAward = loanAward;
		this.loanAwards= IntegerAndString.LongToString(loanAward);
	}
	public String getLoanAwards() {
		return loanAwards;
	}
	public void setLoanAwards(String loanAwards) {
		this.loanAwards = loanAwards;
	}
	public long getInvestAward() {
		return investAward;
	}
	public void setInvestAward(long investAward) {
		this.investAward = investAward;
		this.investAwards= IntegerAndString.LongToString(investAward);
	}
	public String getInvestAwards() {
		return investAwards;
	}
	public void setInvestAwards(String investAwards) {
		this.investAwards = investAwards;
	}
	public long getVipAward() {
		return vipAward;
	}
	public void setVipAward(long vipAward) {
		this.vipAward = vipAward;
		this.vipAwards= IntegerAndString.LongToString(vipAward);
	}
	public String getVipAwards() {
		return vipAwards;
	}
	public void setVipAwards(String vipAwards) {
		this.vipAwards = vipAwards;
	}
	public long getRepayAward() {
		return repayAward;
	}
	public void setRepayAward(long repayAward) {
		this.repayAward = repayAward;
		this.repayAwards= IntegerAndString.LongToString(repayAward);
	}
	public String getRepayAwards() {
		return repayAwards;
	}
	public void setRepayAwards(String repayAwards) {
		this.repayAwards = repayAwards;
	}
	public long getAwardTotal() {
		return awardTotal;
	}
	public void setAwardTotal(long awardTotal) {
		this.awardTotal = awardTotal;
		this.awardTotals= IntegerAndString.LongToString(awardTotal);
	}
	public String getAwardTotals() {
		return awardTotals;
	}
	public void setAwardTotals(String awardTotals) {
		this.awardTotals = awardTotals;
	}
	
}

