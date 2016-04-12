

/** 
* @Title: InvestmentstatisticsEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-9 下午4:28:01 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 投资统计信息实体
 * @since 
 * @date 2016-4-9 下午4:28:01  */

public class InvestmentstatisticsEntity {
	 private int successInvest;// 成功投资笔数、
     private long successInvestAmount;// 成功投资金额、
     private long successRecvPrincipalTotal;// 累计已收本金、
     private long incomeTotal;// 累计已收收益、
     private long notSDRecvPrincipal;// 待收本金、
     private long notSDRecvInterest;// 待收收益
     private String successInvestAmounts;// 成功投资金额、
     private String successRecvPrincipalTotals;// 累计已收本金、
     private String incomeTotals;// 累计已收收益、
     private String notSDRecvPrincipals;// 待收本金、
     private String notSDRecvInterests;// 待收收益
	public long getIncomeTotal() {
		return incomeTotal;
	}
	public void setIncomeTotal(long incomeTotal) {
		this.incomeTotal = incomeTotal;
		this.incomeTotals=IntegerAndString.LongToString(incomeTotal);
	}
	public long getNotSDRecvPrincipal() {
		return notSDRecvPrincipal;
	}
	public void setNotSDRecvPrincipal(long notSDRecvPrincipal) {
		this.notSDRecvPrincipal = notSDRecvPrincipal;
		this.notSDRecvPrincipals=IntegerAndString.LongToString(notSDRecvPrincipal);
	}
	public long getNotSDRecvInterest() {
		return notSDRecvInterest;
	}
	public void setNotSDRecvInterest(long notSDRecvInterest) {
		this.notSDRecvInterest = notSDRecvInterest;
		this.notSDRecvInterests=IntegerAndString.LongToString(notSDRecvInterest);
	}
	public String getNotSDRecvPrincipals() {
		return notSDRecvPrincipals;
	}
	public void setNotSDRecvPrincipals(String notSDRecvPrincipals) {
		this.notSDRecvPrincipals = notSDRecvPrincipals;
	}
	public String getNotSDRecvInterests() {
		return notSDRecvInterests;
	}
	public void setNotSDRecvInterests(String notSDRecvInterests) {
		this.notSDRecvInterests = notSDRecvInterests;
	}
	public int getSuccessInvest() {
		return successInvest;
	}
	public void setSuccessInvest(int successInvest) {
		this.successInvest = successInvest;
	}
	public long getSuccessInvestAmount() {
		return successInvestAmount;
	}
	public void setSuccessInvestAmount(long successInvestAmount) {
		this.successInvestAmount = successInvestAmount;
		this.successInvestAmounts	= IntegerAndString.LongToString(successInvestAmount);
	}
	public long getSuccessRecvPrincipalTotal() {
		return successRecvPrincipalTotal;
	}
	public void setSuccessRecvPrincipalTotal(long successRecvPrincipalTotal) {
		this.successRecvPrincipalTotal = successRecvPrincipalTotal;
		this.successRecvPrincipalTotals	= IntegerAndString.LongToString(successRecvPrincipalTotal);
	}
	 
	public String getSuccessInvestAmounts() {
		return successInvestAmounts;
	}
	public void setSuccessInvestAmounts(String successInvestAmounts) {
		this.successInvestAmounts = successInvestAmounts;
	}
	public String getSuccessRecvPrincipalTotals() {
		return successRecvPrincipalTotals;
	}
	public void setSuccessRecvPrincipalTotals(String successRecvPrincipalTotals) {
		this.successRecvPrincipalTotals = successRecvPrincipalTotals;
	}
	public String getIncomeTotals() {
		return incomeTotals;
	}
	public void setIncomeTotals(String incomeTotals) {
		this.incomeTotals = incomeTotals;
	}
 
	 
}

