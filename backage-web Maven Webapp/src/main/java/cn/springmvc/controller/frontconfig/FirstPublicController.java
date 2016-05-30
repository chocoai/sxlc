
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
import product_p2p.kit.datatrans.TimestampAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.model.SafetyCertificationSetEntity;
import cn.springmvc.service.SafetyCertificationSetService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  前台页面配置
 *  首页权全屏弹出公告管理
 * @date:2016-5-20 下午3:30:16
 **/


@Controller
@RequestMapping("/FirstPublic")
public class FirstPublicController {

	@Autowired
	SafetyCertificationSetService safetyCertificationSetService;
	
	/**
	 * 显示全屏弹出公告管理
	 * TODO
	 * 创建日期：2016-5-20下午7:39:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/SafetySetList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity SafetySetList(HttpServletRequest request) {
		
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), -1);
		param.put("startTime", startDate);
		param.put("endDate", endDate);
		param.put("statu", statu);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		safetyCertificationSetService.selectSafetyCertificationSetListpage(pager);
		return pager;
	}
	
	/**
	 * 添加全屏弹出公告管理
	 * TODO
	 * 创建日期：2016-5-20下午7:39:05
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveSafetySet")
	@ResponseBody
	public int saveSafetySet(HttpServletRequest request) {
		SafetyCertificationSetEntity entity = new SafetyCertificationSetEntity();
		String url  = request.getParameter("url");
		String certificationPicture = request.getParameter("imgPath");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		entity.setStatu(1);
		entity.setCertificationUrl(url);
		entity.setCertificationStartTime(TimestampAndString.StringToDate(startDate));
		entity.setCertificationEndTime(TimestampAndString.StringToDate(endDate));
		entity.setCertificationPicture(certificationPicture);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
			entity.setAdminId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(518);
		logentity.setlOptId(51801);
		int iResult = safetyCertificationSetService.insertSafetyCertificationSet(entity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 修改底部网站认证管理
	 * TODO
	 * 创建日期：2016-5-20下午3:36:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateSafetySet")
	@ResponseBody
	public int updateSafetySet(HttpServletRequest request) {
		long id = IntegerAndString.StringToLong(request.getParameter("id"), 0);
		SafetyCertificationSetEntity entity = new SafetyCertificationSetEntity();
		String certificationPicture = request.getParameter("imgPath");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String url  = request.getParameter("url");
		entity.setStatu(1);
		entity.setCertificationUrl(url);
		entity.setCertificationStartTime(TimestampAndString.StringToDate(startDate));
		entity.setCertificationEndTime(TimestampAndString.StringToDate(endDate));
		entity.setCertificationPicture(certificationPicture);
		entity.setId(id);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(518);
		logentity.setlOptId(51802);
		int iResult = safetyCertificationSetService.updateSafetyCertificationSetByID(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * 停用启用网站认证管理
	 * TODO
	 * 创建日期：2016-5-20下午3:39:35
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/ofSafetySet")
	@ResponseBody
	public int ofSafetySet(HttpServletRequest request) {
		SafetyCertificationSetEntity entity = new SafetyCertificationSetEntity();
		
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		entity.setId(id);
		entity.setStatu(statu);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(518);
		logentity.setlOptId(51803);
		int iResult = safetyCertificationSetService.updateSafetyCertificationSetStatuByID(entity, logentity, sIpInfo);
		return iResult;
	}
}

