package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.constant.Constant;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AffairInfo;
import cn.invitemastermng.model.RedRecord;
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberInfo;
import cn.springmvc.service.IMemberManangerService;
import cn.springmvc.service.IRedPackageService;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


/***
 * 活动
 * 
 * @author 李杰
 * @since 
 * @date 2016-9-1 上午11:55:55 
 *
 */
@Controller
public class ActivityController {

	
	
	@Autowired
	private IRedPackageService iRedPackageService;
	
	
	@Autowired
	private IMemberManangerService iMemberManangerService;
	
	
	/***
	 * 获取最新红包领取记录<br>
	 *
	 *
	 * @author 李杰
	 * @return
	 * @date 2016-9-1 下午12:02:30
	 */
	@RequestMapping(value="redRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String redRecord(HttpServletRequest request){
		int pageSize = IntegerAndString.StringToInt(request.getParameter("pageSize"), 10);
		int cpage	 = IntegerAndString.StringToInt(request.getParameter("cpage"), 1);
		
		PageEntity entity = new PageEntity();
		entity.setPageNum(cpage);
		entity.setPageSize(pageSize);
		List<RedRecord> list = iRedPackageService.redRecord(entity);
		return JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 
	* 抢红包
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-20 下午2:05:17
	 */
	@RequestMapping(value="grabRedPackage",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String grabRedPackage(HttpServletRequest request){
		long affairId = IntegerAndString.StringToLong(request.getParameter("affairId"), -1);
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,String> message = new HashMap<String, String>();
		//1领取成功、0领取失败、-1当前活动不存在、-2活动未开始、-3活动已结束、-4你已经领过了、-5红包被领完了、 -6黑名单会员禁止抢红包
		int result = -7;
		if(memberInfo != null && affairId != -1){
			result = iRedPackageService.grabRedPackage(affairId, memberInfo.getId());
		}
		
		if(result == 1){
			message.put("message", "领取成功");
		}else if(result == 0){
			message.put("message", "领取失败");
		}else if(result == -1){
			message.put("message", "活动不存在");
		}else if(result == -2){
			message.put("message", "活动未开始");
		}else if(result == -3){
			message.put("message", "活动已结束");
		}else if(result == -4){
			message.put("message", "您已经领取过了");
		}else if(result == -5){
			message.put("message", "红包被抢光啦");
		}else if(result == -6){
			message.put("message", "黑名单会员无法抢红包");
		}else if(result == -7){
			message.put("message", "请先登录后,再抢红包吧");
		}
		message.put("status", ""+result);
		return JSONObject.toJSONString(message);
	}
	
	
	
	/***
	 * 抢红包
	 * 
	 * @author 李杰
	 * @Title: redEnvelope
	 * @return
	 * @date 2016-5-27 下午1:53:13
	 */
	@RequestMapping("redEnvelope")
	public String redEnvelope(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if(memberInfo == null){
			request.setAttribute("optionStatu","0");
		}else{
			request.setAttribute("optionStatu","1");
		}
	
		//查询最新一期的活动信息
		AffairInfo affairInfo = iRedPackageService.findLatelyInfo();
		request.setAttribute("affairInfo", affairInfo);
		return "integralMall/redEnvelope";
	}
	
	
	
	
	
	
	
	
	
	
	
	/***
	 * 抢红包
	 * 
	 * @author 李杰
	 * @param request
	 * @date 2016-5-20 下午5:06:13
	 */
	@RequestMapping("qiangHongBao")
	@ResponseBody
	public String 抢红包(HttpServletRequest request){
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(100);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberType", 0);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		pageEntity.setMap(param);
		List<MemberAll> members = iMemberManangerService.getMembersByParam(pageEntity);
		for (int i = 0; i < members.size(); i++) {
			int result = iRedPackageService.grabRedPackage(5895073, members.get(i).getMemberId());
			if(result == 1){
				System.out.println(members.get(i).getMemberName()+" ： 领取成功");
			}else if(result == 0){
				System.out.println(members.get(i).getMemberName()+" ：领取失败");
			}else if(result == -1){
				System.out.println(members.get(i).getMemberName()+" ：活动不存在");
			}else if(result == -2){
				System.out.println(members.get(i).getMemberName()+" ：活动未开始");
			}else if(result == -3){
				System.out.println(members.get(i).getMemberName()+" ：活动已结束");
			}else if(result == -4){
				System.out.println(members.get(i).getMemberName()+" ：您已经领取过了");
			}else if(result == -5){
				System.out.println(members.get(i).getMemberName()+" ：红包被抢光啦");
			}else if(result == -6){
				System.out.println(members.get(i).getMemberName()+" ：黑名单会员无法抢红包");
			}else if(result == -7){
				System.out.println(members.get(i).getMemberName()+" ：请先登录后,再抢红包吧");
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

