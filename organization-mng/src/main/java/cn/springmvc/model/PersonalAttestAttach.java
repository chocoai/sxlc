package cn.springmvc.model;

import java.util.Date;





/***
 * 会员认附件表
 * @author LiJie
 *
 */
public class PersonalAttestAttach {

	private Long			attestId;				//附件序号
	private String			attachName;				//认证附件标题
	private Integer			attachType;				//附件类型
	private Date			uploadTime;				//上传时间
	private String			attachPath;				//附件路径
	
	public PersonalAttestAttach() {}

	public PersonalAttestAttach(Long attestId, String attachName,
			Integer attachType, Date uploadTime, String attachPath) {
		super();
		this.attestId = attestId;
		this.attachName = attachName;
		this.attachType = attachType;
		this.uploadTime = uploadTime;
		this.attachPath = attachPath;
	}

	public Long getAttestId() {
		return attestId;
	}

	public void setAttestId(Long attestId) {
		this.attestId = attestId;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public Integer getAttachType() {
		return attachType;
	}

	public void setAttachType(Integer attachType) {
		this.attachType = attachType;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	
	
}
