package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;



/***
* 还款管理+还款中的借款
* 
* @author 李杰
* @since 
* @date 2016-4-29 下午9:17:38 
*
*/
public class RepaymentOfBorrowings {
	
	private long			projectId			;//借款项目编号
	private String			projectNo			;//借款编号
	private String			projectName			;//借款项目名称
	private String			lendingTime			;//放款时间
	private long			principal			;//本金
	private String			sPrincipal			;//本金
	private int				interestRates		;//年利率
	private String			sInterestRates		;//年利率
	private int				termOfLoan			;//借款期限
	private int				termOfLoanType		;//借款期限类型
	private int				repaymentType		;//还款方式
	private String			repaymentTypeName	;//
	private long			alsoHasInterest		;//已还本息
	private String			sAlsoHasInterest	;//
	private long			noHasInterest		;//未还本息
	private String			sNoHasInterest		;//
	private String			nextRepaymentTime	;//下一个还款日
	private long			repaymentAount		;//还款金额
	private String			sRepaymentAount		;//
	
	
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
	public String getLendingTime() {
		return lendingTime;
	}
	public void setLendingTime(String lendingTime) {
		this.lendingTime = lendingTime;
	}
	public long getPrincipal() {
		return principal;
	}
	public void setPrincipal(long principal) {
		this.principal = principal;
		this.sPrincipal = IntegerAndString.LongToString(principal);
	}
	public String getsPrincipal() {
		return sPrincipal;
	}
	public void setsPrincipal(String sPrincipal) {
		this.sPrincipal = sPrincipal;
	}
	public int getInterestRates() {
		return interestRates;
	}
	public void setInterestRates(int interestRates) {
		this.interestRates = interestRates;
	}
	public String getsInterestRates() {
		return sInterestRates;
	}
	public void setsInterestRates(String sInterestRates) {
		this.sInterestRates = sInterestRates;
	}
	public int getTermOfLoan() {
		return termOfLoan;
	}
	public void setTermOfLoan(int termOfLoan) {
		this.termOfLoan = termOfLoan;
	}
	public int getTermOfLoanType() {
		return termOfLoanType;
	}
	public void setTermOfLoanType(int termOfLoanType) {
		this.termOfLoanType = termOfLoanType;
	}
	public int getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(int repaymentType) {
		this.repaymentType = repaymentType;
	}
	public String getRepaymentTypeName() {
		return repaymentTypeName;
	}
	public void setRepaymentTypeName(String repaymentTypeName) {
		this.repaymentTypeName = repaymentTypeName;
	}
	public long getAlsoHasInterest() {
		return alsoHasInterest;
	}
	public void setAlsoHasInterest(long alsoHasInterest) {
		this.alsoHasInterest = alsoHasInterest;
		this.sAlsoHasInterest = IntegerAndString.LongToString(alsoHasInterest);
	}
	public String getsAlsoHasInterest() {
		return sAlsoHasInterest;
	}
	public void setsAlsoHasInterest(String sAlsoHasInterest) {
		this.sAlsoHasInterest = sAlsoHasInterest;
	}
	public long getNoHasInterest() {
		return noHasInterest;
	}
	public void setNoHasInterest(long noHasInterest) {
		this.noHasInterest = noHasInterest;
		this.sNoHasInterest = IntegerAndString.LongToString(noHasInterest);
	}
	public String getsNoHasInterest() {
		return sNoHasInterest;
	}
	public void setsNoHasInterest(String sNoHasInterest) {
		this.sNoHasInterest = sNoHasInterest;
	}
	public String getNextRepaymentTime() {
		return nextRepaymentTime;
	}
	public void setNextRepaymentTime(String nextRepaymentTime) {
		this.nextRepaymentTime = nextRepaymentTime;
	}
	public long getRepaymentAount() {
		return repaymentAount;
	}
	public void setRepaymentAount(long repaymentAount) {
		this.repaymentAount = repaymentAount;
		this.sRepaymentAount = IntegerAndString.LongToString(repaymentAount);
	}
	public String getsRepaymentAount() {
		return sRepaymentAount;
	}
	public void setsRepaymentAount(String sRepaymentAount) {
		this.sRepaymentAount = sRepaymentAount;
	}

}

