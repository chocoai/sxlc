

/** 
* @Title: OrderRecordsEntity.java 
* @Package cn.integralmall.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-22 下午7:52:28 
* @version V5.0 */
 
package cn.integralmall.model; 

/** 
 * @author 刘利 
 * @Description: 定单实体
 * @since 
 * @date 2016-4-22 下午7:52:28  */

public class OrderRecordsEntity {
	private String exchangeTime;	//兑换时间
	private String deliveryTime;	// 发货时间
	private String receiveTime;		// 收货时间
	private String logname;			//  会员用户名
	private String personalName;	//会员姓名
	private String personalPhone;	// 联系电话
	private String commodityNO;		// 商品编号
	private String commodityName;   // 商品名称
	private String quantity;		//兑换数量
	private String needPoint;		// 应付积分
	private String realPoint;		// 实际使用积分 
	private String revocationTime;	// 订单撤销时间
	private String revocationReason;	//订单撤销原因
	private String adminName;		//撤销操作员
	private int    orderType;       //订单状态
	private long   orderID;         //订单ID
	public String getExchangeTime() {
		return exchangeTime;
	}
	public void setExchangeTime(String exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getCommodityNO() {
		return commodityNO;
	}
	public void setCommodityNO(String commodityNO) {
		this.commodityNO = commodityNO;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getNeedPoint() {
		return needPoint;
	}
	public void setNeedPoint(String needPoint) {
		this.needPoint = needPoint;
	}
	public String getRealPoint() {
		return realPoint;
	}
	public void setRealPoint(String realPoint) {
		this.realPoint = realPoint;
	}
	public String getRevocationTime() {
		return revocationTime;
	}
	public void setRevocationTime(String revocationTime) {
		this.revocationTime = revocationTime;
	}
 
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public String getRevocationReason() {
		return revocationReason;
	}
	public void setRevocationReason(String revocationReason) {
		this.revocationReason = revocationReason;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
}

