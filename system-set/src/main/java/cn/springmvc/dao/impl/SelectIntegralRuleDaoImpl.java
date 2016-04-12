
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.SelectIntegralRuleDao;
import cn.springmvc.dao.SelectOverdueDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 积分规则设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("selectIntegralRuleDaoImpl")
public class SelectIntegralRuleDaoImpl extends SqlSessionDaoSupport implements SelectIntegralRuleDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	/* * 
	 * 根据会员类型，某项积分规则查询积分规则设置
	 *  *  * @param map  membertype会员类型   
	 *  type 查询类型 1:邀请注册积分规则 2:项目投资积分规则 3:债权转让投资积分规则 4:充值积分规则 5:借款积分规则
	 */
	/* *  *  * @return * @see cn.springmvc.dao.SelectIntegralRuleDao#findAllIntegralRule(java.util.Map) */
	@Override
	public List<IntegralRuleEntity> findAllIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		if((int)map.get("type")==1){
			return getSqlSession().selectList("IntegralRuleXML.selectIntegralRule", map);
		}else if ((int)map.get("type")==2) {
			return getSqlSession().selectList("IntegralRuleXML.selectproIntegralRule", map);
		}else if ((int)map.get("type")==3) {
			return getSqlSession().selectList("IntegralRuleXML.selecttraIntegralRule", map);
		}else if ((int)map.get("type")==4) {
			return getSqlSession().selectList("IntegralRuleXML.selectrecIntegralRule", map);
		}else if ((int)map.get("type")==5) {
			return getSqlSession().selectList("IntegralRuleXML.selectloaIntegralRule", map);
		}else {
			return null;
		}
		
	}
	
	
	
	

}

