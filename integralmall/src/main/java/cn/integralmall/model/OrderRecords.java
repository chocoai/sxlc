package cn.integralmall.model; 

import java.util.Date;


/***
* 订单记录表
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-11 下午3:30:24 
*
*/
public class OrderRecords {

	
	private long				orderId						;//订单序号
	private long				memberId					;//会员编号
	private long				addressId					;//收货地址序号
	private int					exchangeType				;//兑换类型
	private String				exchangeTypeName			;//兑换类型名称
	private long				orderNO						;//订单号
	private Date				exchangeTime				;//兑换时间
	private Date				deliveryTime				;//发货时间
	private Date				receiveTime					;//收货时间
	private int					orderType					;//订单状态
	private String				orderTypeName				;//订单状态名称
	private int					undoflag					;//撤销标记1有效 0已撤销
	private long				revocationPerson			;//撤销人员
	private Date				revocationTime				;//订单撤销时间
	private String				revocationReason			;//撤销原因
	private String				logisticsCompany			;//物流公司
	private String				logisticsNO					;//物流单号
	private String				information					;//通知信息
	private int					deleteFlag					;//删除标记1有效 0已删除
	
	public OrderRecords() {	}

	
	public OrderRecords(long orderId, long memberId, long addressId,
			int exchangeType, String exchangeTypeName, long orderNO,
			Date exchangeTime, Date deliveryTime, Date receiveTime,
			int orderType, String orderTypeName, int undoflag,
			long revocationPerson, Date revocationTime,
			String revocationReason, String logisticsCompany,
			String logisticsNO, String information, int deleteFlag) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.addressId = addressId;
		this.exchangeType = exchangeType;
		this.exchangeTypeName = exchangeTypeName;
		this.orderNO = orderNO;
		this.exchangeTime = exchangeTime;
		this.deliveryTime = deliveryTime;
		this.receiveTime = receiveTime;
		this.orderType = orderType;
		this.orderTypeName = orderTypeName;
		this.undoflag = undoflag;
		this.revocationPerson = revocationPerson;
		this.revocationTime = revocationTime;
		this.revocationReason = revocationReason;
		this.logisticsCompany = logisticsCompany;
		this.logisticsNO = logisticsNO;
		this.information = information;
		this.deleteFlag = deleteFlag;
	}


	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(int exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getExchangeTypeName() {
		return exchangeTypeName;
	}

	public void setExchangeTypeName(String exchangeTypeName) {
		this.exchangeTypeName = exchangeTypeName;
	}

	public long getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(long orderNO) {
		this.orderNO = orderNO;
	}

	public Date getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getOrderTypeName() {
		return orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}

	public int getUndoflag() {
		return undoflag;
	}

	public void setUndoflag(int undoflag) {
		this.undoflag = undoflag;
	}

	public long getRevocationPerson() {
		return revocationPerson;
	}

	public void setRevocationPerson(long revocationPerson) {
		this.revocationPerson = revocationPerson;
	}

	public Date getRevocationTime() {
		return revocationTime;
	}

	public void setRevocationTime(Date revocationTime) {
		this.revocationTime = revocationTime;
	}

	public String getRevocationReason() {
		return revocationReason;
	}

	public void setRevocationReason(String revocationReason) {
		this.revocationReason = revocationReason;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getLogisticsNO() {
		return logisticsNO;
	}

	public void setLogisticsNO(String logisticsNO) {
		this.logisticsNO = logisticsNO;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	
}

