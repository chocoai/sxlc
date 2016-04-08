package cn.springmvc.model;
/**
 * 首页全屏弹出框配置实体类
 * @author 刘利
 *
 */
public class SafetyCertificationSetEntity {
	/**
	 * 首页全屏弹出框配置id
	 */
	private long id;
	/**
	 * 弹出公告展示图片
	 */
	private String certificationPicture;
	/**
	 * 公告链接
	 */
	private String certificationUrl;
	/**
	 * 公告弹出开始时间
	 */
	private String certificationStartTime;
	/**
	 * 公告弹出结束时间
	 */
	private String certificationEndTime;
	/**
	 * 弹出公告添加时间
	 */
	private String certificationAddTime;
	/**
	 * 最近一次操作管理员ID
	 */
	private long adminId;
	/**
	 * 状态：0无效 1有效
	 */
	private int Statu;
	/**
	 * 最近一次操作员姓名
	 */
	private String adminName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCertificationPicture() {
		return certificationPicture;
	}
	public void setCertificationPicture(String certificationPicture) {
		this.certificationPicture = certificationPicture;
	}
	public String getCertificationUrl() {
		return certificationUrl;
	}
	public void setCertificationUrl(String certificationUrl) {
		this.certificationUrl = certificationUrl;
	}
	public String getCertificationStartTime() {
		return certificationStartTime;
	}
	public void setCertificationStartTime(String certificationStartTime) {
		this.certificationStartTime = certificationStartTime;
	}
	public String getCertificationEndTime() {
		return certificationEndTime;
	}
	public void setCertificationEndTime(String certificationEndTime) {
		this.certificationEndTime = certificationEndTime;
	}
	public String getCertificationAddTime() {
		return certificationAddTime;
	}
	public void setCertificationAddTime(String certificationAddTime) {
		this.certificationAddTime = certificationAddTime;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public int getStatu() {
		return Statu;
	}
	public void setStatu(int statu) {
		Statu = statu;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "SafetyCertificationSetEntity [id=" + id
				+ ", certificationPicture=" + certificationPicture
				+ ", certificationUrl=" + certificationUrl
				+ ", certificationStartTime=" + certificationStartTime
				+ ", certificationEndTime=" + certificationEndTime
				+ ", certificationAddTime=" + certificationAddTime
				+ ", adminId=" + adminId + ", Statu=" + Statu + ", adminName="
				+ adminName + "]";
	}																																																																																																																																																																																																																																															

}
