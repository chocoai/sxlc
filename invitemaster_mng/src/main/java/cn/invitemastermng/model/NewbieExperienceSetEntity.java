

/** 
* @Title: NewbieExperienceSetEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-19 下午3:10:27 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 新手体验标设置
 * @since 
 * @date 2016-4-19 下午3:10:27  */

public class NewbieExperienceSetEntity {
	private long   projectID;//体验标类型(项目类型)
	private String experienceName;//体验标标题
	private String experienceDescribe;//体验标描述
	private String experienceUrl;//体验标图片路径
	private int    repayWay;//体验产品还款方式
	private int    yearRate;//体验产品年化收益率
	private String yearRates;//体验产品年化收益率
	private int    deadline;//借款期限
	private int    deadlineType;//期限类型  0：天标 1：月标 2：年标
	private long   vouchersAmount;//投资即得代金券面值
	private String vouchersAmounts;//投资即得代金券面值
	private int    statu;//1启用0停用
	private String replayways;//还款方式字符窜
	
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getExperienceName() {
		return experienceName;
	}
	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}
	public String getExperienceDescribe() {
		return experienceDescribe;
	}
	public void setExperienceDescribe(String experienceDescribe) {
		this.experienceDescribe = experienceDescribe;
	}
	public String getExperienceUrl() {
		return experienceUrl;
	}
	public void setExperienceUrl(String experienceUrl) {
		this.experienceUrl = experienceUrl;
	}
	public int getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(int repayWay) {
		this.repayWay = repayWay;
	}
	public int getYearRate() {
		return yearRate;
	}
	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
		this.yearRates = IntegerAndString.IntToString(yearRate);
	}
	public String getYearRates() {
		return yearRates;
	}
	public void setYearRates(String yearRates) {
		this.yearRates = yearRates;
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
	public long getVouchersAmount() {
		return vouchersAmount;
	}
	public void setVouchersAmount(long vouchersAmount) {
		this.vouchersAmount = vouchersAmount;
		this.setVouchersAmounts(IntegerAndString.LongToString(vouchersAmount));
	}
	 
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getVouchersAmounts() {
		return vouchersAmounts;
	}
	public void setVouchersAmounts(String vouchersAmounts) {
		this.vouchersAmounts = vouchersAmounts;
	}
	@Override
	public String toString() {
		return "NewbieExperienceSetEntity [体验标类型=" + projectID
				+ ", 体验标标题=" + experienceName
				+ ", 体验标描述=" + experienceDescribe
				+ ", 体验标图片路径=" + experienceUrl + ", 体验产品还款方式=" + repayWay
				+ ", 体验产品年化收益率=" + yearRates
				+ ", 借款期限=" + deadline + ", 期限类型=" + deadlineType
				+ ", 投资即得代金券面值="
				+ vouchersAmounts + ", 状态（1启用0停用）=" + statu + "]";
	}
	public String getReplayways() {
		return replayways;
	}
	public void setReplayways(String replayways) {
		this.replayways = replayways;
	}

}

