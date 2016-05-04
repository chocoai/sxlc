
package cn.springmvc.controller.frontconfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.model.PlatformIntroduceEntity;
import cn.springmvc.service.PlatformIntroduceService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 平台简介控制层 
* @since 
* @date 2016-4-26 下午3:48:36
 */
@Controller
@RequestMapping("/platform")
public class PlatFormIntroductionController {

	@Autowired
	PlatformIntroduceService platformIntroduceService;
	
	/**
	 * 
	* query查询平台简介 
	* TODO查询平台简介 
	* @author 杨翰林  
	* * @Title: query 
	* @Description: 查询平台简介  
	* @param @return 设定文件 
	* @return NewHandEntity 返回类型 
	* @date 2016-4-26 下午3:50:18
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public PlatformIntroduceEntity query() {
		
		PlatformIntroduceEntity entity = platformIntroduceService.
				selectPlatformIntroduceList();
		return entity;
	}
	
	/**
	 * 
	* save添加修改平台简介 
	* TODO添加修改平台简介
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加修改平台简介 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 下午3:52:26
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		PlatformIntroduceEntity platformIntroduceEntity = new PlatformIntroduceEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String content = request.getParameter("content");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51901);
		entity.setlModuleId(519);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		if (!"".equals(content)) {
			int num = platformIntroduceService.insertPlatformIntroduce(platformIntroduceEntity, entity, sIpInfo);
			return num;
		}else {
			return 0;
		}
		
	}
}

