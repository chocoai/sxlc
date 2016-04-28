

/** 
* @Title: LoanRepayUrgedRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午6:32:24 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 催收记录 
 * @since 
 * @date 2016-4-15 下午6:32:24  */

public class LoanRepayUrgedRecordEntity {
	private long applyID;	//项目ID		
	private long repayId;// 还款计划ID		
	private long adminID;//	 管理员ID	
	private int urgedType;// 催收方式 0：电话 1：短信 2：邮件	
	private String urgedDetail	;//	 催收内容	
	private String UrgedDate;// 操作时间	
	public long getApplyID() {
		return applyID;
	}
	public void setApplyID(long applyID) {
		this.applyID = applyID;
	}
	public long getRepayId() {
		return repayId;
	}
	public void setRepayId(long repayId) {
		this.repayId = repayId;
	}
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public int getUrgedType() {
		return urgedType;
	}
	public void setUrgedType(int urgedType) {
		this.urgedType = urgedType;
	}
	public String getUrgedDetail() {
		return urgedDetail;
	}
	public void setUrgedDetail(String urgedDetail) {
		this.urgedDetail = urgedDetail;
	}
	public String getUrgedDate() {
		return UrgedDate;
	}
	public void setUrgedDate(String urgedDate) {
		UrgedDate = urgedDate;
	}

}

