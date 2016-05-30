

/** 
* @Title: ProjectAuitDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午12:58:55 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.projectPublishDao;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectImageEntity;

import product_p2p.kit.datatrans.IntegerAndString; 

/** 
 * @author 刘利 
 * @Description: 项目发布模块
 * @since 
 * @date 2016-3-23 下午12:58:55  */
@Repository("projectPublishDaoImpl")
public class ProjectPublishDaoImpl extends SqlSessionDaoSupport implements projectPublishDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

   @Override
	public int insertProjectImage(List<ProjectImageEntity> ProjectImage) {
		 
		int result = getSqlSession().insert("projectPublish.insertProjectImage",ProjectImage);
		return result;
		
	}

 
	@Override
	public int publishProject(Map<String,Object> map) {
		
	    getSqlSession().update("projectPublish.publish",map);
	    return IntegerAndString.StringToInt(map.get("result").toString(),1);  
		
	}

 	@Override
	public int updateEndtime(ProjectAppProcessEntity projectAppProcessEntity) {
 		
 		getSqlSession().selectOne("projectPublish.updateEndDate",projectAppProcessEntity);  
		return projectAppProcessEntity.getResult();
		
	}

	@Override
	public int Refuse(long applyId) {
		
		int result = getSqlSession().update("projectPublish.Refuse",applyId);
		return result;
		
	}

	 
}

