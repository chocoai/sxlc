

/** 
* @Title: MemberWithdrawalRechargeEntity.java 
* @Package cn.capitalbudgetdetails.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午5:19:00 
* @version V5.0 */
 
package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * @author 刘利 
 * @Description: 会员充值提现记录实体
 * @since 
 * @date 2016-3-30 下午5:19:00  */

public class MemberWithdrawalRechargeEntity {
 
	private long rechargeID;
	/**
	 * 第三方交易记录ID
	 */
	private long thirdTradeId;
	/**
	 * 交易类型 0：充值 1：提现
	 */
	private int dealType;	
	/**
	 * 关联提现申请ID	
	 */
	private long withdrawalID;
	/**
	 * 会员类型 0：会员 1：担保机构 2：平台
	 */
	private long memberType;
	/**
	 * 会员ID
	 */
	private long memberID;	
	/**
	 * 平台交易流水号	
	 */
	private String merBillno; 
	/**
	 * 第三方交易流水号	
	 */
	private String thirdMerBillno; 
	/**
	 * 提现金额	
	 */
	private long withdrawalMoney;
	/**
	 * 提现金额	
	 */
	private String withdrawalMoneys;
	/**
	 * 平台手续费
	 */
	private int mngFee; 
	/**
	 * 平台手续费
	 */
	private String mngFees; 
	/**
	 * 第三方手续费
	 */
	private int thirdMngFee; 
	/**
	 * 第三方手续费
	 */
	private String thirdMngFees; 
	/**
	 * 平台代付手续费	
	 */
	private int mngFeeRepay;
	/**
	 * 平台代付手续费	
	 */
	private String mngFeeRepays;
	/**
	 * 实际到账金额
	 */
	private long realMoney;
	/**
	 * 实际到账金额
	 */
	private String realMoneys;

	
	private Date recordDate;
	private String sRecordDate;	//申请时间
	
	/**
	 * 到账时间
	 */
	private Date   receiveDate;	//
	private String sReceiveDate;
	/**
	 * 到账银行卡ID
	 */
	private long receiveCard; 
	/**
	 * 提现状态 0：失败 1：成功 	
	 */
	private int statu; 
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 总的手续费
	 */
	private String totalfees;
	/**
	 * 总的手续费
	 */
	private long totalfee;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 提现审核状态
	 */
	private String checkstatu;
	public long getRechargeID() {
		return rechargeID;
	}
	public void setRechargeID(long rechargeID) {
		this.rechargeID = rechargeID;
	}
	public int getDealType() {
		return dealType;
	}
	public void setDealType(int dealType) {
		this.dealType = dealType;
	}
	public long getWithdrawalID() {
		return withdrawalID;
	}
	public void setWithdrawalID(long withdrawalID) {
		this.withdrawalID = withdrawalID;
	}
	public long getMemberType() {
		return memberType;
	}
	public void setMemberType(long memberType) {
		this.memberType = memberType;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getMerBillno() {
		return merBillno;
	}
	public void setMerBillno(String merBillno) {
		this.merBillno = merBillno;
	}
	public String getThirdMerBillno() {
		return thirdMerBillno;
	}
	public void setThirdMerBillno(String thirdMerBillno) {
		this.thirdMerBillno = thirdMerBillno;
	}
	public long getWithdrawalMoney() {
		return withdrawalMoney;
	}
	public void setWithdrawalMoney(long withdrawalMoney) {
		this.withdrawalMoney = withdrawalMoney;
	}
	public int getMngFee() {
		return mngFee;
	}
	public void setMngFee(int mngFee) {
		this.mngFee = mngFee;
		this.mngFees= IntegerAndString.IntToString(mngFee);
	}
	public int getThirdMngFee() {
		return thirdMngFee;
	}
	public void setThirdMngFee(int thirdMngFee) {
		this.thirdMngFee = thirdMngFee;
		this.thirdMngFees= IntegerAndString.IntToString(thirdMngFee); 
	}
	public int getMngFeeRepay() {
		return mngFeeRepay;
	}
	public void setMngFeeRepay(int mngFeeRepay) {
		this.mngFeeRepay = mngFeeRepay;
		this.mngFeeRepays= IntegerAndString.IntToString(mngFeeRepay);
	}
	public long getRealMoney() {
		return realMoney;
	}
	public void setRealMoney(long realMoney) {
		this.realMoney = realMoney;
		this.realMoneys= IntegerAndString.LongToString(realMoney);
	}
	
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate = TimestampAndString.DateToString2(recordDate);
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
		this.sReceiveDate = TimestampAndString.DateToString2(receiveDate);
	}
	public String getsReceiveDate() {
		return sReceiveDate;
	}
	public long getReceiveCard() {
		return receiveCard;
	}
	public void setReceiveCard(long receiveCard) {
		this.receiveCard = receiveCard;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getThirdTradeId() {
		return thirdTradeId;
	}
	public void setThirdTradeId(long thirdTradeId) {
		this.thirdTradeId = thirdTradeId;
	}
	public String getWithdrawalMoneys() {
		return withdrawalMoneys;
	}
	public void setWithdrawalMoneys(String withdrawalMoneys) {
		this.withdrawalMoneys = withdrawalMoneys;
	}
	public String getMngFees() {
		return mngFees;
	}
	public void setMngFees(String mngFees) {
		this.mngFees = mngFees;
	} 	
	public String getThirdMngFees() {
		return thirdMngFees;
	}
	public void setThirdMngFees(String thirdMngFees) {
		this.thirdMngFees = thirdMngFees;
	}
	public String getMngFeeRepays() {
		return mngFeeRepays;
	}
	public void setMngFeeRepays(String mngFeeRepays) {
		this.mngFeeRepays = mngFeeRepays;
	}
	public String getRealMoneys() {
		return realMoneys;
	}
	public void setRealMoneys(String realMoneys) {
		this.realMoneys = realMoneys;
	}
	public long getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(long totalfee) {
		this.totalfee = totalfee;
		this.totalfees= IntegerAndString.LongToString(totalfee);
	}
	public String getTotalfees() {
		return totalfees;
	}
	public void setTotalfees(String totalfees) {
		this.totalfees = totalfees;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCheckstatu() {
		return checkstatu;
	}
	public void setCheckstatu(String checkstatu) {
		this.checkstatu = checkstatu;
	}
}

