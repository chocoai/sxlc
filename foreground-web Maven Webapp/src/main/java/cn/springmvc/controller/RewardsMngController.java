package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import com.alibaba.fastjson.JSONObject;

import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.RadPackage;
import cn.springmvc.service.IMemberService;
import cn.springmvc.util.MemberSessionMng;

@Controller
@RequestMapping(value="/rewards")
public class RewardsMngController {

	@Autowired
	IMemberService memberService;
	
	/**
	 * 查询我的红包信息 （领取总额，已用总额，过期总额，可用总额）
	* loadMyRedpackage
	* @author 邱陈东  
	* * @Title: loadMyRedpackage 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午6:20:49
	* @throws
	 */
	@RequestMapping(value="/loadMyRedpackage", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadMyRedpackage(HttpServletRequest request){
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		MyRedPackage entity=memberService.myRedpackage((int)lMemberInfo[1], lMemberInfo[0]);
		if(entity==null){
			entity = new MyRedPackage();
		}
		if(entity.getsRedPackageSum()==null){
			entity.setsRedPackageSum("0");
		}
		if(entity.getsExpiredSum()==null){
			entity.setsExpiredSum("0");
		}
		if(entity.getsUseRedPackageSum()==null){
			entity.setsUseRedPackageSum("0");
		}
		entity.setCanUseRedPackageSum(entity.getRedPackageSum()-entity.getExpiredSum()-entity.getUseRedPackageSum());
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("status", 0);
		message.put("message", "读取信息成功");
		message.put("data", entity);
	
		return JSONObject.toJSONString(message);
	}
	
	
	/**
	 * 加载我的红包列表
	* loadRedPackageList
	* @author 邱陈东  
	* * @Title: loadRedPackageList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午7:19:47
	* @throws
	 */
	@RequestMapping(value="/loadRedPackageList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadRedPackageList(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		 List<RadPackage> list =  memberService.redPackages(entity);
		 
		 PageUtil.ObjectToPage(entity, list);
		entity.getMap().remove("sKey");
			
		return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 加载代金劵信息
	* loadMyVouchers
	* @author 邱陈东  
	* * @Title: loadMyVouchers 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午7:22:20
	* @throws
	 */
	@RequestMapping(value="/loadMyVouchers", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadMyVouchers(HttpServletRequest request){
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();

		MemberVouchers data =  memberService.myVouchers(lMemberInfo[0],(int)lMemberInfo[1]);
		 
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("status", 0);
		message.put("message", "读取信息成功");
		message.put("data", data);
	
		return JSONObject.toJSONString(message);
	}

	
	/**
	 * 查询已经获取的代金劵列表
	* loadVouchersList
	* @author 邱陈东  
	* * @Title: loadVouchersList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午7:25:23
	* @throws
	 */
	@RequestMapping(value="/loadVouchersList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadVouchersList(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		 List<MemberVouchers> list =  memberService.vouchers(entity);
		 
		 PageUtil.ObjectToPage(entity, list);
		entity.getMap().remove("sKey");
			
		return JSONObject.toJSONString(entity);
	}
	
	
	/**
	 *  查询已经使用的代金劵列表
	* loadUseVouchersList
	* @author 邱陈东  
	* * @Title: loadUseVouchersList 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午7:54:32
	* @throws
	 */
	@RequestMapping(value="/loadUseVouchersList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadUseVouchersList(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberId",lMemberInfo[0]);
		param.put("memberType",lMemberInfo[1]);
		
		PageEntity entity = new PageEntity();
		entity.setMap(param);
		entity.setPageNum(start);
		entity.setPageSize(length);
		
		 List<MemberVouchers> list =  memberService.useVouchers(entity);
		 
		 PageUtil.ObjectToPage(entity, list);
		entity.getMap().remove("sKey");
			
		return JSONObject.toJSONString(entity);
	}
}

