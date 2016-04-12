

/** 
* @Title: LoanCreditStatisticsEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-9 下午4:01:12 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员借款信用实体
 * @since 
 * @date 2016-4-9 下午4:01:12  */

public class LoanCreditStatisticsEntity {
	private int successLoan;//成功借款N笔 
	private int successReplay;// 成功还款N笔 
	private int successInvest;//成功投资N笔 
	private int overReplay;// 逾期还款N笔 
	private int overlimitReplay;// 严重逾期还款N笔 
	private int overnotreplay;//逾期未还N笔 
	private int successAdvance;// 提前还款N笔  
	public int getSuccessLoan() {
		return successLoan;
	}
	public void setSuccessLoan(int successLoan) {
		this.successLoan = successLoan;
	}
	public int getSuccessReplay() {
		return successReplay;
	}
	public void setSuccessReplay(int successReplay) {
		this.successReplay = successReplay;
	}
	public int getSuccessInvest() {
		return successInvest;
	}
	public void setSuccessInvest(int successInvest) {
		this.successInvest = successInvest;
	}
	public int getOverReplay() {
		return overReplay;
	}
	public void setOverReplay(int overReplay) {
		this.overReplay = overReplay;
	}
	public int getOverlimitReplay() {
		return overlimitReplay;
	}
	public void setOverlimitReplay(int overlimitReplay) {
		this.overlimitReplay = overlimitReplay;
	}
	public int getOvernotreplay() {
		return overnotreplay;
	}
	public void setOvernotreplay(int overnotreplay) {
		this.overnotreplay = overnotreplay;
	}
	public int getSuccessAdvance() {
		return successAdvance;
	}
	public void setSuccessAdvance(int successAdvance) {
		this.successAdvance = successAdvance;
	}
}

