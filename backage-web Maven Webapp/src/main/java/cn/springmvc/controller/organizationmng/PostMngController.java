package cn.springmvc.controller.organizationmng;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.model.PostInfo;
import cn.springmvc.model.RoleInfo;
import cn.springmvc.model.Trui;
import cn.springmvc.service.IDeptInfoServer;
import cn.springmvc.service.IPostInfoServer;


/**
 * @author 
 * 职务控制层 
 * @date:2016-3-29 下午8:24:15
 **/
@Controller
@RequestMapping(value ="/PostController")
public class PostMngController {
	
	@Resource(name="postInfoServerImpl")
	private  IPostInfoServer iPostInfoServer;
	@Resource(name="deptInfoServerImpl")
	private  IDeptInfoServer ideptInfoServer;

	/**
	 * 获取部门列表
	 * TODO
	 * 创建日期：2016-4-22下午6:56:21
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return String
	 */
	@RequestMapping(value ="/getDeptList", method = RequestMethod.GET)
	public String getDeptList(HttpServletRequest request){
		List<DeptInfo>  list  = ideptInfoServer.getDeptList();
		
		request.setAttribute("deptList", list);
		//return new ModelAndView("web/role/role.jsp");
		return "role/role-post";
	}
	/**
	 * 部门树状框架对应的职务信息
	 * @return
	 */	
	@RequestMapping(value ="/finddapt")
	@ResponseBody
	public List<Trui> finddapt(HttpServletRequest request){
	    List<DeptInfo> list= ideptInfoServer.findall();
	    List<Trui> treeList= new ArrayList<Trui>(); 
		Trui entity = new Trui();	
		long sPreId = 0 ;
		long sNodeId = 0;
		DeptInfo deptEntity = null;
		if(list!=null && list.size()>0){
			for (int i = 0; i <  list.size(); i++) {
				deptEntity = list.get(i);
				entity = new Trui();	
				long prevId = list.get(i).getId();
				if(list.get(i).getDeptLevel() !=-1){//部门等级
					prevId = list.get(i).getId();
				}
				
				if(prevId == 0){
					entity.setAccessPath("");
					entity.setChecked(true);  //是否选中
				}else{
					String accessPath ="PostController/getPostList.do?deptId="+deptEntity.getId() ;
					entity.setAccessPath(accessPath);
					entity.setChecked(false);  //是否选中
				}
				entity.setDelFlag(0);
				
				if(deptEntity.getId() == -1){
					sNodeId = 0 ;
				}else{
					sNodeId = deptEntity.getId() ;
				}
				if(deptEntity.getPreDeptId() == null && deptEntity.getPreDeptId() <= 0){
					sPreId =  0;
				}else{
					sPreId =  deptEntity.getPreDeptId();
				}
				entity.setParentID(sPreId);  //上级
				entity.setResourceCode(""); 
				entity.setResourceDesc("");
				entity.setResourceGrade(0);
				entity.setResourceID(sNodeId);   //编号
				
				entity.setResourceName(deptEntity.getDeptName());
				entity.setResourceOrder(0);
				entity.setResourceType(""); 
				treeList.add(entity);
			}
		}
		return	treeList;
	}

	/**
	 * TODO 职务列表
	 * 创建日期：2016-3-30下午8:22:02
	 * 修改日期：
	 * @param
	 * return void
	 */
	@RequestMapping(value ="/getPostList")
	@ResponseBody
	public PageEntity getPostList(HttpServletRequest request){
		Map<String ,Object> param = new HashMap<String, Object>();
		String postName =request.getParameter("postName");
		String deptName = request.getParameter("deptName");
		String startTime = request.getParameter("startTime");
		String  endTime = request.getParameter("endTime");
		long   deptId =IntegerAndString.StringToLong(request.getParameter("deptId"),0);
		param.put("deptId", deptId);
		if(postName!=null && !postName.equals("")){
			param.put("postName", postName);
		}
		if(deptName!=null&& !deptName.equals("")){
			param.put("deptName", deptName);
		}
		if(startTime!=null && !startTime.equals("")){
			param.put("startTime", startTime);
		}
		if(endTime!=null && !endTime.equals("")){
			param.put("endTime", endTime);
		}
		String sKey = DbKeyUtil.GetDbCodeKey();
		param.put("sKey", sKey);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setMap(param);
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		iPostInfoServer.getListByParam(pageEntity);
		return pageEntity;
	}
	
	
	/**
	 * TODO 持久化一个职务  即保存
	 * 创建日期：2016-3-30下午8:31:49
	 * return void
	 */
	@RequestMapping(value ="/savePost")
	@ResponseBody
	public int  savePost(HttpServletRequest request){
		//,Map<String ,Object> req,Integer id,String deptname
		//,String postNo,String postName,String postRemark
		String postName =request.getParameter("postName");
		long depeId = IntegerAndString.StringToLong(request.getParameter("depeId"),0);
		String postRemark = request.getParameter("postRemark");
		PostInfo post =new PostInfo();
		post.setPostName(postName);
		IdGeneratorUtil generatorUtil = new IdGeneratorUtil();
		long id = generatorUtil.GetId();
		post.setId(id);
		post.setPostNo(id+"");
		post.setDeptId(depeId);
		post.setPostRemark(postRemark);
		
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10201);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int    iResult = iPostInfoServer.savePost(post,entity,sIpInfo);
		return iResult;
	}
	
	
	/**
	 * TODO 修改一个职务
	 * 创建日期：2016-3-30下午8:32:44
	 * 修改日期：
	 * return int
	 */
	@RequestMapping(value ="/editPost")
	@ResponseBody
	public int editPost(HttpServletRequest request){
		String postName =request.getParameter("postName");
		long depeId = IntegerAndString.StringToLong(request.getParameter("depeId"),0);
		String postRemark = request.getParameter("postRemark");
		long id = IntegerAndString.StringToLong(request.getParameter("lId"),0);
		PostInfo post =new PostInfo();
		post.setPostName(postName);
		post.setId(id);
		post.setDeptId(depeId);
		post.setPostRemark(postRemark);
		
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10202);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult = iPostInfoServer.editPost(post,entity,sIpInfo);
		return iResult;
	}
	
	
	/**
	 * TODO 
	 * 创建日期：2016-3-30下午8:33:54
	 * return int删除 
	 */
	@RequestMapping(value ="/delPost")
	@ResponseBody
	public int delPost(HttpServletRequest request){
		PostInfo post =new PostInfo();
		
		long postId = IntegerAndString.StringToLong(request.getParameter("lId"),0);
		post.setId(postId);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10203);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int iResult = iPostInfoServer.delPost(post,entity,sIpInfo);
		return iResult ;
	}
	
	/**
	 * 停用启用职务
	 * TODO
	 * 创建日期：2016-4-22下午4:08:38
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/ofPost", method = RequestMethod.POST)
	@ResponseBody
	public int ofPost(HttpServletRequest request){
		long id =IntegerAndString.StringToLong(request.getParameter("lId"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		
		PostInfo info = new PostInfo();
		info.setId(id);
		info.setPostStatu(statu);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String[] sIpinfo = new String[6];
		Admin loginAdmin = (Admin) request.getSession().getAttribute("LoginPerson");
		if(loginAdmin!=null && loginAdmin.getId()>0){
			entity.setiAdminId(loginAdmin.getId());
		}
		
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpinfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(102);
		entity.setlOptId(10204);
		int result = iPostInfoServer.ofPost(info, entity, sIpinfo);
		return result;
	}
	
	
}
