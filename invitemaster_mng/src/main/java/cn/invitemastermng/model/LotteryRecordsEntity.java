

/** 
* @Title: LotteryRecordsEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午11:30:11 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 抽奖记录实体
 * @since 
 * @date 2016-4-15 上午11:30:11  */

public class LotteryRecordsEntity {
	private int    period;//抽奖期数
	private String startDate;//抽奖活动开始时间
	private int    integra;//消耗积分
	private int    grade;//获奖等级
	private int    prizeType;//奖品类型
	private String prizeName;//奖品名称
	private long   prizeWorth;//奖品价值
	private String lotteryTime;//中奖时间
	private String memberNo;//中奖会员编号
	private String logname;//中奖会员用户名
	private String personalPhone;//中奖会员手机号
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getIntegra() {
		return integra;
	}
	public void setIntegra(int integra) {
		this.integra = integra;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getPrizeType() {
		return prizeType;
	}
	public void setPrizeType(int prizeType) {
		this.prizeType = prizeType;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public long getPrizeWorth() {
		return prizeWorth;
	}
	public void setPrizeWorth(long prizeWorth) {
		this.prizeWorth = prizeWorth;
	}
	public String getLotteryTime() {
		return lotteryTime;
	}
	public void setLotteryTime(String lotteryTime) {
		this.lotteryTime = lotteryTime;
	}
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
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
}

