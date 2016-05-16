package cn.springmvc.controller.config;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import cn.springmvc.model.ProjectPurposeSetEntity;
import cn.springmvc.model.SystemAgreementSetEntity;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.service.ChannelSetService;
import cn.springmvc.service.ProjectPurposeSetService;
import cn.springmvc.service.SystemAgreementSetService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 第三方通道配置
 * @date:2016-4-27 上午9:53:45
 **/


@Controller
@RequestMapping("/channel")
public class ChannelSetController {
	
	@Autowired
	private  ChannelSetService channelSetService;
	
	
	/**
	 * 查询第三方通道
	 * TODO
	 * 创建日期：2016-5-13上午10:13:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getchannelList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getFront(HttpServletRequest request){
		int interfaceType = IntegerAndString.StringToInt(request.getParameter("interfaceType"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("interfaceType", interfaceType);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		pageEntity.setMap(map);
		channelSetService.selectThreeInterface(pageEntity);
		return pageEntity;
	}
	
	
	/**
	 * 保存第三方账户
	 * TODO
	 * 创建日期：2016-4-27上午10:03:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveChanner")
	@ResponseBody
	public int saveChanner(HttpServletRequest request){
		
		int escrowID = IntegerAndString.StringToInt(request.getParameter("escrowID"),0);
		int interfaceID = IntegerAndString.StringToInt(request.getParameter("interfaceID"),0);
		String interfaceUrl = request.getParameter("interfaceUrl");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("escrowID", escrowID);
		map.put("interfaceID", interfaceID);
		map.put("interfaceUrl", interfaceUrl);
		map.put("statu", 1);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(604);
		entity.setlOptId(60401);
		int iResult = channelSetService.insertThreeInterface(map,entity,sIpInfo);
		return  iResult;
	}
	/**
	 * 修改第三方账户
	 * TODO
	 * 创建日期：2016-5-13上午11:27:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateChanner")
	@ResponseBody
	public int updateChanner(HttpServletRequest request){
		
		int escrowID = IntegerAndString.StringToInt(request.getParameter("escrowID"),0);
		int interfaceID = IntegerAndString.StringToInt(request.getParameter("interfaceID"),0);
		String interfaceUrl = request.getParameter("interfaceUrl");
		int  statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("escrowID", escrowID);
		map.put("interfaceID", interfaceID);
		map.put("interfaceUrl", interfaceUrl);
		map.put("statu", statu);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(604);
		entity.setlOptId(60403);
		int iResult = channelSetService.updateThreeInterface(map, entity, sIpInfo);
		return  iResult;
	}	
	/**
	 * 停用启用第三方账户
	 * TODO
	 * 创建日期：2016-5-13上午11:27:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/ofChanner")
	@ResponseBody
	public int ofChanner(HttpServletRequest request){
		
		int escrowID = IntegerAndString.StringToInt(request.getParameter("escrowID"),0);
		int interfaceID = IntegerAndString.StringToInt(request.getParameter("interfaceID"),0);
		String interfaceUrl = request.getParameter("interfaceUrl");
		int  statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("escrowID", escrowID);
		map.put("interfaceID", interfaceID);
		map.put("interfaceUrl", interfaceUrl);
		map.put("statu", statu);
		
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(604);
		entity.setlOptId(60403);
		int iResult = channelSetService.updateThreeInterface(map, entity, sIpInfo);
		return  iResult;
	}	
}
