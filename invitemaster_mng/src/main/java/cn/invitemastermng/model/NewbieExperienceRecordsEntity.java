

/** 
* @Title: NewbieExperienceRecordsEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午1:51:07 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 会员体验收益获取记录
 * @since 
 * @date 2016-4-15 下午1:51:07  */

public class NewbieExperienceRecordsEntity {
	private String memberNo;//会员编号
	private String logname;//会员用户名
	private String personalName;//会员名称
	private String regDate;//开户时间
	private String experienceDate;//投资体验标时间
	private long   vouchersAmount;//代金券面值
	private int    prizeWorth;//是否成功发放
	private long   incomeAmount;//收益总金额
	private String vouchersAmounts;//代金券面值 
	private String incomeAmounts;//收益总金额
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getExperienceDate() {
		return experienceDate;
	}
	public void setExperienceDate(String experienceDate) {
		this.experienceDate = experienceDate;
	}
	public long getVouchersAmount() {
		return vouchersAmount;
	}
	public void setVouchersAmount(long vouchersAmount) {
		this.vouchersAmount = vouchersAmount;
		this.vouchersAmounts = IntegerAndString.LongToString(vouchersAmount);
	}
	public int getPrizeWorth() {
		return prizeWorth;
	}
	public void setPrizeWorth(int prizeWorth) {
		this.prizeWorth = prizeWorth;
	}
	public long getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(long incomeAmount) {
		this.incomeAmount = incomeAmount;
		this.incomeAmounts = IntegerAndString.LongToString(incomeAmount);
	}
	public String getVouchersAmounts() {
		return vouchersAmounts;
	}
	public void setVouchersAmounts(String vouchersAmounts) {
		this.vouchersAmounts = vouchersAmounts;
	}
	public String getIncomeAmounts() {
		return incomeAmounts;
	}
	public void setIncomeAmounts(String incomeAmounts) {
		this.incomeAmounts = incomeAmounts;
	}
	 
}

