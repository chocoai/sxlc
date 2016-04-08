package cn.springmvc.service;

import java.util.Map;

import cn.springmvc.model.WithdrawalsFeeEntity;



/** 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午2:17:39  */
public interface FinancialSettingService {
	
	/** 
	* updateWithdrawalsFee 修改提现手续费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateWithdrawalsFee 
	* @Description: TODO 
	* @param @param withdrawalsFeeEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity);
	
	
	
	/** 
	* selectWithdrawalsFee 查询提现手续费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectWithdrawalsFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return WithdrawalsFeeEntity 返回类型 
	* @throws 
	*/
	public WithdrawalsFeeEntity selectWithdrawalsFee();
	
	
	
	/** 
	* findWithdrawalsFee 查询是否已存在提现手续费 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findWithdrawalsFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int findWithdrawalsFee(Map<String, Object> map);
	
	
	/** 
	* insertWithdrawalsFee 若不存在已设置的提现手续费 则添加 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertWithdrawalsFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity);
}

