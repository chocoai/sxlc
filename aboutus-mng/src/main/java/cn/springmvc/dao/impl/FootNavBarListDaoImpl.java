package cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.FootNavBarListDao;
import cn.springmvc.model.FootNavBarEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现底部导航条查询功能
* @since 
* @date 2016-3-19 下午7:46:44
 */
@Repository("footNavBarListDaoImpl")
public class FootNavBarListDaoImpl extends SqlSessionDaoSupport implements FootNavBarListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public FootNavBarEntity selectFootNavBarIsExistByNAme(
			FootNavBarEntity entity) {
		
		FootNavBarEntity footNavBarEntity = null;
		footNavBarEntity = (FootNavBarEntity) getSqlSession().
				selectOne("footNavBar.selectFootNavBarIsExistByNAme",entity);
		return footNavBarEntity;
	}
	@Override
	public List<FootNavBarEntity> selectFootNavBarList(
			PageEntity pageEntity) {
		
		List<FootNavBarEntity> footNavBarList = null;
		footNavBarList = getSqlSession().selectList("footNavBar.selectFootNavBarList",pageEntity
				,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return footNavBarList;
	}
	 
	@Override
	public FootNavBarEntity selectFootNavBarByID(long id) { 
		
		FootNavBarEntity footNavBarEntity = null;
		footNavBarEntity = (FootNavBarEntity) getSqlSession().
				selectOne("footNavBar.selectFootNavBarbyID",id);
		return footNavBarEntity;
		
	}
	@Override
	public List<FootNavBarEntity> selectFootNavBarfront() {
		
	 	List<FootNavBarEntity> footNavBarList = null;
		footNavBarList = getSqlSession().selectList("footNavBar.selectFootNavBarfront");
		return footNavBarList;
		
	} 
}
