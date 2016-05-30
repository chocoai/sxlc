

/** 
* @Title: InvestEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午6:37:22 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 投资记录实体类
 * @since 
 * @date 2016-3-21 下午6:37:22  */

public class InvestEntity {
	
	private long id	 ;
	/**
	 * 第三方交易记录ID
	 */
	private long thirdTradeId	;
	/**
	 * 项目ID
	 */
	private long projectId;	
	/**
	 * 投资会员ID
	 */
	private long memberID;	
	/**
	 * 第三方投资订单号	
	 */
	private String billNo;	
	/**
	 * 返回赠送金额投资订单号
	 */
	private String giftBillNo;	 
	/**
	 * 投资订单号	
	 */
	private String merbillNo ;
	/**
	 * 投资总金额
	 */
	private long investAmount;
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
	 * 返现折扣 精确到百万分之
	 */
	private int backRate;
	/**
	 * 返现折扣 精确到百万分之
	 */
	private String backRates;
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
	private String investDate;	
	/**
	 * 投资管理费(单位：分)
	 */
	private int investMng;	
	/**
	 * 投资管理费(单位：分)
	 */
	private String investMngs;	
	/**
	 * 放款时间
	 */
	private String holdDate;
	/**
	 * 结清时间	
	 */
	private String endDate	; 
	/**
	 * 有效投资金额 = 投资总金额-转让总金额
	 */
	private long investAmountValid;
	/**
	 * 有效投资金额 = 投资总金额-转让总金额
	 */
	private String investAmountValids;
	/**
	 * 是否为自动投标 0：否 1：是	
	 */
	private int isAuto;	
	/**
	 * 投资类型 0：pc 1：app 2：微信端	
	 */
	private int investType	; 
	/**
	 * 是否有效（0：有效，1：无效）	
	 */
	private int isValid;
	/**
	 * 投资会员编号
	 */
	private String memberNo;
	/**
	 * 投资类型
	 */
	private String investTypes;
	/**
	 * 借款会员
	 */
	private String membername;
	/**
	 * 登录用户名
	 */
	private String logname;
	private int isBack;//是否使用返现券
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
	public String getInvestTypes() {
		return investTypes;
	}
	public void setInvestTypes(String investTypes) {
		this.investTypes = investTypes;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getThirdTradeId() {
		return thirdTradeId;
	}
	public void setThirdTradeId(long thirdTradeId) {
		this.thirdTradeId = thirdTradeId;
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
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getGiftBillNo() {
		return giftBillNo;
	}
	public void setGiftBillNo(String giftBillNo) {
		this.giftBillNo = giftBillNo;
	}
	public String getMerbillNo() {
		return merbillNo;
	}
	public void setMerbillNo(String merbillNo) {
		this.merbillNo = merbillNo;
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
		this.investVouchersAmounts= IntegerAndString.IntToString(investVouchersAmount);
	}
	public String getInvestVouchersAmounts() {
		return investVouchersAmounts;
	}
	public void setInvestVouchersAmounts(String investVouchersAmounts) {
		this.investVouchersAmounts = investVouchersAmounts;
	}
	public int getBackRate() {
		return backRate;
	}
	public void setBackRate(int backRate) {
		this.backRate = backRate;
	}
	public String getBackRates() {
		return backRates;
	}
	public void setBackRates(String backRates) {
		this.backRates = backRates;
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
	public String getInvestDate() {
		return investDate;
	}
	public void setInvestDate(String investDate) {
		this.investDate = investDate;
	}
	public int getInvestMng() {
		return investMng;
	}
	public void setInvestMng(int investMng) {
		this.investMng = investMng;
	}
	public String getInvestMngs() {
		return investMngs;
	}
	public void setInvestMngs(String investMngs) {
		this.investMngs = investMngs;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
	public int getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(int isAuto) {
		this.isAuto = isAuto;
	}
	public int getInvestType() {
		return investType;
	}
	public void setInvestType(int investType) {
		this.investType = investType;
	}
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public int getIsBack() {
		return isBack;
	}
	public void setIsBack(int isBack) {
		this.isBack = isBack;
	} 	


}

