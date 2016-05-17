package cn.membermng.model; 

/***
* 实名认证信息
* 
* @author 李杰
* @since 
* @date 2016-4-26 下午4:44:24 
*
 */
public class RealNameAuth {
	
	private long 				aid;			//认证记录编号
	private String				realName;		//真实姓名
	private String				personalIDCard;	//身份证号
	private int					sexId;			//性别
	private String				homeTown;		//籍贯
	private int					aationId;		//民族
	private String              nationName;		//民族
	private String				endDate;		//有效期
	private String				positive;		//身份证图片
	private String				reverse;		//身份证图片
	private int					status;			//认证状态
	private String				attachPrefix;  //附件访问前缀url
	
	public String getAttachPrefix() {
		return attachPrefix;
	}


	public void setAttachPrefix(String attachPrefix) {
		this.attachPrefix = attachPrefix;
	}


	public String getNationName() {
		return nationName;
	}


	public void setNationName(String nationName) {
		this.nationName = nationName;
	}


	public RealNameAuth() {}


	public long getAid() {
		return aid;
	}


	public void setAid(long aid) {
		this.aid = aid;
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


	public int getAationId() {
		return aationId;
	}


	public void setAationId(int aationId) {
		this.aationId = aationId;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getPositive() {
		return positive;
	}


	public void setPositive(String positive) {
		this.positive = positive;
	}


	public String getReverse() {
		return reverse;
	}


	public void setReverse(String reverse) {
		this.reverse = reverse;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	

}

