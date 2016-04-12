
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleIntegralRuleDaoImpl;
import cn.springmvc.dao.impl.HandleOverdueDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectIntegralRuleDaoImpl;
import cn.springmvc.dao.impl.SelectOverdueDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.IntegralRuleService;
import cn.springmvc.service.OverdueService;
import cn.springmvc.service.QuickRechargeFeeService;

/** 
 * 逾期设置 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("integralRuleServiceImpl")
public class IntegralRuleServiceImpl implements IntegralRuleService {
	@Resource(name="selectIntegralRuleDaoImpl")
	private SelectIntegralRuleDaoImpl  selectIntegralRuleDaoImpl;

	@Resource(name="handleIntegralRuleDaoImpl")
	private HandleIntegralRuleDaoImpl  handleIntegralRuleDaoImpl;
	/* * 
	 * 
	 *  *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.service.IntegralRuleService#findAllIntegralRule(java.util.Map) */
	@Override
	public List<IntegralRuleEntity> findAllIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectIntegralRuleDaoImpl.findAllIntegralRule(map);
	}


	@Override
	public int updateRegPointsIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.updateRegPointsIntegralRule(map);
	}


	@Override
	public int deleteIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.deleteIntegralRule(map);
	}


	@Override
	public int insetRegPointsIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.insetRegPointsIntegralRule(map);
	}


	@Override
	public int insertIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.insertIntegralRule(map);
	}

}

