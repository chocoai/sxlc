package cn.springmvc.model;
/**
 * 注册页轮播图实体类
 * @author 刘利
 *
 */
public class RegisterBannerEntity {
	/**
	 * 注册页轮播图id
	 */
	private int id;	
	/**
	 * 标题
	 */
	private String bannerTitle; 
	/**
	 * url
	 */
	private String url;
	/**
	 * 连接
	 */
	private String links;
	/**
	 * 序号
	 */
	private int indexs;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBannerTitle() {
		return bannerTitle;
	}
	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getOptId() {
		return optId;
	}
	public void setOptId(long optId) {
		this.optId = optId;
	} 
}
