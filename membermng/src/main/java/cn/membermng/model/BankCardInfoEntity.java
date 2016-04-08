

/** 
* @Title: BankCardInfoEntity.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午10:52:49 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 银行卡信息实体
 * @since 
 * @date 2016-3-28 上午10:52:49  */

public class BankCardInfoEntity {
	/**
	 * 银行卡信息ID
	 */
	private long bankCardId; 
	/**
	 * 银行编号ID
	 */
	private int bankId;
	/**
	 * 银行卡省份ID	
	 */
	private int cardProvince;
	/**
	 * 银行卡城市ID
	 */
	private int cardCity;	
	/**
	 * 开户行支行
	 */
	private String branch;	
	/**
	 * 开户行支行地址
	 */
	private String branchAddress;
	/**
	 *  银行卡号	
	 */
	private String bankNo;
	/**
	 * 银行卡关联手机号	
	 */
	private String bankPhone;
	public long getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getCardProvince() {
		return cardProvince;
	}
	public void setCardProvince(int cardProvince) {
		this.cardProvince = cardProvince;
	}
	public int getCardCity() {
		return cardCity;
	}
	public void setCardCity(int cardCity) {
		this.cardCity = cardCity;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankPhone() {
		return bankPhone;
	}
	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}
	@Override
	public String toString() {
		return "BankCardInfoEntity [bankCardId=" + bankCardId + ", bankId="
				+ bankId + ", cardProvince=" + cardProvince + ", cardCity="
				+ cardCity + ", branch=" + branch + ", branchAddress="
				+ branchAddress + ", bankNo=" + bankNo + ", bankPhone="
				+ bankPhone + "]";
	} 

}

