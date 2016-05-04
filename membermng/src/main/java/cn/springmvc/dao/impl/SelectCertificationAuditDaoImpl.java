package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

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
		return getSqlSession().selectList("EnterpriseCAXML.selectMemberAttestByType",map,new RowBounds(page.getPageNum(),page.getPageSize()));
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
	public List<MemberAttestByTypeEntity> EnterpriseOrganizationCode(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.EnterpriseOrganizationCode",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<MemberAttestByTypeEntity> EnterprisebusinessLC(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.EnterprisebusinessLC",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
	@Override
	public List<MemberAttestByTypeEntity> accountLicenseCode(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.accountLicenseCode",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}
}
