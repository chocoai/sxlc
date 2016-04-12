
package cn.springmvc.service; 

import java.util.Map;

import cn.springmvc.model.CreditorEntity;



/** 
 * 债权转让设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:29:30  */
public interface CreditorService {
	
	/** 
	* findAllCreditor  债权转让设置查询
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findAllCreditor 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return CreditorEntity 返回类型 
	* @throws 
	*/
	public CreditorEntity findAllCreditor();
	
	
	/** 
	* inserCreditor 如果已经存在设置，则不再需要重新添加 ；添加债权设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: inserCreditor 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int inserCreditor(CreditorEntity creditorEntity);
	
	
	
	/** 
	* updateCreditor  修改债权转让设置
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

