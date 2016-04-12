
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 积分规则设置 查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface SelectIntegralRuleDao {
	
	/** 
	* findAllIntegralRule 根据会员类型，某项积分规则查询积分规则设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findAllIntegralRule 
	* @Description: TODO 
	* @param @param map membertype会员类型  type 查询类型
	* @param @return 设定文件 
	* @return List<IntegralRuleEntity> 返回类型 
	* @throws 
	*/
	public List<IntegralRuleEntity> findAllIntegralRule(Map<String, Object> map);
	
}

