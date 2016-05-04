

/** 
* @Title: InvestRepaymentEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-28 下午7:51:38 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description:推荐达人推荐还本明细
 * @since 
 * @date 2016-4-28 下午7:51:38  */

public class InvestRepaymentEntity {
	private long   applyId;//项目申请记录ID
	private String projectTitle;//借款名称
	private long   amount;//借款金额
	private String amounts;//借款金额
	private String logname;//借款人用户名
	private String personalName;//会员名称
	private long   repayPrincipal;//本次还款本金
	private long   repayInterest;//本次还款利息
	private String repayPrincipals;//本次还款本金
	private String repayInterests;//本次还款利息
	private String repayTime;//还款时间
	private String repayMaxTime;//预期还款时间
	private int    isoverque;//是否逾期1是0否
	
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts= IntegerAndString.LongToString(amount);
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
	public long getRepayPrincipal() {
		return repayPrincipal;
	}
	public void setRepayPrincipal(long repayPrincipal) {
		this.repayPrincipal = repayPrincipal;
		this.repayPrincipals= IntegerAndString.LongToString(repayPrincipal);
	}
	public long getRepayInterest() {
		return repayInterest;
	}
	public void setRepayInterest(long repayInterest) {
		this.repayInterest = repayInterest;
		this.repayInterests= IntegerAndString.LongToString(repayInterest);
	}
	public String getRepayPrincipals() {
		return repayPrincipals;
	}
	public void setRepayPrincipals(String repayPrincipals) {
		this.repayPrincipals = repayPrincipals;
	}
	public String getRepayInterests() {
		return repayInterests;
	}
	public void setRepayInterests(String repayInterests) {
		this.repayInterests = repayInterests;
	}
	public String getRepayTime() {
		return repayTime;
	}
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	} 
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public int getIsoverque() {
		return isoverque;
	}
	public void setIsoverque(int isoverque) {
		this.isoverque = isoverque;
	}
	
}

