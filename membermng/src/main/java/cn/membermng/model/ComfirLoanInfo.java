package cn.membermng.model; 


/***
* 待确认的借款信息
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-5-12 上午9:24:54 
*
*/
public class ComfirLoanInfo {

	private		long		applyId;		//借款申请编号
	private		String		loanTypeName;	//借款类型名称
	private 	String		loanTitle;		//借款标题
	private 	long		loanAmount;		//借款金额
	private 	String		sLoanAmount;	//借款金额
	private 	int			deadline;		//借款期限
	private		int			deadlineType;	//借款期限类型 0天 1月 2年
	private 	String		replayTypeName;	//还款方式名称
	private		String		proJectDetail;	//项目描述
	private		String		loanDetail;		//借款描述	
	private		String		usageOfLoan;	//借款用途
	private		String		paymentSource;	//还款来源
	
	
	
	
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public String getLoanTypeName() {
		return loanTypeName;
	}
	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}
	public String getLoanTitle() {
		return loanTitle;
	}
	public void setLoanTitle(String loanTitle) {
		this.loanTitle = loanTitle;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getsLoanAmount() {
		return sLoanAmount;
	}
	public void setsLoanAmount(String sLoanAmount) {
		this.sLoanAmount = sLoanAmount;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getDeadlineType() {
		return deadlineType;
	}
	public void setDeadlineType(int deadlineType) {
		this.deadlineType = deadlineType;
	}
	public String getReplayTypeName() {
		return replayTypeName;
	}
	public void setReplayTypeName(String replayTypeName) {
		this.replayTypeName = replayTypeName;
	}
	public String getProJectDetail() {
		return proJectDetail;
	}
	public void setProJectDetail(String proJectDetail) {
		this.proJectDetail = proJectDetail;
	}
	public String getLoanDetail() {
		return loanDetail;
	}
	public void setLoanDetail(String loanDetail) {
		this.loanDetail = loanDetail;
	}
	public String getUsageOfLoan() {
		return usageOfLoan;
	}
	public void setUsageOfLoan(String usageOfLoan) {
		this.usageOfLoan = usageOfLoan;
	}
	public String getPaymentSource() {
		return paymentSource;
	}
	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
	}
	
	
}

