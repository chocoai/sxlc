package cn.springmvc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.organization.util.StringUtils;
import cn.springmvc.dao.IStaffInfoDao;
import cn.springmvc.dao.IStaffInfoReadDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.StaffInfo;
import cn.springmvc.service.IStaffInfoService;


@Service
public class StaffInfoServiceImpl implements IStaffInfoService{
	
	@Resource(name="staffInfoDaoImpl")
	private IStaffInfoDao staffInfoDao;
	
	@Resource(name="staffInfoReadDaoImpl")
	private IStaffInfoReadDao staffInfoReadDao;
	
	//日志
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public StaffInfo findById(long fid) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("fid", fid);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return staffInfoReadDao.findById(param);
	}

	
	@Override
	public int saveStaff(StaffInfo info,String deptId,String postId,Date joinDate,InsertAdminLogEntity entity,String[] sIpInfo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String joinDate2 = dateFormat.format(joinDate == null ? new Date():joinDate);
		int result = staffInfoDao.saveStaff(info, deptId,postId,joinDate2, DbKeyUtil.GetDbCodeKey());
		entity.setsDetail("添加员工:姓名["+info.getBaseInfo().getPersonalName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}


	@Override
	public void  StaffInfosByParam(PageEntity pageEntity) {
		List<StaffInfo> list=  staffInfoReadDao.getListByParam(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
	}

	
	@Override
	public int editStaff(StaffInfo info, String deptId, String posId,Date joinDate,InsertAdminLogEntity entity,String[] sIpInfo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String joinDate2 = dateFormat.format(joinDate == null ? new Date():joinDate);
		int result = staffInfoDao.editStaff(info, deptId, posId, joinDate2, DbKeyUtil.GetDbCodeKey());
		entity.setsDetail("修改员工信息:姓名["+info.getBaseInfo().getPersonalName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}


	@Override
	public int quit(StaffInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("sid", info.getId());
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		StaffInfo info2 = staffInfoReadDao.findById(param);
		int result = staffInfoDao.quit(info);
		entity.setsDetail("员工离职：姓名["+info2.getBaseInfo().getPersonalName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	
}
