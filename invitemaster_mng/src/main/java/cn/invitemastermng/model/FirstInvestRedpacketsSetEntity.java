

/** 
* @Title: FirstInvestRedpacketsSetEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-18 下午3:18:13 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 会员首次投资红包赠送配置 
 * @since 
 * @date 2016-4-18 下午3:18:13  */

public class FirstInvestRedpacketsSetEntity {
	private long firpID;//ID																					
	private long investAmount;//投资金额 单位：元  保留4位小数	
	private String investAmounts;//投资金额 单位：元  保留4位小数	
	private int  rpRate;// 赠送比例 单位：百万分之	
	private String  rpRates;// 赠送比例 单位：百万分之	
	private int  statu;// 状态 0：无效 1：有效																					
	public long getFirpID() {
		return firpID;
	}
	public void setFirpID(long firpID) {
		this.firpID = firpID;
	}
	public long getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(long investAmount) {
		this.investAmount = investAmount;
		this.investAmounts=IntegerAndString.LongToString(investAmount);
	}
	public String getInvestAmounts() {
		return investAmounts;
	}
	public void setInvestAmounts(String investAmounts) {
		this.investAmounts = investAmounts;
	}
	public int getRpRate() {
		return rpRate;
	}
	public void setRpRate(int rpRate) {
		this.rpRate = rpRate;
		this.rpRates=IntegerAndString.IntToString(rpRate);
	}
	public String getRpRates() {
		return rpRates;
	}
	public void setRpRates(String rpRates) {
		this.rpRates = rpRates;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}

}

