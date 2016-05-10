package cn.springmvc.controller.member; 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.RealNameAuth;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.service.IBorrowingCertificationServer;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 * 会员分配理财顾问
 * @date:2016-5-7 下午3:29:10
 **/

@Controller
@RequestMapping("/adviserPlaner")
public class MemRitributeController {
	
	@Autowired
	private CertificationAuditService certificationAuditService;
	
	
	/**
	 * 未分配理财顾问会员
	 * TODO
	 * 创建日期：2016-5-7下午3:39:55
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/memberNoPlaner", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity memberNoPlaner(HttpServletRequest req){
		//查询条件
		Map<String,Object> map = new HashMap<String, Object>();
		int memberType = IntegerAndString.StringToInt(req.getParameter("content"),0);
		String memberNo = req.getParameter("memberNo");//会员编号
		String logName = req.getParameter("logName");//登录名
		String personalName = req.getParameter("personalName");//姓名
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		map.put("memberNo", memberNo);
		map.put("logName", logName);
		map.put("personalName", personalName);
		map.put("startTime", start);
		map.put("endTime", end);
		map.put("memberType", memberType);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		PageEntity pager = new PageEntity();
		int pageSize = IntegerAndString.StringToInt(req.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(req.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		pager.setMap(map);
		certificationAuditService.ExistingFinancialAdvisor(pager);
		return pager;
	}	
	
	/**
	 * 已分配理财顾问
	 * TODO
	 * 创建日期：2016-5-7下午3:40:21
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/memberAlreadyPlaner", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity memberAlreadyPlaner(HttpServletRequest req){
		//查询条件
		Map<String,Object> map = new HashMap<String, Object>();
		int memberType = IntegerAndString.StringToInt(req.getParameter("content"),0);
		String memberNo = req.getParameter("memberNo");//会员编号
		String logName = req.getParameter("logName");//登录名
		String personalName = req.getParameter("personalName");//姓名
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		String planner = req.getParameter("planner");
		map.put("memberNo", memberNo);
		map.put("logName", logName);
		map.put("personalName", personalName);
		map.put("startTime", start);
		map.put("endTime", end);
		map.put("memberType", memberType);
		map.put("fAName", planner);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		PageEntity pager = new PageEntity();
		int pageSize = IntegerAndString.StringToInt(req.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(req.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		pager.setMap(map);
		certificationAuditService.HasFinancialAdvisor(pager);
		return pager;
	}	
	
	/**
	 * 理财顾问 列表
	 * TODO
	 * 创建日期：2016-5-7下午3:40:21
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/PlanerList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity PlanerList(HttpServletRequest req){
		//查询条件
		Map<String,Object> map = new HashMap<String, Object>();
		String memberNo = req.getParameter("memberNo");//编号
		String realName = req.getParameter("realName");//姓名
		String phone = req.getParameter("phone");//手机号
		map.put("memberNo", memberNo);
		map.put("realName", realName);
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		PageEntity pager = new PageEntity();
		int pageSize = IntegerAndString.StringToInt(req.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(req.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		pager.setMap(map);
		certificationAuditService.findFinancialAdvisor(pager);
		return pager;
	}	
}

