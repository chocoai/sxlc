
package cn.membermng.model; 

/** 
 * 自动投标设置
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-4 上午9:34:23  */
public class AutomaticBidSettingEntity {
	private long memberID;//会员ID
	private String proType;//自动投标项目类型id集
	private String proTypesString;//自动投标项目类型名称
	private String status;//还款方式
	private long everyMoney;//每次投资金额
	private String sEveryMoney;
	private long rateMin;//年华利率最小值
	private long rateMax;//年华利率最大值
	private int yearMin;//项目期限-年最小值
	private int yearMax;//项目期限-年最大值
	private int monthMin;//项目期限-月最小值
	private int monthMax;//项目期限-月最大值
	private int dayMin;//项目期限-天最小值
	private int dayMax;//项目期限-天最大值
	private long reservedMoney;//账户预留金额
	private String sReservedMoney;
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getEveryMoney() {
		return everyMoney;
	}
	public void setEveryMoney(long everyMoney) {
		this.everyMoney = everyMoney;
	}
	public long getRateMin() {
		return rateMin;
	}
	public void setRateMin(long rateMin) {
		this.rateMin = rateMin;
	}
	public long getRateMax() {
		return rateMax;
	}
	public void setRateMax(long rateMax) {
		this.rateMax = rateMax;
	}
	public int getYearMin() {
		return yearMin;
	}
	public void setYearMin(int yearMin) {
		this.yearMin = yearMin;
	}
	public int getYearMax() {
		return yearMax;
	}
	public void setYearMax(int yearMax) {
		this.yearMax = yearMax;
	}
	public int getMonthMin() {
		return monthMin;
	}
	public void setMonthMin(int monthMin) {
		this.monthMin = monthMin;
	}
	public int getMonthMax() {
		return monthMax;
	}
	public void setMonthMax(int monthMax) {
		this.monthMax = monthMax;
	}
	public int getDayMin() {
		return dayMin;
	}
	public void setDayMin(int dayMin) {
		this.dayMin = dayMin;
	}
	public int getDayMax() {
		return dayMax;
	}
	public void setDayMax(int dayMax) {
		this.dayMax = dayMax;
	}
	public long getReservedMoney() {
		return reservedMoney;
	}
	public void setReservedMoney(long reservedMoney) {
		this.reservedMoney = reservedMoney;
	}
	public String getProTypesString() {
		return proTypesString;
	}
	public void setProTypesString(String proTypesString) {
		this.proTypesString = proTypesString;
	}
	public String getsEveryMoney() {
		return sEveryMoney;
	}
	public void setsEveryMoney(String sEveryMoney) {
		this.sEveryMoney = sEveryMoney;
	}
	public String getsReservedMoney() {
		return sReservedMoney;
	}
	public void setsReservedMoney(String sReservedMoney) {
		this.sReservedMoney = sReservedMoney;
	}
	
}

