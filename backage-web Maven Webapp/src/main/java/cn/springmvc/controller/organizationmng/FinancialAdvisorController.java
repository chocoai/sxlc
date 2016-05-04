package cn.springmvc.controller.organizationmng;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.FinancialAdvisor;
import cn.springmvc.service.IFinancialAdvisorServer;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 组织机构
 * 理财顾问
 * @date:2016-3-29 下午8:24:15
 **/

@Controller("financialAdvisorController")
public class FinancialAdvisorController {

	@Resource(name="financialAdvisorServer")
	private  IFinancialAdvisorServer financialAdvisorServer;
	
	@RequestMapping(value ="/getPlannerAdvise", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getPlannerAdvise(HttpServletRequest request){
		Map<String ,Object> param = new HashMap<String, Object>();
		String staffName =request.getParameter("staffName");
		String memberNo =request.getParameter("memberNo");
		String logName =request.getParameter("logName");
		String realName = request.getParameter("realName");
		if(staffName!=null && !staffName.equals("")){
			param.put("staffName", staffName);
		}
		if(memberNo!=null && !memberNo.equals("")){
			param.put("memberNo", memberNo);
		}
		if(logName!=null && !logName.equals("")){
			param.put("logName", logName);
		}
		if(realName!=null && !realName.equals("")){
			param.put("realName", realName);
		}
		
		String sKey = DbKeyUtil.GetDbCodeKey();
		param.put("sKey", sKey);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		
		PageEntity pageEntity = new PageEntity();
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		pageEntity.setMap(param);
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		financialAdvisorServer.getListByParam(pageEntity);
		return pageEntity;
	}
	
	/**
	 * 添加 理财师顾问
	 * TODO
	 * 创建日期：2016-4-9下午2:45:59
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/savaPlannerAdvise", method = RequestMethod.POST)
	@ResponseBody
	public int savaPlannerAdvise(HttpServletRequest request){
		FinancialAdvisor advisor = new FinancialAdvisor();
		String staffId = request.getParameter("staffId");
		advisor.setStaffId(IntegerAndString.StringToLong(staffId, 0));
		
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10401);
		entity.setlModuleId(104);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		return financialAdvisorServer.saveFinancialAdvisor(advisor,entity,sIpInfo);
	}
	
	/**
	 * 移除 理财顾问
	 * TODO  
	 * 创建日期：2016-4-9下午2:46:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
  	@RequestMapping(value ="/removePlannerAdvise", method = RequestMethod.POST)
	@ResponseBody
	public int removePlannerAdvise( HttpServletRequest request){
  		String planneId =request.getParameter("planneId");
		long planne_Id = IntegerAndString.StringToLong(planneId, 0);
		FinancialAdvisor advisor = new FinancialAdvisor();
		advisor.setId(planne_Id);
		
		
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10402);
		entity.setlModuleId(104);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		return financialAdvisorServer.removeFinancialAdvisor(advisor,entity,sIpInfo);
	}
}	
