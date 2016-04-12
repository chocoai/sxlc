

/** 
* @Title: MemberTradingRecordsEntity.java 
* @Package cn.capitalbudgetdetails.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午1:47:16 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description:会员交易记录实体 
 * @since 
 * @date 2016-3-30 下午1:47:16  */

public class MemberTradingRecordsEntity {
	private long tradeID;
	/**
	 * 会员类型 0：会员 1：担保机构 2：平台	
	 */
	private int memberType; 
	/**
	 * 会员ID
	 */
	private long memberID; 
	/**
	 * 交易类型 0：其他 1：充值 2：提现成功 3：冻结借款项目投标金额 4：扣除借款项目投标金额 5：冻结债权转让投标金额 6：扣除债权转让投标金额 
	 * 7：借款项目放款 8：债权转让放款 9：借款人还款 10：获得投资收益 11：投资借款项目流标 12：投资债权转让流标 13：支付担保收益 14：代偿还款 
	 * 15：积分兑换 16：获取担保收益 
	 * 17：代偿回款 18：提现登记 19：提现打回 20：支付借款管理费 21：支付风险备付金 23：代偿还款 24：代偿回款 25：支付项目认证费用
	 */
	private int tradeTypeId; 
	/**
	 * 交易类型
	 */
	private String tradeType; 	
	/**
	 * 项目ID 相关项目ID	
	 */
	private long projectID; 
	/**
	 * 描述
	 */
	private String abstracts; 
	/**
	 *  是否为收入 -1:支出 1：收入	
	 */
	private int getPay;
	/**
	 * varbinary(180)BIGINT 有效交易金额  包含平台管理费 第三方管理费	
	 */
	private long amount;
	/**
	 * varbinary(180)BIGINT 有效交易金额  包含平台管理费 第三方管理费	
	 */
	private String amounts;
	/**
	 * varbinary(120)平台管理费
	 */
	private int mngFee; 
	/**
	 * varbinary(120)平台管理费
	 */
	private String mngFees; 
	/**
	 * varbinary(120)INT 	第三方管理费	
	 */
	private int thirdMngFee;
	/**
	 * varbinary(120)INT 	第三方管理费	
	 */
	private String thirdMngFees;
	/**
	 * varbinary(120)INT 使用赠送金额：代金券
	 */
	private int giftAmount;	
	/**
	 * varbinary(120)INT 使用赠送金额：红包	
	 */
	private int redpacketsAmount;	
	/**
	 * 记录时间	
	 */
	private String recordDate;
	/**
	 *  交易编号	
	 */
	private String recordNo;
	/**
	 * 商户订单号	
	 */
	private String merBillNo;
	/**
	 * varbinary(180)BIGINT  统计交易金额 （计算账户余额使用 支出为负数 收入为正数 只冻结不支付时为0）
	 */
	private long statisticsAmount;
	/**
	 * varbinary(180)BIGINT  统计交易金额 （计算账户余额使用 支出为负数 收入为正数 只冻结不支付时为0）
	 */
	private String statisticsAmounts;
	/**
	 * varbinary(180)BIGINT  统计冻结交易金额 （计算账户余额使用 支出为负数 收入为正数 直接交易不冻结时为0）	
	 */
	private long statisticsFrozenAmount;
	/**
	 * varbinary(180)BIGINT  统计冻结交易金额 （计算账户余额使用 支出为负数 收入为正数 直接交易不冻结时为0）	
	 */
	private String statisticsFrozenAmounts;
	/**
	 *  统计代金券交易金额 （计算账户余额使用 支出为负数 收入为正数 只冻结不支付时为0）	
	 */
	private long statisticsGiftAmount;
	/**
	 *  统计代金券交易金额 （计算账户余额使用 支出为负数 收入为正数 只冻结不支付时为0）	
	 */
	private String statisticsGiftAmounts;
	/**
	 * varbinary(180)BIGINT 统计代金券冻结交易金额 （计算账户余额使用 支出为负数 收入为正数 直接交易不冻结时为0）
	 */
	private long statisticsGiftFrozenAmount;
	/**
	 * varbinary(180)BIGINT 统计代金券冻结交易金额 （计算账户余额使用 支出为负数 收入为正数 直接交易不冻结时为0）
	 */
	private String statisticsGiftFrozenAmounts;
	/**
	 * 余额处理状态 0：未处理 1：已经处理
	 */
	private int dealStatu;
	/**
	 * 处理时间	
	 */
	private String dealDate;	
	/**
	 * 账户信息处理状态 0：未处理 1：已经处理	
	 */
	private int accountDealStatu;
	/**
	 * 交易对方类型 0：平台 1：会员 2：担保机构会员	
	 */
	private int tradeObjectType;
	/**
	 * 交易对方id	
	 */
	private long tradeObjectId;
	/**
	 * 记录状态 0：无效 1：有效
	 */
	private int statu;
	/**
	 * 待收本金(分)
	 */
	private long willRecPrincipal;	
	/**
	 * 待收本金(分)
	 */
	private String willRecPrincipals;	
	/**
	 * 待收利息(分)
	 */
	private long willRecInterest; 
	/**
	 * 待收利息(分)
	 */
	private String willRecInterests; 
	/**
	 * 待还本金(分)
	 */
	private long willPayPrincipal;	
	/**
	 * 待还本金(分)
	 */
	private String willPayPrincipals;	
	/**
	 * 待还利息(分)
	 */
	private long willPayInterest; 	
	/**
	 * 待还利息(分)
	 */
	private String willPayInterests; 	
	/**
	 * 待还逾期利息(分)
	 */
	private long willPayOverdueInterest; 
	/**
	 * 待还逾期利息(分)
	 */
	private String willPayOverdueInterests; 
	/**
	 * 待还逾期罚金(分)	
	 */
	private long willPayOverdue; 
	/**
	 * 待还逾期罚金(分)	
	 */
	private String willPayOverdues; 
	/**
	 * 账户可用余额(分)
	 */
	private  long userBalance;
	/**
	 * 账户可用余额(分)
	 */
	private  String userBalances;
	/**
	 * 账户冻结金额
	 */
	private  long frozenBalance ;
	/**
	 * 账户冻结金额
	 */
	private  String frozenBalances ;
	/**
	 * 账户可用赠送余额 代金券
	 */
	private  long userGift	;
	/**
	 * 账户可用赠送余额 代金券
	 */
	private  String userGifts	;
	/**
	 * 账户冻结赠送金额 代金券
	 */
	private  long frozenGift;
	/**
	 * 账户冻结赠送金额 代金券
	 */
	private  String frozenGifts;
	/**
	 * 会员用户名
	 */
	private  String membername;
	/**
	 * 市区名
	 */
	private String cityName;
	/**
	 * 省名
	 */
	private String provinceName;
	/**
	 * 总金额
	 */
	private long totalAmount;
	/**
	 * 总金额
	 */
	private String totalAmounts;
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		this.totalAmounts= IntegerAndString.LongToString(totalAmount);
	}
	public String getTotalAmounts() {
		return totalAmounts;
	}
	public void setTotalAmounts(String totalAmounts) {
		this.totalAmounts = totalAmounts;
	}
	public long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(long userBalance) {
		this.userBalance = userBalance;
		this.userBalances= IntegerAndString.LongToString(userBalance);
	}
	public String getUserBalances() {
		return userBalances;
	}
	public void setUserBalances(String userBalances) {
		this.userBalances = userBalances;
	}
	public long getFrozenBalance() {
		return frozenBalance;
	}
	public void setFrozenBalance(long frozenBalance) {
		this.frozenBalance = frozenBalance;
		this.frozenBalances= IntegerAndString.LongToString(frozenBalance);
	}
	public String getFrozenBalances() {
		return frozenBalances;
	}
	public void setFrozenBalances(String frozenBalances) {
		this.frozenBalances = frozenBalances;
	}
	public long getUserGift() {
		return userGift;
	}
	public void setUserGift(long userGift) {
		this.userGift = userGift;
		this.userGifts= IntegerAndString.LongToString(userGift);
	}
	public String getUserGifts() {
		return userGifts;
	}
	public void setUserGifts(String userGifts) {
		this.userGifts = userGifts;
	}
	public long getFrozenGift() {
		return frozenGift;
	}
	public void setFrozenGift(long frozenGift) {
		this.frozenGift = frozenGift;
		this.frozenGifts= IntegerAndString.LongToString(frozenGift);
	}
	public String getFrozenGifts() {
		return frozenGifts;
	}
	public void setFrozenGifts(String frozenGifts) {
		this.frozenGifts = frozenGifts;
	}
	public long getWillRecPrincipal() {
		return willRecPrincipal;
	}
	public void setWillRecPrincipal(long willRecPrincipal) {
		this.willRecPrincipal = willRecPrincipal;
		this.willRecPrincipals= IntegerAndString.LongToString(willRecPrincipal);
	}
	public String getWillRecPrincipals() {
		return willRecPrincipals;
	}
	public void setWillRecPrincipals(String willRecPrincipals) {
		this.willRecPrincipals = willRecPrincipals;
	}
	public long getWillRecInterest() {
		return willRecInterest;
	}
	public void setWillRecInterest(long willRecInterest) {
		this.willRecInterest = willRecInterest;
		this.willRecInterests= IntegerAndString.LongToString(willRecInterest);
	}
	public String getWillRecInterests() {
		return willRecInterests;
	}
	public void setWillRecInterests(String willRecInterests) {
		this.willRecInterests = willRecInterests;
	}
	public long getWillPayPrincipal() {
		return willPayPrincipal;
	}
	public void setWillPayPrincipal(long willPayPrincipal) {
		this.willPayPrincipal = willPayPrincipal;
		this.willPayPrincipals= IntegerAndString.LongToString(willPayPrincipal);
	}
	public String getWillPayPrincipals() {
		return willPayPrincipals;
	}
	public void setWillPayPrincipals(String willPayPrincipals) {
		this.willPayPrincipals = willPayPrincipals;
	}
	public long getWillPayInterest() {
		return willPayInterest;
	}
	public void setWillPayInterest(long willPayInterest) {
		this.willPayInterest = willPayInterest;
		this.willPayInterests= IntegerAndString.LongToString(willPayInterest);
	}
	public String getWillPayInterests() {
		return willPayInterests;
	}
	public void setWillPayInterests(String willPayInterests) {
		this.willPayInterests = willPayInterests;
	}
	public long getWillPayOverdueInterest() {
		return willPayOverdueInterest;
	}
	public void setWillPayOverdueInterest(long willPayOverdueInterest) {
		this.willPayOverdueInterest = willPayOverdueInterest;
		this.willPayOverdueInterests= IntegerAndString.LongToString(willPayOverdueInterest);
	}
	public String getWillPayOverdueInterests() {
		return willPayOverdueInterests;
	}
	public void setWillPayOverdueInterests(String willPayOverdueInterests) {
		this.willPayOverdueInterests = willPayOverdueInterests;
	}
	public long getWillPayOverdue() {
		return willPayOverdue;
	}
	public void setWillPayOverdue(long willPayOverdue) {
		this.willPayOverdue = willPayOverdue;
		this.willPayOverdues= IntegerAndString.LongToString(willPayOverdue);
	}
	public String getWillPayOverdues() {
		return willPayOverdues;
	}
	public void setWillPayOverdues(String willPayOverdues) {
		this.willPayOverdues = willPayOverdues;
	}
	public long getTradeID() {
		return tradeID;
	}
	public void setTradeID(long tradeID) {
		this.tradeID = tradeID;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public int getTradeTypeId() {
		return tradeTypeId;
	}
	public void setTradeTypeId(int tradeTypeId) {
		this.tradeTypeId = tradeTypeId;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public int getGetPay() {
		return getPay;
	}
	public void setGetPay(int getPay) {
		this.getPay = getPay;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
		this.amounts= IntegerAndString.LongToString(amount);
	}
	public String getAmounts() {
		return amounts;
	}
	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}
	public int getMngFee() {
		return mngFee;
	}
	public void setMngFee(int mngFee) {
		this.mngFee = mngFee;
		this.mngFees= IntegerAndString.IntToString(mngFee);
	}
	public String getMngFees() {
		return mngFees;
	}
	public void setMngFees(String mngFees) {
		this.mngFees = mngFees;
	}
	public int getThirdMngFee() {
		return thirdMngFee;
	}
	public void setThirdMngFee(int thirdMngFee) {
		this.thirdMngFee = thirdMngFee;
		this.thirdMngFees= IntegerAndString.IntToString(thirdMngFee);
	}
	public String getThirdMngFees() {
		return thirdMngFees;
	}
	public void setThirdMngFees(String thirdMngFees) {
		this.thirdMngFees = thirdMngFees;
	}
	public int getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(int giftAmount) {
		this.giftAmount = giftAmount; 
	}
	public int getRedpacketsAmount() {
		return redpacketsAmount;
	}
	public void setRedpacketsAmount(int redpacketsAmount) {
		this.redpacketsAmount = redpacketsAmount;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	public String getMerBillNo() {
		return merBillNo;
	}
	public void setMerBillNo(String merBillNo) {
		this.merBillNo = merBillNo;
	}
	public long getStatisticsAmount() {
		return statisticsAmount;
	}
	public void setStatisticsAmount(long statisticsAmount) {
		this.statisticsAmount = statisticsAmount;
		this.statisticsAmounts= IntegerAndString.LongToString(statisticsAmount);
	}
	public String getStatisticsAmounts() {
		return statisticsAmounts;
	}
	public void setStatisticsAmounts(String statisticsAmounts) {
		this.statisticsAmounts = statisticsAmounts;
	}
	public long getStatisticsFrozenAmount() {
		return statisticsFrozenAmount;
	}
	public void setStatisticsFrozenAmount(long statisticsFrozenAmount) {
		this.statisticsFrozenAmount = statisticsFrozenAmount;
		this.statisticsFrozenAmounts= IntegerAndString.LongToString(statisticsFrozenAmount);
	}
	public String getStatisticsFrozenAmounts() {
		return statisticsFrozenAmounts;
	}
	public void setStatisticsFrozenAmounts(String statisticsFrozenAmounts) {
		this.statisticsFrozenAmounts = statisticsFrozenAmounts;
	}
	public long getStatisticsGiftAmount() {
		return statisticsGiftAmount;
	}
	public void setStatisticsGiftAmount(long statisticsGiftAmount) {
		this.statisticsGiftAmount = statisticsGiftAmount;
		this.statisticsGiftAmounts= IntegerAndString.LongToString(statisticsGiftAmount);
	}
	public String getStatisticsGiftAmounts() {
		return statisticsGiftAmounts;
	}
	public void setStatisticsGiftAmounts(String statisticsGiftAmounts) {
		this.statisticsGiftAmounts = statisticsGiftAmounts;
	}
	public long getStatisticsGiftFrozenAmount() {
		return statisticsGiftFrozenAmount;
	}
	public void setStatisticsGiftFrozenAmount(long statisticsGiftFrozenAmount) {
		this.statisticsGiftFrozenAmount = statisticsGiftFrozenAmount;
		this.statisticsGiftFrozenAmounts= IntegerAndString.LongToString(statisticsGiftFrozenAmount);
	}
	public String getStatisticsGiftFrozenAmounts() {
		return statisticsGiftFrozenAmounts;
	}
	public void setStatisticsGiftFrozenAmounts(String statisticsGiftFrozenAmounts) {
		this.statisticsGiftFrozenAmounts = statisticsGiftFrozenAmounts;
	}
	public int getDealStatu() {
		return dealStatu;
	}
	public void setDealStatu(int dealStatu) {
		this.dealStatu = dealStatu;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public int getAccountDealStatu() {
		return accountDealStatu;
	}
	public void setAccountDealStatu(int accountDealStatu) {
		this.accountDealStatu = accountDealStatu;
	}
	public int getTradeObjectType() {
		return tradeObjectType;
	}
	public void setTradeObjectType(int tradeObjectType) {
		this.tradeObjectType = tradeObjectType;
	}
	public long getTradeObjectId() {
		return tradeObjectId;
	}
	public void setTradeObjectId(long tradeObjectId) {
		this.tradeObjectId = tradeObjectId;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}  	

}

