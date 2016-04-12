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
	private long id	;
	/**
	 * 会员ID
	 */
	private long memberID;
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
	private String amount;	
	/**
	 * 项目描述
	 */
	private String projectDescript	;	
	/**
	 * 借款期限 单位：月/天	
	 */
	private int deadline;
	/**
	 * 期限类型  0：天标 1：月标 2：年标
	 */
	private int deadlineType;	
	/**
	 * 还款方式  0：等额本息，1：每月还息，到期还本 2：到期还息本 3:等额本金
	 */
	private int repayWay;
	/**
	 * 预计年化收益率(万分之)
	 */
	private int yearRate;
	/**
	 * 申请时间
	 */
	private String recordDate;
	/**
	 * 提交申请管理员ID
	 */
	private long adminId;	
	/**
	 * 意向处理状态 0：未处理 1：提交申请 -1：打回	
	 */
	private int dealStatu;
	/**
	 * 积分处理时间
	 */
	private String dealDate; 
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProjectDescript() {
		return projectDescript;
	}
	public void setProjectDescript(String projectDescript) {
		this.projectDescript = projectDescript;
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
	public int getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(int repayWay) {
		this.repayWay = repayWay;
	}
	public int getYearRate() {
		return yearRate;
	}
	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public int getDealStatu() {
		return dealStatu;
	}
	public void setDealStatu(int dealStatu) {
		this.dealStatu = dealStatu;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	

}
