

/** 
* @Title: LoanServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-14 上午9:23:10 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.LoanDao;
import cn.springmvc.dao.LoanDaoList;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.LoanProjectEntity;
import cn.springmvc.service.LoanService;

/** 
 * @author 刘利 
 * @Description: 项目放款
 * @since 
 * @date 2016-4-14 上午9:23:10  */
@Service("loanServiceImpl")
public class LoanServiceImpl implements LoanService {
	@Resource(name="loanDaoImpl")
    private LoanDao loanDao;
	
	@Resource(name="loanDaoListImpl")
	private LoanDaoList loanDaoList;
	
	@Override
	public int Loan(long lApplyId, String sMerBillNo, String sOrderNos,
			int iStatu, String backInfoenc, String backinfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId(); 
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("lId", id);
		map.put("lApplyId", lApplyId);
		map.put("sMerBillNo", sMerBillNo);
		map.put("sOrderNos", sOrderNos);
		map.put("iStatu", iStatu);
		map.put("backInfoenc", backInfoenc);
		
		map.put("backinfo", backinfo);
		map.put("Skey",DbKeyUtil.GetDbCodeKey());
		int result = loanDao.Loan(map);
		
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
        return result;
	}

	@Override
	public List<LoanProjectEntity> selectLoanList(PageEntity pageEntity) {
		pageEntity.getMap().put("keys", DbKeyUtil.GetDbCodeKey());
		List<LoanProjectEntity> list = loanDaoList.selectLoanList(pageEntity);
		
		PageUtil.ObjectToPage(pageEntity, list);
		
		return list;
		
	}

}

