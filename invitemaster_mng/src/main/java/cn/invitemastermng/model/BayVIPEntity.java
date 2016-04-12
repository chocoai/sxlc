

/** 
* @Title: BayVIPEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午2:50:53 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 理财顾问-推荐达人-VIP购买明细
 * @since 
 * @date 2016-4-5 下午2:50:53  */

public class BayVIPEntity {
	private String logname;//用户名
	private String personalName;//会员名称
	private String certifySDate;//购买有效时间段起始时间
	private String certifyEDate;//购买有效时间段终止时间
	private long amount;//购买金额
	private String amounts;//购买金额
	private String recordDate;//支付时间
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getCertifySDate() {
		return certifySDate;
	}
	public void setCertifySDate(String certifySDate) {
		this.certifySDate = certifySDate;
	}
	public String getCertifyEDate() {
		return certifyEDate;
	}
	public void setCertifyEDate(String certifyEDate) {
		this.certifyEDate = certifyEDate;
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
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
}

