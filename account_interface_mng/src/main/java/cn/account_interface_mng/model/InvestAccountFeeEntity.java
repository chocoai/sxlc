
package cn.account_interface_mng.model; 
/**
 * 投资资金及账户信息查询数据封装
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-3-31 下午7:24:20
 */
public class InvestAccountFeeEntity {
	// pbi.Amount,pam.MngFee_Amount,pam.RiskMargin_Fee,pam.Guarantee_Fee,mtib.ThirdParty_Mark,mti.ThirdParty_Mark 
	private String sGuaranteeMark;			//担保公司第三方账户标识
	private String sMemberMark;				//投资会员第三方账户标识
	private long lAmountTotal;				//借款总金额
	private long lMngFee;					//管理费
	private long lRiskMarginFee;			//风险保证金
	private long lGuaranteeFee;				//担保费
	private String sProjectNo;				//项目编号
	private long iRewardRate;				//投资奖励比例
	public long getiRewardRate() {
		return iRewardRate;
	}
	public void setiRewardRate(long iRewardRate) {
		this.iRewardRate = iRewardRate;
	}
	public String getsProjectNo() {
		return sProjectNo;
	}
	public void setsProjectNo(String sProjectNo) {
		this.sProjectNo = sProjectNo;
	}
	public String getsGuaranteeMark() {
		return sGuaranteeMark;
	}
	public void setsGuaranteeMark(String sGuaranteeMark) {
		this.sGuaranteeMark = sGuaranteeMark;
	}
	public String getsMemberMark() {
		return sMemberMark;
	}
	public void setsMemberMark(String sMemberMark) {
		this.sMemberMark = sMemberMark;
	}
	public long getlAmountTotal() {
		return lAmountTotal;
	}
	public void setlAmountTotal(long lAmountTotal) {
		this.lAmountTotal = lAmountTotal;
	}
	public long getlMngFee() {
		return lMngFee;
	}
	public void setlMngFee(long lMngFee) {
		this.lMngFee = lMngFee;
	}
	public long getlRiskMarginFee() {
		return lRiskMarginFee;
	}
	public void setlRiskMarginFee(long lRiskMarginFee) {
		this.lRiskMarginFee = lRiskMarginFee;
	}
	public long getlGuaranteeFee() {
		return lGuaranteeFee;
	}
	public void setlGuaranteeFee(long lGuaranteeFee) {
		this.lGuaranteeFee = lGuaranteeFee;
	}
}

