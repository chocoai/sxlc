package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;


public class ConfirmationLoan {

	
	private long 				projectId				;//借款项目编号
	private String				projectName				;//借款项目名称
	private String				projectTypeName			;//产品类型名称
	private int					termOfLoan				;//借款期限
	private int					termOfLoanType			;//借款期限类型
	private long				loanAount				;//借款金额
	private String				sLoanAount				;//借款金额
	private long				minLoanAount			;//最低借款金额
	private String				sMinLoanAonnt			;//最低借款金额
	private int					interestRates			;//年利率
	private String				sInterestRates			;//年利率
	private int					status					;//状态
	private String				statusName				;//状态名称
	
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
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
	public long getLoanAount() {
		return loanAount;
	}
	public void setLoanAount(long loanAount) {
		this.loanAount = loanAount;
		this.sLoanAount = IntegerAndString.LongToString(loanAount);
	}
	public String getsLoanAount() {
		return sLoanAount;
	}
	public void setsLoanAount(String sLoanAount) {
		this.sLoanAount = sLoanAount;
	}
	public long getMinLoanAount() {
		return minLoanAount;
	}
	public void setMinLoanAount(long minLoanAount) {
		this.minLoanAount = minLoanAount;
		this.sMinLoanAonnt = IntegerAndString.LongToString(minLoanAount);
	}
	public String getsMinLoanAonnt() {
		return sMinLoanAonnt;
	}
	public void setsMinLoanAonnt(String sMinLoanAonnt) {
		this.sMinLoanAonnt = sMinLoanAonnt;
	}
	public int getInterestRates() {
		return interestRates;
	}
	public void setInterestRates(int interestRates) {
		this.interestRates = interestRates;
		this.sInterestRates = IntegerAndString.IntToString(interestRates);
	}
	public String getsInterestRates() {
		return sInterestRates;
	}
	public void setsInterestRates(String sInterestRates) {
		this.sInterestRates = sInterestRates;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusName() {
		return statusName;
	}
}

