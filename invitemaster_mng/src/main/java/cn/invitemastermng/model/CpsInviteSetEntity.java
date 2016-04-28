

/** 
* @Title: CpsInviteSetEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-18 下午4:54:03 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: cps推荐配置表
 * @since 
 * @date 2016-4-18 下午4:54:03  */

public class CpsInviteSetEntity {
	private int firstInvestSet;//cps推荐首次投资返现金额 单位：元  保留4位小数		
	private int inviteSet;//开通第三方账户成功返现金额 单位：元  保留4位小数		
	private int firstBorrowSet;//首次借款成功返现金额 单位：元  保留4位小数		
	private int firstRechargeSet;//首次充值成功返现金额 单位：元  保留4位小数		
	private String firstInvestSets;//cps推荐首次投资返现金额 单位：元  保留4位小数		
	private String inviteSets;//开通第三方账户成功返现金额 单位：元  保留4位小数		
	private String firstBorrowSets;//首次借款成功返现金额 单位：元  保留4位小数		
	private String firstRechargeSets;//首次充值成功返现金额 单位：元  保留4位小数		
	public String getFirstInvestSets() {
		return firstInvestSets;
	}
	public void setFirstInvestSets(String firstInvestSets) {
		this.firstInvestSets = firstInvestSets;
	}
	public String getInviteSets() {
		return inviteSets;
	}
	public void setInviteSets(String inviteSets) {
		this.inviteSets = inviteSets;
	}
	public String getFirstBorrowSets() {
		return firstBorrowSets;
	}
	public void setFirstBorrowSets(String firstBorrowSets) {
		this.firstBorrowSets = firstBorrowSets;
	}
	public String getFirstRechargeSets() {
		return firstRechargeSets;
	}
	public void setFirstRechargeSets(String firstRechargeSets) {
		this.firstRechargeSets = firstRechargeSets;
	}
	public int getFirstInvestSet() {
		return firstInvestSet;
	}
	public void setFirstInvestSet(int firstInvestSet) {
		this.firstInvestSet = firstInvestSet;
		this.firstInvestSets = IntegerAndString.IntToString(firstInvestSet);
	}
	public int getInviteSet() {
		return inviteSet;
	}
	public void setInviteSet(int inviteSet) {
		this.inviteSet = inviteSet;
		this.inviteSets = IntegerAndString.IntToString(inviteSet);
	}
	public int getFirstBorrowSet() {
		return firstBorrowSet;
	}
	public void setFirstBorrowSet(int firstBorrowSet) {
		this.firstBorrowSet = firstBorrowSet;
		this.firstBorrowSets = IntegerAndString.IntToString(firstBorrowSet);
	}
	public int getFirstRechargeSet() {
		return firstRechargeSet;
	}
	public void setFirstRechargeSet(int firstRechargeSet) {
		this.firstRechargeSet = firstRechargeSet;
		this.firstRechargeSets = IntegerAndString.IntToString(firstRechargeSet);
	}

}

