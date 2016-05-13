
package cn.springmvc.controller.index; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.CoutEntity;
import cn.springmvc.model.FinancialRelatedEntity;
import cn.springmvc.model.OperationItemStatisticsEntity;
import cn.springmvc.model.PlatformRevenueStatisticsEntity;
import cn.springmvc.service.BackgroundDataStatisticsService;

/**
 * 
* @author 杨翰林 
* @Description: 首页控制层 
* @since 
* @date 2016-5-12 下午6:34:43
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@Resource(name="backgroundDataStatisticsServiceImpl")
	private BackgroundDataStatisticsService backgroundDataStatisticsService;
	
	/**
	 * 
	* selectProjectStatistic查询运营统计 
	* TODO查询运营统计
	* @author 杨翰林  
	* * @Title: selectProjectStatistic 
	* @Description: 查询运营统计 
	* @param @return 设定文件 
	* @return OperationItemStatisticsEntity 返回类型 
	* @date 2016-5-12 下午6:38:23
	* @throws
	 */
	@RequestMapping("/statistics")
	@ResponseBody
	public OperationItemStatisticsEntity selectProjectStatistic() {
		
		OperationItemStatisticsEntity entity = backgroundDataStatisticsService.selectProjectStatistic();
		
		return entity;
	}
	
	/**
	 * 
	* selectPlatformRevenue平台收益统计 
	* TODO平台收益统计
	* @author 杨翰林  
	* * @Title: selectPlatformRevenue 
	* @Description: 平台收益统计 
	* @param @return 设定文件 
	* @return PlatformRevenueStatisticsEntity 返回类型 
	* @date 2016-5-13 上午10:23:06
	* @throws
	 */
	@RequestMapping("/plat")
	@ResponseBody
	public PlatformRevenueStatisticsEntity selectPlatformRevenue() {
		
		PlatformRevenueStatisticsEntity entity = backgroundDataStatisticsService.selectPlatformRevenue();
		
		return entity;
	}
	
	/**
	 * 
	* selectFinancialRelated查询平台收支 
	* TODO查询平台收支
	* @author 杨翰林  
	* * @Title: selectFinancialRelated 
	* @Description: 查询平台收支 
	* @param @param req
	* @param @return 设定文件 
	* @return FinancialRelatedEntity 返回类型 
	* @date 2016-5-13 上午10:44:35
	* @throws
	 */
	@RequestMapping("/platMoney")
	@ResponseBody
	public FinancialRelatedEntity selectFinancialRelated(Map<String, Object> req) {
		
		FinancialRelatedEntity entity = backgroundDataStatisticsService.selectFinancialRelated(req);
		
		return entity;
	}
	
	/**
	 * 
	* selectFinancialRelated累计交易、投资 
	* TODO累计交易、投资
	* @author 杨翰林  
	* * @Title: selectFinancialRelated 
	* @Description: 累计交易、投资 
	* @param @param req
	* @param @return 设定文件 
	* @return FinancialRelatedEntity 返回类型 
	* @date 2016-5-13 上午10:49:22
	* @throws
	 */
	@RequestMapping("/transaction")
	@ResponseBody
	public OperationItemStatisticsEntity StaticsProjectTime(Map<String, Object> req) {
		
		OperationItemStatisticsEntity entity = backgroundDataStatisticsService.StaticsProjectTime(req);
		
		return entity;
	}
	
	/**
	 * 
	* StaticsProjectTime累计注册会员个数（最近30天注册会员个数走势图） 
	* TODO累计注册会员个数（最近30天注册会员个数走势图）
	* @author 杨翰林  
	* * @Title: StaticsProjectTime 
	* @Description: 累计注册会员个数（最近30天注册会员个数走势图） 
	* @param @param req
	* @param @return 设定文件 
	* @return OperationItemStatisticsEntity 返回类型 
	* @date 2016-5-13 上午11:23:37
	* @throws
	 */
	@RequestMapping("/vip")
	@ResponseBody
	public List<CoutEntity> selectMember(Map<String, Object> req) {
		
		List<CoutEntity> list = backgroundDataStatisticsService.selectMember(req);
		
		return list;
	}
	
	/**
	 * 
	* StaticsFrontAccess最近30天前台访问量 
	* TODO最近30天前台访问量
	* @author 杨翰林  
	* * @Title: StaticsFrontAccess 
	* @Description: 最近30天前台访问量 
	* @param @param req
	* @param @return 设定文件 
	* @return List<CoutEntity> 返回类型 
	* @date 2016-5-13 下午3:47:49
	* @throws
	 */
	@RequestMapping("/visit")
	@ResponseBody
	public List<CoutEntity> StaticsFrontAccess(Map<String, Object> req) {
		
		List<CoutEntity> list = backgroundDataStatisticsService.StaticsFrontAccess(req);
		
		return list;
	}
	
	/**
	 * 
	* StaticsFrontAccess充值统计 
	* TODO充值统计
	* @author 杨翰林  
	* * @Title: StaticsFrontAccess 
	* @Description: 充值统计 
	* @param @param req
	* @param @return 设定文件 
	* @return List<CoutEntity> 返回类型 
	* @date 2016-5-13 下午4:10:29
	* @throws
	 */
	@RequestMapping("/recharge")
	@ResponseBody
	public List<CoutEntity> selectRechargethree(Map<String, Object> req) {
		
		List<CoutEntity> list = backgroundDataStatisticsService.selectRechargethree(req);
		
		return list;
	}
	
	/**
	 * 
	* selectWithdrawalthree提现统计
	* TODO提现统计
	* @author 杨翰林  
	* * @Title: selectWithdrawalthree 
	* @Description: 提现统计 
	* @param @param req
	* @param @return 设定文件 
	* @return List<CoutEntity> 返回类型 
	* @date 2016-5-13 下午4:27:29
	* @throws
	 */
	@RequestMapping("/withdrawal")
	@ResponseBody
	public List<CoutEntity> selectWithdrawalthree(Map<String, Object> req) {
		
		List<CoutEntity> list = backgroundDataStatisticsService.selectWithdrawalthree(req);
		
		return list;
	}
	
	/**
	 * 
	* StaticsByDay按天统计新增会员 
	* TODO按天统计新增会员
	* @author 杨翰林  
	* * @Title: StaticsByDay 
	* @Description: 按天统计新增会员 
	* @param @param req
	* @param @return 设定文件 
	* @return CoutEntity 返回类型 
	* @date 2016-5-13 下午4:40:16
	* @throws
	 */
	@RequestMapping("/day")
	@ResponseBody
	public CoutEntity StaticsByDay(Map<String, Object> req) {
		
		CoutEntity coutEntity = backgroundDataStatisticsService.StaticsByDay(req);
		
		return coutEntity;
	}
	
	/**
	 * 
	* StaticsByWeek按周统计新增会员 
	* TODO按周统计新增会员
	* @author 杨翰林  
	* * @Title: StaticsByWeek 
	* @Description: 按周统计新增会员 
	* @param @param req
	* @param @return 设定文件 
	* @return CoutEntity 返回类型 
	* @date 2016-5-13 下午4:40:55
	* @throws
	 */
	@RequestMapping("/week")
	@ResponseBody
	public CoutEntity StaticsByWeek(Map<String, Object> req) {
		
		CoutEntity coutEntity = backgroundDataStatisticsService.StaticsByWeek(req);
		
		return coutEntity;
	}
	
	/**
	 * 
	* StaticsByMonth按月统计新增会员 
	* TODO按月统计新增会员
	* @author 杨翰林  
	* * @Title: StaticsByMonth 
	* @Description: 按月统计新增会员
	* @param @param req
	* @param @return 设定文件 
	* @return CoutEntity 返回类型 
	* @date 2016-5-13 下午4:41:19
	* @throws
	 */
	@RequestMapping("/month")
	@ResponseBody
	public CoutEntity StaticsByMonth(Map<String, Object> req) {
		
		CoutEntity coutEntity = backgroundDataStatisticsService.StaticsByMonth(req);
		
		return coutEntity;
	}
}

