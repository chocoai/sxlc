
package cn.membermng.model; 

/** 
 * 列表分页展示单个认证项的所有认证企业会员信息
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午3:03:46  */
public class MemberAttestByTypeEntity {
	private String memberNo;//会员编号
	private long memberID;//会员id
	private String logname;//会员登录名
	private long certificationID;//认证记录ID
	private String recordDate;//提交申请时间
	private int status;//认证状态0	未提交1审核中2已认证3已打回4已过期
	private long attestTypeID;//会员认证ID
	private String attestTypeName;//认证项类型名称
	private String statuname;//认证状态名称
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public long getCertificationID() {
		return certificationID;
	}
	public void setCertificationID(long certificationID) {
		this.certificationID = certificationID;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getAttestTypeID() {
		return attestTypeID;
	}
	public void setAttestTypeID(long attestTypeID) {
		this.attestTypeID = attestTypeID;
	}
	public String getAttestTypeName() {
		return attestTypeName;
	}
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	public String getStatuname() {
		return statuname;
	}
	public void setStatuname(String statuname) {
		this.statuname = statuname;
	}
	
}

