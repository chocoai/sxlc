package cn.membermng.model;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;



/***
 * 个人基础信息
 * @author LiJie
 *
 */
public class PersonalBaseInfo {
	
	private Long		id;						//序号
	
	@Pattern(regexp="[\u4E00-\u9FA5\uf900-\ufa2d]{2,12}",message="姓名为2-8位中文")
	private	String		personalName;			//姓名
	@Pattern(regexp="",message="请输入18位身份证号")
	private String		personalIDCard;			//联系人身份证
	private Integer		sexId;					//性别
	private String		sexName;				
	private Integer		maritalStatus;			//婚姻状况
	private String		maritalName;			
	private Integer		education;				//最高学历
	private String		educationName;			//
	private String		graduatedSchool;		//毕业学校
	private	String		graduatedProfessionals;	//毕业专业
	private Date		graduatedDATE;			//毕业时间
	private Integer		nationId;				//名族
	private String		nationName;				//名族
	private String		homeTown;				//籍贯
	private String		census;					//户口所在地
	private String		monthlyIncome;			//月均收入
	private String		legalIdCardUrl1;		//身份证正面
	private String		legalIdCardUrl2;		//身份证背面
	private Integer		bloodType;				//血型 0：O型 1：A型 2：B型 3：AB型
	private Integer		height;					//身高 cm
	private Integer		weight;					//体重 斤
	private Integer		religionId;				//宗教信仰
	@Length(max=25,message="居住地址应在25个字内")
	private String		houseAddress;			//现居住地
	private String		mailingAddress;			//通讯地址
	private String		zipCode;				//邮政编码
	private String		homeAddress;			//家庭地址
	@Pattern(regexp="1\\d{10}",message="请输入11位电话号码")
	private String		personalPhone;			//手机号
	private String		personalFixPhone;		//固定电话
	@Pattern(regexp="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message="请输入有效邮箱地址")
	private String		personalEmail;			//邮箱
	@Pattern(regexp="\\d{5,12}",message="请输入5-12位QQ号码")
	private String		qq;						//联系QQ
	private String		birthday;				//出生日期
	private Integer		age;					//年龄
	
	
	public PersonalBaseInfo() {}
	
	
	public PersonalBaseInfo(Long id, String personalName,
			String personalIDCard, Integer sexId, Integer maritalStatus,
			Integer education, String graduatedSchool,
			String graduatedProfessionals, Date graduatedDATE,
			Integer nationId, String homeTown, String census,
			String monthlyIncome, String legalIdCardUrl1,
			String legalIdCardUrl2, Integer bloodType, Integer height,
			Integer weight, Integer religionId, String houseAddress,
			String mailingAddress, String zipCode, String homeAddress,
			String personalPhone, String personalFixPhone,
			String personalEmail, String qq) {
		super();
		this.id = id;
		this.personalName = personalName;
		this.personalIDCard = personalIDCard;
		this.sexId = sexId;
		this.maritalStatus = maritalStatus;
		this.education = education;
		this.graduatedSchool = graduatedSchool;
		this.graduatedProfessionals = graduatedProfessionals;
		this.graduatedDATE = graduatedDATE;
		this.nationId = nationId;
		this.homeTown = homeTown;
		this.census = census;
		this.monthlyIncome = monthlyIncome;
		this.legalIdCardUrl1 = legalIdCardUrl1;
		this.legalIdCardUrl2 = legalIdCardUrl2;
		this.bloodType = bloodType;
		this.height = height;
		this.weight = weight;
		this.religionId = religionId;
		this.houseAddress = houseAddress;
		this.mailingAddress = mailingAddress;
		this.zipCode = zipCode;
		this.homeAddress = homeAddress;
		this.personalPhone = personalPhone;
		this.personalFixPhone = personalFixPhone;
		this.personalEmail = personalEmail;
		this.qq = qq;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalIDCard() {
		return personalIDCard;
	}
	public void setPersonalIDCard(String personalIDCard) {
		this.personalIDCard = personalIDCard;
	}
	public Integer getSexId() {
		return sexId;
	}
	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	public Integer getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public String getGraduatedSchool() {
		return graduatedSchool;
	}
	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}
	public String getGraduatedProfessionals() {
		return graduatedProfessionals;
	}
	public void setGraduatedProfessionals(String graduatedProfessionals) {
		this.graduatedProfessionals = graduatedProfessionals;
	}
	public Date getGraduatedDATE() {
		return graduatedDATE;
	}
	public void setGraduatedDATE(Date graduatedDATE) {
		this.graduatedDATE = graduatedDATE;
	}
	public Integer getNationId() {
		return nationId;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getCensus() {
		return census;
	}
	public void setCensus(String census) {
		this.census = census;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getLegalIdCardUrl1() {
		return legalIdCardUrl1;
	}
	public void setLegalIdCardUrl1(String legalIdCardUrl1) {
		this.legalIdCardUrl1 = legalIdCardUrl1;
	}
	public String getLegalIdCardUrl2() {
		return legalIdCardUrl2;
	}
	public void setLegalIdCardUrl2(String legalIdCardUrl2) {
		this.legalIdCardUrl2 = legalIdCardUrl2;
	}
	public Integer getBloodType() {
		return bloodType;
	}
	public void setBloodType(Integer bloodType) {
		this.bloodType = bloodType;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getReligionId() {
		return religionId;
	}
	public void setReligionId(Integer religionId) {
		this.religionId = religionId;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalFixPhone() {
		return personalFixPhone;
	}
	public void setPersonalFixPhone(String personalFixPhone) {
		this.personalFixPhone = personalFixPhone;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	public String getSexName() {
		return sexName;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAge() {
		return age;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}
	public String getMaritalName() {
		return maritalName;
	}
	
}
