package  cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.ActivitiesProjectDao;
import cn.springmvc.dao.SelectProjectAppRecordDao;
import cn.springmvc.model.ActivitiesProjectEntity;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppAutoSetEntity;
import cn.springmvc.model.ProjectAppMngFeeEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;
import cn.springmvc.model.ProjectPurposeEntity;
 
@Repository("selectProjectAppRecordDaoImpl")
public class SelectProjectAppRecordDaoImpl extends SqlSessionDaoSupport  implements SelectProjectAppRecordDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<ProjectPurposeEntity> selectAllProjectPurpose(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ProjectAppRecordXML.selectAllProjectPurpose",page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}

	@Override
	public ProjectPurposeEntity selectProjectPurposeById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.selectProjectPurposeById", map);
	}

	@Override
	public ProjectAppRecordEntity selectProjectAppRecordById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.selectProjectAppRecordById", map);
	}

	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.selectProjectBaseInfoById", map);
	}

	@Override
	public ProjectAppMngFeeEntity selectProjectAppMngFeeById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.selectProjectAppMngFeeById", map);
	}

	@Override
	public ProjectAppAutoSetEntity selectProjectAppAutoSetById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.selectProjectAppAutoSetById", map);
	}

	@Override
	public List<ProjectInvestRedPackageEntity> selectProjectInvestRedPackageById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ProjectAppRecordXML.selectProjectInvestRedPackageById", map);
	}

	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachmentById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ProjectAppRecordXML.selectProjectAppAttachmentById", map);

	}
	
}
