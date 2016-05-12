

/** 
* @Title: BorrowingDetailedEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午1:53:48 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import java.sql.Timestamp;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;

/** 
 * @author 刘利 
 * @Description: 理财顾问-推荐达人-借款明细实体
 * @since 
 * @date 2016-4-5 下午1:53:48  */

public class BorrowingDetailedEntity {
	private String projectTitle;//借款名称
	private long amount;//借款金额
	private String amounts;//借款金额 
	private int deadline;//借款期限
	private String  name1;//借款期限类型
	private int yearRate;//年化利率
	private String yearRates;//年化利率
	private String logname;//借款人用户名
	private String personalName;//会员名称
	private String holdDate;//放款时间
	public  String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
 
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	} 
	public int getYearRate() {
		return yearRate;
	}
	public void setYearRate(int yearRate) {
		this.yearRate = yearRate;
		java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.00"); 
		this.yearRates =  myformat.format(Double.valueOf(IntegerAndString.LongToString(yearRate))) ;    
 
	}
	public String getYearRates() {
		return yearRates;
	}
	public void setYearRates(String yearRates) {
		this.yearRates = yearRates;
	}
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
	public String getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(String holdDate) {
		this.holdDate = TimestampAndString.TimestampToString(Timestamp.valueOf(holdDate));
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
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
}

