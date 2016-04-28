package cn.springmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import product_p2p.kit.constant.Constant;

import cn.membermng.model.MemberInfo;

public class MemberSessionMng {
	/**
	 * 获取当前登录会员id，会员类型
	* GetLoginMemberInfo(获取当前登录会员id，会员类型) 
	* TODO(描述)
	* @author 邱陈东  
	* * @Title: GetLoginMemberInfo 
	* @Description: TODO 
	* @param @param request							当前请求request
	* @param @param lMemberInfo					new long 数组，长度1或2，赋值顺序：会员id，会员类型
	* @return void 返回类型 
	* @date 2016-4-25 下午6:25:54
	* @throws
	 */
	public static void GetLoginMemberInfo(HttpServletRequest request,long[] lMemberInfo){
		if(request == null || lMemberInfo==null || lMemberInfo.length<1){
			return;
		}
		HttpSession session = request.getSession();
		MemberInfo loginMember = (MemberInfo)session.getAttribute(Constant.LOGINUSER);
		if(loginMember == null){
			return;
		}
		lMemberInfo[0] = loginMember.getId();
		if(lMemberInfo.length>1){
			lMemberInfo[1] = loginMember.getMemberType();
		}
	}
}
