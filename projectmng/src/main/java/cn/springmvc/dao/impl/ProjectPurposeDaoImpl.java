
package cn.springmvc.dao.impl; 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectPurposeDao;
import cn.springmvc.model.ProjectPurposeEntity;
/**
 * 
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-18 下午7:07:42
 */
@Repository("projectPurposeDaoImpl")
public class ProjectPurposeDaoImpl extends SqlSessionDaoSupport implements ProjectPurposeDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectPurposeDao(ProjectPurposeEntity entity) {
 
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectPurpose.insertProjectPurpose", entity);
		return iResult;
	}

}

