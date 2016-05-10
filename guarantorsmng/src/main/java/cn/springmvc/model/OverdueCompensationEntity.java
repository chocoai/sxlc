
package cn.springmvc.model; 

/**
 * 逾期代偿列表信息 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-6 下午4:56:53  */
public class OverdueCompensationEntity {
	private long applyId;//项目申请记录id
	private String projectNo;//项目编号
	private String projectName;//项目类型名称
	private String projectTitle;//项目标题
	private int indexs;//期数
	private String personalName;//姓名
	private String logname;//登录名
	private String personalPhone;//手机号
	private String guaranteeName;//担保机构名称
	private long guaranteeID;//担保机构id
	private long realAmount;//实际借款金额
	private String repayMaxTime;//合约还款日 /支付时间
	private long sDRepayPrincipal;//应还本金 /支付本金
	private long sDRepayInterest;//应还利息 /支付利息
	private long repayOverdueInterest;//逾期利息 /支付逾期利息
	private long repayOverdue;//逾期罚金 / 支付逾期罚金
	private long repayID;//还款计划id
	private long projectID;//产品类型id
	private int isCompensatory;//是否代偿 0：未代偿；1：已代偿
	private String paymentTime;//回款时间
	private long allmoney;//代偿总金额、回款总金额
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
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
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public long getsDRepayPrincipal() {
		return sDRepayPrincipal;
	}
	public void setsDRepayPrincipal(long sDRepayPrincipal) {
		this.sDRepayPrincipal = sDRepayPrincipal;
	}
	public long getsDRepayInterest() {
		return sDRepayInterest;
	}
	public void setsDRepayInterest(long sDRepayInterest) {
		this.sDRepayInterest = sDRepayInterest;
	}
	public long getRepayOverdueInterest() {
		return repayOverdueInterest;
	}
	public void setRepayOverdueInterest(long repayOverdueInterest) {
		this.repayOverdueInterest = repayOverdueInterest;
	}
	public long getRepayOverdue() {
		return repayOverdue;
	}
	public void setRepayOverdue(long repayOverdue) {
		this.repayOverdue = repayOverdue;
	}
	public long getRepayID() {
		return repayID;
	}
	public void setRepayID(long repayID) {
		this.repayID = repayID;
	}
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public int getIsCompensatory() {
		return isCompensatory;
	}
	public void setIsCompensatory(int isCompensatory) {
		this.isCompensatory = isCompensatory;
	}
	public long getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(long allmoney) {
		this.allmoney = allmoney;
	}
	public String getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	
}

