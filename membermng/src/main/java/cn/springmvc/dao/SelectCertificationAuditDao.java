package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AutomaticBidSettingEntity;
import cn.membermng.model.EnterpriseAttestEntity;
import cn.membermng.model.EnterpriseLicenseAttestEntity;
import cn.membermng.model.ExistingFinancialAdvisorEntity;
import cn.membermng.model.FinancialAdvisorEntity;
import cn.membermng.model.MemberAttestByTypeEntity;
import cn.membermng.model.MemberAttestTypeEntity;
import cn.membermng.model.PersonalAttestAttachEntity;
import cn.membermng.model.VIPPurchaseRecordsEntity;

/*import cn.springmvc.model.MemberAttestByTypeEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.PersonalAttestAttachEntity;*/


/** 
 * 认证信息审核
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-24 下午7:37:31  */
public interface SelectCertificationAuditDao {
	
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
	* selectMemberAttestByType 根据会员id 查询会员vip购买记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectMemberAttestByType 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<VIPPurchaseRecordsEntity> 返回类型 
	* @date 2016-5-2 下午2:32:10
	* @throws 
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
	* @date 2016-5-3 下午2:45:06
	* @throws 
	*/
	public List<MemberAttestByTypeEntity> marriageCertification(
			PageEntity page);
	
	/** 
	* EducationCertification 根据认证类型id,会员类型分页查询学历认证信息  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EducationCertification 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午3:33:08
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
	* EnterprisebusinessLC 企业工商执照认证列表查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EnterprisebusinessLC 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<MemberAttestByTypeEntity> 返回类型 
	* @date 2016-5-3 下午8:04:05
	* @throws 
	*/
	public List<EnterpriseLicenseAttestEntity> EnterprisebusinessLC(
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
	* @date 2016-5-3 下午8:14:48
	* @throws 
	*/
	public List<EnterpriseLicenseAttestEntity> accountLicenseCode(
			PageEntity page);
	
	
	/** 
	* QueryMemberAutomaticBidSetting  根据会员id查询会员自动投标设置 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: QueryMemberAutomaticBidSetting 
	* @Description: TODO 
	* @param @param memberId
	* @param @return 设定文件 
	* @return AutomaticBidSettingEntity 返回类型 
	* @date 2016-5-4 上午10:40:40
	* @throws 
	*/
	public AutomaticBidSettingEntity QueryMemberAutomaticBidSetting(long memberId);
	
	
	/** 
	* findFinancialAdvisor 分配理财顾问列表查询  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findFinancialAdvisor 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<FinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午1:34:42
	* @throws 
	*/
	public  List<FinancialAdvisorEntity> findFinancialAdvisor(
			PageEntity page);
	
	
	/** 
	* ExistingFinancialAdvisor 待分配理财顾问会员  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ExistingFinancialAdvisor 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午5:04:45
	* @throws 
	*/
	public  List<ExistingFinancialAdvisorEntity> ExistingFinancialAdvisor(
			PageEntity page);
	
	
	/** 
	* ExistingFinancialAdvisor 已分配理财顾问会员
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ExistingFinancialAdvisor 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-5 下午9:24:52
	* @throws 
	*/
	public  List<ExistingFinancialAdvisorEntity> HasFinancialAdvisor(
			PageEntity page);
	
	
	/** 
	* ChangeHistory 历史变更理财会员
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ChangeHistory 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<ExistingFinancialAdvisorEntity> 返回类型 
	* @date 2016-5-10 上午10:18:56
	* @throws 
	*/
	public  List<ExistingFinancialAdvisorEntity> ChangeHistory(
			PageEntity page);
	
	
	/** 
	* sEnterpriseLicenseAttestByID 根据认证类型查询认证详情
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: sEnterpriseLicenseAttestByID 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return EnterpriseAttestEntity 返回类型 
	* @date 2016-5-10 下午8:38:15
	* @throws 
	*/
	public EnterpriseAttestEntity sEnterpriseLicenseAttestByID(Map<String, Object> map);
}

