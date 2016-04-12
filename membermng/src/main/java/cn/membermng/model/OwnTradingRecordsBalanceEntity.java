

/** 
* @Title: OwnTradingRecordsBalanceEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午1:37:07 
* @version V5.0 */
 
package cn.membermng.model;  

/** 
 * @author 刘利 
 * @Description: 会员交易记录余额实体类 
 * @since 
 * @date 2016-3-22 下午1:37:07  */

public class OwnTradingRecordsBalanceEntity {
	/**
	 * 交易记录ID
	 */
	private  long tradeID; 
	/**
	 * 账户可用余额(分)
	 */
	private  long userBalance;
	/**
	 * 账户可用余额(分)
	 */
	private  String userBalances;
	/**
	 * 账户冻结金额
	 */
	private  long frozenBalance ;
	/**
	 * 账户冻结金额
	 */
	private  String frozenBalances ;
	/**
	 * 账户可用赠送余额 代金券
	 */
	private  long userGift	;
	/**
	 * 账户可用赠送余额 代金券
	 */
	private  String userGifts	;
	/**
	 * 账户冻结赠送金额 代金券
	 */
	private  long frozenGift;
	/**
	 * 账户冻结赠送金额 代金券
	 */
	private  String frozenGifts;
	public String getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	public String getFrozenBalances() {
		return frozenBalances;
	}
	public void setFrozenBalances(String frozenBalances) {
		this.frozenBalances = frozenBalances;
	}
	public String getUserGifts() {
		return userGifts;
	}
	public void setUserGifts(String userGifts) {
		this.userGifts = userGifts;
	}
	public String getFrozenGifts() {
		return frozenGifts;
	}
	public void setFrozenGifts(String frozenGifts) {
		this.frozenGifts = frozenGifts;
	}
	public long getTradeID() {
		return tradeID;
	}
	public void setTradeID(long tradeID) {
		this.tradeID = tradeID;
	}
	public long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
	}
	public long getFrozenBalance() {
		return frozenBalance;
	}
	public void setFrozenBalance(long frozenBalance) {
		this.frozenBalance = frozenBalance;
	}
	public long getUserGift() {
		return userGift;
	}
	public void setUserGift(long userGift) {
		this.userGift = userGift;
	}
	public long getFrozenGift() {
		return frozenGift;
	}
	public void setFrozenGift(long frozenGift) {
		this.frozenGift = frozenGift;
	}	 		

}

