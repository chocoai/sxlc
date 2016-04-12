package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;


/****
* 用于封装查询出来的会员详细信息
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 上午9:29:57 
*
*/
public class MemberDetaileInfo {
	
	private long					memberId				;//会员编号
	private String					memberNo				;//会员编号
	private String					memberName				;//会员用户名
	private String					userName				;//会员真实姓名
	private String					memberIdCard			;//会员身份证号
	private String					froms					;//籍贯
	private int						nation					;//民族
	private String					nationName				;//
	private String					permanentAddress		;//户籍地址
	private String					residenceAddress		;//居住地址
	private String					memberPhone				;//手机号
	private String					memberEmail				;//电子邮箱
	private String					memberQQ				;//会员QQ号
	private int						sexId					;//会员性别
	private String					sexName					;//会员性别名称
	private int						educationId				;//最高学历
	private String					educationName			;//最高学历
	private int						marriageStatu			;//婚姻状态
	private String					marriageStatuName		;//
	private long					monthlyIncome			;//月收入
	private String					sMonthlyIncome			;//
	private String					provinceName			;//省名称
	private String					cityName				;//市名称
	private String					countyName				;//城市名称
	private String					townName				;//街道名称
	
	public MemberDetaileInfo() {}

	public MemberDetaileInfo(long memberId, String memberNo, String memberName,
			String userName, String memberIdCard, String from, int nation,
			String nationName, String permanentAddress,
			String residenceAddress, String memberPhone, String memberEmail,
			String memberQQ, int sexId, String sexName, int educationId,
			String educationName, int marriageStatu, String marriageStatuName,
			long monthlyIncome, String sMonthlyIncome, String provinceName,
			String cityName, String countyName, String townName) {
		super();
		this.memberId = memberId;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.userName = userName;
		this.memberIdCard = memberIdCard;
		this.froms = from;
		this.nation = nation;
		this.nationName = nationName;
		this.permanentAddress = permanentAddress;
		this.residenceAddress = residenceAddress;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberQQ = memberQQ;
		this.sexId = sexId;
		this.sexName = sexName;
		this.educationId = educationId;
		this.educationName = educationName;
		this.marriageStatu = marriageStatu;
		this.marriageStatuName = marriageStatuName;
		this.monthlyIncome = monthlyIncome;
		this.sMonthlyIncome = sMonthlyIncome;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.countyName = countyName;
		this.townName = townName;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMemberIdCard() {
		return memberIdCard;
	}

	public void setMemberIdCard(String memberIdCard) {
		this.memberIdCard = memberIdCard;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String from) {
		this.froms = from;
	}

	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberQQ() {
		return memberQQ;
	}

	public void setMemberQQ(String memberQQ) {
		this.memberQQ = memberQQ;
	}

	public int getSexId() {
		return sexId;
	}

	public void setSexId(int sexId) {
		this.sexId = sexId;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getMarriageStatu() {
		return marriageStatu;
	}

	public void setMarriageStatu(int marriageStatu) {
		this.marriageStatu = marriageStatu;
	}

	public String getMarriageStatuName() {
		return marriageStatuName;
	}

	public void setMarriageStatuName(String marriageStatuName) {
		this.marriageStatuName = marriageStatuName;
	}

	public long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
		this.sMonthlyIncome = IntegerAndString.LongToString(monthlyIncome);
	}

	public String getsMonthlyIncome() {
		return sMonthlyIncome;
	}

	public void setsMonthlyIncome(String sMonthlyIncome) {
		this.sMonthlyIncome = sMonthlyIncome;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}
	
	
	
	
	
	
	
	
	
	
}

