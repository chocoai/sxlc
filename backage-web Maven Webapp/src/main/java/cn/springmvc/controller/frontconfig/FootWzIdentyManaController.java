
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
import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.service.SafetyCertificationService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  前台页面配置
 *  底部网站认证管理
 * @date:2016-5-20 下午3:30:16
 **/


@Controller
@RequestMapping("/SafetyCertification")
public class FootWzIdentyManaController {

	@Autowired
	SafetyCertificationService safetyCertificationService;
	
	/**
	 * 显示底部网站认证管理
	 * TODO
	 * 创建日期：2016-5-20下午3:31:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/SafetyCertificationList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity safetyCertificationList(HttpServletRequest request) {
		
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String title = request.getParameter("title");
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), -1);
		param.put("title", title);
		param.put("statu", statu);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		safetyCertificationService.selectSafetyCertificationList(pager);
		return pager;
	}
	
	/**
	 * 保存底部网站认证管理
	 * TODO
	 * 创建日期：2016-5-20下午3:36:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveSafetyCertification")
	@ResponseBody
	public int saveSafetyCertification(HttpServletRequest request) {
		SafetyCertificationEntity entity = new SafetyCertificationEntity();
		String title = request.getParameter("title");
		String logo = request.getParameter("logo");
		String url = request.getParameter("url");
		entity.setStatu(1);
		entity.setTitle(title);
		entity.setLogo(logo);
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
		logentity.setlModuleId(516);
		logentity.setlOptId(51601);
		int iResult = safetyCertificationService.insertSafetyCertification(entity, logentity, sIpInfo);
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
	@RequestMapping("/updateSafetyCertification")
	@ResponseBody
	public int updateSafetyCertification(HttpServletRequest request) {
		SafetyCertificationEntity entity = new SafetyCertificationEntity();
		long id = IntegerAndString.StringToLong(request.getParameter("id"), 0);
		String title = request.getParameter("title");
		String logo = request.getParameter("logo");
		String url = request.getParameter("url");
		entity.setId(id);
		entity.setStatu(1);
		entity.setTitle(title);
		entity.setLogo(logo);
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
		logentity.setlModuleId(516);
		logentity.setlOptId(51602);
		int iResult = safetyCertificationService.updateSafetyCertificationByID(entity, logentity, sIpInfo);
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
	@RequestMapping("/ofSafetyCertification")
	@ResponseBody
	public int ofSafetyCertification(HttpServletRequest request) {
		SafetyCertificationEntity entity = new SafetyCertificationEntity();
		
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
		logentity.setlModuleId(516);
		logentity.setlOptId(51603);
		int iResult = safetyCertificationService.updateSafetyCertificationStatuByID(entity, logentity, sIpInfo);
		return iResult;
	}
}

