
package cn.sxlc.account.manager.model; 

/** 
 * 第三方转账（投资、还款）信息提交
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-10 下午6:36:03  */
public class LoanTransferEntity {
	private String loanJsonList;//转账列表
	private String platformMoneymoremore;//平台乾多多标识
	private String transferAction;//转账类型 1.投标 2.还款3.其他
	private String action;//操作类型  1.手动转账  2.自动转账
	private String transferType;//转账方式 1.桥连 2.直连
	private String needAudit;//通过是否需要审核  空.需要审核 1.自动通过
	private String delayTransfer;//是否半自动批处理(暂不可用)
	private String randomTimeStamp;//
	private String remark1;//
	private String remark2;//
	private String remark3;//
	private String submitURL;//提交地址
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String signInfo;//签名信息
	private int statu;//转账信息处理状态  0成功 1失败
	public String getLoanJsonList() {
		return loanJsonList;
	}
	public void setLoanJsonList(String loanJsonList) {
		this.loanJsonList = loanJsonList;
	}
	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}
	public String getTransferAction() {
		return transferAction;
	}
	public void setTransferAction(String transferAction) {
		this.transferAction = transferAction;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getNeedAudit() {
		return needAudit;
	}
	public void setNeedAudit(String needAudit) {
		this.needAudit = needAudit;
	}
	public String getDelayTransfer() {
		return delayTransfer;
	}
	public void setDelayTransfer(String delayTransfer) {
		this.delayTransfer = delayTransfer;
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
	public String getSubmitURL() {
		return submitURL;
	}
	public void setSubmitURL(String submitURL) {
		this.submitURL = submitURL;
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
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}

