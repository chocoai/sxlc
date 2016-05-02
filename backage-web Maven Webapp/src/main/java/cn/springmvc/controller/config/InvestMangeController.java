
package cn.springmvc.controller.config; 


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.service.SystemSetService;

/**
 * 
* @author 杨翰林
* @Description: 投资管理费控制层 
* @since 
* @date 2016-4-13 下午3:37:00
 */
@Controller
@RequestMapping("/mange")
public class InvestMangeController {

	@Autowired
	private SystemSetService systemSetService;
	
	/**
	 * 
	* msg查询投资管理  
	* TODO查询投资管理
	* @author 杨翰林  
	* * @Title: msg 
	* @Description: 查询投资管理 
	* @param @return 设定文件 
	* @return SystemSetEntity 返回类型 
	* @date 2016-4-13 下午3:42:21
	* @throws
	 */
	@RequestMapping("/msg")
	@ResponseBody
	public String msg() {
		
		String mange = systemSetService.findInterestMngFee();
		return mange;
	}
	
	/**
	 * 
	* update修改投资管理费用百分比 
	* TODO修改投资管理费用百分比
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改投资管理费用百分比 
	* @param @param autoBackRate
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-13 下午3:42:49
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String priceDatum = request.getParameter("priceDatum");
		
		String [] sIpInfo = new String[5];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(6010801);
		entity.setlModuleId(60108);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		if (priceDatum != null && priceDatum != "") {
			int num = systemSetService.setInterestMngFee(priceDatum, null, null);
			return num;
		}else {
			return 0;
		}
	}
}

