package cn.account_interface_mng.model; 

import java.util.List;

/** 
 * 第三方转账（投资、还款）信息提交
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-10 下午6:36:03  */
public class TransferSubmitEntity {
	private String platformMoneymoremore;//平台乾多多标识
	private String transferAction;//转账类型 1.投标 2.还款3.其他
	private String action;//操作类型  1.手动转账  2.自动转账
	private String randomTimeStamp;//
	private String remark1;//备注;可拼接此次转账需处理信息 如：会员id、红包id
	private String remark2;//备注;可拼接此次转账需处理信息 如：会员id
	private String remark3;//备注;可拼接此次转账需处理信息 如：会员id
	private String submitURL;//提交地址
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private List<LoanInfoBeanSubmit> loanInfoBeanSubmits;//转账列表集合
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
	public List<LoanInfoBeanSubmit> getLoanInfoBeanSubmits() {
		return loanInfoBeanSubmits;
	}
	public void setLoanInfoBeanSubmits(List<LoanInfoBeanSubmit> loanInfoBeanSubmits) {
		this.loanInfoBeanSubmits = loanInfoBeanSubmits;
	}
	
}

