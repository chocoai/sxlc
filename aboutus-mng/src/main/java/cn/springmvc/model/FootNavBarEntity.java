package cn.springmvc.model;
/**
 * 底部导航条实体类
 * @author 刘利
 *
 */
public class FootNavBarEntity {
	/**
	 * 底部导航条id
	 */
	private long  id;
	/**
	 * 导航类型ID
	 */
	private long typeId;
	/**
	 * 导航名称
	 */
	private String  title;	
	/**
	 * 导航点击URL
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
	 * 底部导航条类型名称
	 */
	private String name;
	/**
	 * 底部导航条类型实体
	 */
	private FootNavBarTypeEntity footNavBarType;
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
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	/**
	 * 最后一次操作员id	
	 */
	private int optId;
	public int getOptId() {
		return optId;
	}
	public void setOptId(int optId) {
		this.optId = optId;
	}
	public FootNavBarTypeEntity getFootNavBarType() {
		return footNavBarType;
	}
	public void setFootNavBarType(FootNavBarTypeEntity footNavBarType) {
		this.footNavBarType = footNavBarType;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}		

}
