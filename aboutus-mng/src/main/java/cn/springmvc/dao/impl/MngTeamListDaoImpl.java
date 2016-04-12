package cn.springmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.MngTeamListDao;
import cn.springmvc.model.MngTeamEntity;
@Repository("mngTeamListDaoImpl")
public class MngTeamListDaoImpl extends SqlSessionDaoSupport implements MngTeamListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public MngTeamEntity selectMngTeamIsExistByNAme(MngTeamEntity entity) {
		
		MngTeamEntity mngTeamEntity = null;
		mngTeamEntity = (MngTeamEntity) getSqlSession().selectOne("mngTeam.selectMngTeamIsExistByNAme",entity);
		return mngTeamEntity;
	}

	@Override
	public List<MngTeamEntity> selectMngTeamAllpage(PageEntity pageEntity) {
		List<MngTeamEntity> mngTeamList = null;
		mngTeamList = getSqlSession().selectList("mngTeam.selectMngTeamList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return mngTeamList;
	}
 	@Override
	public MngTeamEntity selectMngTeamByID(int id) {
 		
 		MngTeamEntity mngTeamEntity = null;
		mngTeamEntity = (MngTeamEntity) getSqlSession().selectOne("mngTeam.selectMngTeamByID",id);
		return mngTeamEntity;
 
	} 
}
