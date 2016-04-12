package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.RecruitmentListDao;
import cn.springmvc.model.RecruitmentEntity;
@Repository("recruitmentListDaoImpl")
public class RecruitmentListDaoImpl extends SqlSessionDaoSupport  implements RecruitmentListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public RecruitmentEntity selectRecruitmentIsExistByNAme(RecruitmentEntity entity) {
		
		RecruitmentEntity recruitmentEntity = null;
		recruitmentEntity = (RecruitmentEntity) getSqlSession().selectOne("Mapper.selectRecruitmentIsExistByNAme",entity);
		return recruitmentEntity;
	}


	@Override
	public List<RecruitmentEntity> selectRecruitmentList(PageEntity pageEntity) {
		
		List<RecruitmentEntity> recruitmentList = null;
		recruitmentList = getSqlSession().selectList("Mapper.selectRecruitmentsList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return recruitmentList;
	}
	 
	@Override
	public RecruitmentEntity selectRecruitmentByID(int id) {
		
		RecruitmentEntity recruitmentEntity = null;
		recruitmentEntity = (RecruitmentEntity) getSqlSession().selectOne("Mapper.selectRecruitmentsByID",id);
		return  recruitmentEntity;
	}


}
