
package cn.springmvc.controller.frontconfig; 

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
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.HomeBannerEntity;
import cn.springmvc.service.HomeBannerService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  前台页面配置
 *  pc首页宣传图片管理
 * @date:2016-5-19 下午6:48:25
 **/


@Controller
@RequestMapping("/homeBanner")
public class PcBannerController {

	@Autowired
	HomeBannerService homeBannerService;
	
	/**
	 * 查询首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午6:54:59
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/showHomeBannerList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity showHomeBannerList(HttpServletRequest request) {
		
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
		homeBannerService.selectHomeBannerListpage(pager);
		
		return pager;
	}
	
	/**
	 *  保存首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午6:58:51
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveHomeBanner")
	@ResponseBody
	public int saveHomeBanner(HttpServletRequest request) {
		HomeBannerEntity entity = new HomeBannerEntity();
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
		logentity.setlModuleId(501);
		logentity.setlOptId(50101);
		int iResult = homeBannerService.insertHomeBanner(entity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 修改首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:09:48
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateHomeBanner")
	@ResponseBody
	public int updateHomeBanner(HttpServletRequest request) {
		HomeBannerEntity entity = new HomeBannerEntity();
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
		logentity.setlModuleId(501);
		logentity.setlOptId(50102);
		int iResult = homeBannerService.updateHomeBannerByID(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 删除首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:15:14
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/deleteHomeBanner")
	@ResponseBody
	public int deleteHomeBanner(HttpServletRequest request) {
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
		logentity.setlModuleId(501);
		logentity.setlOptId(50103);
		int iResult = homeBannerService.deleteHomeBannerByID(id, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 停用启用首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:13:11
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/ofHomeBanner")
	@ResponseBody
	public int ofHomeBanner(HttpServletRequest request) {
		HomeBannerEntity entity = new HomeBannerEntity();
		
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
		logentity.setlModuleId(501);
		logentity.setlOptId(50105);
		int iResult = homeBannerService.updateHomeBannerStatuByID(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 上移或者下移首页轮播图
	 * TODO
	 * 创建日期：2016-5-19下午7:16:16
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/moveHomeBanner")
	@ResponseBody
	public int moveHomeBanner(HttpServletRequest request) {
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int flag = IntegerAndString.StringToInt(request.getParameter("flag"), 1);
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
		logentity.setlModuleId(501);
		logentity.setlOptId(50104);
		int iResult = homeBannerService.moveAndDownHomeBannerByID(map, logentity, sIpInfo);
		return iResult;
	}	
}

