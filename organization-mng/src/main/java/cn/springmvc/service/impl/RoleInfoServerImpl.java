package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.IRoleInfoDao;
import cn.springmvc.dao.IRoleInfoReadDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;
import cn.springmvc.service.IRoleInfoServer;

@Service("roleInfoServerImpl")
public class RoleInfoServerImpl implements IRoleInfoServer{
	
	//角色
	@Resource(name="roleInfoDaoImpl")
	private IRoleInfoDao infoDao;
	
	@Resource(name="roleInfoReadDaoImpl")
	private IRoleInfoReadDao roleInfoReadDao;
	
	//日志
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	
	@Override
	public List<Module> getModuleList() {
		return roleInfoReadDao.getModuleList();
	}

	@Override
	public List<Operation> getOperationList() {
		return roleInfoReadDao.getOperationList();
		
	}
	@Override
	public List<Module> getModuleListThree() {
		return roleInfoReadDao.getModuleListThree();
	}
	@Override
	public int editRole(RoleInfo info, String auths,InsertAdminLogEntity entity,String[] sIpInfo) {
		List<RoleInfo> list = roleInfoReadDao.getRoleInfoById(info.getId());
		RoleInfo info2 = list.get(0);
		int result = infoDao.editRole(info, auths);
		entity.setsDetail("修改角色信息：角色名称["+info2.getRoleName()+" as "+info.getRoleName()+"]");
		if(result == 1){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public void getListByParam(Map<String, Object> param,PageEntity pageEntity) {
		List<RoleInfo> list =  roleInfoReadDao.getListByParam(param,pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
	}
	
	
	@Override
	public int ofRole(RoleInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		int result = infoDao.ofRole(info);
		List<RoleInfo> list = roleInfoReadDao.getRoleInfoById(info.getId());
		RoleInfo info2 = list.get(0);
		if(info.getRoleStatu() == 0){
			entity.setsDetail("启用角色信息：角色名称["+info2.getRoleName()+"]");
		}else{
			entity.setsDetail("停用角色信息：角色名称["+info2.getRoleName()+"]");
		}
		if(result == 1){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	@Override
	public int remove(RoleInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		int result = infoDao.remove(info);
		List<RoleInfo> list = roleInfoReadDao.getRoleInfoById(info.getId());
		RoleInfo info2 = list.get(0);
		entity.setsDetail("删除角色信息：角色名称["+info2.getRoleName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public int saveRole(RoleInfo info, String auths,InsertAdminLogEntity entity,String[] sIpInfo) {
		int result = infoDao.saveRole(info, auths);
		entity.setsDetail("添加角色信息：角色名称["+info.getRoleName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}

	@Override
	public List<Module> getModuleListByID(long roleId) {
		return roleInfoReadDao.getModuleListById(roleId);
	}

	@Override
	public List<Operation> getOperationListByID(long roleId) {
		return roleInfoReadDao.getOperationListById(roleId);
	}

	@Override
	public List<RoleInfo> getRoleInfoById(long roleId) {
		return roleInfoReadDao.getRoleInfoById(roleId);
	}
	@Override
	public List<RoleAuth> getRoleAuthById(long roleId) {
		return roleInfoReadDao.getRoleAuthById(roleId);
	}

	@Override
	public List<RoleInfo> getRoleList() {
		return roleInfoReadDao.getRoleList();
	}


	
	
	
}

