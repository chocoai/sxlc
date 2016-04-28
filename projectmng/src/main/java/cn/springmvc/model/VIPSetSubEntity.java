package cn.springmvc.model;

import product_p2p.kit.datatrans.IntegerAndString;

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
	private String vipAttests; 
	/**
	 * 上个VIP截止日起累计有效投资N元 自动生成
	 */
	private long   vipInvest;
	private String vipInvests;
	
	/**
	 * VIP借款管理费折扣
	 */
	private int    BorrowMngRate;	
	private String BorrowMngRates;
	/**
	 * VIP投资管理费折扣
	 */
	private int    InvestMngRate;
	private String InvestMngRates;
	
	/**
	 * vip有效期限
	 */
	private int vipTerm;
	public int getVipAttest() {
		return vipAttest;
	}
	public void setVipAttest(int vipAttest) {
		this.vipAttest = vipAttest;
		this.vipAttests = IntegerAndString.IntToString(vipAttest);
	}
	public long getVipInvest() {
		return vipInvest;
	}
	public void setVipInvest(long vipInvest) {
		this.vipInvest = vipInvest;
		this.vipInvests = IntegerAndString.LongToString(vipInvest);
	}
	public int getBorrowMngRate() {
		return BorrowMngRate;
	}
	public void setBorrowMngRate(int borrowMngRate) {
		BorrowMngRate = borrowMngRate;
		BorrowMngRates = IntegerAndString.IntToString(borrowMngRate);
	}
	public int getInvestMngRate() {
		return InvestMngRate;
	}
	public void setInvestMngRate(int investMngRate) {
		InvestMngRate = investMngRate;
		InvestMngRates = IntegerAndString.IntToString(investMngRate);
	}
	public int getVipTerm() {
		return vipTerm;
	}
	public void setVipTerm(int vipTerm) {
		this.vipTerm = vipTerm;
	}
	public String getBorrowMngRates() {
		return BorrowMngRates;
	}
	public void setBorrowMngRates(String borrowMngRates) {
		BorrowMngRates = borrowMngRates;
	}
	public String getInvestMngRates() {
		return InvestMngRates;
	}
	public void setInvestMngRates(String investMngRates) {
		InvestMngRates = investMngRates;
	}
	public String getVipAttests() {
		return vipAttests;
	}
	public void setVipAttests(String vipAttests) {
		this.vipAttests = vipAttests;
	}
	public String getVipInvests() {
		return vipInvests;
	}
	public void setVipInvests(String vipInvests) {
		this.vipInvests = vipInvests;
	}
	@Override
	public String toString() {
		return "VIPSetSubEntity [vipAttest=" + vipAttest + ", vipInvest="
				+ vipInvest + ", BorrowMngRate=" + BorrowMngRate
				+ ", InvestMngRate=" + InvestMngRate + ", vipTerm=" + vipTerm
				+ "]";
	}	

}
