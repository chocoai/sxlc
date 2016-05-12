package cn.springmvc.controller.project; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CreditorTransferCheckService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 债权转让管理控制器 
* @date 2016-5-11 下午2:55:36 
*/
@Controller
@RequestMapping("/project")
public class DebtTransferController {

	@Resource(name="creditorTransferCheckServiceImpl")
	private CreditorTransferCheckService creditorTransferCheckService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 债权转让审核页面 
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午2:56:53
	 * @throws 
	 */
	@RequestMapping("/toCreditAssignmentExamPg")
	public String toCreditAssignmentExamPg(HttpServletRequest req){
		return "project/credit_assignment_exam";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 债权转让延期页面
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午5:32:04
	 * @throws 
	 */
	@RequestMapping("/toCreditAssignmentLatePg")
	public String toCreditAssignmentLatePg(HttpServletRequest req){
		return "project/credit_assignment_late";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 分页查询债权转让申请 
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-11 下午3:01:21
	 * @throws 
	 */
	@RequestMapping("/getDebtTransferData")
	@ResponseBody
	public PageEntity getDebtTransferData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String projectNo = req.getParameter("projectNo");
		String billNo = req.getParameter("billNo");
		String name = req.getParameter("name");
		String TransPrincipal = req.getParameter("TransPrincipal");
		String order = req.getParameter("order");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("projectNo", projectNo);
		param.put("billNo", billNo);
		param.put("name", name);
		param.put("TransPrincipal", TransPrincipal);
		//设置排序参数
   		param.put("order", order);//1转让申请时间降序,-1转让申请时间升序-,2转让金额降序,-2转让金额升序,3转让价格降序,-3转让价格升序
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		creditorTransferCheckService.selectCreditorTransferManager(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 债权转让申请审核操作
	 * @param req
	 * @return int  
	 * @date 2016-5-11 下午3:50:00
	 * @throws 
	 */
	@RequestMapping("/creditorTransAppCheck")
	@ResponseBody
	public int creditorTransAppCheck(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=307(债权转让审核)
		//optID=30701(债权转让审核)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(307);
		logEntity.setlOptId(30701);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		String ctaId = req.getParameter("ctaId");//债权转让申请ID
		String checkstatu = req.getParameter("checkstatu");
		String checkRemark = req.getParameter("checkRemark");
		String transMaxTime = req.getParameter("transMaxTime");
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("ctaId",ctaId);
		param.put("checkstatu", checkstatu);
		param.put("checkRemark",checkRemark );
		param.put("transMaxTime", transMaxTime);
		param.put("adminID", admin.getId());
		
		int result = 0;
		result = creditorTransferCheckService.creditorTransAppCheck(param,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 投标结束时间延长 
	 * @param req
	 * @return int  
	 * @date 2016-5-11 下午5:55:40
	 * @throws 
	 */
	@RequestMapping("/updateTransMaxTime")
	@ResponseBody
	public int updateTransMaxTime(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=308(债权转让延期)
		//optID=30801(债权转让延期)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(308);
		logEntity.setlOptId(30801);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		String ctaId = req.getParameter("ctaId");//债权转让申请ID
		String transMaxTime = req.getParameter("transMaxTime");
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("ctaId",ctaId);
		param.put("transMaxTime", transMaxTime);
		
		int result = 0;
		result = creditorTransferCheckService.updateTransMaxTime(param,logEntity,sIpInfo);
		return result;
	}
	
	
}

