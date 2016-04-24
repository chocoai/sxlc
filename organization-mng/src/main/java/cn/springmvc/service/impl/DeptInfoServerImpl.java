package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IDeptInfoDao;
import cn.springmvc.dao.IDeptInfoReadDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.service.IDeptInfoServer;

@Service
public class DeptInfoServerImpl implements IDeptInfoServer{

	@Resource(name="deptInfoDaoImpl")
	private IDeptInfoDao deptInfoDao;
	
	@Resource(name="deptInfoReadDaoImpl")
	private IDeptInfoReadDao deptInfoReadDao;
	
	@Resource
	private OptRecordWriteDaoImpl recordWriteDaoImpl;
	
	
	@Override
	public int delDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		param.put("deptId", deptInfo.getId());
		deptInfo = deptInfoReadDao.deptInfo(param);
		entity.setsDetail("删除部门:"+deptInfo.getDeptName());
		int result = deptInfoDao.delDept(param);
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",成功");
		}else{
			entity.setsDetail(entity.getsDetail()+",失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public int editDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		param.put("deptId", deptInfo.getId());
		
		param.put("deptName", deptInfo.getDeptName());
		param.put("principalName", deptInfo.getPrincipalName());
		param.put("principalPhone", deptInfo.getPrincipalPhone());
		param.put("deptRemark", deptInfo.getDeptRemark());
		
		DeptInfo oldDeptInfo = deptInfoReadDao.deptInfo(param);
		entity.setsDetail("修改部门信息：部门名称["+oldDeptInfo.getDeptName()+" as "+deptInfo.getDeptName()+"],部门负责人名称["+oldDeptInfo.getPrincipalName()+" as "+deptInfo.getPrincipalName()+"],部门负责人电话["+oldDeptInfo.getPrincipalPhone()+" as "+deptInfo.getPrincipalPhone()+"],部门描述["+oldDeptInfo.getDeptRemark()+" as "+oldDeptInfo.getDeptRemark()+"]");
		int result = deptInfoDao.editDept(param);
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	@Override
	public List<DeptInfo> getListByParam(PageEntity entity) {
		return deptInfoReadDao.getListByParam(entity);
	}
	
	
	@Override
	public int ofDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		param.put("deptStatu", deptInfo.getDeptStatu());
		param.put("deptId", deptInfo.getId());
		
		DeptInfo oldDeptInfo = deptInfoReadDao.deptInfo(param);
		if(deptInfo.getDeptStatu() == 1){
			entity.setsDetail("启用部门:"+oldDeptInfo.getDeptName()+"成功");
		}else{
			entity.setsDetail("停用部门:"+oldDeptInfo.getDeptName()+"失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return deptInfoDao.ofDept(param);
	}
	
	@Override
	public int saveDept(DeptInfo deptInfo,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		param.put("id", id);
		param.put("deptName", deptInfo.getDeptName());
		param.put("principalName", deptInfo.getPrincipalName());
		param.put("principalPhone", deptInfo.getPrincipalPhone());
		param.put("deptRemark", deptInfo.getDeptRemark());
		param.put("deptNo", deptInfo.getDeptNo());
		param.put("preDeptId", deptInfo.getPreDeptId());
		
		int result = deptInfoDao.saveDept(param);
		if(result == 1){
			entity.setsDetail("部门添加:"+deptInfo.getDeptName()+",成功");
			generatorUtil.SetIdUsed(id);
		}else{
			entity.setsDetail("部门添加:"+deptInfo.getDeptName()+",失败");
			generatorUtil.SetIdUsedFail(id);
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public List<DeptInfo> findall() {
		
		return deptInfoReadDao.findall();
	}
	
	@Override
	public DeptInfo deprinfoById(long deptId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("deptId", deptId);
		return deptInfoReadDao.deptInfo(param);
	}

	@Override
	public List<DeptInfo> findDeptInfoByParentId(long parentId) {
		Map<String,Object> param = new HashMap<String,Object>();
		return deptInfoReadDao.findDeptInfoByParentId(param);
	}

	
}

