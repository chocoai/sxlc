

/** 
* @Title: RedpacketsAffairEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-16 下午2:17:52 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import java.util.List;

/** 
 * @author 刘利 
 * @Description: 红包活动记录实体 
 * @since 
 * @date 2016-4-16 下午2:17:52  */

public class RedpacketsAffairEntity {
	private long   affairID;// ID																					
	private String affairName;// 活动名称																					
	private long   affairAccount;// 红包总金额		
	private String affairAccounts;// 红包总金额		
	private String createTime;// 添加时间		 
	private String startDate;//开始时间		
	private String endDate;// 结束时间  空表示无结束时间		
	private String userEndDate;// 使用有效期		
	private long   statu;// 状态 0：未发布 1：领取中 2：已结束（2，或者（1且已过结束时间））		
	private String realEndDate;// 实际结束时间		
	private String remark;// 备注		
    private int    quantity;//活动红包总个数 
	private long   receiveAffair;//已领取活动红包总金额	
	private long   remainingAffair;//剩余活动红包总金额
	private String receiveAffairs;//已领取活动红包总金额	
	private String remainingAffairs;//剩余活动红包总金额
	private List<RedpacketsDetailRecordEntity> redpacketsDetail;//红包活动明细
	public long getAffairID() {
		return affairID;
	}
	public void setAffairID(long affairID) {
		this.affairID = affairID;
	}
	public String getAffairName() {
		return affairName;
	}
	public void setAffairName(String affairName) {
		this.affairName = affairName;
	}
	public long getAffairAccount() {
		return affairAccount;
	}
	public void setAffairAccount(long affairAccount) {
		this.affairAccount = affairAccount;
	}
	public String getAffairAccounts() {
		return affairAccounts;
	}
	public void setAffairAccounts(String affairAccounts) {
		this.affairAccounts = affairAccounts;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUserEndDate() {
		return userEndDate;
	}
	public void setUserEndDate(String userEndDate) {
		this.userEndDate = userEndDate;
	}
	public long getStatu() {
		return statu;
	}
	public void setStatu(long statu) {
		this.statu = statu;
	}
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getReceiveAffair() {
		return receiveAffair;
	}
	public void setReceiveAffair(long receiveAffair) {
		this.receiveAffair = receiveAffair;
	}
	public long getRemainingAffair() {
		return remainingAffair;
	}
	public void setRemainingAffair(long remainingAffair) {
		this.remainingAffair = remainingAffair;
	}
	public String getReceiveAffairs() {
		return receiveAffairs;
	}
	public void setReceiveAffairs(String receiveAffairs) {
		this.receiveAffairs = receiveAffairs;
	}
	public String getRemainingAffairs() {
		return remainingAffairs;
	}
	public void setRemainingAffairs(String remainingAffairs) {
		this.remainingAffairs = remainingAffairs;
	}
	public List<RedpacketsDetailRecordEntity> getRedpacketsDetail() {
		return redpacketsDetail;
	}
	public void setRedpacketsDetail(
			List<RedpacketsDetailRecordEntity> redpacketsDetail) {
		this.redpacketsDetail = redpacketsDetail;
	}
	
	 
}

