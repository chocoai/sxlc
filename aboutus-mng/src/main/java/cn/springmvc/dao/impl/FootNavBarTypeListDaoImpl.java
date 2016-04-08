package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.FootNavBarTypeListDao;
import cn.springmvc.model.FootNavBarTypeEntity;
import cn.springmvc.model.PartnersEntity;
@Repository("footNavBarTypeListDaoImpl")
public class FootNavBarTypeListDaoImpl extends SqlSessionDaoSupport implements FootNavBarTypeListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public FootNavBarTypeEntity selectFootNavBarTypeIsExistByNAme(
			FootNavBarTypeEntity entity) {
		
		FootNavBarTypeEntity footNavBarTypeEntity = null;
		footNavBarTypeEntity = (FootNavBarTypeEntity) getSqlSession().selectOne("footNavBarType.selectFootNavBarTypeIsExistByNAme",entity);
		return footNavBarTypeEntity;
	}
	@Override
	public List<FootNavBarTypeEntity> selectFootNavBarTypeList(
			PageEntity pageEntity) {
		
		List<FootNavBarTypeEntity> footNavBarTypeList = null;
		footNavBarTypeList = getSqlSession().selectList("footNavBarType.selectFootNavBarTypeList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return footNavBarTypeList;
	}
	
 	@Override
	public FootNavBarTypeEntity selectFootNavBarTypeByID(
			int id) {
		
 		FootNavBarTypeEntity footNavBarTypeEntity = null;
		footNavBarTypeEntity = (FootNavBarTypeEntity) getSqlSession().selectOne("footNavBarType.selectFootNavBarTypeByID",id);
		return footNavBarTypeEntity;
		
	} 
}
