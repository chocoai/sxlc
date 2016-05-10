package cn.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.membermng.model.IncomeReplayPlanEntity;
import cn.membermng.model.MyAccountHomeEntity;
import cn.springmvc.model.SafetyCertificationSetEntity;
import cn.springmvc.service.MyAccountHomeService;
import cn.springmvc.util.MemberSessionMng;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

/**
 * 
* @Description: 我的账户首页
* @since 
* @date 2016-5-5 下午4:10:23
 */
@Controller
@RequestMapping("accountOverview")
public class AccountOverviewController {
	
	@Resource(name="myAccountHomeServiceImpl")
	MyAccountHomeService myAccountHomeService;
	
	
	@RequestMapping("/accountOverview")
	public String accountOverview(){
		return "account/accountOverview/accountOverview";
	}
	
	
	
	/**
	 * 我的账户首页-账户信息查询 
	* selectMyAccountHome
	* @author 邱陈东  
	* * @Title: selectMyAccountHome 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午4:19:26
	* @throws
	 */
	@RequestMapping(value="selectMyAccountHome",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMyAccountHome(HttpServletRequest request){
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		MyAccountHomeEntity data = myAccountHomeService.selectMyAccountHome(memberInfo[0]);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",data);
		
		return JSONObject.toJSONString(message);
	}

	/**
	 * 查询回款计划信息 列表 （生成图表）
	* getInvestIncome
	* @author 邱陈东  
	* * @Title: getInvestIncome 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午4:28:17
	* @throws
	 */
	@RequestMapping(value="getInvestIncome",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getInvestIncome(HttpServletRequest request){
		String year = request.getParameter("year");
		SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
		if(StringUtils.isEmpty(year)){
			year=df.format(new Date());
		}else if(1970>Integer.parseInt(year)){
			year=df.format(new Date());
		}else if(2100<Integer.parseInt(year)){
			year=df.format(new Date());
		}
		
		String startTime = year+"01";
		
		String endTime = year+"12";
		
		
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		List<IncomeReplayPlanEntity> list = myAccountHomeService.getInvestIncome(memberInfo[0], startTime, endTime);
		
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 根据回款计划查询当月回款信息
	* getIncomeRecord
	* @author 邱陈东  
	* * @Title: getIncomeRecord 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午6:17:10
	* @throws
	 */
	@RequestMapping(value="getIncomeRecord",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getIncomeRecord(HttpServletRequest request){
		String time = "201601";
		if(time==null || time.equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
			time=df.format(new Date());
		}
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		List<IncomeReplayPlanEntity> list = myAccountHomeService.getIncomeRecord(memberInfo[0], time);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 查询还款计划信息列表（图表）
	* getLoanRepay
	* @author 邱陈东  
	* * @Title: getLoanRepay 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午4:29:53
	* @throws
	 */
	@RequestMapping(value="getLoanRepay",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getLoanRepay(HttpServletRequest request){
		
		
		String year = request.getParameter("year");
		SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
		if(StringUtils.isEmpty(year)){
			year=df.format(new Date());
		}else if(1970>Integer.parseInt(year)){
			year=df.format(new Date());
		}else if(2100<Integer.parseInt(year)){
			year=df.format(new Date());
		}
		
		String startTime = year+"01";
		
		String endTime = year+"12";
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		List<IncomeReplayPlanEntity> list = myAccountHomeService.getLoanRepay(memberInfo[0], startTime, endTime);
		
		/*for(int i=0;i<12;i++){
			IncomeReplayPlanEntity entity = new IncomeReplayPlanEntity();
			for(int j=i;j<list.size();i++){
			}
			entity.setMonth(i+1);
			entity.setSdRecvAmounts(3300*i+".00");
			list.add(entity);
		}*/
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 根据还款计划查询当月应还款信息
	* getRepayRecord
	* @author 邱陈东  
	* * @Title: getRepayRecord 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午6:32:52
	* @throws
	 */
	@RequestMapping(value="getRepayRecord",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getRepayRecord(HttpServletRequest request){
		String time = request.getParameter("time");
		if(time==null || time.equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
			time=df.format(new Date());
		}
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		List<IncomeReplayPlanEntity> list = myAccountHomeService.getRepayRecord(memberInfo[0], time);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
	/**
	 * 查询资金动态信息
	* getDynamicFunds
	* @author 邱陈东  
	* * @Title: getDynamicFunds 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-5 下午6:34:16
	* @throws
	 */
	@RequestMapping(value="getDynamicFunds",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getDynamicFunds(HttpServletRequest request){
		
		long[] memberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,memberInfo); 
		
		List<IncomeReplayPlanEntity> list = myAccountHomeService.getDynamicFunds(memberInfo[0]);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",list);
		
		return JSONObject.toJSONString(message);
	}
}
