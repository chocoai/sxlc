package cn.springmvc.dao.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.HomeBannerDao;
import cn.springmvc.model.HomeBannerEntity; 
@Repository("homeBannerDaoImpl")
public class HomeBannerDaoImpl extends SqlSessionDaoSupport implements HomeBannerDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertHomeBanner(HomeBannerEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult; 
		} 
		iResult = getSqlSession().insert("homeBanner.insertHomeBanner", entity);
		return iResult;
	}
 
	@Override
	public int updateHomeBannerByID(HomeBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("homeBanner.updateHomeBannerByID", entity);
		return result;
	}

	@Override
	public int deleteHomeBannerByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("homeBanner.deleteHomeBannerByID", id);
		return result;
	} 
	@Override
	public int updateHomeBannerStatuByID(HomeBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("homeBanner.updateHomeBannerStatuByID", entity);
		return result;
	}
	@Override
	public int moveAndDownHomeBannerByID(Map<String, Object> map) {
		
		int result = -1;
		getSqlSession().update("homeBanner.moveAndDownHomeBanner", map);
		result=IntegerAndString.StringToInt(map.get("result").toString(),-1);
		return result;
	}
 
}
