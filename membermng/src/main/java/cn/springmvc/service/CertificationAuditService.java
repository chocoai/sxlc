package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberAttestByTypeEntity;
import cn.membermng.model.MemberAttestTypeEntity;
import cn.membermng.model.PersonalAttestAttachEntity;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
/*import cn.springmvc.model.MemberAttestByTypeEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.PersonalAttestAttachEntity;*/





/** 
 * 后台会员认证审核相关
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午8:29:59  */
public interface CertificationAuditService {
	/** 
	* selectAllMemberAttestType(分页查询企业或者个人会员所有需要后台审核的认证类型) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllMemberAttestType 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestTypeEntity> 返回类型 
	* @date 2016-3-24 下午7:40:21
	* @throws 
	*/
	public List<MemberAttestTypeEntity> selectAllMemberAttestType(PageEntity page);
	

	
	/** 
	* selectMemberAttestByType 根据认证类型id,会员类型分页查询当前认证所有会员信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectMemberAttestByType 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-3-24 下午7:42:26
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> selectMemberAttestByType(PageEntity page);
	
	
	/** 
	* selectAttestAttachList 根据认证记录id查看会员该认证项的认证附件信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAttestAttachList 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<PersonalAttestAttachEntity> 返回类型 
	* @date 2016-3-24 下午7:46:39
	* @throws 
	*/
	public List<PersonalAttestAttachEntity> selectAttestAttachList(Map<String, Object> map);

	/** 
	* handleEnterpriseCerAudit 操作企业营业执照认证 审核
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleEnterpriseCerAudit 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:24:50
	* @throws 
	*/
	public Map<String, Object> handleEnterpriseCerAudit(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	/** 
	* handleEnterpriseBLAttest 操作企业会员工商执照认证信息审核
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleEnterpriseBLAttest 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:25:15
	* @throws 
	*/
	public Map<String, Object> handleEnterpriseBLAttest(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* handleAttest 会员其他相关认证操作
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleAttest 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-24 下午8:25:39
	* @throws 
	*/
	public Map<String, Object> handleAttest(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	
	/** 
	* handlequalification 个人会员最高学历认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlequalification 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午9:08:34
	* @throws 
	*/
	public Map<String, Object> handlequalification(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	/** 
	* handlenameAuthentication 个人会员实名认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlenameAuthentication 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:00:00
	* @throws 
	*/
	public Map<String, Object> handlenameAuthentication(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	/** 
	* handlemarriage 个人会员婚姻认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handlemarriage 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:04:42
	* @throws 
	*/
	public Map<String, Object> handlemarriage(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* handleAddress 个人会员住址认证操作 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleAddress 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-25 上午10:16:41
	* @throws 
	*/
	public Map<String, Object> handleAddress(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
}
