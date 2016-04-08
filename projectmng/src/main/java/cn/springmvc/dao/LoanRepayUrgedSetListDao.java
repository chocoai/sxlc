package cn.springmvc.dao;

import cn.springmvc.model.LoanRepayUrgedSetEntity; 
/**
 * 
* @author 刘利 
* @Description: 催收账单配置
* @since 
* @date 2016-3-19 下午10:21:44
 */
public interface LoanRepayUrgedSetListDao {
	/**
	 * 查询催收账单配置
	 * @param entity 催收账单配置实体
	 * @return
	 */
	public  LoanRepayUrgedSetEntity  selectLoanRepayUrgedSet (); 
	/**
	 * 查询催收账单配置是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectLoanRepayUrgedSetIsExist();
}
