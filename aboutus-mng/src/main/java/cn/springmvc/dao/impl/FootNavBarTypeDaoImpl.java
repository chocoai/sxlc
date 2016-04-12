package cn.springmvc.dao.impl; 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.FootNavBarTypeDao;
import cn.springmvc.model.FootNavBarTypeEntity; 
@Repository("footNavBarTypeDaoImpl")
public class FootNavBarTypeDaoImpl extends SqlSessionDaoSupport implements FootNavBarTypeDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertFootNavBarType(FootNavBarTypeEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("footNavBarType.insertFootNavBarType", entity);
		return iResult;
	} 
	@Override
	public int updateFootNavBarTypeByID(FootNavBarTypeEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("footNavBarType.updateFootNavBarTypeByID", entity);
		return result;
	}

	@Override
	public int deleteFootNavBarTypeByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("footNavBarType.deleteFootNavBarTypeByID", id);
		return result;
	} 
	@Override
	public int updateFootNavBarTypeStatuByID(FootNavBarTypeEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("footNavBarType.updateFootNavBarTypeStatuByID", entity);
		return result;
	}
 
}
