
package cn.springmvc.controller.frontconfig; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.NewEventEntity;
import cn.springmvc.service.NewEventService;

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
	
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, String title, String statu) {
		
		PageEntity pager = new PageEntity();
		
		if (title != null && title != "") {
			req.put("title", title);
		}
		if (statu != null && statu != "") {
			req.put("statu", statu);
		}
		pager.setPageNum(1);
		pager.setPageSize(10);
		pager.setMap(req);
		
		List<NewEventEntity> results = newEventService.selectNewEventListpage(pager);
		pager.setResults(results);
		
		return pager;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public int save(String title, String content, String optId) {
		
		NewEventEntity entity = new NewEventEntity();
		
		if (title != null && title != "") {
			entity.setTitle(title);
		}
		if (content != null && content != "") {
			entity.setContent(content);
		}
		if (optId != null && optId != "") {
			entity.setOptId(Long.valueOf(optId));
		}
		
		int num = newEventService.insertNewEvent(entity);
		return num;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public int update(String title, String content, String optId, String newsId) {
		
		NewEventEntity entity = new NewEventEntity();
		
		if (title != null && title != "") {
			entity.setTitle(title);
		}
		if (content != null && content != "") {
			entity.setContent(content);
		}
		if (optId != null && optId != "") {
			entity.setOptId(Long.valueOf(optId));
		}
		if (newsId != null && newsId != "") {
			entity.setId(Long.valueOf(newsId));
		}
		
		int num = newEventService.updateNewEventByID(entity);
		return num;
	}
	
	@RequestMapping("/ofOrOpenNews")
	@ResponseBody
	public int ofOrOpenNews(String newsId, String statu) {
		
		NewEventEntity entity = new NewEventEntity();
		
		if (newsId != null && newsId != "") {
			entity.setId(Long.valueOf(newsId));
		}
		if (statu != null && statu != "") {
			entity.setStatu(statu);
		}
		
		int num = newEventService.updateNewEventStatuByID(entity);
		return num;
	}
	
}

