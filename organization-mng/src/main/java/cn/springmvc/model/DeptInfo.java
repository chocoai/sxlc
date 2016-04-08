package cn.springmvc.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


/***
 * 部门实体
 * @author LiJie
 * @date   2016-03-14
 *
 */
public class DeptInfo {
	
	private Long 		id;							//编号
	@NotNull(message="部门名称不能为空")
	@Pattern(regexp="[\u4E00-\u9FA5A-Za-z0-9]{1,12}",message="部门名称2-12位汉字、字母、数字组成")
	private String 		deptName;					//部门名称
	private	String 		deptNo;						//部门编号
	@NotNull(message="部门负责人名称不能为空")
	@Length(max=8,min=2,message="部门负责人名称2~8个汉字")
	private	String		principalName;				//部门负责人名称
	@Pattern(regexp="1\\d{10}",message="请输入大陆手机号")
	private String 		principalPhone;				//部门负责人联系电话
	private Long		preDeptId;					//上级部门编号
	@Length(max=125,message="备注最多125个字")
	private String		deptRemark;					//部门备注
	private Date		addDate;					//添加时间
	private Integer		deptLevel;					//部门等级
	private Integer		deptStatu;					//1有效、0无效
	
	
	
	
	public DeptInfo() {
	}
	
	
	public DeptInfo(Long id, String deptName, String deptNo,
			String principalName, String principalPhone, Long preDeptId,
			String deptRemark, Date addDate, Integer deptLevel,
			Integer deptStatu) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptNo = deptNo;
		this.principalName = principalName;
		this.principalPhone = principalPhone;
		this.preDeptId = preDeptId;
		this.deptRemark = deptRemark;
		this.addDate = addDate;
		this.deptLevel = deptLevel;
		this.deptStatu = deptStatu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalPhone() {
		return principalPhone;
	}
	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
	}
	public Long getPreDeptId() {
		return preDeptId;
	}
	public void setPreDeptId(Long preDeptId) {
		this.preDeptId = preDeptId;
	}
	public String getDeptRemark() {
		return deptRemark;
	}
	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Integer getDeptLevel() {
		return deptLevel;
	}
	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}
	public Integer getDeptStatu() {
		if (deptStatu == null) {
			return 0;
		}
		return deptStatu;
	}
	public void setDeptStatu(Integer deptStatu) {
		this.deptStatu = deptStatu;
	}


	@Override
	public String toString() {
		System.out.println(this.deptName+","+this.principalName);
		return super.toString();
	}

	
	
}
