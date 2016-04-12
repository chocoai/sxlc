package cn.springmvc.model;
/**
 * 平台公告实体类
 * @author 刘利
 *
 */
public class PlatformAnnouncementEntity {
	/**
	 * 平台公告ID
	 */
	private long id;
	/**
	 * 平台公告标题
	 */
	private String title; 
	/**
	 * 公告内容
	 */
 	private String content;
 	/**
 	 * 是否有效,0:无效 1：有效
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
