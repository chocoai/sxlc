package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/***
* 会员列表 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 上午10:55:51 
*
*/
public class VIPMemberInfos {

	private long 					memberId				;//会员编号
	private String					memberNo				;//
	private String					userName				;//会员姓名
	private String					memberName				;//会员登录名
	private String					memberPhone				;//会员手机号
	private String					provinceName			;//省名称
	private String					cityName				;//市名称
	private String					countyName				;//城市名称
	private String					townName				;//街道名称
	private String					thirdPartyAccount		;//第三方账户
	private long					userBalance				;//账户可用余额
	private String					sUserBalance			;//
	private long					frozen					;//账户冻结金额
	private String					sFrozen					;//
	private long					recharge				;//充值总金额
	private String					sRecharge				;//
	private long					investment				;//投资总金额
	private String					sInvestment				;//
	private long					loan					;//借款总额
	private String					sLoan					;//
	private long					withdrawals				;//提现总额
	private String					sWithdrawals			;//
	
	
	public VIPMemberInfos() {}


	public VIPMemberInfos(long memberId, String memberNo, String userName,
			String memberName, String memberPhone, String provinceName,
			String cityName, String countyName, String townName,
			String thirdPartyAccount, long userBalance, String sUserBalance,
			long frozen, String sFrozen, long recharge, String sRecharge,
			long investment, String sInvestment, long loan, String sLoan,
			long withdrawals, String sWithdrawals) {
		super();
		this.memberId = memberId;
		this.memberNo = memberNo;
		this.userName = userName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.countyName = countyName;
		this.townName = townName;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

