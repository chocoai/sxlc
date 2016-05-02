package cn.springmvc.controller.frontconfig;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.FootNavBarEntity;
import cn.springmvc.model.FootNavBarTypeEntity;
import cn.springmvc.service.FootNavBarService;
import cn.springmvc.service.FootNavBarTypeService;
import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
/**
 * 
* @author 杨翰林 
* @Description: 底部链接控制层 
* @since 
* @date 2016-4-25 下午3:39:52
 */
@Controller
@RequestMapping("/bootLink")
public class BootLinkController {
	
	@Autowired
	private FootNavBarService footNavBarService;
	@Autowired
	private FootNavBarTypeService footNavBarTypeService;
	
	/**
	 * 
	* list查询底部连接 
	* TODO查询底部连接
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询底部连接 
	* @param @param req
	* @param @param request
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-25 下午3:40:19
	* @throws
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String title = request.getParameter("title");
		String statu = request.getParameter("statu");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		if (!"".equals(title)) {
			req.put("title", title);
		}
		if ("".equals(statu)) {
			req.put("statu", statu);
		}else {
			req.put("statu", -1);
		}
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<FootNavBarEntity> result = footNavBarService.selectFootNavBarListpage(pager);
		pager.setResults(result);
		
		return pager;
		
	}
	
	/**
	 * 
	* save添加底部导航 
	* TODO添加底部导航
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加底部导航
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-25 下午3:40:50
	* @throws
	 */
	@RequestMapping("/save")
	public int save(HttpServletRequest request) {
		
		FootNavBarEntity footEntity = new FootNavBarEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String typeId = request.getParameter("typeId");
		
		if (!"".equals(title)) {
			footEntity.setTitle(title);
		}
		if (!"".equals(url)) {
			footEntity.setUrl(url);
		}
		if (!"".equals(typeId)) {
			footEntity.setTypeId(Long.valueOf(typeId));
		}
			footEntity.setOptId(userInfo.getId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51501);
		entity.setlModuleId(515);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = footNavBarService.insertFootNavBar(footEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* update修改底部连接 
	* TODO修改底部连接 
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改底部连接  
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-25 下午3:42:31
	* @throws
	 */
	@RequestMapping("/update")
	public int update(HttpServletRequest request) {
		
		FootNavBarEntity footEntity = new FootNavBarEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String typeId = request.getParameter("typeId");
		String bootId = request.getParameter("bootId");
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		if (!"".equals(title)) {
			footEntity.setTitle(title);
		}
		if (!"".equals(url)) {
			footEntity.setUrl(url);
		}
		if (!"".equals(typeId)) {
			footEntity.setTypeId(Long.valueOf(typeId));
		}
		if (!"".equals(bootId)) {
			footEntity.setId(Long.valueOf(bootId));
		}
		footEntity.setOptId(userInfo.getId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51502);
		entity.setlModuleId(515);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = footNavBarService.updateFootNavBarByID(footEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* ofOrOpen启用停用底部连接 
	* TODO启用停用底部连接
	* @author 杨翰林  
	* * @Title: ofOrOpen 
	* @Description: 启用停用底部连接 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-25 下午3:48:09
	* @throws
	 */
	@RequestMapping("/ofOrOpen")
	public int ofOrOpen(HttpServletRequest request) {
		
		FootNavBarEntity footEntity = new FootNavBarEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String statu = request.getParameter("statu");
		String bootId = request.getParameter("bootId");
		footEntity.setStatu(Integer.valueOf(statu));
		if (bootId != null && bootId != "") {
			footEntity.setId(Long.valueOf(bootId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51503);
		entity.setlModuleId(515);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = footNavBarService.updateFootNavBarStatuByID(footEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* query4type查询导航类型 
	* TODO查询导航类型 
	* @author 杨翰林  
	* * @Title: query4type 
	* @Description: 查询导航类型  
	* @param @return 设定文件 
	* @return List<FootNavBarTypeEntity> 返回类型 
	* @date 2016-4-26 上午10:21:25
	* @throws
	 */
	@RequestMapping("/query4type")
	@ResponseBody
	public List<FootNavBarTypeEntity> query4type() {
		
		List<FootNavBarTypeEntity> result = footNavBarTypeService.selectFootNavBarType();
		
		return result;
	}
}
