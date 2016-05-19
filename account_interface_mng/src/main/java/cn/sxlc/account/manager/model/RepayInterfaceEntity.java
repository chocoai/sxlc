package cn.sxlc.account.manager.model;

import java.util.List;

/**
 * 钱多多  还款 实体
 * @author 张友
 *
 */
public class RepayInterfaceEntity {
	private long id;
	private long iMemberId;			//还款会员id
	private int iMemberType;		//还款会员类型
	private String sMark;			//还款会员多多标识
	private long lAmount;			//还款总金额
	private String sAmount;			//还款总金额
	private long lPrincipal;		//本金
	private String sPrincipal;		//本金
	private long lInterest;			//利息
	private String sInterest;		//利息
	private long lOverdue;			//逾期费
	private String sOverdue;		//逾期费
	private int iOverDays;			//逾期天数
	private long lPenalty;			//违约金
	private String sPenalty;		//违约金
	private long lMngFee;			//投资管理费
	private String sMngFee;			//投资管理费
	private String sOrderNo;		//网贷平台标号
	private long lOverdueInterest;		//逾期利息
	private String sOverdueInterest;	//逾期利息
	
	private String remark1;//
	private String remark2;//
	private String remark3;//
	private List<RepayDetailEntity> detailList = null;		//还款明细
	public int getiOverDays() {
		return iOverDays;
	}
	public void setiOverDays(int iOverDays) {
		this.iOverDays = iOverDays;
	}
	public String getsOrderNo() {
		return sOrderNo;
	}
	public void setsOrderNo(String sOrderNo) {
		this.sOrderNo = sOrderNo;
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
	public List<RepayDetailEntity> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<RepayDetailEntity> detailList) {
		this.detailList = detailList;
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
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
}
