
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
import cn.springmvc.model.LawsRegulationsEntity;
import cn.springmvc.service.LawsRegulationsService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 法律法规控制层 
* @since 
* @date 2016-4-26 下午4:02:50
 */
@Controller
@RequestMapping("/law")
public class LawsRulesController {
	
	@Autowired
	private LawsRegulationsService lawsRegulationsService;
	
	/**
	 * 
	* query查询法律法规 
	* TODO查询法律法规
	* @author 杨翰林  
	* * @Title: query 
	* @Description: 查询法律法规 
	* @param @return 设定文件 
	* @return LawsRegulationsEntity 返回类型 
	* @date 2016-4-26 下午4:04:51
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public LawsRegulationsEntity query() {
		
		LawsRegulationsEntity entity = lawsRegulationsService.selectLawsRegulationsList();
		return entity;
	}
	
	/**
	 * 
	* save添加修改法律法规 
	* TODO添加修改法律法规
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加修改法律法规 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-26 下午4:06:09
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		LawsRegulationsEntity lawsRegulationsEntity = new LawsRegulationsEntity();
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
			int num = lawsRegulationsService.insertLawsRegulations(lawsRegulationsEntity, entity, sIpInfo);
			return num;
		}else {
			return 0;
		}
		
	}
}

