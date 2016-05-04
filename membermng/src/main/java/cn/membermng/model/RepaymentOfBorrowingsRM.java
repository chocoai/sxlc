package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;



/***
* 
* 还款管理+还款中的借款
* 
* @author 李杰
* @since 
* @date 2016-5-2 下午2:48:00 
*
*/
public class RepaymentOfBorrowingsRM {

	private long			lid;						//还款计划编号
	private int				indexs;						//还款序号
	private Long			loanAmount;					//应还本金
	private String			sLoanAmount;				//应还本经
	private Long			loanInterest;				//应还利息
	private String			sLoanInterest;				//
	private String			loanTime;					//还款时间
	private int				statu;						//还款状态
	private String			statuName;					//
	private int				isYuQi;						//是否逾期 1已逾期  0未逾期
	private int 			isDaiChang;					//是否代偿
	private long			yuQiFeiYong;				//逾期费用
	private String			sYuQiFeiYong;				//
	private long			shiJiHuankuan;				//实际还款金额
	private String			sShiJiHuanKuan;				//
	private String			shiJiHuanKuanRi;			//实际还款日
	
	
	
	
	
	public long getLid() {
		return lid;
	}
	public void setLid(long lid) {
		this.lid = lid;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
		this.sLoanAmount = IntegerAndString.LongToString(loanAmount);
	}
	public String getsLoanAmount() {
		return sLoanAmount;
	}
	public void setsLoanAmount(String sLoanAmount) {
		this.sLoanAmount = sLoanAmount;
	}
	public Long getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(Long loanInterest) {
		this.loanInterest = loanInterest;
		this.sLoanInterest = IntegerAndString.LongToString(loanInterest);
	}
	public String getsLoanInterest() {
		return sLoanInterest;
	}
	public void setsLoanInterest(String sLoanInterest) {
		this.sLoanInterest = sLoanInterest;
	}
	public String getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getStatuName() {
		return statuName;
	}
	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}
	public int getIsYuQi() {
		return isYuQi;
	}
	public void setIsYuQi(int isYuQi) {
		this.isYuQi = isYuQi;
	}
	public int getIsDaiChang() {
		return isDaiChang;
	}
	public void setIsDaiChang(int isDaiChang) {
		this.isDaiChang = isDaiChang;
	}
	public long getYuQiFeiYong() {
		return yuQiFeiYong;
	}
	public void setYuQiFeiYong(long yuQiFeiYong) {
		this.yuQiFeiYong = yuQiFeiYong;
		this.sYuQiFeiYong = IntegerAndString.LongToString(yuQiFeiYong);
	}
	public long getShiJiHuankuan() {
		return shiJiHuankuan;
	}
	public void setShiJiHuankuan(long shiJiHuankuan) {
		this.shiJiHuankuan = shiJiHuankuan;
		this.sShiJiHuanKuan = IntegerAndString.LongToString(shiJiHuankuan);
	}
	public String getShiJiHuanKuanRi() {
		return shiJiHuanKuanRi;
	}
	public void setShiJiHuanKuanRi(String shiJiHuanKuanRi) {
		this.shiJiHuanKuanRi = shiJiHuanKuanRi;
	}
	public String getsYuQiFeiYong() {
		return sYuQiFeiYong;
	}
	public void setsYuQiFeiYong(String sYuQiFeiYong) {
		this.sYuQiFeiYong = sYuQiFeiYong;
	}
	public String getsShiJiHuanKuan() {
		return sShiJiHuanKuan;
	}
	public void setsShiJiHuanKuan(String sShiJiHuanKuan) {
		this.sShiJiHuanKuan = sShiJiHuanKuan;
	}
	
	
}

