package cn.springmvc.controller.organizationmng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.model.PostInfo;
import cn.springmvc.service.IDeptInfoServer;
import cn.springmvc.service.IPostInfoServer;
import cn.springmvc.util.LoadUrlUtil;


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
	private DeptInfo deptInfo;


	/**
	 * 部门树状框架对应的职务信息
	 * @return
	 */	
//	@RequestMapping(value ="/finddapt")
//	@ResponseBody
//	public List<Trui> finddapt( ){
//	    List<DeptInfo> list= ideptInfoServer.findall();
//	    List<Trui> treeList= new ArrayList<Trui>(); 
//		Trui entity = new Trui();	
//		String sPreId = "";
//		String sNodeId = "";
//		DeptInfo deptEntity = null;
//		if(list!=null && list.size()>0){
//			for (int i = 0; i <  list.size(); i++) {
//				deptEntity = list.get(i);
//				entity = new Trui();	
//				long prevId = list.get(i).getId();
//				if(list.get(i).getDeptLevel() !=-1){//部门等级
//					prevId = list.get(i).getId();
//				}
//				/*if(prevId == 0){
//					entity.setAccessPath("");
//					entity.setChecked("true");  //是否选中
//				}else{*/
//					entity.setAccessPath("web/role/role-post.jsp?prevId="+prevId);//右边的页面
//					entity.setChecked("false");  //是否选中
//				/*}*/
//				entity.setDelFlag("0");
//				
//				if(deptEntity.getId() == -1){
//					sNodeId = "si_" + deptEntity.getId() + "";
//				}else{
//					sNodeId = deptEntity.getId() + "";
//				}
//				if(deptEntity.getPreDeptId() != null && deptEntity.getPreDeptId() < 0){
//					sPreId = "si_" + (0- deptEntity.getPreDeptId())+"";
//				}else{
//					sPreId = deptEntity.getPreDeptId()+"";
//				}
//				entity.setParentID(sPreId);  //上级
//				entity.setResourceCode(""); 
//				entity.setResourceDesc("");
//				entity.setResourceGrade("0");
//				entity.setResourceID(sNodeId);   //编号
//				entity.setResourceName(deptEntity.getDeptName());
//				entity.setResourceOrder("0");
//				entity.setResourceType(""); 
//				treeList.add(entity);
//			}
//		}
//		return	treeList;
//	}

	/**
	 * TODO 职务列表
	 * 创建日期：2016-3-30下午8:22:02
	 * 修改日期：
	 * @param
	 * return void
	 */
	@RequestMapping(value ="/getPostList")
	@ResponseBody
	public PageEntity getPostList(Map<String ,Object> req,Integer pageNum,Integer pageSize,
			String deptNo,Integer id,String deptname,String postName,String postRemark,String addDate ){
		PageEntity page =new PageEntity();
		req.put("id", id);
		req.put("postName", postName);
		req.put("postRemark", postRemark);
		req.put("addDate", addDate);
		if (pageNum != null) {
			page.setPageNum(pageNum);
		}
		if (pageSize != null) {
			page.setPageSize(pageSize);
		}
		
		page.setMap(req);
		List<PostInfo>  list  = iPostInfoServer.getListByParam(page);
		page.setResults(list);
		return page;
	}
	
	
	/**
	 * TODO 持久化一个职务  即保存
	 * 创建日期：2016-3-30下午8:31:49
	 * return void
	 */
	@RequestMapping(value ="/savePost")
	@ResponseBody
	public int  savePost(HttpServletRequest request,Map<String ,Object> req,Integer id,String deptname,String postNo,String postName,String postRemark){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		PostInfo post =new PostInfo();
		post.setId((long) 5);
		post.setPostName(postName);
		post.setPostNo("11");
		post.setDeptId((long) 1);
		post.setPostRemark(postRemark);
		post.setAddDate(format.format(new Date()));
		
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
	public int editPost(HttpServletRequest request,Integer id,String postName){
		PostInfo post =new PostInfo();
		post.setId(Long.valueOf(id));
		post.setPostName(postName);
		
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
	public int delPost(HttpServletRequest request,Integer id){
		PostInfo post =new PostInfo();
		post.setId(Long.valueOf(id)) ;
		
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
}
