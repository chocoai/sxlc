package cn.springmvc.dao.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProcessProjectDao;
import cn.springmvc.model.ProcessProjectEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现项目审批流程的增加、删除、修改功能业务逻辑层
* @since 
* @date 2016-3-19 下午5:21:15
 */
@Repository("processProjectDaoImpl")
public class ProcessProjectDaoImpl extends SqlSessionDaoSupport implements ProcessProjectDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProcessProject(ProcessProjectEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult; 
		}  
		iResult = getSqlSession().insert("processProject.insertProcessProject", entity);
		return iResult;
	} 
	@Override
	public int deleteProcessProjectByID(int id) {
		int result=0;
		result=getSqlSession().delete("processProject.deleteProcessProjectByID", id);
		return result;
	} 
	@Override
	public int updateProcessProjectStatuByID(ProcessProjectEntity entity) {
		int result=0;
		result=getSqlSession().update("processProject.updateProcessProjectStatuByID", entity);
		return result;
	}
	@Override
	public int moveAndDownProcessProjectByID(Map<String, Object> map) {
		int result=-1;
		getSqlSession().update("processProject.moveAndDownProcessProject", map);
		result=(Integer) map.get("result");
		return result;
	}
 
}
