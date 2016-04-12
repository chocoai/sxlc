package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IRoleInfoDao;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;

@Component("roleInfoDaoImpl")
public class RoleInfoDaoImpl extends SqlSessionDaoSupport implements IRoleInfoDao {

	@Override
	public List<Module> getModuleList() {
		
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
	public int saveRole(RoleInfo info, String auths) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		
		param.put("rid", 		id					);
		param.put("roleNo", 	info.getRoleNo()	);
		param.put("roleName", 	info.getRoleName()	);
		param.put("roleRemark", info.getRoleRemark());
		param.put("auths", 		auths				);
		param.put("result", 1);
		getSqlSession().selectOne("roleInfoDaoImpl.saveRole", param);
		int result = IntegerAndString.StringToInt(param.get("result").toString(),1);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		 return result;

	}

	@Override
	public int editRole(RoleInfo info, String auths) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("rid", 		info.getId()		);
		param.put("roleName", 	info.getRoleName()	);
		param.put("roleRemark", info.getRoleRemark());
		param.put("auths", 		auths				);
		param.put("result", 1);
		getSqlSession().selectOne("roleInfoDaoImpl.editRole", param);
		int result =0;
		Object obj = param.get("result");
		if(obj!=null){
			result = IntegerAndString.StringToInt(obj.toString(),1);
		}
		return result;
	}

	@Override
	public int remove(RoleInfo info) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("rid", info.getId());
		param.put("result", 1);
		getSqlSession().selectOne("roleInfoDaoImpl.removeRole", param);
		int result = IntegerAndString.StringToInt(param.get("result").toString(),1);
		return result; 
	}

	@Override
	public int ofRole(RoleInfo info) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("rid", 		info.getId()		);
		param.put("statu", 		info.getRoleStatu()	);
		param.put("result", 1);
	    getSqlSession().selectOne("roleInfoDaoImpl.ofRole", param);
	    int result = IntegerAndString.StringToInt(param.get("result").toString(),1);
	    return result; 
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
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<RoleInfo> getRoleList() {
		return getSqlSession().selectList("roleInfoDaoImpl.getRoleList");
	}


}
