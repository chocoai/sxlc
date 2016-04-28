package cn.springmvc.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;


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
	private Date 				addTime;	//职务添加时间	
	private String				addDate;	//职务添加时间
	private int					postStatu;	//状态 0无效、1有效
	
	private String deptName;//部门 
	
	
	public PostInfo() {}
	public PostInfo(Long id, Long deptId, String postNo, String postName,
			String postRemark, Date addTime, String addDate, int postStatu,
			String deptName) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.postNo = postNo;
		this.postName = postName;
		this.postRemark = postRemark;
		this.addTime = addTime;
		this.addDate = addDate;
		this.postStatu = postStatu;
		this.deptName = deptName;
	}

	public Date getAddTime() {
		return addTime;
	
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
		this.addDate = TimestampAndString.DateToString(addTime);
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
