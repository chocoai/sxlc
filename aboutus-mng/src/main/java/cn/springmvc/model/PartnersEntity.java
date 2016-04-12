package cn.springmvc.model;
/**
 * 合作伙伴实体类
 * @author 刘利
 *
 */
public class PartnersEntity {
	/**
	 * 合作伙伴ID
	 */
	private  long id	;
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
	 * 合作伙伴名称
	 */
	private String name;	
	/**
	 * 合作伙伴名称Logo路径
	 */
	private String logo;
	/**
	 * 合作伙伴URL
	 */
	private String url;		
	/**
	 * 合作伙伴简介	
	 */
	private String introduction	;
	/**
	 * 是否有效,默认值为true, true：有效 false：无效	
	 */
	private boolean statu;	
	/**
	 * 添加时间
	 */
	private String createTime;	
	/**
	 * 序号
	 */
	private int indexs;	
	/**
	 * 最后一次操作员id	
	 */
	private long optId;	
	/**
	 * 最后一次操作时间
	 */
	private String optDate;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getOptDate() {
		return optDate;
	}
	public void setOptDate(String optDate) {
		this.optDate = optDate;
	}			

}
