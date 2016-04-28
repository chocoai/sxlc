

/** 
* @Title: LotteryActivityEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-19 下午4:21:59 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 抽奖活动列表
 * @since 
 * @date 2016-4-19 下午4:21:59  */

public class LotteryActivityEntity { 
	private long    lotteryID;//抽奖活动ID 
	private long    adminID;//管理员ID 
	private int     period;//	抽奖期数 
	private long	integra;//	单次抽奖所需积分 
	private String	startDate;//	抽奖活动开始时间 
	private String	endDate;//	抽奖活动结束时间 
	private int	    status;// 活动状态：1开启0关闭 
	public long getLotteryID() {
		return lotteryID;
	}
	public void setLotteryID(long lotteryID) {
		this.lotteryID = lotteryID;
	}
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public long getIntegra() {
		return integra;
	}
	public void setIntegra(long integra) {
		this.integra = integra;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}

