package cn.springmvc.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.service.OverdueService;

/** 
* @author 唐国峰
* @Description: 逾期配置controller
* @date 2016-4-13 上午9:57:09 
*/
@Controller
@RequestMapping("config")
public class OverdueController {
	
	@Resource(name="overdueServiceImpl")
	private OverdueService overdueService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到逾期严重程度配置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-13 上午10:05:11
	 * @throws 
	 */
	@RequestMapping("/toOverdueLimit")
	public String toOverdueLimit(HttpServletRequest req){
		Integer overDays = overdueService.findOverdueLimit();
		req.setAttribute("overDays", overDays);
		return "config/late-allocation";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到逾期费用设置页面
	 * @return String  
	 * @date 2016-4-13 上午11:32:29
	 * @throws 
	 */
	@RequestMapping("/toOverdueList")
	public String toOverdueList(){
		return "config/late-fee";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 增加或修改逾期程度
	 * @return int 操作成功与否标志 
	 * @param overdueLimit 
	 * @date 2016-4-13 上午10:44:08
	 * @throws 
	 */
	@RequestMapping("/addOverdueLimit")
	@ResponseBody
	public int addOverdueLimit(String overdueLimit){
		Integer overDays = overdueService.findOverdueLimit();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("overdueLimit", overdueLimit);
		int result=0;
		if(null != overDays){
			 result = overdueService.updateOverdueLimit(map);
		}else{
			 result = overdueService.insertOverdueLimit(map);
		}
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 逾期费用设置表格查询
	 * @param start 开始条数
	 * @param length 页条数
	 * @return PageEntity 分页实体 
	 * @date 2016-4-13 上午11:56:31
	 * @throws 
	 */
	@RequestMapping("/getAllOverdue")
	@ResponseBody
	public PageEntity getAllOverdue(int start,int length){
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		overdueService.findAllOverdue(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 
	 * @param overdueMin
	 * @return int  
	 * @date 2016-4-13 下午1:37:50
	 * @throws 
	 */
	@RequestMapping("/deleteOverdue")
	@ResponseBody
	public int deleteOverdue(String overdueMin){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("overdueMin", overdueMin);
		int result=0;
		result = overdueService.deleteOverdue(map);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 增加数据 
	 * @param overdueEntity
	 * @return int  
	 * @date 2016-4-13 下午2:16:51
	 * @throws 
	 */
	@RequestMapping("/addOverdue")
	@ResponseBody
	public int addOrUpdate(OverdueEntity overdueEntity){
		int result=0;
		result = overdueService.insertOverdue(overdueEntity);
		return result;
	}
	
}
