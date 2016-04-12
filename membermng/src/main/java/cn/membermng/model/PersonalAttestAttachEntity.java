
package cn.membermng.model; 

/**
 * 会员认证附件信息 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午3:37:00  */
public class PersonalAttestAttachEntity {
	private long attestID;//认证记录ID
	private String attachName;//认证附件标题
	private int attachType;//附件类型
	private String attachTypeName;//附件类型名称
	private String uploadtime;//附件上传时间
	private String attachPath;//附件路径
	public long getAttestID() {
		return attestID;
	}
	public void setAttestID(long attestID) {
		this.attestID = attestID;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public int getAttachType() {
		return attachType;
	}
	public void setAttachType(int attachType) {
		this.attachType = attachType;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	public String getAttachTypeName() {
		return attachTypeName;
	}
	public void setAttachTypeName(String attachTypeName) {
		this.attachTypeName = attachTypeName;
	}
	
}

