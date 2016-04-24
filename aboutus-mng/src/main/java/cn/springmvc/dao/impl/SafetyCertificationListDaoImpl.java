package cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.SafetyCertificationListDao;
import cn.springmvc.model.SafetyCertificationEntity; 
@Repository("safetyCertificationListDaoImpl")
public class SafetyCertificationListDaoImpl extends SqlSessionDaoSupport implements SafetyCertificationListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public SafetyCertificationEntity selectSafetyCertificationIsExistByNAme(
			SafetyCertificationEntity entity) {
		
		SafetyCertificationEntity safetyCertificationEntity = null;
		safetyCertificationEntity = (SafetyCertificationEntity) getSqlSession().
				selectOne("safetyCertification.selectSafetyCertificationIsExistByNAme",entity);
		
		return safetyCertificationEntity;
	}
	@Override
	public List<SafetyCertificationEntity> selectSafetyCertificationList(
			PageEntity pageEntity) {
		
		List<SafetyCertificationEntity> safetyCertificationList = null;
		safetyCertificationList = getSqlSession().selectList("safetyCertification.selectSafetyCertificationList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
		return safetyCertificationList;
	}
	
 
	@Override
	public SafetyCertificationEntity selectSafetyCertificationByID(long id) {
		
		return getSqlSession().selectOne("safetyCertification.selectSafetyCertificationByID",id); 
	 
	}
	@Override
	public List<SafetyCertificationEntity> selectSafetyCertificationfront() {
		
		List<SafetyCertificationEntity> safetyCertificationList = null;
		safetyCertificationList = getSqlSession().selectList("safetyCertification.selectSafetyCertificationfront");
		return safetyCertificationList;
		
	} 
}
