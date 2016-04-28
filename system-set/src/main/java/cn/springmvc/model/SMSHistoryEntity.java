
package cn.springmvc.model; 

/** 
 * 短信发送历史记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-28 上午11:30:03  */
public class SMSHistoryEntity {
	private String personalPhone;//接收人邮箱
	private String personalName;//接收人
	private String msgDetail;//邮件内容
	private int recordType;//发送类型（手动发送、平台自动发送）
	private String recordDate;//发送时间
	private String adminName;//发送操作管理员
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getMsgDetail() {
		return msgDetail;
	}
	public void setMsgDetail(String msgDetail) {
		this.msgDetail = msgDetail;
	}
	public int getRecordType() {
		return recordType;
	}
	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}

