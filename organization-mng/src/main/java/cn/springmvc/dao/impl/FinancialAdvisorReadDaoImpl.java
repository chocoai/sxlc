package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IFinancialAdvisorReadDao;
import cn.springmvc.dao.IFinancialAdvisorWriteDao;
import cn.springmvc.model.FinancialAdvisor;

@Repository
public class FinancialAdvisorReadDaoImpl extends SqlSessionDaoSupport implements IFinancialAdvisorReadDao {

	
	@Override
	public List<FinancialAdvisor> getListByParam(PageEntity entity) {
		 return getSqlSession().selectList("financialAdvisorDaoImpl.getListByParam", entity ,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}




}
