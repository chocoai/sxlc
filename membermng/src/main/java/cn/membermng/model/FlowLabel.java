package cn.membermng.model; 

import java.sql.Timestamp;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;


/***
* 已流标模型、用在封装我的借款中-已流标查询结果集
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-5 上午10:48:23 
*
 */
public class FlowLabel {

	
	private long 		loanId;					//借款项编号
	private String		projectNo;				//项目编号
	private String		projectName;			//借款项目名称
	private int			projectType;			//产品类型
	private String		projectTypeName;		//产品类型名称
	private int			deadline;				//借款期限
	private int			deadlineType;			//借款期限类型
	private long 		amount;					//借款金额
	private String		sAmount;				//
	private long 		minAmount;				//最低借款金额
	private String		sMinAmount;				//
	private int			yearRate;				//年化利率
	private String		sYearRate;				//年化利率
	private String		releaseTime;			//发布时间
	private String		startTime;				//投标开始时间
	private String		endTime;				//投标结束时间
	private String		realEndDate;			//实际投标结束时间
	private int			investRate;				//投资进度
	private String		sInvestRate;			
	private String		holdDate;				//流标时间
	
	
	
	public FlowLabel() {}



	public FlowLabel(long loanId, String projectNo, String projectName,
			int projectType, String projectTypeName, int deadline,
			int deadlineType, long amount, String sAmount, long minAmount,
			String sMinAmount, int yearRate, String sYearRate,
			String releaseTime, String startTime, String endTime,
			String realEndDate, int investRate) {
		super();
		this.loanId = loanId;
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
		this.releaseTime = releaseTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.realEndDate = realEndDate;
		this.investRate = investRate;
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
		this.sYearRate =  myformat.format(Double.valueOf(IntegerAndString.LongToString(yearRate))) ;  
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
		this.releaseTime =  TimestampAndString.TimestampToString2(Timestamp.valueOf(releaseTime));
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = TimestampAndString.TimestampToString2(Timestamp.valueOf(startTime));
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = TimestampAndString.TimestampToString2(Timestamp.valueOf(endTime));
	}

	public String getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(String realEndDate) {
		this.realEndDate = TimestampAndString.TimestampToString2(Timestamp.valueOf(realEndDate));
	}

	public long getInvestRate() {
		return investRate;
	}

	public void setInvestRate(int investRate) {
		this.investRate = investRate;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sInvestRate =  myformat.format(Double.valueOf(IntegerAndString.LongToString(investRate))) ;   
	}

	public String getsInvestRate() {
		return sInvestRate;
	}

	public void setsInvestRate(String sInvestRate) {
		this.sInvestRate = sInvestRate;
	}
	
	public void setHoldDate(String holdDate) {
		this.holdDate =  TimestampAndString.TimestampToString2(Timestamp.valueOf(holdDate));
	}
	
	public String getHoldDate() {
		return holdDate;
	}
	
}

