package cn.membermng.model;

import product_p2p.kit.datatrans.IntegerAndString;

/***
* 我的红包
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-30 上午11:48:03 
*
 */
public class MyRedPackage {

	
	private long 		redPackageSum = 0;							//红包总额
	private String 		sRedPackageSum;							
	private long		expiredSum = 0;								//已过期红包
	private String		sExpiredSum;							
	private long		useRedPackageSum = 0;						//已使用
	private String		sUseRedPackageSum;						
	private long		canUseRedPackageSum = 0;					//可使用红包总额
	private String		sCanUseRedPackageSum;
	
	
	
	public long getRedPackageSum() {
		return redPackageSum;
	}
	public void setRedPackageSum(long redPackageSum) {
		this.redPackageSum = redPackageSum;
	}
	
	public String getsRedPackageSum() {
		return sRedPackageSum;
	}
	public void setsRedPackageSum(String sRedPackageSum) {
		this.sRedPackageSum = sRedPackageSum;
		this.redPackageSum	= IntegerAndString.StringToLong(sRedPackageSum);
	}
	public long getExpiredSum() {
		return expiredSum;
	}
	public void setExpiredSum(long expiredSum) {
		this.expiredSum = expiredSum;
	}
	public String getsExpiredSum() {
		return sExpiredSum;
	}
	public void setsExpiredSum(String sExpiredSum) {
		this.sExpiredSum = sExpiredSum;
		this.expiredSum  = IntegerAndString.StringToLong(sExpiredSum);
	}
	public long getUseRedPackageSum() {
		return useRedPackageSum;
	}
	public void setUseRedPackageSum(long useRedPackageSum) {
		this.useRedPackageSum = useRedPackageSum;
	}
	public String getsUseRedPackageSum() {
		return sUseRedPackageSum;
	}
	public void setsUseRedPackageSum(String sUseRedPackageSum) {
		this.sUseRedPackageSum = sUseRedPackageSum;
		this.useRedPackageSum  = IntegerAndString.StringToLong(sUseRedPackageSum);
	}
	public long getCanUseRedPackageSum() {
		return canUseRedPackageSum;
	}
	public void setCanUseRedPackageSum(long canUseRedPackageSum) {
		this.sCanUseRedPackageSum = IntegerAndString.LongToString(canUseRedPackageSum);
		this.canUseRedPackageSum = canUseRedPackageSum;
	}
	public String getsCanUseRedPackageSum() {
		return sCanUseRedPackageSum;
	}
	public void setsCanUseRedPackageSum(String sCanUseRedPackageSum) {
		this.sCanUseRedPackageSum = sCanUseRedPackageSum;
		this.canUseRedPackageSum  = IntegerAndString.StringToLong(sCanUseRedPackageSum);
	}					
	
	
}

