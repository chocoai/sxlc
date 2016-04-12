

/** 
* @Title: BankCodeEntity.java 
* @Package cn.bankcard.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午10:46:10 
* @version V5.0 */
 
package cn.membermng.model; 

/** 
 * @author 刘利 
 * @Description: 银行卡编号实体 
 * @since 
 * @date 2016-3-28 上午10:46:10  */

public class BankCodeEntity {
	/**
	 * 银行ID
	 */
	private int bankID	;
	/**
	 * 银行表实体类
	 */
	private BankInfoEntity bankInfoEntity;
	/**
	 * 银行编号	
	 */
	private String bankCode;
	/**
	 * 银行名称 
	 */
	private String  bankName;	
	/**
	 * 是否有效 0:无效 1：有效
	 */
	private int typeStatu;
	public int getBankID() {
		return bankID;
	}
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	public BankInfoEntity getBankInfoEntity() {
		return bankInfoEntity;
	}
	public void setBankInfoEntity(BankInfoEntity bankInfoEntity) {
		this.bankInfoEntity = bankInfoEntity;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		
		 return "BankCodeEntity [bankID=" + bankID + ", bankCode=" + bankCode  
	                + ", bankName=" + bankName + "]"; 
		
	} 		

}

