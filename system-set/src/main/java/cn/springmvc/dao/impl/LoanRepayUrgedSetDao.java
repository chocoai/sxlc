package cn.springmvc.dao.impl;
  
import cn.springmvc.model.LoanRepayUrgedSetEntity;
/**
 * 
* @author 刘利 
* @Description: 催收账单配置 
* @since 
* @date 2016-3-19 下午10:21:33
 */
public interface LoanRepayUrgedSetDao {
	/**
	 * 添加催收账单配置
	 * @param entity  催收账单配置实体类
	 * @return	0：失败	1：成功
	 */
	public int insertLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity);
 
	/**
	 * 修改催收账单配置
	 * @param entity 催收账单配置实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity); 
	/**
	 * 删除催收账单配置 
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteLoanRepayUrgedSet();

}
