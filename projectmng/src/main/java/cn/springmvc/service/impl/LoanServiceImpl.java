

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
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.springmvc.dao.LoanDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
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

}

