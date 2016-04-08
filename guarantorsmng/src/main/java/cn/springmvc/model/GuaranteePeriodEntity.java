
package cn.springmvc.model; 

/** 
 * 担保机构期限范围设置
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-21 下午4:08:33  */
public class GuaranteePeriodEntity {
	private long guaranteeID;//担保机构ID
	private int minDeadline;//最小期限
	private int maxDeadline;//最大期限
	private int deadlineType;//期限类型
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	public int getMinDeadline() {
		return minDeadline;
	}
	public void setMinDeadline(int minDeadline) {
		this.minDeadline = minDeadline;
	}
	public int getMaxDeadline() {
		return maxDeadline;
	}
	public void setMaxDeadline(int maxDeadline) {
		this.maxDeadline = maxDeadline;
	}
	public int getDeadlineType() {
		return deadlineType;
	}
	public void setDeadlineType(int deadlineType) {
		this.deadlineType = deadlineType;
	}
	
}

