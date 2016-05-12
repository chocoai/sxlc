package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/***
* 借款申请记录 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-5 下午3:40:46 
*
 */
public class LoanApplyRecord {

	
	private String 				projectNo;					//项目申请编号
	private String				projectName;				//项目申请名称
	private int					projectType;				//产品类型
	private String				projectTypeName;			//产品类型名称
	private int					deadline;					//借款期限
	private int					deadlineType;				//借款期限类型
	private long 				amount;						//借款金额
	private String				sAmount;					//
	private long 				minAmount;					//最低借款金额
	private String				sMinAmount;					//
	private int					yearRate;					//年化利率
	private String				sYearRate;					//
	private int					statu;						//状态
	private String				statuName;					//状态名称
	
	
	public LoanApplyRecord() {}


	public LoanApplyRecord(String projectNo, String projectName,
			int projectType, String projectTypeName, int deadline,
			int deadlineType, long amount, String sAmount, long minAmount,
			String sMinAmount, int yearRate, String sYearRate, int statu) {
		super();
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectTypeName = projectTypeName;
		this.deadline = deadline;
		this.deadlineType = deadlineType;
		this.amount = amount;
		this.sAmount = sAmount;
		this.minAmount = minAmount;
		this.sMinAmount = sMinAmount;
		this.yearRate = yearRate;
		this.sYearRate = sYearRate;
		this.statu = statu;
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


	public int getProjectType() {
		return projectType;
	}


	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}


	public String getProjectTypeName() {
		return projectTypeName;
	}


	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
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


	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sAmount =  myformat.format(Double.valueOf(IntegerAndString.LongToString(amount))) ;   
	}


	public String getsAmount() {
		return sAmount;
	}


	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}


	public long getMinAmount() {
		return minAmount;
	}


	public void setMinAmount(long minAmount) {
		this.minAmount = minAmount;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sMinAmount =  myformat.format(Double.valueOf(IntegerAndString.LongToString(minAmount))) ;  
	}


	public String getsMinAmount() {
		return sMinAmount;
	}


	public void setsMinAmount(String sMinAmount) {
		this.sMinAmount = sMinAmount;
	}


	public int getYearRate() {
		return yearRate;
	}


	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sYearRate =  myformat.format(Double.valueOf(IntegerAndString.IntToString(yearRate))) ;  
	}


	public String getsYearRate() {
		return sYearRate;
	}


	public void setsYearRate(String sYearRate) {
		this.sYearRate = sYearRate;
	}


	public int getStatu() {
		return statu;
	}


	public void setStatu(int statu) {
		this.statu = statu;
	}


	public String getStatuName() {
		return statuName;
	}


	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}
	
	
	
}

