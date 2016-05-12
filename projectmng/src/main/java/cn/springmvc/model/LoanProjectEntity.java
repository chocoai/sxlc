

/** 
* @Title: LoanProjectEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-12 下午1:36:35 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-5-12 下午1:36:35  */

public class LoanProjectEntity {
    private String  realEndDate;      //融资结束时间
    private String  projectNo;        //项目编号
    private String  projectName;      //项目类型名称
    private String  projectTitle;     // 项目标题
    private String  memberName;       //借款会员名称
    private String  logname;          //会员登录用户名
    private long    amount;           //借款金额
    private String  amounts;          //借款金额
    private long    realAmount;      //实际借款金额
    private String  realAmounts;       //实际借款金额
   
	private int     investRate;       //融资进度
    private String  investRates;      //融资进度
    private long    riskMarginFee;      //保证金
    private String  riskMarginFees;      //保证金
    private long    platformDirect;      //平台直扣
    private String  platformDirects;      //平台直扣
    private long    mngFeeAmount;      //借款管理费
    private String  mngFeeAmounts;      //借款管理费
    private long    realLoanmoney;      //实际放款金额
    private String  realLoanmoneys;      //实际放款金额
	private String  holdDate;           //放款时间
    private int     investStatu;        
    public long getRealLoanmoney() {
		return realLoanmoney;
	}
	public void setRealLoanmoney(long realLoanmoney) {
		this.realLoanmoney = realLoanmoney;
		this.realLoanmoneys = IntegerAndString.LongToString(realLoanmoney);
	}
	public String getRealLoanmoneys() {
		return realLoanmoneys;
	}
	public void setRealLoanmoneys(String realLoanmoneys) {
		this.realLoanmoneys = realLoanmoneys;
	}

    public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts = IntegerAndString.LongToString(realAmount);
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts = IntegerAndString.LongToString(amount);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
 
	public int getInvestRate() {
		return investRate;
	}
	public void setInvestRate(int investRate) {
		this.investRate = investRate;
		this.investRates = IntegerAndString.LongToString(investRate);
	}
	public String getInvestRates() {
		return investRates;
	}
	public void setInvestRates(String investRates) {
		this.investRates = investRates;
	}
	public long getRiskMarginFee() {
		return riskMarginFee;
	}
	public void setRiskMarginFee(long riskMarginFee) {
		this.riskMarginFee = riskMarginFee;
		this.riskMarginFees = IntegerAndString.LongToString(riskMarginFee);
	}
	public String getRiskMarginFees() {
		return riskMarginFees;
	}
	public void setRiskMarginFees(String riskMarginFees) {
		this.riskMarginFees = riskMarginFees;
	}
	public long getPlatformDirect() {
		return platformDirect;
	}
	public void setPlatformDirect(long platformDirect) {
		this.platformDirect = platformDirect;
		this.platformDirects = IntegerAndString.LongToString(platformDirect);
	}
	public String getPlatformDirects() {
		return platformDirects;
	}
	public void setPlatformDirects(String platformDirects) {
		this.platformDirects = platformDirects;
	}
	public long getMngFeeAmount() {
		return mngFeeAmount;
	}
	public void setMngFeeAmount(long mngFeeAmount) {
		this.mngFeeAmount = mngFeeAmount;
		this.mngFeeAmounts = IntegerAndString.LongToString(mngFeeAmount);
	}
	public String getMngFeeAmounts() {
		return mngFeeAmounts;
	}
	public void setMngFeeAmounts(String mngFeeAmounts) {
		this.mngFeeAmounts = mngFeeAmounts;
	}
 
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public int getInvestStatu() {
		return investStatu;
	}
	public void setInvestStatu(int investStatu) {
		this.investStatu = investStatu;
	}
}

