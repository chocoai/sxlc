package cn.sxlc.account.manager.model;


/**
 * 第三方 放款、提现审核接口返回信息
 *
 * @author ZZY
 * @Description: TODO
 * @date 2016-3-10 下午4:19:43
 */
public class AuditReturnEntity {
    private String loanNoList;//乾多多流水号列表
    private String loanNoListFail;//有问题的的乾多多流水号列表
    private String platformMoneyMoreMore;//平台乾多多标识
    private String platformMoneymoremore;
    private String auditType;//审核类型 1.通过 2.退回  5.提现通过6.提现退回
    private String delayTransfer;//是否半自动批处理(暂不可用)
    private String randomTimeStamp;//
    private String remark1;//
    private String remark2;//
    private String remark3;//
    private String returnURL;//
    private String notifyURL;//
    private String signInfo;//
    private String resultCode;//返回码
    private String message;//返回信息
    private String returnTimes;//返回次数
    private int statu;//操作状态：0 成功；1 失败

    public String getLoanNoList() {
        return loanNoList;
    }

    public void setLoanNoList(String loanNoList) {
        this.loanNoList = loanNoList;
    }

    public String getLoanNoListFail() {
        return loanNoListFail;
    }

    public void setLoanNoListFail(String loanNoListFail) {
        this.loanNoListFail = loanNoListFail;
    }

    public String getPlatformMoneyMoreMore() {
        return platformMoneyMoreMore;
    }

    public void setPlatformMoneyMoreMore(String platformMoneyMoreMore) {
        this.platformMoneyMoreMore = platformMoneyMoreMore;
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

    public String getReturnTimes() {
        return returnTimes;
    }

    public void setReturnTimes(String returnTimes) {
        this.returnTimes = returnTimes;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}

	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}


}

