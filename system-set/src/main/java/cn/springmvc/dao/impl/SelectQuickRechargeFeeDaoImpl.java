
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("selectQuickRechargeFeeDaoImpl")
public class SelectQuickRechargeFeeDaoImpl extends SqlSessionDaoSupport implements SelectQuickRechargeFeeDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	/* * 
	 * 查询充值手续费设置
	 *  *  * @return * @see cn.springmvc.dao.SelectQuickRechargeFeeDao#findAllQuickRechargeFee() */
	@Override
	public List<QuickRechargeFeeEntity> findAllQuickRechargeFee() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("QuickRechargeFeeXML.selectQuickRechargeFee");
	}

}

