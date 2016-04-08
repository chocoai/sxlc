package cn.springmvc.dao.impl; 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.FootNavBarDao;
import cn.springmvc.model.FootNavBarEntity; 
@Repository("footNavBarDaoImpl")
public class FootNavBarDaoImpl extends SqlSessionDaoSupport implements FootNavBarDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertFootNavBar(FootNavBarEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("footNavBar.insertFootNavBar", entity);
		return iResult;
	} 
	@Override
	public int updateFootNavBarByID(FootNavBarEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("footNavBar.updateFootNavBarByID", entity);
		return result;
	}

	@Override
	public int deleteFootNavBarByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("footNavBar.deleteFootNavBarByID", id);
		return result;
	} 
	@Override
	public int updateFootNavBarStatuByID(FootNavBarEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("footNavBar.updateFootNavBarStatuByID", entity);
		return result;
	}
 
}
