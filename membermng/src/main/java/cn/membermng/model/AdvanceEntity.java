

/** 
* @Title: AdvanceEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-3 上午11:16:53 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 提前还款实体
 * @since 
 * @date 2016-5-3 上午11:16:53  */

public class AdvanceEntity {
	
	private long   repayPrincipal;//应还本金
	private String repayPrincipals;
	
	private long   repayInterest;//应还利息
	private String repayInterests;
	
	private int   penaltyInvestRate;//用户支付违约金比率
	private String penaltyInvestRates;
	
	private int   penaltyPingTaiRate;//平台支付违约金比率
	private String penaltyPingTaiRates;
	
	private long   penaltyInvest;//用户支付违约金
	private String penaltyInvests;
	
	private long   penaltyPingTai;//平台支付违约金
	private String penaltyPingTais;
	
	private long   penaltyTotal;//总的违约金
	private String penaltyTotals;
	
	private long   replayTotal;//应还款总额
	private String replayTotals;//应还款总额
	private long    applyId;//项目申请ID
	public long getRepayPrincipal() {
		return repayPrincipal;
	}
	public void setRepayPrincipal(long repayPrincipal) {
		this.repayPrincipal = repayPrincipal;
		this.repayPrincipals = IntegerAndString.LongToString(repayPrincipal);
	}
	public String getRepayPrincipals() {
		return repayPrincipals;
	}
	public void setRepayPrincipals(String repayPrincipals) {
		this.repayPrincipals = repayPrincipals;
	}
	public long getRepayInterest() {
		return repayInterest;
	}
	public void setRepayInterest(long repayInterest) {
		this.repayInterest = repayInterest;
		this.repayInterests = IntegerAndString.LongToString(repayInterest);
	}
	public String getRepayInterests() {
		return repayInterests;
	}
	public void setRepayInterests(String repayInterests) {
		this.repayInterests = repayInterests;
	}
	public long getPenaltyInvestRate() {
		return penaltyInvestRate;
	}
	 
	public void setPenaltyInvestRates(String penaltyInvestRates) {
		this.penaltyInvestRates = penaltyInvestRates;
	}
	public long getPenaltyPingTaiRate() {
		return penaltyPingTaiRate;
	}
	 
	public void setPenaltyPingTaiRates(String penaltyPingTaiRates) {
		this.penaltyPingTaiRates = penaltyPingTaiRates;
	}
	public long getPenaltyInvest() {
		return penaltyInvest;
	}
	public void setPenaltyInvest(long penaltyInvest) {
		this.penaltyInvest = penaltyInvest;
		this.penaltyInvests=IntegerAndString.LongToString(penaltyInvest);
	}
	public String getPenaltyInvests() {
		return penaltyInvests;
	}
	public void setPenaltyInvests(String penaltyInvests) {
		this.penaltyInvests = penaltyInvests;
	}
	public long getPenaltyPingTai() {
		return penaltyPingTai;
	}
	public void setPenaltyPingTai(long penaltyPingTai) {
		this.penaltyPingTai = penaltyPingTai;
		this.penaltyPingTais=IntegerAndString.LongToString(penaltyPingTai);
	}
	public String getPenaltyPingTais() {
		return penaltyPingTais;
	}
	public void setPenaltyPingTais(String penaltyPingTais) {
		this.penaltyPingTais = penaltyPingTais;
	}
	public String getPenaltyInvestRates() {
		return penaltyInvestRates;
	}
	public String getPenaltyPingTaiRates() {
		return penaltyPingTaiRates;
	}
	public void setPenaltyInvestRate(int penaltyInvestRate) {
		this.penaltyInvestRate = penaltyInvestRate;
		this.penaltyInvestRates = IntegerAndString.IntToString(penaltyInvestRate);
	}
	public void setPenaltyPingTaiRate(int penaltyPingTaiRate) {
		this.penaltyPingTaiRate = penaltyPingTaiRate;
		this.penaltyPingTaiRates = IntegerAndString.IntToString(penaltyPingTaiRate);
	}
	public long getPenaltyTotal() {
		return penaltyTotal;
	}
	public void setPenaltyTotal(long penaltyTotal) {
		this.penaltyTotal = penaltyTotal;
		this.penaltyTotals = IntegerAndString.LongToString(penaltyTotal);
	}
	public String getPenaltyTotals() {
		return penaltyTotals;
	}
	public void setPenaltyTotals(String penaltyTotals) {
		this.penaltyTotals = penaltyTotals;
	}
	public long getReplayTotal() {
		return replayTotal;
	}
	public void setReplayTotal(long replayTotal) {
		this.replayTotal = replayTotal;
		this.replayTotals = IntegerAndString.LongToString(replayTotal);
	}
	public String getReplayTotals() {
		return replayTotals;
	}
	public void setReplayTotals(String replayTotals) {
		this.replayTotals = replayTotals;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
 
}

