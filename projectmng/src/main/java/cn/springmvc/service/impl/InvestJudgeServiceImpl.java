

/** 
* @Title: InvestJudgeServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午11:00:36 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.springmvc.dao.impl.ActivitiesProjectDaoImpl;
import cn.springmvc.dao.impl.InvestJudgeListDaoImpl;
import cn.springmvc.service.ActivitiesProjectService;
import cn.springmvc.service.InvestJudgeService;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-25 上午11:00:36  */
@Service("investJudgeServiceImpl")
public class InvestJudgeServiceImpl implements InvestJudgeService{
	@Resource(name="investJudgeListDaoImpl")
	private InvestJudgeListDaoImpl investJudgeListDaoImpl;

 	
	@Override
	public long selectInvestAmountByMemID(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return investJudgeListDaoImpl.selectInvestAmountByMemID(map);
		
	}


 	@Override
	public int selectInvestCountByApplyID(long applyID) {
		
 		return investJudgeListDaoImpl.selectInvestCountByApplyID(applyID);
		
	}

 	@Override
	public Map<String, Object> selectGiftInfobyID(Map<String, Object> map) {
		
		return investJudgeListDaoImpl.selectGiftInfobyID(map);
		
	}


	 	
	@Override
	public int selectRedpacketsRateMax() {
		
		return investJudgeListDaoImpl.selectRedpacketsRateMax();
		
	}  
}

