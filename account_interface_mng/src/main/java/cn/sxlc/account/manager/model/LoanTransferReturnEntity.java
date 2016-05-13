package cn.sxlc.account.manager.model;

import java.util.List;

/**
 * 第三方转账（投资、还款）返回信息处理
 *
 * @author ZZY
 * @Description: TODO
 * @date 2016-3-10 下午7:34:43
 */
public class LoanTransferReturnEntity {
    private String LoanJsonList;//转账列表
    private String PlatformMoneymoremore;//平台乾多多标识
    private String Action;//操作类型
    private String RandomTimeStamp;//
    private String Remark1;//
    private String Remark2;//
    private String Remark3;//
    private String ResultCode;//返回码
    private String Message;//返回信息
    private String ReturnTimes;
    private String SignInfo;//签名信息
    private List<LoanReturnInfoBean> loaninfolist;//转账参数集合
    private List<Object> loaninfolists;//转账参数集合
    public List<Object> getLoaninfolists() {
		return loaninfolists;
	}

	public void setLoaninfolists(List<Object> loaninfolists) {
		this.loaninfolists = loaninfolists;
	}

	private int statu;//转账状态；0成功 1失败

	/*public LoanTransferReturnEntity findLoanList() throws UnsupportedEncodingException{
		LoanTransferReturnEntity 
			loanTransferReturnEntity=new LoanTransferReturnEntity();
		ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.setCharacterEncoding("UTF-8");
		loanTransferReturnEntity.
			setResultCode(request.getParameter("ResultCode"));
		loanTransferReturnEntity
			.setMessage(request.getParameter("Message"));//返回信息
		if(loanTransferReturnEntity.getResultCode()!=null){
			if (loanTransferReturnEntity.getResultCode().equals("88")) {
				loanTransferReturnEntity.setStatu(0);
				loanTransferReturnEntity
				.setLoanJsonList(request.getParameter("LoanJsonList"));
				String fah = request.getParameter("LoanJsonList");
				fah = Common.UrlDecoder(fah, "utf-8");
				List<Object> loaninfolist = Common.JSONDecodeList(fah,
						LoanReturnInfoBean.class);
				loanTransferReturnEntity.setLoaninfolist(loaninfolist);//需要处理的转账信息
				loanTransferReturnEntity
				.setPlatformMoneyMoreMore(request.getParameter("PlatformMoneymoremore"));
				loanTransferReturnEntity
				.setRemark1(request.getParameter("Remark1"));
				loanTransferReturnEntity
				.setRemark2(request.getParameter("Remark2"));
				loanTransferReturnEntity
				.setRemark3(request.getParameter("Remark3"));
			}else {
				loanTransferReturnEntity.setStatu(1);
			}
		}else {
			loanTransferReturnEntity.setStatu(1);
		}
		return loanTransferReturnEntity;
	}*/

    public String getLoanJsonList() {
        return LoanJsonList;
    }

    public void setLoanJsonList(String loanJsonList) {
        LoanJsonList = loanJsonList;
    }

    public String getPlatformMoneymoremore() {
        return PlatformMoneymoremore;
    }

    public void setPlatformMoneymoremore(String platformMoneymoremore) {
        PlatformMoneymoremore = platformMoneymoremore;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
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

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getReturnTimes() {
        return ReturnTimes;
    }

    public void setReturnTimes(String returnTimes) {
        ReturnTimes = returnTimes;
    }

    public String getSignInfo() {
        return SignInfo;
    }

    public void setSignInfo(String signInfo) {
        SignInfo = signInfo;
    }

    public List<LoanReturnInfoBean> getLoaninfolist() {
        return loaninfolist;
    }

    public void setLoaninfolist(List<LoanReturnInfoBean> loaninfolist) {
        this.loaninfolist = loaninfolist;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

	@Override
	public String toString() {
		return "LoanTransferReturnEntity [LoanJsonList=" + LoanJsonList
				+ ", PlatformMoneymoremore=" + PlatformMoneymoremore
				+ ", Action=" + Action + ", RandomTimeStamp=" + RandomTimeStamp
				+ ", Remark1=" + Remark1 + ", Remark2=" + Remark2
				+ ", Remark3=" + Remark3 + ", ResultCode=" + ResultCode
				+ ", Message=" + Message + ", ReturnTimes=" + ReturnTimes
				+ ", SignInfo=" + SignInfo + ", loaninfolist=" + loaninfolist
				+ ", loaninfolists=" + loaninfolists + ", statu=" + statu + "]";
	}

}

