

/** 
* @Title: ProjectStatisticEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 下午12:03:10 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 项目统计
 * @since 
 * @date 2016-4-27 下午12:03:10  */

public class ProjectStatisticEntity {
	private long    applyId;//项目申请ID
	private String  projectNo;//项目编号
	private String  logname;//借款用户名
	private String  memberNo;//借款会员编号
	private String  projectTitle;//借款项目名称
	private String  memberName;//借款会员名字
	private long    amount;//借款金额
	private String  amounts;//借款金额
	private String  realEndDate;//借款金额
	private long    realAmount;//借款金额
	private String  realAmounts;//借款金额
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
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
		this.amounts= IntegerAndString.LongToString(amount);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts= IntegerAndString.LongToString(realAmount);
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}
}

