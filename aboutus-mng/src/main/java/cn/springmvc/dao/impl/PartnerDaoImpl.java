package cn.springmvc.dao.impl;
 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.PartnersDao; 
import cn.springmvc.model.PartnersEntity;
@Repository("partnerDaoImpl")
public class PartnerDaoImpl extends SqlSessionDaoSupport implements PartnersDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertPartners(PartnersEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("Mapper.insertPartner", entity);
		return iResult;
	} 
	@Override
	public int updatePartnerByID(PartnersEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updatePartnerByID", entity);
		return result;
	}

	@Override
	public int deletePartnerByID(long id) {
		
		int result = 0;
		result = getSqlSession().delete("Mapper.deletePartnerByID", id);
		return result;
	} 
	@Override
	public int updatePartnerStatuByID(PartnersEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updatePartnerStatuByID", entity);
		return result;
	}

}
