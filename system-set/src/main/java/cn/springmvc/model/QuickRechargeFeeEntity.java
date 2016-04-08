
package cn.springmvc.model; 

/** 
 * 充值快捷支付手续费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午4:45:34  */
public class QuickRechargeFeeEntity {
	private int rechargeFeeThird;//第三方收取充值管理费 0 表示不需要支付
	private int rechargeTypeThird;//第三方充值管理费类型 0：百分比 1：固定金额
	private int paymentMemberType;//充值手续费支付会员类型 0：前台会员 1：第三方合作机构 2：平台
	private int feePaymentMethod;//充值手续费支付方式 1.充值成功时从充值人账户全额扣除
	//2.充值成功时从平台自有账户全额扣除
	//3.充值成功时从充值人账户扣除与提现手续费的差值
	//4.充值成功时从平台自有账户扣除与提现手续费的差值
	public int getPaymentMemberType() {
		return paymentMemberType;
	}
	public void setPaymentMemberType(int paymentMemberType) {
		this.paymentMemberType = paymentMemberType;
	}
	public int getFeePaymentMethod() {
		return feePaymentMethod;
	}
	public void setFeePaymentMethod(int feePaymentMethod) {
		this.feePaymentMethod = feePaymentMethod;
	}
	public int getRechargeTypeThird() {
		return rechargeTypeThird;
	}
	public void setRechargeTypeThird(int rechargeTypeThird) {
		this.rechargeTypeThird = rechargeTypeThird;
	}
	public int getRechargeFeeThird() {
		return rechargeFeeThird;
	}
	public void setRechargeFeeThird(int rechargeFeeThird) {
		this.rechargeFeeThird = rechargeFeeThird;
	}
	
}

