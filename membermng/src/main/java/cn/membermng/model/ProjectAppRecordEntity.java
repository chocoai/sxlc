

/** 
* @Title: ProjectAppRecordEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午10:19:33 
* @version V5.0 */
 
package cn.membermng.model; 

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
	 * 资产管理方ID
	 */
	private long assetManagerID; 	
	/**
	 *  担保机构ID	
	 */
	private long guaranteeID;  
	/**
	 * 项目编号（发布后生成编号）
	 */
	private String projectNo; 
	/**
	 * 投标进度 百万分之
	 */
	private int investRate; 
	/**
	 * 投标结束时间
	 */
	private String endDate;   
	private String projectName;//借款类型名称
	private String recordDate;//提交申请时间 
	private String releaseDate;//项目发布时间
	private String realEndDate;//实际投标结束日期
	private String holdDate;//放款时间
	private long   endamount;//实际借款金额
	private String endamounts;//实际借款金额 
	private String settleDate;//结清时间 
	private int    statu;//项目状态
	private String guaranteeName;//担保机构   
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
	 
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	 
	public int getInvestRate() {
		return investRate;
	}
	 
	public long getPurposeID() {
		return purposeID;
	}
	public void setPurposeID(long purposeID) {
		this.purposeID = purposeID;
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
	 
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	} 
}

