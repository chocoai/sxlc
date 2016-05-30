package cn.membermng.model; 




/***
 * 会员第三方账户设置信息表
 * 
 * @author 李杰
 * @since 
 * @date 2016-5-26 下午2:19:19 
 *
 */
public class MemberThirdAuthInfo {
	
	
	private long				accountId;				//第三方账户编号
	private int					openAutoRecharge;		//是否授权代扣         0否、1是
	private int					isAutoRecharge;			//代扣		 0否、1是
	private int					openAutoPay;			//自动还款授权	 0否、1是
	private int					isAutoPay;				//自动还款		 0否、1是
	private int					openAutoInvest;			//自动投标授权	 0否、1是
	private int					isAutoInvest;			//自动投标		 0否、1是
	private int					openSecondDistribute;	//二次分配授权	 0否、1是
	
	
	
	
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
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

