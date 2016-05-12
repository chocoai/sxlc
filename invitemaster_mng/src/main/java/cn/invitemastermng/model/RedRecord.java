package cn.invitemastermng.model; 

import java.util.Date;



/****
* 红包领取记录
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-19 下午1:57:15 
*
*/
public class RedRecord {

	private String					userName		;//领取用户名
	private long					amount			;//领取金额
	private String					sAmount			;//
	private Date					recordDate		;//领取时间
	private String					sRecordDate		;
	
	public RedRecord() {}

	public RedRecord(String userName, long amount, String sAmount,
			Date recordDate, String sRecordDate) {
		super();
		this.userName = userName;
		this.amount = amount;
		this.sAmount = sAmount;
		this.recordDate = recordDate;
		this.sRecordDate = sRecordDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getsAmount() {
		return sAmount;
	}

	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getsRecordDate() {
		return sRecordDate;
	}

	public void setsRecordDate(String sRecordDate) {
		this.sRecordDate = sRecordDate;
	}
	
	
	
}

