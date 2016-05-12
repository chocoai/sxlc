

/** 
* @Title: InvestDetailedEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午2:41:01 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 理财顾问-推荐达人-投资明细 
 * @since 
 * @date 2016-4-5 下午2:41:01  */

public class InvestDetailedEntity {
	private String projectTitle;//借款名称
	private long investAmountValid;//投资金额
	private String investAmountValids;//投资金额
	private String logname;//用户名
	private String personalName;//会员名称
	private long sdRecvPrincipal;//预期本金
	private long sdRecvInterest;//预期收益
	private String sdRecvPrincipals;//预期本金
	private String sdRecvInterests;//预期收益
	private String holdDate;//投资成功时间
	private String nextReplayDay;//预期收益时间
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
		this.investAmountValids= IntegerAndString.LongToString(investAmountValid);
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public long getSdRecvPrincipal() {
		return sdRecvPrincipal;
	}
	public void setSdRecvPrincipal(long sdRecvPrincipal) {
		this.sdRecvPrincipal = sdRecvPrincipal;
		this.sdRecvPrincipals= IntegerAndString.LongToString(sdRecvPrincipal);
	}
	public long getSdRecvInterest() {
		return sdRecvInterest;
	}
	public void setSdRecvInterest(long sdRecvInterest) {
		this.sdRecvInterest = sdRecvInterest;
		this.sdRecvInterests= IntegerAndString.LongToString(sdRecvInterest);
	}
	public String getSdRecvPrincipals() {
		return sdRecvPrincipals;
	}
	public void setSdRecvPrincipals(String sdRecvPrincipals) {
		this.sdRecvPrincipals = sdRecvPrincipals;
	}
	public String getSdRecvInterests() {
		return sdRecvInterests;
	}
	public void setSdRecvInterests(String sdRecvInterests) {
		this.sdRecvInterests = sdRecvInterests;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public String getNextReplayDay() {
		return nextReplayDay;
	}
	public void setNextReplayDay(String nextReplayDay) {
		this.nextReplayDay = nextReplayDay;
	}
}

