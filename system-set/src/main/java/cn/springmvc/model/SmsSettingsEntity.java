
package cn.springmvc.model; 

/** 
 * 短信设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午3:24:42  */
public class SmsSettingsEntity {
	private long id;//	
	private String smsInterface;//短信接口地址
	private String smsSerialNumber;//	短信序列号
	private String smsPassword;//	密码
	private String recordDate;//	添加时间
	private String optDate;//	最后一次操作时间
	private long optId;//	最后一次操作员id
	private String optName;//	最后一次操作员
	private int statu;//	是否有效 0:无效 1：有效
	private int smsInterfaceType;//接口类型 0：发送短信 1：接收短信 2：查询余额
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSmsInterface() {
		return smsInterface;
	}
	public void setSmsInterface(String smsInterface) {
		this.smsInterface = smsInterface;
	}
	public String getSmsSerialNumber() {
		return smsSerialNumber;
	}
	public void setSmsSerialNumber(String smsSerialNumber) {
		this.smsSerialNumber = smsSerialNumber;
	}
	public String getSmsPassword() {
		return smsPassword;
	}
	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getOptDate() {
		return optDate;
	}
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	}
	public long getOptId() {
		return optId;
	}
	public void setOptId(long optId) {
		this.optId = optId;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "SmsSettingsEntity [id=" + id + ", smsInterface(短信接口地址)=" + smsInterface
				+ ", smsSerialNumber(短信序列号)=" + smsSerialNumber + ", smsPassword(密码)="
				+ smsPassword + ", optId(最后一次操作员id)=" + optId+"]";
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public int getSmsInterfaceType() {
		return smsInterfaceType;
	}
	public void setSmsInterfaceType(int smsInterfaceType) {
		this.smsInterfaceType = smsInterfaceType;
	}

}

