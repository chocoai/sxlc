package cn.membermng.model; 



/***
* 借款统计 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 下午7:41:50 
*
*/
public class BorrowingStatistics {
	
	private int					loanCount;					//成功借款
	private int					repaymentCount;				//成功还款
	private int					investmentCount;			//成功投资
	private int					overdueRepaymentCount;		//逾期还款
	private int					yZOverdueRepaymentCount;	//严重逾期
	private int					yuQiWeiHuan;				//逾期未还
	private int					tiQianHuanKuan;				//提前还款笔数
	
	
	public int getLoanCount() {
		return loanCount;
	}
	public void setLoanCount(int loanCount) {
		this.loanCount = loanCount;
	}
	public int getRepaymentCount() {
		return repaymentCount;
	}
	public void setRepaymentCount(int repaymentCount) {
		this.repaymentCount = repaymentCount;
	}
	public int getInvestmentCount() {
		return investmentCount;
	}
	public void setInvestmentCount(int investmentCount) {
		this.investmentCount = investmentCount;
	}
	public int getOverdueRepaymentCount() {
		return overdueRepaymentCount;
	}
	public void setOverdueRepaymentCount(int overdueRepaymentCount) {
		this.overdueRepaymentCount = overdueRepaymentCount;
	}
	public int getyZOverdueRepaymentCount() {
		return yZOverdueRepaymentCount;
	}
	public void setyZOverdueRepaymentCount(int yZOverdueRepaymentCount) {
		this.yZOverdueRepaymentCount = yZOverdueRepaymentCount;
	}
	public int getYuQiWeiHuan() {
		return yuQiWeiHuan;
	}
	public void setYuQiWeiHuan(int yuQiWeiHuan) {
		this.yuQiWeiHuan = yuQiWeiHuan;
	}
	public int getTiQianHuanKuan() {
		return tiQianHuanKuan;
	}
	public void setTiQianHuanKuan(int tiQianHuanKuan) {
		this.tiQianHuanKuan = tiQianHuanKuan;
	}
	
	
	
	
}

