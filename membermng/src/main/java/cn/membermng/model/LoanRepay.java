package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;


/***
* 还款计划
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 下午7:27:20 
*
 */
public class LoanRepay {

	
	private long			lid;						//还款计划编号
	private int				indexs;						//还款序号
	private Long			loanAmount;					//应还本金
	private String			sLoanAmount;				//应还本经
	private Long			loanInterest;				//应还利息
	private String			sLoanInterest;				//
	private String			loanTime;					//还款时间
	private int				statu;						//还款状态
	private Long			overdueInterest;			//逾期利息
	private String			sOverdueInterest;	
	private Long			oberdueFine;				//逾期罚金
	private String			sOberdueFine;		
	private int				isCompensatory;				//是否代偿
	private Long			paidAmount;					//已还本金
	private String			sPaidAmount;				//已还本金
	private Long			paidInterest;				//已还利息
	private String			sPaidInterest;				//已还利息
	
	private Long			paidOverdueInterest;		//已还逾期利息
	private String			paidSOverdueInterest;	
	private Long			paidOberdueFine;			//已还逾期罚金
	private String			paidSOberdueFine;		
	
	
	public LoanRepay() {
		// TODO Auto-generated constructor stub

	}

	

	public LoanRepay(long lid, int indexs, Long loanAmount, String sLoanAmount,
			Long loanInterest, String sLoanInterest, String loanTime,
			int statu, Long overdueInterest, String sOverdueInterest,
			Long oberdueFine, String sOberdueFine, int isCompensatory,
			Long paidAmount, String sPaidAmount, Long paidInterest,
			String sPaidInterest, Long paidOverdueInterest,
			String paidSOverdueInterest, Long paidOberdueFine,
			String paidSOberdueFine) {
		super();
		this.lid = lid;
		this.indexs = indexs;
		this.loanAmount = loanAmount;
		this.sLoanAmount = sLoanAmount;
		this.loanInterest = loanInterest;
		this.sLoanInterest = sLoanInterest;
		this.loanTime = loanTime;
		this.statu = statu;
		this.overdueInterest = overdueInterest;
		this.sOverdueInterest = sOverdueInterest;
		this.oberdueFine = oberdueFine;
		this.sOberdueFine = sOberdueFine;
		this.isCompensatory = isCompensatory;
		this.paidAmount = paidAmount;
		this.sPaidAmount = sPaidAmount;
		this.paidInterest = paidInterest;
		this.sPaidInterest = sPaidInterest;
		this.paidOverdueInterest = paidOverdueInterest;
		this.paidSOverdueInterest = paidSOverdueInterest;
		this.paidOberdueFine = paidOberdueFine;
		this.paidSOberdueFine = paidSOberdueFine;
	}



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


	public Long getOverdueInterest() {
		return overdueInterest;
	}


	public void setOverdueInterest(Long overdueInterest) {
		this.overdueInterest = overdueInterest;
		this.sOverdueInterest	= IntegerAndString.LongToString(overdueInterest);
	}


	public String getsOverdueInterest() {
		return sOverdueInterest;
	}


	public void setsOverdueInterest(String sOverdueInterest) {
		this.sOverdueInterest = sOverdueInterest;
	}


	public Long getOberdueFine() {
		return oberdueFine;
	}


	public void setOberdueFine(Long oberdueFine) {
		this.oberdueFine = oberdueFine;
		this.sOberdueFine = IntegerAndString.LongToString(oberdueFine);
	}


	public String getsOberdueFine() {
		return sOberdueFine;
	}


	public void setsOberdueFine(String sOberdueFine) {
		this.sOberdueFine = sOberdueFine;
	}


	public int getIsCompensatory() {
		return isCompensatory;
	}


	public void setIsCompensatory(int isCompensatory) {
		this.isCompensatory = isCompensatory;
	}


	public Long getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
		this.sPaidAmount = IntegerAndString.LongToString(paidAmount);
	}


	public String getsPaidAmount() {
		return sPaidAmount;
	}


	public void setsPaidAmount(String sPaidAmount) {
		this.sPaidAmount = sPaidAmount;
	}


	public Long getPaidInterest() {
		return paidInterest;
	}


	public void setPaidInterest(Long paidInterest) {
		this.paidInterest = paidInterest;
		this.sPaidInterest = IntegerAndString.LongToString(paidInterest);
	}


	public String getsPaidInterest() {
		return sPaidInterest;
	}


	public void setsPaidInterest(String sPaidInterest) {
		this.sPaidInterest = sPaidInterest;
	}


	public Long getPaidOverdueInterest() {
		return paidOverdueInterest;
	}


	public void setPaidOverdueInterest(Long paidOverdueInterest) {
		this.paidOverdueInterest = paidOverdueInterest;
		this.paidSOverdueInterest = IntegerAndString.LongToString(paidOverdueInterest);
	}


	public String getPaidSOverdueInterest() {
		return paidSOverdueInterest;
	}


	public void setPaidSOverdueInterest(String paidSOverdueInterest) {
		this.paidSOverdueInterest = paidSOverdueInterest;
	}


	public Long getPaidOberdueFine() {
		return paidOberdueFine;
	}


	public void setPaidOberdueFine(Long paidOberdueFine) {
		this.paidOberdueFine = paidOberdueFine;
		this.paidSOberdueFine = IntegerAndString.LongToString(paidOberdueFine);
	}


	public String getPaidSOberdueFine() {
		return paidSOberdueFine;
	}


	public void setPaidSOberdueFine(String paidSOberdueFine) {
		this.paidSOberdueFine = paidSOberdueFine;
	}
	
	
}

