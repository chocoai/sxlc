package cn.springmvc.dao.impl;
 
import java.util.List; 
import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.IntegralMallBannerListDao;
import cn.springmvc.model.IntegralMallBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 积分商城查询类 
* @since 
* @date 2016-3-19 下午8:28:34
 */
@Repository("integralMallBannerListDaoImpl")
public class IntegralMallBannerListDaoImpl extends SqlSessionDaoSupport implements IntegralMallBannerListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public IntegralMallBannerEntity selectIntegralMallBannerIsExistByNAme(
			IntegralMallBannerEntity entity) {
		
		IntegralMallBannerEntity mediaReportsEntity = null;
		mediaReportsEntity = (IntegralMallBannerEntity) getSqlSession().selectOne("integralMallBanner.selectIntegralMallBannerIsExistByNAme",entity);
		return mediaReportsEntity;
	}
	@Override
	public List<IntegralMallBannerEntity> selectIntegralMallBannerAllpage(
			PageEntity pageEntity) {
		
		List<IntegralMallBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("integralMallBanner.selectIntegralMallBannerListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return homeBannerList;
	}
 
	@Override
	public IntegralMallBannerEntity selectIntegralMallBannerByID(long id) {
		
		IntegralMallBannerEntity mediaReportsEntity=null;
		mediaReportsEntity = (IntegralMallBannerEntity) getSqlSession().selectOne("integralMallBanner.selectIntegralMallBannerByid",id);
		return mediaReportsEntity; 
	}
	@Override
	public List<IntegralMallBannerEntity> selectIntegralMallBannerfront() {
		
		List<IntegralMallBannerEntity> homeBannerList = null;
		homeBannerList = getSqlSession().selectList("integralMallBanner.selectIntegralMallBannerfront");
		return homeBannerList;
		
	}
	@Override
	public int selectIntegralMallBannerindex() {
		
		Integer index = getSqlSession().selectOne("integralMallBanner.selectIntegralMallBannerindex");
		if(index == null) {
			index = 0;
		}
		return index;
	}

}
