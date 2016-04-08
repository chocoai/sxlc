

/** 
* @Title: MemberRedpacketsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午2:06:13 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 会员红包记录实体
 * @since 
 * @date 2016-3-22 下午2:06:13  */

public class MemberRedpacketsEntity {
	private long memberRPID; 
	/**
	 * 领取会员ID	
	 */
	private long memberID; 
	/**
	 *  领取时间
	 */
	private String receiveDate	;	
	/**
	 * 过期时间
	 */
	private String endDate	; 
	/**
	 * 红包类型 0：红包活动抽取 1：开户赠送 2：首次充值 3：首次投资 4：投资惊喜红包 5：积分商城兑换红包		
	 */
	private int giftType;	
	/**
	 * 红包金额  单位  元  保留4位小数	
	 */
	private long giftAmount;
	/**
	 * 红包金额  单位  元  保留4位小数	
	 */
	private String giftAmounts;
	/**
	 * 赠送事件ID
	 */
	private long projectId; 
	/**
	 *  使用状态 0：未使用 1：部分使用 2：完全使用	
	 */
	private int statu;
	/**
	 * 已使用红包
	 */
	private long useGiftAmount;
	/**
	 * 已使用红包
	 */
	private String useGiftAmounts;
	/**
	 * 有效的红包金额
	 */
	private long validGiftAmount;
	/**
	 * 已使用红包
	 */
	private String validGiftAmounts;
	public long getValidGiftAmount() {
		return validGiftAmount;
	}
	public void setValidGiftAmount(long validGiftAmount) {
		this.validGiftAmount = validGiftAmount;
	}
	public String getValidGiftAmounts() {
		return validGiftAmounts;
	}
	public void setValidGiftAmounts(String validGiftAmounts) {
		this.validGiftAmounts = validGiftAmounts;
	}
	public long getUseGiftAmount() {
		return useGiftAmount;
	}
	public void setUseGiftAmount(long useGiftAmount) {
		this.useGiftAmount = useGiftAmount;
	}
	public String getUseGiftAmounts() {
		return useGiftAmounts;
	}
	public void setUseGiftAmounts(String useGiftAmounts) {
		this.useGiftAmounts = useGiftAmounts;
	}
	public long getMemberRPID() {
		return memberRPID;
	}
	public void setMemberRPID(long memberRPID) {
		this.memberRPID = memberRPID;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getGiftType() {
		return giftType;
	}
	public void setGiftType(int giftType) {
		this.giftType = giftType;
	}
	public long getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(long giftAmount) {
		this.giftAmount = giftAmount;
	}
	public String getGiftAmounts() {
		return giftAmounts;
	}
	public void setGiftAmounts(String giftAmounts) {
		this.giftAmounts = giftAmounts;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}		

}

