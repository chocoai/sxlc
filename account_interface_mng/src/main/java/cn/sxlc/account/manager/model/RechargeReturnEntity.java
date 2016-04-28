
package cn.sxlc.account.manager.model; 

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** 
 * 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-9 下午3:25:47  */
public class RechargeReturnEntity {
	private String rechargeMoneymoremore;//充值人乾多多标识
	private String platformMoneymoremore;//平台乾多多标识
	private String loanNo;//乾多多流水号
	private String orderNo;//平台的充值订单号
	private String amount;//充值金额
	private String fee;//用户承担手续费
	private String feePlatform;//平台承担手续费
	private String rechargeType;//双乾充值类型  空.网银充值  1.代扣充值(暂不可用)2.快捷支付3.汇款充值4.企业网银
	//手续费类型
	//1.充值成功时从充值人账户全额扣除2.充值成功时从平台自有账户全额扣除
	//3.充值成功时从充值人账户扣除与提现手续费的差4.充值成功时从平台自有账户扣除与提现手续费的差值 
	//快捷支付、汇款充值、企业网银必填，其他类型留空
	private String feeType; 
	private String cardNoList="";//当前绑定的银行卡号列表
	private String randomTimeStamp="";
	private String remark1;
	private String remark2;
	private String remark3;
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String signInfo;//签名信息
	private String resultCode;//返回码
	private String message;//返回信息
	private int statu;//充值状态 0：成功 ;1：失败 ;2:汇款充值信息提交成功，等待双乾财务确定处理
	
	
	/** 
	* rechargeReturnData 充值第三方返回信息整合 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: rechargeReturnData 
	* @Description: TODO 
	* @param @return
	* @param @throws UnsupportedEncodingException 设定文件 
	* @return RechargeReturnEntity 返回类型 
	* @throws 
	*/
	public RechargeReturnEntity rechargeReturnData() throws UnsupportedEncodingException{
		ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.setCharacterEncoding("UTF-8");
		RechargeReturnEntity rechargeReturnEntity=new RechargeReturnEntity();
		rechargeReturnEntity.setResultCode(request.getParameter("ResultCode"));
		rechargeReturnEntity.setMessage(request.getParameter("Message"));//充值返回信息
		String ResultCode=request.getParameter("ResultCode");
		if(ResultCode!=null ){
			if(ResultCode.equals("88") || ResultCode.equals("90")){
				if(ResultCode.equals("88") && request.getParameter("RechargeType").equals(3)){//汇款充值信息提交成功等待处理
					rechargeReturnEntity.setStatu(2);
				}else{
					rechargeReturnEntity.setStatu(0);
				}
				rechargeReturnEntity.setAmount(request.getParameter("Amount"));
				rechargeReturnEntity.setCardNoList(request.getParameter("CardNoList"));
				rechargeReturnEntity.setFee(request.getParameter("Fee"));
				rechargeReturnEntity.setFeeType(request.getParameter("FeeType"));
				rechargeReturnEntity.setFeePlatform(request.getParameter("FeePlatform"));
				rechargeReturnEntity.setLoanNo(request.getParameter("LoanNo"));
				rechargeReturnEntity.setNotifyURL(request.getParameter("NotifyURL"));
				rechargeReturnEntity.setOrderNo(request.getParameter("OrderNo"));
				rechargeReturnEntity.setPlatformMoneymoremore(request.getParameter("PlatformMoneymoremore"));
				rechargeReturnEntity.setRechargeMoneymoremore(request.getParameter("RechargeMoneymoremore"));
				rechargeReturnEntity.setRechargeType(request.getParameter("RechargeType"));
				rechargeReturnEntity.setRemark1(request.getParameter("Remark1"));
				rechargeReturnEntity.setRemark2(request.getParameter("Remark2"));
				rechargeReturnEntity.setRemark3(request.getParameter("Remark3"));
				rechargeReturnEntity.setSignInfo(request.getParameter("SignInfo"));
				rechargeReturnEntity.setReturnURL(request.getParameter("ReturnURL"));
			}else{
				rechargeReturnEntity.setStatu(1);
			}
		}else{
			rechargeReturnEntity.setStatu(1);
		}
		
		return rechargeReturnEntity;
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
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
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
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getFeePlatform() {
		return feePlatform;
	}
	public void setFeePlatform(String feePlatform) {
		this.feePlatform = feePlatform;
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
	public String getCardNoList() {
		return cardNoList;
	}
	public void setCardNoList(String cardNoList) {
		this.cardNoList = cardNoList;
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
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}

