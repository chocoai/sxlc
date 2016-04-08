package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IAdminReadDao;
import cn.springmvc.dao.IAdminWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Resource(name="adminWriteDaoImpl")
	private IAdminWriteDao adminDao;
	
	@Resource(name="adminReadDaoImpl")
	private IAdminReadDao adminReadDao;

	@Override
	public int saveAdmin(Admin admin, String roles) {
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
		}else {
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}

	@Override
	public List<Admin> adminsByParam(PageEntity entity) {
		
		return adminReadDao.getAdminsByParam(entity);
	}

	@Override
	public int editAdmin(Admin admin, String roles) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("aid", admin.getId());
		param.put("roles", roles);
		return adminDao.editAdmin(param);
	}

	@Override
	public int ofAdmin(long id,int statu) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("statu", statu);
		return adminDao.ofAdmin(param);
	}
	
	
	@Override
	public int editAdminPassword(long adminId, String password) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("adminId", adminId);
		param.put("passsword", password);
		return adminDao.editAdminPassword(param);
	}
}
