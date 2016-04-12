package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;


/***
 * 理财顾问实体
 * @author LiJie
 *
 */
public class FinancialAdvisor {
	
	private Long 				id;					//理财顾问序号
	private String				serviceNo;			//理财顾问编号
	private String				serviceQQ;			//理财顾问QQ
	private String				servicePhone;		//理财顾问手机号
	private String				serviceFixPhone;	//理财顾问电话
	private String				serviceNickname;	//理财顾问昵称
	private	String				serviceHeadUrl;		//理财顾问头像
	private String				serviceEmail;		//理财顾问邮箱
	private Long				staffId;			//理财顾问员工编号
	private String              staffName;			//员工姓名
	private Integer				serviceStatu;		//理财顾问状态
	private Integer				integralNum;		//当前积分
	private Date				recordDate;			//任职时间
	private String				sRecordDate;		//任职时间
	
	private Long				memberId;			//前台会员的编号
	private String 				memberNo;			//前台会员编号
	private int                 memberType;			//前台会员类型
	private String              logName;			//前台会员登录名
	private String              realName;			//前台会员姓名
	public FinancialAdvisor() {
		// TODO Auto-generated constructor stub
	}
	public FinancialAdvisor(Long id, String serviceNo, String serviceQQ,
			String servicePhone, String serviceFixPhone,
			String serviceNickname, String serviceHeadUrl, String serviceEmail,
			Long staffId, String staffName, Integer serviceStatu,
			Integer integralNum, Long memberId, int memberType, String logName,
			String realName) {
		this.id = id;
		this.serviceNo = serviceNo;
		this.serviceQQ = serviceQQ;
		this.servicePhone = servicePhone;
		this.serviceFixPhone = serviceFixPhone;
		this.serviceNickname = serviceNickname;
		this.serviceHeadUrl = serviceHeadUrl;
		this.serviceEmail = serviceEmail;
		this.staffId = staffId;
		this.staffName = staffName;
		this.serviceStatu = serviceStatu;
		this.integralNum = integralNum;
		this.memberId = memberId;
		this.memberType = memberType;
		this.logName = logName;
		this.realName = realName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getServiceQQ() {
		return serviceQQ;
	}
	public void setServiceQQ(String serviceQQ) {
		this.serviceQQ = serviceQQ;
	}
	public String getServicePhone() {
		return servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	public String getServiceFixPhone() {
		return serviceFixPhone;
	}
	public void setServiceFixPhone(String serviceFixPhone) {
		this.serviceFixPhone = serviceFixPhone;
	}
	public String getServiceNickname() {
		return serviceNickname;
	}
	public void setServiceNickname(String serviceNickname) {
		this.serviceNickname = serviceNickname;
	}
	public String getServiceHeadUrl() {
		return serviceHeadUrl;
	}
	public void setServiceHeadUrl(String serviceHeadUrl) {
		this.serviceHeadUrl = serviceHeadUrl;
	}
	public String getServiceEmail() {
		return serviceEmail;
	}
	public void setServiceEmail(String serviceEmail) {
		this.serviceEmail = serviceEmail;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Integer getServiceStatu() {
		return serviceStatu;
	}
	public void setServiceStatu(Integer serviceStatu) {
		this.serviceStatu = serviceStatu;
	}
	public Integer getIntegralNum() {
		return integralNum;
	}
	public void setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate = TimestampAndString.DateToString2(recordDate);
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
}
