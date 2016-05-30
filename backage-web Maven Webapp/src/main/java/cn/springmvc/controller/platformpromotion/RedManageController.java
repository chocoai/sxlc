
package cn.springmvc.controller.platformpromotion;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.MemberRedpacketsSetEntity;
import cn.invitemastermng.model.RedpacketsAffairEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.ExtensionModuleGiftService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 红包管理控制层
* @since 
* @date 2016-5-11 上午10:48:41
 */
@Controller
@RequestMapping("/red")
public class RedManageController {

	@Resource(name="extensionModuleGiftServiceImpl")
	private ExtensionModuleGiftService extensionModuleGiftService;
	
	/**
	 * 
	* redSendList查询红包赠送配置 
	* TODO查询红包赠送配置
	* @author 杨翰林  
	* * @Title: redSendList 
	* @Description: 查询红包赠送配置 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-11 上午11:11:47
	* @throws
	 */
	@RequestMapping("/redSendList")
	@ResponseBody
	public PageEntity redSendList(HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleGiftService.selectFIInvestRedSetList(pager);
		return pager;
	}
	
	/**
	 * 
	* selectMemberRedpacketsSet查询首次开户充值信息 
	* TODO查询首次开户充值信息
	* @author 杨翰林  
	* * @Title: selectMemberRedpacketsSet 
	* @Description: 查询首次开户充值信息 
	* @param @return 设定文件 
	* @return MemberRedpacketsSetEntity 返回类型 
	* @date 2016-5-11 上午11:36:45
	* @throws
	 */
	@RequestMapping("/first")
	@ResponseBody
	public MemberRedpacketsSetEntity selectMemberRedpacketsSet() {
		
		MemberRedpacketsSetEntity memberRedpacketsSetEntity = extensionModuleGiftService
				.selectMemberRedpacketsSet();
		return memberRedpacketsSetEntity;
	}
	
	/**
	 * 
	* MemberRedpacketsSet会员红包赠送配置表设置  
	* TODO会员红包赠送配置表设置 
	* @author 杨翰林  
	* * @Title: MemberRedpacketsSet 
	* @Description: 会员红包赠送配置表设置  
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 上午11:47:57
	* @throws
	 */
	@RequestMapping("/addRed")
	@ResponseBody
	public int FirstInvestRedpacketsSet(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String invsit = request.getParameter("invsit");
		String scale = request.getParameter("scale");
		String lId = request.getParameter("lId");
		
		req.put("invest_Amount", IntegerAndString.StringToInt(invsit));
		req.put("rp_Rate", IntegerAndString.StringToInt(scale));
		if (lId != null && !"".equals(lId)) {
			req.put("lId", lId);
		}else {
			req.put("lId", 0);
		}
		
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100601);
		entity.setlModuleId(1006);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleGiftService.FirstInvestRedpacketsSet(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* MemberRedpacketsSet添加、修改红包 
	* TODO添加、修改红包
	* @author 杨翰林  
	* * @Title: MemberRedpacketsSet 
	* @Description: 添加、修改红包 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 下午2:30:05
	* @throws
	 */
	@RequestMapping("/firstOption")
	@ResponseBody
	public int MemberRedpacketsSet(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String openAccount = request.getParameter("openAcount");
		String firstRecharge = request.getParameter("firstRecharge");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100701);
		entity.setlModuleId(1007);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleGiftService.MemberRedpacketsSet(openAccount, firstRecharge, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* redActivityRecord查询红包活动记录 
	* TODO查询红包活动记录
	* @author 杨翰林  
	* * @Title: redActivityRecord 
	* @Description: 查询红包活动记录 
	* @param @param request
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-11 下午2:33:17
	* @throws
	 */
	@RequestMapping("redRecordList")
	@ResponseBody
	public PageEntity redActivityRecord(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String startDate1 = request.getParameter("startDate1");
		String startDate2 = request.getParameter("startDate2");
		String startDate3 = request.getParameter("startDate3");
		String endDate1 = request.getParameter("endDate1");
		String endDate2 = request.getParameter("endDate2");
		String endDate3 = request.getParameter("endDate3");
		String statu = request.getParameter("statu");
		
		req.put("CreateTime_Min", startDate1);
		req.put("CreateTime_Max", endDate1);
		req.put("Start_Date_Min", startDate2);
		req.put("Start_Date_Max", endDate2);
		req.put("End_Date_Min", startDate3);
		req.put("End_Date_Max", endDate3);
		req.put("Statu", statu);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleGiftService.getRedpacketsAffair(pager);
		
		return pager;
	}
	
	/**
	 * 
	* redActivityRecord查询红包领取明细 
	* TODO查询红包领取明细
	* @author 杨翰林  
	* * @Title: redActivityRecord 
	* @Description: 查询红包领取明细 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-11 下午3:05:41
	* @throws
	 */
	@RequestMapping("getDetail")
	@ResponseBody
	public PageEntity getRedDetail(HttpServletRequest request, Map<String,Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String affairID = request.getParameter("affairID");
		
		req.put("Affair_ID", affairID);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleGiftService.getRedpacketsreceive(pager);
		
		return pager;
	}
	
	/**
	 * 
	* addRedRecord新增红包记录 
	* TODO新增红包记录
	* @author 杨翰林  
	* * @Title: addRedRecord 
	* @Description: 新增红包记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 下午7:31:48
	* @throws
	 */
	@RequestMapping("addRedRecord")
	@ResponseBody
	public int addRedRecord(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String affairName = request.getParameter("affairName");
		String userendDate = request.getParameter("userendDate");
		String giftAmount = request.getParameter("giftAmount");
		String quantity = request.getParameter("quantity");
		
		req.put("startDate", startDate + " 00:00:00");
		req.put("endDate", endDate + " 23:59:59");
		req.put("userendDate", userendDate);
		req.put("affairName", affairName);
		req.put("giftAmount", giftAmount);
		req.put("quantity", quantity);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100601);
		entity.setlModuleId(1006);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleGiftService.RedpacketsAffairinsert(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* modRedRecord修改红包记录 
	* TODO修改红包记录
	* @author 杨翰林  
	* * @Title: modRedRecord 
	* @Description: 修改红包记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 下午7:43:18
	* @throws
	 */
	@RequestMapping("modRedRecord")
	@ResponseBody
	public int modRedRecord(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String affairName = request.getParameter("affairName");
		String userendDate = request.getParameter("userendDate");
		String giftAmount = request.getParameter("giftAmount");
		String quantity = request.getParameter("quantity");
		String affairID = request.getParameter("affairID");
		String detailId = request.getParameter("detailId");
		
		req.put("startDate", startDate +" 23:59:59");
		req.put("endDate", endDate);
		req.put("userendDate", userendDate);
		req.put("affairName", affairName);
		req.put("giftAmount", giftAmount);
		req.put("quantity", quantity);
		req.put("affairID", affairID);
		req.put("detailID", detailId);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100602);
		entity.setlModuleId(1006);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleGiftService.RedpacketsAffairupdate(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* query4mod查询红包明细 
	* TODO查询红包明细
	* @author 杨翰林  
	* * @Title: query4mod 
	* @Description: 查询红包明细 
	* @param @param request
	* @param @return 设定文件 
	* @return List<RedpacketsDetailRecordEntity> 返回类型 
	* @date 2016-5-11 下午7:48:37
	* @throws
	 */
	@RequestMapping("/query4mod")
	@ResponseBody
	public RedpacketsAffairEntity query4mod(HttpServletRequest request) {
		
		String affairID = request.getParameter("affairID");
		
		RedpacketsAffairEntity entity = extensionModuleGiftService
				.selectRedpacketsAffairbyID(IntegerAndString.StringToLong(affairID, -1));
		
		return entity;
	}
	
	/**
	 * 
	* RedpacketsAffairrelease发布红包
	* TODO发布红包
	* @author 杨翰林  
	* * @Title: RedpacketsAffairrelease 
	* @Description: 发布红包 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-20 上午11:24:22
	* @throws
	 */
	@RequestMapping("/publish")
	@ResponseBody
	public int RedpacketsAffairrelease(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String affairID = request.getParameter("affairID");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100603);
		entity.setlModuleId(1006);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleGiftService.RedpacketsAffairrelease(IntegerAndString.StringToLong(affairID, -1), entity, sIpInfo);
		
		return num;
	}
}

