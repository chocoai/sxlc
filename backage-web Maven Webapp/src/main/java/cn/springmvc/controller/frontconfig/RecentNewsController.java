
package cn.springmvc.controller.frontconfig; 

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Admin;
import cn.springmvc.model.NewEventEntity;
import cn.springmvc.service.NewEventService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林
* @Description: 最新动态控制层
* @since 
* @date 2016-4-8 下午4:01:55
 */
@Controller
@RequestMapping("/news")
public class RecentNewsController {

	@Autowired
	NewEventService newEventService;
	
	/**
	 * 
	* list查询最新动态列表 
	* TODO查询最新动态列表
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询最新动态列表 
	* @param @param req
	* @param @param title
	* @param @param statu
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-11 上午10:27:02
	* @throws
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String title = request.getParameter("title");
		String statu = request.getParameter("statu");
		int start = Integer.valueOf(request.getParameter("start"));
		int length = Integer.valueOf(request.getParameter("length"));
		if (title != null && title != "") { 
			req.put("title", title);
		}
		if (statu != null && statu != "") {
			req.put("statu", statu);
		}else {
			req.put("statu", -1);
		}
		pager.setPageNum(start / length + 1);
		pager.setPageSize(length);
		pager.setMap(req);
		
		List<NewEventEntity> results = newEventService.selectNewEventListpage(pager);
		pager.setResults(results);
		
		return pager;
	}
	
	/**
	 * 
	* save添加最新动态 
	* TODO添加最新动态
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加最新动态 
	* @param @param title
	* @param @param content
	* @param @param optId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 上午10:27:45
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		NewEventEntity newEventEntity = new NewEventEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (title != null && title != "") {
			newEventEntity.setTitle(title);
		}
		if (content != null && content != "") {
			newEventEntity.setContent(content);
		}
		newEventEntity.setOptId(Long.valueOf(1));
			
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(50601);
		entity.setlModuleId(506);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = newEventService.insertNewEvent(newEventEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* update修改最新动态 
	* TODO修改最新动态
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改最新动态 
	* @param @param title
	* @param @param content
	* @param @param optId
	* @param @param newsId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 上午10:28:09
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		NewEventEntity newEventEntity = new NewEventEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String optId = request.getParameter("optId");
		String newsId = request.getParameter("newsId");
		if (title != null && title != "") {
			newEventEntity.setTitle(title);
		}
		if (content != null && content != "") {
			newEventEntity.setContent(content);
		}
		if (optId != null && optId != "") {
			newEventEntity.setOptId(Long.valueOf(optId));
		}
		if (newsId != null && newsId != "") {
			newEventEntity.setId(Long.valueOf(newsId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(50602);
		entity.setlModuleId(506);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = newEventService.updateNewEventByID(newEventEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 启用停用最新动态
	* ofOrOpenNews启用停用最新动态 
	* TODO启用停用最新动态
	* @author 杨翰林  
	* * @Title: ofOrOpenNews 
	* @Description: 启用停用最新动态 
	* @param @param newsId
	* @param @param statu
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 上午10:28:30
	* @throws
	 */
	@RequestMapping("/ofOrOpenNews")
	@ResponseBody
	public int ofOrOpenNews(HttpServletRequest request) {
		
		NewEventEntity newEventEntity = new NewEventEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String newsId = request.getParameter("newsId");
		String statu = request.getParameter("statu");
		if (newsId != null && newsId != "") {
			newEventEntity.setId(Long.valueOf(newsId));
		}
		if (statu != null && statu != "") {
			newEventEntity.setStatu(Integer.valueOf(statu));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(50603);
		entity.setlModuleId(506);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = newEventService.updateNewEventStatuByID(newEventEntity, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 通过id查动态
	* query4update通过id查动态 
	* TODO通过id查动态
	* @author 杨翰林  
	* * @Title: query4update 
	* @Description: 通过id查动态 
	* @param @param newsId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 上午10:29:00
	* @throws
	 */
	@RequestMapping("/query4update")
	@ResponseBody
	public NewEventEntity query4update(HttpServletRequest request) {
		
		String newsId = request.getParameter("newsId");
		NewEventEntity event = newEventService.
				selectNewEventByID(Integer.valueOf(newsId));
		return event;
	}
	
}

