

/** 
* @Title: ProjectDetailTYEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-11 下午3:18:56 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 后台显示项目投资详情
 * @since 
 * @date 2016-5-11 下午3:18:56  */

public class ProjectDetailTYEntity {
	private long    amount;//借款金额
	private String  amounts;//借款金额
    private String  repayGuarantee;//还款保障
    private String  projectName;//项目类型名
    private int     deadline;//借款期限 单位：月/天	
    private int     deadlineType;//期限类型  0：天标 1：月标 2：年标
    private String  repaySource;//还款来源
    private String  uses;//借款用途
    private String  guarantyDescribe;// 抵押物描叙
    private int     autoInvestMax;//自动投标占比
    private String  autoInvestMaxs;//自动投标占比
    private int     rewardRate;//奖励百分比 0：表示非奖励标 单位：百万分之	
    private int     rateAddRate;//加息率 0：表示非加息标 单位：百万分之	
    private String  rewardRates;//奖励百分比 0：表示非奖励标 单位：百万分之	
    private String  rateAddRates;//加息率 0：表示非加息标 单位：百万分之	
    private String  isDirect;//是否定向标 0：否 1：是
    private int     investRedPackageMin;//投资超过N元 单位：元 精确到小数点后4位
    private String  investRedPackageMins;//投资超过N元 单位：元 精确到小数点后4位
    private int     investNum;//前M位投资人
    private int     redPackage;//获取红包金额 单位：元 精确到小数点后4位
    private String  redPackages;//获取红包金额 单位：元 精确到小数点后4位
    private String  guaranteeName;//担保机构名称
    private String  managementName;//资产管理方
    private int     investCountMax;//最大投资笔数 
    private long    riskMarginFee;//收取风险保证金
    private String  riskMarginFees;//收取风险保证金
    private String  autoStart;//自动投标开始时间
    private long    riskMarginRate;//风险保证金费率 单位：百万分之
    private String  riskMarginRates;//风险保证金费率 单位：百万分之
    private int     riskMarginType;
    private long    mngFeeAmount;//借款管理费
    private String  mngFeeAmounts;//借款管理费
    private long    mngFeeRate;//借款管理费率
    private String  mngFeeRates;//借款管理费率
    private int     memberType;
    private long    memberId;
    private int     isVip;//借款会员是否是VIP会员，大于0是，等于0不是
    private int     vipBorrowMngRate;//VIP会员折扣
    private int     checkStatu;//审核状态申请状态 0：未审核 1：通过 -1：打回
    private int     mngFeeRateIncreace;//管理费比例、天标起收比例 单位：百万分之
    public int getIsVip() {
		return isVip;
	}
	public void setIsVip(int isVip) {
		this.isVip = isVip;
	}
	public int getVipBorrowMngRate() {
		return vipBorrowMngRate;
	}
	public void setVipBorrowMngRate(int vipBorrowMngRate) {
		this.vipBorrowMngRate = vipBorrowMngRate;
	}
	public long getMngFeeRate() {
		return mngFeeRate;
	}
	public void setMngFeeRate(long mngFeeRate) {
		this.mngFeeRate = mngFeeRate;
		this.mngFeeRates = IntegerAndString.LongToString(mngFeeRate);
	}
	public String getMngFeeRates() {
		return mngFeeRates;
	}
	public void setMngFeeRates(String mngFeeRates) {
		this.mngFeeRates = mngFeeRates;
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
	public long getRiskMarginRate() {
		return riskMarginRate;
	}
	public void setRiskMarginRate(long riskMarginRate) {
		this.riskMarginRate = riskMarginRate;
		this.riskMarginRates = IntegerAndString.LongToString(riskMarginRate);
	}
	public String getRiskMarginRates() {
		return riskMarginRates;
	}
	public void setRiskMarginRates(String riskMarginRates) {
		this.riskMarginRates = riskMarginRates;
	}
	public int getRiskMarginType() {
		return riskMarginType;
	}
	public void setRiskMarginType(int riskMarginType) {
		this.riskMarginType = riskMarginType;
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
	public String getRepayGuarantee() {
		return repayGuarantee;
	}
	public void setRepayGuarantee(String repayGuarantee) {
		this.repayGuarantee = repayGuarantee;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getDeadlineType() {
		return deadlineType;
	}
	public void setDeadlineType(int deadlineType) {
		this.deadlineType = deadlineType;
	}
	public String getRepaySource() {
		return repaySource;
	}
	public void setRepaySource(String repaySource) {
		this.repaySource = repaySource;
	}
	public String getUses() {
		return uses;
	}
	public void setUses(String uses) {
		this.uses = uses;
	}
	public String getGuarantyDescribe() {
		return guarantyDescribe;
	}
	public void setGuarantyDescribe(String guarantyDescribe) {
		this.guarantyDescribe = guarantyDescribe;
	}
	public int getAutoInvestMax() {
		return autoInvestMax;
	}
	public void setAutoInvestMax(int autoInvestMax) {
		this.autoInvestMax = autoInvestMax;
		this.autoInvestMaxs = IntegerAndString.LongToString(autoInvestMax);
	}
	public String getAutoInvestMaxs() {
		return autoInvestMaxs;
	}
	public void setAutoInvestMaxs(String autoInvestMaxs) {
		this.autoInvestMaxs = autoInvestMaxs;
	}
	public int getRewardRate() {
		return rewardRate;
	}
	public void setRewardRate(int rewardRate) {
		this.rewardRate = rewardRate;
		this.rewardRates = IntegerAndString.IntToString(rewardRate);
	}
	public int getRateAddRate() {
		return rateAddRate;
	}
	public void setRateAddRate(int rateAddRate) {
		this.rateAddRate = rateAddRate;
		this.rateAddRates = IntegerAndString.IntToString(rateAddRate);
	}
	public String getIsDirect() {
		return isDirect;
	}
	public void setIsDirect(String isDirect) {
		this.isDirect = isDirect;
	}
	public int getInvestRedPackageMin() {
		return investRedPackageMin;
	}
	public void setInvestRedPackageMin(int investRedPackageMin) {
		this.investRedPackageMin = investRedPackageMin;
		this.investRedPackageMins = IntegerAndString.IntToString(investRedPackageMin);
	}
	public String getInvestRedPackageMins() {
		return investRedPackageMins;
	}
	public void setInvestRedPackageMins(String investRedPackageMins) {
		this.investRedPackageMins = investRedPackageMins;
	}
	public int getInvestNum() {
		return investNum;
	}
	public void setInvestNum(int investNum) {
		this.investNum = investNum;
	}
	public int getRedPackage() {
		return redPackage;
	}
	public void setRedPackage(int redPackage) {
		this.redPackage = redPackage;
		this.redPackages = IntegerAndString.IntToString(redPackage);
	}
	public String getRedPackages() {
		return redPackages;
	}
	public void setRedPackages(String redPackages) {
		this.redPackages = redPackages;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public String getManagementName() {
		return managementName;
	}
	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}
	public int getInvestCountMax() {
		return investCountMax;
	}
	public void setInvestCountMax(int investCountMax) {
		this.investCountMax = investCountMax;
	}
	public String getRewardRates() {
		return rewardRates;
	}
	public void setRewardRates(String rewardRates) {
		this.rewardRates = rewardRates;
	}
	public String getRateAddRates() {
		return rateAddRates;
	}
	public void setRateAddRates(String rateAddRates) {
		this.rateAddRates = rateAddRates;
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
	public String getAutoStart() {
		return autoStart;
	}
	public void setAutoStart(String autoStart) {
		this.autoStart = autoStart;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public int getMngFeeRateIncreace() {
		return mngFeeRateIncreace;
	}
	public void setMngFeeRateIncreace(int mngFeeRateIncreace) {
		this.mngFeeRateIncreace = mngFeeRateIncreace;
	}
	
}

