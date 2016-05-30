
package cn.sxlc.account.manager.model; 

/** 
 * 第三方接口提现提交信息
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-9 下午7:19:35  */
public class WithdrawsInterdaceEntity {
	private long   memberId;//会员id
	private int    memberType;//会员类型
	private long   cardId;//银行卡信息id
	private String submitURL;//提现提交接口
	private String WithdrawMoneymoremore;//提现人乾多多标识
	private String PlatformMoneymoremore;//平台乾多多标识
	private String OrderNo;//平台的提现订单号
	private String Amount;//金额
	private String FeeQuota="";//用户承担的定额手续费
	private String sPtRate="";			//平台支付第三方手续费比例
	private String sUserFee="";		//用户承担的最高手续费
	private String sFeeRate="";		//上浮费率
	private String CardNo;//银行卡号
	private String CardType;//银行卡类型
	private String BankCode;//银行代码
	private String BranchBankName;//开户行支行名称
	private String Province;//开户行省份
	private String City;//开户行城市
	private String RandomTimeStamp="";
	private String Remark1="";
	private String Remark2="";
	private String Remark3="";
	private String SubmitUrl;//提交第三方提现网址
	private String ReturnURL;//页面返回网址
	private String NotifyURL;//后台通知网址
	private String SignInfo;//签名信息
	private int statu=0;//0:成功 1：拉黑会员禁止提现
	public String getWithdrawMoneymoremore() {
		return WithdrawMoneymoremore;
	}
	public void setWithdrawMoneymoremore(String withdrawMoneymoremore) {
		WithdrawMoneymoremore = withdrawMoneymoremore;
	}
	public String getPlatformMoneymoremore() {
		return PlatformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		PlatformMoneymoremore = platformMoneymoremore;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getFeeQuota() {
		return FeeQuota;
	}
	public void setFeeQuota(String feeQuota) {
		FeeQuota = feeQuota;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getBankCode() {
		return BankCode;
	}
	public void setBankCode(String bankCode) {
		BankCode = bankCode;
	}
	public String getBranchBankName() {
		return BranchBankName;
	}
	public void setBranchBankName(String branchBankName) {
		BranchBankName = branchBankName;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getRandomTimeStamp() {
		return RandomTimeStamp;
	}
	public void setRandomTimeStamp(String randomTimeStamp) {
		RandomTimeStamp = randomTimeStamp;
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
	public String getSubmitUrl() {
		return SubmitUrl;
	}
	public void setSubmitUrl(String submitUrl) {
		SubmitUrl = submitUrl;
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
	public String getSignInfo() {
		return SignInfo;
	}
	public void setSignInfo(String signInfo) {
		SignInfo = signInfo;
	}
	public String getsPtRate() {
		return sPtRate;
	}
	public void setsPtRate(String sPtRate) {
		this.sPtRate = sPtRate;
	}
	public String getsUserFee() {
		return sUserFee;
	}
	public void setsUserFee(String sUserFee) {
		this.sUserFee = sUserFee;
	}
	public String getsFeeRate() {
		return sFeeRate;
	}
	public void setsFeeRate(String sFeeRate) {
		this.sFeeRate = sFeeRate;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	public String getSubmitURL() {
		return submitURL;
	}
	public void setSubmitURL(String submitURL) {
		this.submitURL = submitURL;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}

