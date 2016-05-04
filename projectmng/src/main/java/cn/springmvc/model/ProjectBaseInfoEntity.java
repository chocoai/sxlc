package cn.springmvc.model;

import product_p2p.kit.datatrans.IntegerAndString;
 
/**
 * 项目类型实体
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-22 下午2:08:04
 */
public class ProjectBaseInfoEntity {
	/**
	 * 项目类型id
	 */
	private long id	;
	/**
	 * 项目名称 例如：信用贷 银行贷款等	
	 */
	private String projectName;
	/**
	 * 最低借款金额
	 */
	private long minAmount	; 
	/**
	 * 最高借款金额 0：表示无上限
	 */
	private long maxAmount; 
	/**
	 * 最低借款金额
	 */
	private String minAmounts; 
	/**
	 * 最高借款金额 0：表示无上限
	 */
	private String maxAmounts; 
	/**
	 * 最低年化利率(‰)
	 */
	private int minRate;
	private String minRates;
	/**
	 * 最高年化利率(‰)
	 */
	private int maxRate;
	private String maxRates;
	/**
	 * 最小投资金额
	 */
	private int singleMin;	
	/**
	 * 最大投资比例 保留四位小数 0-1000000 0，1000000表示无限制
	 * （同一个会员投资总金额不能超过借款金额*最大投资比例）	
	 */
	private int investMax;
	private String investMaxs;
	
	/**
	 * 起投金额
	 */
	private int minStart;
	/**
	 * 项目类型简介	
	 */
	private String briefIntroduction;
	/**
	 * 申请会员限制 0：无限制 1：个人会员 2：企业会员	
	 */
	private int applyMember;
	/**
	 * 展示图片
	 */
	private String picUrl;	
	/**
	 * 显示小图标
	 */
	private String picIcon	;	
	/**
	 * 是否需要抵押 0：否 1：是	
	 */
	private int isMortgage;
	/**
	 * 状态 0：停用 1：启用
	 */
	private int statu; 
	private String contentR;//还款指南
	private String contentG;//借款指南
	private int tminDaytime;//天标最小借款时间
	private int tmaxDaytime;//天标最大借款时间
	private int mminDaytime;//月标最小借款时间
	private int mmaxDaytime;//月标最大借款时间
	private int yminDaytime;//年标最小借款时间
	private int ymaxDaytime;//年标最大借款时间
	private String typeString;
	 
	public int getTminDaytime() {
		return tminDaytime;
	}
	public void setTminDaytime(int tminDaytime) {
		this.tminDaytime = tminDaytime;
	}
	public int getTmaxDaytime() {
		return tmaxDaytime;
	}
	public void setTmaxDaytime(int tmaxDaytime) {
		this.tmaxDaytime = tmaxDaytime;
	}
	public int getMminDaytime() {
		return mminDaytime;
	}
	public void setMminDaytime(int mminDaytime) {
		this.mminDaytime = mminDaytime;
	}
	public int getMmaxDaytime() {
		return mmaxDaytime;
	}
	public void setMmaxDaytime(int mmaxDaytime) {
		this.mmaxDaytime = mmaxDaytime;
	}
	public int getYminDaytime() {
		return yminDaytime;
	}
	public void setYminDaytime(int yminDaytime) {
		this.yminDaytime = yminDaytime;
	}
	public int getYmaxDaytime() {
		return ymaxDaytime;
	}
	public void setYmaxDaytime(int ymaxDaytime) {
		this.ymaxDaytime = ymaxDaytime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public long getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(long minAmount) {
		this.minAmount = minAmount;
		this.minAmounts = IntegerAndString.LongToString(minAmount);
	}
	public long getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(long maxAmount) {
		this.maxAmount = maxAmount;
		this.maxAmounts = IntegerAndString.LongToString(maxAmount);
		
	}
	public int getMinRate() {
		return minRate;
	}
	public void setMinRate(int minRate) {
		this.minRate = minRate; 
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.minRates = myformat.format(Double.valueOf(IntegerAndString.IntToString(minRate)));
	}
	public int getMaxRate() {
		return maxRate;
	}
	public void setMaxRate(int maxRate) {
		this.maxRate = maxRate;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.maxRates = myformat.format(Double.valueOf(IntegerAndString.IntToString(maxRate)));
	}
	public int getSingleMin() {
		return singleMin;
	}
	public void setSingleMin(int singleMin) {
		this.singleMin = singleMin;
	}
	public int getInvestMax() {
		return investMax;
	}
	public void setInvestMax(int investMax) {
		this.investMax = investMax;
		this.investMaxs = IntegerAndString.IntToString(investMax);
	}
	public int getMinStart() {
		return minStart;
	}
	public void setMinStart(int minStart) {
		this.minStart = minStart; 
	}
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	public int getApplyMember() {
		return applyMember;
	}
	public void setApplyMember(int applyMember) {
		this.applyMember = applyMember;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPicIcon() {
		return picIcon;
	}
	public void setPicIcon(String picIcon) {
		this.picIcon = picIcon;
	} 
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getIsMortgage() {
		return isMortgage;
	}
	public void setIsMortgage(int isMortgage) {
		this.isMortgage = isMortgage;
	}
	public String getMinRates() {
		return minRates;
	}
	public void setMinRates(String minRates) {
		this.minRates = minRates;
	}
	public String getMaxRates() {
		return maxRates;
	}
	public void setMaxRates(String maxRates) {
		this.maxRates = maxRates;
	}
	public String getInvestMaxs() {
		return investMaxs;
	}
	public void setInvestMaxs(String investMaxs) {
		this.investMaxs = investMaxs;
	} 
	public String getContentG() {
		return contentG;
	}
	public void setContentG(String contentG) {
		this.contentG = contentG;
	}
	public String getContentR() {
		return contentR;
	}
	public void setContentR(String contentR) {
		this.contentR = contentR;
	}
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
//		StringBuffer detail = new StringBuffer();
//		detail.append("天标："+tminDaytime+"~"+tmaxDaytime+"天");
//		detail.append("月标："+mminDaytime+"~"+mmaxDaytime+"月");
//		detail.append("年标："+mminDaytime+"~"+mmaxDaytime+"年");
		this.typeString = typeString;
	}
	@Override
	public String toString() {
		return "ProjectBaseInfoEntity [id=" + id + ", projectName="
				+ projectName + ", minAmount=" + minAmount + ", maxAmount="
				+ maxAmount + ", minRate=" + minRate + ", minRates=" + minRates
				+ ", maxRate=" + maxRate + ", maxRates=" + maxRates
				+ ", singleMin=" + singleMin + ", investMax=" + investMax
				+ ", investMaxs=" + investMaxs + ", minStart=" + minStart
				+ ", briefIntroduction=" + briefIntroduction + ", applyMember="
				+ applyMember + ", picUrl=" + picUrl + ", picIcon=" + picIcon
				+ ", isMortgage=" + isMortgage + ", statu=" + statu
				+ ", contentR=" + contentR + ", contentG=" + contentG
				+ ", tminDaytime=" + tminDaytime + ", tmaxDaytime="
				+ tmaxDaytime + ", mminDaytime=" + mminDaytime
				+ ", mmaxDaytime=" + mmaxDaytime + ", yminDaytime="
				+ yminDaytime + ", ymaxDaytime=" + ymaxDaytime
				+ ", typeString=" + typeString + "]";
	}
	public String getMaxAmounts() {
		return maxAmounts;
	}
	public void setMaxAmounts(String maxAmounts) {
		this.maxAmounts = maxAmounts;
	}
	public String getMinAmounts() {
		return minAmounts;
	}
	public void setMinAmounts(String minAmounts) {
		this.minAmounts = minAmounts;
	}
	
	
}
