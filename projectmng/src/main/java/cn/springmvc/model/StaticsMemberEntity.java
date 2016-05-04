

/** 
* @Title: StaticsMemberEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 下午6:12:51 
* @version V5.0 */
 
package cn.springmvc.model; 

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-27 下午6:12:51  */

public class StaticsMemberEntity {
	public long countMember;//会员个数
	public long countInvestMember;//投资会员个数
	public long countLoanMember;//借款会员个数
	public long getCountMember() {
		return countMember;
	}
	public void setCountMember(long countMember) {
		this.countMember = countMember;
	}
	public long getCountInvestMember() {
		return countInvestMember;
	}
	public void setCountInvestMember(long countInvestMember) {
		this.countInvestMember = countInvestMember;
	}
	public long getCountLoanMember() {
		return countLoanMember;
	}
	public void setCountLoanMember(long countLoanMember) {
		this.countLoanMember = countLoanMember;
	}
}

