package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SystemAgreementSetListDao;
import cn.springmvc.model.SystemAgreementSetEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("systemAgreementSetListDaoImpl")
public class SystemAgreementSetListDaoImpl extends SqlSessionDaoSupport implements SystemAgreementSetListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public SystemAgreementSetEntity selectSystemAgreementSetIsExistBytype(
			SystemAgreementSetEntity entity) {
		SystemAgreementSetEntity systemAgreementSetEntity=null;
		systemAgreementSetEntity=(SystemAgreementSetEntity) getSqlSession().selectOne("systemAgreementSet.selectSystemAgreementSetIsExistBytype",entity.getAgreementType());
		return systemAgreementSetEntity;
	}

	@Override
	public List<SystemAgreementSetEntity> selectSystemAgreementSetAllpage(
			PageEntity pageEntity) {
		List<SystemAgreementSetEntity> systemAgreementSetList=null;
		systemAgreementSetList=getSqlSession().selectList("systemAgreementSet.selectSystemAgreementSetList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return systemAgreementSetList;
	}
	@Override
	public SystemAgreementSetEntity selectSystemAgreementSetBytype(
			int agreementType) {
		SystemAgreementSetEntity systemAgreementSetEntity=null;
		systemAgreementSetEntity=(SystemAgreementSetEntity) getSqlSession().selectOne("systemAgreementSet.selectSystemAgreementSetBytype",agreementType);
		return systemAgreementSetEntity;
	}
}
