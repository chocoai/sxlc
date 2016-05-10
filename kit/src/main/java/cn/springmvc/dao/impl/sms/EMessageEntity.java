package cn.springmvc.dao.impl.sms;

/**
 * 短信-邮箱 接口实体类
 * @author ZZY
 *@version 0.0.1
 */
public class EMessageEntity {
	private int id;
	private String smtpservice;//SMTP服务器
	private String port_Number;//端口号
	private String email_Address;//邮箱地址
	private String email_Password;//邮箱密码
	private String sms_Interface;//短信接口地址
	private String sms_SerialNumber;//短信序列号
	private String sms_Password;//密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSmtpservice() {
		return smtpservice;
	}
	public void setSmtpservice(String smtpservice) {
		this.smtpservice = smtpservice;
	}
	public String getPort_Number() {
		return port_Number;
	}
	public void setPort_Number(String port_Number) {
		this.port_Number = port_Number;
	}
	public String getEmail_Address() {
		return email_Address;
	}
	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}
	public String getEmail_Password() {
		return email_Password;
	}
	public void setEmail_Password(String email_Password) {
		this.email_Password = email_Password;
	}
	public String getSms_Interface() {
		return sms_Interface;
	}
	public void setSms_Interface(String sms_Interface) {
		this.sms_Interface = sms_Interface;
	}
	public String getSms_SerialNumber() {
		return sms_SerialNumber;
	}
	public void setSms_SerialNumber(String sms_SerialNumber) {
		this.sms_SerialNumber = sms_SerialNumber;
	}
	public String getSms_Password() {
		return sms_Password;
	}
	public void setSms_Password(String sms_Password) {
		this.sms_Password = sms_Password;
	}
	
}
