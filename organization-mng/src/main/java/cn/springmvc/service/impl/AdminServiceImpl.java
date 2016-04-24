package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.IAdminReadDao;
import cn.springmvc.dao.IAdminWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.Admin;
import cn.springmvc.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Resource(name="adminWriteDaoImpl")
	private IAdminWriteDao adminDao;
	
	@Resource(name="adminReadDaoImpl")
	private IAdminReadDao adminReadDao;
	
	@Resource
	private OptRecordWriteDaoImpl recordWriteDaoImpl;
	
	@Override
	public int saveAdmin(Admin admin, long roles,InsertAdminLogEntity entity,String[] sIpInfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("aid", id);
		param.put("staffType", admin.getStaffType());
		param.put("staffId", admin.getStaffId());
		param.put("adminName", admin.getAdminName());
		param.put("adminPwd", admin.getAdminPwd());
		param.put("adminRemark", admin.getAdminRemark());
		param.put("adminCure", admin.getAdminCure());
		param.put("adminStatu", admin.getAdminStatu());
		param.put("roles", roles);
		
		int result = adminDao.saveAdmin(param);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
			entity.setsDetail("保存管理员"+admin.getAdminName()+"成功");
		}else {
			generatorUtil.SetIdUsedFail(id);
			entity.setsDetail("保存管理员"+admin.getAdminName()+"成功");
		}
		
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}

	@Override
	public void adminsByParam(PageEntity entity) {
		List<Admin> list = adminReadDao.getAdminsByParam(entity);
		PageUtil.ObjectToPage(entity, list);
//		return 
	}

	@Override
	public int editAdmin(Admin admin, long roles,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("aid", admin.getId());
		param.put("adminPwd", admin.getAdminPwd());
		param.put("adminRemark", admin.getAdminRemark());
		param.put("roles", roles);
		Admin tagAdmin = adminReadDao.findAdminById(admin.getId());
		int result = adminDao.editAdmin(param);
		if(result == 0){
			entity.setsDetail("修改管理员信息："+tagAdmin.getAdminName()+",成功");
		}else {
			entity.setsDetail("修改管理员信息："+tagAdmin.getAdminName()+",失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}

	
	
	@Override
	public int ofAdmin(long id,int statu,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("statu", statu);
		int result = adminDao.ofAdmin(param);
		Admin tagAdmin = adminReadDao.findAdminById(id);
		if(statu == 0){
			entity.setsDetail("停用管理员：修改对象["+tagAdmin.getAdminName()+"],操作状态[");
		}else{
			entity.setsDetail("启用管理员：修改对象["+tagAdmin.getAdminName()+"],操作状态[");
		}
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+"成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+"失败]");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	@Override
	public int editAdminPassword(long adminId, String password,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("adminId", adminId);
		param.put("passsword", password);
		int result = adminDao.editAdminPassword(param);
		Admin tagAdmin = adminReadDao.findAdminById(adminId);
		entity.setsDetail("修改管理员密码：修改对象["+tagAdmin.getAdminName()+"],操作状态[");
		if(result == 1){
			entity.setsDetail(entity.getsDetail()+"成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+"失败]");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	@Override
	public Admin findAdminById(long adminId) {
		
		return adminReadDao.findAdminById(adminId);
	}
}
