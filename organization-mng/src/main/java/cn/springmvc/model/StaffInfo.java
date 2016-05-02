package cn.springmvc.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Pattern;

/***
 * 员工实体信息
 * @author LiJie
 *
 */
public class StaffInfo {

	private Long				id;				//序号
	private String				staffNo;		//员工编号
	private Long				personalId;		//个人信息关联编号
	private PersonalBaseInfo 	baseInfo;		//个人信息
	@Pattern(regexp="[\u4E00-\u9FA5\uf900-\ufa2d]{2,12}",message="紧急联系人姓名为2-8位中文")
	private	String				emerName;		//紧急联系人名称
	@Pattern(regexp="1\\d{10}",message="请输入11位电话号码")
	private String				emerPhone;		//紧急联系人电话
	private Date				startDate;		//入职时间
	private Date				endDate;		//离职时间
	private Integer				staffStatu;		//状态
	
	/*----------add by TGF @2016-4-6 用于页面职务展示*/
	private String				postId;		//职务id
	private String				postName;		//职务名
	private String				deptId;		//部门id(用于修改员工信息)
	
	
	public StaffInfo() {}



	public StaffInfo(Long id, String staffNo, Long personalId,
			PersonalBaseInfo baseInfo, String emerName, String emerPhone,
			Date startDate, Date endDate, Integer staffStatu) {
		super();
		this.id = id;
		this.staffNo = staffNo;
		this.personalId = personalId;
		this.baseInfo = baseInfo;
		this.emerName = emerName;
		this.emerPhone = emerPhone;
		this.startDate = startDate;
		this.endDate = endDate;
		this.staffStatu = staffStatu;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}



	public String getPostName() {
		return postName;
	}



	public void setPostName(String postName) {
		this.postName = postName;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public PersonalBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(PersonalBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getEmerName() {
		return emerName;
	}

	public void setEmerName(String emerName) {
		this.emerName = emerName;
	}

	public String getEmerPhone() {
		return emerPhone;
	}

	public void setEmerPhone(String emerPhone) {
		this.emerPhone = emerPhone;
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

	public Integer getStaffStatu() {
		return staffStatu;
	}

	public void setStaffStatu(Integer staffStatu) {
		this.staffStatu = staffStatu;
	}
	
	
}
