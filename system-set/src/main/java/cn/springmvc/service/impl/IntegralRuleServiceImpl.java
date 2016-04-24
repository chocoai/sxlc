
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleIntegralRuleDaoImpl;
import cn.springmvc.dao.impl.HandleOverdueDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
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
 * 积分规则设置
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
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
	public int updateRegPointsIntegralRule(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("修改邀请注册积分规则 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.updateRegPointsIntegralRule(map);
	}


	@Override
	public int deleteIntegralRule(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("根据id删除积分规则 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.deleteIntegralRule(map);
	}


	@Override
	public int insetRegPointsIntegralRule(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("添加  邀请注册积分规则 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.insetRegPointsIntegralRule(map);
	}


	@Override
	public int insertIntegralRule(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("添加 项目投资积分membertype 0:推荐达人  1:理财顾问 2:会员 ;type 1:邀请注册积分规则 2:项目投资积分规则 3:债权转让投资积分规则 4:充值积分规则 5:借款积分规则 "+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleIntegralRuleDaoImpl.insertIntegralRule(map);
	}

}

