

/** 
* @Title: IndexStaticsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-5 下午7:56:33 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description:首页数据统计
 * @since 
 * @date 2016-5-5 下午7:56:33  */

public class IndexStaticsEntity {
	private int countmember;//会员个数
	private long incomeTotal;//为投资人赚取
	private String incomeTotals;//为投资人赚取
	private long totalLoanAmount;//已撮合总额
	private String totalLoanAmounts;//已撮合总额
	private long riskReserveFund;//风险备用金
	private String riskReserveFunds;//风险备用金
	public int getCountmember() {
		return countmember;
	}
	public void setCountmember(int countmember) {
		this.countmember = countmember;
	}
	public long getIncomeTotal() {
		return incomeTotal;
	}
	public void setIncomeTotal(long incomeTotal) {
		this.incomeTotal = incomeTotal;
		this.incomeTotals= IntegerAndString.LongToString(incomeTotal);
	}
	public String getIncomeTotals() {
		return incomeTotals;
	}
	public void setIncomeTotals(String incomeTotals) {
		this.incomeTotals = incomeTotals;
	}
	public long getTotalLoanAmount() {
		return totalLoanAmount;
	}
	public void setTotalLoanAmount(long totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
		this.totalLoanAmounts= IntegerAndString.LongToString(totalLoanAmount);
	}
	public String getTotalLoanAmounts() {
		return totalLoanAmounts;
	}
	public void setTotalLoanAmounts(String totalLoanAmounts) {
		this.totalLoanAmounts = totalLoanAmounts;
	}
	public long getRiskReserveFund() {
		return riskReserveFund;
	}
	public void setRiskReserveFund(long riskReserveFund) {
		this.riskReserveFund = riskReserveFund;
		this.riskReserveFunds= IntegerAndString.LongToString(riskReserveFund);
	}
	public String getRiskReserveFunds() {
		return riskReserveFunds;
	}
	public void setRiskReserveFunds(String riskReserveFunds) {
		this.riskReserveFunds = riskReserveFunds;
	}
}

