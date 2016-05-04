

/** 
* @Title: InvestEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午6:37:22 
* @version V5.0 */
 
package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * @author 刘利 
 * @Description: 投资记录实体类
 * @since 
 * @date 2016-3-21 下午6:37:22  */

public class InvestEntity {
	
	private long id	 ; 
	/**
	 * 项目ID
	 */
	private long projectId;	
	/**
	 * 投资会员ID
	 */
	private long memberID;	 
	/**
	 * 投资总金额
	 */
	private int investAmount;
	/**
	 * 投资总金额
	 */
	private String investAmounts;
	/**
	 * 包含红包金额
	 */
	private int investGiftAmount;
	/**
	 * 包含红包金额
	 */
	private String investGiftAmounts;	 
	/**
	 * 包含代金券金额	
	 */
	private int investVouchersAmount;
	/**
	 * 包含代金券金额	
	 */
	private String investVouchersAmounts; 
	/**
	 * 返现金额	
	 */
	private int backAmount;	
	/**
	 * 返现金额	
	 */
	private String backAmounts;	
	/**
	 * 惊喜红包金额
	 */
	private int redPackageAmount; 
	/**
	 * 惊喜红包金额
	 */
	private String redPackageAmounts; 
	/**
	 * 投资时间
	 */
	private String sInvestDate;
	
	private Date investDate;
	/**
	 * 放款时间
	 */
	private String sHoldDate;
	
	private Date  holdDate ;
	/**
	 * 结清时间	
	 */
	private String sEndDate	; 
	private Date endDate;
	/**
	 * 有效投资金额 = 投资总金额-转让总金额
	 */
	private int investAmountValid;
	/**
	 * 有效投资金额 = 投资总金额-转让总金额
	 */
	private String investAmountValids;  
	private String projectNo;//借款项目编号
	private String projectTitle;//借款项目标题
	private int investRate;//投资总进度
	private String investRates;//投资总进度
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public int getInvestRate() {
		return investRate;
	}
	public void setInvestRate(int investRate) {
		this.investRate = investRate;
		this.investRates= IntegerAndString.LongToString(investRate);
	}
	public String getInvestRates() {
		return investRates;
	}
	public void setInvestRates(String investRates) {
		this.investRates = investRates;
	}
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	 
	public int getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(int investAmount) {
		this.investAmount = investAmount;
		this.investAmounts= IntegerAndString.LongToString(investAmount);
	}
	public String getInvestAmounts() {
		return investAmounts;
	}
	public void setInvestAmounts(String investAmounts) {
		this.investAmounts = investAmounts;
	}
	public int getInvestGiftAmount() {
		return investGiftAmount;
	}
	public void setInvestGiftAmount(int investGiftAmount) {
		this.investGiftAmount = investGiftAmount;
		this.investGiftAmounts= IntegerAndString.LongToString(investGiftAmount);
	}
	public String getInvestGiftAmounts() {
		return investGiftAmounts;
	}
	public void setInvestGiftAmounts(String investGiftAmounts) {
		this.investGiftAmounts = investGiftAmounts;
	}
	public int getInvestVouchersAmount() {
		return investVouchersAmount;
	}
	public void setInvestVouchersAmount(int investVouchersAmount) {
		this.investVouchersAmount = investVouchersAmount;
	}
	public String getInvestVouchersAmounts() {
		return investVouchersAmounts;
	}
	public void setInvestVouchersAmounts(String investVouchersAmounts) {
		this.investVouchersAmounts = investVouchersAmounts;
	}
	 
	public int getBackAmount() {
		return backAmount;
	}
	public void setBackAmount(int backAmount) {
		this.backAmount = backAmount;
	}
	public String getBackAmounts() {
		return backAmounts;
	}
	public void setBackAmounts(String backAmounts) {
		this.backAmounts = backAmounts;
	}
	public int getRedPackageAmount() {
		return redPackageAmount;
	}
	public void setRedPackageAmount(int redPackageAmount) {
		this.redPackageAmount = redPackageAmount;
	}
	public String getRedPackageAmounts() {
		return redPackageAmounts;
	}
	public void setRedPackageAmounts(String redPackageAmounts) {
		this.redPackageAmounts = redPackageAmounts;
	}
	public String getsInvestDate() {
		return sInvestDate;
	}
	public Date getInvestDate() {
		return investDate;
	}
	public void setInvestDate(Date investDate) {
		this.investDate = investDate;
		this.sInvestDate = TimestampAndString.DateToString2(investDate);
	}
	public String getsHoldDate() {
		return sHoldDate;
	}
	public Date getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(Date holdDate) {
		this.holdDate = holdDate;
		this.sHoldDate = TimestampAndString.DateToString2(holdDate);
	}
	public String getsEndDate() {
		return sEndDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		this.sEndDate = TimestampAndString.DateToString2(endDate);
	}
	public int getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(int investAmountValid) {
		this.investAmountValid = investAmountValid;
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	} 
}

