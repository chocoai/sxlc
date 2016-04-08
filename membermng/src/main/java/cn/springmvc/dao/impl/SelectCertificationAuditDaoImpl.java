package cn.springmvc.dao.impl;

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
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.selectMemberAttestByType",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}

	@Override
	public List<PersonalAttestAttachEntity> selectAttestAttachList(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("EnterpriseCAXML.selectMemberAttestByType",map);
	}


}
