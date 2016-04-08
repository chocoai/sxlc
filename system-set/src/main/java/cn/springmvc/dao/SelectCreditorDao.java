
package cn.springmvc.dao; 

import java.util.List;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 债权转让设置 查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface SelectCreditorDao {
	
	
	
	/** 
	* findAllCreditor 查询债权转让设置 
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
}

