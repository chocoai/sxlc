package  cn.springmvc.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.ProjectBaseInfoDao;
import cn.springmvc.model.ProjectBaseInfoEntity;
 
@Repository("projectBaseInfoDaoImpl")
public class ProjectBaseInfoDaoImpl extends SqlSessionDaoSupport  implements ProjectBaseInfoDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectBaseInfo(ProjectBaseInfoEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectBaseInfo.insertProjectBaseInfo", entity);
		return iResult;
	}

	@Override
	public int updateProjectBaseInfoByID(ProjectBaseInfoEntity entity) {
		int result=0;
		result=getSqlSession().update("projectBaseInfo.updateProjectBaseInfoByID", entity);
		return result;
	}

	@Override
	public int deleteProjectBaseInfoByID(long id) {
		int result=0;
		result=getSqlSession().delete("projectBaseInfo.deleteProjectBaseInfoByID", id);
		return result;
	}

	@Override
	public int updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity) {
		int result=0;
		result=getSqlSession().update("projectBaseInfo.updateProjectBaseInfoStatuByID", entity);
		return result;
	}
	@Override
	public int addProjectBaseType(Map<String, Object> map) {
		
		 getSqlSession().selectOne("projectBaseInfo.addProjectBaseType",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0); 
	}
	@Override
	public int updateProjectBaseType(Map<String, Object> map) {
		
		 getSqlSession().selectOne("projectBaseInfo.updateProjectBaseType",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0); 
		
	}

}
