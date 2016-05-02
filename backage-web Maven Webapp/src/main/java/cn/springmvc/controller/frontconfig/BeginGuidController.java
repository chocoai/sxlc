
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
import cn.springmvc.model.NewHandEntity;
import cn.springmvc.service.NewHandService;

/**
 * 
* @author 杨翰林 
* @Description: 新手指南控制层 
* @since 
* @date 2016-4-26 下午2:45:01
 */
@Controller
@RequestMapping("/new")
public class BeginGuidController {

	@Autowired
	private NewHandService newHandService;
	
	/**
	 * 
	* query查询新手指南 
	* TODO查询新手指南
	* @author 杨翰林  
	* * @Title: query 
	* @Description: 查询新手指南 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午3:00:53
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public NewHandEntity query() {
		
		NewHandEntity entity = newHandService
				.selectNewHandList();
		return entity;
	}
	
	/**
	 * 
	* save添加修改新手指南 
	* TODO添加修改新手指南
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加修改新手指南 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 下午3:03:58
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		NewHandEntity newHandEntity = new NewHandEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String content = request.getParameter("content");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(52001);
		entity.setlModuleId(520);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		if (!"".equals(content)) {
			int num = newHandService.insertNewHand(newHandEntity, entity, sIpInfo);
			return num;
		}else {
			return 0;
		}
		
	}
}

