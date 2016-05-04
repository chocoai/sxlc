

/** 
* @Title: MemberTradingRecordsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午6:00:37 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: 交易记录实体
 * @since 
 * @date 2016-4-13 下午6:00:37  */

public class MemberTradingRecordsEntity {
	private long    tradeID;//交易记录ID
	private String  recordNo;//序号ID
	private String  typeName;//交易类型
	private long    amount;//交易金额
	private long    frozenBalance;//冻结金额
	private long    userBalance;//可用余额
	private String  amounts;//交易金额
	private String  frozenBalances;//冻结金额
	private String  userBalances;//可用余额
	private String  guaranteeName;//交易对方
	private String  recordDate;//交易时间
	private String  abstracts;//描述
	public long getTradeID() {
		return tradeID;
	}
	public void setTradeID(long tradeID) {
		this.tradeID = tradeID;
	}
	public String getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getFrozenBalance() {
		return frozenBalance;
	}
	public void setFrozenBalance(long frozenBalance) {
		this.frozenBalance = frozenBalance;
	}
	public long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public String getFrozenBalances() {
		return frozenBalances;
	}
	public void setFrozenBalances(String frozenBalances) {
		this.frozenBalances = frozenBalances;
	}
	public String getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	public String getGuaranteeName() {
		return guaranteeName;
	}
	public void setGuaranteeName(String guaranteeName) {
		this.guaranteeName = guaranteeName;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
}

