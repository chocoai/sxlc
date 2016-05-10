

/**
 * @author pengran
 *  黑名单受限
 * @date:2016-5-10 上午10:17:26
 **/
 
package cn.membermng.model; 


public class BlackLimitEntity {
	private int optType;   //操作类型 0：借款 1：投资 2：提现 3：积分兑换 4：抽奖 5：抢红包
	private int status;		//操作状态 0：不可操作 
	public int getOptType() {
		return optType;
	}
	public void setOptType(int optType) {
		this.optType = optType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

