package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

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
	private Date certificationStartTime;
	private String  certificationStartTimes;
	/**
	 * 公告弹出结束时间
	 */
	private Date certificationEndTime;
	private String certificationEndTimes;
	/**
	 * 弹出公告添加时间
	 */
	private Date certificationAddTime;
	private String certificationAddTimes;
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
	
	public Date getCertificationStartTime() {
		return certificationStartTime;
	}
	public void setCertificationStartTime(Date certificationStartTime) {
		this.certificationStartTime = certificationStartTime;
		this.certificationStartTimes = TimestampAndString.DateToString(certificationStartTime);
	}
	public String getCertificationStartTimes() {
		return certificationStartTimes;
	}
	public Date getCertificationEndTime() {
		return certificationEndTime;
	}
	public void setCertificationEndTime(Date certificationEndTime) {
		this.certificationEndTime = certificationEndTime;
		this.certificationEndTimes = TimestampAndString.DateToString(certificationEndTime);
	}
	public String getCertificationEndTimes() {
		return certificationEndTimes;
	}
	public Date getCertificationAddTime() {
		return certificationAddTime;
	}
	public void setCertificationAddTime(Date certificationAddTime) {
		this.certificationAddTime = certificationAddTime;
		this.certificationAddTimes = TimestampAndString.DateToString(certificationAddTime);
	}
	public String getCertificationAddTimes() {
		return certificationAddTimes;
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
