
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * 积分规则设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午4:09:49  */
public class IntegralRuleEntity {
	private int type;//0:推荐达人  1:理财顾问 2:会员
	//邀请注册积分规则
	private int signPoints;//签名赠送积分
	private int regPoints;//邀请注册赠送积分个数
	private int statu;//状态 0：无效 1：有效
	
	//项目投资积分规则
	private int proID;	//
	private long proinvest_Amount;	//投资金额
	private String proinvest_Amounts;
	private int proinvest_Points;	//赠送积分
	private int prostatu;	//状态 0：无效 1：有效
	
	//债权转让投资积分规则
	private int traID;	
	private long traInvestAmount;//投资金额	
	private String traInvestAmounts;
	private int traInvestPoints;//赠送积分	
	private int traStatu;//状态 0：无效 1：有效	
	
	//充值积分规则
	private int recID;	
	private long recRechargeAmount;//	充值金额
	private String recRechargeAmounts;
	private int recRechargePoints;//	充值赠送积分
	private int recStatu;//	状态 0：无效 1：有效
	
	//借款积分规则
	private int loaID;
	private long loaLoan_Amount;	//借款金额
	private String loaLoan_Amounts;
	private int loaLoan_Points;	//借款赠送积分
	private int loaStatu;	//状态 0：无效 1：有效
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSignPoints() {
		return signPoints;
	}
	public void setSignPoints(int signPoints) {
		this.signPoints = signPoints;
	}
	public int getRegPoints() {
		return regPoints;
	}
	public void setRegPoints(int regPoints) {
		this.regPoints = regPoints;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public long getProinvest_Amount() {
		return proinvest_Amount;
	}
	public void setProinvest_Amount(long proinvest_Amount) {
		this.proinvest_Amount = proinvest_Amount;
		this.proinvest_Amounts = IntegerAndString.LongToString(proinvest_Amount);
	}
	
	public String getProinvest_Amounts() {
		return proinvest_Amounts;
	}
	public int getProinvest_Points() {
		return proinvest_Points;
	}
	public void setProinvest_Points(int proinvest_Points) {
		this.proinvest_Points = proinvest_Points;
	}
	public int getProstatu() {
		return prostatu;
	}
	public void setProstatu(int prostatu) {
		this.prostatu = prostatu;
	}
	public int getTraID() {
		return traID;
	}
	public void setTraID(int traID) {
		this.traID = traID;
	}
	public long getTraInvestAmount() {
		return traInvestAmount;
	}
	public void setTraInvestAmount(long traInvestAmount) {
		this.traInvestAmount = traInvestAmount;
		this.traInvestAmounts =IntegerAndString.LongToString(traInvestAmount);
	}
	public String getTraInvestAmounts() {
		return traInvestAmounts;
	}
	public int getTraInvestPoints() {
		return traInvestPoints;
	}
	public void setTraInvestPoints(int traInvestPoints) {
		this.traInvestPoints = traInvestPoints;
	}
	public int getTraStatu() {
		return traStatu;
	}
	public void setTraStatu(int traStatu) {
		this.traStatu = traStatu;
	}
	public int getRecID() {
		return recID;
	}
	public void setRecID(int recID) {
		this.recID = recID;
	}
	
	public long getRecRechargeAmount() {
		return recRechargeAmount;
	}
	public void setRecRechargeAmount(long recRechargeAmount) {
		this.recRechargeAmount = recRechargeAmount;
		this.recRechargeAmounts = IntegerAndString.LongToString(recRechargeAmount);
	}
	public String getRecRechargeAmounts() {
		return recRechargeAmounts;
	}
	public int getRecRechargePoints() {
		return recRechargePoints;
	}
	public void setRecRechargePoints(int recRechargePoints) {
		this.recRechargePoints = recRechargePoints;
	}
	public int getRecStatu() {
		return recStatu;
	}
	public void setRecStatu(int recStatu) {
		this.recStatu = recStatu;
	}
	public int getLoaID() {
		return loaID;
	}
	public void setLoaID(int loaID) {
		this.loaID = loaID;
	}

	public long getLoaLoan_Amount() {
		return loaLoan_Amount;
	}
	public void setLoaLoan_Amount(long loaLoan_Amount) {
		this.loaLoan_Amount = loaLoan_Amount;
		this.loaLoan_Amounts =  IntegerAndString.LongToString(loaLoan_Amount);
	}
	public String getLoaLoan_Amounts() {
		return loaLoan_Amounts;
	}
	public int getLoaLoan_Points() {
		return loaLoan_Points;
	}
	public void setLoaLoan_Points(int loaLoan_Points) {
		this.loaLoan_Points = loaLoan_Points;
	}
	public int getLoaStatu() {
		return loaStatu;
	}
	public void setLoaStatu(int loaStatu) {
		this.loaStatu = loaStatu;
	}



}

