

/** 
* @Title: RedpacketsDetailRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-20 下午4:59:55 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 红包活动明细ID
 * @since 
 * @date 2016-4-20 下午4:59:55  */

public class RedpacketsDetailRecordEntity {
	 
	private long 	rpDetailID;//活动红包明细记录ID 
	private long 	affairID; ;//红包活动记录ID 
	private int  	giftAmount;//	赠送金额  单位  元  保留4位小数 
	private int  	quantity;//	红包个数	 
	private int  	remainQuantity;//	剩余个数，初始化时和红包一样 
	private String  giftAmounts;//	赠送金额  单位  元  保留4位小数 
	public long getRpDetailID() {
		return rpDetailID;
	}
	public void setRpDetailID(long rpDetailID) {
		this.rpDetailID = rpDetailID;
	}
	public long getAffairID() {
		return affairID;
	}
	public void setAffairID(long affairID) {
		this.affairID = affairID;
	}
	public int getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(int giftAmount) {
		this.giftAmount = giftAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRemainQuantity() {
		return remainQuantity;
	}
	public void setRemainQuantity(int remainQuantity) {
		this.remainQuantity = remainQuantity;
	}
	public String getGiftAmounts() {
		return giftAmounts;
	}
	public void setGiftAmounts(String giftAmounts) {
		this.giftAmounts = giftAmounts;
	}
	
}

