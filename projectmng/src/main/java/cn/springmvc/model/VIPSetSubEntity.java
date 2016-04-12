package cn.springmvc.model;
/**
 * VIP会员设置实体类
 * @author 刘利
 *
 */
public class VIPSetSubEntity {
	/**
	 * VIP年费金额  单位元  保留4位小数
	 */
	private int vipAttest; 
	/**
	 * 上个VIP截止日起累计有效投资N元 自动生成
	 */
	private long vipInvest;
	/**
	 * VIP借款管理费折扣
	 */
	private int BorrowMngRate;	
	/**
	 * VIP投资管理费折扣
	 */
	private int InvestMngRate;
	/**
	 * vip有效期限
	 */
	private int vipTerm;
	public int getVipAttest() {
		return vipAttest;
	}
	public void setVipAttest(int vipAttest) {
		this.vipAttest = vipAttest;
	}
	public long getVipInvest() {
		return vipInvest;
	}
	public void setVipInvest(long vipInvest) {
		this.vipInvest = vipInvest;
	}
	public int getBorrowMngRate() {
		return BorrowMngRate;
	}
	public void setBorrowMngRate(int borrowMngRate) {
		BorrowMngRate = borrowMngRate;
	}
	public int getInvestMngRate() {
		return InvestMngRate;
	}
	public void setInvestMngRate(int investMngRate) {
		InvestMngRate = investMngRate;
	}
	public int getVipTerm() {
		return vipTerm;
	}
	public void setVipTerm(int vipTerm) {
		this.vipTerm = vipTerm;
	}
	@Override
	public String toString() {
		return "VIPSetSubEntity [vipAttest=" + vipAttest + ", vipInvest="
				+ vipInvest + ", BorrowMngRate=" + BorrowMngRate
				+ ", InvestMngRate=" + InvestMngRate + ", vipTerm=" + vipTerm
				+ "]";
	}	

}
