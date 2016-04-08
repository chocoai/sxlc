
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleQuickRechargeFeeDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("handleQuickRechargeFeeDaoImpl")
public class HandleQuickRechargeFeeDaoImpl extends SqlSessionDaoSupport implements HandleQuickRechargeFeeDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	/* *  
	 * 修改充值手续费
	 * *  * @param qFeeEntity
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleQuickRechargeFeeDao#updateQuickRechargeFee(cn.springmvc.model.QuickRechargeFeeEntity) */
	@Override
	public List<Object> updateQuickRechargeFee(Map<String, Object> map) {
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("QuickRechargeFeeXML.updateQuickRechargeFee", map);
	}
	
	

}

