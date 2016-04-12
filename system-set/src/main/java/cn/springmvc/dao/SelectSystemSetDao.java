
package cn.springmvc.dao; 

import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;





/** 
 * 系统设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午6:59:23  */
public interface SelectSystemSetDao {	
	
	/** 
	* findSystemSet 查询系统设置表信息
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findSystemSet 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return SystemSetEntity 返回类型 
	* @throws 
	*/
	public SystemSetEntity findSystemSet();
	
	/** 
	* findSystemInfoSet 查询平台设置信息
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findSystemSet 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return SystemSetEntity 返回类型 
	* @throws 
	*/
	public SystemInfoSetEntity findSystemInfoSet();
	
}

