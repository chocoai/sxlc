
package cn.springmvc.model; 

/** 
 * 项目惊喜红包配置
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午5:02:59  */
public class ProjectInvestRedPackageEntity {
	private long applyId;//	项目申请ID
	private int investRedPackageMin;//投资超过N元 单位：元 精确到小数点后4位	
	private int investNum;//前M位投资人	
	private int redPackage;//	获取红包金额 单位：元 精确到小数点后4位
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public int getInvestRedPackageMin() {
		return investRedPackageMin;
	}
	public void setInvestRedPackageMin(int investRedPackageMin) {
		this.investRedPackageMin = investRedPackageMin;
	}
	public int getInvestNum() {
		return investNum;
	}
	public void setInvestNum(int investNum) {
		this.investNum = investNum;
	}
	public int getRedPackage() {
		return redPackage;
	}
	public void setRedPackage(int redPackage) {
		this.redPackage = redPackage;
	}
	
}

