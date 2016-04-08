package cn.springmvc.model;

import java.util.Date;


/***
 * 员工职务关联表
 * @author Administrator
 *
 */
public class StaffPost {

	private Long		deptId;					//部门编号
	private DeptInfo	deptInfo;				//部门信息实体
	private Long		postId;					//职务编号
	private PostInfo	postInfo;				//职务信息实体
	private Long	 	staffId;				//员工编号
	private StaffInfo	staffInfo;				//员工信息实体
	private Date 	 	startDate;				//任职时间
	private Date 	 	endDate;				//离职时间
	private Integer	 	staffPostStatu;			//员工在职状态 0：有效 1：无效
	
	
	
	
	
	
	
	public StaffPost() {}

	public StaffPost(Long deptId, Long postId, Long staffId, Date startDate,
			Date endDate, Integer staffPostStatu) {
		super();
		this.deptId = deptId;
		this.postId = postId;
		this.staffId = staffId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.staffPostStatu = staffPostStatu;
	}



	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStaffPostStatu() {
		return staffPostStatu;
	}

	public void setStaffPostStatu(Integer staffPostStatu) {
		this.staffPostStatu = staffPostStatu;
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	public PostInfo getPostInfo() {
		return postInfo;
	}

	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}

	public StaffInfo getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}
	
	
}
