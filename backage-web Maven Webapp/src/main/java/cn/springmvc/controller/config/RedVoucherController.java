
package cn.springmvc.controller.config; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.SystemSetService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林
* @Description: 红包代金卷控制层 
* @since 
* @date 2016-4-13 上午11:17:31
 */
@Controller
@RequestMapping("/redV")
public class RedVoucherController {

	@Autowired
	private SystemSetService systemSetService;
	
	/**
	 * 
	* userMsg查询系统设置 
	* TODO查询系统设置 
	* @author 杨翰林  
	* * @Title: userMsg 
	* @Description: 查询系统设置  
	* @param @return 设定文件 
	* @return SystemSetEntity 返回类型 
	* @date 2016-4-13 上午11:31:53
	* @throws
	 */
	@RequestMapping("/msg")
	@ResponseBody
	public SystemSetEntity msg() {
		
		SystemSetEntity systemEntity = systemSetService.
				findSystemSet();
		
		return systemEntity;
	}
	
	
	/**
	 * 
	* update修改红包代金卷到期提醒 
	* TODO修改红包代金卷到期提醒
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改红包代金卷到期提醒 
	* @param @param endDateRemind
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-13 上午11:45:22
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		SystemSetEntity systemSetEntity = new SystemSetEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String endDateRemind = request.getParameter("endDateRemind");
		if (endDateRemind != null && endDateRemind != "") {
			systemSetEntity.setEndDateRemind(IntegerAndString.StringToInt(endDateRemind, -1));
		}
		systemSetEntity.setExpirationReminderSet(-1);
		systemSetEntity.setOverdueInsteadDay(-1);
		systemSetEntity.setRedpacketsRateMax(-1);
		systemSetEntity.setRiskMarginType(-1);
		systemSetEntity.setAutoBackRate(-1);
		systemSetEntity.setRiskMarginRateMax(-1);
		
		String [] sIpInfo = new String[5];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(6011001);
		entity.setlModuleId(60110);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = systemSetService.updateSystemSet(systemSetEntity, entity, sIpInfo);
		
		return num;
	}
	
}

