
package cn.sxlc.account.manager.model; 

/** 
 * 第三方充值提交参数
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-9 下午2:34:51  */
public class RechargeEntity {
	private long   memberId;//充值会员id
	private int	   memberType;//充值会员类型 0：个人会员 1：企业会员 2：担保机构 3：平台
	private int    isApp;//0：PC,1:手机app 2:微信
	private String rechargeMoneymoremore;//充值人乾多多标识
	private String platformMoneymoremore;//平台乾多多标识
	private String orderNo;//平台的充值订单号
	private String amount;//充值金额
	private String rechargeType;//双乾充值类型  空.网银充值  1.代扣充值(暂不可用)2.快捷支付3.汇款充值4.企业网银
	//手续费类型
	//1.充值成功时从充值人账户全额扣除2.充值成功时从平台自有账户全额扣除
	//3.充值成功时从充值人账户扣除与提现手续费的差4.充值成功时从平台自有账户扣除与提现手续费的差值 
	//快捷支付、汇款充值、企业网银必填，其他类型留空
	private String feeType; 
	
	private String cardNo="";//银行卡号  可不填
	private String randomTimeStamp="";
	private String remark1;
	private String remark2;
	private String remark3;//充值会员前台填写的备注
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String submitURL;//充值信息提交地址
	private String signInfo;//签名信息
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getRechargeMoneymoremore() {
		return rechargeMoneymoremore;
	}
	public void setRechargeMoneymoremore(String rechargeMoneymoremore) {
		this.rechargeMoneymoremore = rechargeMoneymoremore;
	}
	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRechargeType() {
		return rechargeType;
	}
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
	public String getReturnURL() {
		return returnURL;
	}
	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}
	public String getNotifyURL() {
		return notifyURL;
	}
	public void setNotifyURL(String notifyURL) {
		this.notifyURL = notifyURL;
	}
	public String getSignInfo() {
		return signInfo;
	}
	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}
	
	public String getSubmitURL() {
		return submitURL;
	}
	public void setSubmitURL(String submitURL) {
		this.submitURL = submitURL;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public int getIsApp() {
		return isApp;
	}
	public void setIsApp(int isApp) {
		this.isApp = isApp;
	}
	
}

