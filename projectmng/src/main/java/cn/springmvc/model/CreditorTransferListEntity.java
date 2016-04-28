

/** 
* @Title: CreditorTransferListEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午10:56:03 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-6 上午10:56:03  */

public class CreditorTransferListEntity { 
	private String  projectTitle;//项目标题
	private String  ProjectNo;//项目编号
	private long    transPrincipal;//转让本金
	private int     surplusTime;//剩余期限
	private int     surplusTimeType;//剩余期限类型
	private int     transDiscount;//转让折扣
	private int     ctaInvestRate;//投资进度
	private String  repalyways;//还款方式
	private String  transStatus;//投资状态
	private long    applyId;//项目申请ID
	private long    ctaId;//债权转让申请ID
	private int     transStatu;//转让状态(-1：待流标处理 0：投标中 1：流标 2：投标完成 3：还款中 4：结清)
	private String  endDate;//债权到期日
	private String  transPrincipals;//转让本金
	private String  transDiscounts;//转让折扣
	private String  ctaInvestRates;//投资进度
	private String  levelMark;//信用等级 
	private int     rateAddRate;//加息率 0：表示非加息标 单位：百万分之		 
	private int     rewardRate;//奖励百分比 0：表示非奖励标 单位：百万分之 
	private String  rewardIcon; //奖励标图标 空表示不单独配置，使用默认
	private String  rateAddRates;//加息率 0：表示非加息标 单位：百万分之		 
	private String  rewardRates;//奖励百分比 0：表示非奖励标 单位：百万分之 
	private long    availableaAmount;//可投金额
	private String  availableaAmounts;//可投金额
	private long    investTotal;//已投资总额
	private String  investTotals;//已投资总额
	private int     expectYearrate;//预期年化利率
	private String  expectYearrates;//预期年化利率
	public int getExpectYearrate() {
		return expectYearrate;
	}
	public void setExpectYearrate(int expectYearrate) {
		this.expectYearrate = expectYearrate;
		this.expectYearrates= IntegerAndString.LongToString(expectYearrate);
	}
	public String getExpectYearrates() {
		return expectYearrates;
	}
	public void setExpectYearrates(String expectYearrates) {
		this.expectYearrates = expectYearrates;
	}
	public long getInvestTotal() {
		return investTotal;
	}
	public void setInvestTotal(long investTotal) {
		this.investTotal = investTotal;
		this.investTotals= IntegerAndString.LongToString(investTotal);
	}
	public String getInvestTotals() {
		return investTotals;
	}
	public void setInvestTotals(String investTotals) {
		this.investTotals = investTotals;
	}
	public int getRateAddRate() {
		return rateAddRate;
	}
	public void setRateAddRate(int rateAddRate) {
		this.rateAddRate = rateAddRate;
		this.rateAddRates= IntegerAndString.IntToString(rateAddRate);
	}
	public int getRewardRate() {
		return rewardRate;
	}
	public void setRewardRate(int rewardRate) {
		this.rewardRate = rewardRate;
		this.rewardRates= IntegerAndString.IntToString(rewardRate);
	}
	public String getRewardIcon() {
		return rewardIcon;
	}
	public void setRewardIcon(String rewardIcon) {
		this.rewardIcon = rewardIcon;
	}
	public String getRateAddRates() {
		return rateAddRates;
	}
	public void setRateAddRates(String rateAddRates) {
		this.rateAddRates = rateAddRates;
	}
	public String getRewardRates() {
		return rewardRates;
	}
	public void setRewardRates(String rewardRates) {
		this.rewardRates = rewardRates;
	}
	public long getAvailableaAmount() {
		return availableaAmount;
	}
	public void setAvailableaAmount(long availableaAmount) {
		this.availableaAmount = availableaAmount;
		this.availableaAmounts= IntegerAndString.LongToString(availableaAmount);
	}
	public String getAvailableaAmounts() {
		return availableaAmounts;
	}
	public void setAvailableaAmounts(String availableaAmounts) {
		this.availableaAmounts = availableaAmounts;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectNo() {
		return ProjectNo;
	}
	public void setProjectNo(String projectNo) {
		ProjectNo = projectNo;
	}
	public long getTransPrincipal() {
		return transPrincipal;
	}
	public void setTransPrincipal(long transPrincipal) {
		this.transPrincipal = transPrincipal;
		this.transPrincipals= IntegerAndString.LongToString(transPrincipal);
	}
	public int getSurplusTime() {
		return surplusTime;
	}
	public void setSurplusTime(int surplusTime) {
		this.surplusTime = surplusTime;
	}
	public int getSurplusTimeType() {
		return surplusTimeType;
	}
	public void setSurplusTimeType(int surplusTimeType) {
		this.surplusTimeType = surplusTimeType;
	}
	public int getTransDiscount() {
		return transDiscount;
	}
	public void setTransDiscount(int transDiscount) {
		this.transDiscount = transDiscount;
		this.transDiscounts= IntegerAndString.IntToString(transDiscount);
	}
	public int getCtaInvestRate() {
		return ctaInvestRate;
	}
	public void setCtaInvestRate(int ctaInvestRate) {
		this.ctaInvestRate = ctaInvestRate;
		this.ctaInvestRates= IntegerAndString.IntToString(ctaInvestRate);
	}
	public String getRepalyways() {
		return repalyways;
	}
	public void setRepalyways(String repalyways) {
		this.repalyways = repalyways;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	} 
	public int getTransStatu() {
		return transStatu;
	}
	public void setTransStatu(int transStatu) {
		this.transStatu = transStatu;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTransPrincipals() {
		return transPrincipals;
	}
	public void setTransPrincipals(String transPrincipals) {
		this.transPrincipals = transPrincipals;
	}
	public String getTransDiscounts() {
		return transDiscounts;
	}
	public void setTransDiscounts(String transDiscounts) {
		this.transDiscounts = transDiscounts;
	}
	public String getCtaInvestRates() {
		return ctaInvestRates;
	}
	public void setCtaInvestRates(String ctaInvestRates) {
		this.ctaInvestRates = ctaInvestRates;
	}
	public String getLevelMark() {
		return levelMark;
	}
	public void setLevelMark(String levelMark) {
		this.levelMark = levelMark;
	}
	public long getCtaId() {
		return ctaId;
	}
	public void setCtaId(long ctaId) {
		this.ctaId = ctaId;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
}

