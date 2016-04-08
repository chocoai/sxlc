package cn.springmvc.model;
/**
 * 管理团队实体类
 * @author 刘利
 *
 */
public class MngTeamEntity {
	/**
	 * 管理团队id
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
	private String createTime; 
	/**
	 * 最后一次添加时间
	 */
	private String optDate; 
	/**
	 * 最后一次操作员id
	 */
	private long optId;
	/**
	 * 操作员name
	 */
	private String optName; 
	
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOptDate() {
		return optDate;
	}
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	} 	

}
