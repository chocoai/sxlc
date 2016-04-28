package cn.sxlc.account.manager.model;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/** 
 * 双乾开户接口返回参数定义
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-9 上午10:22:02  */
public class AccountInterfaceReturnEntity {
	private String accountType;//账户类型 0:企业 1：个人
	private String accountNumber;//多多号
	private String mobile;//手机号
	private String email;//邮箱
	private String realName;// 真实姓名/企业名
	private String identificationNo; //身份证号/营业执照号
	private String loanPlatformAccount;//用户在网贷平台的账号 
	private String moneymoremoreId;//用户的乾多多标识 
	private String platformMoneymoremore;//平台乾多多标识 
	private String authFee;//姓名匹配手续费 
	private String authState;//实名认证状态 
	private String randomTimeStamp; //
	private String remark1; 
	private String remark2; 
	private String remark3; 
	private String resultCode;//返回码
	private String message;//返回信息
	private String signInfo;//签名信息
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentificationNo() {
		return identificationNo;
	}
	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}
	public String getLoanPlatformAccount() {
		return loanPlatformAccount;
	}
	public void setLoanPlatformAccount(String loanPlatformAccount) {
		this.loanPlatformAccount = loanPlatformAccount;
	}
	public String getMoneymoremoreId() {
		return moneymoremoreId;
	}
	public void setMoneymoremoreId(String moneymoremoreId) {
		this.moneymoremoreId = moneymoremoreId;
	}
	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}
	public String getAuthFee() {
		return authFee;
	}
	public void setAuthFee(String authFee) {
		this.authFee = authFee;
	}
	public String getAuthState() {
		return authState;
	}
	public void setAuthState(String authState) {
		this.authState = authState;
	}
	public String getRandomTimeStamp() {
		return randomTimeStamp;
	}
	public void setRandomTimeStamp(String randomTimeStamp) {
		this.randomTimeStamp = randomTimeStamp;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSignInfo() {
		return signInfo;
	}
	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	private int statu;//处理返回状态；1：开户成功；2：开户失败
	public AccountInterfaceReturnEntity getAllAccount() throws UnsupportedEncodingException{
		ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.setCharacterEncoding("UTF-8");
		AccountInterfaceReturnEntity accountInterfaceReturnEntity=new AccountInterfaceReturnEntity();
		accountInterfaceReturnEntity.setResultCode(request.getParameter("ResultCode"));
		accountInterfaceReturnEntity.setMessage(request.getParameter("Message"));//开户状态信息
		String ReturnTimes = request.getParameter("ReturnTimes");//返回次数
		//开户成功
		if(request.getParameter("ResultCode")!=null 
				&& request.getParameter("ResultCode").equals("88")){
			accountInterfaceReturnEntity.setStatu(1);
			accountInterfaceReturnEntity.setLoanPlatformAccount(request.getParameter("LoanPlatformAccount"));
			
			accountInterfaceReturnEntity.setRemark1(request.getParameter("Remark1"));
			accountInterfaceReturnEntity.setRemark2(request.getParameter("Remark2"));
			accountInterfaceReturnEntity.setRemark3(request.getParameter("Remark3"));
			String accountType = request.getParameter("AccountType");// 开户类型
			if (accountType.equals("")) {
				accountInterfaceReturnEntity.setAccountType("1");// 个人
			} else if (accountType.equals("1")) {
				accountInterfaceReturnEntity.setAccountType("0");// 企业
			}
			accountInterfaceReturnEntity
				.setAccountNumber(request.getParameter("AccountNumber"));//乾多多数字账号
			accountInterfaceReturnEntity
				.setMoneymoremoreId(request.getParameter("MoneymoremoreId"));//用户的乾多多标识
			accountInterfaceReturnEntity
				.setAuthFee(request.getParameter("AuthFee"));//姓名匹配手续费
			accountInterfaceReturnEntity
				.setAuthState(request.getParameter("AuthState"));//实名认证状态1.未实名认证2.快捷支付认证3.其他认证
			accountInterfaceReturnEntity.setSignInfo(request.getParameter("SignInfo"));//签名信息
		
		}else {//开户失败
			accountInterfaceReturnEntity.setStatu(2);
		}
		
		
		return null;
	}
	
}

