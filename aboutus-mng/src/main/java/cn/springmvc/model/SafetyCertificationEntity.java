package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

/**
 * 认证资料实体类
 * @author 刘利
 *
 */
public class SafetyCertificationEntity {
	/**
	 * 认证资料id
	 */
	private long id	; 
	/**
	 * 认证资料标题
	 */
	private String title;
	/**
	 * 认证资料图片url
	 */
	private String logo;
	/**
	 * 认证链接URL
	 */
	private String url;
	/**
	 * 是否有效 0:无效 1：有效
	 */
	private int statu;
	/**
	 * 添加时间
	 */
	private Date createTime;
	private String sCreateTime;
	/**
	 * 最后一次操作时间
	 */
	private Date optDate;	
	private String sOptDate;
	/**
	 * 最后一次操作员id	
	 */
	private long optId;
	/**
	 * 最后一次操作员名称
	 */
	private String adminName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.sCreateTime = TimestampAndString.DateToString(createTime);
	}
	public String getsCreateTime() {
		return sCreateTime;
	}
	public void setsCreateTime(String sCreateTime) {
	}
	public Date getOptDate() {
		return optDate;
	}
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
		this.sOptDate = TimestampAndString.DateToString(optDate);;
	}
	public String getsOptDate() {
		return sOptDate;
	}
	public long getOptId() {
		return optId;
	}
	public void setOptId(long optId) {
		this.optId = optId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}		

}
