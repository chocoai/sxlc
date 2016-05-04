

/** 
* @Title: MyinvestEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-31 下午1:47:55 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 我的投资 
 * @since 
 * @date 2016-3-31 下午1:47:55  */

public class MyinvestEntity {
	private long    investId;// 投资ID
	private String  projectTitle;//项目名称
	private String  projectNo;//项目编号
	private String  membername;//借款会员名称
	private String  investAmounts;//投资金额
	private long    investAmount;//投资金额
	private String  remaimPrincipals;//剩余本金
	private long    remaimPrincipal;//剩余本金
	private String  remaimInterests;//剩余利息
	private long    remaimInterest;//剩余利息
	private int     remianindex;//剩余期数
	private String  nextReplayDay;//下一还款日
	private String  nextPrincipals;//下期应还本金
	private long    nextPrincipal;//下期应还本金
	private String  nextInterests;//下期应还利息
	private long    nextInterest;//下期应还利息
	private int     yearRate ;//年化利率
	private String  yearRates ;
    private String  holdDate;//放款时间
	private String  settleDate;//结清时间
	private long    totalincome;//总收益 
	private String  totalincomes;//总收益 
	private String  startDate;//投标开始时间
	private String  endDate;//投标结束时间
	private String  replayways;//还款方式
	private String  investRates;//投资进度
	private long    investRate;//投资进度 
	private int     deadline;//借款期限 单位：月/天 
	private int     deadlineType;	//期限类型  0：天标 1：月标 2：年标
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getDeadlineType() {
		return deadlineType;
	}
	public void setDeadlineType(int deadlineType) {
		this.deadlineType = deadlineType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getReplayways() {
		return replayways;
	}
	public void setReplayways(String replayways) {
		this.replayways = replayways;
	}
	public String getInvestRates() {
		return investRates;
	}
	public void setInvestRates(String investRates) {
		this.investRates = investRates;
	}
	public long getInvestRate() {
		return investRate;
	}
	public void setInvestRate(long investRate) {
		this.investRate = investRate;
		this.investRates= IntegerAndString.LongToString(investRate);
	}
	public int getYearRate() {
		return yearRate;
	}
	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
	}
	public String getYearRates() {
		return yearRates;
	}
	public void setYearRates(String yearRates) {
		this.yearRates = yearRates;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public long getTotalincome() {
		return totalincome;
	}
	public void setTotalincome(long totalincome) {
		this.totalincome = totalincome;
		this.totalincomes= IntegerAndString.LongToString(totalincome);
	}
	public String getTotalincomes() {
		return totalincomes;
	}
	public void setTotalincomes(String totalincomes) {
		this.totalincomes = totalincomes;
	}
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	
	public long getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(long investAmount) {
		this.investAmount = investAmount;
		this.investAmounts= IntegerAndString.LongToString(investAmount);
	}
	public String getInvestAmounts() {
		return investAmounts;
	}
	public void setInvestAmounts(String investAmounts) {
		this.investAmounts = investAmounts;
	}
	public String getRemaimPrincipals() {
		return remaimPrincipals;
	}
	public void setRemaimPrincipals(String remaimPrincipals) {
		this.remaimPrincipals = remaimPrincipals;
		
	}
	public long getRemaimPrincipal() {
		return remaimPrincipal;
	}
	public void setRemaimPrincipal(long remaimPrincipal) {
		this.remaimPrincipal = remaimPrincipal;
		this.remaimPrincipals= IntegerAndString.LongToString(remaimPrincipal);
	}
	public String getRemaimInterests() {
		return remaimInterests;
	}
	public void setRemaimInterests(String remaimInterests) {
		this.remaimInterests = remaimInterests;
	}
	public long getRemaimInterest() {
		return remaimInterest;
	}
	public void setRemaimInterest(long remaimInterest) {
		this.remaimInterest = remaimInterest;
		this.remaimInterests= IntegerAndString.LongToString(remaimInterest);
	}
	public int getRemianindex() {
		return remianindex;
	}
	public void setRemianindex(int remianindex) {
		this.remianindex = remianindex;
	}
	public String getNextReplayDay() {
		return nextReplayDay;
	}
	public void setNextReplayDay(String nextReplayDay) {
		this.nextReplayDay = nextReplayDay;
	}
	public String getNextPrincipals() {
		return nextPrincipals;
	}
	public void setNextPrincipals(String nextPrincipals) {
		this.nextPrincipals = nextPrincipals;
	}
	public long getNextPrincipal() {
		return nextPrincipal;
	}
	public void setNextPrincipal(long nextPrincipal) {
		this.nextPrincipal = nextPrincipal;
		this.nextPrincipals= IntegerAndString.LongToString(nextPrincipal);
	}
	public String getNextInterests() {
		return nextInterests;
	}
	public void setNextInterests(String nextInterests) {
		this.nextInterests = nextInterests;
	}
	public long getNextInterest() {
		return nextInterest;
	}
	public void setNextInterest(long nextInterest) {
		this.nextInterest = nextInterest;
		this.nextInterests= IntegerAndString.LongToString(nextInterest);
	}
	@Override
	public String toString() {
		return "MyinvestEntity [investId=" + investId + ", projectTitle="
				+ projectTitle + ", projectNo=" + projectNo + ", membername="
				+ membername + ", investAmounts=" + investAmounts
				+ ", investAmount=" + investAmount + ", remaimPrincipals="
				+ remaimPrincipals + ", remaimPrincipal=" + remaimPrincipal
				+ ", remaimInterests=" + remaimInterests + ", remaimInterest="
				+ remaimInterest + ", remianindex=" + remianindex
				+ ", nextReplayDay=" + nextReplayDay + ", nextPrincipals="
				+ nextPrincipals + ", nextPrincipal=" + nextPrincipal
				+ ", nextInterests=" + nextInterests + ", nextInterest="
				+ nextInterest + ", yearRate=" + yearRate + ", yearRates="
				+ yearRates + ", holdDate=" + holdDate + ", settleDate="
				+ settleDate + ", totalincome=" + totalincome
				+ ", totalincomes=" + totalincomes + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", replayways=" + replayways
				+ ", investRates=" + investRates + ", investRate=" + investRate
				+ "]";
	}

}

