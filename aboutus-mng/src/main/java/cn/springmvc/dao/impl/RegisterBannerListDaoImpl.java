package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.RegisterBannerListDao;
import cn.springmvc.model.RegisterBannerEntity;
@Repository("registerBannerListDaoImpl")
public class RegisterBannerListDaoImpl extends SqlSessionDaoSupport implements RegisterBannerListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public RegisterBannerEntity selectRegisterBannerIsExistByNAme(
			RegisterBannerEntity entity) {
		
		RegisterBannerEntity registerBannerEntity = null;
		registerBannerEntity = (RegisterBannerEntity) getSqlSession().selectOne("Mapper.selectRegisterBannerIsExistByNAme",entity);
		return registerBannerEntity;
	}
	@Override
	public List<RegisterBannerEntity> selectRegisterBannerAllpage(
			PageEntity pageEntity) {
		
		List<RegisterBannerEntity> registerBannerList = null;
		registerBannerList = getSqlSession().selectList("Mapper.selectRegisterBannerListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return registerBannerList;
	}
	
 
	@Override
	public RegisterBannerEntity selectRegisterBannerByID(int id) {
		
		RegisterBannerEntity registerBannerEntity = null;
		registerBannerEntity = (RegisterBannerEntity) getSqlSession().selectOne("Mapper.selectRegisterBannerByID",id);
	    return registerBannerEntity;
		
	}
	@Override
	public List<RegisterBannerEntity> selectRegisterBannerfront() {
		
		List<RegisterBannerEntity> registerBannerList = null;
		registerBannerList = getSqlSession().selectList("Mapper.selectRegisterBannerfront");
		return registerBannerList;
		
	}
	@Override
	public int selectRegisterBannerindex() {
		
		Integer index = getSqlSession().selectOne("Mapper.selectRegisterBannerindex");
		if(index == null) {
			index = 0;
		}
		return index;
	}

}
