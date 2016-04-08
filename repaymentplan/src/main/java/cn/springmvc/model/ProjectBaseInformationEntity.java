

/** 
* @Title: ProjectBaseInformationEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午10:49:06 
* @version V5.0 */
 
package cn.springmvc.model;  

import cn.springmvc.controller.RepalyUtitls;

/** 
 * @author 刘利 
 * @Description: 项目基础信息实体类
 * @since 
 * @date 2016-3-21 上午10:49:06  */

public class ProjectBaseInformationEntity {
	/**
	 * 项目基础信息id
	 */
	private long id;
	/**
	 * 项目标题
	 */
	private String projectTitle;
	/**
	 * 借款用途
	 */
	private String uses;
	/**
	 * 还款来源	
	 */
	private String repaySource;
	/**
	 * 借款金额	
	 */
	private long amount;
	/**
	 * 借款金额	字符窜
	 */
	private String amounts;
	/**
	 * 项目描述	
	 */
	private String projectDescript;
	/**
	 * 借款期限 单位：月/天	
	 */
	private int deadline;
	/**
	 * 期限类型  0：天标 1：月标 2：年标
	 */
	private int deadlineType;	
	/**
	 * 还款方式  0：等额本息，1：每月还息，到期还本 2：到期还息本 3:等额本金	
	 */
	private int repayWay;
	/**
	 * 还款方式 
	 */
	private String replayWays;
	/**
	 * 预计年化收益率(百万万分之)	
	 */
	private int  yearRate;
	/**
	 * 预计年化收益率(百万万分之)	字符窜
	 */
	private String yearRates;
	/**
	 * 会员信用积分
	 */
	private int creditIntegral;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getUses() {
		return uses;
	}
	public void setUses(String uses) {
		this.uses = uses;
	}
	public String getRepaySource() {
		return repaySource;
	}
	public void setRepaySource(String repaySource) {
		this.repaySource = repaySource;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts= RepalyUtitls.LongToString(amount);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getProjectDescript() {
		return projectDescript;
	}
	public void setProjectDescript(String projectDescript) {
		this.projectDescript = projectDescript;
	}
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
	public int getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(int repayWay) {
		this.repayWay = repayWay;
	}
	public int getYearRate() {
		return yearRate;
	}
	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
		this.yearRates= RepalyUtitls.LongToString(yearRate);
	}
	public String getYearRates() {
		return yearRates;
	}
	public void setYearRates(String yearRates) {
		this.yearRates = yearRates;
	}
	public int getCreditIntegral() {
		return creditIntegral;
	}
	public void setCreditIntegral(int creditIntegral) {
		this.creditIntegral = creditIntegral;
	}
	public String getReplayWays() {
		return replayWays;
	}
	public void setReplayWays(String replayWays) {
		this.replayWays = replayWays;
	}
}

