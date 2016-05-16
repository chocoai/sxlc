

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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.TimestampAndString;
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
		
		List<CoutEntity>  CoutEntitylist  = backgroundDataStatisticsDao.selectMember(map);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//获取有数据的时间
		List<Timestamp> listdate =  new ArrayList<Timestamp>();
 		for(int i = 0;i < CoutEntitylist.size();i++ ) { 
 			listdate.add(Timestamp.valueOf(CoutEntitylist.get(i).getDay()));
 		}
 		
 		//当前时间
 		Date date=new Date(); 
		String time=format.format(date)+" 00:00:00.0";
		
		List<CoutEntity> entitylist = new ArrayList<CoutEntity>();
		
		int j = 0;
		for(int i=29;i>=0;i--) {
		   String datestr =	TimestampAndString.timeBackTotime(time, 0, 0, -i); 
		   CoutEntity  entity =new CoutEntity();
		   if(!listdate.contains(Timestamp.valueOf(datestr))) {
			   entity.setDay(datestr);
			   entity.setCountMember(0); 
		   }else if(j<CoutEntitylist.size()) {
			   entity.setDay(CoutEntitylist.get(j).getDay());
			   entity.setCountMember(CoutEntitylist.get(j).getCountMember()); 
			   j=j+1;
		   }
		   entitylist.add(entity);
		}
		return entitylist; 
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
		
 		List<CoutEntity>  CoutEntitylist  = backgroundDataStatisticsDao.StaticsFrontAccess(map);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//获取有数据的时间
		List<Timestamp> listdate =  new ArrayList<Timestamp>();
 		for(int i = 0;i < CoutEntitylist.size();i++ ) { 
 			listdate.add(Timestamp.valueOf(CoutEntitylist.get(i).getDay()));
 		}
 		
 		//当前时间
 		Date date=new Date(); 
		String time=format.format(date)+" 00:00:00.0";
		
		List<CoutEntity> entitylist = new ArrayList<CoutEntity>();
		
		int j = 0;
		for(int i = 29;i >= 0;i--) {
		   String datestr =	TimestampAndString.timeBackTotime(time, 0, 0, -i); 
		   CoutEntity  entity =new CoutEntity();
		   if(!listdate.contains(Timestamp.valueOf(datestr))) {
			   entity.setDay(datestr);
			   entity.setCountFrontAccess(0); 
		   }else if(j < CoutEntitylist.size()) {
			   entity.setDay(CoutEntitylist.get(j).getDay());
			   entity.setCountFrontAccess(CoutEntitylist.get(j).getCountFrontAccess()); 
			   j=j+1;
		   }
		   entitylist.add(entity);
		}
		return entitylist;  
		
	}
	@Override
	public OperationItemStatisticsEntity StaticsProjectoney(
			Map<String, Object> map) {
		
		return backgroundDataStatisticsDao.StaticsProjectoney(map);
		
	}
	@Override
	public List<CoutEntity> selectRechargethree(Map<String, Object> map) {
		
		List<CoutEntity>  CoutEntitylist  = backgroundDataStatisticsDao.selectRechargethree(map);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//获取有数据的时间
		List<Timestamp> listdate =  new ArrayList<Timestamp>();
 		for(int i = 0;i < CoutEntitylist.size();i++ ) { 
 			listdate.add(Timestamp.valueOf(CoutEntitylist.get(i).getDay()));
 		}
 		
 		//当前时间
 		Date date=new Date(); 
		String time=format.format(date)+" 00:00:00.0";
		
		List<CoutEntity> entitylist = new ArrayList<CoutEntity>();
		
		int j = 0;
		for(int i = 29;i >= 0;i--) {
		   String datestr =	TimestampAndString.timeBackTotime(time, 0, 0, -i); 
		   CoutEntity  entity =new CoutEntity();
		   if(!listdate.contains(Timestamp.valueOf(datestr))) {
			   entity.setDay(datestr);
			   entity.setpRechargeFee(0); 
		   }else if(j<CoutEntitylist.size()) {
			   entity.setDay(CoutEntitylist.get(j).getDay());
			   entity.setpRechargeFee(CoutEntitylist.get(j).getpRechargeFee()); 
			   j=j+1;
		   }
		   entitylist.add(entity);
		}
		return entitylist;   
		
	}
	@Override
	public List<CoutEntity> selectWithdrawalthree(Map<String, Object> map) {
		
		List<CoutEntity>  CoutEntitylist  = backgroundDataStatisticsDao.selectWithdrawalthree(map);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//获取有数据的时间
		List<Timestamp> listdate =  new ArrayList<Timestamp>();
 		for(int i = 0;i < CoutEntitylist.size();i++ ) { 
 			listdate.add(Timestamp.valueOf(CoutEntitylist.get(i).getDay()));
 		}
 		
 		//当前时间
 		Date date=new Date(); 
		String time=format.format(date)+" 00:00:00.0";
		
		List<CoutEntity> entitylist = new ArrayList<CoutEntity>();
		
		int j = 0;
		for(int i = 29;i >= 0;i--) {
		   String datestr =	TimestampAndString.timeBackTotime(time, 0, 0, -i); 
		   CoutEntity  entity =new CoutEntity();
		   if(!listdate.contains(Timestamp.valueOf(datestr))) {
			   entity.setDay(datestr);
			   entity.setPwidthdrawFee(0); 
		   }else if(j<CoutEntitylist.size()) {
			   entity.setDay(CoutEntitylist.get(j).getDay());
			   entity.setPwidthdrawFee(CoutEntitylist.get(j).getPwidthdrawFee()); 
			   j=j+1;
		   }
		   entitylist.add(entity);
		}
		return entitylist;    
		
	}

}

