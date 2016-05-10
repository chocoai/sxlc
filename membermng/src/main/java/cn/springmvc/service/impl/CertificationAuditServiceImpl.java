package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.membermng.model.AutomaticBidSettingEntity;
import cn.membermng.model.EnterpriseLicenseAttestEntity;
import cn.membermng.model.ExistingFinancialAdvisorEntity;
import cn.membermng.model.FinancialAdvisorEntity;
import cn.membermng.model.MemberAttestByTypeEntity;
import cn.membermng.model.MemberAttestTypeEntity;
import cn.membermng.model.PersonalAttestAttachEntity;
import cn.membermng.model.VIPPurchaseRecordsEntity;
import cn.springmvc.dao.impl.HandleCertificationAuditDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectCertificationAuditDaoImpl;
import cn.springmvc.service.CertificationAuditService;

@Service("certificationAuditServiceImpl")
public class CertificationAuditServiceImpl implements CertificationAuditService{
	@Resource(name="handleCertificationAuditDaoImpl")
	private HandleCertificationAuditDaoImpl  handleCertificationAuditDaoImpl;
	@Resource(name="selectCertificationAuditDaoImpl")
	private SelectCertificationAuditDaoImpl  selectCertificationAuditDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<MemberAttestTypeEntity> selectAllMemberAttestType(PageEntity page) {
		
		List<MemberAttestTypeEntity> list =  selectCertificationAuditDaoImpl.selectAllMemberAttestType(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}

	@Override
	public List<MemberAttestByTypeEntity> selectMemberAttestByType(
			PageEntity page) {
		List<MemberAttestByTypeEntity> list =  selectCertificationAuditDaoImpl.selectMemberAttestByType(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}

	@Override
	public List<PersonalAttestAttachEntity> selectAttestAttachList(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.selectAttestAttachList(map);
	}

	@Override
	public Map<String, Object> handleEnterpriseCerAudit(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("操作企业营业执照认证 审核:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handleEnterpriseCerAudit(map);
	}

	@Override
	public Map<String, Object> handleEnterpriseBLAttest(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("操作企业会员工商执照认证信息审核:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handleEnterpriseBLAttest(map);
	}

	@Override
	public Map<String, Object> handleAttest(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("会员相关认证操作:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handleAttest(map);
	}

	@Override
	public Map<String, Object> handlequalification(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("个人会员最高学历认证操作:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handlequalification(map);
	}

	@Override
	public Map<String, Object> handlenameAuthentication(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("个人会员实名认证操作:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handlenameAuthentication(map);
	}

	@Override
	public Map<String, Object> handlemarriage(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("个人会员婚姻认证操作:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handlemarriage(map);
	}

	@Override
	public Map<String, Object> handleAddress(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("个人会员住址认证操作:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.handleAddress(map);
	}
	@Override
	public List<VIPPurchaseRecordsEntity>  VipPurchaseRecords(PageEntity page,Map<String, Object> map) {
		List<VIPPurchaseRecordsEntity> list =  selectCertificationAuditDaoImpl.VipPurchaseRecords(page, map);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public List<MemberAttestByTypeEntity> realNameAuthentication(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.realNameAuthentication(page);
	}
	@Override
	public List<MemberAttestByTypeEntity> AddressAuthentication(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.AddressAuthentication(page);
	}
	@Override
	public List<MemberAttestByTypeEntity> marriageCertification(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.marriageCertification(page);
	}
	@Override
	public List<MemberAttestByTypeEntity> EducationCertification(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.EducationCertification(page);
	}
	@Override
	public List<EnterpriseLicenseAttestEntity> EnterpriseOrganizationCode(
			PageEntity page) {
		
		List<EnterpriseLicenseAttestEntity>  list =  selectCertificationAuditDaoImpl.EnterpriseOrganizationCode(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public List<EnterpriseLicenseAttestEntity> accountLicenseCode(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.accountLicenseCode(page);
	}
	@Override
	public AutomaticBidSettingEntity QueryMemberAutomaticBidSetting(
			long memberId) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.QueryMemberAutomaticBidSetting(memberId);
	}
	@Override
	public int AutomaticBidSetting(Map<String, Object> map) {
		handleCertificationAuditDaoImpl.AutomaticBidSetting(map);
		// TODO Auto-generated method stub return null;
		//result ：-1：已存在自动投标设置  -2：还未开户  -3：还未进行自动投标授权 0：成功
		int rulest = IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rulest;
	}
	@Override
	public int delAutomaticBidSetting(Map<String, Object> map) {
		// TODO Auto-generated method stub return null;
		return handleCertificationAuditDaoImpl.delAutomaticBidSetting(map);
	}
	@Override
	public List<FinancialAdvisorEntity> findFinancialAdvisor(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		List<FinancialAdvisorEntity> list =  selectCertificationAuditDaoImpl.findFinancialAdvisor(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public int DistributionFinancialAdvisor(long memberID, long advisorId,long oldadvisorId,int types,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberID", memberID);
		map.put("advisorId", advisorId);
		map.put("oldadvisorId", oldadvisorId);
		map.put("types", types);
		// TODO Auto-generated method stub return 0;
		//types:1:分配理财顾问（oldadvisorId 可为0） 2:变更理财顾问  result ：1:成功 ；-1; 已存在理财顾问，请到会员管理变更理财顾问  -2;-- 没有原始理财顾问 不能变更
		if (types==1) {
			entity.setsDetail("给会员分配理财顾问，会员id："+memberID+"理财顾问id："+advisorId);
		}else {
			entity.setsDetail("给变更会员理财顾问，会员id："+memberID+"变更前理财顾问id"+oldadvisorId+"，变更后理财顾问id："+advisorId);
		}
		
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		handleCertificationAuditDaoImpl.DistributionFinancialAdvisor(map);
		int result= IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return result;
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> ExistingFinancialAdvisor(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		List<ExistingFinancialAdvisorEntity> list =  selectCertificationAuditDaoImpl.ExistingFinancialAdvisor(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> HasFinancialAdvisor(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		List<ExistingFinancialAdvisorEntity> list =  selectCertificationAuditDaoImpl.HasFinancialAdvisor(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> ChangeHistory(PageEntity page,
			long memberID) {
		Map<String, Object> Map = new HashMap<>();
		Map.put("memberID", memberID);
		page.setMap(Map);
		// TODO Auto-generated method stub return null;
		List<ExistingFinancialAdvisorEntity> list =  selectCertificationAuditDaoImpl.ChangeHistory(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
}
