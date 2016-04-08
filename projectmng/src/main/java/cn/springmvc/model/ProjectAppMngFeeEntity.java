
package cn.springmvc.model; 

/** 
 * 项目费用记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午3:20:33  */
public class ProjectAppMngFeeEntity {
	private long projectID;//项目ID	
	private int guaranteeRate;//担保费率 单位：百万分之	
	private int guaranteeType;//担保费类型 0：百分比 1：固定金额
	private int guaranteeFee;//收取担保费金额	
	private int riskMarginRate;//风险保证金费率 单位：百万分之
	private int riskMarginType;//风险保证金类型 0：百分比 1：固定金额
	private int riskMarginFee;//收取风险保证金金额	
	private int mngFeeRate;//管理费比例、天标起收比例 单位：百万分之	
	private int mngFeeRateIncreace;//管理费增量 单位：百万分之	
	private long mngFeeAmount;//管理费金额
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
	}
	public int getRiskMarginRate() {
		return riskMarginRate;
	}
	public void setRiskMarginRate(int riskMarginRate) {
		this.riskMarginRate = riskMarginRate;
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
	}
	public int getMngFeeRate() {
		return mngFeeRate;
	}
	public void setMngFeeRate(int mngFeeRate) {
		this.mngFeeRate = mngFeeRate;
	}
	public int getMngFeeRateIncreace() {
		return mngFeeRateIncreace;
	}
	public void setMngFeeRateIncreace(int mngFeeRateIncreace) {
		this.mngFeeRateIncreace = mngFeeRateIncreace;
	}
	public long getMngFeeAmount() {
		return mngFeeAmount;
	}
	public void setMngFeeAmount(long mngFeeAmount) {
		this.mngFeeAmount = mngFeeAmount;
	}
	

}

