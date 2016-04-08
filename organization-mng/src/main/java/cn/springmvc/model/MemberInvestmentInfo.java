package cn.springmvc.model; 

/***
* 
* 会员投资信息
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 下午7:10:45 
*
*/
public class MemberInvestmentInfo {
	
	private int				investmentCount;			//成功投资次数
	private long			investmentSum;				//成功投资金额
	private String			sInvestmentSum;				//
	private long			recvPrincipal;				//已收本金
	private String			sRecvPrincipal;				//
	private long			recvInterest;				//已收利息
	private String			sRecvInterest;				//
	private long			expectRecvPrincipal;		//
	private String			sExpectRecvPrincipal;
	private long			incomeReceived;				//待收收益
	private String			sIncomeReceived;			//
	
	
	public MemberInvestmentInfo() {}


	public MemberInvestmentInfo(int investmentCount, long investmentSum,
			String sInvestmentSum, long recvPrincipal, String sRecvPrincipal,
			long recvInterest, String sRecvInterest, long expectRecvPrincipal,
			String sExpectRecvPrincipal, long incomeReceived,
			String sIncomeReceived) {
		super();
		this.investmentCount = investmentCount;
		this.investmentSum = investmentSum;
		this.sInvestmentSum = sInvestmentSum;
		this.recvPrincipal = recvPrincipal;
		this.sRecvPrincipal = sRecvPrincipal;
		this.recvInterest = recvInterest;
		this.sRecvInterest = sRecvInterest;
		this.expectRecvPrincipal = expectRecvPrincipal;
		this.sExpectRecvPrincipal = sExpectRecvPrincipal;
		this.incomeReceived = incomeReceived;
		this.sIncomeReceived = sIncomeReceived;
	}


	public int getInvestmentCount() {
		return investmentCount;
	}


	public void setInvestmentCount(int investmentCount) {
		this.investmentCount = investmentCount;
	}


	public long getInvestmentSum() {
		return investmentSum;
	}


	public void setInvestmentSum(long investmentSum) {
		this.investmentSum = investmentSum;
	}


	public String getsInvestmentSum() {
		return sInvestmentSum;
	}


	public void setsInvestmentSum(String sInvestmentSum) {
		this.sInvestmentSum = sInvestmentSum;
	}


	public long getRecvPrincipal() {
		return recvPrincipal;
	}


	public void setRecvPrincipal(long recvPrincipal) {
		this.recvPrincipal = recvPrincipal;
	}


	public String getsRecvPrincipal() {
		return sRecvPrincipal;
	}


	public void setsRecvPrincipal(String sRecvPrincipal) {
		this.sRecvPrincipal = sRecvPrincipal;
	}


	public long getRecvInterest() {
		return recvInterest;
	}


	public void setRecvInterest(long recvInterest) {
		this.recvInterest = recvInterest;
	}


	public String getsRecvInterest() {
		return sRecvInterest;
	}


	public void setsRecvInterest(String sRecvInterest) {
		this.sRecvInterest = sRecvInterest;
	}


	public long getExpectRecvPrincipal() {
		return expectRecvPrincipal;
	}


	public void setExpectRecvPrincipal(long expectRecvPrincipal) {
		this.expectRecvPrincipal = expectRecvPrincipal;
	}


	public String getsExpectRecvPrincipal() {
		return sExpectRecvPrincipal;
	}


	public void setsExpectRecvPrincipal(String sExpectRecvPrincipal) {
		this.sExpectRecvPrincipal = sExpectRecvPrincipal;
	}


	public long getIncomeReceived() {
		return incomeReceived;
	}


	public void setIncomeReceived(long incomeReceived) {
		this.incomeReceived = incomeReceived;
	}


	public String getsIncomeReceived() {
		return sIncomeReceived;
	}


	public void setsIncomeReceived(String sIncomeReceived) {
		this.sIncomeReceived = sIncomeReceived;
	}
	
	
	
	
	
	
	

}

