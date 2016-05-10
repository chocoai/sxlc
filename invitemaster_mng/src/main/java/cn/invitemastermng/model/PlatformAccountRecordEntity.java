
package cn.invitemastermng.model; 

/**
 * 平台账户交易记录 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-27 上午10:51:44  */
public class PlatformAccountRecordEntity {
	private String recordDate;//交易记录时间
	private long amount;//交易金额
	private String recordType;//交易类型
	private String accountTType;//账户类型
	private String abstractText;//摘要
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getAccountTType() {
		return accountTType;
	}
	public void setAccountTType(String accountTType) {
		this.accountTType = accountTType;
	}
	public String getAbstractText() {
		return abstractText;
	}
	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}
	
}

