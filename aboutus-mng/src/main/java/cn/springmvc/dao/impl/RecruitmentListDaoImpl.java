package cn.springmvc.dao.impl;
 
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
		
		return getSqlSession().selectOne("Mapper.selectRecruitmentIsExistByNAme",entity); 
	}


	@Override
	public List<RecruitmentEntity> selectRecruitmentList(PageEntity pageEntity) {
		
		return  getSqlSession().selectList("Mapper.selectRecruitmentsList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		 
	}
	 
	@Override
	public RecruitmentEntity selectRecruitmentByID(long id) {
		
		return getSqlSession().selectOne("Mapper.selectRecruitmentsByID",id);
		 
	}


}
