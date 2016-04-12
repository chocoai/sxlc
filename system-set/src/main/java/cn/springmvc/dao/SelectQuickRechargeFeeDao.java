
package cn.springmvc.dao; 

import java.util.List;

import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 快捷充值手续费设置 查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface SelectQuickRechargeFeeDao {
	
	/** 
	* findAllQuickRechargeFee  查询快捷充值手续费设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findAllQuickRechargeFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<QuickRechargeFeeEntity> 返回类型 
	* @throws 
	*/
	public List<QuickRechargeFeeEntity> findAllQuickRechargeFee();
}

