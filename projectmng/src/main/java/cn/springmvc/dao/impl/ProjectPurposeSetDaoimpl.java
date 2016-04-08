package cn.springmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectPurposeSetDao;
import cn.springmvc.model.ProjectPurposeSetEntity;
@Repository("projectPurposeSetDaoimpl")
public class ProjectPurposeSetDaoimpl extends SqlSessionDaoSupport  implements ProjectPurposeSetDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectPurposeSet(ProjectPurposeSetEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectPurposeSet.insertProjectPurposeSet", entity);
		return iResult;
	}

	@Override
	public int deleteProjectPurposeSetBytype(int optionType) {
		int result=0;
		result=getSqlSession().delete("projectPurposeSet.deleteProjectPurposeSetByID", optionType);
		return result;
	}

	@Override
	public int updateProjectPurposeSetStatuCheck(List<Integer> list) {
		int result=0;
		result=getSqlSession().update("projectPurposeSet.updateProjectPurposeSetStatuBytype", list);
		return result;
	}

	@Override
	public int updateProjectPurposeSetStatu() {
		int result=0;
		result=getSqlSession().update("projectPurposeSet.updateProjectPurposeSetStatu");
		return result;
	}

}
