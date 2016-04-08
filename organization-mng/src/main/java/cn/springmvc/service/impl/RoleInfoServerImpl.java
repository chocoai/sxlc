package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IRoleInfoDao;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;
import cn.springmvc.service.IRoleInfoServer;

@Service("roleInfoServerImpl")
public class RoleInfoServerImpl implements IRoleInfoServer{
	
	
	@Resource(name="roleInfoDaoImpl")
	private IRoleInfoDao infoDao;
	
	
	@Override
	public List<Module> getModuleList() {
		return infoDao.getModuleList();
	}

	@Override
	public List<Operation> getOperationList() {
		return infoDao.getOperationList();
	}
	
	@Override
	public int editRole(RoleInfo info, String auths) {
		return infoDao.editRole(info, auths);
	}
	
	@Override
	public List<RoleInfo> getListByParam(Map<String, Object> param,PageEntity pageEntity) {
		return infoDao.getListByParam(param,pageEntity);
	}
	
	
	@Override
	public int ofRole(RoleInfo info) {
		return infoDao.ofRole(info);
	}
	
	
	@Override
	public int remove(RoleInfo info) {
		return infoDao.remove(info);
	}
	
	@Override
	public int saveRole(RoleInfo info, String auths) {
		return infoDao.saveRole(info, auths);
	}

	@Override
	public List<Module> getModuleListByID(long roleId) {
		return infoDao.getModuleListById(roleId);
	}

	@Override
	public List<Operation> getOperationListByID(long roleId) {
		return infoDao.getOperationListById(roleId);
	}

	@Override
	public List<RoleInfo> getRoleInfoById(long roleId) {
		return infoDao.getRoleInfoById(roleId);
	}
	@Override
	public List<RoleAuth> getRoleAuthById(long roleId) {
		return infoDao.getRoleAuthById(roleId);
	}
	
}

