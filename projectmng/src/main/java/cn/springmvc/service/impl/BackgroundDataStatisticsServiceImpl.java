

/** 
* @Title: BackgroundDataStatisticsServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 上午11:57:13 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.BackgroundDataStatisticsDao; 
import cn.springmvc.model.FinancialRelatedEntity;
import cn.springmvc.model.OperationItemStatisticsEntity; 
import cn.springmvc.model.PlatformRevenueStatisticsEntity;
import cn.springmvc.model.ProjectStatisticEntity;
import cn.springmvc.model.CoutEntity;
import cn.springmvc.service.BackgroundDataStatisticsService;

/** 
 * @author 刘利 
 * @Description: 后台首页数据统计
 * @since 
 * @date 2016-4-27 上午11:57:13  */
@Service("backgroundDataStatisticsServiceImpl")
public class BackgroundDataStatisticsServiceImpl implements
		BackgroundDataStatisticsService {

	@Resource(name="backgroundDataStatisticsDaoImpl")
	private BackgroundDataStatisticsDao backgroundDataStatisticsDao;
	@Override
	public OperationItemStatisticsEntity selectProjectStatistic() {

		return backgroundDataStatisticsDao.selectProjectStatistic();

	}
	@Override
	public void selectProjectCheck(PageEntity pageEntity) {
		
		List<ProjectStatisticEntity>  list = backgroundDataStatisticsDao.selectProjectCheck(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void selectProjectLoan(PageEntity pageEntity) {
		
		List<ProjectStatisticEntity>  list = backgroundDataStatisticsDao.selectProjectLoan(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public PlatformRevenueStatisticsEntity selectPlatformRevenue() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keys", DbKeyUtil.GetDbCodeKey());
		return backgroundDataStatisticsDao.selectPlatformRevenue(map);
		
	}
	@Override
	public FinancialRelatedEntity selectFinancialRelated(Map<String, Object> map) {
		
		map.put("keys", DbKeyUtil.GetDbCodeKey());
		return backgroundDataStatisticsDao.selectFinancialRelated(map);
		
	}
	@Override
	public  CoutEntity  StaticsByDay(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsByDay(map);
		
	}
	@Override
	public  CoutEntity  StaticsByWeek(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsByWeek(map);
		
	}
	@Override
	public  CoutEntity  StaticsByMonth(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsByMonth(map);
		
	}
	@Override
	public OperationItemStatisticsEntity StaticsProjectTime(
			Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsProjectTime(map);
		
	}
	@Override
	public List<CoutEntity> selectMember(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.selectMember(map);
		
	}
	@Override
	public  CoutEntity  StaticsDayInvest(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsDayInvest(map);
		
	}
	@Override
	public  CoutEntity  StaticsWeekInvest(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsWeekInvest(map);
		
	}
	@Override
	public  CoutEntity  StaticsMonthInvest(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsMonthInvest(map);
		
	}
	@Override
	public List<CoutEntity> StaticsFrontAccess(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsFrontAccess(map);
		
	}
	@Override
	public OperationItemStatisticsEntity StaticsProjectoney(
			Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsProjectoney(map);
		
	}
	@Override
	public List<CoutEntity> selectRechargethree(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.selectRechargethree(map);
		
	}
	@Override
	public List<CoutEntity> selectWithdrawalthree(Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.selectWithdrawalthree(map);
		
	}

}

