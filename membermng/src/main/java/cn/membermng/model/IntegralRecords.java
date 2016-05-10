package cn.membermng.model;



/***
* 积分消费记录实体
* @author 李杰
* @since 
* @date 2016-3-30 上午10:12:48 
*
 */
public class IntegralRecords {
	
	private long 					orderId;			//订单编号
	private long					quantity;			//积分					
	private String					eTName;				//兑换类型名称
	private String					cName;				//商品名称
	private String					numbers;			//兑换数量
	private String					eTime;				//兑换时间
	private String					rTime;				//收货时间
	private String					oType;				//订单状态
	private String					oTypeName;			//订单状态名称
	
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String geteTName() {
		return eTName;
	}
	public void seteTName(String eTName) {
		this.eTName = eTName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getoType() {
		return oType;
	}
	public void setoType(String oType) {
		this.oType = oType;
	}
	public String getoTypeName() {
		return oTypeName;
	}
	public void setoTypeName(String oTypeName) {
		this.oTypeName = oTypeName;
	}
	
	
}

