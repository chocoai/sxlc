

/** 
* @Title: LoanRealRepayEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 上午10:13:25 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 真实还款记录 实体类
 * @since 
 * @date 2016-3-22 上午10:13:25  */

public class LoanRealRepayEntity {
	/**
	 * 真实还款id
	 */
	private long id; 
	/**
	 * 第三方交易记录ID
	 */
	private long thirdTradeId;
	/**
	 * 还款订单号																						
	 */
	private String merbillNo;
	/**
	 * 项目ID 
	 */
	private long rrojectId; 
	/**
	 * 还款计划ID	
	 */
	private long repayId; 
	/**
	 * 还款计划实体
	 */
	private LoanRepayEntity loanRepayEntity;
	/**
	 * 实还本金(单位：分)
	 */
	private int repayPrincipal; 
	/**
	 * 实还利息(单位：分)
	 */
	private int repayInterest;
	/**
	 * 逾期利息(单位：分)
	 */
	private int repayOverdueInterest ;
	/**
	 * 逾期罚金(单位：分)
	 */
	private int repayOverdue;
	/**
	 * 提前还款违约金(单位：分)
	 */
	private int repayPenalty;
	/**
	 *  还款时间
	 */
	private String repayTime;	
	/**
	 * 是否 自动还款 0：否 1：是
	 */ 
	private int isAuto;
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
	public String getMerbillNo() {
		return merbillNo;
	}
	public void setMerbillNo(String merbillNo) {
		this.merbillNo = merbillNo;
	}
	public long getRrojectId() {
		return rrojectId;
	}
	public void setRrojectId(long rrojectId) {
		this.rrojectId = rrojectId;
	}
	public long getRepayId() {
		return repayId;
	}
	public void setRepayId(long repayId) {
		this.repayId = repayId;
	}
	public LoanRepayEntity getLoanRepayEntity() {
		return loanRepayEntity;
	}
	public void setLoanRepayEntity(LoanRepayEntity loanRepayEntity) {
		this.loanRepayEntity = loanRepayEntity;
	}
	public int getRepayPrincipal() {
		return repayPrincipal;
	}
	public void setRepayPrincipal(int repayPrincipal) {
		this.repayPrincipal = repayPrincipal;
	}
	public int getRepayInterest() {
		return repayInterest;
	}
	public void setRepayInterest(int repayInterest) {
		this.repayInterest = repayInterest;
	}
	public int getRepayOverdueInterest() {
		return repayOverdueInterest;
	}
	public void setRepayOverdueInterest(int repayOverdueInterest) {
		this.repayOverdueInterest = repayOverdueInterest;
	}
	public int getRepayOverdue() {
		return repayOverdue;
	}
	public void setRepayOverdue(int repayOverdue) {
		this.repayOverdue = repayOverdue;
	}
	public int getRepayPenalty() {
		return repayPenalty;
	}
	public void setRepayPenalty(int repayPenalty) {
		this.repayPenalty = repayPenalty;
	}
	public String getRepayTime() {
		return repayTime;
	}
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	public int getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(int isAuto) {
		this.isAuto = isAuto;
	}
	@Override
	public String toString() {
		return "LoanRealRepayEntity [id=" + id + ", thirdTradeId="
				+ thirdTradeId + ", merbillNo=" + merbillNo + ", rrojectId="
				+ rrojectId + ", repayId=" + repayId + ", loanRepayEntity="
				+ loanRepayEntity + ", repayPrincipal=" + repayPrincipal
				+ ", repayInterest=" + repayInterest
				+ ", repayOverdueInterest=" + repayOverdueInterest
				+ ", repayOverdue=" + repayOverdue + ", repayPenalty="
				+ repayPenalty + ", repayTime=" + repayTime + ", isAuto="
				+ isAuto + "]";
	} 		

}

