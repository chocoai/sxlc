package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List; 
import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.HomeBannerListDao;
import cn.springmvc.model.HomeBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 实现首页轮播图的查询
* @since 
* @date 2016-3-19 下午8:18:57
 */
@Repository("homeBannerListDaoImpl")
public class HomeBannerListDaoImpl extends SqlSessionDaoSupport implements HomeBannerListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public HomeBannerEntity selectHomeBannerIsExistByNAme(
			HomeBannerEntity entity) {
		
		HomeBannerEntity mediaReportsEntity = null;
		mediaReportsEntity = (HomeBannerEntity) getSqlSession().selectOne("homeBanner.selectHomeBannerIsExistByNAme",entity);
		return mediaReportsEntity;
	}
	@Override
	public List<HomeBannerEntity> selectHomeBannerAllpage(
			PageEntity pageEntity) {
		
		List<HomeBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("homeBanner.selectHomeBannerListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return homeBannerList;
	}
	
	 	
	@Override
	public HomeBannerEntity selectHomeBannerByID(int id) {
		
		HomeBannerEntity mediaReportsEntity = null;
		mediaReportsEntity = (HomeBannerEntity) getSqlSession().selectOne("homeBanner.selectHomeBannerByID",id);
		return mediaReportsEntity;
	}
	
	@Override
	public List<HomeBannerEntity> selectHomeBannerfront() {
		
		List<HomeBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("homeBanner.selectHomeBannerfront");
		return homeBannerList;
		
	}
	@Override
	public int selectHomeBannerindex() {
		
		Integer indexs = getSqlSession().selectOne("homeBanner.selectHomeBannerindex");
		if(indexs == null) {
			indexs = 0;
		}
		return indexs;
		
	}

}
