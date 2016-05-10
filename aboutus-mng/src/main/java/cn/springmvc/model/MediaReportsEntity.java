package cn.springmvc.model;
/**
 * 媒体报道实体类
 * @author 刘利
 *
 */
public class MediaReportsEntity {
	/**
	 * 媒体报道ID
	 */
	private long id; 	
	/**
	 * 媒体报道标题
	 */
	private String title;
	/**
	 * 媒体报道Logo路径
	 */ 
	private String logo;
	/**
	 * 报道来源
	 */
	private String source;	
	/**
	 * 媒体报道内容
	 */
	private String content;	
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
	private long nexID;//下一篇ID
	private long preID;//上一篇ID
	public long getPreID() {
		return preID;
	}
	public void setPreID(long preID) {
		this.preID = preID;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public long getNexID() {
		return nexID;
	}
	public void setNexID(long nexID) {
		this.nexID = nexID;
	} 
}
