

/** 
* @Title: MemberThirdInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午11:24:47 
* @version V5.0 */
 
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 会员第三方账户信息实体
 * @since 
 * @date 2016-3-25 上午11:24:47  */

public class MemberThirdInfoEntity {
	/**
	 * 第三方账户信息ID
	 */
	private long accountId;
	/**
	 * 会员类型 0：会员 1：担保机构 2：平台	
	 */
	private int memberType;
	/**
	 * 会员ID
	 */
	private long  memberID;	
	/**
	 * 第三方账号	
	 */
	private String  thirdPartyAccount;
	/**
	 * 用户第三方账户标识	
	 */
	private String  thirdPartyMark; 
	/**
	 * 账户可用余额	
	 */
	private long  userBalance;	
	/**
	 * 账户可用余额	
	 */
	private String  userBalances;	
	/**
	 * varbinary(180)账户冻结金额	
	 */
	private long  frozen;
	/**
	 * varbinary(180)账户冻结金额	
	 */
	private String  frozens;
	/**
	 * 	varbinary(180)账户代金券可用余额		
	 */
	private long  giftUserBalance;
	/**
	 * 	varbinary(180)账户代金券可用余额		
	 */
	private String  giftUserBalances;
	/**
	 * 	varbinary(180)账户代金券冻结金额	
	 */ 
	private long  giftFrozen;
	/**
	 * 	varbinary(180)账户代金券冻结金额	
	 */ 
	private String  giftFrozens;
	
	/**
	 * 加密
	 */
	private String key;  
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getThirdPartyAccount() {
		return thirdPartyAccount;
	}
	public void setThirdPartyAccount(String thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}
	public String getThirdPartyMark() {
		return thirdPartyMark;
	}
	public void setThirdPartyMark(String thirdPartyMark) {
		this.thirdPartyMark = thirdPartyMark;
	}
	public long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
		this.userBalances= IntegerAndString.LongToString(userBalance);
	}
	public long getFrozen() {
		return frozen;
	}
	public void setFrozen(long frozen) {
		this.frozen = frozen;
		this.frozens= IntegerAndString.LongToString(frozen);
	}
	public long getGiftUserBalance() {
		return giftUserBalance;
	}
	public void setGiftUserBalance(long giftUserBalance) {
		this.giftUserBalance = giftUserBalance;
		this.giftUserBalances= IntegerAndString.LongToString(giftUserBalance);
	}
	public long getGiftFrozen() {
		return giftFrozen;
	}
	public void setGiftFrozen(long giftFrozen) {
		this.giftFrozen = giftFrozen;
		this.giftFrozens= IntegerAndString.LongToString(giftFrozen);
	} 
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	public String getFrozens() {
		return frozens;
	}
	public void setFrozens(String frozens) {
		this.frozens = frozens;
	} 
	public String getGiftUserBalances() {
		return giftUserBalances;
	}
	public void setGiftUserBalances(String giftUserBalances) {
		this.giftUserBalances = giftUserBalances;
	}
	public String getGiftFrozens() {
		return giftFrozens;
	}
	public void setGiftFrozens(String giftFrozens) {
		this.giftFrozens = giftFrozens;
	}
}

