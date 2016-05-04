package cn.membermng.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;





/***
 * 会员对象实体
 * @author LiJie
 *
 */
public class MemberInfo {
	
	
	private Long 		id;						//序号
	private Long        memberId;	  			
	private Integer		memberType;				//会员类型
	private String		memberNo;				//会员编号
	@NotNull(message="用户名必须填写")
	@Pattern(regexp="^(([0-9]{1,}(?=[a-zA-z_]+))|([a-zA-Z]{1,}(?=[0-9_]+)))",message="用户名由6~16位的数字、字母、或汉字至少包含2种组成")
	private String		logname;				//会员登录名
	@NotNull(message="密码不能为空")
	private String		memberPwd;				//会员密码
	@NotNull(message="确认密码不能为空")
	private String		confirmPassword;		//会员密码
	private String		safePwd;				//会员安全密码
	private Long		companyId;				//企业信息编号
	private CompanyInfo	companyInfo;
	private Long		personalId;				//个人信息编号
	
	private String      personalName;			//会员姓名+
	private String		personalIdCard;			//会员身份证  +
	private String 		personalPhone;			//注册会员电话+
	private String      personalEmail;			//注册会员邮箱+
	
	private String      regClient;		  	  //注册客户端+
	
	
	
	private String		thirdPartyAccount;		//用户第三方账户
	private long        userBalance	;   		//第三方账户金额
	private String		sUserBalance;			//第三方账户金额
	private long        frozen;					//第三方账户冻结金额
	private String		sFrozen;				//第三方账户冻结金额
	
	
	/************************借款会员**********************************/
	private   long   	borrow;			//在借金额
	private   String    sBorrow;		//在借金额
	private   long  	settled;		//已结清金额
	private   String    sSettled;		//已结清金额
	private   long   	overdue;		//逾期次数
	private   long   	recharge;		//充值
	private   String    sRecharge;		//充值
	private   long      withdrawals;	//提现
	private   String    sWithdrawals;	//提现
	private  long       cjplatform;		//充值手续费平台
	private String		sCjplatform;	//充值手续费平台
	private long        cjmember ;		//充值手续费会员
	private String		sCjmember;		//充值手续费会员
	private long		loanManager;	//借款管理费
	private String		sLoanManager;	//借款管理费
	private long		txplatform;		//提现手续费平台
	private String      sTxplatform;	//提现手续费平台	
	private long 		txmember;		//提现手续费会员号
	private String      sTxmember; 		//提现手续费会员号
	private long        loan;          //借款总额
	private String      sLoan;			//借款总额
	/************************投资会员**********************************/
	private long        investment;				//投资总额
	private String      sInvestment;			//投资总额
	private long        managerFee;				//收益管理费
	private String 		sManagerFee;			//收益管理费
	/**********************************************************/
	
	/************************复合会员**********************************/
	private long        noRrturn;				//累计逾期未还本金
	private String      sNoReturn;			  //累计逾期未还本金
	private long        noIntrest;				//累计逾期未还利息
	private String 		sNoInterest;			//累计逾期未还利息
	/**********************************************************/
	
	//会员黑名单······································································
	private Integer		count;					//拉黑次数	
	private Date        lastBlack;				//最后一次拉黑时间
	private String      sLastBlack;				//最后一次拉黑时间
	//---
	private PersonalBaseInfo baseInfo;
	private String		path;					//头像路径
	private String		invitateCode;			//邀请码
	private String		beinvitateCode;			//被邀请码
	private Integer		provinceId;				//所属省份
	private String		provinceName;			//
	private Integer		cityId;					//所属市区
	private String		cityName;				//
	private Integer		countyId;				//所属区县
	private String		countyName;				//
	private Integer		townId;					//所属乡镇
	private String		townName;				//
	private Integer		integral;				//当前积分
	private Integer		creditIntegral;			//当前信用积分
	
	
	private Date		regDate;				//注册时间
	private String      sRegDate;				//注册时间
	private Date		recordDate;				//第三方开通时间
	private String 	    sRcordDate;				//第三方开通时间
	
	public MemberInfo() {}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
		this.memberId = id;
	}


	public Long getMemberId() {
		return memberId;
	}

	public Integer getMemberType() {
		return memberType;
	}


	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getLogname() {
		return logname;
	}


	public void setLogname(String logname) {
		this.logname = logname;
	}


	public String getMemberPwd() {
		return memberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}


	public String getSafePwd() {
		return safePwd;
	}


	public void setSafePwd(String safePwd) {
		this.safePwd = safePwd;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public Long getPersonalId() {
		return personalId;
	}


	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

	public String getInvitateCode() {
		return invitateCode;
	}


	public void setInvitateCode(String invitateCode) {
		this.invitateCode = invitateCode;
	}


	public String getBeinvitateCode() {
		return beinvitateCode;
	}


	public void setBeinvitateCode(String beinvitateCode) {
		this.beinvitateCode = beinvitateCode;
	}


	public Integer getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public Integer getCountyId() {
		return countyId;
	}


	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}


	public Integer getTownId() {
		return townId;
	}


	public void setTownId(Integer townId) {
		this.townId = townId;
	}


	public Integer getIntegral() {
		return integral;
	}


	public void setIntegral(Integer integral) {
		this.integral = integral;
	}


	public Integer getCreditIntegral() {
		return creditIntegral;
	}


	public void setCreditIntegral(Integer creditIntegral) {
		this.creditIntegral = creditIntegral;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public PersonalBaseInfo getBaseInfo() {
		return baseInfo;
	}


	public void setBaseInfo(PersonalBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}


	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}


	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		this.sRegDate = TimestampAndString.DateToString(regDate);
	}

	public String getsRegDate() {
		return sRegDate;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRcordDate = TimestampAndString.DateToString(recordDate);
	}

	public String getsRcordDate() {
		return sRcordDate;
	}

	public String getPersonalIdCard() {
		return personalIdCard;
	}

	public void setPersonalIdCard(String personalIdCard) {
		this.personalIdCard = personalIdCard;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getRegClient() {
		return regClient;
	}

	public void setRegClient(String regClient) {
		this.regClient = regClient;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public long getBorrow() {
		return borrow;
	}

	public void setBorrow(long borrow) {
		this.borrow = borrow;
		this.sBorrow =  IntegerAndString.LongToString(borrow);
	}

	public String getsBorrow() {
		return sBorrow;
	}

	public long getSettled() {
		return settled;
	}

	public void setSettled(long settled) {
		this.settled = settled;
		this.sSettled = IntegerAndString.LongToString(settled);
	}

	public String getsSettled() {
		return sSettled;
	}


	public long getOverdue() {
		return overdue;
	}

	public long getRecharge() {
		return recharge;
	}

	public void setRecharge(long recharge) {
		this.recharge = recharge;
		this.sRecharge =IntegerAndString.LongToString(recharge);
	}

	public String getsRecharge() {
		return sRecharge;
	}

	public long getCjplatform() {
		return cjplatform;
	}

	public void setCjplatform(long cjplatform) {
		this.cjplatform = cjplatform;
		this.sCjplatform = IntegerAndString.LongToString(cjplatform);
	}

	public String getsCjplatform() {
		return sCjplatform;
	}

	public void setsCjplatform(String sCjplatform) {
		this.sCjplatform = sCjplatform;
	}

	public long getCjmember() {
		return cjmember;
	}

	public void setCjmember(long cjmember) {
		this.cjmember = cjmember;
		this.sCjmember = IntegerAndString.LongToString(cjmember);
	}

	public String getsCjmember() {
		return sCjmember;
	}


	public long getLoanManager() {
		return loanManager;
	}

	public void setLoanManager(long loanManager) {
		this.loanManager = loanManager;
		this.sLoanManager = IntegerAndString.LongToString(loanManager);
	}

	public String getsLoanManager() {
		return sLoanManager;
	}

	public long getTxplatform() {
		return txplatform;
	}

	public void setTxplatform(long txplatform) {
		this.txplatform  = txplatform;
		this.sTxplatform = IntegerAndString.LongToString(txplatform);
	}

	public String getsTxplatform() {
		return sTxplatform;
	}

	public long getTxmember() {
		return txmember;
	}

	public void setTxmember(long txmember) {
		this.txmember = txmember;
		this.sTxmember = IntegerAndString.LongToString(txmember);
	}

	public String getsTxmember() {
		return sTxmember;
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

	public long getLoan() {
		return loan;
	}

	public void setLoan(long loan) {
		this.loan = loan;
		this.sLoan =  IntegerAndString.LongToString(loan);
	}

	public String getsLoan() {
		return sLoan;
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
		this.sUserBalance =  IntegerAndString.LongToString(userBalance);
	}

	public String getsUserBalance() {
		return sUserBalance;
	}

	public long getFrozen() {
		return frozen;
	}

	public void setFrozen(long frozen) {
		this.frozen = frozen;
		this.sFrozen =  IntegerAndString.LongToString(frozen);
	}

	public String getsFrozen() {
		return sFrozen;
	}

	public long getManagerFee() {
		return managerFee;
	}

	public void setManagerFee(long managerFee) {
		this.managerFee = managerFee;
		this.sManagerFee = IntegerAndString.LongToString(managerFee);
	}

	public String getsManagerFee() {
		return sManagerFee;
	}

	public long getInvestment() {
		return investment;
	}

	public void setInvestment(long investment) {
		this.investment = investment;
		this.sInvestment =  IntegerAndString.LongToString(investment);
	}

	public String getsInvestment() {
		return sInvestment;
	}

	public long getNoRrturn() {
		return noRrturn;
	}

	public void setNoRrturn(long noRrturn) {
		this.noRrturn = noRrturn;
		this.sNoReturn = IntegerAndString.LongToString(noRrturn);
	}

	public String getsNoReturn() {
		return sNoReturn;
	}


	public long getNoIntrest() {
		return noIntrest;
	}

	public void setNoIntrest(long noIntrest) {
		this.noIntrest = noIntrest;
		this.sNoInterest =IntegerAndString.LongToString(noIntrest);
	}

	public String getsNoInterest() {
		return sNoInterest;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getLastBlack() {
		return lastBlack;
	}

	public void setLastBlack(Date lastBlack) {
		this.lastBlack = lastBlack;
		this.sLastBlack = TimestampAndString.DateToString(lastBlack);
	}

	public String getsLastBlack() {
		return sLastBlack;
	}

}
