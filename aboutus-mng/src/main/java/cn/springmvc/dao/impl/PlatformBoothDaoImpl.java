package cn.springmvc.dao.impl;
 
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.PlatformBoothDao; 
import cn.springmvc.model.PlatformBoothEntity;
/**
 * 
 * @author 刘利 
 * @Description: 平台宣传点
 * @since 
 * @date 2016-3-26 下午12:15:25
 */
@Repository("platformBoothDaoImpl")
public class PlatformBoothDaoImpl extends SqlSessionDaoSupport  implements PlatformBoothDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
  
	@Override
	public int insertPlatformBooth(PlatformBoothEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("PlatformBooth.insertPlatformBooth", entity);
		return iResult;
		
	}

	@Override
	public int updatePlatformBoothByID(PlatformBoothEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().update("PlatformBooth.updatePlatformBoothByID", entity);
		return iResult;
		
	}

	@Override
	public int deletePlatformBoothByID(long sgID) {
		
		return getSqlSession().delete("PlatformBooth.deletePlatformBoothByID", sgID);
		
	}

	@Override
	public int updatePlatformBoothStatu(Map<String, Object> map) {
		
		return getSqlSession().update("PlatformBooth.updatePlatformBoothStatu", map);
		
	}
}
