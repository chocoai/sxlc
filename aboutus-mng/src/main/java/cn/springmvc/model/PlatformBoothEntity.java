

/** 
* @Title: PlatformBoothEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:11:20 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 平台宣传点
 * @since 
 * @date 2016-4-12 下午7:11:20  */

public class PlatformBoothEntity { 
	private long	sgID;//	平台宣传点ID 
	private String	asTitle;//	标题	 
	private String	sgContent;//内容	 
	private String	sgPic;//	图片路径 
	private String	sgUrl;//	链接地址 
	private String  createTime;//	添加时间 
	private String	optDate;//	最后一次操作时间 
	private long    adminID;//	管理员ID	
	private String  adminName;//管理员名称
	private int     statu;	 //状态
	public long getSgID() {
		return sgID;
	}
	public void setSgID(long sgID) {
		this.sgID = sgID;
	}
	public String getAsTitle() {
		return asTitle;
	}
	public void setAsTitle(String asTitle) {
		this.asTitle = asTitle;
	}
	public String getSgContent() {
		return sgContent;
	}
	public void setSgContent(String sgContent) {
		this.sgContent = sgContent;
	}
	public String getSgPic() {
		return sgPic;
	}
	public void setSgPic(String sgPic) {
		this.sgPic = sgPic;
	}
	public String getSgUrl() {
		return sgUrl;
	}
	public void setSgUrl(String sgUrl) {
		this.sgUrl = sgUrl;
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
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
}

