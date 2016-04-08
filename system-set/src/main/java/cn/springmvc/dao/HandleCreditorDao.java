
package cn.springmvc.dao; 

import java.util.Map;

import cn.springmvc.model.CreditorEntity;


/** 
 * 债权转让设置 操作
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface HandleCreditorDao {
	
	/** 
	* inserCreditor  如果已经存在设置，则不再需要从新添加 ；添加债权设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: inserCreditor 
	* @Description: TODO 
	* @param @param creditorEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int inserCreditor(CreditorEntity creditorEntity);
	
	
	/** 
	* updateCreditor 修改债权转让设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateCreditor 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateCreditor(Map<String, Object> map);
}

