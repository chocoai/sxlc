
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.InterestMngFeeEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.SystemSetEntity;

/** 
 * 利息管理费
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午9:18:56  */
public interface InterestMngFeeService {

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

