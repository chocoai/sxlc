

/** 
* @Title: SuccessRepayDetail.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-12 下午4:00:39 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 成交项目管理还款详情
 * @since 
 * @date 2016-5-12 下午4:00:39  */

public class SuccessRepayDetail {
	private long			lid;						//还款计划编号
	private int				indexs;						//还款序号
	private Long			loanAmount;					//应还本金
	private String			sLoanAmount;				//应还本经
	private Long			loanInterest;				//应还利息
	private String			sLoanInterest;				//应还利息
	private String			loanTime;					//预期还款时间 
	private Long			overdueInterest;			//应还罚息
	private String			sOverdueInterest;	        //应还罚息
	private Long            sdReplayTotal;               //应还总额
	private String          sdReplayTotals;              //应还总额 
	private Long			paidAmount;					//已还本金
	private String			sPaidAmount;				//已还本金
	private Long			paidInterest;				//已还利息
	private String			sPaidInterest;				//已还利息 
	private Long			paidOverdueInterest;		//已还罚息
	private String			paidSOverdueInterest;	    //已还罚息
	
	private Long			notpaidAmount;					//未还本金
	private String			notsPaidAmount;				//未还本金
	private Long			notpaidInterest;				//未还利息
	private String			notsPaidInterest;				//未还利息 
	private Long			notpaidOverdueInterest;		//未还罚息
	private String			notpaidSOverdueInterest;	    //未还罚息
	private int             overDay ;                    //逾期天数
	private String         repayTime;//实际还款日期 
	
	public Long getNotpaidAmount() {
		return notpaidAmount;
	}


	public void setNotpaidAmount(Long notpaidAmount) {
		this.notpaidAmount = notpaidAmount;
		this.notsPaidAmount = IntegerAndString.LongToString(notpaidAmount);
	}


	public String getNotsPaidAmount() {
		return notsPaidAmount;
	}


	public void setNotsPaidAmount(String notsPaidAmount) {
		this.notsPaidAmount = notsPaidAmount;
	}


	public Long getNotpaidInterest() {
		return notpaidInterest;
	}


	public void setNotpaidInterest(Long notpaidInterest) {
		this.notpaidInterest = notpaidInterest;
		this.notsPaidInterest = IntegerAndString.LongToString(notpaidInterest);
	}


	public String getNotsPaidInterest() {
		return notsPaidInterest;
	}


	public void setNotsPaidInterest(String notsPaidInterest) {
		this.notsPaidInterest = notsPaidInterest;
	}


	public Long getNotpaidOverdueInterest() {
		return notpaidOverdueInterest;
	}


	public void setNotpaidOverdueInterest(Long notpaidOverdueInterest) {
		this.notpaidOverdueInterest = notpaidOverdueInterest;
		this.notpaidSOverdueInterest = IntegerAndString.LongToString(notpaidOverdueInterest);
	}


	public String getNotpaidSOverdueInterest() {
		return notpaidSOverdueInterest;
	}


	public void setNotpaidSOverdueInterest(String notpaidSOverdueInterest) {
		this.notpaidSOverdueInterest = notpaidSOverdueInterest;
	}

	 
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


	public Long getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
		this.sLoanAmount = IntegerAndString.LongToString(loanAmount);
	}


	public String getsLoanAmount() {
		return sLoanAmount;
	}


	public void setsLoanAmount(String sLoanAmount) {
		this.sLoanAmount = sLoanAmount;
	}


	public Long getLoanInterest() {
		return loanInterest;
	}


	public void setLoanInterest(Long loanInterest) {
		this.loanInterest = loanInterest;
		this.sLoanInterest = IntegerAndString.LongToString(loanInterest);
	}


	public String getsLoanInterest() {
		return sLoanInterest;
	}


	public void setsLoanInterest(String sLoanInterest) {
		this.sLoanInterest = sLoanInterest;
	}


	public String getLoanTime() {
		return loanTime;
	}


	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}


	 

	public Long getOverdueInterest() {
		return overdueInterest;
	}


	public void setOverdueInterest(Long overdueInterest) {
		this.overdueInterest = overdueInterest;
		this.sOverdueInterest	= IntegerAndString.LongToString(overdueInterest);
	}


	public String getsOverdueInterest() {
		return sOverdueInterest;
	}


	public void setsOverdueInterest(String sOverdueInterest) {
		this.sOverdueInterest = sOverdueInterest;
	}


  
	public Long getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
		this.sPaidAmount = IntegerAndString.LongToString(paidAmount);
	}


	public String getsPaidAmount() {
		return sPaidAmount;
	}


	public void setsPaidAmount(String sPaidAmount) {
		this.sPaidAmount = sPaidAmount;
	}


	public Long getPaidInterest() {
		return paidInterest;
	}


	public void setPaidInterest(Long paidInterest) {
		this.paidInterest = paidInterest;
		this.sPaidInterest = IntegerAndString.LongToString(paidInterest);
	}


	public String getsPaidInterest() {
		return sPaidInterest;
	}


	public void setsPaidInterest(String sPaidInterest) {
		this.sPaidInterest = sPaidInterest;
	}


	public Long getPaidOverdueInterest() {
		return paidOverdueInterest;
	}


	public void setPaidOverdueInterest(Long paidOverdueInterest) {
		this.paidOverdueInterest = paidOverdueInterest;
		this.paidSOverdueInterest = IntegerAndString.LongToString(paidOverdueInterest);
	}


	public String getPaidSOverdueInterest() {
		return paidSOverdueInterest;
	}


	public void setPaidSOverdueInterest(String paidSOverdueInterest) {
		this.paidSOverdueInterest = paidSOverdueInterest;
	}

 
	public Long getSdReplayTotal() {
		return sdReplayTotal;
	}



	public void setSdReplayTotal(Long sdReplayTotal) {
		this.sdReplayTotal = sdReplayTotal;
		this.sdReplayTotals = IntegerAndString.LongToString(sdReplayTotal);
	}
	
	public String getSdReplayTotals() {
		return sdReplayTotals;
	}
 
	public void setSdReplayTotals(String sdReplayTotals) {
		this.sdReplayTotals = sdReplayTotals;
	}


 

	public String getRepayTime() {
		return repayTime;
	}



	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}


	public int getOverDay() {
		return overDay;
	}


	public void setOverDay(int overDay) {
		this.overDay = overDay;
	}
}

