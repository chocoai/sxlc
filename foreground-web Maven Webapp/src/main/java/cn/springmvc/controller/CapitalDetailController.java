package cn.springmvc.controller; 

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import cn.membermng.model.MemberMsgRecordEntity;
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;
import cn.springmvc.service.CapitalbudgetdetailsService;
import cn.springmvc.util.MemberSessionMng;

/**
 * 我的账户-资金管理-资金记录
* @author 邱陈东 
* @since 
* @date 2016-5-9 上午11:28:32
 */

@Controller
@RequestMapping(value="/capitalDetail")
public class CapitalDetailController {

	@Resource(name="capitalbudgetdetailsServiceImpl")
	CapitalbudgetdetailsService capitalbudgetdetailsService;
	
	
	/**
	 * 查询会员交易记录
	* selectMemberTradingRecords
	* @author 邱陈东  
	* * @Title: selectMemberTradingRecords 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 上午11:58:49
	* @throws
	 */
	@RequestMapping(value="/selectMemberTradingRecords",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMemberTradingRecords(HttpServletRequest request){
		String tradeTypeId = request.getParameter("tradeTypeId");//交易类型：-1全部
		if(tradeTypeId==null||tradeTypeId.equals("")){
			tradeTypeId="-1";
		}
		String startrecordDate = request.getParameter("startTime");//开始时间
		String endrecordDate = request.getParameter("endTime");//结束时间
		
		String recorddays = request.getParameter("recorddays");//(近几周，几月，转换为天数)
		
		String order=request.getParameter("order");
		//(  1交易金额 降序,-1交易金额 升序，2 冻结金额 降序，-2 冻结金额 升序， 3待收本金 降序，-3 待收本金升序
		//   4待收利息 降序,-4待收利息 升序，5 账户可用金额  降序，-5 账户可用金额 升序， 6待还本金 降序，-6 待还本金 升序
		 //  7待还利息 降序,-7待还利息 升序，8 待还逾期利息  降序，-8待还逾期利息 升序， 9待还逾期罚息 降序， -9 待还逾期罚息 升序
		 //  10总金额 降序,-10 总金额 升序)
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberID",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		
		if(!StringUtils.isEmpty(tradeTypeId)){
			param.put("tradeTypeId",tradeTypeId);
		}
		if(!StringUtils.isEmpty(startrecordDate)){
			param.put("startrecordDate",startrecordDate);
		}
		if(!StringUtils.isEmpty(endrecordDate)){
			param.put("endrecordDate",endrecordDate);
		}
		if(!StringUtils.isEmpty(recorddays)){
			param.put("recorddays",recorddays);
		}
		if(!StringUtils.isEmpty(order)){
			param.put("order",order);
		}

		
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start/length+1);
		entity.setPageSize(length);
		
		List<MemberTradingRecordsEntity> list = capitalbudgetdetailsService.selectMemberTradingRecords(entity);
		PageUtil.ObjectToPage(entity, list);
		entity.getMap().remove("sKey");
		
		return JSONObject.toJSONString(entity);
		
	}
	
	/**
	 * 根据交易记录的ID查询会员交易记录详情
	* selectTradingRecordsdetail
	* @author 邱陈东  
	* * @Title: selectTradingRecordsdetail 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午1:32:13
	* @throws
	 */
	@RequestMapping(value="/selectTradingRecordsdetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectTradingRecordsdetail(HttpServletRequest request){
		String tradeId = request.getParameter("tradeId");
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tradeID", tradeId);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		
		MemberTradingRecordsEntity entity = capitalbudgetdetailsService.selectTradingRecordsdetail(map);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "读取成功");
		message.put("data",entity);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 分页查询会员充值记录
	* selectRechargeList
	* @author 邱陈东  
	* * @Title: selectRechargeList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午2:12:16
	* @throws
	 */
	@RequestMapping(value="/selectRechargeList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectRechargeList(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		//筛选条件
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String statu = request.getParameter("statu");//-1所有 0：失败 1：成功 	
		String order = request.getParameter("order");//排序  1充值金额 降序,-1充值金额 升序，2 交易时间 降序，-2 交易时间 升序， 3实际到账金额 降序，-3 实际到账金额 升序
		String thirdMerBillno = request.getParameter("thirdMerBillno");//第三方交易流水号
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberID",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		
		if(!StringUtils.isEmpty(startDate)){
			param.put("startTime",startDate);
		}
		if(!StringUtils.isEmpty(endDate)){
			param.put("endtimeTime",endDate);
		}
		if(!StringUtils.isEmpty(statu)){
			param.put("statu",statu);
		}
		if(!StringUtils.isEmpty(order)){
			param.put("order",order);
		}
		if(!StringUtils.isEmpty(thirdMerBillno)){
			param.put("threeNum",thirdMerBillno);
		}
		PageEntity pager = new PageEntity();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		
		
		List<MemberWithdrawalRechargeEntity> list = capitalbudgetdetailsService.selectRechargeList(pager);
		
		PageUtil.ObjectToPage(pager, list);
		pager.getMap().remove("sKey");
		
		return JSONObject.toJSONString(pager);
	}
	
	/**
	 * 分页查询会员提现记录
	* selectWithdrawalList
	* @author 邱陈东  
	* * @Title: selectWithdrawalList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午2:32:57
	* @throws
	 */
	@RequestMapping(value="/selectWithdrawalList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectWithdrawalList(HttpServletRequest request){
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		//筛选条件
		//申请时间
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		String statu = request.getParameter("statu");//-1所有 
		String order = request.getParameter("order");//排序  1充值金额 降序,-1充值金额 升序，2 交易时间 降序，-2 交易时间 升序， 3实际到账金额 降序，-3 实际到账金额 升序
		String threeNum = request.getParameter("threeNum");//第三方交易流水号
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberID",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		param.put("sKey", DbKeyUtil.GetDbCodeKey());
		
		if(!StringUtils.isEmpty(startDate)){
			param.put("startTime",startDate);
		}
		if(!StringUtils.isEmpty(endDate)){
			param.put("endtimeTime",endDate);
		}

		if(!StringUtils.isEmpty(statu)){
			param.put("statu",statu);
		}
		if(!StringUtils.isEmpty(order)){
			param.put("order",order);
		}
		if(!StringUtils.isEmpty(threeNum)){
			param.put("threeNum",threeNum);
		}
		PageEntity pager = new PageEntity();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		
		
		List<MemberWithdrawalRechargeEntity> list = capitalbudgetdetailsService.selectWithdrawalList(pager);
		
		PageUtil.ObjectToPage(pager, list);
		pager.getMap().remove("sKey");
		
		return JSONObject.toJSONString(pager);
	}
	/**
	 * 查询充值 提现的到账金额以及手续费
	* selectAllDealInfoAndFree
	* @author 邱陈东  
	* * @Title: selectAllDealInfoAndFree 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午3:35:33
	* @throws
	 */
	@RequestMapping(value="/selectAllDealInfoAndFree",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectAllDealInfoAndFree(HttpServletRequest request){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberID",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		Map<String,Object> rechargeData=capitalbudgetdetailsService.selectTotalRechargeInfo(param);
		Map<String,Object> withdrawalData=capitalbudgetdetailsService.selectTotalWithdrawalInfo(param);
		
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("rechargeFee", rechargeData.get("totalfee"));							//充值手续费
		data.put("rechargeMoney", rechargeData.get("totalrecharge"));				//实际到账充值总额
		
		data.put("withdrawalFee", withdrawalData.get("totalfee"));					//提现手续费
		data.put("withdrawalMoney", withdrawalData.get("totalWithdrawal")); //实际到账提现总额
		
		return JSONObject.toJSONString(data);
	}
	
}

