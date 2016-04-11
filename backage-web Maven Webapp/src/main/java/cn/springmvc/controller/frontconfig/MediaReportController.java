
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
	
	
	/** 
	* @author 唐国峰  
	* @Description: 跳转到媒体报道页面
	* @return String
	* @date 2016-4-11 上午9:16:51
	* @throws 
	*/
	@RequestMapping("/toMediRepList")
	public String toMediRepList(HttpServletRequest req){
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "frontconfig/fc-mediaReport";
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: dataTables表格数据获取
	* @return PageEntity
	* @date 2016-4-11 上午10:33:38
	* @throws 
	*/
	@RequestMapping("/getMediaData")
	@ResponseBody
	public PageEntity getMediaData(int start,int length,String addDate,String name,HttpServletRequest request,HttpServletResponse res){
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MediaReportsEntity>  teams = mediaReportsService.selectMediaReportsListpage(pager);
		pager.setResults(teams);
		return pager;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 新增媒体报道
	* @return int
	* @date 2016-4-11 上午10:33:56
	* @throws 
	*/
	@RequestMapping("/addMediaReport")
	@ResponseBody
	public int addMediaReport(MediaReportsEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		entity.setStatu(1);
		entity.setOptId(1);//操作员id,暂时写死
		result = mediaReportsService.insertMediaReports(entity);
		return result;
	}
	
	
	
	/** 
	* @author 唐国峰  
	* @Description: 修改媒体报道
	* @return int
	* @date 2016-4-11 上午10:34:17
	* @throws 
	*/
	@RequestMapping("/editMediaReport")
	@ResponseBody
	public int editMediaReport(Long reportId,MediaReportsEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		entity.setId(reportId);
		entity.setStatu(1);
		entity.setOptId(1);//操作员id,暂时写死
		result = mediaReportsService.updateMediaReportsByID(entity);
		return result;
	}
	
	
	
	/** 
	* @author 唐国峰  
	* @Description: 停用或启用媒体报道信息
	* @return int
	* @date 2016-4-11 上午10:34:35
	* @throws 
	*/
	@RequestMapping("/enableMediRepo")
	@ResponseBody
	public int enableMngTeam( MediaReportsEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		result = mediaReportsService.updateMediaReportsStatuByID(entity);
		return result;
	}
	
}

