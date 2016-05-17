

/** 
* @Title: ProjectCollectionEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午5:14:45 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 账单催收
 * @since 
 * @date 2016-4-15 下午5:14:45  */

public class PostProjectEntity {
	private long   repayID;					//还款计划ID
	private long   applyId;					//借款项目申请ID
	private String projectNo;				//项目编号
	private String projectTitle; 			//项目标题
    private String memberName; 				//借款会员名称
    private long   amount;					//账单金额 
    private String amounts;					//账单金额 
    private long   lPrincipal;				//应还本金
    private String sPrincipal;				//应还本金
    private long   lInterest;				//应还利息
    private String sInterest;				//应还利息
    private int    indexs;					//账单期数
    private String repayMaxTime;			//应还款时间
    private int    overDay;					//逾期天数
    private long   overdueAmount;			//逾期费用
    private String overdueAmounts;			//逾期费用
    private String repayTime;				//实际还款时间
    private String merbillNo;				//账单编号
    private String holdDate;				//放款时间
	public long getlPrincipal() {
		return lPrincipal;
	}
	public void setlPrincipal(long lPrincipal) {
		this.lPrincipal = lPrincipal;
		this.sPrincipal = IntegerAndString.LongToString(lPrincipal);
	}
	public String getsPrincipal() {
		return sPrincipal;
	}
	public void setsPrincipal(String sPrincipal) {
		this.sPrincipal = sPrincipal;
	}
	public long getlInterest() {
		return lInterest;
	}
	public void setlInterest(long lInterest) {
		this.lInterest = lInterest;
		this.sInterest = IntegerAndString.LongToString(lInterest);
	}
	public String getsInterest() {
		return sInterest;
	}
	public void setsInterest(String sInterest) {
		this.sInterest = sInterest;
	}
	public long getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(long overdueAmount) {
		this.overdueAmount = overdueAmount;
		this.overdueAmounts = IntegerAndString.LongToString(overdueAmount);
	}
	public String getOverdueAmounts() {
		return overdueAmounts;
	}
	public void setOverdueAmounts(String overdueAmounts) {
		this.overdueAmounts = overdueAmounts; 
	}
	public String getRepayTime() {
		return repayTime;
	}
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	public String getMerbillNo() {
		return merbillNo;
	}
	public void setMerbillNo(String merbillNo) {
		this.merbillNo = merbillNo;
	}
	public long getRepayID() {
		return repayID;
	}
	public void setRepayID(long repayID) {
		this.repayID = repayID;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts = IntegerAndString.LongToString(amount);
	}
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public String getRepayMaxTime() {
		return repayMaxTime;
	}
	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = repayMaxTime;
	}
	public int getOverDay() {
		return overDay;
	}
	public void setOverDay(int overDay) {
		this.overDay = overDay;
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	@Override
	public String toString() {
		return "PostProjectEntity [repayID=" + repayID + ", applyId=" + applyId
				+ ", projectNo=" + projectNo + ", projectTitle=" + projectTitle
				+ ", memberName=" + memberName + ", amount=" + amount
				+ ", amounts=" + amounts + ", indexs=" + indexs
				+ ", repayMaxTime=" + repayMaxTime + ", overDay=" + overDay
				+ ", overdueAmount=" + overdueAmount + ", overdueAmounts="
				+ overdueAmounts + ", repayTime=" + repayTime + ", merbillNo="
				+ merbillNo + "]";
	}
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = holdDate;
	} 
	
}

