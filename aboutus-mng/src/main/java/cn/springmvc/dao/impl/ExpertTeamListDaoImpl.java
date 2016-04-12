package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.ExpertTeamListDao;
import cn.springmvc.model.ExpertTeamEntity;
/**
 * 
* @author 刘利 
* @Description: 实现专家顾问的查询功能
* @since 
* @date 2016-3-19 下午7:26:09
 */
@Repository("expertTeamListDaoImpl")
public class ExpertTeamListDaoImpl extends SqlSessionDaoSupport  implements ExpertTeamListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public ExpertTeamEntity selectExpertTeamIsExistByNAme(
			ExpertTeamEntity entity) {
		
		ExpertTeamEntity expertTeamEntity = null;
		expertTeamEntity = (ExpertTeamEntity) getSqlSession().selectOne("expertTeam.selectExpertTeamIsExistByNAme",entity);
		return expertTeamEntity;
	}
	@Override
	public List<ExpertTeamEntity> selectExpertTeamAllpage(
			PageEntity pageEntity) {
		
		List<ExpertTeamEntity> expertTeamList = null;
		expertTeamList=getSqlSession().selectList("expertTeam.selectExpertTeamList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return expertTeamList;
	} 
	 
	@Override
	public ExpertTeamEntity selectExpertTeamByID(int id) {
		
		ExpertTeamEntity expertTeamEntity = null;
		expertTeamEntity=(ExpertTeamEntity) getSqlSession().selectOne("expertTeam.selectExpertTeamByID",id);
		return expertTeamEntity;
	}

	@Override
	public List<ExpertTeamEntity> selectExpertTeamfront() {
		
		List<ExpertTeamEntity> expertTeamList = null;
		expertTeamList=getSqlSession().selectList("expertTeam.selectExpertTeamfront");
		return expertTeamList;
		
	} 
}
