
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * VIP购买记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-2 下午2:24:37  */
public class VIPPurchaseRecordsEntity {
	private String 			addTime;			//记录时间
	private String 			statrTime;			//开始时间
	private String 			endTime;			//结束时间
	private int 			vipType;			//vip购买类型
	private String			vipTypeName;
	private long 			amount;				//使用金额
	private String			sAmount;			//
	
	
	
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getStatrTime() {
		return statrTime;
	}
	public void setStatrTime(String statrTime) {
		this.statrTime = statrTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getVipType() {
		return vipType;
	}
	public void setVipType(int vipType) {
		this.vipType = vipType;
	}
	public String getVipTypeName() {
		return vipTypeName;
	}
	public void setVipTypeName(String vipTypeName) {
		this.vipTypeName = vipTypeName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.sAmount = IntegerAndString.LongToString(amount);
	}
	public String getsAmount() {
		return sAmount;
	}
	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}
	
	
}

