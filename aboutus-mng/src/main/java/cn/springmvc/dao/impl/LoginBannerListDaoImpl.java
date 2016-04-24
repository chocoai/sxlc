package cn.springmvc.dao.impl;
 
import java.util.List; 

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.LoginBannerListDao; 
import cn.springmvc.model.LoginBannerEntity; 
@Repository("loginBannerListDaoImpl")
public class LoginBannerListDaoImpl extends SqlSessionDaoSupport implements LoginBannerListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public LoginBannerEntity selectLoginBannerIsExistByNAme(
			LoginBannerEntity entity) {
		
		LoginBannerEntity loginBannerEntity = null;
		loginBannerEntity=(LoginBannerEntity) getSqlSession().selectOne("loginBanner.selectLoginBannerIsExistByNAme",entity);
		return loginBannerEntity;
	}
	@Override
	public List<LoginBannerEntity> selectLoginBannerAllpage(
			PageEntity pageEntity) {
		
		List<LoginBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("loginBanner.selectLoginBannerListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return homeBannerList;
	}
 
	@Override
	public LoginBannerEntity selectLoginBannerByID(long id) {
		
		LoginBannerEntity loginBannerEntity = null;
		loginBannerEntity = (LoginBannerEntity) getSqlSession().selectOne("loginBanner.selectLoginBannerByID",id);
		return loginBannerEntity;
		
	}
	@Override
	public List<LoginBannerEntity> selectLoginBannerfront() {
		
		List<LoginBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("loginBanner.selectLoginBannerfront");
		return homeBannerList;
		
	}
	@Override
	public int selectLoginBannerindex() {
		
		Integer indexs = getSqlSession().selectOne("loginBanner.selectLoginBannerindex");
		if(indexs == null) {
			indexs = 0;
		}
		return indexs;
	}
}
