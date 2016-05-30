
package cn.springmvc.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * 提现手续费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午12:01:17  */
public class WithdrawalsFeeEntity {
	private int payment_Member_Type;//手续费支付会员类型 0：前台会员 1：第三方合作机构 2：平台
	private int withdrawal_Fee_Third=1;//第三方提现管理费 0 表示不需要支付  1:需要支付
	private int withdrawal_Type_Third=0;//第三方提现管理费类型 0：百分比 1：固定金额
	private int withdrawal_Fee_Pingtai;//提现手续费平台代付百分比
	
	private String swithdrawal_Fee_Third="";//第三方提现管理费 0 表示不需要支付  1:需要支付
	private String swithdrawal_Type_Third="";//第三方提现管理费类型 0：百分比 1：固定金额
	private String swithdrawal_Fee_Pingtai="";//提现手续费平台代付百分比
	
	private int check_Type;//提现是否需要审核 0：否 1：是
	public int getWithdrawal_Fee_Third() {
		return withdrawal_Fee_Third;
	}
	public void setWithdrawal_Fee_Third(int withdrawal_Fee_Third) {
		this.withdrawal_Fee_Third = withdrawal_Fee_Third;
		this.swithdrawal_Fee_Third = IntegerAndString.IntToString(withdrawal_Fee_Third);
	}
	public int getWithdrawal_Type_Third() {
		return withdrawal_Type_Third;
	}
	public void setWithdrawal_Type_Third(int withdrawal_Type_Third) {
		this.withdrawal_Type_Third = withdrawal_Type_Third;
		this.swithdrawal_Type_Third = IntegerAndString.IntToString(withdrawal_Type_Third);
	}
	public int getWithdrawal_Fee_Pingtai() {
		return withdrawal_Fee_Pingtai;
	}
	public void setWithdrawal_Fee_Pingtai(int withdrawal_Fee_Pingtai) {
		this.withdrawal_Fee_Pingtai = withdrawal_Fee_Pingtai;
		this.swithdrawal_Fee_Pingtai = IntegerAndString.IntToString(withdrawal_Fee_Pingtai);
	}
	public int getCheck_Type() {
		return check_Type;
	}
	public void setCheck_Type(int check_Type) {
		this.check_Type = check_Type;
	}
	public int getPayment_Member_Type() {
		return payment_Member_Type;
	}
	public void setPayment_Member_Type(int payment_Member_Type) {
		this.payment_Member_Type = payment_Member_Type;
	}
	@Override
	public String toString() {
		return "提现手续费设置[payment_Member_Type(手续费支付会员类型)="
				+ payment_Member_Type + ", withdrawal_Fee_Third(第三方提现管理费)="
				+ withdrawal_Fee_Third + ", withdrawal_Type_Third(第三方提现管理费类型)="
				+ withdrawal_Type_Third + ", withdrawal_Fee_Pingtai(提现手续费平台代付百分比)="
				+ withdrawal_Fee_Pingtai + ", check_Type(提现是否需要审核)=" + check_Type + "]";
	}
	public String getSwithdrawal_Fee_Third() {
		return swithdrawal_Fee_Third;
	}
	public void setSwithdrawal_Fee_Third(String swithdrawal_Fee_Third) {
		this.swithdrawal_Fee_Third = swithdrawal_Fee_Third;
	}
	public String getSwithdrawal_Type_Third() {
		return swithdrawal_Type_Third;
	}
	public void setSwithdrawal_Type_Third(String swithdrawal_Type_Third) {
		this.swithdrawal_Type_Third = swithdrawal_Type_Third;
	}
	public String getSwithdrawal_Fee_Pingtai() {
		return swithdrawal_Fee_Pingtai;
	}
	public void setSwithdrawal_Fee_Pingtai(String swithdrawal_Fee_Pingtai) {
		this.swithdrawal_Fee_Pingtai = swithdrawal_Fee_Pingtai;
	}
	
}

