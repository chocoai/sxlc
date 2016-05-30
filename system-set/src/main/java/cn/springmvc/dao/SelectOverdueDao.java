
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 逾期设置 查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:08:13  */
public interface SelectOverdueDao {
	
	
	/** 
	* findAllOverdue 逾期费用设置查询 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findAllOverdue 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<OverdueEntity> 返回类型 
	* @throws 
	*/
	public List<OverdueEntity> findAllOverdue(PageEntity pageEntity);
	
	/** 
	* findOverdueLimit 逾期程度界限查询
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findOverdueLimit 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public Integer findOverdueLimit();
	
	
	
	/** 
	* findMaxOverdue 查询目前最大的天数 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findMaxOverdue 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int findMaxOverdue();
}

