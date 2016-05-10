
package cn.springmvc.controller.financialmanagement; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.springmvc.service.CommissionissuedService;

/**
 * 
* @author 杨翰林 
* @Description: 佣金发放记录控制层 
* @since 
* @date 2016-5-5 上午11:50:55
 */
@Controller
@RequestMapping("/commissionRecord")
public class CommissionRecordController {

	@Resource(name="commissionissuedServiceImpl")
	private CommissionissuedService commissionissuedService;
	
	/**
	 * 
	* recordList佣金发放记录 
	* TODO佣金发放记录
	* @author 杨翰林  
	* * @Title: recordList 
	* @Description: 佣金发放记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-5 下午1:42:43
	* @throws
	 */
	@RequestMapping("/record")
	@ResponseBody
	public PageEntity recordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String memberNo = request.getParameter("memberNo");
		String personalName = request.getParameter("personalName");
		String personalPhone = request.getParameter("personalPhone");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String tstartDate = request.getParameter("tstartDate");
		String tendDate = request.getParameter("tendDate");
		String types = request.getParameter("types");
		
		req.put("Member_No", memberNo);
		req.put("Personal_Phone", personalPhone);
		req.put("Personal_Name", personalName);
		req.put("Pay_Date_Min", startDate);
		req.put("Pay_Date_Max", endDate);
		req.put("Start_Date", tstartDate);
		req.put("End_Date", tendDate);
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		if (types .equals("0")) {
			List<AwardPaymentRecordEntity> list = commissionissuedService.getAwardRecordAdvisor(pager);
			pager.setResults(list);
		}else {
			List<AwardPaymentRecordEntity> list = commissionissuedService.getAwardRecordsInvite(pager);
			pager.setResults(list);
		}
		
		return pager;
	}
}

