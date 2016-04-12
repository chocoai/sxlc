

/** 
* @Title: MyAccountHomeListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-7 上午10:08:47 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.membermng.model.IncomeReplayPlanEntity;
import cn.springmvc.dao.MyAccountHomeListDao;

/** 
 * @author 刘利 
 * @Description: 我的账户首页 
 * @since 
 * @date 2016-4-7 上午10:08:47  */
@Repository("myAccountHomeListDaoImpl")
public class MyAccountHomeListDaoImpl extends SqlSessionDaoSupport implements MyAccountHomeListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void selectMyAccountHome(Map<String, Object> map) {
		
		getSqlSession().selectOne("MyAccountHome.selectMyAccountHome",map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getInvestIncome(Map<String, Object> map) {
		
		return getSqlSession().selectList("HomePageList.getInvest_Income",map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getIncomeRecord(Map<String, Object> map) {
		
		return getSqlSession().selectList("HomePageList.getIncomeRecord",map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getLoanRepay(Map<String, Object> map) {
		
		return getSqlSession().selectList("HomePageList.getLoan_Repay",map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getRepayRecord(Map<String, Object> map) {
		
		return getSqlSession().selectList("HomePageList.getRepay_Record",map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getDynamicFunds(long memberID) {
		
		return getSqlSession().selectList("HomePageList.getDynamic_Funds",memberID);
		
	}
}

