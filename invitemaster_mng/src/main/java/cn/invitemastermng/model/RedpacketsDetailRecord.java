package cn.invitemastermng.model; 

/***
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-13 下午7:24:51 
*
*/
public class RedpacketsDetailRecord {

	private long				rPDetailId						;//活动红包记录比编号
	private long				affairId						;//红包活动编号
	private int					giftAmount						;//赠送金额
	private int					quantity						;//红包个数
	private int					remainQuantity					;//剩余个数
	
	public RedpacketsDetailRecord() {}

	public RedpacketsDetailRecord(long rPDetailId, long affairId,
			int giftAmount, int quantity, int remainQuantity) {
		super();
		this.rPDetailId = rPDetailId;
		this.affairId = affairId;
		this.giftAmount = giftAmount;
		this.quantity = quantity;
		this.remainQuantity = remainQuantity;
	}


	public long getrPDetailId() {
		return rPDetailId;
	}

	public void setrPDetailId(long rPDetailId) {
		this.rPDetailId = rPDetailId;
	}

	public long getAffairId() {
		return affairId;
	}

	public void setAffairId(long affairId) {
		this.affairId = affairId;
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
	
	
	
	
	
}

