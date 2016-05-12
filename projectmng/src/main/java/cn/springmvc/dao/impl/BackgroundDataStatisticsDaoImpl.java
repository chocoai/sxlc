

/** 
* @Title: BackgroundDataStatisticsDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 上午11:51:56 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.BackgroundDataStatisticsDao; 
import cn.springmvc.model.FinancialRelatedEntity;
import cn.springmvc.model.OperationItemStatisticsEntity;  
import cn.springmvc.model.PlatformRevenueStatisticsEntity;
import cn.springmvc.model.ProjectStatisticEntity;
import cn.springmvc.model.CoutEntity;

/** 
 * @author 刘利 
 * @Description: 后台首页数据统计
 * @since 
 * @date 2016-4-27 上午11:51:56  */
@Repository("backgroundDataStatisticsDaoImpl")
public class BackgroundDataStatisticsDaoImpl extends SqlSessionDaoSupport 
				implements BackgroundDataStatisticsDao{
    
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public OperationItemStatisticsEntity selectProjectStatistic() {
		
		return getSqlSession().selectOne("backgroundData.selectProjectStatistic");
		
	}

	@Override
	public List<ProjectStatisticEntity> selectProjectCheck(PageEntity pageEntity) {
		 
			return getSqlSession().selectList("backgroundData.selectProjectCheck",pageEntity,
					new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize())); 
	}

	@Override
	public List<ProjectStatisticEntity> selectProjectLoan(PageEntity pageEntity) {
		
		return getSqlSession().selectList("backgroundData.selectProjectCheck",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize())); 
		
	}

	@Override
	public PlatformRevenueStatisticsEntity selectPlatformRevenue(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("backgroundData.selectPlatformRevenue",map);
		
	}

	@Override
	public FinancialRelatedEntity selectFinancialRelated(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backgroundData.selectFinancialRelated",map);
		
	}

	@Override
	public  CoutEntity  StaticsByDay(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsByDay",map);
		
	}

	@Override
	public  CoutEntity  StaticsByWeek(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsByWeek",map);
		
	}

	@Override
	public  CoutEntity  StaticsByMonth(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsByMonth",map);
		
	}

	@Override
	public OperationItemStatisticsEntity StaticsProjectTime(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("backgroundData.StaticsProjectTime",map);
		
	}

	@Override
	public List<CoutEntity> selectMember(Map<String, Object> map) {
		
		return getSqlSession().selectList("backgroundData.selectMember",map);
		
	}

	@Override
	public  CoutEntity  StaticsDayInvest(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsDayInvest",map);
		
	}

	@Override
	public  CoutEntity  StaticsWeekInvest(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsWeekInvest",map);
		
	}

	@Override
	public  CoutEntity  StaticsMonthInvest(Map<String, Object> map) {
		
		return getSqlSession().selectOne("backHompageData.StaticsMonthInvest",map);
		
	}

	@Override
	public List<CoutEntity> StaticsFrontAccess(Map<String, Object> map) {
		
		return getSqlSession().selectList("backgroundData.StaticsFrontAccess",map);
		
	}

	@Override
	public OperationItemStatisticsEntity StaticsProjectoney(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("backgroundData.StaticsProjectoney",map);
		
	}

	@Override
	public List<CoutEntity> selectRechargethree(Map<String, Object> map) {
		
		return getSqlSession().selectList("backgroundData.selectRechargethree",map);
		
	}

	@Override
	public List<CoutEntity> selectWithdrawalthree(Map<String, Object> map) {
		
		return getSqlSession().selectList("backgroundData.selectRechargethree",map);
		
	}
	
	 

}

