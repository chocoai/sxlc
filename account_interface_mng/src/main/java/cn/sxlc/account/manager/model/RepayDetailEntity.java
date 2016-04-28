package cn.sxlc.account.manager.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 钱多多  还款条款   实体
 * @author 张友
 *
 */
public class RepayDetailEntity {
	private long id;					//投资收益id
	private long iInvestId;			//投资id
	private long iMemberId;			//投资会员id
	private int iMemberType;		//投资会员类型
	private String sMark;			//投资会员多多标识
	private long lAmount;			//收益总金额
	private String sAmount;			//收益总金额
	private long lPrincipal;		//本金
	private String sPrincipal;		//本金
	private long lInterest;			//利息
	private String sInterest;		//利息
	private long lOverdue;			//总逾期费
	private String sOverdue;		//总逾期费
	private long lOverdueInterest;		//总的逾期利息
	private String sOverdueInterest="0.00";	//总的逾期利息
	private long lOverduePing;		//平台收取逾期费
	private String sOverduePing;	//平台收取逾期费
	
	private long lThisOverdue;		//本期新增逾期罚金
	private long lThisOdInterest;		//本期新增逾期利息
	
	private long lOverdueInvest;	//收取逾期费(投资人收取/担保方收取)
	private String sOverdueInvest;	//收取逾期费(投资人收取/担保方收取)
	
	private long lPenalty;			//违约金平台
	private String sPenalty;		//违约金平台
	
	private long lPenaltyInvest;			//违约金投资人
	private String sPenaltyInvest;		//违约金投资人
	
	
	private long lMngFee;			//投资管理费
	private String sMngFee;			//投资管理费
	private String sOrderNo;		//网贷平台订单号
	private String sDetail;			//还款信息详情		id + 'A' + 本金 + 'A' + 利息  + 'A' + 逾期费 + 'A' + 违约金 + 'A' + 投资管理费  + 'A' 
									//	+ statu + 'A' + memberid + 'A' + membertype + 'A' + 支付投资方/担保方逾期费 // + 'A' + 支付平台逾期费  + 'B'		statu 状态   1：逾期  0：提前
	private int iInOrOut;			//支出\收入	0：收入	1：支出
	private int remart;			//0:还给投资人，1：还给平台，2还给担保机构
	private long lMngFeeRate;			//投资管理费率
	private long investAmountValid;//有效投资金额；
	public int getiInOrOut() {
		return iInOrOut;
	}
	public void setiInOrOut(int iInOrOut) {
		this.iInOrOut = iInOrOut;
	}
	public String getsDetail() {
		return sDetail;
	}
	public long getlOverdueInvest() {
		return lOverdueInvest;
	}
	public void setlOverdueInvest(long lOverdueInvest) {
		this.lOverdueInvest = lOverdueInvest;
	}
	public String getsOverdueInvest() {
		return sOverdueInvest;
	}
	public void setsOverdueInvest(String sOverdueInvest) {
		this.sOverdueInvest = sOverdueInvest;
	}
	public long getlOverduePing() {
		return lOverduePing;
	}
	public void setlOverduePing(long lOverduePing) {
		this.lOverduePing = lOverduePing;
	}
	public String getsOverduePing() {
		return sOverduePing;
	}
	public void setsOverduePing(String sOverduePing) {
		this.sOverduePing = sOverduePing;
	}
	public long getiInvestId() {
		return iInvestId;
	}
	public void setiInvestId(long iInvestId) {
		this.iInvestId = iInvestId;
	}
	public void setsDetail(String sDetail) {
		this.sDetail = sDetail;
	}
	public String getsOrderNo() {
		return sOrderNo;
	}
	public void setsOrderNo(String sOrderNo) {
		this.sOrderNo = sOrderNo;
	}
	public long getlMngFee() {
		return lMngFee;
	}
	public void setlMngFee(long lMngFee) {
		this.lMngFee = lMngFee;
	}
	public String getsMngFee() {
		return sMngFee;
	}
	public void setsMngFee(String sMngFee) {
		this.sMngFee = sMngFee;
	}
	public long getlPrincipal() {
		return lPrincipal;
	}
	public void setlPrincipal(long lPrincipal) {
		this.lPrincipal = lPrincipal;
	}
	public String getsPrincipal() {
		return sPrincipal;
	}
	public void setsPrincipal(String sPrincipal) {
		this.sPrincipal = sPrincipal;
	}
	public long getlInterest() {
		return lInterest;
	}
	public void setlInterest(long lInterest) {
		this.lInterest = lInterest;
	}
	public String getsInterest() {
		return sInterest;
	}
	public void setsInterest(String sInterest) {
		this.sInterest = sInterest;
	}
	public long getlOverdue() {
		return lOverdue;
	}
	public void setlOverdue(long lOverdue) {
		this.lOverdue = lOverdue;
	}
	public String getsOverdue() {
		return sOverdue;
	}
	public void setsOverdue(String sOverdue) {
		this.sOverdue = sOverdue;
	}
	public long getlPenalty() {
		return lPenalty;
	}
	public void setlPenalty(long lPenalty) {
		this.lPenalty = lPenalty;
	}
	public String getsPenalty() {
		return sPenalty;
	}
	public void setsPenalty(String sPenalty) {
		this.sPenalty = sPenalty;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getiMemberId() {
		return iMemberId;
	}
	public void setiMemberId(long iMemberId) {
		this.iMemberId = iMemberId;
	}
	public int getiMemberType() {
		return iMemberType;
	}
	public void setiMemberType(int iMemberType) {
		this.iMemberType = iMemberType;
	}
	public String getsMark() {
		return sMark;
	}
	public void setsMark(String sMark) {
		this.sMark = sMark;
	}
	public long getlAmount() {
		return lAmount;
	}
	public void setlAmount(long lAmount) {
		this.lAmount = lAmount;
	}
	public String getsAmount() {
		return sAmount;
	}
	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}
	public void InitDate(){
		this.lAmount = 0;
		this.sAmount = "0.00";
		this.lPrincipal = 0;
		this.sPrincipal = "0.00";
		this.lInterest = 0;
		this.sInterest = "0.00";
		this.lOverdue = 0;
		this.sOverdue = "0.00";
		this.lPenalty = 0;
		this.sPenalty = "0.00";
		this.lMngFee = 0;
		this.sMngFee = "0.00";
	}
	public int getRemart() {
		return remart;
	}
	public void setRemart(int remart) {
		this.remart = remart;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
	}
	public long getlMngFeeRate() {
		return lMngFeeRate;
	}
	public void setlMngFeeRate(long lMngFeeRate) {
		this.lMngFeeRate = lMngFeeRate;
	}
	public long getlPenaltyInvest() {
		return lPenaltyInvest;
	}
	public void setlPenaltyInvest(long lPenaltyInvest) {
		this.lPenaltyInvest = lPenaltyInvest;
	}
	public String getsPenaltyInvest() {
		return sPenaltyInvest;
	}
	public void setsPenaltyInvest(String sPenaltyInvest) {
		this.sPenaltyInvest = sPenaltyInvest;
	}
	public long getlOverdueInterest() {
		return lOverdueInterest;
	}
	public void setlOverdueInterest(long lOverdueInterest) {
		this.lOverdueInterest = lOverdueInterest;
	}
	public String getsOverdueInterest() {
		return sOverdueInterest;
	}
	public void setsOverdueInterest(String sOverdueInterest) {
		this.sOverdueInterest = sOverdueInterest;
	}
	public long getlThisOverdue() {
		return lThisOverdue;
	}
	public void setlThisOverdue(long lThisOverdue) {
		this.lThisOverdue = lThisOverdue;
	}
	public long getlThisOdInterest() {
		return lThisOdInterest;
	}
	public void setlThisOdInterest(long lThisOdInterest) {
		this.lThisOdInterest = lThisOdInterest;
	}
	/**
	 * 计算逾期时间
	 * @param ttStart	起始时间
	 * @param ttEnd		结束时间
	 * @return		相差天数
	 */
	public static int GetDateSub(Timestamp ttStart,Timestamp ttEnd){
		int iResult = 0;
		if(ttStart == null || ttEnd == null){
			return iResult;
		}
		long lSub = (long)ttEnd.getTime() - (long)ttStart.getTime();
		long lDiv = lSub/(1000*60*60*24);
		long lMod = lSub%(1000*60*60*24);
		if(lMod>0){
			lDiv ++;
		}
		iResult = (int)lDiv;
		return iResult;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Timestamp GetCurrentDateTime(){
		Timestamp sResult = null;
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 sResult = Timestamp.valueOf(formatter.format(currentTime));
		// System.out.println(sResult);
		return sResult;
	}
	
	 /**
		 * 计算借款的逾期 费用
		 *@param iDays 		逾期天数
		 *@param lAmount    金额
		 *@param iYearRate		年化利率
		 *@param lResultInfo	逾期费详情	0：逾期利息	1：逾期罚金
		 *@param lRate 逾期利率
		 *@author 
		 *@return 逾期费用
		 */
		public static void GetYuqiAmount(long iDays,long lAmount,long iYearRate,long[] lResultInfo,long lRate){
			if(lAmount<=0 || iDays<=0 || iYearRate<=0 || lResultInfo == null || lResultInfo.length<2){
				return;
			}
			lResultInfo[0] = (iYearRate * lAmount* iDays)/(10000*365);
			lResultInfo[1] = (lRate * lAmount* iDays)/10000;
		}
}
