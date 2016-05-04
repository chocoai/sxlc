

/** 
* @Title: OperationItemStatisticsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 上午11:39:36 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 运营项目统计
 * @since 
 * @date 2016-4-27 上午11:39:36  */

public class OperationItemStatisticsEntity {
	private int notDeal;//未处理意向借款申请
	private int investing;//融资中借款 
	private int replaying;//还款中借款项目
	private int overReplay;//逾期未还借款 
	private int Settled; //已结清借款
	private int successLoan;//累计成功借款项目数
	private int successRepay; //累计成功还款
	private int cumulative; //累计成交总额
	private long notRepayPrincipal;//待还本金
	private long notRepayTotal; //待还本金+利息
	private String notRepayPrincipals;//待还本金
	private String notRepayTotals; //待还本金+利息
	public int getSuccessLoan() {
		return successLoan;
	}
	public void setSuccessLoan(int successLoan) {
		this.successLoan = successLoan;
	}
	public int getSuccessRepay() {
		return successRepay;
	}
	public void setSuccessRepay(int successRepay) {
		this.successRepay = successRepay;
	}
	public int getCumulative() {
		return cumulative;
	}
	public void setCumulative(int cumulative) {
		this.cumulative = cumulative;
	}
	public int getNotDeal() {
		return notDeal;
	}
	public void setNotDeal(int notDeal) {
		this.notDeal = notDeal;
	}
	public int getInvesting() {
		return investing;
	}
	public void setInvesting(int investing) {
		this.investing = investing;
	}
	public int getReplaying() {
		return replaying;
	}
	public void setReplaying(int replaying) {
		this.replaying = replaying;
	}
	public int getOverReplay() {
		return overReplay;
	}
	public void setOverReplay(int overReplay) {
		this.overReplay = overReplay;
	}
	public int getSettled() {
		return Settled;
	}
	public void setSettled(int settled) {
		Settled = settled;
	}
	public long getNotRepayTotal() {
		return notRepayTotal;
	}
	public void setNotRepayTotal(long notRepayTotal) {
		this.notRepayTotal = notRepayTotal;
		this.setNotRepayTotals(IntegerAndString.LongToString(notRepayTotal));
	}
	public long getNotRepayPrincipal() {
		return notRepayPrincipal;
	}
	public void setNotRepayPrincipal(long notRepayPrincipal) {
		this.notRepayPrincipal = notRepayPrincipal;
		this.setNotRepayPrincipals(IntegerAndString.LongToString(notRepayPrincipal));
	}
	public String getNotRepayPrincipals() {
		return notRepayPrincipals;
	}
	public void setNotRepayPrincipals(String notRepayPrincipals) {
		this.notRepayPrincipals = notRepayPrincipals;
	}
	public String getNotRepayTotals() {
		return notRepayTotals;
	}
	public void setNotRepayTotals(String notRepayTotals) {
		this.notRepayTotals = notRepayTotals;
	}
}

