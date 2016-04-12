
package cn.springmvc.model; 

/** 
 * 可转让债权列表
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-30 下午5:19:29  */
public class TransferableCreditsEntity {
	private long investId;//投资记录id
	private String projectTitle;//项目标题
	private String deadlineTypeName;//期限类型名称
	private long yearRate;//年化利率
	private long money;//剩余可转让金额
	private int cou;//剩余期限 
	private String nextTime;//下一还款日
	public long getInvestId() {
		return investId;
	}
	public void setInvestId(long investId) {
		this.investId = investId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getDeadlineTypeName() {
		return deadlineTypeName;
	}
	public void setDeadlineTypeName(String deadlineTypeName) {
		this.deadlineTypeName = deadlineTypeName;
	}
	public long getYearRate() {
		return yearRate;
	}
	public void setYearRate(long yearRate) {
		this.yearRate = yearRate;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public int getCou() {
		return cou;
	}
	public void setCou(int cou) {
		this.cou = cou;
	}
	public String getNextTime() {
		return nextTime;
	}
	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}
	
}

