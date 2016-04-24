
package cn.springmvc.controller.frontconfig; 

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.NewEventEntity;
import cn.springmvc.model.SecurityGuaranteeEntity;
import cn.springmvc.service.NewEventService;
import cn.springmvc.service.SecurityGuaranteeService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 * 平台安全保障管理
 * @date:2016-4-21 上午11:58:59
 **/

@Controller
@RequestMapping("/Security")
public class PlatSafeController {

	@Autowired
	SecurityGuaranteeService securityGuaranteeService;
	
	/**
	 * 查询平台安全保障
	 * TODO
	 * 创建日期：2016-4-21下午2:08:42
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping("/SecurityEntity")
	@ResponseBody
	public SecurityGuaranteeEntity SecurityEntity(Map<String, Object> req, HttpServletRequest request) {
		
		SecurityGuaranteeEntity entity = new SecurityGuaranteeEntity();
		
		entity = securityGuaranteeService.selectSecurityGuaranteeList(1);
		
		return entity;
	}
	
	/**
	 * 保存平台安全保障
	 * TODO
	 * 创建日期：2016-4-21下午2:13:40
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/SaveSecurity")
	@ResponseBody
	public int SaveSecurity(HttpServletRequest request) {
		SecurityGuaranteeEntity entity = new SecurityGuaranteeEntity();
		String content = request.getParameter("content");
		entity.setContent(content);
		entity.setStatu(1);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		entity.setId(1);
		entity.setOptId(loginAdmin.getId());
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(513);
		logentity.setlOptId(51301);
		int iResult = securityGuaranteeService.insertSecurityGuarantee(entity, logentity, sIpInfo);
		return iResult;
	}
	


	

}

