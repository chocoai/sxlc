
package cn.springmvc.model; 

import java.util.Date;

/**
 * 计算预计收益 债权转让基本信息
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-5-9 下午8:54:54
 */
public class CreditorTransBaseEntity {
	private long lId;				//债权转让申请ID
	private short sSurplus;			//剩余期限
	private int iSurplusType;		//剩余期限类型	0：天标 1：月标 2：年标
	private short sSubSurplus;		//二级剩余期限
	private Date ttEndDate;	//项目到期时间
	private short sRepayWay;		//还款方式		0：等额本息，1：每月还息，到期还本 2：到期还息本 3:等额本金
	private int iYearRate;			//年化利率
	public long getlId() {
		return lId;
	}
	public void setlId(long lId) {
		this.lId = lId;
	}
	public short getsSurplus() {
		return sSurplus;
	}
	public void setsSurplus(short sSurplus) {
		this.sSurplus = sSurplus;
	}
	public int getiSurplusType() {
		return iSurplusType;
	}
	public void setiSurplusType(int iSurplusType) {
		this.iSurplusType = iSurplusType;
	}
	public short getsSubSurplus() {
		return sSubSurplus;
	}
	public void setsSubSurplus(short sSubSurplus) {
		this.sSubSurplus = sSubSurplus;
	}
	public short getsRepayWay() {
		return sRepayWay;
	}
	public void setsRepayWay(short sRepayWay) {
		this.sRepayWay = sRepayWay;
	}
	public int getiYearRate() {
		return iYearRate;
	}
	public void setiYearRate(int iYearRate) {
		this.iYearRate = iYearRate;
	}
	public Date getTtEndDate() {
		return ttEndDate;
	}
	public void setTtEndDate(Date ttEndDate) {
		this.ttEndDate = ttEndDate;
	}
}

