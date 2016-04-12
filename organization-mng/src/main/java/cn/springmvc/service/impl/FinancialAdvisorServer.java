package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.IFinancialAdvisorReadDao;
import cn.springmvc.dao.IFinancialAdvisorWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.FinancialAdvisor;
import cn.springmvc.service.IFinancialAdvisorServer;

@Service
public class FinancialAdvisorServer implements IFinancialAdvisorServer{

	@Resource(name="financialAdvisorWriteDaoImpl")
	private IFinancialAdvisorWriteDao financialAdvisorDaol;
	
	
	@Resource(name="financialAdvisorReadDaoImpl")
	private IFinancialAdvisorReadDao financialAdvisorReadDao;
	
	
	
	@Override
	public void getListByParam(PageEntity entity) {
		 List<FinancialAdvisor> list =  financialAdvisorReadDao.getListByParam(entity);
		 PageUtil.ObjectToPage(entity, list);
	}
	
	
	@Override
	public int removeFinancialAdvisor(FinancialAdvisor advisor) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("fid", advisor.getId());
		return financialAdvisorDaol.removeFinancialAdvisor(param);
	}
	
	
	@Override
	public int saveFinancialAdvisor(FinancialAdvisor advisor) {
		Map<String,Object> param = new HashMap<String,Object>();
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		param.put("fid", id);
		param.put("staffId",advisor.getStaffId());
		param.put("financialNo", id+ IntegerAndString.getRandomNum(6));
		
		int result = financialAdvisorDaol.saveFinancialAdvisor(param);
		if(result == 0){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}
		
		return result;
	}
	
	
}

