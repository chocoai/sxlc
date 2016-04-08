package cn.springmvc.model;
/**
 * 底部导航条类型表
 * @author 刘利
 *
 */
public class FootNavBarTypeEntity {
	/**
	 * 底部导航条类型ID
	 */
	private long id;
	/**
	 * 导航类型名称
	 */
	private String	 name;
	/**
	 * 导航类型点击URL
	 */
	private String url;	
	/**
	 * 是否有效 0:无效 1：有效	
	 */
	private int statu;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}
