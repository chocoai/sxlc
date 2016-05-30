package cn.invitemastermng.model; 


/***
 * 红包信息
 * 
 * @author 李杰
 * @since 
 * @date 2016-5-27 下午2:08:26 
 *
 */
public class AffairInfo {

	private long	affairId;				//活动编号
	private String 	affairName;				//活动名称
	private long	affairAccount;			//红包总金额
	private String	startDate;				//开始时间
	private String	endDate;				//结束时间
	
	
	
	public long getAffairId() {
		return affairId;
	}
	public void setAffairId(long affairId) {
		this.affairId = affairId;
	}
	public String getAffairName() {
		return affairName;
	}
	public void setAffairName(String affairName) {
		this.affairName = affairName;
	}
	public long getAffairAccount() {
		return affairAccount;
	}
	public void setAffairAccount(long affairAccount) {
		this.affairAccount = affairAccount;
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
	
}

