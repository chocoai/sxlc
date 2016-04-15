

/** 
* @Title: ProjectPublishListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午8:54:45 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.ProjectPublishListDao;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectImageEntity;

/** 
 * @author 刘利 
 * @Description: 项目发布 
 * @since 
 * @date 2016-3-23 下午8:54:45  */
@Repository("projectPublishListDaoImpl")
public class ProjectPublishListDaoImpl  extends SqlSessionDaoSupport  implements ProjectPublishListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public List<ProjectAppRecordEntity> selectProjectPublishList(
			PageEntity pageEntity) {
		
 		List<ProjectAppRecordEntity> projectAppRecordlist =null;
 		projectAppRecordlist = getSqlSession().selectList("projectPublish.selectProjectPublishList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
 		return projectAppRecordlist;

		
	}

 	@Override
	public List<ProjectImageEntity> selectProjectImageList(long applyId) {
		
 		List<ProjectImageEntity> ProjectImagelist =null;
 		ProjectImagelist= getSqlSession().selectList("projectPublish.selectProjectImage",applyId);
 		return ProjectImagelist;
		
	}

 	@Override
	public ProjectAppProcessEntity selectProjectEndtime(long projectID) {
		
		return getSqlSession().selectOne("projectPublish.selectProjectEndtime",projectID);
		
	}

}

