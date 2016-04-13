
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.WithdrawalsFeeEntity;

/** 
 * 财务设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 上午11:46:59  */
public interface FinancialSettingDao {	
	

	
	/** 
	* findWithdrawalsFee 查看是否存在手续费配置 
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
	* selectWithdrawalsFeeEntity 查询当前配置  
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: countWithdrawalsFeeEntity 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return WithdrawalsFeeEntity 返回类型 
	* @throws 
	*/
	public List<WithdrawalsFeeEntity> selectWithdrawalsFeeEntity();
	
	
	/** 
	* updateWithdrawalsFee 提现手续费修改 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateWithdrawalsFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity);
	
	
	/** 
	* insertWithdrawalsFee 添加提现手续费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateWithdrawalsFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity);
	
	
}

