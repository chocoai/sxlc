package cn.springmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


/***
 * 职务信息实体
 * @author LiJie
 *
 */
public class PostInfo {
	
	private Long				id;			//职务序号
	private Long				deptId;		//部门编号
	private String				postNo;		//职务编号
	@NotNull(message="职务名称不能为空")
	@Pattern(regexp="[\u4E00-\u9FA5A-Za-z0-9]{1,12}",message="部门名称由2-12位汉字、字母、数字组成")
	private String				postName;	//职务名称
	@Length(max=125,message="职务描述不能超过125个字符")
	private String 				postRemark;	//职务备注
	private String				addDate;	//职务添加时间
	private int					postStatu;	//状态 0无效、1有效
	
	
	
	
	public PostInfo() {}
	
	
	public PostInfo(Long iD, Long deptId, String postNo, String postName,
			String postRemark, String addDate, int postStatu) {
		super();
		this.id = iD;
		this.deptId = deptId;
		this.postNo = postNo;
		this.postName = postName;
		this.postRemark = postRemark;
		this.addDate = addDate;
		this.postStatu = postStatu;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostRemark() {
		return postRemark;
	}
	public void setPostRemark(String postRemark) {
		this.postRemark = postRemark;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getPostStatu() {
		return postStatu;
	}
	public void setPostStatu(int postStatu) {
		this.postStatu = postStatu;
	}

}
