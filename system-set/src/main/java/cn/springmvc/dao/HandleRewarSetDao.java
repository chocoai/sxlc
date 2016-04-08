
package cn.springmvc.dao; 

import cn.springmvc.model.RewardSetEntity;


/** 
 * 提奖设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午10:03:47  */
public interface HandleRewarSetDao {
	
	
	/** 
	* insertRewarSet 添加提奖设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertRewarSet 
	* @Description: TODO 
	* @param @param rewardSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertRewarSet(RewardSetEntity rewardSetEntity);
	
	/** 
	* updateRewarSet 修改提奖设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateRewarSet 
	* @Description: TODO 
	* @param @param rewardSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateRewarSet(RewardSetEntity rewardSetEntity);
	
	/** 
	* deleteRewarSet 删除提奖设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: deleteRewarSet 
	* @Description: TODO 
	* @param @param rewardSetEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int deleteRewarSet(RewardSetEntity rewardSetEntity);
}

