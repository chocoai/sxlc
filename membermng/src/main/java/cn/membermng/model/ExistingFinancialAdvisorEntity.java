
package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * 已有理财顾问会员
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-5 下午4:23:35  */
public class ExistingFinancialAdvisorEntity {
	private long memberID;//会员id
	private String memberNo;//会员编号
	private String logName;//会员用户名
	private Date regDate;//注册时间  / 移除时间
	private String  sRegDate;	//注册时间
	private String personalName;//姓名
	private int	therStatu;//是否开通第三方；大于0：是 等于0 ：否
	private long faid;//原理财顾问id
	private String fAName;//理财顾问姓名
	
	public String getsRegDate() {
		return sRegDate;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		this.sRegDate = TimestampAndString.DateToString(regDate);
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public int getTherStatu() {
		return therStatu;
	}
	public void setTherStatu(int therStatu) {
		this.therStatu = therStatu;
	}
	public long getFaid() {
		return faid;
	}
	public void setFaid(long faid) {
		this.faid = faid;
	}
	public String getfAName() {
		return fAName;
	}
	public void setfAName(String fAName) {
		this.fAName = fAName;
	}
	
}

