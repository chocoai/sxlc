package cn.springmvc.dao.impl;
 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.LawsRegulationsDao;
import cn.springmvc.model.LawsRegulationsEntity; 
@Repository("lawsRegulationsDaoImpl")
public class LawsRegulationsDaoImpl extends SqlSessionDaoSupport implements LawsRegulationsDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertLawsRegulations(LawsRegulationsEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("lawsRegulations.insertLawsRegulations", entity);
		return iResult;
	} 
	@Override
	public int updateLawsRegulationsByID(LawsRegulationsEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("lawsRegulations.updateLawsRegulationsByID", entity);
		return result;
	}

	@Override
	public int deleteLawsRegulationsByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("lawsRegulations.deleteLawsRegulationsByID", id);
		return result;
	}

	@Override
	public int updateLawsRegulationsStatuByID(LawsRegulationsEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("lawsRegulations.updateLawsRegulationsStatuByID", entity);
		return result;
	}
 

}
