
package cn.springmvc.model; 

/** 
 * 担保机构充值交易记录
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-25 下午3:45:34  */
public class InstitutionsRecordsEntity {
	private String dealTime;//交易时间
	private String orderNumber;//平台交易编号
	private String loanNumber;//第三方交易编号
	private long   amount;//交易金额
	private String samount;//交易金额 字符串类型
	private long   feeAmount;//支付手续费
	private String sfeeAmount;
	private long realAmount;//实际到账金额
	private String srealAmount;//实际到账金额
	private int    statu=-1;//充值，提现状态
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getSamount() {
		return samount;
	}
	public void setSamount(String samount) {
		this.samount = samount;
	}
	public long getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(long feeAmount) {
		this.feeAmount = feeAmount;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getSfeeAmount() {
		return sfeeAmount;
	}
	public void setSfeeAmount(String sfeeAmount) {
		this.sfeeAmount = sfeeAmount;
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
	}
	public String getSrealAmount() {
		return srealAmount;
	}
	public void setSrealAmount(String srealAmount) {
		this.srealAmount = srealAmount;
	}
	
}

