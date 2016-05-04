
package cn.springmvc.controller.frontconfig; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.service.MediaReportsService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

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
	public PageEntity getMediaData(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		mediaReportsService.selectMediaReportsListpage(pager);
		return pager;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 新增或修改媒体报道
	* @return int
	* @date 2016-4-11 上午10:33:56
	* @throws 
	*/
	@RequestMapping("/addOrUpdateReport")
	@ResponseBody
	public int addMediaReport(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=507(媒体报道管理)
		//optID=50701(添加）50702 修改
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(507);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MediaReportsEntity entity = new MediaReportsEntity();
		String title = req.getParameter("title");
		entity.setTitle(title);
		String source = req.getParameter("source");
		entity.setSource(source);
		String logo = req.getParameter("logo");
		entity.setLogo(logo);
		String content = req.getParameter("content");
		entity.setContent(content);
		
		int result=0;
		entity.setStatu(1);
		entity.setOptId(admin.getId());//操作员id
		
		String type = req.getParameter("type");
		if(type.equals("1")){//增加操作
			logEntity.setlOptId(50701);
			result = mediaReportsService.insertMediaReports(entity,logEntity,sIpInfo);
		}else if(type.equals("2")){//修改操作
			logEntity.setlOptId(50702);
			Long reportId = Long.parseLong(req.getParameter("reportId"));
			entity.setId(reportId);
			result = mediaReportsService.updateMediaReportsByID(entity,logEntity,sIpInfo);
		}
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
	public int enableMngTeam(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=507(媒体报道管理)
		//optID=50703(停用/启用）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(507);
		logEntity.setlOptId(50703);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MediaReportsEntity entity = new  MediaReportsEntity();
		int statu = Integer.parseInt(req.getParameter("statu"));
		entity.setStatu(statu);
		Long id = Long.parseLong(req.getParameter("id"));
		entity.setId(id);
		
		int result=0;
		result = mediaReportsService.updateMediaReportsStatuByID(entity,logEntity,sIpInfo);
		return result;
	}
	
}

