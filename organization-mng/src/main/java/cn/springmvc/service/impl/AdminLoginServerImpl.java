package cn.springmvc.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.IAdminLoginDao;
import cn.springmvc.model.Admin;
import cn.springmvc.service.IAdminLoginService;

@Service
public class AdminLoginServerImpl implements IAdminLoginService {
	
	//@Resource(name="adminLoginImpl")
	private IAdminLoginDao adminLoginDao;

	public int adminLogin(Map<String,Object> param) {
		return adminLoginDao.Login(param);
	}
	@Override
	public Admin adminMess(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return adminLoginDao.adminMess(param);
	}
	@Override
	public int updatePwd(String adminName, String oldPwd, String newPwd) {
		return adminLoginDao.updatePwd(adminName, oldPwd, newPwd);
	}

	
	
}
