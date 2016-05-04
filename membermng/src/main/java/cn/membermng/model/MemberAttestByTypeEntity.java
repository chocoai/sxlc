package cn.membermng.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/**
 * 列表分页展示单个认证项的所有认证企业会员信息
 * 
 * @author 朱祖轶
 * @Description: TODO
 * @since
 * @date 2016-3-24 下午3:03:46
 */
public class MemberAttestByTypeEntity {
	private String address;//住址
	private String maritalName;//婚姻状况
	private String educationName;//学历
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String memberNo;// 会员编号
	private long memberID;// 会员id
	private String logname;// 会员登录名
	private long certificationID;// 认证记录ID
	private String sRecordDate;// 提交申请时间
	private Date  recordDate;// 提交申请时间
	private int status;// 认证状态0 未提交1审核中2已认证3已打回4已过期
	private long attestTypeID;// 会员认证ID
	private String attestTypeName;// 认证项类型名称
	private String statuname;// 认证状态名称
	private String realName;// 真实姓名
	private String personalIDCard;// 身份证号
	private int sexId;// 性别 0 男 \ 1女
	private String homeTown;// 籍贯

	private String nationName;//民族
	

	private Date  validTime;//有效期
	private String sValidTime;	//

	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

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


	public String getsRecordDate() {
		return sRecordDate;
	}


	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate =  TimestampAndString.DateToString(recordDate);
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPersonalIDCard() {
		return personalIDCard;
	}

	public void setPersonalIDCard(String personalIDCard) {
		this.personalIDCard = personalIDCard;
	}

	public String getMaritalName() {
		return maritalName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}


	public int getSexId() {
		return sexId;
	}

	public void setSexId(int sexId) {
		this.sexId = sexId;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	


	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
		this.sValidTime = TimestampAndString.DateToString(validTime);
	}

	public String getsValidTime() {
		return sValidTime;
	}

}
