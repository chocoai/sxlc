

/** 
* @Title: ProjectInfoStatisticalEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午9:26:17 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 统计中心-借款统计实体
 * @since 
 * @date 2016-4-13 下午9:26:17  */

public class ProjectInfoStatisticalEntity {
	private long applyId;//项目申请记录ID
	private String projectNo;//项目编号
	private String projectName;//项目类型
	private String projectTitle;//项目名称
	private String logname;//借款人用户名
	private String personalName;//借款人姓名
	private long   amount;//借款金额
	private long   investAmountValid;//实际借款金额
	private long   realAmount;//实际到账金额 
	private String amounts;//借款金额
	private String investAmountValids;//实际借款金额
	private String realAmounts;//实际到账金额
	private String holdDate;//借款到账时间
	private long   mngFeeAmount;//平台借款管理费
	private String mngFeeAmounts;//平台借款管理费
	private String mngFeeDate;//平台借款管理费到账时间
	private long   guaranteeFee;//担保费
	private String guaranteeFees;//担保费
	private String guaranteeDate;//担保费到账时间
	private String guaranteeName;//担保方名称
	private int    statu;//项目状态
	private String remark;//备注
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
		this.investAmountValids=IntegerAndString.LongToString(investAmountValid);
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts=IntegerAndString.LongToString(realAmount);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	}
	public long getMngFeeAmount() {
		return mngFeeAmount;
	}
	public void setMngFeeAmount(long mngFeeAmount) {
		this.mngFeeAmount = mngFeeAmount;
		this.mngFeeAmounts=IntegerAndString.LongToString(mngFeeAmount);
	}
	public String getMngFeeAmounts() {
		return mngFeeAmounts;
	}
	public void setMngFeeAmounts(String mngFeeAmounts) {
		this.mngFeeAmounts = mngFeeAmounts;
	}
	public String getMngFeeDate() {
		return mngFeeDate;
	}
	public void setMngFeeDate(String mngFeeDate) {
		this.mngFeeDate = mngFeeDate;
	}
	public long getGuaranteeFee() {
		return guaranteeFee;
	}
	public void setGuaranteeFee(long guaranteeFee) {
		this.guaranteeFee = guaranteeFee;
		this.guaranteeFees=IntegerAndString.LongToString(guaranteeFee);
	}
	public String getGuaranteeFees() {
		return guaranteeFees;
	}
	public void setGuaranteeFees(String guaranteeFees) {
		this.guaranteeFees = guaranteeFees;
	}
	public String getGuaranteeDate() {
		return guaranteeDate;
	}
	public void setGuaranteeDate(String guaranteeDate) {
		this.guaranteeDate = guaranteeDate;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

