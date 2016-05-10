
package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * 理财顾问列表展示
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-5 上午11:41:01  */
public class FinancialAdvisorEntity {
	private long fAID;//理财顾问id
	private Date   recordDate;
	private String sRecordDate;//成为理财顾问时间
	private String realName;//理财顾问 前台姓名
	private String servicePhone;//理财顾问手机号
	private String serviceNo;//理财顾问编号
	private String logName;//会员登录名
	public long getfAID() {
		return fAID;
	}
	public void setfAID(long fAID) {
		this.fAID = fAID;
	}
	
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate = TimestampAndString.DateToString(recordDate);
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getServicePhone() {
		return servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	
}

