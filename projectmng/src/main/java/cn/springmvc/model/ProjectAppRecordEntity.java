

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

import product_p2p.kit.datatrans.IntegerAndString; 

/** 
 * @author 刘利 
 * @Description: 项目申请记录实体类
 * @since 
 * @date 2016-3-21 上午10:19:33  */

public class ProjectAppRecordEntity {
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
	 * 会员实体类
	 */
	private MemberInfoEntity memberInfoEntity;
	/**
	 * 项目类型ID
	 */
	private long projectType; 
	/**
	 * 项目类型实体
	 */
	private  ProjectBaseInfoEntity projectTypeentity;
	
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
	private ProjectBaseInformationEntity projectBaseInfoentity;
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
	 * 加息率 0：表示非加息标 单位：百万分之	
	 */
	private String rateAddRates;	
	/**
	 * 奖励百分比 0：表示非奖励标 单位：百万分之	
	 */
	private String rewardRates;
	
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
	 * 登录用户名
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
	/**
	 * 信用等级
	 */
	private String levelMark;
	/**
	 * 投标结束时间
	 */
	private String endDate; 
	/**
	 * 借款会员名称
	 */
	private String memberName;
	/**
	 * 借款会员电话
	 */
	private String personalPhone;
	/**
	 * 项目类型小图标
	 */
	private String picIcon;
	private long   investTotal;//已投资总额
	private String investTotals;//已投资总额
	private String projectName;//借款类型名称
	private String recordDate;//提交申请时间
	private String checkDate;//申请失败时间
	private String checkRemark;//申请失败原因
	private String releaseDate;//项目发布时间
	private String realEndDate;//实际投标结束日期
	private String holdDate;//放款时间
	private long   endamount;//实际借款金额
	private String endamounts;//实际借款金额
	private String repayTime;//最近一期还款时间
	private int    overdue;//统计是否逾期：0未逾期 1逾期
	private String settleDate;//结清时间
	private long   sdRepayAmount;//实际应还款总额
	private long   repayAmount;//实际还款总额
	private String sdRepayAmounts;//实际应还款总额
	private String repayAmounts;//实际还款总额
	private int    statu;//项目状态
	private String guaranteeName;//担保机构
	private String apName;//借款审核阶段
	private long principalAmount;//未还本金
	private long interestAmount;//未还利息
	private String principalAmounts;//未还本金
	private String interestAmounts;//未还利息
	private String repayMaxTime;//合同约定下一个还款日 
	private String getDate;//服务器时间
	public long getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(long principalAmount) {
		this.principalAmount = principalAmount;
		this.principalAmounts= IntegerAndString.LongToString(principalAmount);
	}
	public long getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(long interestAmount) {
		this.interestAmount = interestAmount;
		this.interestAmounts= IntegerAndString.LongToString(interestAmount);
	}
	public String getPrincipalAmounts() {
		return principalAmounts;
	}
	public void setPrincipalAmounts(String principalAmounts) {
		this.principalAmounts = principalAmounts;
	}
	public String getInterestAmounts() {
		return interestAmounts;
	}
	public void setInterestAmounts(String interestAmounts) {
		this.interestAmounts = interestAmounts;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public long getSdRepayAmount() {
		return sdRepayAmount;
	}
	public void setSdRepayAmount(long sdRepayAmount) {
		this.sdRepayAmount = sdRepayAmount;
		this.sdRepayAmounts= IntegerAndString.LongToString(sdRepayAmount);
	}
	public long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
		this.repayAmounts= IntegerAndString.LongToString(repayAmount);
	}
	public String getSdRepayAmounts() {
		return sdRepayAmounts;
	}
	public void setSdRepayAmounts(String sdRepayAmounts) {
		this.sdRepayAmounts = sdRepayAmounts;
	}
	public String getRepayAmounts() {
		return repayAmounts;
	}
	public void setRepayAmounts(String repayAmounts) {
		this.repayAmounts = repayAmounts;
	}
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
	public ProjectBaseInfoEntity getProjectTypeentity() {
		return projectTypeentity;
	}
	public void setProjectTypeentity(ProjectBaseInfoEntity projectTypeentity) {
		this.projectTypeentity = projectTypeentity;
	}
	public long getProjectBaseID() {
		return projectBaseID;
	}
	public void setProjectBaseID(long projectBaseID) {
		this.projectBaseID = projectBaseID;
	}
	public ProjectBaseInformationEntity getProjectBaseInfoentity() {
		return projectBaseInfoentity;
	}
	public void setProjectBaseInfoentity(
			ProjectBaseInformationEntity projectBaseInfoentity) {
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
		this.investRates= IntegerAndString.LongToString(investRate);
	}
 
	public String getInvestmentProgress() {
		return investmentProgress;
	}
	public void setInvestmentProgress(String investmentProgress) {
		this.investmentProgress = investmentProgress;
	}
	public MemberInfoEntity getMemberInfoEntity() {
		return memberInfoEntity;
	}
	public void setMemberInfoEntity(MemberInfoEntity memberInfoEntity) {
		this.memberInfoEntity = memberInfoEntity;
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
		this.availableaAmounts= IntegerAndString.LongToString(availableaAmount);
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
	public String getLevelMark() {
		return levelMark;
	}
	public void setLevelMark(String levelMark) {
		this.levelMark = levelMark;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPicIcon() {
		return picIcon;
	}
	public void setPicIcon(String picIcon) {
		this.picIcon = picIcon;
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckRemark() {
		return checkRemark;
	}
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public long getEndamount() {
		return endamount;
	}
	public void setEndamount(long endamount) {
		this.endamount = endamount;
		this.setEndamounts(IntegerAndString.LongToString(endamount));
	}
	public String getEndamounts() {
		return endamounts;
	}
	public void setEndamounts(String endamounts) {
		this.endamounts = endamounts;
	}
	public String getRepayTime() {
		return repayTime;
	}
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	public int getOverdue() {
		return overdue;
	}
	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public String getApName() {
		return apName;
	}
	public void setApName(String apName) {
		this.apName = apName;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public String getGetDate() {
		return getDate;
	}
	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}
	
}

