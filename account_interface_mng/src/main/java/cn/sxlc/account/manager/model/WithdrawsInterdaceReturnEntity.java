
package cn.sxlc.account.manager.model; 


/** 
 * 第三方接口提现提交信息
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-9 下午7:19:35  */
public class WithdrawsInterdaceReturnEntity {
	private String withdrawMoneymoremore;//提现人乾多多标识
	private String loanNo;//乾多多流水号
	private String feeMax;//用户承担的最高手续费
	private String feeWithdraws;//用户实际承担的手续费金额
	private String feePercent;//平台承担的手续费比例
	private String fee;//平台承担的手续费金额
	private String freeLimit;//平台扣除的免费提现额
	private String feeRate;//上浮费率
	private String feeSplitting;//平台分润
	private String eesultCode;//返回码
	private String message;//返回信息
	private String returnTimes;//返回次数
	private String platformMoneymoremore;//平台乾多多标识
	private String orderNo;//平台的提现订单号
	private String amount;//金额
	private String randomTimeStamp;
	private String remark1;
	private String remark2;
	private String remark3;
	private String submitUrl;//提交第三方提现网址
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String signInfo;//签名信息
	private int statu;//提现状态 0：提现申请成功，等待平台审核  1：提现成功 2：提现失败3:提现银行退回
	
//	public WithdrawsInterdaceReturnEntity mentionReturnInformation() throws UnsupportedEncodingException{
//		ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		request.setCharacterEncoding("UTF-8");
//		WithdrawsInterdaceReturnEntity 
//			withdrawsInterdaceReturnEntity=new WithdrawsInterdaceReturnEntity();
//		String ResultCode = request.getParameter("ResultCode");
//		String Message = request.getParameter("Message");
//		if(ResultCode!=null){
//			if (ResultCode.equals("88") || ResultCode.equals("90") || ResultCode.equals("89")) {//提现信息提交成功
//				withdrawsInterdaceReturnEntity.setMessage(Message);
//				withdrawsInterdaceReturnEntity.setWithdrawMoneymoremore(request.getParameter("WithdrawMoneymoremore"));
//				withdrawsInterdaceReturnEntity.setPlatformMoneymoremore(request.getParameter("PlatformMoneymoremore"));
//				withdrawsInterdaceReturnEntity.setLoanNo(request.getParameter("LoanNo"));
//				withdrawsInterdaceReturnEntity.setOrderNo(request.getParameter("OrderNo"));
//				withdrawsInterdaceReturnEntity.setAmount(request.getParameter("Amount"));
//				withdrawsInterdaceReturnEntity.setFeeMax(request.getParameter("FeeMax"));
//				withdrawsInterdaceReturnEntity.setFeeWithdraws(request.getParameter("FeeWithdraws"));
//				withdrawsInterdaceReturnEntity.setFeePercent(request.getParameter("FeePercent"));
//				withdrawsInterdaceReturnEntity.setFee(request.getParameter("Fee"));
//				withdrawsInterdaceReturnEntity.setFreeLimit(request.getParameter("FreeLimit"));
//				withdrawsInterdaceReturnEntity.setFeeRate(request.getParameter("FeeRate"));
//				withdrawsInterdaceReturnEntity.setFeeSplitting(request.getParameter("FeeSplitting"));
//				withdrawsInterdaceReturnEntity.setRandomTimeStamp(request.getParameter("RandomTimeStamp"));
//				withdrawsInterdaceReturnEntity.setRemark1(request.getParameter("Remark1"));
//				withdrawsInterdaceReturnEntity.setRemark2(request.getParameter("Remark2"));
//				withdrawsInterdaceReturnEntity.setRemark3(request.getParameter("Remark3"));
//				withdrawsInterdaceReturnEntity.setReturnTimes(request.getParameter("ReturnTimes"));
//				withdrawsInterdaceReturnEntity.setSignInfo(request.getParameter("SignInfo"));
//				if(ResultCode.equals("88")){//提现成功
//					withdrawsInterdaceReturnEntity.setStatu(1);
//				}else if(ResultCode.equals("90")){//提现申请成功，等待平台审核
//					withdrawsInterdaceReturnEntity.setStatu(0);
//				}else {
//					withdrawsInterdaceReturnEntity.setStatu(3);//提现银行退回
//				}
//			}else {
//				withdrawsInterdaceReturnEntity.setStatu(2);
//				withdrawsInterdaceReturnEntity.setMessage(Message);
//			}
//		}
//		
//		return withdrawsInterdaceReturnEntity;
//	}
	
	
	
	



	public int getStatu() {
		return statu;
	}



	public void setStatu(int statu) {
		this.statu = statu;
	}







	public String getWithdrawMoneymoremore() {
		return withdrawMoneymoremore;
	}







	public void setWithdrawMoneymoremore(String withdrawMoneymoremore) {
		this.withdrawMoneymoremore = withdrawMoneymoremore;
	}







	public String getLoanNo() {
		return loanNo;
	}







	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}







	public String getFeeMax() {
		return feeMax;
	}







	public void setFeeMax(String feeMax) {
		this.feeMax = feeMax;
	}







	public String getFeeWithdraws() {
		return feeWithdraws;
	}







	public void setFeeWithdraws(String feeWithdraws) {
		this.feeWithdraws = feeWithdraws;
	}







	public String getFeePercent() {
		return feePercent;
	}







	public void setFeePercent(String feePercent) {
		this.feePercent = feePercent;
	}







	public String getFee() {
		return fee;
	}







	public void setFee(String fee) {
		this.fee = fee;
	}







	public String getFreeLimit() {
		return freeLimit;
	}







	public void setFreeLimit(String freeLimit) {
		this.freeLimit = freeLimit;
	}







	public String getFeeRate() {
		return feeRate;
	}







	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}







	public String getFeeSplitting() {
		return feeSplitting;
	}







	public void setFeeSplitting(String feeSplitting) {
		this.feeSplitting = feeSplitting;
	}







	public String getEesultCode() {
		return eesultCode;
	}







	public void setEesultCode(String eesultCode) {
		this.eesultCode = eesultCode;
	}







	public String getMessage() {
		return message;
	}







	public void setMessage(String message) {
		this.message = message;
	}







	public String getReturnTimes() {
		return returnTimes;
	}







	public void setReturnTimes(String returnTimes) {
		this.returnTimes = returnTimes;
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







	public String getSubmitUrl() {
		return submitUrl;
	}







	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
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
	
}

