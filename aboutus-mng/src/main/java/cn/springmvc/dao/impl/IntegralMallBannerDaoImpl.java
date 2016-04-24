package cn.springmvc.dao.impl;
  
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
 
import cn.springmvc.dao.IntegralMallBannerDao;
import cn.springmvc.model.IntegralMallBannerEntity; 
@Repository("integralMallBannerDaoImpl")
public class IntegralMallBannerDaoImpl extends SqlSessionDaoSupport implements IntegralMallBannerDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertIntegralMallBanner(IntegralMallBannerEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		} 
		iResult = getSqlSession().insert("integralMallBanner.insertIntegralMallBanner", entity);
		return iResult;
	}
 
	@Override
	public int updateIntegralMallBannerByID(IntegralMallBannerEntity entity) {
		
		int result = 0;
		if(entity == null) {
			return result;
		}
		result = getSqlSession().update("integralMallBanner.updateIntegralMallBannerByID", entity);
		return result;
	}

	@Override
	public int deleteIntegralMallBannerByID(long id) {
		
		int result = 0;
		result = getSqlSession().delete("integralMallBanner.deleteIntegralMallBannerByID", id);
		return result;
	} 
	
	@Override
	public int updateIntegralMallBannerStatuByID(IntegralMallBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("integralMallBanner.updateIntegralMallBannerStatuByID", entity);
		return result;
	}
	@Override
	public int moveAndDownIntegralMallBanner(Map<String, Object> map) {
		
		int result = -1;
		getSqlSession().update("integralMallBanner.moveAndDownIntegralMallBanner", map);
		result=IntegerAndString.StringToInt(map.get("result").toString(),-1);
		return result;
	}
 
}
