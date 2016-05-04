

/** 
* @Title: ProjectAppRecordEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午10:19:33 
* @version V5.0 */
 
package cn.springmvc.model; 

import cn.springmvc.utitls.RepalyUtitls;
  
/** 
 * @author 刘利 
 * @Description: 项目申请记录实体类
 * @since 
 * @date 2016-3-21 上午10:19:33  */

public class ProjectDetailEntity {
	/**
	 * 项目申请记录id
	 */
	private long applyId; 
	/**
	 * 项目类型ID
	 */
	private long projectID;
	/**
	 * 会员ID
	 */
	private long memberID;	 
	/**
	 * 项目类型ID
	 */
	private long projectType;  
	
	/** 
	* @Fields Purpose_ID : 意向记录ID 
	*/
	private  long purposeID;
	/**
	 * 项目基本信息ID	
	 */
	private long projectBaseID;
	/**
	 * 项目基本信息实体类
	 */
	private ProjectBaseInfoEntity projectBaseInfoentity;
    /**
     * 还款保障
     */
	private String repayGuarantee;	
	/**
	 * 抵押物描述
	 */
	private String guarantyDescribe;
	/**
	 * 起投金额 0：表示无限制
	 */
	private int  minStart;
	/**
	 * 加价幅度 0：表示无限制	
	 */
	private int increaseRange;	
	/**
	 * 最大投资比例 保留四位小数 0-1000000 0，1000000表示无限制（同一个会员投资总金额不能超过借款金额*最大投资比例）	
	 */
	private int investMax;	
	/**
	 * 申请状态 0：未审核 1：通过 -1：打回	
	 */
	private int checkStatu;
	/**
	 * 发布状态 0：借款人未确认 1：借款人确认中 2：借款人已确认 -1：借款人已取消	
	 */
	private int publishStatu;	
	/**
	 * 融资状态 项目状态 -3：待流标 -2：待第三方登记 -1：登记中 0：投标中 1：流标 2：投标完成 3：还款中 4：结清  5:债务转让中	
	 */
	private int investStatu;
	/**
	 * 是否定向标 0：否 1：是	
	 */
	private int isDirect;
	/**
	 * 定向标密码
	 */
	private String directPwd;	 
	/**
	 * 资产管理方ID
	 */
	private long assetManagerID; 	
	/**
	 *  担保机构ID	
	 */
	private long guaranteeID;
	/**
	 * 加息率 0：表示非加息标 单位：百万分之	
	 */
	private int rateAddRate;	
	/**
	 * 奖励百分比 0：表示非奖励标 单位：百万分之	
	 */
	private int rewardRate;
	/**
	 * 奖励标图标 空表示不单独配置，使用默认	
	 */
	private String rewardIcon; 
	/**
	 * 最大投资笔数 0：表示无限制	
	 */
	private int investCountMax;
	/**
	 * 项目编号（发布后生成编号）
	 */
	private String projectNo;
	/**
	 * 项目登记商户订单号(环迅接口使用)
	 */
	private String merBillNo;
	/**
	 * 投标进度 百万分之
	 */
	private int investRate;
	/**
	 * 投标进度 百万分之
	 */
	private String investRates;
	/**
	 * 可投金额
	 */
	private long availableaAmount;
	/**
	 * 可投金额
	 */
	private String availableaAmounts;
	/**
	 * 投资进度
	 */
	private String investmentProgress;
	/**
	 * 婚姻状况
	 */
	private String maritalName;
	/**
	 * 投标开始时间
	 */
	private String startDate;
	/**
	 * 投标结束时间
	 */
	private String logname; 
	/**
	 * 会员类型 0个人 1企业
	 */
	private int memberType; 
	/**
	 * 企业会员信息ID
	 */
	private int companyID; 
	/**
	 * 个人会员信息ID
	 */
	private int personalID; 
	/**
	 * 借款会员名称 
	 */
	private String membername;
	/**
	 * 借款会员编号
	 */
	private String memberNo; 
	/**
	 * 个人会员名称 
	 */
	private String personalName;
	/**
	 * 企业会员名称 
	 */
	private String compangName;
	/**
	 * 项目形象图
	 */
	private String imageUrl;
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
 
	public int getPersonalID() {
		return personalID;
	}
	public void setPersonalID(int personalID) {
		this.personalID = personalID;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	/**
	 * 投标结束时间
	 */
	private String endDate; 
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
 
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public long getProjectType() {
		return projectType;
	}
	public void setProjectType(long projectType) {
		this.projectType = projectType;
	}
	 
	public long getProjectBaseID() {
		return projectBaseID;
	}
	public void setProjectBaseID(long projectBaseID) {
		this.projectBaseID = projectBaseID;
	}
	public ProjectBaseInfoEntity getProjectBaseInfoentity() {
		return projectBaseInfoentity;
	}
	public void setProjectBaseInfoentity(
			ProjectBaseInfoEntity projectBaseInfoentity) {
		this.projectBaseInfoentity = projectBaseInfoentity;
	}
	public String getRepayGuarantee() {
		return repayGuarantee;
	}
	public void setRepayGuarantee(String repayGuarantee) {
		this.repayGuarantee = repayGuarantee;
	}
	public String getGuarantyDescribe() {
		return guarantyDescribe;
	}
	public void setGuarantyDescribe(String guarantyDescribe) {
		this.guarantyDescribe = guarantyDescribe;
	}
	public int getMinStart() {
		return minStart;
	}
	public void setMinStart(int minStart) {
		this.minStart = minStart;
	}
	public int getIncreaseRange() {
		return increaseRange;
	}
	public void setIncreaseRange(int increaseRange) {
		this.increaseRange = increaseRange;
	}
	public int getInvestMax() {
		return investMax;
	}
	public void setInvestMax(int investMax) {
		this.investMax = investMax; 
	}
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public int getPublishStatu() {
		return publishStatu;
	}
	public void setPublishStatu(int publishStatu) {
		this.publishStatu = publishStatu;
	}
	public int getInvestStatu() {
		return investStatu;
	}
	public void setInvestStatu(int investStatu) {
		this.investStatu = investStatu;
	}
	public int getIsDirect() {
		return isDirect;
	}
	public void setIsDirect(int isDirect) {
		this.isDirect = isDirect;
	}
	public String getDirectPwd() {
		return directPwd;
	}
	public void setDirectPwd(String directPwd) {
		this.directPwd = directPwd;
	}
	public long getAssetManagerID() {
		return assetManagerID;
	}
	public void setAssetManagerID(long assetManagerID) {
		this.assetManagerID = assetManagerID;
	}
	public long getGuaranteeID() {
		return guaranteeID;
	}
	public void setGuaranteeID(long guaranteeID) {
		this.guaranteeID = guaranteeID;
	}
	public int getRateAddRate() {
		return rateAddRate;
	}
	public void setRateAddRate(int rateAddRate) {
		this.rateAddRate = rateAddRate;
	}
	public int getRewardRate() {
		return rewardRate;
	}
	public void setRewardRate(int rewardRate) {
		this.rewardRate = rewardRate;
	}
	public String getRewardIcon() {
		return rewardIcon;
	}
	public void setRewardIcon(String rewardIcon) {
		this.rewardIcon = rewardIcon;
	}
	public int getInvestCountMax() {
		return investCountMax;
	}
	public void setInvestCountMax(int investCountMax) {
		this.investCountMax = investCountMax;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getMerBillNo() {
		return merBillNo;
	}
	public void setMerBillNo(String merBillNo) {
		this.merBillNo = merBillNo;
	}
	public int getInvestRate() {
		return investRate;
	}
	public void setInvestRate(int investRate) {
		this.investRate = investRate;
		this.investRates= RepalyUtitls.LongToString(investRate);
	}
 
	public String getInvestmentProgress() {
		return investmentProgress;
	}
	public void setInvestmentProgress(String investmentProgress) {
		this.investmentProgress = investmentProgress;
	}
	 
	public String getMaritalName() {
		return maritalName;
	}
	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}
	public long getPurposeID() {
		return purposeID;
	}
	public void setPurposeID(long purposeID) {
		this.purposeID = purposeID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getAvailableaAmounts() {
		return availableaAmounts;
	}
	public void setAvailableaAmounts(String availableaAmounts) {
		this.availableaAmounts = availableaAmounts;
	}
	public long getAvailableaAmount() {
		return availableaAmount;
	}
	public void setAvailableaAmount(long availableaAmount) {
		this.availableaAmount = availableaAmount;
		this.availableaAmounts= RepalyUtitls.LongToString(availableaAmount);
	}
	public String getCompangName() {
		return compangName;
	}
	public void setCompangName(String compangName) {
		this.compangName = compangName;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getInvestRates() {
		return investRates;
	}
	public void setInvestRates(String investRates) {
		this.investRates = investRates;
	} 		

}

