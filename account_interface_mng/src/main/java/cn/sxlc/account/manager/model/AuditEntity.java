package cn.sxlc.account.manager.model;


/** 
 * 第三方 放款、提现审核接口提交信息
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-10 下午4:19:43  */
public class AuditEntity {
	private long   pid;//操作项目id 项目id 债权转让id 提现申请记录id
	private int    stype;//操作类型 1：项目 2：债权 3：提现
	private String loanNoList;//乾多多流水号列表
	private String platformMoneymoremore;//平台乾多多标识
	private String auditType;//审核类型 1：放款 2：流标  5：提现通过 6：提现退回
	private String delayTransfer;//是否半自动批处理(暂不可用)
	private String randomTimeStamp;//
	private String remark1;//
	private String remark2;//
	private String remark3;//
	private String submitURL;//提交三方地址
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String signInfo;//签名信息
	
	private int statu=1;//信息处理返回： 1：处理成功  -1：无投资流标成功
	public String getLoanNoList() {
		return loanNoList;
	}
	public void setLoanNoList(String loanNoList) {
		this.loanNoList = loanNoList;
	}
	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
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
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public int getStype() {
		return stype;
	}
	public void setStype(int stype) {
		this.stype = stype;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}

