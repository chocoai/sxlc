package cn.springmvc.model;
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
	private String createTime;
	/**
	 * 最后一次操作时间
	 */
	private String optDate;	
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
