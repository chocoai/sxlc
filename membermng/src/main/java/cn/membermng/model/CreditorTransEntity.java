

/** 
* @Title: CreditorTransAppEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午10:16:45 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 债权转让申请实体
 * @since 
 * @date 2016-4-6 上午10:16:45  */

public class CreditorTransEntity {
	private long   ctaId;//ID		
	private String billNo;//债权转让申请编号  审核通过后生成		
	private long   investId;//投资ID		
	private long   transPrincipal;//转让本金(单位：分)		
	private long   transDiscount;//转让折扣(％)		
	private String transMaxTime;//最迟转让时间		
	private String applyTime;//申请时间		
	private int    checkStatu;//申请状态(0：申请；1：审核通过；-1：审核打回)		
	private int    statu;//转让状态(-1：待流标处理 0：投标中 1：流标 2：投标完成 3：还款中 4：结清)		
	private int    mngFee;//债权转让手续费金额   单位  分		
	private int    mngFeeStatu;//债权转让手续费状态   0：未支付   1：支付		
	private int    surplusTime;//剩余期限		
	private int    surplusTimeType;//剩余期限类型 0：天标 1：月标 2：年标		
	private String endDate;//债权到期日		
	private int    ctaInvestRate;//投标进度 万分之	
	private String ctaInvestRates;//投标进度 万分之	
	private String dealDate;//	放款时间	
	private String transPrincipals;//转让本金(单位：分)		
	private String transDiscounts;//转让折扣(％)	
	private String mngFees;//债权转让手续费金额   单位  分	
	private String projectTitle;//转让项目名称 
	private long   transAmount;//转让价格
	private String transAmounts;//转让价格
	private String holdDate;//投资成交时间
	private long   interestAmount;//转让金额投资收益
	private String interestAmounts;//转让金额投资收益 
	private long   tansID;//债券转让购买ID
	private String transTime;//转入时间
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public long getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(long transAmount) {
		this.transAmount = transAmount;
		this.transAmounts= IntegerAndString.LongToString(transAmount);
	}
	public String getTransAmounts() {
		return transAmounts;
	}
	public void setTransAmounts(String transAmounts) {
		this.transAmounts = transAmounts;
	}
	public long getCtaId() {
		return ctaId;
	}
	public void setCtaId(long ctaId) {
		this.ctaId = ctaId;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	public long getTransPrincipal() {
		return transPrincipal;
	}
	public void setTransPrincipal(long transPrincipal) {
		this.transPrincipal = transPrincipal;
		this.transPrincipals= IntegerAndString.LongToString(transPrincipal);
	}
	public long getTransDiscount() {
		return transDiscount;
	}
	public void setTransDiscount(long transDiscount) {
		this.transDiscount = transDiscount;
		this.transDiscounts= IntegerAndString.LongToString(transDiscount);
	}
	public String getTransMaxTime() {
		return transMaxTime;
	}
	public void setTransMaxTime(String transMaxTime) {
		this.transMaxTime = transMaxTime;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getMngFee() {
		return mngFee;
	}
	public void setMngFee(int mngFee) {
		this.mngFee = mngFee;
		this.mngFees= IntegerAndString.IntToString(mngFee);
	}
	public int getMngFeeStatu() {
		return mngFeeStatu;
	}
	public void setMngFeeStatu(int mngFeeStatu) {
		this.mngFeeStatu = mngFeeStatu;
	}
	public int getSurplusTime() {
		return surplusTime;
	}
	public void setSurplusTime(int surplusTime) {
		this.surplusTime = surplusTime;
	}
	public int getSurplusTimeType() {
		return surplusTimeType;
	}
	public void setSurplusTimeType(int surplusTimeType) {
		this.surplusTimeType = surplusTimeType;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getCtaInvestRate() {
		return ctaInvestRate;
	}
	public void setCtaInvestRate(int ctaInvestRate) {
		this.ctaInvestRate = ctaInvestRate;
		this.setCtaInvestRates(IntegerAndString.IntToString(ctaInvestRate));
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getTransPrincipals() {
		return transPrincipals;
	}
	public void setTransPrincipals(String transPrincipals) {
		this.transPrincipals = transPrincipals;
	}
	public String getTransDiscounts() {
		return transDiscounts;
	}
	public void setTransDiscounts(String transDiscounts) {
		this.transDiscounts = transDiscounts;
	}
	public String getMngFees() {
		return mngFees;
	}
	public void setMngFees(String mngFees) {
		this.mngFees = mngFees;
	}
	public String getCtaInvestRates() {
		return ctaInvestRates;
	}
	public void setCtaInvestRates(String ctaInvestRates) {
		this.ctaInvestRates = ctaInvestRates;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public String getInterestAmounts() {
		return interestAmounts;
	}
	public void setInterestAmounts(String interestAmounts) {
		this.interestAmounts = interestAmounts;
	}
	public long getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(long interestAmount) {
		this.interestAmount = interestAmount;
		this.interestAmounts= IntegerAndString.LongToString(interestAmount);
	}
	public long getTansID() {
		return tansID;
	}
	public void setTansID(long tansID) {
		this.tansID = tansID;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

}

