package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.constant.Constant;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AutomaticBidSettingEntity;
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.MyinvestEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.TransferableCreditsEntity;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.service.InvestmentManagementService;
import cn.springmvc.service.MyinvestService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.service.TransferableCreditsService;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;




/***
* 
* 我的投资
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-29 下午3:45:51 
*
*/
@Controller
@RequestMapping("investmentManagement")
public class InvestmentManagementController {
	
	@Autowired
	private MyinvestService myinvestService;
	
	@Autowired
	private ProjectBaseInfoService baseInfoService;
	
	@Autowired
	private RecordsBalanceService balanceService;
	
	@Autowired
	private InvestmentManagementService investmentManagementService;
	
	@Autowired
	private TransferableCreditsService transferableCreditsService;
	
	@Autowired
	private CertificationAuditService auditService;
	
	/**
	* 我的投资
	* 
	* @author 李杰
	* @Title: myInvestment
	* @return
	* @date 2016-4-29 下午4:05:07
	 */
	@RequestMapping("/myInvestment")
	public String myInvestment(){
		return "account/investmentManagement/myInvestment";
	}
	
	
	/***
	* 我的投资-回收中 
	* 
	* @author 李杰
	* @Title: recycling
	* @param request
	* @return
	* @date 2016-4-29 下午4:27:52
	 */
	@RequestMapping(value="recycling",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String recycling(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int pageSize	= IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);
				//Integer.parseInt(request.getParameter("pageSize"));
		int cpage		= IntegerAndString.StringToInt(request.getParameter("cpage"), 1);
				//Integer.parseInt(request.getParameter("cpage"));
		int orderBy		= IntegerAndString.StringToInt(request.getParameter("order"),-1);
				//Integer.parseInt(request.getParameter("order"));
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey",DbKeyUtil.GetDbCodeKey());
		param.put("memberID", memberInfo.getId());
		param.put("order", orderBy);
		entity.setMap(param);
		List<MyinvestEntity> list = myinvestService.selectMyinvestCollect(entity);
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		String resultJSon = JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue);
		System.out.println(resultJSon);
		return resultJSon;
	}
	
	
	/***
	* 回收中的投资-查看收益计划
	* 
	* @author 李杰
	* @return
	* @date 2016-5-4 下午2:01:26
	 */
	@RequestMapping(value="revenuePlan/{investId:[0-9]+}/{cpage:[0-9]+}",produces = "text/html;charset=UTF-8")
	public String revenuePlan(HttpServletRequest request,@PathVariable long investId,@PathVariable int cpage){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(10);
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("investID", investId);
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		param.put("memberID", memberInfo.getId());
		entity.setMap(param);
		List<InvestIncomeEntity> list = myinvestService.selectInvestIncome(entity);
		request.setAttribute("list", list);
		request.setAttribute("tol", entity.getRecordsTotal());
		request.setAttribute("cpage", cpage);
		request.setAttribute("pageSize", 10);
		return "account/investmentManagement/revenuePlan";
	}
	
	
	/***
	* 我的投资-已结清
	* 
	* @author 李杰
	* @Title: settled
	* @param request
	* @return
	* @date 2016-4-29 下午4:37:10
	*/
	@RequestMapping(value="settled",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String settled(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int pageSize	= IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);
		int cpage		= IntegerAndString.StringToInt(request.getParameter("cpage"), 1);
		int orderBy		= IntegerAndString.StringToInt(request.getParameter("order"),-1);
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey",DbKeyUtil.GetDbCodeKey());
		param.put("memberID", memberInfo.getId());
		param.put("order", orderBy);
		entity.setMap(param);
		List<MyinvestEntity> list = myinvestService.selectMyinvestSettled(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 已结清的投资-收益记录
	* 
	* @author 李杰
	* @return
	* @date 2016-5-9 下午2:13:56
	*/
	@RequestMapping(value="/revenueRecord/{investId:[0-9]+}/{cpage:[0-9]+}")
	public String revenueRecord(HttpServletRequest request,@PathVariable long investId,@PathVariable int cpage){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(10);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey", 	  DbKeyUtil.GetDbCodeKey());
		param.put("investID", investId);
		param.put("memberID", memberInfo.getId());
		entity.setMap(param);
		
		List<InvestIncomeEntity> list = myinvestService.selectRealincome(entity);
		
		request.setAttribute("list", list);
		request.setAttribute("tol", entity.getRecordsTotal());
		request.setAttribute("pageSize", entity.getPageSize());
		request.setAttribute("cpage", entity.getPageNum());
		return "account/investmentManagement/revenueRecord";
	}
	
	
	/***
	* 我的投资-投标中
	* statu			0投标中,1已流标,2 投标完成
	* @author 李杰
	* @Title: bidding
	* @param request
	* @return
	* @date 2016-4-29 下午4:47:50
	 */
	@RequestMapping(value="bidding",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String bidding(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int pageSize	= IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);
		int cpage		= IntegerAndString.StringToInt(request.getParameter("cpage"), 1);
		int orderBy		= IntegerAndString.StringToInt(request.getParameter("order"),-1);
		int statu 		= Integer.parseInt(request.getParameter("statu"));
		if(statu > 2){			
			return null;
		}
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("sKey",DbKeyUtil.GetDbCodeKey());
		param.put("memberID", memberInfo.getId());
		param.put("order", orderBy);
		param.put("statu", statu);
		entity.setMap(param);
		List<MyinvestEntity> list = myinvestService.selectMyinvesting(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 自动投标
	* 
	* @author 李杰
	* @return
	* @date 2016-4-29 下午4:52:10
	 */
	@RequestMapping("/autoBid")
	public String autoBid(HttpServletRequest request){
		//查询出设置列表信息
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		AutomaticBidSettingEntity automaticBidSettingEntity = auditService.QueryMemberAutomaticBidSetting(memberInfo.getId());
		request.setAttribute("automaticBidSettingEntity", automaticBidSettingEntity);
		//查询出借款类型列表
		List<ProjectBaseInfoEntity> projectTypes = baseInfoService.selectProjectBaseInfoCombox();
		request.setAttribute("projectTypes",projectTypes);
		//查询出可用余额
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberID", memberInfo.getId());
		param.put("memberType", memberInfo.getMemberType());
		MemberThirdAuthInfoEntity authInfoEntity = balanceService.selectMemberThirdAuthInfo(param);
		request.setAttribute("authInfoEntity", authInfoEntity);
		return "account/investmentManagement/autoBid";
	}
	
	
	/***
	* 设置自动投标
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-6 下午2:55:58
	 */
	@RequestMapping(value="/autoBidConfig",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String autoBidConfig(HttpServletRequest request){
		String	proType 	= request.getParameter("proType");											//借款类型多个逗号隔开
		String  loanType	= request.getParameter("loanType");											//还款方式多个逗号隔开
		long	everyMoney	= IntegerAndString.StringToLong(request.getParameter("everyMoney"));	//每次投资金额
		long	rateMin		= IntegerAndString.StringToLong(request.getParameter("rateMin"));		//年化利率最小值
		long	rateMax		= IntegerAndString.StringToLong(request.getParameter("rateMax"));		//年化利率最大值
		long	yearMin		= IntegerAndString.StringToLong(request.getParameter("yearMin"),-1);	//年最小值
		long	yearMax		= IntegerAndString.StringToLong(request.getParameter("yearMax"),-1);	//年最大值
		long	monthMin	= IntegerAndString.StringToLong(request.getParameter("monthMin"),-1);	//月最小值
		long	monthMax	= IntegerAndString.StringToLong(request.getParameter("monthMax"),-1);	//月最大值
		long	dayMin		= IntegerAndString.StringToLong(request.getParameter("dayMin"), -1);	//最小天
		long	dayMax		= IntegerAndString.StringToLong(request.getParameter("dayMax"), -1);	//最大天
		long	reservedMoney= IntegerAndString.StringToLong(request.getParameter("reservedMoney"));//账户预留金额
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberInfo.getId());
		param.put("proType", proType);
		param.put("status", loanType);
		param.put("everyMoney", everyMoney);
		param.put("rateMin", rateMin);
		param.put("rateMax", rateMax);
		param.put("yearMax", yearMax);
		param.put("yearMin", yearMin);
		param.put("monthMin", monthMin);
		param.put("monthMax", monthMax);
		param.put("dayMin", dayMin);
		param.put("dayMax", dayMax);
		param.put("reservedMoney", reservedMoney);
		int result = auditService.AutomaticBidSetting(param);
		
		Map<String,Object> message = new HashMap<String,Object>();
		if(result == -1){
			message.put("status", "-1");
			message.put("message", "已存在自动投标设置");
		}else if(result == -2){
			message.put("status", "-2");
			message.put("message", "还未开户，请开户");
		}else if(result == -3){
			message.put("status", "-3");
			message.put("message", "还未进行自动投标授权");
		}else if(result == 0){
			message.put("status", "0");
			message.put("message", "设置成功");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/***
	* 删除自动投标设置
	* 
	* @author 李杰
	* @return
	* @date 2016-5-10 上午9:54:38
	 */
	@RequestMapping(value="removeAutoBidConf",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String removeAutoBidConf(HttpServletRequest request){
		Map<String,Object> param = new HashMap<String, Object>();
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		param.put("memberID", memberInfo.getId());
		int result = auditService.delAutomaticBidSetting(param);
		Map<String,Object> message = new HashMap<String, Object>();
		if(result == 1){
			message.put("status", "1");
			message.put("message", "删除设置成功");
		}else{
			message.put("status", "1");
			message.put("message", "删除设置失败");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	
	/***
	* 投资管理-债权转让
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午7:46:19
	 */
	@RequestMapping("/debtAttorn")
	public String debtAttorn(){
		return "account/investmentManagement/debtAttorn";
	}
	
	
	/***
	* 投资管理-债权转让-转让中
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午7:48:33
	 */
	@RequestMapping(value="transferIn",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String transferIn(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);					//当前页
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("Member_ID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		investmentManagementService.getCreditorTransfer(entity);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("cpage", cpage);
		result.put("pageSize", pageSize);
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", entity.getResults());
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 投资管理-债权转让-可转出
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-5 下午8:25:34
	 */
	@RequestMapping(value="canTurnOut",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String canTurnOut(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);					//当前页
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("memberID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		List<TransferableCreditsEntity> list = transferableCreditsService.selectTransferableCredits(entity);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("cpage", cpage);
		result.put("pageSize", pageSize);
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
		
	
	}
	
	
	/***
	* 投资管理-债权转让-可转让-转让
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午8:51:26
	*/
	@RequestMapping(value="turnOutDebts",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String turnOutDebts(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		long extras 	= IntegerAndString.StringToLong(request.getParameter("extras"));				//转让金额
		long discount 	= IntegerAndString.StringToLong(request.getParameter("discount"));				//转让折扣
		long iId		= IntegerAndString.StringToLong(request.getParameter("iId"), 0);				//投资记录编号
		Map<String,Object> parma = new HashMap<String,Object>();
		parma.put("logId", memberInfo.getId());															//会员编号
		parma.put("investId", iId);
		parma.put("transPrincipal", extras);
		parma.put("transDiscount", discount);
		parma.put("transMaxTime", 1);					//小朱说传1								
		parma.put("surplusTime", 1);
		parma.put("surplusTimeType", 1);
		
		//1：成功 -1该债权转让不是本人 -2转让金额大于最大可转让金额
		int result = transferableCreditsService.creditorTransApp(parma);
		Map<String,Object> resultMessage = new HashMap<String,Object>();
		if(result  == 1){
			resultMessage.put("message", "转让成功");
			resultMessage.put("status", 1);
		}else if(result  == -1){
			resultMessage.put("message", "转让失败");
			resultMessage.put("status", -1);
		}else if(result  == -2){
			resultMessage.put("message", "转让金额大于可转让金额");
			resultMessage.put("status", -2);
		}else{
			resultMessage.put("message", "转让失败");
			resultMessage.put("status", -1);
		}
		return JSONObject.toJSONString(resultMessage);
	}
	
	
	/***
	* 投资管理-债权转让-已转出
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-5 下午8:03:18
	*/
	@RequestMapping(value="turnOut",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String turnOut(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);					//当前页
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("Member_ID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		investmentManagementService.getCreditorOut(entity);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("cpage", cpage);
		result.put("pageSize", pageSize);
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", entity.getResults());
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 投资管理-债权转让-已转入
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-5 下午8:05:18
	*/
	@RequestMapping(value="changeInto",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeInto(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);					//当前页
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("Member_ID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		investmentManagementService.getCreditorIn(entity);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("cpage", cpage);
		result.put("pageSize", pageSize);
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", entity.getResults());
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 投资管理-债权转让-已结清
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-5 下午8:08:42
	 */
	@RequestMapping(value="debtsSettled",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String debtsSettled(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);					//当前页
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("Member_ID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		
		investmentManagementService.getCreditorOff(entity);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("cpage", cpage);
		result.put("pageSize", pageSize);
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", entity.getResults());
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	*已转入-收益列表
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午8:12:01
	 */
	@RequestMapping("/incomeList/{investmentId:[0-9]+}/{cpage:[0-9]+}")
	public String incomeList(HttpServletRequest request,@PathVariable long investmentId,@PathVariable int cpage){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		int	pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);				//页大小
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		Map<String,Object> param = new HashMap<String,Object>();
		entity.setMap(param);
		param.put("Member_ID", memberInfo.getId());
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("Invest_Id", investmentId);				//投资记录编号
		investmentManagementService.getInvest(entity);
		
		List<InvestIncomeEntity> list = entity.getResults();
		request.setAttribute("list", list);
		request.setAttribute("tol", entity.getRecordsTotal());
		request.setAttribute("cpage", cpage);
		request.setAttribute("pageSize", 10);
		return "account/investmentManagement/incomeList";
	}


	

}
