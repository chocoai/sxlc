
package cn.springmvc.model; 

/** 
 * 系统设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午6:55:59  */
public class SystemSetEntity {
	private int overdueInsteadDay;//逾期N天后代偿
	private int autoBackRate;	//自动投标成功后返还投资总金额的百分比 保留4位小数
	private String sautoBackRate;
	private int endDateRemind;	//红包、代金券到期前N天提醒
	private int expirationReminderSet;	//即将到期时间定义
	private int riskMarginRateMax;	//借款项目风险保证金比例 0：表示无上限
	private String sriskMarginRateMax;
	private int redpacketsRateMax;	//红包使用百分比上限 0：表示无上限
	private String sredpacketsRateMax;
	private int riskMarginType;//保证金扣除方式 0：一次性全部扣除 1：按照逾期本金比例扣除 2：按照逾期期数比例扣除
	public int getOverdueInsteadDay() {
		return overdueInsteadDay;
	}
	public void setOverdueInsteadDay(int overdueInsteadDay) {
		this.overdueInsteadDay = overdueInsteadDay;
	}
	public int getAutoBackRate() {
		return autoBackRate;
	}
	public void setAutoBackRate(int autoBackRate) {
		this.autoBackRate = autoBackRate;
	}
	public int getEndDateRemind() {
		return endDateRemind;
	}
	public void setEndDateRemind(int endDateRemind) {
		this.endDateRemind = endDateRemind;
	}
	public int getExpirationReminderSet() {
		return expirationReminderSet;
	}
	public void setExpirationReminderSet(int expirationReminderSet) {
		this.expirationReminderSet = expirationReminderSet;
	}
	public int getRiskMarginRateMax() {
		return riskMarginRateMax;
	}
	public void setRiskMarginRateMax(int riskMarginRateMax) {
		this.riskMarginRateMax = riskMarginRateMax;
	}
	public int getRedpacketsRateMax() {
		return redpacketsRateMax;
	}
	public void setRedpacketsRateMax(int redpacketsRateMax) {
		this.redpacketsRateMax = redpacketsRateMax;
	}
	public int getRiskMarginType() {
		return riskMarginType;
	}
	public void setRiskMarginType(int riskMarginType) {
		this.riskMarginType = riskMarginType;
	}
	public String getSautoBackRate() {
		return sautoBackRate;
	}
	public void setSautoBackRate(String sautoBackRate) {
		this.sautoBackRate = sautoBackRate;
	}
	public String getSriskMarginRateMax() {
		return sriskMarginRateMax;
	}
	public void setSriskMarginRateMax(String sriskMarginRateMax) {
		this.sriskMarginRateMax = sriskMarginRateMax;
	}
	public String getSredpacketsRateMax() {
		return sredpacketsRateMax;
	}
	public void setSredpacketsRateMax(String sredpacketsRateMax) {
		this.sredpacketsRateMax = sredpacketsRateMax;
	}
	@Override
	public String toString() {
		return "SystemSetEntity [overdueInsteadDay=" + overdueInsteadDay
				+ ", autoBackRate=" + autoBackRate + ", sautoBackRate="
				+ sautoBackRate + ", endDateRemind=" + endDateRemind
				+ ", expirationReminderSet=" + expirationReminderSet
				+ ", riskMarginRateMax=" + riskMarginRateMax
				+ ", sriskMarginRateMax=" + sriskMarginRateMax
				+ ", redpacketsRateMax=" + redpacketsRateMax
				+ ", sredpacketsRateMax=" + sredpacketsRateMax
				+ ", riskMarginType=" + riskMarginType + "]";
	}
	
}

