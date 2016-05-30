package cn.springmvc.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;
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
import cn.springmvc.dao.SelectCertificationAuditDao;



@Component("selectCertificationAuditDaoImpl")
public class SelectCertificationAuditDaoImpl extends SqlSessionDaoSupport implements SelectCertificationAuditDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<MemberAttestTypeEntity> selectAllMemberAttestType(PageEntity page){
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.selectAllMemberAttestType",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}

	@Override
	public List<MemberAttestByTypeEntity> selectMemberAttestByType(
			PageEntity page) {
		String xml = (String)page.getMap().get("xmlSql");
		return getSqlSession().selectList(xml,page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}

	@Override
	public List<PersonalAttestAttachEntity> selectAttestAttachList(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.selectMemberAttestByType",map);
	}

	@Override
	public List<VIPPurchaseRecordsEntity> VipPurchaseRecords(PageEntity page,Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.VipPurchaseRecords",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	
	public List<MemberAttestByTypeEntity> realNameAuthentication(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.realNameAuthentication",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<MemberAttestByTypeEntity> AddressAuthentication(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.AddressAuthentication",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<MemberAttestByTypeEntity> marriageCertification(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.marriageCertification",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<MemberAttestByTypeEntity> EducationCertification(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.EducationCertification",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<EnterpriseLicenseAttestEntity> EnterpriseOrganizationCode(
			PageEntity page) {
		
		String xml = (String)page.getMap().get("xmlSql");
		return getSqlSession().selectList(xml,page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<EnterpriseLicenseAttestEntity> EnterprisebusinessLC(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.EnterprisebusinessLC",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<EnterpriseLicenseAttestEntity> accountLicenseCode(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.accountLicenseCode",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public AutomaticBidSettingEntity QueryMemberAutomaticBidSetting(
			long memberId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberID", memberId);
		AutomaticBidSettingEntity aEntity=getSqlSession().selectOne("EnterpriseCAXML.QueryMemberAutomaticBidSetting",map);
		if (aEntity!=null) {
			aEntity.setsEveryMoney(IntegerAndString.LongToString(aEntity.getEveryMoney()));
			aEntity.setsReservedMoney(IntegerAndString.LongToString(aEntity.getReservedMoney()));
			if (aEntity.getProType()!=null && !aEntity.getProType().equals("")) {
				String [] sty=aEntity.getProType().split(",");
				String ss="";
				for (int i = 0; i < sty.length; i++) {
					Map<String, Object> map1 = new HashMap<String, Object>();
					map1.put("projectID", sty[i]);
					String pbi="";
					//查询借款类型
					pbi=getSqlSession().selectOne("EnterpriseCAXML.findProjectBaseInfo",map1);
					if (ss!="") {
						ss+=","+pbi;
					}else {
						ss+=pbi;
					}
				}
				aEntity.setProTypesString(ss);
			}
			if(aEntity.getStatus()!=null && !aEntity.getStatus().equals("")){
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("status", aEntity.getStatus());
				getSqlSession().selectOne("EnterpriseCAXML.findHKFS",map2);
				if(map2.get("result")!=null){
					aEntity.setStatus(map2.get("result").toString());
				}
			}
			
		}
		// TODO Auto-generated method stub return null;
		return aEntity;
	}
	
	@Override
	public List<FinancialAdvisorEntity> findFinancialAdvisor(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.findFinancialAdvisor",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> ExistingFinancialAdvisor(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.ExistingFinancialAdvisor",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> HasFinancialAdvisor(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.HasFinancialAdvisor",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<ExistingFinancialAdvisorEntity> ChangeHistory(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.ChangeHistory",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public EnterpriseAttestEntity sEnterpriseLicenseAttestByID(
			Map<String, Object> map ) {
		
		return getSqlSession().selectOne("EnterpriseCAXML.sEnterpriseLicenseAttestByID",map);
	}
}
