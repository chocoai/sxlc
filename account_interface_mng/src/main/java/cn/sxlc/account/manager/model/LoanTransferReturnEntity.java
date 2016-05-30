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
    private String loanJsonList;//转账列表
    private String platformMoneymoremore;//平台乾多多标识
    private String action;//操作类型
    private String randomTimeStamp;//
    private String remark1;//
    private String remark2;//
    private String remark3;//
    private String resultCode;//返回码
    private String message;//返回信息
    private String returnTimes;
    private String signInfo;//签名信息
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

	public String getSignInfo() {
		return signInfo;
	}

	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
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
		return "LoanTransferReturnEntity [loanJsonList=" + loanJsonList
				+ ", platformMoneymoremore=" + platformMoneymoremore
				+ ", action=" + action + ", randomTimeStamp=" + randomTimeStamp
				+ ", remark1=" + remark1 + ", remark2=" + remark2
				+ ", remark3=" + remark3 + ", resultCode=" + resultCode
				+ ", message=" + message + ", returnTimes=" + returnTimes
				+ ", signInfo=" + signInfo + ", loaninfolist=" + loaninfolist
				+ ", loaninfolists=" + loaninfolists + ", statu=" + statu + "]";
	}

}

