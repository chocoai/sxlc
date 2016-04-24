//
//package cn.springmvc.controller.frontconfig;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import product_p2p.kit.HttpIp.AddressUtils;
//import product_p2p.kit.optrecord.InsertAdminLogEntity;
//import product_p2p.kit.pageselect.PageEntity;
//
//import cn.springmvc.model.Admin;
//import cn.springmvc.model.FriendshipUnitEntity;
//import cn.springmvc.service.FriendshipLinkService;
//import cn.springmvc.util.HttpSessionUtil;
//import cn.springmvc.util.LoadUrlUtil;
//
///**
// * 
//* @author 杨翰林
//* @Description: 友情连接控制曾
//* @since 
//* @date 2016-4-21 下午3:16:28
// */
//@Controller
//@RequestMapping("/link")
//public class FriendLinkController {
//
//	@Autowired
//	private FriendshipLinkService friendshipLinkService;
//	
//	/**
//	 * 
//	* list查询友情链接列表 
//	* TODO查询友情链接列表
//	* @author 杨翰林  
//	* * @Title: list 
//	* @Description: 查询友情链接列表 
//	* @param @param req
//	* @param @param request
//	* @param @return 设定文件 
//	* @return PageEntity 返回类型 
//	* @date 2016-4-21 下午3:36:00
//	* @throws
//	 */
//	@RequestMapping("/list")
//	@ResponseBody
//	public PageEntity list(Map<String, Object> req, HttpServletRequest request) {
//		
//		PageEntity pager = new PageEntity();
//		
//		String name = request.getParameter("name");
//		String statu = request.getParameter("statu");
//		String length = request.getParameter("length");
//		String start = request.getParameter("start");
//		
//		if (name != null && name != "") {
//			req.put("name", name);
//		}
//		if (statu != null && statu != "") {
//			req.put("statu", statu);
//		}else {
//			req.put("statu", -1);
//		}
//		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
//		pager.setPageSize(Integer.valueOf(length));
//		pager.setMap(req);
//		
//		List<FriendshipUnitEntity> results = friendshipLinkService.selectFriendshipLinkListpage(pager);
//		pager.setResults(results);
//		
//		return pager;
//	}
//	
//	/**
//	 * 
//	* save添加友情链接 
//	* TODO添加友情链接
//	* @author 杨翰林  
//	* * @Title: save 
//	* @Description: 添加友情链接
//	* @param @param request
//	* @param @return 设定文件 
//	* @return int 返回类型 
//	* @date 2016-4-21 下午4:03:01
//	* @throws
//	 */
//	@RequestMapping("/save")
//	@ResponseBody
//	public int save(HttpServletRequest request) {
//		
//		FriendshipUnitEntity friendEntity = new FriendshipUnitEntity();
//		HttpSession session = HttpSessionUtil.getSession(request);
//		InsertAdminLogEntity entity = new InsertAdminLogEntity();
//		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
//		
//		String name = request.getParameter("name");
//		String url = request.getParameter("url");
//		
//		if (name != null && name != "") {
//			friendEntity.setName(name);
//		}
//		if (url != null && url != "") {
//			friendEntity.setUrl(url);
//		}
//			friendEntity.setOptId(userInfo.getId());
//			
//			String [] sIpInfo = new String[6];
//			if (userInfo != null) {
//				entity.setiAdminId(userInfo.getId());
//			}
//			entity.setlOptId(51401);
//			entity.setlModuleId(514);
//			entity.setsDetail("");
//			entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
//			entity.setsMac(null);
//			entity.setsUrl(LoadUrlUtil.getFullURL(request));
//			
//			int num = friendshipLinkService.insertFriendshipLink(friendEntity);
//			
//		return num;
//	}
//	
//	/**
//	 * 
//	* update修改友情链接 
//	* TODO修改友情链接
//	* @author 杨翰林  
//	* * @Title: update 
//	* @Description: 修改友情链接 
//	* @param @param request
//	* @param @return 设定文件 
//	* @return int 返回类型 
//	* @date 2016-4-21 下午4:02:07
//	* @throws
//	 */
//	@RequestMapping("/update")
//	@ResponseBody
//	public int update(HttpServletRequest request) {
//		
//		FriendshipUnitEntity friendEntity = new FriendshipUnitEntity();
//		HttpSession session = HttpSessionUtil.getSession(request);
//		InsertAdminLogEntity entity = new InsertAdminLogEntity();
//		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
//		
//		String name = request.getParameter("name");
//		String url = request.getParameter("url");
//		String friendLinkId = request.getParameter("friendLinkId");
//		
//		if (name != null && name != "") {
//			friendEntity.setName(name);
//		}
//		if (url != null && url != "") {
//			friendEntity.setUrl(url);
//		}
//		if (friendLinkId != null && friendLinkId != "") {
//			friendEntity.setId(Long.valueOf(friendLinkId));
//		}
//		
//		String [] sIpInfo = new String[6];
//		if (userInfo != null) {
//			entity.setiAdminId(userInfo.getId());
//		}
//		entity.setlOptId(51402);
//		entity.setlModuleId(514);
//		entity.setsDetail("");
//		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
//		entity.setsMac(null);
//		entity.setsUrl(LoadUrlUtil.getFullURL(request));
//		
//		int num = friendshipLinkService.updateFriendshipLinkByID(friendEntity);
//		
//		return num;
//	}
//	
//	/**
//	 * 
//	* delete 删除友情链接 
//	* TODO删除友情链接
//	* @author 杨翰林  
//	* * @Title: delete 
//	* @Description: 删除友情链接 
//	* @param @param request
//	* @param @return 设定文件 
//	* @return int 返回类型 
//	* @date 2016-4-21 下午4:01:08
//	* @throws
//	 */
//	@RequestMapping("/delete")
//	@ResponseBody
//	public int delete (HttpServletRequest request) {
//		
//		HttpSession session = HttpSessionUtil.getSession(request);
//		InsertAdminLogEntity entity = new InsertAdminLogEntity();
//		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
//		
//		String friendLinkId = request.getParameter("friendLinkId");
//		
//		String [] sIpInfo = new String[6];
//		if (userInfo != null) {
//			entity.setiAdminId(userInfo.getId());
//		}
//		entity.setlOptId(51403);
//		entity.setlModuleId(514);
//		entity.setsDetail("");
//		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
//		entity.setsMac(null);
//		entity.setsUrl(LoadUrlUtil.getFullURL(request));
//		
//		int num = friendshipLinkService.deleteFriendshipLinkByID(Integer.valueOf(friendLinkId));
//		
//		return num;
//	}
//}
//
