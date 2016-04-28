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

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.InvestListService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.projectDetailService;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/***
* 
* 投资专区信息
* 
* @author 李杰
* @since 
* @date 2016-4-27 下午2:03:14 
*
*/
@Controller
@RequestMapping("invest")
public class InvestController {
	
	
	@Autowired
	private InvestListService investListService;
	
	@Autowired
	private projectDetailService detailService;
	
	@Autowired
	private ProjectBaseInfoService baseInfoService;
	
	
	/***
	* 投资专区首页
	* <br>查询出广告列表 然后去页面显示
	* @author 李杰
	* @Title: investmentZone
	* @return
	* @date 2016-4-27 下午2:02:22
	 */
	@RequestMapping(value="/investmentZone",method=RequestMethod.GET)
	public String investmentZone(HttpServletRequest req){
		//加载广告列表
		
		//查询出借款类型
		List<ProjectBaseInfoEntity> project = baseInfoService.selectProjectBaseInfoCombox();
		req.setAttribute("projectBaseInfos", project);
		return "invest/investmentZone";
	}
	
	
	
	
	/***
	* 根据条件查询投资列表
	* 
	* @author 李杰
	* @return
	* @date 2016-4-27 下午2:17:23
	 */
	@RequestMapping(value="fundList",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String fundList(HttpServletRequest request){
		String wd				=	request.getParameter("wd");						//赛选条件名称(项目名称)
		String projectStatu		= 	request.getParameter("projectStatu");			//项目状态
		String reward			=	request.getParameter("reward");					//奖励
		String loanType			=	request.getParameter("loanType");				//借款类型
		String annualInterest	=	request.getParameter("annualInterest");			//年利率
		String repayment 		=	request.getParameter("repayment");				//还款方式
		String deadlineType		= 	request.getParameter("deadlineType");			//借款期限
		String deadline			= 	request.getParameter("deadlinemin");			//期限
		int page				=	Integer.parseInt(request.getParameter("page"));	//页码
		
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(6);
		pageEntity.setMap(param);
		
		if(wd != null && wd.trim().length() > 0){
			param.put("projectinfo", wd);
		}
		
		
		
		param.put("investStatu", projectStatu);
		param.put("reward", reward);
		param.put("projectType", loanType);
		if(annualInterest.equals("-1")){
			param.put("yearratemin", "-1");
		}else if(annualInterest.equals("8")){
			param.put("yearratemin", "0");
			param.put("yearratemax", "8");
		}else if(annualInterest.equals("8-12")){
			param.put("yearratemin", "8");
			param.put("yearratemax", "12");
		}else if(annualInterest.equals("12")){
			param.put("yearratemin", "12");
		}
		
		
		if(deadline.equals("1")){
			param.put("deadlinemin", 1);
			param.put("deadlinemax", 1);
		}else if(deadline.equals("2")){
			param.put("deadlinemin", 2);
			param.put("deadlinemax", 2);
		}else if(deadline.equals("3")){
			param.put("deadlinemin", 3);
			param.put("deadlinemax", 3);
		}else if(deadline.equals("45")){
			param.put("deadlinemin", 45);
			param.put("deadlinemax", 45);
		}else if(deadline.equals("12")){
			param.put("deadlinemin", 12);
			param.put("deadlinemax", 12);
		}else{
			String[] deadlineArray = deadline.split("-");
			if(deadlineArray.length == 2){
				param.put("deadlinemin", deadlineArray[0]);
				param.put("deadlinemax", deadlineArray[1]);
			}
		}
		
		param.put("deadlineType", deadlineType);
		param.put("repayment", repayment);
		List<ProjectAppRecordEntity> list = investListService.selectInvestList(pageEntity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", pageEntity.getPageNum());
		result.put("pageSize", pageEntity.getPageSize());
		result.put("tol", pageEntity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	
	@RequestMapping("/debtCession")
	public String debtCession(){
		return "invest/debtCession";
	}
	
	
	/***
	* 投资详细信息
	* 
	* @author 李杰
	* @return
	* @date 2016-4-27 下午4:01:48
	 */
	@RequestMapping("/investmentDetail/{sprojectId:[0-9]+}")
	public String investmentDetail(HttpServletRequest request,@PathVariable String sprojectId){
		long projectId = 0;
		try {
			projectId = Long.parseLong(sprojectId);
		} catch (Exception e) {
			return null;
		}
		ProjectAppRecordEntity appRecordEntity = detailService.selectProjectDetailByID(projectId);
		request.setAttribute("appRecordEntity", appRecordEntity);
		return "invest/investmentDetail";
	}
	
	
	
	
	
	@RequestMapping("/debtDetail")
	public String debtDetail(){
		return "invest/debtDetail";
	}
	@RequestMapping("/projectDetail")
	public String projectDetail(){
		return "invest/projectDetail";
	}
	@RequestMapping("/riskControl")
	public String riskControl(){
		return "invest/riskControl";
	}
	@RequestMapping("/repaymentPlan")
	public String repaymentPlan(){
		return "invest/repaymentPlan";
	}
	@RequestMapping("/investmentList")
	public String investmentList(){
		return "invest/investmentList";
	}
	@RequestMapping("/projectCourse")
	public String projectCourse(){
		return "invest/projectCourse";
	}
	@RequestMapping("/postLoanSupervision")
	public String postLoanSupervision(){
		return "invest/postLoanSupervision";
	}
	@RequestMapping("/proDetail")
	public String proDetail(){
		return "invest/proDetail";
	}
	@RequestMapping("/riskCtrl")
	public String riskCtrl(){
		return "invest/riskCtrl";
	}
	@RequestMapping("/repayArrang")
	public String repayArrang(){
		return "invest/repayArrang";
	}
	@RequestMapping("/proCourse")
	public String proCourse(){
		return "invest/proCourse";
	}
	@RequestMapping("/bidRecord")
	public String bidRecord(){
		return "invest/bidRecord";
	}
	@RequestMapping("/investSuccess")
	public String investSuccess(){
		return "invest/investSuccess";
	}
	@RequestMapping("/investFalse")
	public String investFalse(){
		return "invest/investFalse";
	}
}
