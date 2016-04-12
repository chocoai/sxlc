

/** 
* @Title: IncomeReplayPlanEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-7 下午2:43:07 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 我的账户首页-回款计划-还款计划
 * @since 
 * @date 2016-4-7 下午2:43:07  */

public class IncomeReplayPlanEntity {
	private long memberID;//会员ID
	private int month;//统计月份
	private long sdRecvAmount;//应回款金额 
	private int day;//回款日期(几号)/还款日期(几号)
	private long sdRecvPrincipal;//应回本金
	private long sdRecvInterest;//应回利息 
	private long sdRepayAmount;//应还款金额  
	private long sdRepayPrincipal;//应还本金
	private long sdRepayInterest;//应还利息  
	private String recordDate;//记录时间
	private String abstracts;//描述
	
	private String sdRecvAmounts;//应回款金额
	private String sdRecvPrincipals;//应回本金
	private String sdRecvInterests;//应回利息
	private String sdRepayAmounts;//应还款金额  
	private String sdRepayPrincipals;//应还本金
	private String sdRepayInterests;//应还利息  
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public long getSdRecvAmount() {
		return sdRecvAmount;
	}
	public void setSdRecvAmount(long sdRecvAmount) {
		this.sdRecvAmount = sdRecvAmount;
		this.sdRecvAmounts= IntegerAndString.LongToString(sdRecvAmount);
	}
 
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public long getSdRecvPrincipal() {
		return sdRecvPrincipal;
	}
	public void setSdRecvPrincipal(long sdRecvPrincipal) {
		this.sdRecvPrincipal = sdRecvPrincipal;
		this.sdRecvPrincipals= IntegerAndString.LongToString(sdRecvPrincipal);
	}
	public long getSdRecvInterest() {
		return sdRecvInterest;
	}
	public void setSdRecvInterest(long sdRecvInterest) {
		this.sdRecvInterest = sdRecvInterest;
		this.sdRecvInterests= IntegerAndString.LongToString(sdRecvInterest);
	}
 
	public long getSdRepayAmount() {
		return sdRepayAmount;
	}
	public void setSdRepayAmount(long sdRepayAmount) {
		this.sdRepayAmount = sdRepayAmount;
		this.sdRepayAmounts= IntegerAndString.LongToString(sdRepayAmount);
	}
	public long getSdRepayPrincipal() {
		return sdRepayPrincipal;
	}
	public void setSdRepayPrincipal(long sdRepayPrincipal) {
		this.sdRepayPrincipal = sdRepayPrincipal;
		this.sdRepayPrincipals= IntegerAndString.LongToString(sdRepayPrincipal);
	}
	public long getSdRepayInterest() {
		return sdRepayInterest;
	}
	public void setSdRepayInterest(long sdRepayInterest) {
		this.sdRepayInterest = sdRepayInterest;
		this.sdRepayInterests= IntegerAndString.LongToString(sdRepayInterest);
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getSdRecvAmounts() {
		return sdRecvAmounts;
	}
	public void setSdRecvAmounts(String sdRecvAmounts) {
		this.sdRecvAmounts = sdRecvAmounts;
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
	public String getSdRepayAmounts() {
		return sdRepayAmounts;
	}
	public void setSdRepayAmounts(String sdRepayAmounts) {
		this.sdRepayAmounts = sdRepayAmounts;
	}
	public String getSdRepayPrincipals() {
		return sdRepayPrincipals;
	}
	public void setSdRepayPrincipals(String sdRepayPrincipals) {
		this.sdRepayPrincipals = sdRepayPrincipals;
	}
	public String getSdRepayInterests() {
		return sdRepayInterests;
	}
	public void setSdRepayInterests(String sdRepayInterests) {
		this.sdRepayInterests = sdRepayInterests;
	}
}

