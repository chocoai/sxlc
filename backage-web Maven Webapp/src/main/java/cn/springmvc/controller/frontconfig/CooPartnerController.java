
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
import cn.springmvc.model.PartnersEntity;
import cn.springmvc.service.PartnersService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林
* @Description: 合作伙伴控制层 
* @since 
* @date 2016-4-11 下午1:36:09
 */
@Controller
@RequestMapping("/coop")
public class CooPartnerController {
	
	@Autowired
	private PartnersService partnersService;
	
	/**
	 * 
	* list查询合作伙伴列表 
	* TODO查询合作伙伴列表 
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询合作伙伴列表  
	* @param @param req
	* @param @param start
	* @param @param length
	* @param @param name
	* @param @param statu
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-11 下午3:15:53
	* @throws
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String name = request.getParameter("name");
		String statu = request.getParameter("statu");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		if (name != null && name != "") {
			req.put("name", name);
		}
		if (statu != null && statu != "") {
			req.put("statu", statu);
		}else {
			req.put("statu", -1);
		}
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
	    partnersService.selectPartnersList(pager);
		
		return pager;
	}
	
	/**
	 * 
	* save添加合作伙伴 
	* TODO添加合作伙伴
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加合作伙伴 
	* @param @param logo
	* @param @param url
	* @param @param introduction
	* @param @param name
	* @param @param indexs
	* @param @param optId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:18:02
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		PartnersEntity partNer = new PartnersEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String title = request.getParameter("title");
		String logo = request.getParameter("logo");
		String url = request.getParameter("url");
		String introduction = request.getParameter("introduction");
		String indexs = request.getParameter("indexs");
		if (title != null && title != "") {
			partNer.setName(title);
		}
		if (logo != null && logo != "") {
			partNer.setLogo(logo);
		}
		if (url != null && url != "") {
			partNer.setUrl(url);
		}
		if (introduction != null && introduction != "") {
			partNer.setIntroduction(introduction);
		}
		if (indexs != null && indexs != "") {
			partNer.setIndexs(Integer.valueOf(indexs));
		}
			partNer.setOptId(userInfo.getId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51001);
		entity.setlModuleId(510);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = partnersService.insertPartners(partNer, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* update修改合作伙伴 
	* TODO修改合作伙伴 
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改合作伙伴  
	* @param @param logo
	* @param @param url
	* @param @param introduction
	* @param @param name
	* @param @param indexs
	* @param @param optId
	* @param @param partnerId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:17:34
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		PartnersEntity partNer = new PartnersEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String partnerId = request.getParameter("partnerId");
		String name = request.getParameter("name");
		String logo = request.getParameter("logo");
		String url = request.getParameter("url");
		String introduction = request.getParameter("introduction");
		String indexs = request.getParameter("indexs");
		String optId = request.getParameter("optId");
		
		if (partnerId != null && partnerId != "") {
			partNer.setId(Long.valueOf(partnerId));
		}
		if (name != null && name != "") {
			partNer.setName(name);
		}
		if (logo != null && logo != "") {
			partNer.setLogo(logo);
		}
		if (url != null && url != "") {
			partNer.setUrl(url);
		}
		if (introduction != null && introduction != "") {
			partNer.setIntroduction(introduction);
		}
		if (indexs != null && indexs != "") {
			partNer.setIndexs(Integer.valueOf(indexs));
		}
		if (optId != null && optId != "") {
			partNer.setOptId(Long.valueOf(optId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51002);
		entity.setlModuleId(510);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = partnersService.updatePartners(partNer, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* ofOrOpen启用停用合作伙伴 
	* TODO启用停用合作伙伴
	* @author 杨翰林  
	* * @Title: ofOrOpen 
	* @Description: 启用停用合作伙伴 
	* @param @param statu
	* @param @param partNerId
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-11 下午4:22:57
	* @throws
	 */
	@RequestMapping("/ofOrOpen")
	@ResponseBody
	public int ofOrOpen(HttpServletRequest request) {
		
		PartnersEntity partNer = new PartnersEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String statu = request.getParameter("statu");
		String partNerId = request.getParameter("partNerId");
		if("1".equals(statu)){
			partNer.setStatu(true);
		}else{
			partNer.setStatu(false);
		}
		if (partNerId != null && partNerId != "") {
			partNer.setId(Long.valueOf(partNerId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(51003);
		entity.setlModuleId(510);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = partnersService.updatePartnerStatuByID(partNer, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* query4update为修改查询单个实体  
	* TODO为修改查询单个实体 
	* @author 杨翰林  
	* * @Title: query4update 
	* @Description: 为修改查询单个实体  
	* @param @param partNerId
	* @param @return 设定文件 
	* @return PartnersEntity 返回类型 
	* @date 2016-4-11 下午4:26:12
	* @throws
	 */
	@RequestMapping("/query4update")
	@ResponseBody
	public PartnersEntity query4update (String partNerId){
		
		PartnersEntity partNer= partnersService.
				selectPartnerByID(Integer.valueOf(partNerId));
		return partNer;
	}
}

