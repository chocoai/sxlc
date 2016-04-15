

/** 
* @Title: ProjectAuditListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-24 下午4:07:32 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.ProjectAuitDao;
import cn.springmvc.dao.ProjectAuitListDao;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectCheckRecordEntity;

/** 
 * @author 刘利 
 * @Description: 项目审核查询模块 
 * @since 
 * @date 2016-3-24 下午4:07:32  */
@Repository("projectAuditListDaoImpl")
public class ProjectAuditListDaoImpl extends SqlSessionDaoSupport implements ProjectAuitListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<ProjectAppRecordEntity> selectProjectAuitList(
			PageEntity pageEntity) {

 		List<ProjectAppRecordEntity> ProjectAppRecordlist =null;
 		ProjectAppRecordlist = getSqlSession().selectList("projectAudit.selectProjectAuitList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
 		return ProjectAppRecordlist;

	}
 	@Override
	public ProjectAppRecordEntity selectProjectDetailByID(int id) {

 		ProjectAppRecordEntity ProjectAppRecordEntity = null;
 		ProjectAppRecordEntity = getSqlSession().selectOne("projectAudit.selectProjectdetail",id);
		return  ProjectAppRecordEntity;

	}
 	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(
			int projectID) {
		
		List<ProjectAppAttachmentEntity>  projectAppAttachmentList = getSqlSession().selectList("projectAppAttachment.selectProjectAuitList",projectID);
		return  projectAppAttachmentList;
	}
	
 	@Override
	public List<ProjectCheckRecordEntity> selectProjectCheckRecord(
			PageEntity pageEntity) {
		
 		List<ProjectCheckRecordEntity>  projectCheckRecordList = getSqlSession().selectList("projectCheckRecord.selectProjectCheckRecord",pageEntity);
		return  projectCheckRecordList;
	 
	}
 	@Override
	public List<ProjectCheckAttachEntity> selectCheckAttachDeal(
			PageEntity pageEntity) {
		
 		List<ProjectCheckAttachEntity>  projectCheckAttachList = getSqlSession().selectList("projectCheckAttach.selectCheckAttachDeal",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return  projectCheckAttachList;
		
	}
	
 	
	@Override
	public List<ProjectCheckAttachEntity> selectCheckAttachDealDelete(
			PageEntity pageEntity) {
		
		List<ProjectCheckAttachEntity>  projectCheckAttachList = getSqlSession().selectList("projectCheckAttach.selectCheckAttachDealDelete",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return  projectCheckAttachList;
	 
	}
	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttachTotal(
			int projectID) {
		
		return getSqlSession().selectList("projectCheckAttach.selectProjectCheckAttachTotal",projectID);
		
	}
	
	@Override
	public int selectAttachindex() {
		
		return getSqlSession().selectOne("projectCheckAttach.selectAttachindex");
		
	}
}

