
package cn.springmvc.controller.frontconfig; 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.IntegralMallBannerEntity;
import cn.springmvc.service.IntegralMallBannerService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  前台页面配置
 *  pc积分商城轮播图管理
 * @date:2016-5-19 下午6:48:25
 **/


@Controller
@RequestMapping("/mallBanner")
public class IntegralMallBannerController {

	@Autowired
	IntegralMallBannerService integralMallBannerService;
	
	/**
	 * 积分商城轮播图管理列表
	 * TODO
	 * 创建日期：2016-5-19下午7:27:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping("/showMallBannerList")
	@ResponseBody
	public PageEntity showMallBannerList(HttpServletRequest request) {
		
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String bannerTitle = request.getParameter("bannerTitle");
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),-1);
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("startTime", startDate);
		param.put("endTime", endDate);
		param.put("bannerTitle", bannerTitle);
		param.put("statu", statu);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		integralMallBannerService.selectIntegralMallBannerListpage(pager);
		return pager;
	}
	
	/**
	 * 保存积分商城轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:27:52
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveMallBanner")
	@ResponseBody
	public int saveMallBanner(HttpServletRequest request) {
		IntegralMallBannerEntity entity = new IntegralMallBannerEntity();
		String bannerTitle = request.getParameter("bannerTitle");
		String links = request.getParameter("links");
		String url = request.getParameter("url");
		entity.setStatu(1);
		entity.setBannerTitle(bannerTitle);
		entity.setLinks(links);
		entity.setUrl(url);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
			entity.setOptId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(502);
		logentity.setlOptId(50201);
		int iResult = integralMallBannerService.insertIntegralMallBanner(entity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 修改积分商城轮播图
	 * 
	 * TODO
	 * 创建日期：2016-5-19下午7:28:00
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateMallBanner")
	@ResponseBody
	public int updateMallBanner(HttpServletRequest request) {
		IntegralMallBannerEntity entity = new IntegralMallBannerEntity();
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		String bannerTitle = request.getParameter("bannerTitle");
		String links = request.getParameter("links");
		String url = request.getParameter("url");
		entity.setId(id);
		entity.setBannerTitle(bannerTitle);
		entity.setLinks(links);
		entity.setUrl(url);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
			entity.setOptId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(502);
		logentity.setlOptId(50202);
		int iResult = integralMallBannerService.updateIntegralMallBannerByID(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 删除积分商城轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:28:08
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/deleteMallBanner")
	@ResponseBody
	public int deleteMallBanner (HttpServletRequest request) {
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(502);
		logentity.setlOptId(50203);
		int iResult = integralMallBannerService.deleteIntegralMallBannerByID(id, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 停用启用积分商城轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:28:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/ofMallBanner")
	@ResponseBody
	public int ofMallBanner (HttpServletRequest request) {
		IntegralMallBannerEntity entity = new IntegralMallBannerEntity();
		
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		entity.setId(id);
		entity.setStatu(statu);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
			entity.setOptId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(502);
		logentity.setlOptId(50205);
		int iResult = integralMallBannerService.updateIntegralMallBannerStatuByID(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 上移下移积分商城轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:28:28
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/moveMallBanner")
	@ResponseBody
	public int moveMallBanner (HttpServletRequest request) {
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int flag = IntegerAndString.StringToInt(request.getParameter("flag"), 0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iid", id);
		map.put("flag", flag);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(502);
		logentity.setlOptId(50204);
		int iResult = integralMallBannerService.moveAndDownIntegralMallBannerByID(map, logentity, sIpInfo);
		return iResult;
	}	
}

