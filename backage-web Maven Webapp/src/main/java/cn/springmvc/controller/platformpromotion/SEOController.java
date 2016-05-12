
package cn.springmvc.controller.platformpromotion; 

import java.util.List;
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
import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.SeoSetTypeEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.ExtensionModuleService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: seo控制层 
* @since 
* @date 2016-5-10 下午4:58:10
 */
@Controller
@RequestMapping("/seo")
public class SEOController {

	@Resource(name="extensionModuleServiceImpl")
	private ExtensionModuleService extensionModuleService;
	
	/**
	 * 
	* seoList查询seo设置列表 
	* TODO查询seo设置列表 
	* @author 杨翰林  
	* * @Title: seoList 
	* @Description: 查询seo设置列表  
	* @param @param request
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-10 下午5:04:15
	* @throws
	 */
	@RequestMapping("/seoList")
	@ResponseBody
	public PageEntity seoList(HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleService.getSEODisplay(pager);
		
		return pager;
	}
	
	/**
	 * 
	* addSEO添加、修改seo 
	* TODO添加、修改seo
	* @author 杨翰林  
	* * @Title: addSEO 
	* @Description: 添加、修改seo 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-10 下午5:21:35
	* @throws
	 */
	@RequestMapping("/addSEO")
	@ResponseBody
	public int addSEO(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String title = request.getParameter("seoTitle");
		String description = request.getParameter("seoDescription");
		String keyword = request.getParameter("seoKeyword");
		String seotype = request.getParameter("seoTypeName");
		String seoId = request.getParameter("seoId");
		
		if (seoId != null && !"".equals(seoId)) {
			req.put("lId", seoId);
		}
		req.put("title", title);
		req.put("description", description);
		req.put("keyword", keyword);
		req.put("seotype", seotype);
		req.put("adminID", userInfo.getId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(1005);
		entity.setlModuleId(2);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleService.seoSet(req, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* query4select查询下拉 
	* TODO查询下拉
	* @author 杨翰林  
	* * @Title: query4select 
	* @Description: 查询下拉 
	* @param @return 设定文件 
	* @return List<SeoSetTypeEntity> 返回类型 
	* @date 2016-5-10 下午6:48:29
	* @throws
	 */
	@RequestMapping("/query4select")
	@ResponseBody
	public List<SeoSetTypeEntity> query4select() {
		
		List<SeoSetTypeEntity> list = extensionModuleService.getSeoSetType();
		
		return list;
	}
	
	/**
	 * 
	* del删除seo设置 
	* TODO删除seo设置
	* @author 杨翰林  
	* * @Title: del 
	* @Description: 删除seo设置 
	* @param @param request
	* @param @return 设定文件 
	* @return List<SeoSetTypeEntity> 返回类型 
	* @date 2016-5-10 下午6:54:47
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int del(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String seoSetID = request.getParameter("seoSetID");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(1005);
		entity.setlModuleId(2);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleService.
				seoDelete(IntegerAndString.StringToInt(seoSetID), entity, sIpInfo);
		
		return num;
	}
}

