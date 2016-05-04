
package cn.springmvc.controller.recommend; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;

import product_p2p.kit.pageselect.PageEntity;
/**
 * 
* @author 杨翰林 
* @Description: 平台自有账户操作控制层
* @since 
* @date 2016-5-3 下午3:47:08
 */
@Controller
@RequestMapping("/account")
public class PlatAccountOptionController {

	/**
	 * 充值、提现模块
	 */
	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	/**
	 * 交易记录模块
	 */
	@Resource(name="guaranteeAgenciesServiceImpl")
	private GuaranteeAgenciesService guaranteeAgenciesService;
	
	/**
	 * 
	* rechargeRecordList查询充值、提现 
	* TODO查询充值、提现
	* @author 杨翰林  
	* * @Title: rechargeRecordList 
	* @Description: 查询充值、提现 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-3 下午6:37:11
	* @throws
	 */
	@RequestMapping("/rechargeRecordList")
	@ResponseBody
	public PageEntity rechargeRecordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String orderNumber = request.getParameter("orderNumber");
		String thirdMerBillno = request.getParameter("batch");
		String statu = request.getParameter("statu");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		req.put("orderNumber", orderNumber);
		req.put("thirdMerBillno", thirdMerBillno);
		req.put("statu", statu);
		req.put("startdealTime", startDate);
		req.put("enddealTime", endDate);
		req.put("dealType", 0);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.InstitutionsToRaiseCashRecords(pager);
		return pager;
	}
	
	/**
	 * 
	* tradeRecord查询交易记录 
	* TODO查询交易记录
	* @author 杨翰林  
	* * @Title: tradeRecord 
	* @Description: 查询交易记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-4 上午9:40:55
	* @throws
	 */
	@RequestMapping("/tradeRecord")
	@ResponseBody
	public PageEntity tradeRecord(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String typeName = request.getParameter("typeName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		req.put("Record_Date_Min", startDate);
		req.put("Record_Date_Max", endDate);
		req.put("typeName", typeName);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getTransaction(pager);
		return pager;
	}
}

