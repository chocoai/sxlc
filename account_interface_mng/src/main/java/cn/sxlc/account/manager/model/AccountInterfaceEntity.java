package cn.sxlc.account.manager.model;


 

/** 
 * 关于乾多多第三方开户接口所需参数
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-7 下午2:25:15  */
public class AccountInterfaceEntity {
	private long id;//会员id
	private int memberType;//会员类型
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	private String registerType="2";//1表示全自动，2表示半自动 ;
	private String email;//邮箱
	private String phone;//手机
	private String name;//会员真实姓名 或企业名
	private String idcard;//身份证号 或  营业执照
	private String accountType;//开户类型  空表示个人账户  1表示企业账户
	private String PlatformMoneymoremore;//平台乾多多标识
	private String logName;//登陆名
	private String Remark1="";
	private String Remark2="";
	private String Remark3="";
	private String RandomTimeStamp="";
	private String SubmitURL = "";//提交双乾开户地址
	private String ReturnURL = "";//页面返回网址
	private String NotifyURL = "";// 后台通知网址
	private String signInfo = "";//加密抛送字符串
	private String isApp = "";//客户端（0：pc   1:app 2:微信）
	private int statu=0;//处理状态 0：成功 不等于0失败
	private String message;//处理信息
	
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPlatformMoneymoremore() {
		return PlatformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		PlatformMoneymoremore = platformMoneymoremore;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getRemark1() {
		return Remark1;
	}
	public void setRemark1(String remark1) {
		Remark1 = remark1;
	}
	public String getRemark2() {
		return Remark2;
	}
	public void setRemark2(String remark2) {
		Remark2 = remark2;
	}
	public String getRemark3() {
		return Remark3;
	}
	public void setRemark3(String remark3) {
		Remark3 = remark3;
	}
	public String getRandomTimeStamp() {
		return RandomTimeStamp;
	}
	public void setRandomTimeStamp(String randomTimeStamp) {
		RandomTimeStamp = randomTimeStamp;
	}
	public String getSubmitURL() {
		return SubmitURL;
	}
	public void setSubmitURL(String submitURL) {
		SubmitURL = submitURL;
	}
	public String getReturnURL() {
		return ReturnURL;
	}
	public void setReturnURL(String returnURL) {
		ReturnURL = returnURL;
	}
	public String getNotifyURL() {
		return NotifyURL;
	}
	public void setNotifyURL(String notifyURL) {
		NotifyURL = notifyURL;
	}
	public String getIsApp() {
		return isApp;
	}
	public void setIsApp(String isApp) {
		this.isApp = isApp;
	}
	public String getSignInfo() {
		return signInfo;
	}
	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	
}

