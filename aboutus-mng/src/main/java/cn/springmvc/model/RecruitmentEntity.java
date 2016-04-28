package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/**
 * 招贤纳士实体类
 * @author 刘利
 *
 */
public class RecruitmentEntity {
	/**
	 * 招贤纳士id
	 */
	private long id;
	/**
	 * 招聘职位名称
	 */
	private String name;
	/**
	 * 招聘职位工作地区
	 */
	private String area;
	/**
	 * 岗位职责内容
	 */
	private String jobResponsibilities;
	/**
	 * 岗位职责内容
	 */
	private String jobRequirements;
	/**
	 * 是否有效 0:无效 1：有效	
	 */
	private int statu;
	/**
	 * 添加时间
	 */
	/**
	 * 添加时间
	 */
	private Date createTime; 
	
	private String sCreateTime;
	
	/**
	 * 最后一次添加时间
	 */
	private Date optDate; 
	private String sOptDate;
	/**
	 * 最后一次操作员id	
	 */
	private long optId;
	/**
	 * 最后一次操作员名称
	 */
	private String adminName; 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOptId() {
		return optId;
	}
	public void setOptId(long optId) {
		this.optId = optId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getJobResponsibilities() {
		return jobResponsibilities;
	}
	public void setJobResponsibilities(String jobResponsibilities) {
		this.jobResponsibilities = jobResponsibilities;
	}
	public String getJobRequirements() {
		return jobRequirements;
	}
	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.sCreateTime = TimestampAndString.DateToString(createTime);
	}
	public String getsCreateTime() {
		return sCreateTime;
	}
	public Date getOptDate() {
		return optDate;
	}
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
		this.sOptDate = TimestampAndString.DateToString(optDate);
	}
	public String getsOptDate() {
		return sOptDate;
	}
}
