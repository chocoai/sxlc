

/** 
* @Title: MemberRedpacketsSetEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-18 下午2:52:52 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 会员红包赠送配置实体
 * @since 
 * @date 2016-4-18 下午2:52:52  */

public class MemberRedpacketsSetEntity {
	private int    openAccountRP;//新注册会员开户赠送金额																					
	private int    firstRechargeRP;//首次充值赠送红包金额	
	private String openAccountRPs;//新注册会员开户赠送金额																					
	private String firstRechargeRPs;//首次充值赠送红包金额	
	public int getOpenAccountRP() {
		return openAccountRP;
	}
	public void setOpenAccountRP(int openAccountRP) {
		this.openAccountRP = openAccountRP;
		this.openAccountRPs=IntegerAndString.IntToString(openAccountRP);
	}
	public int getFirstRechargeRP() {
		return firstRechargeRP;
	}
	public void setFirstRechargeRP(int firstRechargeRP) {
		this.firstRechargeRP = firstRechargeRP;
		this.firstRechargeRPs=IntegerAndString.IntToString(firstRechargeRP);
	}
	public String getOpenAccountRPs() {
		return openAccountRPs;
	}
	public void setOpenAccountRPs(String openAccountRPs) {
		this.openAccountRPs = openAccountRPs;
	}
	public String getFirstRechargeRPs() {
		return firstRechargeRPs;
	}
	public void setFirstRechargeRPs(String firstRechargeRPs) {
		this.firstRechargeRPs = firstRechargeRPs;
	}
	@Override
	public String toString() {
		return "MemberRedpacketsSetEntity [openAccountRP=" + openAccountRP
				+ ", firstRechargeRP=" + firstRechargeRP + ", openAccountRPs="
				+ openAccountRPs + ", firstRechargeRPs=" + firstRechargeRPs
				+ "]";
	}

}

