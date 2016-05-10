
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

import cn.invitemastermng.model.CpsInviteSetEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.ExtensionModuleService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 平台推广cps控制层
* @since 
* @date 2016-5-10 下午3:53:07
 */
@Controller
@RequestMapping("/cps")
public class CPSController {

	@Resource(name="extensionModuleServiceImpl")
	private ExtensionModuleService extensionModuleService;
	
	/**
	 * 
	* queryCps查询cps配置 
	* TODO查询cps配置
	* @author 杨翰林  
	* * @Title: queryCps 
	* @Description: 查询cps配置 
	* @param @return 设定文件 
	* @return CpsInviteSetEntity 返回类型 
	* @date 2016-5-10 下午4:00:18
	* @throws
	 */
	@RequestMapping("/queryCps")
	@ResponseBody
	public CpsInviteSetEntity queryCps() {
		
		CpsInviteSetEntity cpsInviteSetEntity = extensionModuleService
				.selectCpsInviteSet();
		
		return cpsInviteSetEntity;
	}
	
	/**
	 * 
	* modCps修改cps配置 
	* TODO修改cps配置
	* @author 杨翰林  
	* * @Title: modCps 
	* @Description: 修改cps配置 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-10 下午4:53:47
	* @throws
	 */
	@RequestMapping("/modCps")
	@ResponseBody
	public int modCps(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String firstInvestSet = request.getParameter("firstInvestSet");
		
		int firstInvestSets = IntegerAndString.StringToInt(firstInvestSet);
		req.put("first_Invest", firstInvestSets);
		req.put("invite", -1);
		req.put("first_Borrow", -1);
		req.put("first_Recharge", -1);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(1001);
		entity.setlModuleId(2);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleService
				.CPSPromote(req, entity, sIpInfo);
		
		return num;
	}
}

