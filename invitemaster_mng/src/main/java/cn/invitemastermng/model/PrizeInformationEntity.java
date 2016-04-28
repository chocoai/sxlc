

/** 
* @Title: PrizeInformationEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-19 下午4:41:33 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 奖品信息实体
 * @since 
 * @date 2016-4-19 下午4:41:33  */

public class PrizeInformationEntity { 
	private long 	prizeID;//	奖品ID	 
	private int	    prizeType;//	字典：奖品类型DICTJPLX	 
	private String	prizeName;//	奖品名称	VARCHAR(120) 
	private long	prizeWorth;//	奖品价值（红包面值、实物市值、代金券面值、返现券面值） 
	private String	prizeWorths;//	奖品价值（红包面值、实物市值、代金券面值、返现券面值） 
	private long	prizeQuantity;//	奖品剩余数量 
	private String	prizeUrl;//	奖品图片路径 
	private int	    status;//	状态：1有效0无效 
	private int     grade;//获奖等级
	private long    gradeOdds;//等级基数
	private long    winningOdds;//中奖概率基数
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public long getGradeOdds() {
		return gradeOdds;
	}
	public void setGradeOdds(long gradeOdds) {
		this.gradeOdds = gradeOdds;
	}
	public long getWinningOdds() {
		return winningOdds;
	}
	public void setWinningOdds(long winningOdds) {
		this.winningOdds = winningOdds;
	}
	public long getPrizeID() {
		return prizeID;
	}
	public void setPrizeID(long prizeID) {
		this.prizeID = prizeID;
	}
	public int getPrizeType() {
		return prizeType;
	}
	public void setPrizeType(int prizeType) {
		this.prizeType = prizeType;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public long getPrizeWorth() {
		return prizeWorth;
	}
	public void setPrizeWorth(long prizeWorth) {
		this.prizeWorth = prizeWorth;
		this.prizeWorths = IntegerAndString.LongToString(prizeWorth);
	}
	public String getPrizeWorths() {
		return prizeWorths;
	}
	public void setPrizeWorths(String prizeWorths) {
		this.prizeWorths = prizeWorths;
	}
	public long getPrizeQuantity() {
		return prizeQuantity;
	}
	public void setPrizeQuantity(long prizeQuantity) {
		this.prizeQuantity = prizeQuantity;
	}
	public String getPrizeUrl() {
		return prizeUrl;
	}
	public void setPrizeUrl(String prizeUrl) {
		this.prizeUrl = prizeUrl;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
 
}

