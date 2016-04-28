

/** 
* @Title: MemberLoginRecordEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午8:50:31 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员登录实体 
 * @since 
 * @date 2016-4-13 下午8:50:31  */

public class MemberLoginRecordEntity {
	private long    memberID;//会员ID
	private String	logname;//会员名称
	private String	personalName;//真实姓名
	private String	personalPhone;//联系电话
	private String	recordDate;//登录时间
	private String	ipAddr;//登录IP
	private String	area;//登录区域
	private String	isp;//网络运营商
	private String	regClient;//登录客户端
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
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getRegClient() {
		return regClient;
	}
	public void setRegClient(String regClient) {
		this.regClient = regClient;
	}
}

