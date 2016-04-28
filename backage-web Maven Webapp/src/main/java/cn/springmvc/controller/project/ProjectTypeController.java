package cn.springmvc.controller.project; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.service.ProjectBaseInfoService;

/** 
* @author 唐国峰
* @Description:  项目管理控制器
* @date 2016-4-28 下午12:35:19 
*/
@Controller
@RequestMapping("/project")
public class ProjectTypeController {
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	
	/** 
	 * @author 唐国峰 
	 * @Description:跳转到项目类型管理页面 
	 * @param req
	 * @return String  
	 * @date 2016-4-28 下午12:38:13
	 * @throws 
	 */
	@RequestMapping("/toProTypePg")
	public String toProTypePg(HttpServletRequest req){
		return "project/pro_type";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取分页项目类型数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-4-28 下午3:00:05
	 * @throws 
	 */
	@RequestMapping("/getProTypeData")
	@ResponseBody
	public PageEntity getProTypeData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String projectName = req.getParameter("projectName");
		String statu = req.getParameter("statu");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("projectName", projectName);
		param.put("statu", statu);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		projectBaseInfoService.selectProjectBaseInfoListpage(pager);
		return pager;
	}
	
	
	
}

