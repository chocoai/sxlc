

/** 
* @Title: LoanRepayEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午5:18:28 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 还款计划实体 
 * @since 
 * @date 2016-3-21 下午5:18:28  */

public class LoanRepayEntity {
	private long repayID	;	
	/**
	 * 项目ID
	 */
	private long projectId;
	/**
	 * 期数
	 */
	private int indexs; 
	/**
	 * 应还本金(单位：分)
	 */
	private long sDRepayPrincipal;	
	/**
	 * 应还本金(单位：分)
	 */
	private String sDRepayPrincipals;	
	/**
	 * 应还利息(单位：分)	
	 */
	private long sDRepayInterest; 	
	/**
	 * 应还利息(单位：分)	
	 */
	private String sDRepayInterests; 	
	/**
	 * 最迟还款时间
	 */
	private String repayMaxTime; 	
	/**
	 * 还款状态 0：未还 1：还款中 2：部分还完 3：已还		
	 */
	private int statu;	 
	/**
	 * 是否代偿(0：未代偿；1：代偿)	
	 */
	private int isCompensatory;	
	/**
	 * 代偿时间	
	 */
	private String compensatoryTime;
	/**
	 * 是否有效（0：有效，1：无效）
	 */
	private int isValid; 
	/**
	 * 已还金额
	 */
	private long replayTotal;
	/**
	 * 已还金额
	 */
	private String replayTotals;
	private String corpus;		//应付本金（元）
	private String interest;		//应付利息（元）
	private String endCorpusInterest;		//待付息本（元）
	private String retrieveDateTime;		//预计还款日期（string类型）
	private Double allSy;  //总收益
	private long totalSDRepay;//共需还本息
	private String totalSDRepays;
	public String getCorpus() {
		return corpus;
	}
	public void setCorpus(String corpus) {
		this.corpus = corpus;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getEndCorpusInterest() {
		return endCorpusInterest;
	}
	public void setEndCorpusInterest(String endCorpusInterest) {
		this.endCorpusInterest = endCorpusInterest;
	}
	public long getReplayTotal() {
		return replayTotal;
	}
	public void setReplayTotal(long replayTotal) {
		this.replayTotal = replayTotal;
		this.replayTotals= IntegerAndString.LongToString(replayTotal);
	}
	public String getReplayTotals() {
		return replayTotals;
	}
	public void setReplayTotals(String replayTotals) {
		this.replayTotals = replayTotals;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public long getsDRepayPrincipal() {
		return sDRepayPrincipal;
	}
	public void setsDRepayPrincipal(long sDRepayPrincipal) {
		this.sDRepayPrincipal = sDRepayPrincipal;
		this.sDRepayPrincipals= IntegerAndString.LongToString(sDRepayPrincipal);
	}
	public String getsDRepayPrincipals() {
		return sDRepayPrincipals;
	}
	public void setsDRepayPrincipals(String sDRepayPrincipals) {
		this.sDRepayPrincipals = sDRepayPrincipals;
	}
	public long getsDRepayInterest() {
		return sDRepayInterest;
	}
	public void setsDRepayInterest(long sDRepayInterest) {
		this.sDRepayInterest = sDRepayInterest;
		this.sDRepayInterests= IntegerAndString.LongToString(sDRepayInterest);
	}
	public String getsDRepayInterests() {
		return sDRepayInterests;
	}
	public void setsDRepayInterests(String sDRepayInterests) {
		this.sDRepayInterests = sDRepayInterests;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getIsCompensatory() {
		return isCompensatory;
	}
	public void setIsCompensatory(int isCompensatory) {
		this.isCompensatory = isCompensatory;
	}
	public String getCompensatoryTime() {
		return compensatoryTime;
	}
	public void setCompensatoryTime(String compensatoryTime) {
		this.compensatoryTime = compensatoryTime;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public long getRepayID() {
		return repayID;
	}
	public void setRepayID(long repayID) {
		this.repayID = repayID;
	}
	public String getRetrieveDateTime() {
		return retrieveDateTime;
	}
	public void setRetrieveDateTime(String retrieveDateTime) {
		this.retrieveDateTime = retrieveDateTime;
	}
	public Double getAllSy() {
		return allSy;
	}
	public void setAllSy(Double allSy) {
		this.allSy = allSy;
	}
	public long getTotalSDRepay() {
		return totalSDRepay;
	}
	public void setTotalSDRepay(long totalSDRepay) {
		this.totalSDRepay = totalSDRepay;
	}
	public String getTotalSDRepays() {
		return totalSDRepays;
	}
	public void setTotalSDRepays(String totalSDRepays) {
		this.totalSDRepays = totalSDRepays;
	}			
	@Override
	public String toString() {
		return "LoanRepayEntity [repayID=" + repayID + ", projectId="
				+ projectId + ", indexs=" + indexs + ", sDRepayPrincipal="
				+ sDRepayPrincipal + ", sDRepayPrincipals=" + sDRepayPrincipals
				+ ", sDRepayInterest=" + sDRepayInterest
				+ ", sDRepayInterests=" + sDRepayInterests + ", repayMaxTime="
				+ repayMaxTime + ", statu=" + statu + ", isCompensatory="
				+ isCompensatory + ", compensatoryTime=" + compensatoryTime
				+ ", isValid=" + isValid + ", replayTotal=" + replayTotal
				+ ", replayTotals=" + replayTotals + ", corpus=" + corpus
				+ ", interest=" + interest + ", endCorpusInterest="
				+ endCorpusInterest + ", retrieveDateTime=" + retrieveDateTime
				+ ", allSy=" + allSy + "]";
	}
	

}

