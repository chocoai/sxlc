
package cn.springmvc.model; 

/** 
 * 担保机构担保借款范围
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 下午3:39:32  */
public class GuaranteeBorrowingEntity {
	private long guaranteeID;//担保机构ID
	private long minAmount;//最小担保借款金额
	private long maxAmount;//最大担保借款金额
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	public long getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(long minAmount) {
		this.minAmount = minAmount;
	}
	public long getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(long maxAmount) {
		this.maxAmount = maxAmount;
	}
	
}

