package cn.springmvc.dao.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.RegisterBannerDao;
import cn.springmvc.model.RegisterBannerEntity; 
@Repository("registerBannerDaoImpl")
public class RegisterBannerDaoImpl extends SqlSessionDaoSupport implements RegisterBannerDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertRegisterBanner(RegisterBannerEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		} 
		iResult = getSqlSession().insert("Mapper.insertRegisterBanner", entity);
		return iResult;
	}
 
	@Override
	public int updateRegisterBannerByID(RegisterBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateRegisterBannerByID", entity);
		return result;
	}

	@Override
	public int deleteRegisterBannerByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("Mapper.deleteRegisterBannerByID", id);
		return result;
	}

	@Override
	public List<RegisterBannerEntity> selectRegisterBannerAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRegisterBannerStatuByID(RegisterBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateRegisterBannerStatuByID", entity);
		return result;
	}
	@Override
	public int moveAndDownRegisterBannerByID(Map<String, Object> map) {
		
		int result = -1;
		getSqlSession().update("Mapper.moveAndDownRegisterBanner", map);
		//result=(int) map.get("result");
		return result;
	}
 
}
