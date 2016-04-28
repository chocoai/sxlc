

/** 
* @Title: GuranteeRecordEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午5:34:31 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 担保
 * @since 
 * @date 2016-4-13 下午5:34:31  */

public class GuranteeRecordEntity {
	//担保项目信息
	private long   applyId;//项目申请记录ID
	private String projectNo;//项目编号
	private String projectTitle;//项目名称
	private String projectName;//产品类型
	private long   amount;//借款金额
	private long   riskMarginFee;//项目保证金
	private String amounts;//借款金额
	private String riskMarginFees;//项目保证金
	private String guaranteeName;//担保机构名称
	private String recordDate;//担保登记时间
	private int    isCompensatory;//是否代偿
	private String compensatoryTime;//最近代偿时间
	
	//代偿记录信息/历史代偿记录信息
	
	private int    indexs;//代偿期数
	private String personalName;//借款人姓名
	private String logname;//借款人用户名
	private String personalPhone;//借款人手机号 
	private long   endAmount;//实际借款金额
	private String endAmounts;//实际借款金额
	private String repayMaxTime;//当期合约还款时间 
	private long   corpusEnc;//代偿本金
	private long   interestEnc;//代偿利息
	private long   overdueInterestEnc;//代偿逾期利息
	private long   overdueFeeEnc;//代偿逾期罚金
	private long   amountEnc;//代偿总金额
	private String corpusEncs;//代偿本金
	private String interestEncs;//代偿利息
	private String overdueInterestEncs;//代偿逾期利息
	private String overdueFeeEncs;//代偿逾期罚金
	private String amountEncs;//代偿总金额
	private int    statu;//是否回款
	//代偿回款信息  
	private long   repayAmount;//回款金额
	private String repayAmounts;//回款金额
	private String repayTime;//回款时间
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts= IntegerAndString.LongToString(amount);
	}
	public long getRiskMarginFee() {
		return riskMarginFee;
	}
	public void setRiskMarginFee(long riskMarginFee) {
		this.riskMarginFee = riskMarginFee;
		this.riskMarginFees= IntegerAndString.LongToString(riskMarginFee);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getRiskMarginFees() {
		return riskMarginFees;
	}
	public void setRiskMarginFees(String riskMarginFees) {
		this.riskMarginFees = riskMarginFees;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public int getIsCompensatory() {
		return isCompensatory;
	}
	public void setIsCompensatory(int isCompensatory) {
		this.isCompensatory = isCompensatory;
	}
	public String getCompensatoryTime() {
		return compensatoryTime;
	}
	public void setCompensatoryTime(String compensatoryTime) {
		this.compensatoryTime = compensatoryTime;
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public long getEndAmount() {
		return endAmount;
	}
	public void setEndAmount(long endAmount) {
		this.endAmount = endAmount;
		this.setEndAmounts(IntegerAndString.LongToString(endAmount));
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public long getCorpusEnc() {
		return corpusEnc;
	}
	public void setCorpusEnc(long corpusEnc) {
		this.corpusEnc = corpusEnc;
		this.corpusEncs= IntegerAndString.LongToString(corpusEnc);
	}
	public long getInterestEnc() {
		return interestEnc;
	}
	public void setInterestEnc(long interestEnc) {
		this.interestEnc = interestEnc;
		this.interestEncs= IntegerAndString.LongToString(interestEnc);
	}
	public long getOverdueInterestEnc() {
		return overdueInterestEnc;
	}
	public void setOverdueInterestEnc(long overdueInterestEnc) {
		this.overdueInterestEnc = overdueInterestEnc;
		this.overdueInterestEncs= IntegerAndString.LongToString(overdueInterestEnc);
	}
	public long getOverdueFeeEnc() {
		return overdueFeeEnc;
	}
	public void setOverdueFeeEnc(long overdueFeeEnc) {
		this.overdueFeeEnc = overdueFeeEnc;
		this.overdueFeeEncs= IntegerAndString.LongToString(overdueFeeEnc);
	}
	public long getAmountEnc() {
		return amountEnc;
	}
	public void setAmountEnc(long amountEnc) {
		this.amountEnc = amountEnc;
		this.amountEncs= IntegerAndString.LongToString(amountEnc);
	}
	public String getCorpusEncs() {
		return corpusEncs;
	}
	public void setCorpusEncs(String corpusEncs) {
		this.corpusEncs = corpusEncs;
	}
	public String getInterestEncs() {
		return interestEncs;
	}
	public void setInterestEncs(String interestEncs) {
		this.interestEncs = interestEncs;
	}
	public String getOverdueInterestEncs() {
		return overdueInterestEncs;
	}
	public void setOverdueInterestEncs(String overdueInterestEncs) {
		this.overdueInterestEncs = overdueInterestEncs;
	}
	public String getOverdueFeeEncs() {
		return overdueFeeEncs;
	}
	public void setOverdueFeeEncs(String overdueFeeEncs) {
		this.overdueFeeEncs = overdueFeeEncs;
	}
	public String getAmountEncs() {
		return amountEncs;
	}
	public void setAmountEncs(String amountEncs) {
		this.amountEncs = amountEncs;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
		this.setRepayAmounts(IntegerAndString.LongToString(repayAmount));
	}
	public String getRepayTime() {
		return repayTime;
	}
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	public String getRepayAmounts() {
		return repayAmounts;
	}
	public void setRepayAmounts(String repayAmounts) {
		this.repayAmounts = repayAmounts;
	}
	public String getEndAmounts() {
		return endAmounts;
	}
	public void setEndAmounts(String endAmounts) {
		this.endAmounts = endAmounts;
	}
}

