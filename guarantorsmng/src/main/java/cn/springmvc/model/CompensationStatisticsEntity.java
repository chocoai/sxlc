
package cn.springmvc.model; 

/**
 * 查询担保机构代偿统计信息 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-29 下午1:55:15  */
public class CompensationStatisticsEntity {
	private long totalCompensationAmount;//代偿总金额
	private long allCompensatoryPayment;//代偿回款总金额
	private long noCompensatoryPayment;//代偿未回款总金额
	private int numberOfSuccessful;//成功担保笔数
	private int successfulCompensation;//成功代偿笔数
	private int compensatoryPaymentNumber;//代偿成功回款笔数
	private long sxfee;//担保手续费收取
	public long getTotalCompensationAmount() {
		return totalCompensationAmount;
	}
	public void setTotalCompensationAmount(long totalCompensationAmount) {
		this.totalCompensationAmount = totalCompensationAmount;
	}
	public long getAllCompensatoryPayment() {
		return allCompensatoryPayment;
	}
	public void setAllCompensatoryPayment(long allCompensatoryPayment) {
		this.allCompensatoryPayment = allCompensatoryPayment;
	}
	public long getNoCompensatoryPayment() {
		return noCompensatoryPayment;
	}
	public void setNoCompensatoryPayment(long noCompensatoryPayment) {
		this.noCompensatoryPayment = noCompensatoryPayment;
	}
	public int getNumberOfSuccessful() {
		return numberOfSuccessful;
	}
	public void setNumberOfSuccessful(int numberOfSuccessful) {
		this.numberOfSuccessful = numberOfSuccessful;
	}
	public int getSuccessfulCompensation() {
		return successfulCompensation;
	}
	public void setSuccessfulCompensation(int successfulCompensation) {
		this.successfulCompensation = successfulCompensation;
	}
	public int getCompensatoryPaymentNumber() {
		return compensatoryPaymentNumber;
	}
	public void setCompensatoryPaymentNumber(int compensatoryPaymentNumber) {
		this.compensatoryPaymentNumber = compensatoryPaymentNumber;
	}
	public long getSxfee() {
		return sxfee;
	}
	public void setSxfee(long sxfee) {
		this.sxfee = sxfee;
	}
	
}

