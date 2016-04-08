package cn.springmvc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.Util.StringUtils;
import cn.springmvc.dao.IStaffInfoDao;
import cn.springmvc.model.StaffInfo;
import cn.springmvc.service.IStaffInfoService;


@Service
public class StaffInfoServiceImpl implements IStaffInfoService{
	
	@Resource(name="staffInfoDaoImpl")
	private IStaffInfoDao staffInfoDao;
	

	@Override
	public int saveStaff(StaffInfo info,String deptId,String postId,Date joinDate) {
		String joinDate2 = StringUtils.fromtDate(null, joinDate);
		
		return staffInfoDao.saveStaff(info, deptId,postId,joinDate2, DbKeyUtil.GetDbCodeKey());
	}


	@Override
	public List<StaffInfo> StaffInfosByParam(PageEntity pageEntity) {
		return staffInfoDao.getListByParam(pageEntity);
	}


	@Override
	public int editStaff(StaffInfo info, String deptId, String posId,Date joinDate) {
		String joinDate2 = StringUtils.fromtDate(null, joinDate);
		
		return staffInfoDao.editStaff(info, deptId, posId, joinDate2, DbKeyUtil.GetDbCodeKey());
	}


	@Override
	public int quit(StaffInfo info) {
		
		return staffInfoDao.quit(info);
	}
	
}
