package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.IFinancialAdvisorReadDao;
import cn.springmvc.dao.IFinancialAdvisorWriteDao;
import cn.springmvc.dao.IStaffInfoDao;
import cn.springmvc.dao.IStaffInfoReadDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.FinancialAdvisor;
import cn.springmvc.model.StaffInfo;
import cn.springmvc.service.IFinancialAdvisorServer;

@Service
public class FinancialAdvisorServer implements IFinancialAdvisorServer{

	@Resource(name="financialAdvisorWriteDaoImpl")
	private IFinancialAdvisorWriteDao financialAdvisorDaol;
	
	
	@Resource(name="financialAdvisorReadDaoImpl")
	private IFinancialAdvisorReadDao financialAdvisorReadDao;
	
	
	@Resource(name="staffInfoReadDaoImpl")
	private IStaffInfoReadDao staffInfoReadDao;
	
	
	@Resource
	private OptRecordWriteDaoImpl recordWriteDaoImpl;
	
	
	
	@Override
	public void getListByParam(PageEntity entity) {
		 List<FinancialAdvisor> list =  financialAdvisorReadDao.getListByParam(entity);
		 PageUtil.ObjectToPage(entity, list);
	}
	
	
	@Override
	public int removeFinancialAdvisor(FinancialAdvisor advisor,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("fid", advisor.getId());
		FinancialAdvisor advisor2 = financialAdvisorReadDao.findById(param);
		
		int result = financialAdvisorDaol.removeFinancialAdvisor(param);
		if(result == 0){
			entity.setsDetail("移除理财师："+advisor2.getServiceNickname()+",成功");
		}else{
			entity.setsDetail("移除理财师："+advisor2.getServiceNickname()+",失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
	@Override
	public int saveFinancialAdvisor(FinancialAdvisor advisor,InsertAdminLogEntity entity,String[] sIpInfo) {
		Map<String,Object> param = new HashMap<String,Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		param.put("fid", id);
		param.put("staffId",advisor.getStaffId());
		param.put("financialNo", id+ IntegerAndString.getRandomNum(6));
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		//StaffInfo info = staffInfoReadDao.findById(param);
		
		int result = financialAdvisorDaol.saveFinancialAdvisor(param);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
			entity.setsDetail("添加理财师:员工id为"+id+",成功");
		}else{
			generatorUtil.SetIdUsedFail(id);
			entity.setsDetail("添加理财师:员工id为"+id+",失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	
}

