package  cn.springmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeDatumDao;
import cn.springmvc.model.ProjectTypeDatumEntity;
 
@Repository("projectTypeDatumDaoImpl")
public class ProjectTypeDatumDaoImpl extends SqlSessionDaoSupport  implements ProjectTypeDatumDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}  
	@Override
	public int deleteProjectTypeDatumByID(int id) {
		int result=0;
		result=getSqlSession().delete("projectTypeDatum.deleteProjectTypeDatumByOptionType", id);
		return result;
	}
	@Override
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list) {
		int iResult = 0;
		if(list == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectTypeDatum.insertProjectTypeDatum", list);
		return iResult;
	} 
}
