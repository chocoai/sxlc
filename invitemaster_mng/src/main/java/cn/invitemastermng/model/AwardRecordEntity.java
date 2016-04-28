

/** 
* @Title: FinancialAdvisorAwardRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午12:54:11 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;
 

/** 
 * @author 刘利 
 * @Description: 理财顾问-推荐达人-提奖记录实体
 * @since 
 * @date 2016-4-5 下午12:54:11  */

public class AwardRecordEntity {
	
	
	private String personalName;//姓名
	private String logname;//用户名
	private String personalPhone;//联系电话
	private String personalIDCard;//身份证号
	private long   awardAmountBorrowing;//推荐借款提奖
	private String awardAmountBorrowings;//推荐借款提奖
	private long   awardAmountInvest;//推荐投资提奖
	private String awardAmountInvests;//推荐投资提奖
	private long   awardAmountVIP;//推荐购买VIP提奖
	private String awardAmountVIPs;//推荐购买VIP提奖
	private long   awardAmountRepay;//推荐还本提奖
	private String awardAmountRepays;//推荐还本提奖
	private long   awardAmount;//推荐提奖总额
	private String awardAmounts;//提奖金额	
	private int    Statu;//佣金发放状态:1发放 0未发
	
	private long   faid;//理财顾问ID																					
	private int    awardType	;//提奖类型 0：借款提奖 1：投资提奖 2：还本提奖 3：VIP购买提奖																					
	private long   projectId	;//	提奖事件ID																					
	private long   memberID;//会员ID																					
	private long   projectAmount;//事件金额		
	private String projectAmounts;//事件金额	 
	
	private String awardDate;///提奖时间																					
	private int    payStatu;///发放状态 0：未发放 1：发放中 2：发放成功																					
	private String payDate;//	 发放时间			
	 
	
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalIDCard() {
		return personalIDCard;
	}
	public void setPersonalIDCard(String personalIDCard) {
		this.personalIDCard = personalIDCard;
	}
	public long getAwardAmountBorrowing() {
		return awardAmountBorrowing;
	}
	public void setAwardAmountBorrowing(long awardAmountBorrowing) {
		this.awardAmountBorrowing = awardAmountBorrowing;
		this.awardAmountBorrowings= IntegerAndString.LongToString(awardAmountBorrowing);
	}
	public String getAwardAmountBorrowings() {
		return awardAmountBorrowings;
	}
	public void setAwardAmountBorrowings(String awardAmountBorrowings) {
		this.awardAmountBorrowings = awardAmountBorrowings;
	}
	public long getAwardAmountInvest() {
		return awardAmountInvest;
	}
	public void setAwardAmountInvest(long awardAmountInvest) {
		this.awardAmountInvest = awardAmountInvest;
		this.awardAmountInvests= IntegerAndString.LongToString(awardAmountInvest);
	}
	public String getAwardAmountInvests() {
		return awardAmountInvests;
	}
	public void setAwardAmountInvests(String awardAmountInvests) {
		this.awardAmountInvests = awardAmountInvests;
	}
	public long getAwardAmountVIP() {
		return awardAmountVIP;
	}
	public void setAwardAmountVIP(long awardAmountVIP) {
		this.awardAmountVIP = awardAmountVIP;
		this.awardAmountVIPs= IntegerAndString.LongToString(awardAmountVIP);
	}
	public String getAwardAmountVIPs() {
		return awardAmountVIPs;
	}
	public void setAwardAmountVIPs(String awardAmountVIPs) {
		this.awardAmountVIPs = awardAmountVIPs;
	}
	public long getAwardAmountRepay() {
		return awardAmountRepay;
	}
	public void setAwardAmountRepay(long awardAmountRepay) {
		this.awardAmountRepay = awardAmountRepay;
		this.awardAmountRepays= IntegerAndString.LongToString(awardAmountRepay);
	}
	public String getAwardAmountRepays() {
		return awardAmountRepays;
	}
	public void setAwardAmountRepays(String awardAmountRepays) {
		this.awardAmountRepays = awardAmountRepays;
	}
	public int getStatu() {
		return Statu;
	}
	public void setStatu(int statu) {
		Statu = statu;
	}
																			
	public long getFaid() {
		return faid;
	}
	public void setFaid(long faid) {
		this.faid = faid;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getProjectAmount() {
		return projectAmount;
	}
	public void setProjectAmount(long projectAmount) {
		this.projectAmount = projectAmount;
		this.projectAmounts= IntegerAndString.LongToString(projectAmount);
	}
	public String getProjectAmounts() {
		return projectAmounts;
	}
	public void setProjectAmounts(String projectAmounts) {
		this.projectAmounts = projectAmounts;
	}
	public long getAwardAmount() {
		return awardAmount;
	}
	public void setAwardAmount(long awardAmount) {
		this.awardAmount = awardAmount;
		this.awardAmounts= IntegerAndString.LongToString(awardAmount);
	}
	public String getAwardAmounts() {
		return awardAmounts;
	}
	public void setAwardAmounts(String awardAmounts) {
		this.awardAmounts = awardAmounts;
	}
	public String getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(String awardDate) {
		this.awardDate = awardDate;
	}
	public int getPayStatu() {
		return payStatu;
	}
	public void setPayStatu(int payStatu) {
		this.payStatu = payStatu;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

}

