package  cn.springmvc.dao.impl;
 
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
		
		return getSqlSession().selectList("safetyCertificationSet.selectSafetyCertificationSetList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		 
	}
	@Override
	public SafetyCertificationSetEntity selectSafetyCertificationSetbyID(long id) {
		
		return getSqlSession().selectOne("safetyCertificationSet.selectSafetyCertificationSetbyid",id); 
	}
	@Override
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetIndex() {
		
		return getSqlSession().selectList("safetyCertificationSet.selectSafetyCertificationSetIndex");
		
	}

}
