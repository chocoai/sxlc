package cn.springmvc.model;
/**
 * 审批活动实体类
 * @author 刘利
 *
 */
public class ProcessProjectEntity {
	/**
	 * 审批流程id
	 */
	private int id;
	/**
	 * 审批活动点ID	
	 */
	private int apID;
	/**
	 * 审核批次 0：平台初审 1：担保机构审核 2：平台终审
	 */
	private int batch;	
	/**
	 * 审核序号
	 */
	private int indexs;	
	/**
	 * 状态 0：无效 1：有效
	 */
	private int statu;	
	/**
	 * 审批活动点名称
	 */
	private String apName;
	/**
	 * 审批最后一步（发布）的审核序号
	 */
	private int pushIndex;
	
	/**
	 * 审核第一步的审核序号
	 */
	private int firstIndex;
	
	private int result;
	public int getApID() {
		return apID;
	}
	public void setApID(int apID) {
		this.apID = apID;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
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
	public String getApName() {
		return apName;
	}
	public void setApName(String apName) {
		this.apName = apName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPushIndex() {
		return pushIndex;
	}
	public void setPushIndex(int pushIndex) {
		this.pushIndex = pushIndex;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	} 

}
