
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MemberLevelEntity;





/** 
 * 会员等级设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午8:11:33  */
public interface LevelSetService {
	
	/** 
	* selectAllMemberLevel 分页查询会员等级设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectAllMemberLevel 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<MemberLevelEntity> 返回类型 
	* @throws 
	*/
	public List<MemberLevelEntity> selectAllMemberLevel(PageEntity pageEntity);
	
	/** 
	* findMemberLevelById 根据id查询单个会员等级设置信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findMemberLevelById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return MemberLevelEntity 返回类型 
	* @throws 
	*/
	public MemberLevelEntity findMemberLevelById(Map<String, Object> map);
	
	
	/** 
	* selectAllCreditLevel 分页查询会员信用等级设置信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectAllCreditLevel 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<CreditLevelEntity> 返回类型 
	* @throws 
	*/
	public List<CreditLevelEntity> selectAllCreditLevel(PageEntity pageEntity);
	
	/** 
	* findCreditLevelById 根据id查询单个会员信用等级设置信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findCreditLevelById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return CreditLevelEntity 返回类型 
	* @throws 
	*/
	public CreditLevelEntity findCreditLevelById(Map<String, Object> map);
	

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

