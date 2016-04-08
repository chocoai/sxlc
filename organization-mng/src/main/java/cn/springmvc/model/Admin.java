package cn.springmvc.model;

import org.hibernate.validator.constraints.Length;


/***
 * 管理员实体
 * @author LiJie
 *
 */
public class Admin {
	
	private Long		id;					//序号
	private Integer 	staffType;			//人员类型0：员工 1：推荐达人 2：超级管理员 3：客服 4：担保公司管理员
	private Long		staffId;			//员工ID/推荐达人ID/担保公司ID 0：表示超级管理员 
	private PersonalBaseInfo baseInfo;
	@Length(max=10,message="管理员应在10个字以内")
	private String		adminName;			//管理员名称
	@Length(min=6,max=16,message="密码为6~16个任意字符")
	private String		adminPwd;			//管理员密码
	private String		adminRemark;		//管理员描述
	private Integer		adminCure;			//是否固化，固化后只能修改密码，不能进行删除等操作，默认0；0：不固化，非0：固化
	private Integer		adminStatu;			//是否失效，默认0；0：有效，非0：失效
	
	
	public Admin() {}


	public Admin(Long id, Integer staffType, Long staffId, String adminName,
			String adminPwd, String adminRemark, Integer adminCure,
			Integer adminStatu) {
		super();
		this.id = id;
		this.staffType = staffType;
		this.staffId = staffId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminRemark = adminRemark;
		this.adminCure = adminCure;
		this.adminStatu = adminStatu;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getStaffType() {
		return staffType;
	}


	public void setStaffType(Integer staffType) {
		this.staffType = staffType;
	}


	public Long getStaffId() {
		return staffId;
	}


	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminPwd() {
		return adminPwd;
	}


	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}


	public String getAdminRemark() {
		return adminRemark;
	}


	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}


	public Integer getAdminCure() {
		return adminCure;
	}


	public void setAdminCure(Integer adminCure) {
		this.adminCure = adminCure;
	}


	public Integer getAdminStatu() {
		return adminStatu;
	}


	public void setAdminStatu(Integer adminStatu) {
		this.adminStatu = adminStatu;
	}


	public PersonalBaseInfo getBaseInfo() {
		return baseInfo;
	}


	public void setBaseInfo(PersonalBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	
	
	
}
