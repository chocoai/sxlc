
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleIntegralRuleDao;
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
@Component("handleIntegralRuleDaoImpl")
public class HandleIntegralRuleDaoImpl extends SqlSessionDaoSupport implements HandleIntegralRuleDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updateRegPointsIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("IntegralRuleXML.updateRegPointsIntegralRule", map);
	}

	@Override
	public int deleteIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("IntegralRuleXML.deleteIntegralRule", map);
	}

	@Override
	public int insetRegPointsIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("IntegralRuleXML.insetRegPointsIntegralRule", map);
	}

	@Override
	public int insertIntegralRule(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("IntegralRuleXML.insertIntegralRule", map);
	}

	
	
	
	
	

}

