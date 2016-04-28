package cn.membermng.model;

import java.util.Date;
import java.util.List;



/***
 * 会员认证记录
 * @author LiJie
 *
 */
public class MemberAttestInfo {
	
	
	private Long 				certificationId;			//序号
	private Long				memberId;					//会员编号
	private Long				adminId;					//管理员编号
	private Integer				memberType;					//会员类型
	private Integer				attestType;					//认证类型
	private	Integer				status;						//认证状态
	private Date				recordDate;					//申请时间
	private Date 				checkDate;					//认证申请时间
	private Date				ednDate;					//有效期结束时间
	private String				remark;						//备注
	private Integer				deleteFlag;					//删除标记
	
	private List<PersonalAttestAttach> list;
	
	private PersonalAttestAttach attach;
	
	public MemberAttestInfo() {	}
	
	public MemberAttestInfo(Long certificationId, Long memberId, Long adminId,
			Integer memberType, Integer attestType, Integer status,
			Date recordDate, Date checkDate, Date ednDate, String remark,
			Integer deleteFlag) {
		super();
		this.certificationId = certificationId;
		this.memberId = memberId;
		this.adminId = adminId;
		this.memberType = memberType;
		this.attestType = attestType;
		this.status = status;
		this.recordDate = recordDate;
		this.checkDate = checkDate;
		this.ednDate = ednDate;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
	}


	public Long getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Integer getMemberType() {
		return memberType;
	}
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}
	public Integer getAttestType() {
		return attestType;
	}
	public void setAttestType(Integer attestType) {
		this.attestType = attestType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Date getEdnDate() {
		return ednDate;
	}
	public void setEdnDate(Date ednDate) {
		this.ednDate = ednDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<PersonalAttestAttach> getList() {
		return list;
	}

	public void setList(List<PersonalAttestAttach> list) {
		this.list = list;
	}

	public PersonalAttestAttach getAttach() {
		return attach;
	}

	public void setAttach(PersonalAttestAttach attach) {
		this.attach = attach;
	}
	
	
	

}
