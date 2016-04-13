
package cn.springmvc.dao; 

import java.util.Map;

import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;







/** 
 * 设置系统设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午7:18:39  */
public interface HandleSystemSetDao {	
	
	/** 
	* updateSystemSet 修改系统设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateSystemSet 
	* @Description: TODO 
	* @param @param systemSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateSystemSet(SystemSetEntity systemSetEntity);
	
	/** 
	* insertSystemSet 添加系统设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertSystemSet 
	* @Description: TODO 
	* @param @param systemSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertSystemSet(SystemSetEntity systemSetEntity);
	
	
	
	
	
	/** 
	* updateSystemInfoSet 删除平台设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateSystemInfoSet 
	* @Description: TODO 
	* @param @param systemSetInfoEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateSystemInfoSet();
	
	/** 
	* insertSystemInfoSet 添加平台设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertSystemInfoSet 
	* @Description: TODO 
	* @param @param systemInfoSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertSystemInfoSet(SystemInfoSetEntity systemInfoSetEntity);
	
	
	/** 
	* setInterestMngFee 设置利息管理费 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: setInterestMngFee 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-13 下午4:11:59
	* @throws 
	*/
	public Map<String, Object> setInterestMngFee(Map<String, Object> map);
}

