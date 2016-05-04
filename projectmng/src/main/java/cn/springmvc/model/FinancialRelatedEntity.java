

/** 
* @Title: FinancialRelatedEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 下午2:24:37 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 财务相关
 * @since 
 * @date 2016-4-27 下午2:24:37  */

public class FinancialRelatedEntity {
	public long    totalRedpackets;//红包发放总额
	public String  stotalRedpackets;//红包发放总额
	public long    getTotalRedpackets;//红包发放总额
	public String  sgetTotalRedpackets;//红包领取总额 
	public long    affairAccount;//活动红包总额
	public String  saffairAccount;//活动红包总额
	public long    useRedpackets;//红包使用总额
	public String  suseRedpackets;//红包使用总额
	public long    notuseRedpackets;//红包未使用总额
	public String  snotuseRedpackets;//红包未使用总额
	public long    overRedpackets;//过期红包总额
	public String  soverRedpackets;//过期红包总额
	public long    totalVouchers;//代金券兑换总额
	public String  stotalVouchers;//代金券兑换总额
	public long    useVouchers;//代金券使用总额
	public String  suseVouchers;//代金券使用总额
	public long    payWithdrawal;//累计返现总额
	public String  spayWithdrawal;//累计返现总额
	public long    payAward;//累计奖励总额
	public String  spayAward;//累计奖励总额
	public long    rcompenRepayAmount;//平台代偿回款总金额
	public String  srcompenRepayAmount;//平台代偿回款总金额
	public long    rcompenAmount;//平台代偿总金额
	public String  srcompenAmount;//平台代偿总金额
	public long    inviteMasterAward;//平台代偿总金额
	public String  sinviteMasterAward;//平台代偿总金额
	public long    financialAdvisorAward;//推荐达人提奖总额
	public String  sfinancialAdvisorAward;//推荐达人提奖总额
	public long    pRechargeFee;//充值统计
	public String  spRechargeFee;//充值统计
	public long    pwidthdrawFee;//提现统计
	public String  spwidthdrawFee;//提现统计
	public long getTotalRedpackets() {
		return totalRedpackets;
	}
	public void setTotalRedpackets(long totalRedpackets) {
		this.totalRedpackets = totalRedpackets;
		this.stotalRedpackets= IntegerAndString.LongToString(totalRedpackets);
	}
	public String getStotalRedpackets() {
		return stotalRedpackets;
	}
	public void setStotalRedpackets(String stotalRedpackets) {
		this.stotalRedpackets = stotalRedpackets;
	}
	public long getGetTotalRedpackets() {
		return getTotalRedpackets;
	}
	public void setGetTotalRedpackets(long getTotalRedpackets) {
		this.getTotalRedpackets = getTotalRedpackets;
		this.sgetTotalRedpackets= IntegerAndString.LongToString(getTotalRedpackets);
	}
	public String getSgetTotalRedpackets() {
		return sgetTotalRedpackets;
	}
	public void setSgetTotalRedpackets(String sgetTotalRedpackets) {
		this.sgetTotalRedpackets = sgetTotalRedpackets;
	}
	public long getAffairAccount() {
		return affairAccount;
	}
	public void setAffairAccount(long affairAccount) {
		this.affairAccount = affairAccount;
		this.saffairAccount= IntegerAndString.LongToString(affairAccount);
	}
	public String getSaffairAccount() {
		return saffairAccount;
	}
	public void setSaffairAccount(String saffairAccount) {
		this.saffairAccount = saffairAccount;
	}
	public long getUseRedpackets() {
		return useRedpackets;
	}
	public void setUseRedpackets(long useRedpackets) {
		this.useRedpackets = useRedpackets;
		this.suseRedpackets = IntegerAndString.LongToString(useRedpackets);
	}
	public String getSuseRedpackets() {
		return suseRedpackets;
	}
	public void setSuseRedpackets(String suseRedpackets) {
		this.suseRedpackets = suseRedpackets;
	}
	public long getNotuseRedpackets() {
		return notuseRedpackets;
	}
	public void setNotuseRedpackets(long notuseRedpackets) {
		this.notuseRedpackets = notuseRedpackets;
		this.snotuseRedpackets = IntegerAndString.LongToString(notuseRedpackets);
	}
	public String getSnotuseRedpackets() {
		return snotuseRedpackets;
	}
	public void setSnotuseRedpackets(String snotuseRedpackets) {
		this.snotuseRedpackets = snotuseRedpackets;
	}
	public long getOverRedpackets() {
		return overRedpackets;
	}
	public void setOverRedpackets(long overRedpackets) {
		this.overRedpackets = overRedpackets;
		this.soverRedpackets = IntegerAndString.LongToString(overRedpackets);
	}
	public String getSoverRedpackets() {
		return soverRedpackets;
	}
	public void setSoverRedpackets(String soverRedpackets) {
		this.soverRedpackets = soverRedpackets;
	}
	public long getTotalVouchers() {
		return totalVouchers;
	}
	public void setTotalVouchers(long totalVouchers) {
		this.totalVouchers = totalVouchers;
		this.stotalVouchers = IntegerAndString.LongToString(totalVouchers);
	}
	public String getStotalVouchers() {
		return stotalVouchers;
	}
	public void setStotalVouchers(String stotalVouchers) {
		this.stotalVouchers = stotalVouchers;
	}
	public long getUseVouchers() {
		return useVouchers;
	}
	public void setUseVouchers(long useVouchers) {
		this.useVouchers = useVouchers;
		this.suseVouchers = IntegerAndString.LongToString(useVouchers);
	}
	public String getSuseVouchers() {
		return suseVouchers;
	}
	public void setSuseVouchers(String suseVouchers) {
		this.suseVouchers = suseVouchers;
	}
	public long getPayWithdrawal() {
		return payWithdrawal;
	}
	public void setPayWithdrawal(long payWithdrawal) {
		this.payWithdrawal = payWithdrawal;
		this.spayWithdrawal = IntegerAndString.LongToString(payWithdrawal);
	}
	public String getSpayWithdrawal() {
		return spayWithdrawal;
	}
	public void setSpayWithdrawal(String spayWithdrawal) {
		this.spayWithdrawal = spayWithdrawal;
	}
	public long getPayAward() {
		return payAward;
	}
	public void setPayAward(long payAward) {
		this.payAward = payAward;
		this.spayAward = IntegerAndString.LongToString(payAward);
	}
	public String getSpayAward() {
		return spayAward;
	}
	public void setSpayAward(String spayAward) {
		this.spayAward = spayAward;
	}
	public long getRcompenRepayAmount() {
		return rcompenRepayAmount;
	}
	public void setRcompenRepayAmount(long rcompenRepayAmount) {
		this.rcompenRepayAmount = rcompenRepayAmount;
		this.srcompenRepayAmount = IntegerAndString.LongToString(rcompenRepayAmount);
	}
	public String getSrcompenRepayAmount() {
		return srcompenRepayAmount;
	}
	public void setSrcompenRepayAmount(String srcompenRepayAmount) {
		this.srcompenRepayAmount = srcompenRepayAmount;
	}
	public long getRcompenAmount() {
		return rcompenAmount;
	}
	public void setRcompenAmount(long rcompenAmount) {
		this.rcompenAmount = rcompenAmount;
		this.srcompenAmount = IntegerAndString.LongToString(rcompenAmount);
	}
	public String getSrcompenAmount() {
		return srcompenAmount;
	}
	public void setSrcompenAmount(String srcompenAmount) {
		this.srcompenAmount = srcompenAmount;
	}
	public long getInviteMasterAward() {
		return inviteMasterAward;
	}
	public void setInviteMasterAward(long inviteMasterAward) {
		this.inviteMasterAward = inviteMasterAward;
		this.sinviteMasterAward = IntegerAndString.LongToString(inviteMasterAward);
	}
	public String getSinviteMasterAward() {
		return sinviteMasterAward;
	}
	public void setSinviteMasterAward(String sinviteMasterAward) {
		this.sinviteMasterAward = sinviteMasterAward;
	}
	public long getFinancialAdvisorAward() {
		return financialAdvisorAward;
	}
	public void setFinancialAdvisorAward(long financialAdvisorAward) {
		this.financialAdvisorAward = financialAdvisorAward;
		this.sfinancialAdvisorAward = IntegerAndString.LongToString(financialAdvisorAward);
	}
	public String getSfinancialAdvisorAward() {
		return sfinancialAdvisorAward;
	}
	public void setSfinancialAdvisorAward(String sfinancialAdvisorAward) {
		this.sfinancialAdvisorAward = sfinancialAdvisorAward;
	}
	public long getpRechargeFee() {
		return pRechargeFee;
	}
	public void setpRechargeFee(long pRechargeFee) {
		this.pRechargeFee = pRechargeFee;
		this.spRechargeFee = IntegerAndString.LongToString(pRechargeFee);
	}
	public String getSpRechargeFee() {
		return spRechargeFee;
	}
	public void setSpRechargeFee(String spRechargeFee) {
		this.spRechargeFee = spRechargeFee;
	}
	public long getPwidthdrawFee() {
		return pwidthdrawFee;
	}
	public void setPwidthdrawFee(long pwidthdrawFee) {
		this.pwidthdrawFee = pwidthdrawFee;
		this.spwidthdrawFee = IntegerAndString.LongToString(pwidthdrawFee);
	}
	public String getSpwidthdrawFee() {
		return spwidthdrawFee;
	}
	public void setSpwidthdrawFee(String spwidthdrawFee) {
		this.spwidthdrawFee = spwidthdrawFee;
	}
}

