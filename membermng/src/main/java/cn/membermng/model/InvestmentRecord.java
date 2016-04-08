package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;


/***
* 投资记录封装对象
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 下午7:03:46 
*
 */
public class InvestmentRecord {

	
	private String			investDate;				//投资时间
	private String			userName;				//会员用户名
	private String			memberName;				//会员登录名
	private Long			investmentAmount;		//投资金额
	private String			sInvestmentAmount;		//投资金额
	
	
	public InvestmentRecord() {

	}


	public InvestmentRecord(String investDate, String userName,
			String memberName, Long investmentAmount, String sInvestmentAmount) {
		super();
		this.investDate = investDate;
		this.userName = userName;
		this.memberName = memberName;
		this.investmentAmount = investmentAmount;
		this.sInvestmentAmount = sInvestmentAmount;
	}


	public String getInvestDate() {
		return investDate;
	}


	public void setInvestDate(String investDate) {
		this.investDate = investDate;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public Long getInvestmentAmount() {
		return investmentAmount;
	}


	public void setInvestmentAmount(Long investmentAmount) {
		this.investmentAmount = investmentAmount;
		this.sInvestmentAmount	= IntegerAndString.LongToString(investmentAmount);
	}


	public String getsInvestmentAmount() {
		return sInvestmentAmount;
	}


	public void setsInvestmentAmount(String sInvestmentAmount) {
		this.sInvestmentAmount = sInvestmentAmount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

