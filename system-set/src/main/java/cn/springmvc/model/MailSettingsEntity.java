
package cn.springmvc.model; 

/**
 * 邮件设置 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午5:01:21  */
public class MailSettingsEntity {
	private String smtpservice;//SMTP服务器	
	private String portNumber;//端口号	
	private String emailAddress;//邮箱地址	
	private String emailPassword;//邮箱密码
	public String getSmtpservice() {
		return smtpservice;
	}
	public void setSmtpservice(String smtpservice) {
		this.smtpservice = smtpservice;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	

}

