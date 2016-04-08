package cn.membermng.model;

import product_p2p.kit.datatrans.IntegerAndString;

/***
 * 还款中
 * 
 * @author 李杰
 * @Description: TODO
 * @since
 * @date 2016-3-31 上午11:38:06
 * 
 */
public class RepaymentIn {

	private long 		loanId; 			// 借款项编号
	private String 		projectNo; 			// 项目编号
	private String 		projectName; 		// 借款项目名称
	private long 		amount;	 			// 借款金额
	private String 		sAmount; 			//
	
	private long 		sjAmount;			//实际借款金额
	private String		sSjAmount;			//

	private int 		yearRate; 			// 年化利率
	private String 		sYearRate; 			// 年化利率
	private String 		releaseTime; 		// 下次还款时间
	private String 		startTime; 			// 放款时间
	private String 		endTime; 			// 投标结束时间

	private long 		returnedRrincipal; 	// 已还本金
	private String 		sReturnedRrincipal; // 已还本金

	private long 		interestPaid; 		// 已还利息
	private String 		sInterestPaid;		// 已还利息
	
	
	private long 		nextTeturnedRrincipal; 	// 已还本金
	private String 		sNextTeturnedRrincipal; // 已还本金

	private long 		nextInterestPaid; 		// 已还利息
	private String 		sNextInterestPaid;		// 已还利息

	public RepaymentIn() {

	}
	
	public RepaymentIn(long loanId, String projectNo, String projectName,
			long amount, String sAmount, long sjAmount, String sSjAmount,
			int yearRate, String sYearRate, String releaseTime,
			String startTime, String endTime, long returnedRrincipal,
			String sReturnedRrincipal, long interestPaid, String sInterestPaid,
			long nextTeturnedRrincipal, String sNextTeturnedRrincipal,
			long nextInterestPaid, String sNextInterestPaid) {
		super();
		this.loanId = loanId;
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.amount = amount;
		this.sAmount = sAmount;
		this.sjAmount = sjAmount;
		this.sSjAmount = sSjAmount;
		this.yearRate = yearRate;
		this.sYearRate = sYearRate;
		this.releaseTime = releaseTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.returnedRrincipal = returnedRrincipal;
		this.sReturnedRrincipal = sReturnedRrincipal;
		this.interestPaid = interestPaid;
		this.sInterestPaid = sInterestPaid;
		this.nextTeturnedRrincipal = nextTeturnedRrincipal;
		this.sNextTeturnedRrincipal = sNextTeturnedRrincipal;
		this.nextInterestPaid = nextInterestPaid;
		this.sNextInterestPaid = sNextInterestPaid;
	}


	public long getNextTeturnedRrincipal() {
		return nextTeturnedRrincipal;
	}

	public void setNextTeturnedRrincipal(long nextTeturnedRrincipal) {
		this.nextTeturnedRrincipal = nextTeturnedRrincipal;
		this.sNextTeturnedRrincipal = IntegerAndString.LongToString(nextTeturnedRrincipal);
	}

	public String getsNextTeturnedRrincipal() {
		return sNextTeturnedRrincipal;
	}

	public void setsNextTeturnedRrincipal(String sNextTeturnedRrincipal) {
		this.sNextTeturnedRrincipal = sNextTeturnedRrincipal;
	}

	public long getNextInterestPaid() {
		return nextInterestPaid;
	}

	public void setNextInterestPaid(long nextInterestPaid) {
		this.nextInterestPaid = nextInterestPaid;
		this.sNextInterestPaid = IntegerAndString.LongToString(nextInterestPaid);
	}

	public String getsNextInterestPaid() {
		return sNextInterestPaid;
	}

	public void setsNextInterestPaid(String sNextInterestPaid) {
		this.sNextInterestPaid = sNextInterestPaid;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
		this.sAmount = IntegerAndString.LongToString(amount);
	}

	public String getsAmount() {
		return sAmount;
	}

	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}

	public int getYearRate() {
		return yearRate;
	}

	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
		this.sYearRate = IntegerAndString.IntToString(yearRate);
	}

	public String getsYearRate() {
		return sYearRate;
	}

	public void setsYearRate(String sYearRate) {
		this.sYearRate = sYearRate;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public long getReturnedRrincipal() {
		return returnedRrincipal;
	}

	public void setReturnedRrincipal(long returnedRrincipal) {
		this.returnedRrincipal = returnedRrincipal;
		this.sReturnedRrincipal	= IntegerAndString.LongToString(returnedRrincipal);
	}


	public long getInterestPaid() {
		return interestPaid;
	}

	public void setInterestPaid(long interestPaid) {
		this.interestPaid = interestPaid;
		this.sInterestPaid	= IntegerAndString.LongToString(interestPaid);
	}

	public long getSjAmount() {
		return sjAmount;
	}

	public void setSjAmount(long sjAmount) {
		this.sjAmount = sjAmount;
		this.sSjAmount = IntegerAndString.LongToString(sjAmount);
	}

	public String getsSjAmount() {
		return sSjAmount;
	}

	public void setsSjAmount(String sSjAmount) {
		this.sSjAmount = sSjAmount;
	}

	public String getsReturnedRrincipal() {
		return sReturnedRrincipal;
	}

	public void setsReturnedRrincipal(String sReturnedRrincipal) {
		this.sReturnedRrincipal = sReturnedRrincipal;
	}

	public String getsInterestPaid() {
		return sInterestPaid;
	}

	public void setsInterestPaid(String sInterestPaid) {
		this.sInterestPaid = sInterestPaid;
	}
	
	

}
