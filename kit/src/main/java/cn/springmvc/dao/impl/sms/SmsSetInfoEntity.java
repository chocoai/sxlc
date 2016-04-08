package cn.springmvc.dao.impl.sms;
/**
 * 短信配置实体类
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午3:06:24
 */
public class SmsSetInfoEntity {
	private String sInterface;				//接口地址
	private String sSn;						//短信序列号
	private String sPwd;					//短信密码
	public String getsInterface() {
		return sInterface;
	}
	public void setsInterface(String sInterface) {
		this.sInterface = sInterface;
	}
	public String getsSn() {
		return sSn;
	}
	public void setsSn(String sSn) {
		this.sSn = sSn;
	}
	public String getsPwd() {
		return sPwd;
	}
	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}
}

