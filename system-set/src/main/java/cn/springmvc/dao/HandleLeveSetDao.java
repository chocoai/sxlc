
package cn.springmvc.dao; 

import java.util.Map;

import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.MemberLevelEntity;






/** 
 * 会员等级设置 设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午8:03:36  */
public interface HandleLeveSetDao {
	
	/** 
	* insertMemberLevel 添加单个会员等级信息设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertMemberLevel 
	* @Description: TODO 
	* @param @param memberLevelEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertMemberLevel(MemberLevelEntity memberLevelEntity);
	
	/** 
	* updateMemberLevelById 修改单个会员等级设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateMemberLevelById 
	* @Description: TODO 
	* @param @param memberLevelEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateMemberLevelById(MemberLevelEntity memberLevelEntity);
	
	/** 
	* deleteMemberLevelById 删除单条会员等级设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: deleteMemberLevelById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int deleteMemberLevelById(Map<String, Object> map);
	
	
	/** 
	* insertCreditLevel 添加会员信用等级信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertCreditLevel 
	* @Description: TODO 
	* @param @param creditLevelEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertCreditLevel(CreditLevelEntity creditLevelEntity);
	
	/** 
	* updateCreditLevelById 修改单条会员信用等级信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateCreditLevelById 
	* @Description: TODO 
	* @param @param creditLevelEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateCreditLevelById(CreditLevelEntity creditLevelEntity);
	
	/** 
	* deleteCreditLevelById 根据id删除单条会员信用等级信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: deleteCreditLevelById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int deleteCreditLevelById(Map<String, Object> map);
}

