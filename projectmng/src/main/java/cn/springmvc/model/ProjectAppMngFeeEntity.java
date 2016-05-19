
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * 项目费用记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午3:20:33  */
public class ProjectAppMngFeeEntity {
	private long projectID;//项目ID	
	private int guaranteeRate;//担保费率 单位：百万分之	
	private String guaranteeRates;//担保费率 单位：百万分之	
	private int guaranteeType;//担保费类型 0：百分比 1：固定金额
	private int guaranteeFee;//收取担保费金额	
	private String guaranteeFees;//收取担保费金额	
	private int riskMarginRate;//风险保证金费率 单位：百万分之
	private String riskMarginRates;//风险保证金费率 单位：百万分之
	private int riskMarginType;//风险保证金类型 0：百分比 1：固定金额
	private int riskMarginFee;//收取风险保证金金额	
	private String riskMarginFees;//收取风险保证金金额	
	private int mngFeeRate;//管理费比例、天标起收比例 单位：百万分之	
	private String mngFeeRates;//管理费比例、天标起收比例 单位：百万分之	
	private int mngFeeRateIncreace;//管理费增量 单位：百万分之	
	private String mngFeeRateIncreaces;//管理费增量 单位：百万分之	
	private long mngFeeAmount;//管理费金额
	private String mngFeeAmounts;//管理费金额
	
	public String getGuaranteeRates() {
		return guaranteeRates;
	}
	public void setGuaranteeRates(String guaranteeRates) {
		this.guaranteeRates = guaranteeRates;
	}
	public String getGuaranteeFees() {
		return guaranteeFees;
	}
	public void setGuaranteeFees(String guaranteeFees) {
		this.guaranteeFees = guaranteeFees;
	}
	public String getRiskMarginRates() {
		return riskMarginRates;
	}
	public void setRiskMarginRates(String riskMarginRates) {
		this.riskMarginRates = riskMarginRates;
	}
	public String getRiskMarginFees() {
		return riskMarginFees;
	}
	public void setRiskMarginFees(String riskMarginFees) {
		this.riskMarginFees = riskMarginFees;
	}
	public String getMngFeeRates() {
		return mngFeeRates;
	}
	public void setMngFeeRates(String mngFeeRates) {
		this.mngFeeRates = mngFeeRates;
	}
	public String getMngFeeRateIncreaces() {
		return mngFeeRateIncreaces;
	}
	public void setMngFeeRateIncreaces(String mngFeeRateIncreaces) {
		this.mngFeeRateIncreaces = mngFeeRateIncreaces;
	}
	public String getMngFeeAmounts() {
		return mngFeeAmounts;
	}
	public void setMngFeeAmounts(String mngFeeAmounts) {
		this.mngFeeAmounts = mngFeeAmounts;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public int getGuaranteeRate() {
		return guaranteeRate;
	}
	public void setGuaranteeRate(int guaranteeRate) {
		this.guaranteeRate = guaranteeRate;
		this.guaranteeRates = IntegerAndString.IntToString(guaranteeRate);
	}
	public int getGuaranteeType() {
		return guaranteeType;
	}
	public void setGuaranteeType(int guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	public int getGuaranteeFee() {
		return guaranteeFee;
	}
	public void setGuaranteeFee(int guaranteeFee) {
		this.guaranteeFee = guaranteeFee;
		this.guaranteeFees = IntegerAndString.IntToString(guaranteeFee);
	}
	public int getRiskMarginRate() {
		return riskMarginRate;
	}
	public void setRiskMarginRate(int riskMarginRate) {
		this.riskMarginRate = riskMarginRate;
		this.riskMarginRates = IntegerAndString.IntToString(riskMarginRate);
	}
	public int getRiskMarginType() {
		return riskMarginType;
	}
	public void setRiskMarginType(int riskMarginType) {
		this.riskMarginType = riskMarginType;
	}
	public int getRiskMarginFee() {
		return riskMarginFee;
	}
	public void setRiskMarginFee(int riskMarginFee) {
		this.riskMarginFee = riskMarginFee;
		this.riskMarginFees = IntegerAndString.IntToString(riskMarginFee);
	}
	public int getMngFeeRate() {
		return mngFeeRate;
	}
	public void setMngFeeRate(int mngFeeRate) {
		this.mngFeeRate = mngFeeRate;
		this.mngFeeRates = IntegerAndString.IntToString(mngFeeRate);
	}
	public int getMngFeeRateIncreace() {
		return mngFeeRateIncreace;
	}
	public void setMngFeeRateIncreace(int mngFeeRateIncreace) {
		this.mngFeeRateIncreace = mngFeeRateIncreace;
		this.mngFeeRateIncreaces = IntegerAndString.IntToString(mngFeeRateIncreace);
	}
	public long getMngFeeAmount() {
		return mngFeeAmount;
	}
	public void setMngFeeAmount(long mngFeeAmount) {
		this.mngFeeAmount = mngFeeAmount;
		this.mngFeeAmounts = IntegerAndString.LongToString(mngFeeAmount);
	}
	

}

