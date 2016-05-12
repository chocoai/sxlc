//package cn.springmvc.controller.member; 
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import product_p2p.kit.HttpIp.AddressUtils;
//import product_p2p.kit.datatrans.IntegerAndString;
//import product_p2p.kit.optrecord.InsertAdminLogEntity;
//import cn.membermng.model.BlackLimitEntity;
//import cn.springmvc.model.Admin;
//import cn.springmvc.service.IMemberManangerService;
//import cn.springmvc.util.HttpSessionUtil;
//import cn.springmvc.util.LoadUrlUtil;
//
///**
// * @author pengran
// * 黑名单受限操作表
// * @date:2016-5-10 上午10:05:34
// **/
//
//
//@Controller
//@RequestMapping("/blackstint")
//public class BlackLimitController {
//	
//	@Autowired
//	private IMemberManangerService iMemberManangerService;
//	
//	
//	/**
//	 * 查询黑名单受限
//	 * TODO
//	 * 创建日期：2016-5-10上午10:53:02
//	 * 修改日期：
//	 * 作者：pengran
//	 * @param
//	 * return List<BlackLimitEntity>
//	 */
//	@RequestMapping(value ="/BlackLimitList", method = RequestMethod.POST)
//	@ResponseBody
//	public List<BlackLimitEntity> BlackLimitList(HttpServletRequest req){
//		//查询条件
//		return iMemberManangerService.blackLimtList();
//	}
//	
//	/**
//	 * 添加黑名单受限
//	 * TODO
//	 * 创建日期：2016-5-10上午10:57:31
//	 * 修改日期：
//	 * 作者：pengran
//	 * @param
//	 * return int
//	 */
//	@RequestMapping(value ="/AddLimitList", method = RequestMethod.POST)
//	@ResponseBody
//	public int AddLimitList(HttpServletRequest req){
//		//查询条件
//		String limits = req.getParameter("content");
//		String [] limitArr =null;
//		int [] arr = null;
//		if(limits!=null &&  !"".equals(limits)){
//			limits  = limits.substring(0,limits.length()-1);
//			limitArr = limits.split(",");
//			arr = new int[limitArr.length];
//			for (int i = 0; i < limitArr.length; i++) {
//				arr[i] = IntegerAndString.StringToInt(limitArr[i], 0);
//			}
//		}
//		String [] sIpInfo = new String[5];
//		HttpSession session = HttpSessionUtil.getSession(req);
//		InsertAdminLogEntity entity = new InsertAdminLogEntity();
//		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
//		if (userInfo != null && userInfo.getId()>0) {
//			entity.setiAdminId(userInfo.getId());
//		}
//		entity.setlOptId(105);
//		entity.setlModuleId(10501);
//		entity.setsDetail("");
//		entity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
//		entity.setsMac(null);
//		entity.setsUrl(LoadUrlUtil.getFullURL(req));
//		return iMemberManangerService.addLimitList(arr, entity, sIpInfo);
//	}	
//}
//
