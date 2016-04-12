package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IDeptInfoDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.service.IDeptInfoServer;

@Service
public class DeptInfoServerImpl implements IDeptInfoServer{

	@Resource(name="deptInfoDaoImpl")
	private IDeptInfoDao deptInfoDao;
	
	
	
	@Override
	public int delDept(DeptInfo deptInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		return deptInfoDao.delDept(param);
	}
	
	@Override
	public int editDept(DeptInfo deptInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		param.put("deptName", deptInfo.getDeptName());
		param.put("principalName", deptInfo.getPrincipalName());
		param.put("principalPhone", deptInfo.getPrincipalPhone());
		param.put("deptRemark", deptInfo.getDeptRemark());
		return deptInfoDao.editDept(param);
	}
	
	
	@Override
	public List<DeptInfo> getListByParam(PageEntity entity) {
		return deptInfoDao.getListByParam(entity);
	}
	
	
	@Override
	public int ofDept(DeptInfo deptInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("id", deptInfo.getId());
		param.put("deptStatu", deptInfo.getDeptStatu());
		return deptInfoDao.ofDept(param);
	}
	
	@Override
	public int saveDept(DeptInfo deptInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		param.put("id", generatorUtil.GetId());
		param.put("deptName", deptInfo.getDeptName());
		param.put("principalName", deptInfo.getPrincipalName());
		param.put("principalPhone", deptInfo.getPrincipalPhone());
		param.put("deptRemark", deptInfo.getDeptRemark());
		param.put("deptNo", deptInfo.getDeptNo());
		param.put("preDeptId", deptInfo.getPreDeptId());
		return deptInfoDao.saveDept(param);
	}
	
	@Override
	public List<DeptInfo> findall() {
		
		return deptInfoDao.findall();
	}
	
	@Override
	public DeptInfo deprinfoById(long deptId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("deptId", deptId);
		return deptInfoDao.deptInfo(param);
	}

}

