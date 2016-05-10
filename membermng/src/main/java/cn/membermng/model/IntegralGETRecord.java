package cn.membermng.model; 

/***
* 积分获取记录
* 
* @author 李杰
* @since 
* @date 2016-5-7 下午2:30:34 
*
*/
public class IntegralGETRecord {

	
	private long				iId;				//记录编号
	private long				quantity;			//积分
	private String				sQuantity;			//
	private String				pointName;			//积分获取类型名称
	private String				dateTime;			//获取时间
	private String				availableIntegral;	//当钱可用积分
	public long getiId() {
		return iId;
	}
	public void setiId(long iId) {
		this.iId = iId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(String sQuantity) {
		this.sQuantity = sQuantity;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getAvailableIntegral() {
		return availableIntegral;
	}
	public void setAvailableIntegral(String availableIntegral) {
		this.availableIntegral = availableIntegral;
	}
	
	
	
}

