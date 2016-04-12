package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SafetyCertificationSetListDao;
import cn.springmvc.model.SafetyCertificationSetEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("safetyCertificationSetListDaoImpl")
public class SafetyCertificationSetListDaoImpl extends SqlSessionDaoSupport implements SafetyCertificationSetListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetAllpage(
			PageEntity pageEntity) {
		List<SafetyCertificationSetEntity> safetyCertificationSetList=null;
		safetyCertificationSetList=getSqlSession().selectList("safetyCertificationSet.selectSafetyCertificationSetList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return safetyCertificationSetList;
	}
	@Override
	public SafetyCertificationSetEntity selectSafetyCertificationSetbyID(int id) {
		 SafetyCertificationSetEntity  safetyCertificationSet=null;
		 safetyCertificationSet=getSqlSession().selectOne("safetyCertificationSet.selectSafetyCertificationSetbyid",id);
		return safetyCertificationSet;
	}

}
