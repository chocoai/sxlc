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
	private int    borrowMngRate;	
	private String borrowMngRates;
	/**
	 * VIP投资管理费折扣
	 */
	private int    investMngRate;
	private String investMngRates;
	
	/**
	 * vip有效期限
	 */
	private int vipTerm;

	public int getVipAttest() {
		return vipAttest;
	}

	public void setVipAttest(int vipAttest) {
		this.vipAttest = vipAttest;
		this.vipAttests =IntegerAndString.IntToString(vipAttest);
	}

	public String getVipAttests() {
		return vipAttests;
	}

	public long getVipInvest() {
		return vipInvest;
	}

	public void setVipInvest(long vipInvest) {
		this.vipInvest = vipInvest;
		this.vipInvests = IntegerAndString.LongToString(vipInvest);
	}

	public String getVipInvests() {
		return vipInvests;
	}

	public int getBorrowMngRate() {
		return borrowMngRate;
	}

	public void setBorrowMngRate(int borrowMngRate) {
		this.borrowMngRate = borrowMngRate;
		this.borrowMngRates = IntegerAndString.IntToString(borrowMngRate);
	}

	public String getBorrowMngRates() {
		return borrowMngRates;
	}

	public int getInvestMngRate() {
		return investMngRate;
	}

	public void setInvestMngRate(int investMngRate) {
		this.investMngRate = investMngRate;
		this.investMngRates = IntegerAndString.IntToString(investMngRate);
	}

	public String getinvestMngRates() {
		return investMngRates;
	}


	public int getVipTerm() {
		return vipTerm;
	}

	public void setVipTerm(int vipTerm) {
		this.vipTerm = vipTerm;
	}
	
}
