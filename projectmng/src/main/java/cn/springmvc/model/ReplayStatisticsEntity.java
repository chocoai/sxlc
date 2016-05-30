

/** 
* @Title: WillRepayEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-21 下午6:21:47 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 还款统计 
 * @since 
 * @date 2016-4-21 下午6:21:47  */

public class ReplayStatisticsEntity {
	private String 		projectNo;			//借款项目编号
	private String 		projectTitle;		//借款项目名称
	private String 		logname;			//借款人用户名
	private String 		personalName;		//借款人姓名
	private long   		investAmountValid;	//借款金额
	private String 		guaranteeName;		//担保机构
	private String 		repayMaxTime;		//应还日期
	private int    		indexs;				//期数
	private int    		amount;				//当期应还总额
	private int    		sdRepayPrincipal;	//当期应还本金
	private int    		sdRepayInterest;	//当期应还利息
	private String    	amounts;			//当期应还总额
	private String    	sdRepayPrincipals;	//当期应还本金
	private String    	sdRepayInterests;	//当期应还利息
	private String   	investAmountValids;	//借款金额
	private int 		overdueAmount;		//当期应还罚息
	private String 		overdueAmounts;		//当期应还罚息
	private int 		overdueDays;		//逾期天数
	private long        repayID;//还款计划ID
	private long        applyId;//还款计划ID
	public long getRepayID() {
		return repayID;
	}
	public void setRepayID(long repayID) {
		this.repayID = repayID;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public int getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(int overdueAmount) {
		this.overdueAmount = overdueAmount;
		this.overdueAmounts = IntegerAndString.LongToString(overdueAmount);
	}
	public String getOverdueAmounts() {
		return overdueAmounts;
	}
	public void setOverdueAmounts(String overdueAmounts) {
		this.overdueAmounts = overdueAmounts;
	}
	public int getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
		this.investAmountValids = IntegerAndString.LongToString(investAmountValid);
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
		this.amounts = IntegerAndString.LongToString(amount);
	}
	public int getSdRepayPrincipal() {
		return sdRepayPrincipal;
	}
	public void setSdRepayPrincipal(int sdRepayPrincipal) {
		this.sdRepayPrincipal = sdRepayPrincipal;
		this.sdRepayPrincipals = IntegerAndString.LongToString(sdRepayPrincipal);
	}
	public int getSdRepayInterest() {
		return sdRepayInterest;
	}
	public void setSdRepayInterest(int sdRepayInterest) {
		this.sdRepayInterest = sdRepayInterest;
		this.sdRepayInterests = IntegerAndString.LongToString(sdRepayInterest);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getSdRepayPrincipals() {
		return sdRepayPrincipals;
	}
	public void setSdRepayPrincipals(String sdRepayPrincipals) {
		this.sdRepayPrincipals = sdRepayPrincipals;
	}
	public String getSdRepayInterests() {
		return sdRepayInterests;
	}
	public void setSdRepayInterests(String sdRepayInterests) {
		this.sdRepayInterests = sdRepayInterests;
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
}

