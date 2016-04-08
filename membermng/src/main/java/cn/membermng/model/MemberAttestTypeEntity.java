
package cn.membermng.model; 

/** 
 * 会员认证类型
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 上午10:27:51  */
public class MemberAttestTypeEntity {
	private long attestTypeID;//
	private int memberType;//会员类型
	private String attestTypeName;//认证项类型名称
	private int attachType;//附件类型
	private String pictureUrl;//认证图片路径
	private int needCheck;//是否需要后台审核
	private int canMore;//是否可以添加多个
	private int typeCure;//是否为固化0
	private int creditScore;//信用积分
	private int statu;//状态
	public long getAttestTypeID() {
		return attestTypeID;
	}
	public void setAttestTypeID(long attestTypeID) {
		this.attestTypeID = attestTypeID;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getAttestTypeName() {
		return attestTypeName;
	}
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	public int getAttachType() {
		return attachType;
	}
	public void setAttachType(int attachType) {
		this.attachType = attachType;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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
	
	
}

