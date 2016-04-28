
package cn.sxlc.account.manager.model; 

/** 
 * 提奖信息 提交
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-19 下午5:17:33  */
public class AwardEntity {
	private long sjmoney;//事件金额
	private long tjmoney;//提奖金额
	private int  awardType;//提奖时间类型
	public long getSjmoney() {
		return sjmoney;
	}
	public void setSjmoney(long sjmoney) {
		this.sjmoney = sjmoney;
	}
	public long getTjmoney() {
		return tjmoney;
	}
	public void setTjmoney(long tjmoney) {
		this.tjmoney = tjmoney;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	
}

