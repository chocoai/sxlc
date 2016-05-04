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
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.MyinvestEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.MyinvestService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.RecordsBalanceService;

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
		List<MyinvestEntity> list = myinvestService.selectMyinvestCollect(entity);
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteNullStringAsEmpty);
	}
	
	
	/***
	* 查看收益计划
	* 
	* @author 李杰
	* @return
	* @date 2016-5-4 下午2:01:26
	 */
	@RequestMapping(value="revenuePlan/{investId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String revenuePlan(HttpServletRequest request,@PathVariable long investId){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		PageEntity entity = new PageEntity();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("investID", investId);
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		param.put("memberID", memberInfo.getId());
		entity.setMap(param);
		List<InvestIncomeEntity> list = myinvestService.selectInvestIncome(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
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
		List<MyinvestEntity> list = myinvestService.selectMyinvestSettled(entity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", entity.getPageNum());
		result.put("pageSize", entity.getPageSize());
		result.put("tol", entity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteNullStringAsEmpty);
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
		return JSONObject.toJSONString(result,SerializerFeature.WriteNullStringAsEmpty);
	}
	
	
	
	
	
	@RequestMapping("/revenuePlan")
	public String revenuePlan(){
		return "account/investmentManagement/revenuePlan";
	}
	
	@RequestMapping("/revenueRecord")
	public String revenueRecord(){
		return "account/investmentManagement/revenueRecord";
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
	
	
	@RequestMapping(value="/autoBidConfig",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String autoBidConfig(HttpServletRequest request){
		long 	loanType 		= IntegerAndString.StringToLong(request.getParameter("loanType"),-1);
		long 	repaymentType 	= IntegerAndString.StringToLong(request.getParameter("repaymentType"), -1);
		String	minTime			= request.getParameter("minTime");
		String  maxTIme 		= request.getParameter("maxTime");
		int 	minInterest 	= IntegerAndString.StringToInt(request.getParameter("minInterest"), -1);
		int 	maxInterest 	= IntegerAndString.StringToInt(request.getParameter("maxInterest"), -1);
		long	investmentAmount= IntegerAndString.StringToLong(request.getParameter("investmentAmount"), -1);
		long	reserveAmount	= IntegerAndString.StringToLong(request.getParameter("reserveAmount"), -1);
		
		
		return null;
	}
	
	
	
	
	@RequestMapping("/debtAttorn")
	public String debtAttorn(){
		return "account/investmentManagement/debtAttorn";
	}
	@RequestMapping("/incomeList")
	public String incomeList(){
		return "account/investmentManagement/incomeList";
	}
}
