
package cn.springmvc.dao; 

import java.util.List;

import cn.springmvc.model.InterestMngFeeEntity;


/** 
 * 利息管理费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午9:30:00  */
public interface SelectInterestMngFeeDao {
	
	/** 
	* selectAllInterestMngFee 查询所有的利息管理费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectAllInterestMngFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<InterestMngFeeEntity> 返回类型 
	* @throws 
	*/
	public List<InterestMngFeeEntity> selectAllInterestMngFee();
	
}

