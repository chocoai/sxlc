package cn.springmvc.model;
/**
 * 借款意向实体类
 * @author 刘利
 *
 */
public class ProjectPurposeEntity {
	/**
	 * 借款意向id
	 */
	private Long id	;
	/**
	 * 会员ID
	 */
	private Long memberID;
	/**
	 * 借款用途
	 */
	private String uses;	
	/**
	 * 还款来源
	 */
	private String repaySource;	
	/**
	 * 借款金额
	 */
	private Long amount;	
	/**
	 * 借款金额
	 */
	private String amountStr;	
	/**
	 * 项目描述
	 */
	private String projectDescript	;	
	/**
	 * 借款期限 单位：月/天	
	 */
	private Integer deadline;
	/**
	 * 期限类型  0：天标 1：月标 2：年标
	 */
	private Integer deadlineType;	
	/**
	 * 还款方式  0：等额本息，1：每月还息，到期还本 2：到期还息本 3:等额本金
	 */
	private Integer repayWay;
	/**
	 * 预计年化收益率(万分之)
	 */
	private Integer yearRate;
	/**
	 * 申请时间
	 */
	private String recordDate;
	/**
	 * 提交申请管理员ID
	 */
	private Long adminId;	
	/**
	 * 意向处理状态 0：未处理 1：提交申请 -1：打回	
	 */
	private Integer dealStatu;
	
	private String MemberNo;
	private String Logname;
	private String PersonalName;
	private String PersonalPhone;
	private int financial;//有无分配理财顾问 大于0则为有
	private String sendrecordDate;//提交申请时间
	private  Long projectID;//借款类型ID
	
	/**
	 * 积分处理时间
	 */
	private String dealDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberID() {
		return memberID;
	}
	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}
	public String getUses() {
		return uses;
	}
	public void setUses(String uses) {
		this.uses = uses;
	}
	public String getRepaySource() {
		return repaySource;
	}
	public void setRepaySource(String repaySource) {
		this.repaySource = repaySource;
	}

	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getAmountStr() {
		return amountStr;
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public String getProjectDescript() {
		return projectDescript;
	}
	public void setProjectDescript(String projectDescript) {
		this.projectDescript = projectDescript;
	}
	public Integer getDeadline() {
		return deadline;
	}
	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}
	public Integer getDeadlineType() {
		return deadlineType;
	}
	public void setDeadlineType(Integer deadlineType) {
		this.deadlineType = deadlineType;
	}
	public Integer getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(Integer repayWay) {
		this.repayWay = repayWay;
	}
	public Integer getYearRate() {
		return yearRate;
	}
	public void setYearRate(Integer yearRate) {
		this.yearRate = yearRate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Integer getDealStatu() {
		return dealStatu;
	}
	public void setDealStatu(Integer dealStatu) {
		this.dealStatu = dealStatu;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getMemberNo() {
		return MemberNo;
	}
	public void setMemberNo(String memberNo) {
		MemberNo = memberNo;
	}
	public String getLogname() {
		return Logname;
	}
	public void setLogname(String logname) {
		Logname = logname;
	}
	public String getPersonalName() {
		return PersonalName;
	}
	public void setPersonalName(String personalName) {
		PersonalName = personalName;
	}
	public String getPersonalPhone() {
		return PersonalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		PersonalPhone = personalPhone;
	}
	public int getFinancial() {
		return financial;
	}
	public void setFinancial(int financial) {
		this.financial = financial;
	}
	public String getSendrecordDate() {
		return sendrecordDate;
	}
	public void setSendrecordDate(String sendrecordDate) {
		this.sendrecordDate = sendrecordDate;
	}
	public Long getProjectID() {
		return projectID;
	}
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	} 
	
	
}
