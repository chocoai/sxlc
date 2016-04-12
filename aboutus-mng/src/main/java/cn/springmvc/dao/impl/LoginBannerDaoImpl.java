package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.LoginBannerDao;
import cn.springmvc.model.LoginBannerEntity;

@Repository("loginBannerDaoImpl")
public class LoginBannerDaoImpl extends SqlSessionDaoSupport implements LoginBannerDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertLoginBanner(LoginBannerEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		} 
		iResult = getSqlSession().insert("loginBanner.insertLoginBanner", entity);
		return iResult;
	}
 
	@Override
	public int updateLoginBannerByID(LoginBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("loginBanner.updateLoginBannerByID", entity);
		return result;
	}

	@Override
	public int deleteLoginBannerByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("loginBanner.deleteLoginBannerByID", id);
		return result;
	}

	@Override
	public List<LoginBannerEntity> selectLoginBannerAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLoginBannerStatuByID(LoginBannerEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("loginBanner.updateLoginBannerStatuByID", entity);
		return result;
	}
	@Override
	public int moveAndDownLoginBannerByID(Map<String, Object> map) {
		
		int result =-1;
		getSqlSession().update("loginBanner.moveAndDownLoginBanner", map);
		result=IntegerAndString.StringToInt(map.get("result").toString(),-1);
		return result;
	}
}
