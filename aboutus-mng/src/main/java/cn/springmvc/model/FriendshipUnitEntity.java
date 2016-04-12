package cn.springmvc.model;
/**
 * 友情单位实体类
 * @author 刘利
 *
 */ 
public class FriendshipUnitEntity {
	/**
	 * 友情链接ID	
	 */
	 private long id	;	 
	/**
	 * 友情链接名	
	 */
    private String	name;
	/**
	 * 友情链接名Logo路劲
	 */
	private String  logo; 
	/**
	 * 友情链接URL	
	 */
	private String url;
	/**
	 * 友情链接简介
	 */
	private String introduction;	
	/**
	 * 是否有效,默认值为true,true:有效,false:无效	
	 */
	private boolean statu;	
	/**
	 * 添加时间
	 */
	private String  createTime;	
	/**
	 * 序号
	 */
    private  int	indexs;	
    /**
     * 最后一次操作员ID
     */
	private long optId;	
	/**
	 * 最后一次操作时间
	 */
	private int optDate;
	/**
	 * 最后一次操作员名称
	 */
	private String adminName; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	 
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	} 
	public int getOptDate() {
		return optDate;
	}
	public void setOptDate(int optDate) {
		this.optDate = optDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}			

}
