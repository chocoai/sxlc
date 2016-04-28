

/** 
* @Title: InvestIncomeEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-31 下午4:13:18 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 收益计划实体
 * @since 
 * @date 2016-3-31 下午4:13:18  */

public class InvestIncomeEntity {
	public long      repayId; //还款计划ID		
	public long      investId;	// 投资ID		
	public long      memberID;// 	会员ID		
	public int       sdRecvPrincipal;// 	应收本金(单位：分)		
	public int       sdRecvInterest;// 应收收益(单位：分)	
	public String    sdRecvPrincipals;// 	应收本金(单位：分)		
	public String    sdRecvInterests;// 应收收益(单位：分)	
	public String    sdRecvMaxTime;//	应收时间		
	public int    	 statu;//	还款状态 0：未还 1：部分还款 2：还清		
	public int       isValid;// 是否有效（-1:提前还款处理过程状态  0：有效，1：无效）		
	public long      thirdTradeId;// 第三方交易记录ID																					
	public int       incomeId;//	 收益计划ID		
	public int       recvPrincipal;// 实收本金(单位：分)		
	public int       recvInterest;//	 实收收益(单位：分)		
	public int       repayOverdueInterest;// 逾期利息(单位：分)		
	public int       repayOverdue;//	 实收逾期罚金(单位：分)		
	public int       repayPenalty;//	 提前还款违约金(单位：分)		
	public int       investMngFee;//	 	投资管理费(单位：分)	
	public String    recvPrincipals;// 实收本金(单位：分)		
	public String    recvInterests;//	 实收收益(单位：分)		
	public String    repayOverdueInterests;// 逾期利息(单位：分)		
	public String    repayOverdues;//	 实收逾期罚金(单位：分)		
	public String    repayPenaltys;//	 提前还款违约金(单位：分)		
	public String    investMngFees;//	 	投资管理费(单位：分)	
	public String    recvTime;// 实收时间		
	private String   replaystatu;//还款状态
	private int      indexs;//期数
	private long     totalOver;//逾期费总额
	private long     totalincome;//总收益 
	private String   totalOvers;//逾期费总额
	private String   totalincomes;//总收益 
	private long     recvAmount;//已收本息
	private String   recvAmounts;//已收本息
	private long     overdueAmount;//逾期应收收益
	private String   overdueAmounts;//逾期应收收益
	public long getRecvAmount() {
		return recvAmount;
	}
	public void setRecvAmount(long recvAmount) {
		this.recvAmount = recvAmount;
		this.recvAmounts= IntegerAndString.LongToString(recvAmount);
	}
	public String getRecvAmounts() {
		return recvAmounts;
	}
	public void setRecvAmounts(String recvAmounts) {
		this.recvAmounts = recvAmounts;
	}
	public long getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(long overdueAmount) {
		this.overdueAmount = overdueAmount;
		this.overdueAmounts= IntegerAndString.LongToString(overdueAmount);
	}
	public String getOverdueAmounts() {
		return overdueAmounts;
	}
	public void setOverdueAmounts(String overdueAmounts) {
		this.overdueAmounts = overdueAmounts;
	}
	public long getTotalOver() {
		return totalOver;
	}
	public void setTotalOver(long totalOver) {
		this.totalOver = totalOver;
		this.totalOvers= IntegerAndString.LongToString(totalOver);
	}
	public long getTotalincome() {
		return totalincome;
	}
	public void setTotalincome(long totalincome) {
		this.totalincome = totalincome;
		this.totalOvers= IntegerAndString.LongToString(totalOver);
	}
	public String getTotalOvers() {
		return totalOvers;
	}
	public void setTotalOvers(String totalOvers) {
		this.totalOvers = totalOvers;
	}
	public String getTotalincomes() {
		return totalincomes;
	}
	public void setTotalincomes(String totalincomes) {
		this.totalincomes = totalincomes;
	}
	public long getRepayId() {
		return repayId;
	}
	public void setRepayId(long repayId) {
		this.repayId = repayId;
	}
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public int getSdRecvPrincipal() {
		return sdRecvPrincipal;
	}
	public void setSdRecvPrincipal(int sdRecvPrincipal) {
		this.sdRecvPrincipal = sdRecvPrincipal;
		this.sdRecvPrincipals= IntegerAndString.LongToString(sdRecvPrincipal);
	}
	public int getSdRecvInterest() {
		return sdRecvInterest;
	}
	public void setSdRecvInterest(int sdRecvInterest) {
		this.sdRecvInterest = sdRecvInterest;
		this.sdRecvInterests= IntegerAndString.LongToString(sdRecvInterest);
	}
	public String getSdRecvPrincipals() {
		return sdRecvPrincipals;
	}
	public void setSdRecvPrincipals(String sdRecvPrincipals) {
		this.sdRecvPrincipals = sdRecvPrincipals;
	}
	public String getSdRecvInterests() {
		return sdRecvInterests;
	}
	public void setSdRecvInterests(String sdRecvInterests) {
		this.sdRecvInterests = sdRecvInterests;
	}
	public String getSdRecvMaxTime() {
		return sdRecvMaxTime;
	}
	public void setSdRecvMaxTime(String sdRecvMaxTime) {
		this.sdRecvMaxTime = sdRecvMaxTime;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public long getThirdTradeId() {
		return thirdTradeId;
	}
	public void setThirdTradeId(long thirdTradeId) {
		this.thirdTradeId = thirdTradeId;
	}
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public int getRecvPrincipal() {
		return recvPrincipal;
	}
	public void setRecvPrincipal(int recvPrincipal) {
		this.recvPrincipal = recvPrincipal;
		this.recvPrincipals= IntegerAndString.LongToString(recvPrincipal);
	}
	public int getRecvInterest() {
		return recvInterest;
	}
	public void setRecvInterest(int recvInterest) {
		this.recvInterest = recvInterest;
		this.recvInterests= IntegerAndString.LongToString(recvInterest);
	}
	public int getRepayOverdueInterest() {
		return repayOverdueInterest;
	}
	public void setRepayOverdueInterest(int repayOverdueInterest) {
		this.repayOverdueInterest = repayOverdueInterest;
		this.repayOverdueInterests= IntegerAndString.LongToString(repayOverdueInterest);
	}
	public int getRepayOverdue() {
		return repayOverdue;
	}
	public void setRepayOverdue(int repayOverdue) {
		this.repayOverdue = repayOverdue;
		this.repayOverdues= IntegerAndString.LongToString(repayOverdue);
	}
	public int getRepayPenalty() {
		return repayPenalty;
	}
	public void setRepayPenalty(int repayPenalty) {
		this.repayPenalty = repayPenalty;
		this.repayPenaltys= IntegerAndString.LongToString(repayPenalty);
	}
	public int getInvestMngFee() {
		return investMngFee;
	}
	public void setInvestMngFee(int investMngFee) {
		this.investMngFee = investMngFee;
		this.investMngFees= IntegerAndString.LongToString(investMngFee);
	}
	public String getRecvPrincipals() {
		return recvPrincipals;
	}
	public void setRecvPrincipals(String recvPrincipals) {
		this.recvPrincipals = recvPrincipals;
	}
	public String getRecvInterests() {
		return recvInterests;
	}
	public void setRecvInterests(String recvInterests) {
		this.recvInterests = recvInterests;
	}
	public String getRepayOverdueInterests() {
		return repayOverdueInterests;
	}
	public void setRepayOverdueInterests(String repayOverdueInterests) {
		this.repayOverdueInterests = repayOverdueInterests;
	}
	public String getRepayOverdues() {
		return repayOverdues;
	}
	public void setRepayOverdues(String repayOverdues) {
		this.repayOverdues = repayOverdues;
	}
	public String getRepayPenaltys() {
		return repayPenaltys;
	}
	public void setRepayPenaltys(String repayPenaltys) {
		this.repayPenaltys = repayPenaltys;
	}
	public String getInvestMngFees() {
		return investMngFees;
	}
	public void setInvestMngFees(String investMngFees) {
		this.investMngFees = investMngFees;
	}
	public String getRecvTime() {
		return recvTime;
	}
	public void setRecvTime(String recvTime) {
		this.recvTime = recvTime;
	}
	public String getReplaystatu() {
		return replaystatu;
	}
	public void setReplaystatu(String replaystatu) {
		this.replaystatu = replaystatu;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}

}

