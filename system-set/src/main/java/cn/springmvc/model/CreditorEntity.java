
package cn.springmvc.model; 

/** 
 * 债权转让设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:19:42  */
public class CreditorEntity {
	private int holdDay;//	债权持有时间大于天数
	private int rangeDay;//	债权距到期日大于天数
	private int interestDay;//	转让日在付息日前天数
	private int mngFee;	//债权转让手续费 （百万分之 / 分
	private int mngType;//	手续费收取方向（0：转让人:1：购买人:2：全部）
	private int checkType;//	是否需要审核 0：否 1：是
	private int loanType;	// 放款方式 0：自动放款 1：手动放款
	private int interestType;//利息生成方式 0：整期生成 1：按照转让时间点生成
	public int getHoldDay() {
		return holdDay;
	}
	public void setHoldDay(int holdDay) {
		this.holdDay = holdDay;
	}
	public int getRangeDay() {
		return rangeDay;
	}
	public void setRangeDay(int rangeDay) {
		this.rangeDay = rangeDay;
	}
	public int getInterestDay() {
		return interestDay;
	}
	public void setInterestDay(int interestDay) {
		this.interestDay = interestDay;
	}
	public int getMngFee() {
		return mngFee;
	}
	public void setMngFee(int mngFee) {
		this.mngFee = mngFee;
	}
	public int getMngType() {
		return mngType;
	}
	public void setMngType(int mngType) {
		this.mngType = mngType;
	}
	public int getCheckType() {
		return checkType;
	}
	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}
	public int getLoanType() {
		return loanType;
	}
	public void setLoanType(int loanType) {
		this.loanType = loanType;
	}
	public int getInterestType() {
		return interestType;
	}
	public void setInterestType(int interestType) {
		this.interestType = interestType;
	}
	

}

