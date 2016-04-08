
package cn.springmvc.controller.frontconfig; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.service.MediaReportsService;

import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.pageselect.PageEntity;

/** 
* @author 唐国峰
* @Description:媒体报道控制器
* @since 
* @date 2016-4-8 上午11:50:54  
*/
@Controller
@RequestMapping("/front")
public class MediaReportController {
	@Resource(name="")
	private MediaReportsService mediaReportsService;
	
	@RequestMapping("/toMediRepList")
	public String toMediRepList(HttpServletRequest req){
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "frontconfig/fc-mediaReport";
	}
	
	@RequestMapping("/getMediaData")
	@ResponseBody
	public PageEntity getMediaData(int start,int length,String addDate,String name,HttpServletRequest request,HttpServletResponse res){
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("mngName", name);
		param.put("startTime", addDate);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MediaReportsEntity>  teams = mediaReportsService.selectMediaReportsListpage(pager);
		pager.setResults(teams);
		return pager;
	}
	
	
}

