package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IDeptInfoReadDao;
import cn.springmvc.model.DeptInfo;



@Repository
public class DeptInfoReadDaoImpl extends SqlSessionDaoSupport implements IDeptInfoReadDao{

	@Override
	public List<DeptInfo> getListByParam(PageEntity entity) {
		
		return getSqlSession().selectList("DeptInfoDaoImpl.getListByParam", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	
	
	@Override
	public List<DeptInfo> findall() {
		return getSqlSession().selectList("DeptInfoDaoImpl.findall");
	}
	
	
	@Override
	public DeptInfo deptInfo(Map<String, Object> param) {
		return getSqlSession().selectOne("DeptInfoDaoImpl.deptInfo",param);
	}
	
	
	
	
	@Override
	public List<DeptInfo> findDeptInfoByParentId(Map<String, Object> param) {
		return getSqlSession().selectList("DeptInfoDaoImpl.findDeptListByParantId",param);
	}	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}

