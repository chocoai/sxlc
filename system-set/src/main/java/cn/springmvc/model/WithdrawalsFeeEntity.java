
package cn.springmvc.model; 

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
	private int check_Type;//提现是否需要审核 0：否 1：是
	public int getWithdrawal_Fee_Third() {
		return withdrawal_Fee_Third;
	}
	public void setWithdrawal_Fee_Third(int withdrawal_Fee_Third) {
		this.withdrawal_Fee_Third = withdrawal_Fee_Third;
	}
	public int getWithdrawal_Type_Third() {
		return withdrawal_Type_Third;
	}
	public void setWithdrawal_Type_Third(int withdrawal_Type_Third) {
		this.withdrawal_Type_Third = withdrawal_Type_Third;
	}
	public int getWithdrawal_Fee_Pingtai() {
		return withdrawal_Fee_Pingtai;
	}
	public void setWithdrawal_Fee_Pingtai(int withdrawal_Fee_Pingtai) {
		this.withdrawal_Fee_Pingtai = withdrawal_Fee_Pingtai;
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
	
}

