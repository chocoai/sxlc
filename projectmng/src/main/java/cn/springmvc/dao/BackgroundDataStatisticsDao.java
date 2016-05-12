

/** 
* @Title: BackgroundDataStatisticsDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-27 上午11:30:27 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.FinancialRelatedEntity;
import cn.springmvc.model.OperationItemStatisticsEntity;
import cn.springmvc.model.PlatformRevenueStatisticsEntity;
import cn.springmvc.model.ProjectStatisticEntity;
import cn.springmvc.model.CoutEntity;

/** 
 * @author 刘利 
 * @Description: 后台首页 数据统计
 * @since 
 * @date 2016-4-27 上午11:30:27  */

public interface BackgroundDataStatisticsDao {
		
	    /** 
		 * @author 刘利   
		 * @Description: 运营项目统计 
		 * @param @return 设定文件 
		 * @return OperationItemStatisticsEntity 返回类型 
		 * @date 2016-4-27 上午11:50:26
		 */
        public OperationItemStatisticsEntity selectProjectStatistic();
        
        /**
         * 审核中借款 
         * @author 刘利   
         * @Description: TODO 
         * @param @param pageEntity
         * @param @return 设定文件 
         * @return List<ProjectStatisticEntity> 返回类型 
         * @date 2016-4-27 下午12:42:17
         */
        public List<ProjectStatisticEntity> selectProjectCheck(PageEntity pageEntity);
        
        /**
         * 待放款借款 
         * @author 刘利   
         * @Description: TODO 
         * @param @param pageEntity
         * @param @return 设定文件 
         * @return List<ProjectStatisticEntity> 返回类型 
         * @date 2016-4-27 下午12:43:12
         */
        public List<ProjectStatisticEntity> selectProjectLoan(PageEntity pageEntity);
        
        /**
         * 平台收益统计 
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return PlatformRevenueStatisticsEntity 返回类型 
         * @date 2016-4-27 下午1:58:05
         */
        public PlatformRevenueStatisticsEntity selectPlatformRevenue(Map<String,Object> map);
        /**
         * 财务相关  
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return FinancialRelatedEntity 返回类型 
         * @date 2016-4-27 下午3:31:37
         */
        public FinancialRelatedEntity selectFinancialRelated(Map<String,Object> map);
        /**
         * 累计注册会员个数（最近30天注册会员个数走势图）
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-27 下午6:32:27
         */
        public List<CoutEntity>   selectMember(Map<String,Object> map);
        /**
         * 按天统计新增会员数
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-27 下午6:32:27
         */
        public  CoutEntity    StaticsByDay(Map<String,Object> map);
        /**
         * 按周统计新增会员数
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-27 下午6:32:27
         */
        public  CoutEntity    StaticsByWeek(Map<String,Object> map);
        /**
         * 按月统计新增会员数
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-27 下午6:32:27
         */
        public  CoutEntity    StaticsByMonth(Map<String,Object> map);
         /**
          * 筛选累计成交总额（元） 
		  * 累计成功借款项目数 
		  *	累计成功还款（结清）项目数（时间段、截至当前）
          * @author 刘利   
          * @Description: TODO 
          * @param @param map
          * @param @return 设定文件 
          * @return OperationItemStatisticsEntity 返回类型 
          * @date 2016-4-27 下午7:16:15
          */
        public OperationItemStatisticsEntity StaticsProjectTime(Map<String,Object> map);
        /**
         * 按天统计新增投资
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-28 上午11:17:13
         */
        public  CoutEntity   StaticsDayInvest(Map<String,Object> map);
        
        /**
         * 按周统计新增投资
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-28 上午11:17:13
         */
        public  CoutEntity    StaticsWeekInvest(Map<String,Object> map);
        
        /**
         * 按月统计新增投资
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-28 上午11:17:13
         */
        public  CoutEntity    StaticsMonthInvest(Map<String,Object> map);
        
        /**
         *  今日前台访问量（次）（最近30天前台访问量走势图）
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-4-28 上午11:55:21
         */
        public List<CoutEntity>   StaticsFrontAccess(Map<String,Object> map);
        /**
         * 
         *  累计待还本金、待还总额（元）（待还本金+待还利息）（还款中项目）
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return OperationItemStatisticsEntity 返回类型 
         * @date 2016-4-28 下午12:06:57
         */
        public OperationItemStatisticsEntity StaticsProjectoney(Map<String,Object> map);
      
        /**
         * 充值统计（最近30天充值统计走势图）
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-5-12 上午9:49:48
         */
        public List<CoutEntity>   selectRechargethree(Map<String,Object> map);
        
        /**
         * 提现统计（最近30天提现统计走势图）
         * @author 刘利   
         * @Description: TODO 
         * @param @param map
         * @param @return 设定文件 
         * @return List<CoutEntity> 返回类型 
         * @date 2016-5-12 上午9:50:48
         */
        public List<CoutEntity>   selectWithdrawalthree(Map<String,Object> map);
}

