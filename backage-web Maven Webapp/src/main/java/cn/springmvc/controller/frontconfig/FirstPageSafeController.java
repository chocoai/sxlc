
package cn.springmvc.controller.frontconfig; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.PlatformBoothEntity;
import cn.springmvc.service.PlatformBoothService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 * 首页四大安全保障管理
 * @date:2016-4-21 下午3:13:30
 **/
@Controller
@RequestMapping("/firstSecurity")
public class FirstPageSafeController {

	@Autowired
	PlatformBoothService platformBoothService;
	
	/**
	 * 查询首页4大安全保障管理
	 * TODO
	 * 创建日期：2016-4-21下午2:08:42
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping("/FirstSecurityList")
	@ResponseBody
	public PageEntity FirstSecurityList(HttpServletRequest request) {
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		List<PlatformBoothEntity>  list =  platformBoothService.selectPlatformBooth();
		pageEntity.setResults(list);
		return pageEntity;
	}
	
	/**
	 * 保存首页安全保障管理
	 * TODO
	 * 创建日期：2016-4-21下午2:13:40
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 *//*
	 /*	@RequestMapping("/SaveFirstSecurity")
	@ResponseBody
	public int SaveFirstSecurity(HttpServletRequest request) {
		PlatformBoothEntity entity = new PlatformBoothEntity();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String imgPath = request.getParameter("imgPath");
		String imgUrl =request.getParameter("imgUrl");
		entity.setAsTitle(title);
		entity.setSgContent(content);
		entity.setSgPic(imgUrl);
		entity.setSgPic(imgPath);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		entity.setAdminName(loginAdmin.getAdminName());
		entity.setAdminID(loginAdmin.getId());
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(513);
		logentity.setlOptId(51301);
		int iResult = platformBoothService.insertPlatformBooth(entity, logentity, sIpInfo);
		return iResult;
	}*/
	/**
	 * 修改首页安全保障管理
	 * TODO
	 * 创建日期：2016-4-21下午2:13:40
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/UpdateFirstSecurity")
	@ResponseBody
	public int UpdateFirstSecurity(HttpServletRequest request) {
		PlatformBoothEntity entity = new PlatformBoothEntity();
		long  sgID = IntegerAndString.StringToLong(request.getParameter("lId"),0);
		entity.setSgID(sgID);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String imgPath = request.getParameter("imgPath");
		String imgUrl =request.getParameter("imgUrl");
		entity.setAsTitle(title);
		entity.setSgContent(content);
		entity.setSgUrl(imgUrl);
		entity.setSgPic(imgPath);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpInfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		entity.setAdminName(loginAdmin.getAdminName());
		entity.setAdminID(loginAdmin.getId());
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(521);
		logentity.setlOptId(52101);
		int iResult = platformBoothService.updatePlatformBoothByID(entity, logentity, sIpInfo);
		return iResult;
	}	
	
	
	/**
	 * 停用启用安全保障管理
	 * TODO
	 * 创建日期：2016-4-21下午4:26:59
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/ofFirstSecurity", method = RequestMethod.POST)
	@ResponseBody
	public int ofFirstSecurity(HttpServletRequest request){
		long sgID =IntegerAndString.StringToLong(request.getParameter("lId"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		String[] sIpinfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			logentity.setiAdminId(loginAdmin.getId());
		}
		
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpinfo));
		logentity.setsMac("");
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		logentity.setlModuleId(521);
		logentity.setlOptId(52102);
		
		int result = platformBoothService.updatePlatformBoothStatu(statu, sgID, logentity, sIpinfo);
		return result;
	}
}

