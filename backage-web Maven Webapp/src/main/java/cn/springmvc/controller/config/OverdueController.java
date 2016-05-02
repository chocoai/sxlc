package cn.springmvc.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.service.OverdueService;

/** 
* @author 唐国峰
* @Description: 逾期配置controller
* @date 2016-4-13 上午9:57:09 
*/
@Controller
@RequestMapping("config")
public class OverdueController {
	
	@Resource(name="overdueServiceImpl")
	private OverdueService overdueService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到逾期严重程度配置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-13 上午10:05:11
	 * @throws 
	 */
	@RequestMapping("/toOverdueLimit")
	public String toOverdueLimit(HttpServletRequest req){
		Integer overDays = overdueService.findOverdueLimit();
		req.setAttribute("overDays", overDays);
		return "config/late-allocation";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到逾期费用设置页面
	 * @return String  
	 * @date 2016-4-13 上午11:32:29
	 * @throws 
	 */
	@RequestMapping("/toOverdueList")
	public String toOverdueList(){
		return "config/late-fee";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 增加或修改逾期程度设置
	 * @return int 操作成功与否标志 
	 * @param overdueLimit 
	 * @date 2016-4-13 上午10:44:08
	 * @throws 
	 */
	@RequestMapping("/addOverdueLimit")
	@ResponseBody
	public int addOverdueLimit(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60105(逾期配置)
		//optID=6010501(修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60105);
		logEntity.setlOptId(6010501);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		String overdueLimit = req.getParameter("overdueLimit");
		Integer overDays = overdueService.findOverdueLimit();//查询是否已存在配置数据
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("overdueLimit", overdueLimit);
		int result=0;
		if(null != overDays){
			 result = overdueService.updateOverdueLimit(map,logEntity,sIpInfo);
		}else{
			 result = overdueService.insertOverdueLimit(map,logEntity,sIpInfo);
		}
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 逾期费用设置表格查询
	 * @param start 开始条数
	 * @param length 页条数
	 * @return PageEntity 分页实体 
	 * @date 2016-4-13 上午11:56:31
	 * @throws 
	 */
	@RequestMapping("/getAllOverdue")
	@ResponseBody
	public PageEntity getAllOverdue(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		overdueService.findAllOverdue(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 删除逾期费用
	 * @param overdueMin
	 * @return int  
	 * @date 2016-4-13 下午1:37:50
	 * @throws 
	 */
	@RequestMapping("/deleteOverdue")
	@ResponseBody
	public int deleteOverdue(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60105(逾期配置)
		//optID=6010503(逾期费删除）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60105);
		logEntity.setlOptId(6010503);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		String overdueMin = req.getParameter("overdueMin");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("overdueMin", overdueMin);
		int result=0;
		result = overdueService.deleteOverdue(map,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 增加数据 
	 * @param overdueEntity
	 * @return int  
	 * @date 2016-4-13 下午2:16:51
	 * @throws 
	 */
	@RequestMapping("/addOverdue")
	@ResponseBody
	public int addOrUpdate(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=60105(逾期费添加)
		//optID=6010502(逾期费删除）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60105);
		logEntity.setlOptId(6010502);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		OverdueEntity overdueEntity = new OverdueEntity();
		int overdueMin = Integer.parseInt(req.getParameter("overdueMin"));
		overdueEntity.setOverdueMin(overdueMin);
		int overdueMax = Integer.parseInt(req.getParameter("overdueMax"));
		overdueEntity.setOverdueMax(overdueMax);
		int price = Integer.parseInt(req.getParameter("price"));
		overdueEntity.setPrice(price);
		int result=0;
		result = overdueService.insertOverdue(overdueEntity,logEntity,sIpInfo);
		return result;
	}
	
}
