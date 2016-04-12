

/** 
* @Title: MemberThirdAuthInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午11:33:20 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-25 上午11:33:20  */

public class MemberThirdAuthInfoEntity {
	/**
	 * 第三方账户ID
	 */
	private long accountId;	 
	/**
	 * 第三方账户实体
	 */
	private MemberThirdInfoEntity memberThirdInfoEntity;
	/**
	 * 是否授权代扣 0：否 1：是	
	 */
	private int openAutoRecharge;
	/**
	 * 是否代扣 0：否 1：是
	 */
	private int isAutoRecharge; 
	/**
	 * 是否授权自动还款 0：否 1：是
	 */
	private int openAutoPay;
	/**
	 * 是否自动还款 0：否 1：是 	
	 */
	private int isAutoPay; 
	/**
	 * 是否授权自动投标 0：否 1：是
	 */
	private int openAutoInvest; 
	/**
	 * 是否自动投标 0：否 1：是 	
	 */
	private int isAutoInvest;
	/**
	 * 是否授权二次分配
	 */
	private int openSecondDistribute;
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public MemberThirdInfoEntity getMemberThirdInfoEntity() {
		return memberThirdInfoEntity;
	}
	public void setMemberThirdInfoEntity(MemberThirdInfoEntity memberThirdInfoEntity) {
		this.memberThirdInfoEntity = memberThirdInfoEntity;
	}
	public int getOpenAutoRecharge() {
		return openAutoRecharge;
	}
	public void setOpenAutoRecharge(int openAutoRecharge) {
		this.openAutoRecharge = openAutoRecharge;
	}
	public int getIsAutoRecharge() {
		return isAutoRecharge;
	}
	public void setIsAutoRecharge(int isAutoRecharge) {
		this.isAutoRecharge = isAutoRecharge;
	}
	public int getOpenAutoPay() {
		return openAutoPay;
	}
	public void setOpenAutoPay(int openAutoPay) {
		this.openAutoPay = openAutoPay;
	}
	public int getIsAutoPay() {
		return isAutoPay;
	}
	public void setIsAutoPay(int isAutoPay) {
		this.isAutoPay = isAutoPay;
	}
	public int getOpenAutoInvest() {
		return openAutoInvest;
	}
	public void setOpenAutoInvest(int openAutoInvest) {
		this.openAutoInvest = openAutoInvest;
	}
	public int getIsAutoInvest() {
		return isAutoInvest;
	}
	public void setIsAutoInvest(int isAutoInvest) {
		this.isAutoInvest = isAutoInvest;
	}
	public int getOpenSecondDistribute() {
		return openSecondDistribute;
	}
	public void setOpenSecondDistribute(int openSecondDistribute) {
		this.openSecondDistribute = openSecondDistribute;
	}	 	

}

