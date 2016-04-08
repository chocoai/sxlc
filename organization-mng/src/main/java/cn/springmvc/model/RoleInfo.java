package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;


/***
 * 角色实体
 * @author LiJie
 *
 */
public class RoleInfo {
	
	private		long		id;				//序号
	private		String		roleNo;			//角色编号
	private		String		roleName;		//角色名称
	private 	Date		addDate;		//添加时间
	private 	String		sAddDate;		//添加时间
	
	private		String		roleRemark;		//描述
	private 	int		roleStatu;		//角色状态 0有效、1无效
	
	public RoleInfo() {
		// TODO Auto-generated constructor stub
	}

	public RoleInfo(Long id, String roleNo, String roleName, Date addDate,
			String roleRemark, Integer roleStatu) {
		super();
		this.id = id;
		this.roleNo = roleNo;
		this.roleName = roleName;
		this.addDate = addDate;
		this.roleRemark = roleRemark;
		this.roleStatu = roleStatu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
		this.sAddDate =TimestampAndString.DateToString(addDate);
	}

	public String getsAddDate() {
		return sAddDate;
	}

	public void setsAddDate(String sAddDate) {
		this.sAddDate = sAddDate;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public int getRoleStatu() {
		return roleStatu;
	}

	public void setRoleStatu(int roleStatu) {
		this.roleStatu = roleStatu;
	}


}
