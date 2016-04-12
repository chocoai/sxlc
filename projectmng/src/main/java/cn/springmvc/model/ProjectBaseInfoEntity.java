package cn.springmvc.model;

import product_p2p.kit.datatrans.IntegerAndString;

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
	 * 最低年化利率(‰)
	 */
	private int minRate;
	/**
	 * 最高年化利率(‰)
	 */
	private int maxRate;
	/**
	 * 最小投资金额
	 */
	private int singleMin;	
	/**
	 * 最大投资比例 保留四位小数 0-1000000 0，1000000表示无限制
	 * （同一个会员投资总金额不能超过借款金额*最大投资比例）	
	 */
	private int investMax;
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
	}
	public long getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(long maxAmount) {
		this.maxAmount = maxAmount;
		
	}
	public int getMinRate() {
		return minRate;
	}
	public void setMinRate(int minRate) {
		this.minRate = minRate;
	}
	public int getMaxRate() {
		return maxRate;
	}
	public void setMaxRate(int maxRate) {
		this.maxRate = maxRate;
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
	
}
