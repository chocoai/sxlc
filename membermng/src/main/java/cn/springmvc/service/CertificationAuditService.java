package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AutomaticBidSettingEntity;
import cn.membermng.model.EnterpriseLicenseAttestEntity;
import cn.membermng.model.ExistingFinancialAdvisorEntity;
import cn.membermng.model.FinancialAdvisorEntity;
import cn.membermng.model.MemberAttestByTypeEntity;
import cn.membermng.model.MemberAttestTypeEntity;
import cn.membermng.model.PersonalAttestAttachEntity;
import cn.membermng.model.VIPPurchaseRecordsEntity;





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
	/** 
	* selectMemberAttestByType 根据会员id 查询会员vip购买记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectMemberAttestByType 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<VIPPurchaseRecordsEntity> 返回类型 
	* @date 2016-5-2 下午2:32:10
	*/
	public List<VIPPurchaseRecordsEntity> VipPurchaseRecords(PageEntity page,Map<String, Object> map);
	/** 
	* realNameAuthentication  会员实名认证列表信息展示 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: realNameAuthentication 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 上午11:54:14
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> realNameAuthentication(
			PageEntity page);
	/** 
	* AddressAuthentication 根据认证类型id,会员类型分页查询住址认证信息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: AddressAuthentication 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午2:29:05
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> AddressAuthentication(
			PageEntity page);
	
	
	/** 
	* marriageCertification 根据认证类型id,会员类型分页查询婚姻认证信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: marriageCertification 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午2:55:00
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> marriageCertification(
			PageEntity page);
	
	/** 
	* EducationCertification 根据认证类型id,会员类型学历认证
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EducationCertification 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午3:36:01
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> EducationCertification(
			PageEntity page);
	/** 
	* EnterpriseOrganizationCode 分页查询企业组织机构认证信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EnterpriseOrganizationCode 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午8:00:30
	* @throws 
	*/
	public List<EnterpriseLicenseAttestEntity> EnterpriseOrganizationCode(
			PageEntity page);
	
	/** 
	* accountLicenseCode 企业开户许可证认证
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: accountLicenseCode 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午8:17:27
	* @throws 
	*/
	public List<EnterpriseLicenseAttestEntity> accountLicenseCode(
			PageEntity page);
	
	
	/** 
	* QueryMemberAutomaticBidSetting 根据会员id查询会员自动投标设置 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: QueryMemberAutomaticBidSetting 
	* @Description: TODO 
	* @param @param memberId
	* @param @return 设定文件 
	* @return AutomaticBidSettingEntity 返回类型 
	* @date 2016-5-4 上午10:55:35
	* @throws 
	*/
	public AutomaticBidSettingEntity QueryMemberAutomaticBidSetting(long memberId);
	
	/** 
	* delAutomaticBidSetting 删除自动投标设置 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: delAutomaticBidSetting 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-4 下午2:21:37
	* @throws 
	*/
	public int delAutomaticBidSetting(Map<String, Object> map);
	
	/** 
	* AutomaticBidSetting 添加自动投标设置  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: AutomaticBidSetting 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型  result：-1：已存在自动投标设置  -2：还未开户  -3：还未进行自动投标授权 0：成功
	* @date 2016-5-4 下午2:22:05
	* @throws 
	*/
	public int AutomaticBidSetting(Map<String, Object> map);
	
	
	
	/** 
	* findFinancialAdvisor 分配理财顾问列表查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findFinancialAdvisor 
	* @Description: TODO 
	* @param @param page map{ servicePhone:理财顾问手机号，realName：姓名，serviceNo：理财顾问编号}
	* @param @return 设定文件 
	* @return List<FinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午1:37:29
	* @throws 
	*/
	public  List<FinancialAdvisorEntity> findFinancialAdvisor(
			PageEntity page);
	
	
	/** 
	* DistributionFinancialAdvisor 给会员分配理财顾问 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: DistributionFinancialAdvisor 
	* @Description: TODO 
	* @param @param memberID 会员id
	* @param @param advisorId 理财顾问id
	* @param @param entity
	* @param @param sIpInfo
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-5 下午2:36:29
	* @throws 
	*/
	public int DistributionFinancialAdvisor(long memberID,long advisorId,long oldadvisorId,int types,InsertAdminLogEntity entity, String[] sIpInfo);

	
	/** 
	* ExistingFinancialAdvisor 待分配理财顾问会员 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ExistingFinancialAdvisor 
	* @Description: TODO 
	* @param @param page map:
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午5:05:54
	* @throws 
	*/
	public List<ExistingFinancialAdvisorEntity> ExistingFinancialAdvisor(
			PageEntity page);
	
	/** 
	* HasFinancialAdvisor 已分配理财顾问会员 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: HasFinancialAdvisor 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午9:26:39
	* @throws 
	*/
	public  List<ExistingFinancialAdvisorEntity> HasFinancialAdvisor(
			PageEntity page);
	
	/** 
	* ChangeHistory 历史理财顾问变更记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ChangeHistory 
	* @Description: TODO 
	* @param  page
	* @param memberID 会员id
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-10 上午10:20:10
	* @throws 
	*/
	public List<ExistingFinancialAdvisorEntity> ChangeHistory(PageEntity page,long memberID);
}
