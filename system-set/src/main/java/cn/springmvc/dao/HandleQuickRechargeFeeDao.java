
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 快捷充值手续费设置 处理
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface HandleQuickRechargeFeeDao {
	

	
	/** 
	* updateQuickRechargeFee 修改快捷充值手续费 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateQuickRechargeFee 
	* @Description: TODO 
	* @param @param qFeeEntity
	* @param @return 设定文件 
	* @return int 返回类型  1：成功 0：失败
	* @throws 
	*/
	public List<Object> updateQuickRechargeFee(Map<String, Object> map);
	
	
	
}

