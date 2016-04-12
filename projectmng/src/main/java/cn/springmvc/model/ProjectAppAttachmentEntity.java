
package cn.springmvc.model; 

/** 
 * 项目申请附件资料
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午5:19:27  */
public class ProjectAppAttachmentEntity {
	private long applyId;//	项目申请ID
	private int attachInfoType;//附件类型：0：其他 1：借款方资料 2：抵押资料 3：现场调查资料	
	private String attachTitle;//附件标题	
	private String attachUrl;//	附件路径
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public int getAttachInfoType() {
		return attachInfoType;
	}
	public void setAttachInfoType(int attachInfoType) {
		this.attachInfoType = attachInfoType;
	}
	public String getAttachTitle() {
		return attachTitle;
	}
	public void setAttachTitle(String attachTitle) {
		this.attachTitle = attachTitle;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
	
}

