package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/***
* 后台查看所有会员实体信息
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-6 下午5:07:25 
*
*/
public class MemberAll {

	private long 					memberId;				//会员编号
	private String					memberNo;				//会员编号
	private String					personalName;			//会员真实姓名
	private String					memberName;				//会员登录名
	private String 					personalPhone;			//会员手机号
	private String					provinceName;			//省名称
	private String					cityName;				//市名称
	private String					countyName;				//城市名称
	private String					townName;				//街道名称
	private int						grade;					//会员等级
	private	int						creditRating;			//信用等级
	private String					thirdPartyAccount;		//第三方账户
	private long					userBalance;			//账户可用余额
	private String					sUserBalance;			//
	private long					frozen;					//账户冻结金额
	private String					sFrozen;				//
	private long					recharge;				//充值总金额
	private String					sRecharge;				//
	private long					investment;				//投资总金额
	private String					sInvestment;			//
	private long					loan;					//借款总额
	private String					sLoan;					//
	private long					withdrawals;			//提现总额
	private String					sWithdrawals;			//
	private long					profit;					//收益总额
	private String					sProfit;				//
	private long					integral;				//当前积分
	private String					sIntegral;				
	private int						automaticBidding;		//自动投标
	private int						automaticRepayment;		//自动还款
	
	
	public MemberAll() {	}


	public MemberAll(long memberId, String memberNo, String personalName,
			String memberName, String personalPhone, String provinceName,
			String cityName, String countyName, String townName, int grade,
			int creditRating, String thirdPartyAccount, long userBalance,
			String sUserBalance, long frozen, String sFrozen, long recharge,
			String sRecharge, long investment, String sInvestment, long loan,
			String sLoan, long withdrawals, String sWithdrawals, long profit,
			String sProfit, long integral, String sIntegral,
			int automaticBidding, int automaticRepayment) {
		super();
		this.memberId = memberId;
		this.memberNo = memberNo;
		this.personalName = personalName;
		this.memberName = memberName;
		this.personalPhone = personalPhone;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.countyName = countyName;
		this.townName = townName;
		this.grade = grade;
		this.creditRating = creditRating;
		this.thirdPartyAccount = thirdPartyAccount;
		this.userBalance = userBalance;
		this.sUserBalance = sUserBalance;
		this.frozen = frozen;
		this.sFrozen = sFrozen;
		this.recharge = recharge;
		this.sRecharge = sRecharge;
		this.investment = investment;
		this.sInvestment = sInvestment;
		this.loan = loan;
		this.sLoan = sLoan;
		this.withdrawals = withdrawals;
		this.sWithdrawals = sWithdrawals;
		this.profit = profit;
		this.sProfit = sProfit;
		this.integral = integral;
		this.sIntegral = sIntegral;
		this.automaticBidding = automaticBidding;
		this.automaticRepayment = automaticRepayment;
	}


	public long getMemberId() {
		return memberId;
	}


	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getPersonalName() {
		return personalName;
	}


	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getPersonalPhone() {
		return personalPhone;
	}


	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getCountyName() {
		return countyName;
	}


	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}


	public String getTownName() {
		return townName;
	}


	public void setTownName(String townName) {
		this.townName = townName;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getCreditRating() {
		return creditRating;
	}


	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}


	public String getThirdPartyAccount() {
		return thirdPartyAccount;
	}


	public void setThirdPartyAccount(String thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}


	public long getUserBalance() {
		return userBalance;
	}


	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
		this.sUserBalance = IntegerAndString.LongToString(userBalance);
	}


	public String getsUserBalance() {
		return sUserBalance;
	}


	public void setsUserBalance(String sUserBalance) {
		this.sUserBalance = sUserBalance;
	}


	public long getFrozen() {
		return frozen;
	}


	public void setFrozen(long frozen) {
		this.frozen = frozen;
		this.sFrozen = IntegerAndString.LongToString(frozen);
	}


	public String getsFrozen() {
		return sFrozen;
	}


	public void setsFrozen(String sFrozen) {
		this.sFrozen = sFrozen;
	}


	public long getRecharge() {
		return recharge;
	}


	public void setRecharge(long recharge) {
		this.recharge = recharge;
		this.sRecharge = IntegerAndString.LongToString(recharge);
	}


	public String getsRecharge() {
		return sRecharge;
	}


	public void setsRecharge(String sRecharge) {
		this.sRecharge = sRecharge;
	}


	public long getInvestment() {
		return investment;
	}


	public void setInvestment(long investment) {
		this.investment = investment;
		this.sInvestment = IntegerAndString.LongToString(investment);
	}


	public String getsInvestment() {
		return sInvestment;
	}


	public void setsInvestment(String sInvestment) {
		this.sInvestment = sInvestment;
	}


	public long getLoan() {
		return loan;
	}


	public void setLoan(long loan) {
		this.loan = loan;
		this.sLoan = IntegerAndString.LongToString(loan);
	}


	public String getsLoan() {
		return sLoan;
	}


	public void setsLoan(String sLoan) {
		this.sLoan = sLoan;
	}


	public long getWithdrawals() {
		return withdrawals;
	}


	public void setWithdrawals(long withdrawals) {
		this.withdrawals = withdrawals;
		this.sWithdrawals = IntegerAndString.LongToString(withdrawals);
	}


	public String getsWithdrawals() {
		return sWithdrawals;
	}


	public void setsWithdrawals(String sWithdrawals) {
		this.sWithdrawals = sWithdrawals;
	}


	public long getProfit() {
		return profit;
	}


	public void setProfit(long profit) {
		this.profit = profit;
		this.sProfit = IntegerAndString.LongToString(profit);
	}


	public String getsProfit() {
		return sProfit;
	}


	public void setsProfit(String sProfit) {
		this.sProfit = sProfit;
	}


	public long getIntegral() {
		return integral;
	}


	public void setIntegral(long integral) {
		this.integral = integral;
		this.sIntegral = IntegerAndString.LongToString(integral);
	}


	public String getsIntegral() {
		return sIntegral;
	}


	public void setsIntegral(String sIntegral) {
		this.sIntegral = sIntegral;
	}


	public int getAutomaticBidding() {
		return automaticBidding;
	}


	public void setAutomaticBidding(int automaticBidding) {
		this.automaticBidding = automaticBidding;
	}


	public int getAutomaticRepayment() {
		return automaticRepayment;
	}


	public void setAutomaticRepayment(int automaticRepayment) {
		this.automaticRepayment = automaticRepayment;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

