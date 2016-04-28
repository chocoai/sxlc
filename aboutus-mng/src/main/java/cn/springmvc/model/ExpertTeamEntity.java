package cn.springmvc.model;

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;

import sun.misc.Timeable;

/**
 * 专家顾问实体类
 * @author 刘利
 *
 */
public class ExpertTeamEntity {
	/**
	 * 专家顾问id
	 */ 
	private long id;
	/**
	 * 姓名
	 */
	private String mngName; 
	/**
	 * 职务
	 */
	private String mngPost; 
	/**
	 * 头像url
	 */
	private String portraitUrl; 	
	/**
	 * 简介
	 */
	private String profile; 
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
	 * 最后一次添加时间
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
 
 
	public String getMngName() {
		return mngName;
	}
	public void setMngName(String mngName) {
		this.mngName = mngName;
	}
	public String getMngPost() {
		return mngPost;
	}
	public void setMngPost(String mngPost) {
		this.mngPost = mngPost;
	}
	public String getPortraitUrl() {
		return portraitUrl;
	}
	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
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
	public Date getOptDate() {
		return optDate;
	}
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
		this.sOptDate = TimestampAndString.DateToString(optDate);
	}
	public String getsOptDate() {
		return sOptDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
