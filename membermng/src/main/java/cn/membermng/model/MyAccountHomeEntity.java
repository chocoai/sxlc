

/** 
* @Title: MyAccountHomeEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-7 上午10:14:09 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 我的账户首页-账户信息
 * @since 
 * @date 2016-4-7 上午10:14:09  */

public class MyAccountHomeEntity {
	private long userBalance;//可用余额
	private long frozen;//冻结金额
	private long giftUserBalance;//代金券金额
	private long willRecPrincipal; //待收本金=应收本金-实收本金
    private long willRecInterest;//待收收益=应收收益-实收收益
    private long repayAmount;//待还总额=应还本金+应还利息-实还本金-实还利息
    private long totalAmount;//账户总额=可用余额+冻结金额+待收本金+待收收益-还款总额
    private long chargemoney;//累计充值
    private long withdrawalMoney;//累计提现
    private long giftAmount;//红包金额=红包总金额-红包使用金额
    private long friends;//已邀请好友
    private long integralResidue; //可用积分
    private long investAmountValid;//累计投资
    private long realAmount;//累计收益
    private long backAmount;//投标奖励
    private long investVouchersAmount;//代金券抵扣
    private long investGiftAmount;//红包抵扣
    private long amount;//累计借款
    private long willRepayPrincipal;//待还本金=应还本金-实还本金
    private long willRepayInterest;//待还收益=应还收益-实还收益
    private long overdue;//逾期未还=待还本金+待还收益-未到还款时间的本息
    private String lastDate;//最近应还日期
    private String userBalances;//可用余额
	private String frozens;//冻结金额
	private String giftUserBalances;//代金券金额
	private String willRecPrincipals; //待收本金=应收本金-实收本金
    private String willRecInterests;//待收收益=应收收益-实收收益
    private String repayAmounts;//待还总额=应还本金+应还利息-实还本金-实还利息
    private String totalAmounts;//账户总额=可用余额+冻结金额+待收本金+待收收益-还款总额
    private String chargemoneys;//累计充值
    private String withdrawalMoneys;//累计提现
    private String giftAmounts;//红包金额=红包总金额-红包使用金额  
    private String investAmountValids;//累计投资
    private String realAmounts;//累计收益
    private String backAmounts;//投标奖励
    private String investVouchersAmounts;//代金券抵扣
    private String investGiftAmounts;//红包抵扣
    private String amounts;//累计借款
    private String willRepayPrincipals;//待还本金=应还本金-实还本金
    private String willRepayInterests;//待还收益=应还收益-实还收益
    private String overdues;//逾期未还=待还本金+待还收益-未到还款时间的本息
	public long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
		this.userBalances= IntegerAndString.LongToString2(userBalance);
	}
	public long getFrozen() {
		return frozen;
	}
	public void setFrozen(long frozen) {
		this.frozen = frozen;
		this.frozens= IntegerAndString.LongToString2(frozen);
	}
	public long getGiftUserBalance() {
		return giftUserBalance;
	}
	public void setGiftUserBalance(long giftUserBalance) {
		this.giftUserBalance = giftUserBalance;
		this.giftUserBalances= IntegerAndString.LongToString2(giftUserBalance);
	}
	public long getWillRecPrincipal() {
		return willRecPrincipal;
	}
	public void setWillRecPrincipal(long willRecPrincipal) {
		this.willRecPrincipal = willRecPrincipal;
		this.willRecPrincipals= IntegerAndString.LongToString2(willRecPrincipal);
	}
	public long getWillRecInterest() {
		return willRecInterest;
	}
	public void setWillRecInterest(long willRecInterest) {
		this.willRecInterest = willRecInterest;
		this.willRecInterests= IntegerAndString.LongToString2(willRecInterest);
	}
	public long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
		this.repayAmounts= IntegerAndString.LongToString2(repayAmount);
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		this.totalAmounts= IntegerAndString.LongToString2(totalAmount);
	}
	public long getChargemoney() {
		return chargemoney;
	}
	public void setChargemoney(long chargemoney) {
		this.chargemoney = chargemoney;
		this.chargemoneys= IntegerAndString.LongToString2(chargemoney);
	}
	public long getWithdrawalMoney() {
		return withdrawalMoney;
	}
	public void setWithdrawalMoney(long withdrawalMoney) {
		this.withdrawalMoney = withdrawalMoney;
		this.withdrawalMoneys= IntegerAndString.LongToString2(withdrawalMoney);
	}
	public long getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(long giftAmount) {
		this.giftAmount = giftAmount;
		this.giftAmounts= IntegerAndString.LongToString2(giftAmount);
	}
	public long getFriends() {
		return friends;
	}
	public void setFriends(long friends) {
		this.friends = friends; 
	}
	public long getIntegralResidue() {
		return integralResidue;
	}
	public void setIntegralResidue(long integralResidue) {
		this.integralResidue = integralResidue; 
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
		this.investAmountValids= IntegerAndString.LongToString2(investAmountValid);
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts= IntegerAndString.LongToString2(realAmount);
	}
	public long getBackAmount() {
		return backAmount;
	}
	public void setBackAmount(long backAmount) {
		this.backAmount = backAmount;
		this.backAmounts= IntegerAndString.LongToString2(backAmount);
	}
	public long getInvestVouchersAmount() {
		return investVouchersAmount;
	}
	public void setInvestVouchersAmount(long investVouchersAmount) {
		this.investVouchersAmount = investVouchersAmount;
		this.investVouchersAmounts= IntegerAndString.LongToString2(investVouchersAmount);
	}
	public long getInvestGiftAmount() {
		return investGiftAmount;
	}
	public void setInvestGiftAmount(long investGiftAmount) {
		this.investGiftAmount = investGiftAmount;
		this.investGiftAmounts= IntegerAndString.LongToString2(investGiftAmount);
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts= IntegerAndString.LongToString2(amount);
	}
	public long getWillRepayPrincipal() {
		return willRepayPrincipal;
	}
	public void setWillRepayPrincipal(long willRepayPrincipal) {
		this.willRepayPrincipal = willRepayPrincipal;
		this.willRepayPrincipals= IntegerAndString.LongToString2(willRepayPrincipal);
	}
	public long getWillRepayInterest() {
		return willRepayInterest;
	}
	public void setWillRepayInterest(long willRepayInterest) {
		this.willRepayInterest = willRepayInterest;
		this.willRepayInterests= IntegerAndString.LongToString2(willRepayInterest);
	}
	public long getOverdue() {
		return overdue;
	}
	public void setOverdue(long overdue) {
		this.overdue = overdue;
		this.overdues= IntegerAndString.LongToString2(overdue);
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	public String getFrozens() {
		return frozens;
	}
	public void setFrozens(String frozens) {
		this.frozens = frozens;
	}
	public String getGiftUserBalances() {
		return giftUserBalances;
	}
	public void setGiftUserBalances(String giftUserBalances) {
		this.giftUserBalances = giftUserBalances;
	}
	public String getWillRecPrincipals() {
		return willRecPrincipals;
	}
	public void setWillRecPrincipals(String willRecPrincipals) {
		this.willRecPrincipals = willRecPrincipals;
	}
	public String getWillRecInterests() {
		return willRecInterests;
	}
	public void setWillRecInterests(String willRecInterests) {
		this.willRecInterests = willRecInterests;
	}
	public String getRepayAmounts() {
		return repayAmounts;
	}
	public void setRepayAmounts(String repayAmounts) {
		this.repayAmounts = repayAmounts;
	}
	public String getTotalAmounts() {
		return totalAmounts;
	}
	public void setTotalAmounts(String totalAmounts) {
		this.totalAmounts = totalAmounts;
	}
	public String getChargemoneys() {
		return chargemoneys;
	}
	public void setChargemoneys(String chargemoneys) {
		this.chargemoneys = chargemoneys;
	}
	public String getWithdrawalMoneys() {
		return withdrawalMoneys;
	}
	public void setWithdrawalMoneys(String withdrawalMoneys) {
		this.withdrawalMoneys = withdrawalMoneys;
	}
	public String getGiftAmounts() {
		return giftAmounts;
	}
	public void setGiftAmounts(String giftAmounts) {
		this.giftAmounts = giftAmounts;
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}
	public String getBackAmounts() {
		return backAmounts;
	}
	public void setBackAmounts(String backAmounts) {
		this.backAmounts = backAmounts;
	}
	public String getInvestVouchersAmounts() {
		return investVouchersAmounts;
	}
	public void setInvestVouchersAmounts(String investVouchersAmounts) {
		this.investVouchersAmounts = investVouchersAmounts;
	}
	public String getInvestGiftAmounts() {
		return investGiftAmounts;
	}
	public void setInvestGiftAmounts(String investGiftAmounts) {
		this.investGiftAmounts = investGiftAmounts;
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getWillRepayPrincipals() {
		return willRepayPrincipals;
	}
	public void setWillRepayPrincipals(String willRepayPrincipals) {
		this.willRepayPrincipals = willRepayPrincipals;
	}
	public String getWillRepayInterests() {
		return willRepayInterests;
	}
	public void setWillRepayInterests(String willRepayInterests) {
		this.willRepayInterests = willRepayInterests;
	}
	public String getOverdues() {
		return overdues;
	}
	public void setOverdues(String overdues) {
		this.overdues = overdues;
	}
	@Override
	public String toString() {
		return "MyAccountHomeEntity [userBalance=" + userBalance + ", frozen="
				+ frozen + ", giftUserBalance=" + giftUserBalance
				+ ", willRecPrincipal=" + willRecPrincipal
				+ ", willRecInterest=" + willRecInterest + ", repayAmount="
				+ repayAmount + ", totalAmount=" + totalAmount
				+ ", chargemoney=" + chargemoney + ", withdrawalMoney="
				+ withdrawalMoney + ", giftAmount=" + giftAmount + ", friends="
				+ friends + ", integralResidue=" + integralResidue
				+ ", investAmountValid=" + investAmountValid + ", realAmount="
				+ realAmount + ", backAmount=" + backAmount
				+ ", investVouchersAmount=" + investVouchersAmount
				+ ", investGiftAmount=" + investGiftAmount + ", amount="
				+ amount + ", willRepayPrincipal=" + willRepayPrincipal
				+ ", willRepayInterest=" + willRepayInterest + ", overdue="
				+ overdue + ", lastDate=" + lastDate + ", userBalances="
				+ userBalances + ", frozens=" + frozens + ", giftUserBalances="
				+ giftUserBalances + ", willRecPrincipals=" + willRecPrincipals
				+ ", willRecInterests=" + willRecInterests + ", repayAmounts="
				+ repayAmounts + ", totalAmounts=" + totalAmounts
				+ ", chargemoneys=" + chargemoneys + ", withdrawalMoneys="
				+ withdrawalMoneys + ", giftAmounts=" + giftAmounts
				+ ", investAmountValids=" + investAmountValids
				+ ", realAmounts=" + realAmounts + ", backAmounts="
				+ backAmounts + ", investVouchersAmounts="
				+ investVouchersAmounts + ", investGiftAmounts="
				+ investGiftAmounts + ", amounts=" + amounts
				+ ", willRepayPrincipals=" + willRepayPrincipals
				+ ", willRepayInterests=" + willRepayInterests + ", overdues="
				+ overdues + "]";
	}
	
}

