package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IRoleInfoReadDao;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;

@Repository
public class RoleInfoReadDaoImpl extends SqlSessionDaoSupport implements IRoleInfoReadDao{
	
	
	@Override
	public List<Module> getModuleList() {
		
		return getSqlSession().selectList("roleInfoDaoImpl.getModule");
	}

	@Override
	public List<Module> getModuleListThree() {
		return getSqlSession().selectList("roleInfoDaoImpl.getModule");
	}

	@Override
	public List<Operation> getOperationList() {
		return getSqlSession().selectList("roleInfoDaoImpl.getOperation");
	}
	@Override
	public List<RoleInfo> getListByParam(Map<String, Object> param,PageEntity entity) {
		if(entity == null){
			return null;
		}
		SqlSession session = getSqlSession();
		entity.setMap(param);
		List<RoleInfo> roleList = session.selectList("roleInfoDaoImpl.getListByParam", entity,new RowBounds(entity.getPageNum(),entity.getPageSize()));
		return roleList;
//		return getSqlSession().selectList("roleInfoDaoImpl.getListByParam", param);
	}

	@Override
	public List<Module> getModuleListById(long roleId) {
		
		return getSqlSession().selectList("roleInfoDaoImpl.getModuleById",roleId);
	}

	@Override
	public List<Operation> getOperationListById(long roleId) {
		return getSqlSession().selectList("roleInfoDaoImpl.getOperationById",roleId);
	}
	
	@Override
	public List<RoleInfo> getRoleInfoById(long roleId) {
		return getSqlSession().selectList("roleInfoDaoImpl.getRoleInfoById",roleId);
	}
	
	@Override
	public List<RoleAuth> getRoleAuthById(long roleId) {
		return getSqlSession().selectList("roleInfoDaoImpl.getRoleAuthById",roleId);
	}
	
	@Override
	public List<RoleInfo> getRoleList() {
		return getSqlSession().selectList("roleInfoDaoImpl.getRoleList");
	}


	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

