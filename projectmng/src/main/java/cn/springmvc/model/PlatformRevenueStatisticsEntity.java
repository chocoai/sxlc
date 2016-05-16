

/** 
* @Title: PlatformRevenueStatisticsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 下午1:37:31 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 平台收益统计
 * @since 
 * @date 2016-4-27 下午1:37:31  */

public class PlatformRevenueStatisticsEntity {
	private long   rMngFeeAmount;//平台收取借款管理费
	private String rMngFeeAmounts;//平台收取借款管理费
	private long   investMngFeeAmount;//平台收取投资管理费
	private String investMngFeeAmounts;//平台收取投资管理费
	private long   rRiskMarginFee;//收取风险保证金总额
	private String rRiskMarginFees;//收取风险保证金总额
	private long   oRiskMarginFee;//退还风险保证金总额
	private String oRiskMarginFees;//退还风险保证金总额
	private long   rechargeFee;//会员支付充值费用总额
	private String rechargeFees;//会员支付充值费用总额
	private long   withdrawalFee;//会员支付提现手续费总额
	private String withdrawalFees;//会员支付提现手续费总额
	private long   pRechargeFee;//平台代付充值费用总额
	private String pRechargeFees;//平台代付充值费用总额
	private long   pwidthdrawFee;//平台代付提现费用总额
	private String pwidthdrawFees;//平台代付提现费用总额
	private long   pgetwidthdrawFee;//平台收取提现手续费
	private String pgetwidthdrawFees;//平台收取提现手续费
	private long   rTransFeeAmount;//平台收取债权转让手续费总额
	private String rTransFeeAmounts;//平台收取债权转让手续费总额
	private long   roverFeeAmount;//收取逾期罚金总额
	private String roverFeeAmounts;//收取逾期罚金总额
	private long   rcompenRepayAmount;//平台代偿回款总金额
	private String rcompenRepayAmounts;//平台代偿回款总金额
	private long   rcompenAmount;//平台代偿总金额
	private String rcompenAmounts;//平台代偿总金额
	private long   inviteMasterAward;//推荐达人提奖总额
	private String inviteMasterAwards;//推荐达人提奖总额
	private long   financialAdvisorAward;//理财顾问提奖总额
	private String financialAdvisorAwards;//理财顾问提奖总额
	private long   kcrRiskMarginFee;//扣除风险保证金
	private String kcrRiskMarginFees;//扣除风险保证金
	public long getKcrRiskMarginFee() {
		return kcrRiskMarginFee;
	}
	public void setKcrRiskMarginFee(long kcrRiskMarginFee) {
		this.kcrRiskMarginFee = kcrRiskMarginFee;
		this.kcrRiskMarginFees= IntegerAndString.LongToString(kcrRiskMarginFee);
	}
	public String getKcrRiskMarginFees() {
		return kcrRiskMarginFees;
	}
	public void setKcrRiskMarginFees(String kcrRiskMarginFees) {
		this.kcrRiskMarginFees = kcrRiskMarginFees;
	}
	public long getrMngFeeAmount() {
		return rMngFeeAmount;
	}
	public void setrMngFeeAmount(long rMngFeeAmount) {
		this.rMngFeeAmount = rMngFeeAmount;
		this.rMngFeeAmounts= IntegerAndString.LongToString(rMngFeeAmount);
	}
	public String getrMngFeeAmounts() {
		return rMngFeeAmounts;
	}
	public void setrMngFeeAmounts(String rMngFeeAmounts) {
		this.rMngFeeAmounts = rMngFeeAmounts;
	}
	public long getInvestMngFeeAmount() {
		return investMngFeeAmount;
	}
	public void setInvestMngFeeAmount(long investMngFeeAmount) {
		this.investMngFeeAmount = investMngFeeAmount;
		this.investMngFeeAmounts= IntegerAndString.LongToString(investMngFeeAmount);
	}
	public String getInvestMngFeeAmounts() {
		return investMngFeeAmounts;
	}
	public void setInvestMngFeeAmounts(String investMngFeeAmounts) {
		this.investMngFeeAmounts = investMngFeeAmounts;
	}
	public long getrRiskMarginFee() {
		return rRiskMarginFee;
	}
	public void setrRiskMarginFee(long rRiskMarginFee) {
		this.rRiskMarginFee = rRiskMarginFee;
		this.rRiskMarginFees= IntegerAndString.LongToString(rRiskMarginFee);
	}
	public String getrRiskMarginFees() {
		return rRiskMarginFees;
	}
	public void setrRiskMarginFees(String rRiskMarginFees) {
		this.rRiskMarginFees = rRiskMarginFees;
	}
	public long getoRiskMarginFee() {
		return oRiskMarginFee;
	}
	public void setoRiskMarginFee(long oRiskMarginFee) {
		this.oRiskMarginFee = oRiskMarginFee;
		this.oRiskMarginFees= IntegerAndString.LongToString(oRiskMarginFee);
	}
	public String getoRiskMarginFees() {
		return oRiskMarginFees;
	}
	public void setoRiskMarginFees(String oRiskMarginFees) {
		this.oRiskMarginFees = oRiskMarginFees;
	}
	public long getRechargeFee() {
		return rechargeFee;
	}
	public void setRechargeFee(long rechargeFee) {
		this.rechargeFee = rechargeFee;
		this.rechargeFees= IntegerAndString.LongToString(rechargeFee);
	}
	public String getRechargeFees() {
		return rechargeFees;
	}
	public void setRechargeFees(String rechargeFees) {
		this.rechargeFees = rechargeFees;
	}
	public long getWithdrawalFee() {
		return withdrawalFee;
	}
	public void setWithdrawalFee(long withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
		this.withdrawalFees= IntegerAndString.LongToString(withdrawalFee);
	}
	public String getWithdrawalFees() {
		return withdrawalFees;
	}
	public void setWithdrawalFees(String withdrawalFees) {
		this.withdrawalFees = withdrawalFees;
	}
	public long getpRechargeFee() {
		return pRechargeFee;
	}
	public void setpRechargeFee(long pRechargeFee) {
		this.pRechargeFee = pRechargeFee;
		this.pRechargeFees= IntegerAndString.LongToString(pRechargeFee);
	}
	public String getpRechargeFees() {
		return pRechargeFees;
	}
	public void setpRechargeFees(String pRechargeFees) {
		this.pRechargeFees = pRechargeFees;
	}
	public long getPwidthdrawFee() {
		return pwidthdrawFee;
	}
	public void setPwidthdrawFee(long pwidthdrawFee) {
		this.pwidthdrawFee = pwidthdrawFee;
		this.pwidthdrawFees= IntegerAndString.LongToString(pwidthdrawFee);
	}
	public String getPwidthdrawFees() {
		return pwidthdrawFees;
	}
	public void setPwidthdrawFees(String pwidthdrawFees) {
		this.pwidthdrawFees = pwidthdrawFees;
	}
	public long getPgetwidthdrawFee() {
		return pgetwidthdrawFee;
	}
	public void setPgetwidthdrawFee(long pgetwidthdrawFee) {
		this.pgetwidthdrawFee = pgetwidthdrawFee;
		this.pgetwidthdrawFees= IntegerAndString.LongToString(pgetwidthdrawFee);
	}
	public String getPgetwidthdrawFees() {
		return pgetwidthdrawFees;
	}
	public void setPgetwidthdrawFees(String pgetwidthdrawFees) {
		this.pgetwidthdrawFees = pgetwidthdrawFees;
	}
	public long getrTransFeeAmount() {
		return rTransFeeAmount;
	}
	public void setrTransFeeAmount(long rTransFeeAmount) {
		this.rTransFeeAmount = rTransFeeAmount;
		this.rTransFeeAmounts= IntegerAndString.LongToString(rTransFeeAmount);
	}
	public String getrTransFeeAmounts() {
		return rTransFeeAmounts;
	}
	public void setrTransFeeAmounts(String rTransFeeAmounts) {
		this.rTransFeeAmounts = rTransFeeAmounts;
	}
	public long getRoverFeeAmount() {
		return roverFeeAmount;
	}
	public void setRoverFeeAmount(long roverFeeAmount) {
		this.roverFeeAmount = roverFeeAmount;
		this.roverFeeAmounts= IntegerAndString.LongToString(roverFeeAmount);
	}
	public String getRoverFeeAmounts() {
		return roverFeeAmounts;
	}
	public void setRoverFeeAmounts(String roverFeeAmounts) {
		this.roverFeeAmounts = roverFeeAmounts;
	}
	public long getRcompenRepayAmount() {
		return rcompenRepayAmount;
	}
	public void setRcompenRepayAmount(long rcompenRepayAmount) {
		this.rcompenRepayAmount = rcompenRepayAmount;
		this.rcompenRepayAmounts= IntegerAndString.LongToString(rcompenRepayAmount);
	}
	public String getRcompenRepayAmounts() {
		return rcompenRepayAmounts;
	}
	public void setRcompenRepayAmounts(String rcompenRepayAmounts) {
		this.rcompenRepayAmounts = rcompenRepayAmounts;
	}
	public long getRcompenAmount() {
		return rcompenAmount;
	}
	public void setRcompenAmount(long rcompenAmount) {
		this.rcompenAmount = rcompenAmount;
		this.rcompenAmounts= IntegerAndString.LongToString(rcompenAmount);
	}
	public String getRcompenAmounts() {
		return rcompenAmounts;
	}
	public void setRcompenAmounts(String rcompenAmounts) {
		this.rcompenAmounts = rcompenAmounts;
	}
	public long getInviteMasterAward() {
		return inviteMasterAward;
	}
	public void setInviteMasterAward(long inviteMasterAward) {
		this.inviteMasterAward = inviteMasterAward;
		this.inviteMasterAwards= IntegerAndString.LongToString(inviteMasterAward);
	}
	public String getInviteMasterAwards() {
		return inviteMasterAwards;
	}
	public void setInviteMasterAwards(String inviteMasterAwards) {
		this.inviteMasterAwards = inviteMasterAwards;
	}
	public long getFinancialAdvisorAward() {
		return financialAdvisorAward;
	}
	public void setFinancialAdvisorAward(long financialAdvisorAward) {
		this.financialAdvisorAward = financialAdvisorAward;
		this.financialAdvisorAwards= IntegerAndString.LongToString(financialAdvisorAward);
	}
	public String getFinancialAdvisorAwards() {
		return financialAdvisorAwards;
	}
	public void setFinancialAdvisorAwards(String financialAdvisorAwards) {
		this.financialAdvisorAwards = financialAdvisorAwards;
	}
	
	
	
}

