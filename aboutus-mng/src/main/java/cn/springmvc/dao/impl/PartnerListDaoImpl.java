package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.PartnersListDao;
import cn.springmvc.model.PartnersEntity;
@Repository("partnerListDaoImpl")
public class PartnerListDaoImpl extends SqlSessionDaoSupport implements PartnersListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public PartnersEntity selectPartnerIsExistByNAme(PartnersEntity entity) {
		
		PartnersEntity partnersEntity = null;
		partnersEntity = (PartnersEntity) getSqlSession().selectOne("Mapper.selectPartnerIsExistByNAme",entity);
		return partnersEntity;
	}
	@Override
	public List<PartnersEntity> selectPartnerList(PageEntity pageEntity) {
		
		List<PartnersEntity> partnersList = null;
		partnersList = getSqlSession().selectList("Mapper.selectPartnersList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return partnersList;
	}  
	@Override
	public PartnersEntity selectPartnerByID(int id) {
		
		PartnersEntity partnersEntity = null;
		partnersEntity = (PartnersEntity) getSqlSession().selectOne("Mapper.selectPartnersByID",id);
		return partnersEntity;
		
	}
	@Override
	public List<PartnersEntity> selectPartnersListIndex() {
		
		return getSqlSession().selectList("Mapper.selectPartnersListIndex");
		
	} 
}
