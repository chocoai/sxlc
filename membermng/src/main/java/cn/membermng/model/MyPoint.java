package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/***
* 
* 我的积分信息
* 
* @author 李杰
* @since 
* @date 2016-5-7 下午12:16:51 
*
 */
public class MyPoint {

	
	private long			cumulativeIntegral;				//累计积分
	private String			sCumulativeIntegral;			//
	private long			availableIntegral;				//可用积分
	private String			sAvailableIntegral;				//
	private long			usedIntegral;					//已用积分
	private String			sUsedIntegral;					//
	
	
	
	public long getCumulativeIntegral() {
		return cumulativeIntegral;
	}
	public void setCumulativeIntegral(long cumulativeIntegral) {
		this.cumulativeIntegral = cumulativeIntegral;
		this.sCumulativeIntegral = IntegerAndString.LongToString(cumulativeIntegral);
	}
	public String getsCumulativeIntegral() {
		return sCumulativeIntegral;
	}
	public void setsCumulativeIntegral(String sCumulativeIntegral) {
		this.sCumulativeIntegral = sCumulativeIntegral;
	}
	public long getAvailableIntegral() {
		return availableIntegral;
	}
	public void setAvailableIntegral(long availableIntegral) {
		this.availableIntegral = availableIntegral;
		this.sAvailableIntegral = IntegerAndString.LongToString(availableIntegral);
	}
	public String getsAvailableIntegral() {
		return sAvailableIntegral;
	}
	public void setsAvailableIntegral(String sAvailableIntegral) {
		this.sAvailableIntegral = sAvailableIntegral;
	}
	public long getUsedIntegral() {
		return usedIntegral;
	}
	public void setUsedIntegral(long usedIntegral) {
		this.usedIntegral = usedIntegral;
		this.sUsedIntegral = IntegerAndString.LongToString(usedIntegral);
	}
	public String getsUsedIntegral() {
		return sUsedIntegral;
	}
	public void setsUsedIntegral(String sUsedIntegral) {
		this.sUsedIntegral = sUsedIntegral;
	}
	
	
}

