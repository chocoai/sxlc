

/** 
* @Title: BankInfoEntiry.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午10:36:07 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 银行表
 * @since 
 * @date 2016-3-28 上午10:36:07  */

public class BankInfoEntity {
	/**
	 * 银行卡信息ID
	 */
	private int bankID; 
	/**
	 * 银行名称 
	 */
	private String  bankName;	
	/**
	 * 是否有效 0:无效 1：有效	
	 */
	private int typeStatu	;
	public int getBankID() {
		return bankID;
	}
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	} 	

}

