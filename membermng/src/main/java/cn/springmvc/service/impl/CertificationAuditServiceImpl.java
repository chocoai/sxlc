package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.MemberAttestByTypeEntity;
import cn.membermng.model.MemberAttestTypeEntity;
import cn.membermng.model.PersonalAttestAttachEntity;
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
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.selectAllMemberAttestType(page);
	}

	@Override
	public List<MemberAttestByTypeEntity> selectMemberAttestByType(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return selectCertificationAuditDaoImpl.selectMemberAttestByType(page);
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
	
}
