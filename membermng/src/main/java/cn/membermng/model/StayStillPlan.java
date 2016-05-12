package cn.membermng.model; 

import java.sql.Timestamp;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;


/***
* 还款管理 待还计划 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-5 下午4:12:10 
*
*/

public class StayStillPlan {

	
	private long			lrId;						//还款计划编号
	private int				index;						//期数
	private long			sdRepayPrincipal;			//应还本金
	private String			sSDRepayPrincipal;			//
	private long			sdRepayInterest;			//应还利息
	private String			sSDRepayInterest;			//
	private String			repayMaxTime;				//还款日
	private int				statu;						//还款状态
	private String			statuName;					//还款状态名称
	private long			repayOverdueInterest;		//逾期利息
	private String			sRepayOverdueInterest;		//
	private long			repayOverdue;				//逾期罚金
	private String			sRepayOverdue;				//
	private int				isCompensatory;				//是否代偿 0是  1否
	private long			repayPrincipal;				//已还本金
	private String			sRepayPrincipal;			//
	private long			repayInterest;				//已还利息
	private String			sRepayInterest;				//
	private long			yiHuanYuQiLiXi;				//已还逾期利息
	private String			sYiHuanYuQiLiXi;			//
	private long			yiHuanYuQiFaJin;			//已还逾期罚金
	private String			sYiHuanYuQiFaJin;			//
	private String			projectName;				//项目名称
	
	
	public StayStillPlan() {}


	public StayStillPlan(long lrId, long sdRepayPrincipal,
			String sSDRepayPrincipal, long sdRepayInterest,
			String sSDRepayInterest, String repayMaxTime, int statu,
			long repayOverdueInterest, String sRepayOverdueInterest,
			long repayOverdue, String sRepayOverdue, int isCompensatory,
			long repayPrincipal, String sRepayPrincipal, long repayInterest,
			String sRepayInterest, long yiHuanYuQiLiXi, String sYiHuanYuQiLiXi,
			long yiHuanYuQiFaJin, String sYiHuanYuQiFaJin, String projectName) {
		super();
		this.lrId = lrId;
		this.sdRepayPrincipal = sdRepayPrincipal;
		this.sSDRepayPrincipal = sSDRepayPrincipal;
		this.sdRepayInterest = sdRepayInterest;
		this.sSDRepayInterest = sSDRepayInterest;
		this.repayMaxTime = repayMaxTime;
		this.statu = statu;
		this.repayOverdueInterest = repayOverdueInterest;
		this.sRepayOverdueInterest = sRepayOverdueInterest;
		this.repayOverdue = repayOverdue;
		this.sRepayOverdue = sRepayOverdue;
		this.isCompensatory = isCompensatory;
		this.repayPrincipal = repayPrincipal;
		this.sRepayPrincipal = sRepayPrincipal;
		this.repayInterest = repayInterest;
		this.sRepayInterest = sRepayInterest;
		this.yiHuanYuQiLiXi = yiHuanYuQiLiXi;
		this.sYiHuanYuQiLiXi = sYiHuanYuQiLiXi;
		this.yiHuanYuQiFaJin = yiHuanYuQiFaJin;
		this.sYiHuanYuQiFaJin = sYiHuanYuQiFaJin;
		this.projectName = projectName;
	}

	
	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}
	
	public String getStatuName() {
		return statuName;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public long getLrId() {
		return lrId;
	}


	public void setLrId(long lrId) {
		this.lrId = lrId;
	}

	
	
	public long getSdRepayPrincipal() {
		return sdRepayPrincipal;
	}


	public void setSdRepayPrincipal(long sdRepayPrincipal) {
		this.sdRepayPrincipal = sdRepayPrincipal;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sSDRepayPrincipal =  myformat.format(Double.valueOf(IntegerAndString.LongToString(sdRepayPrincipal)));   
	}


	public String getsSDRepayPrincipal() {
		return sSDRepayPrincipal;
	}


	public void setsSDRepayPrincipal(String sSDRepayPrincipal) {
		this.sSDRepayPrincipal = sSDRepayPrincipal;
	}


	public long getSdRepayInterest() {
		return sdRepayInterest;
	}


	public void setSdRepayInterest(long sdRepayInterest) {
		this.sdRepayInterest = sdRepayInterest;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sSDRepayInterest =  myformat.format(Double.valueOf(IntegerAndString.LongToString(sdRepayInterest)));  
	}


	public String getsSDRepayInterest() {
		return sSDRepayInterest;
	}


	public void setsSDRepayInterest(String sSDRepayInterest) {
		this.sSDRepayInterest = sSDRepayInterest;
	}


	public String getRepayMaxTime() {
		return repayMaxTime;
	}


	public void setRepayMaxTime(String repayMaxTime) {
		this.repayMaxTime = TimestampAndString.TimestampToString2(Timestamp.valueOf(repayMaxTime));
	}


	public int getStatu() {
		return statu;
	}


	public void setStatu(int statu) {
		this.statu = statu;
	}


	public long getRepayOverdueInterest() {
		return repayOverdueInterest;
	}


	public void setRepayOverdueInterest(long repayOverdueInterest) {
		this.repayOverdueInterest = repayOverdueInterest;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sRepayOverdueInterest =  myformat.format(Double.valueOf(IntegerAndString.LongToString(repayOverdueInterest)));  
 
	}


	public String getsRepayOverdueInterest() {
		return sRepayOverdueInterest;
	}


	public void setsRepayOverdueInterest(String sRepayOverdueInterest) {
		this.sRepayOverdueInterest = sRepayOverdueInterest;
	}


	public long getRepayOverdue() {
		return repayOverdue;
	}


	public void setRepayOverdue(long repayOverdue) {
		this.repayOverdue = repayOverdue;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sRepayOverdue =  myformat.format(Double.valueOf(IntegerAndString.LongToString(repayOverdue)));  
  
	}


	public String getsRepayOverdue() {
		return sRepayOverdue;
	}


	public void setsRepayOverdue(String sRepayOverdue) {
		this.sRepayOverdue = sRepayOverdue;
	}


	public long getIsCompensatory() {
		return isCompensatory;
	}


	public void setIsCompensatory(int isCompensatory) {
		this.isCompensatory = isCompensatory;
	}


	public long getRepayPrincipal() {
		return repayPrincipal;
	}


	public void setRepayPrincipal(long repayPrincipal) {
		this.repayPrincipal = repayPrincipal;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sRepayPrincipal =  myformat.format(Double.valueOf(IntegerAndString.LongToString(repayPrincipal)));   
 
	}


	public String getsRepayPrincipal() {
		return sRepayPrincipal;
	}


	public void setsRepayPrincipal(String sRepayPrincipal) {
		this.sRepayPrincipal = sRepayPrincipal;
	}


	public long getRepayInterest() {
		return repayInterest;
	}


	public void setRepayInterest(long repayInterest) {
		this.repayInterest = repayInterest;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sRepayInterest =  myformat.format(Double.valueOf(IntegerAndString.LongToString(repayInterest)));    
	}


	public String getsRepayInterest() {
		return sRepayInterest;
	}


	public void setsRepayInterest(String sRepayInterest) {
		this.sRepayInterest = sRepayInterest;
	}


	public long getYiHuanYuQiLiXi() {
		return yiHuanYuQiLiXi;
	}


	public void setYiHuanYuQiLiXi(long yiHuanYuQiLiXi) {
		this.yiHuanYuQiLiXi = yiHuanYuQiLiXi;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sYiHuanYuQiLiXi =  myformat.format(Double.valueOf(IntegerAndString.LongToString(yiHuanYuQiLiXi)));    
 
	}


	public String getsYiHuanYuQiLiXi() {
		return sYiHuanYuQiLiXi;
	}


	public void setsYiHuanYuQiLiXi(String sYiHuanYuQiLiXi) {
		this.sYiHuanYuQiLiXi = sYiHuanYuQiLiXi;
	}


	public long getYiHuanYuQiFaJin() {
		return yiHuanYuQiFaJin;
	}


	public void setYiHuanYuQiFaJin(long yiHuanYuQiFaJin) {
		this.yiHuanYuQiFaJin = yiHuanYuQiFaJin;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.sYiHuanYuQiFaJin =  myformat.format(Double.valueOf(IntegerAndString.LongToString(yiHuanYuQiFaJin)));    
  
	}


	public String getsYiHuanYuQiFaJin() {
		return sYiHuanYuQiFaJin;
	}


	public void setsYiHuanYuQiFaJin(String sYiHuanYuQiFaJin) {
		this.sYiHuanYuQiFaJin = sYiHuanYuQiFaJin;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
	
	
	
	
}

