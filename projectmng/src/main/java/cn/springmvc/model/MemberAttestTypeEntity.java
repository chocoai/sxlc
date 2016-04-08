package  cn.springmvc.model;
/**
 * 会员认证类型实体类
 * @author 刘利
 *
 */
public class MemberAttestTypeEntity {
	/**
	 * 会员认证类型id
	 */
	private int attestTypeID;
	/**
	 * 0：个人会员 1：企业会员
	 */
	private int memberType;
	/**
	 * 认证项类型名称	
	 */
	private String attestTypeName; 
	/**
	 * 附件类型 0：图片 1：offic文件 2：音频 3：视频
	 */
	private int attachType;
	/**
	 * 认证图片路径
	 */
	private String pictureUrl;
	/**
	 *  是否需要后台审核 0：否 1：是
	 */
	private int needCheck;	
	/**
	 * 是否可以添加多个   0：否 1：是
	 */
	private int canMore;
	/**
	 * 是否为固化 1：是 0：否	
	 */
	private int typeCure; 
	/**
	 * 信用积分
	 */
	private int creditScore; 
	/**
	 * 状态 0：停用 1：启用	
	 */
	private int statu;
	/**
	 * 最后一次操作时间	
	 */
	private String optDate;
	/**
	 * 最后一次操作员id
	 */
	private int optId;
	/**
	 * 最后一次操作员姓名
	 */
	private String adminName;
	public String getAttestTypeName() {
		return attestTypeName;
	}
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getOptDate() {
		return optDate;
	}
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	} 
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	} 
	public int getAttachType() {
		return attachType;
	}
	public void setAttachType(int attachType) {
		this.attachType = attachType;
	} 
	public int getNeedCheck() {
		return needCheck;
	}
	public void setNeedCheck(int needCheck) {
		this.needCheck = needCheck;
	}
	public int getCanMore() {
		return canMore;
	}
	public void setCanMore(int canMore) {
		this.canMore = canMore;
	}
	public int getTypeCure() {
		return typeCure;
	}
	public void setTypeCure(int typeCure) {
		this.typeCure = typeCure;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	} 
	public int getOptId() {
		return optId;
	}
	public void setOptId(int optId) {
		this.optId = optId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	} 
	public int getAttestTypeID() {
		return attestTypeID;
	}
	public void setAttestTypeID(int attestTypeID) {
		this.attestTypeID = attestTypeID;
	}
	@Override
	public String toString() {
		return "MemberAttestTypeEntity [attestTypeID=" + attestTypeID
				+ ", memberType=" + memberType + ", attestTypeName="
				+ attestTypeName + ", attachType=" + attachType
				+ ", pictureUrl=" + pictureUrl + ", needCheck=" + needCheck
				+ ", canMore=" + canMore + ", typeCure=" + typeCure
				+ ", creditScore=" + creditScore + ", statu=" + statu
				+ ", optDate=" + optDate + ", optId=" + optId + ", adminName="
				+ adminName + "]";
	}

}
