

/** 
* @Title: MemberThirdInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午11:24:47 
* @version V5.0 */
 
package cn.membermng.model; 

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
	 * varbinary(180)账户冻结金额	
	 */
	private long  frozen;
	/**
	 * 	varbinary(180)账户代金券可用余额		
	 */
	private long  giftUserBalance;	
	/**
	 * 	varbinary(180)账户代金券冻结金额	
	 */ 
	private long  giftFrozen;
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
	}
	public long getFrozen() {
		return frozen;
	}
	public void setFrozen(long frozen) {
		this.frozen = frozen;
	}
	public long getGiftUserBalance() {
		return giftUserBalance;
	}
	public void setGiftUserBalance(long giftUserBalance) {
		this.giftUserBalance = giftUserBalance;
	}
	public long getGiftFrozen() {
		return giftFrozen;
	}
	public void setGiftFrozen(long giftFrozen) {
		this.giftFrozen = giftFrozen;
	} 
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	} 

}

