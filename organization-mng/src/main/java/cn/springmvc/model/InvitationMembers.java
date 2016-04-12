package cn.springmvc.model; 

import java.util.Date;

import product_p2p.kit.datatrans.IntegerAndString;


/***
* 邀请会员列表
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 下午5:29:54 
*
*/
public class InvitationMembers {
	
	private String				memberNo			;//会员编号
	private String				logName				;//登录名称
	private String				userName			;//会员真实名称
	private String				memberPhone			;//会员电话
	private Date				regDate				;//注册时间
	private long				investmentSum		;//投资总额
	private String				sInvestmentSum		;//
	private long				loanSum				;//借款金额
	private String				sLoanSum			;//
	
	
	public InvitationMembers() {}

	
	public InvitationMembers(String memberNo, String logName, String userName,
			String memberPhone, Date regDate, long investmentSum,
			String sInvestmentSum, long loanSum, String sLoanSum) {
		super();
		this.memberNo = memberNo;
		this.logName = logName;
		this.userName = userName;
		this.memberPhone = memberPhone;
		this.regDate = regDate;
		this.investmentSum = investmentSum;
		this.sInvestmentSum = sInvestmentSum;
		this.loanSum = loanSum;
		this.sLoanSum = sLoanSum;
	}



	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getLogName() {
		return logName;
	}


	public void setLogName(String logName) {
		this.logName = logName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public long getInvestmentSum() {
		return investmentSum;
	}


	public void setInvestmentSum(long investmentSum) {
		this.investmentSum = investmentSum;
		this.sInvestmentSum = IntegerAndString.LongToString(investmentSum);
	}


	public String getsInvestmentSum() {
		return sInvestmentSum;
	}


	public void setsInvestmentSum(String sInvestmentSum) {
		this.sInvestmentSum = sInvestmentSum;
	}


	public long getLoanSum() {
		return loanSum;
	}


	public void setLoanSum(long loanSum) {
		this.loanSum = loanSum;
		this.sLoanSum = IntegerAndString.LongToString(loanSum);
	}


	public String getsLoanSum() {
		return sLoanSum;
	}


	public void setsLoanSum(String sLoanSum) {
		this.sLoanSum = sLoanSum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

