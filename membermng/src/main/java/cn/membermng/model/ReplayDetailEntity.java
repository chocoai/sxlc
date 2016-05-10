

/** 
* @Title: ReplayDetailEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-4 下午1:26:34 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 还款详情
 * @since 
 * @date 2016-5-4 下午1:26:34  */

public class ReplayDetailEntity {
	private long			lid;						//还款计划编号
	private int				indexs;						//还款序号
	private long			loanAmount;					//应还本金
	private String			sLoanAmount;				//应还本经
	private long			loanInterest;				//应还利息
	private String			sLoanInterest;				//应还利息
	private long			overdueInterest;			//逾期利息
	private String			sOverdueInterest;	        //逾期利息
	private long			oberdueFine;				//逾期罚金
	private String			sOberdueFine;		        //逾期罚金  
	private long            sdReplayTotal;               //应还总额
	private String          sdReplayTotals;              //应还总额
	
	 
	private long			paidAmount;					//实还本金
	private String			sPaidAmount;				//实还本金
	private long			paidInterest;				//实还利息
	private String			sPaidInterest;				//实还利息 
	private long			paidOverdueInterest;		//实还逾期利息
	private String			paidSOverdueInterest;	    //实还逾期利息
	private long			paidOberdueFine;			//实还逾期罚金
	private String			paidSOberdueFine;		    //实还逾期罚金
	private long            paisdReplayTotal;            //实还总额
	private String          paisdReplayTotals;           //实还总额
	private long            userBalance;                 //实还总额
	private String          userBalances;                //实还总额
	private int             overDay ;                    //逾期天数
	 

	public long getLid() {
		return lid;
	}


	public void setLid(long lid) {
		this.lid = lid;
	}


	public int getIndexs() {
		return indexs;
	}


	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}


	public long getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
		this.sLoanAmount = IntegerAndString.LongToString(loanAmount);
	}


	public String getsLoanAmount() {
		return sLoanAmount;
	}


	public void setsLoanAmount(String sLoanAmount) {
		this.sLoanAmount = sLoanAmount;
	}


	public long getLoanInterest() {
		return loanInterest;
	}


	public void setLoanInterest(long loanInterest) {
		this.loanInterest = loanInterest;
		this.sLoanInterest = IntegerAndString.LongToString(loanInterest);
	}


	public String getsLoanInterest() {
		return sLoanInterest;
	}


	public void setsLoanInterest(String sLoanInterest) {
		this.sLoanInterest = sLoanInterest;
	} 

	public long getOverdueInterest() {
		return overdueInterest;
	}


	public void setOverdueInterest(long overdueInterest) {
		this.overdueInterest = overdueInterest;
		this.sOverdueInterest	= IntegerAndString.LongToString(overdueInterest);
	}


	public String getsOverdueInterest() {
		return sOverdueInterest;
	}


	public void setsOverdueInterest(String sOverdueInterest) {
		this.sOverdueInterest = sOverdueInterest;
	}


	public long getOberdueFine() {
		return oberdueFine;
	}


	public void setOberdueFine(long oberdueFine) {
		this.oberdueFine = oberdueFine;
		this.sOberdueFine = IntegerAndString.LongToString(oberdueFine);
	}


	public String getsOberdueFine() {
		return sOberdueFine;
	}


	public void setsOberdueFine(String sOberdueFine) {
		this.sOberdueFine = sOberdueFine;
	} 

	public long getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
		this.sPaidAmount = IntegerAndString.LongToString(paidAmount);
	}


	public String getsPaidAmount() {
		return sPaidAmount;
	}


	public void setsPaidAmount(String sPaidAmount) {
		this.sPaidAmount = sPaidAmount;
	}


	public long getPaidInterest() {
		return paidInterest;
	}


	public void setPaidInterest(long paidInterest) {
		this.paidInterest = paidInterest;
		this.sPaidInterest = IntegerAndString.LongToString(paidInterest);
	}


	public String getsPaidInterest() {
		return sPaidInterest;
	}


	public void setsPaidInterest(String sPaidInterest) {
		this.sPaidInterest = sPaidInterest;
	}


	public long getPaidOverdueInterest() {
		return paidOverdueInterest;
	}


	public void setPaidOverdueInterest(long paidOverdueInterest) {
		this.paidOverdueInterest = paidOverdueInterest;
		this.paidSOverdueInterest = IntegerAndString.LongToString(paidOverdueInterest);
	}


	public String getPaidSOverdueInterest() {
		return paidSOverdueInterest;
	}


	public void setPaidSOverdueInterest(String paidSOverdueInterest) {
		this.paidSOverdueInterest = paidSOverdueInterest;
	}


	public long getPaidOberdueFine() {
		return paidOberdueFine;
	}


	public void setPaidOberdueFine(long paidOberdueFine) {
		this.paidOberdueFine = paidOberdueFine;
		this.paidSOberdueFine = IntegerAndString.LongToString(paidOberdueFine);
	}


	public String getPaidSOberdueFine() {
		return paidSOberdueFine;
	}


	public void setPaidSOberdueFine(String paidSOberdueFine) {
		this.paidSOberdueFine = paidSOberdueFine;
	}



	public long getSdReplayTotal() {
		return sdReplayTotal;
	}



	public void setSdReplayTotal(long sdReplayTotal) {
		this.sdReplayTotal = sdReplayTotal;
		this.sdReplayTotals = IntegerAndString.LongToString(sdReplayTotal);
	}
	
	public String getSdReplayTotals() {
		return sdReplayTotals;
	}
 
	public void setSdReplayTotals(String sdReplayTotals) {
		this.sdReplayTotals = sdReplayTotals;
	}



	public int getOverDay() {
		return overDay;
	}



	public void setOverDay(int overDay) {
		this.overDay = overDay;
	}


	public long getPaisdReplayTotal() {
		return paisdReplayTotal;
	}


	public void setPaisdReplayTotal(long paisdReplayTotal) {
		this.paisdReplayTotal = paisdReplayTotal;
		this.paisdReplayTotals = IntegerAndString.LongToString(paisdReplayTotal);
	}


	public String getPaisdReplayTotals() {
		return paisdReplayTotals;
	}


	public void setPaisdReplayTotals(String paisdReplayTotals) {
		this.paisdReplayTotals = paisdReplayTotals;
	}


	public long getUserBalance() {
		return userBalance;
	}


	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
		this.userBalances = IntegerAndString.LongToString(userBalance);
	}


	public String getUserBalances() {
		return userBalances;
	}


	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	
}

