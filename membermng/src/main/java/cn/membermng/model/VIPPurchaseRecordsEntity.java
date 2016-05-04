
package cn.membermng.model; 

/** 
 * VIP购买记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-2 下午2:24:37  */
public class VIPPurchaseRecordsEntity {
	private String addTime;//记录时间
	private String statrTime;//开始时间
	private String endTime;//结束时间
	private int VipType;//vip购买类型
	private long amount;//使用金额
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
		return VipType;
	}
	public void setVipType(int vipType) {
		VipType = vipType;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}

