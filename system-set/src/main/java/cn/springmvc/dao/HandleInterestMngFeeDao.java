
package cn.springmvc.dao; 

import cn.springmvc.model.InterestMngFeeEntity;

/** 
 * 利息管理费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午9:30:00  */
public interface HandleInterestMngFeeDao {
	
	/** 
	* updateInterestMngFee 修改利息管理费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateInterestMngFee 
	* @Description: TODO 
	* @param @param interestMngFeeEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateInterestMngFee(InterestMngFeeEntity interestMngFeeEntity);
	
	/** 
	* insertInterestMngFee 添加利息管理费设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertInterestMngFee 
	* @Description: TODO 
	* @param @param interestMngFeeEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertInterestMngFee(InterestMngFeeEntity interestMngFeeEntity);
	
	
}

