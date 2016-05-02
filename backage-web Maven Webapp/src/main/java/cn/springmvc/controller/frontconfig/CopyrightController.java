
package cn.springmvc.controller.frontconfig; 

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
import cn.springmvc.service.SystemCopyrightService;

/**
 * 
* @author 杨翰林 
* @Description: 版权信息控制层 
* @since 
* @date 2016-4-26 上午10:38:12
 */
@Controller
@RequestMapping("/copyright")
public class CopyrightController {

	@Autowired
	private SystemCopyrightService systemCopyrightService;
	
	/**
	 * 
	* query查询网站版权信息 
	* TODO查询网站版权信息
	* @author 杨翰林  
	* * @Title: query 
	* @Description: 查询网站版权信息 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 上午10:41:49
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public String query() {
		
		String copyright = systemCopyrightService.selectSystemCopyright();
		return copyright;
	}
	
	/**
	 * 
	* save添加版权信息 
	* TODO添加版权信息
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加版权信息 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 上午10:43:44
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String result = request.getParameter("result");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51701);
		entity.setlModuleId(517);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		if (!"".equals(result)) {
			int num = systemCopyrightService.
					insertSystemCopyright(result, entity, sIpInfo);
			return num;
		}
		return 0;
	}
	
	/**
	 * 
	* update修改版权信息 
	* TODO修改版权信息
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改版权信息 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 上午10:51:45
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51001);
		entity.setlModuleId(510);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		String content = request.getParameter("content");
		if (!"".equals(content)) {
			int num = systemCopyrightService.
					insertSystemCopyright(content, entity, sIpInfo);
			return num;
		}
		return 0;
	}
}

