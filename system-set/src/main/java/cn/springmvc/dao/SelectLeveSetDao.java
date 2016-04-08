
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MemberLevelEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.SmsSettingsEntity;
import cn.springmvc.model.ThreeInterfaceEntity;





/** 
 * 会员等级设置 查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午8:03:36  */
public interface SelectLeveSetDao {
	
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
}

