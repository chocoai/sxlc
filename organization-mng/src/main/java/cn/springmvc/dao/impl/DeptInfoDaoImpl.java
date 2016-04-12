package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IDeptInfoDao;
import cn.springmvc.model.DeptInfo;

/**
 * @author Administrator
 *
 */
@Repository
public class DeptInfoDaoImpl extends SqlSessionDaoSupport implements IDeptInfoDao{
	

	@Override
	public List<DeptInfo> getListByParam(PageEntity entity) {
		
		return getSqlSession().selectList("DeptInfoDaoImpl.getListByParam", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}

	@Override
	public int saveDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.saveDept", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	@Override
	public int editDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.editDept", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	@Override
	public int delDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.delDept",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1); 
	}


	@Override
	public int ofDept(Map<String,Object> param) {

		getSqlSession().selectOne("DeptInfoDaoImpl.ofDept",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	
	
	@Override
	public List<DeptInfo> findall() {
		return getSqlSession().selectList("DeptInfoDaoImpl.findall");
	}
	
	
	@Override
	public DeptInfo deptInfo(Map<String, Object> param) {
		return getSqlSession().selectOne("DeptInfoDaoImpl.deptInfo",param);
	}
	
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	

	
}
