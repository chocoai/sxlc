package cn.springmvc.interceptor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.constant.Constant;
import product_p2p.kit.optrecord.InsertMemberLogEntity;
import product_p2p.kit.spring.SpringUtil;
import cn.membermng.model.MemberInfo;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;

public class SessionCheckInterceptor implements HandlerInterceptor{

	
	/**
	 * 记录日志
	 */
	public OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	Set<String> exitRouts = null;
	
	public SessionCheckInterceptor() {
		exitRouts = new HashSet<String>();
		exitRouts.add("openThirdAccountCallbackPage");					//开户回调1
		exitRouts.add("openThirdAccountCallback");						//开户回调2
		exitRouts.add("authorizedCallBack");							//二次分配授权
		exitRouts.add("authorizedCallBackPage");						//二次分配授权
		exitRouts.add("loanRechargeNotify");							//绑定银行卡回调
		exitRouts.add("debtInvestmentBack");							//债权投资回调
		exitRouts.add("memberInvestmentPage");							//項目投資返回
		exitRouts.add("memberInvestmentvoid");							//項目投資返回
		exitRouts.add("ReplayCallBackReturn");							//項目还款返回
		exitRouts.add("ReplayCallBackNotify");							//項目还款返回
		exitRouts.add("buyVipCallBackPage");							//VIP购买转账回调
		exitRouts.add("buyVipCallBack");								//VIP购买转账回调
		exitRouts.add("loanWithdrawNotify");							//提现回调
		exitRouts.add("loanWithdrawReturn");							//提现回调
		exitRouts.add("authImage");										//验证码
	}
	

	
	@Override
	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)throws Exception {
		//在一个请求调用之后执行
	}

	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		//处理主体-在Controller处理过后才执行
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2) throws Exception {
		arg1.setContentType("text/html;charset=UTF-8");
		String requestUrl = arg0.getRequestURI();
		String requestPath= requestUrl.substring(requestUrl.lastIndexOf("/")+1, requestUrl.lastIndexOf("."));
		if(exitRouts.contains(requestPath)){	//授权直接走
			return true;
		}
		
		HttpSession session = arg0.getSession();
		optRecordWriteDaoImpl = (OptRecordWriteDaoImpl) SpringUtil.getBean(OptRecordWriteDaoImpl.class);
		
		//判断用户登录过没有
		MemberInfo memberInfo = (MemberInfo) session.getAttribute(Constant.LOGINUSER);
		
		InsertMemberLogEntity entity = new InsertMemberLogEntity();
		String[] sIpinfo = new String[6];
		String ip = AddressUtils.GetRemoteIpAddr(arg0, sIpinfo);
		entity.setsIp(ip);
		entity.setsMac("");
		entity.setsUrl(arg0.getRequestURI());
		entity.setsReferrUrl(arg0.getHeader("Referer"));
		
		if(memberInfo != null){//登录用户
			//-1：非法操作 -2：未登录 -3:登录已过期 1：验证成功 0:验证失败
			int result = optRecordWriteDaoImpl.MemberSessionCheck(session.getId(), memberInfo.getId(), (short)1, session.getMaxInactiveInterval(), ip, sIpinfo);
			optRecordWriteDaoImpl.InsertForgroundLog(session.getId(), memberInfo.getId(), entity, sIpinfo);
			if(result == 1){
				if(checkParam(arg0))
					return true;//继续执行
				return false;
			}else{
				/*String det = "";
				if(result == -1){
					det = "非法操作";
				}else if(result == -2){
					det = "用户未登录";
				}else if(result == -3){
					det = "登录已过期";
				}else if(result == 0){
					det = "认证失败";
				}
				String resultJson = "{\"status\":"+result+",\"det\":"+det+"}";
				arg1.getWriter().write(resultJson);
				return false;*/
				return true;
			}
		}else{
			optRecordWriteDaoImpl.InsertForgroundLog(session.getId(), 0, entity, sIpinfo);
			if(checkParam(arg0)){
				return true;//继续执行
			}else{
				return false;
			}
		}
	}
	
	
	
	
	
	
	/***
	* 参数校验
	* <br>
	* 这个方法将对请求中包含的参数进行一个MD5的有效验证,如果请求中包含sign那么就对这个请求进行验证 没有则不进行验证。
	* <br>
	* 由于当前拦截器会拦截所有的请求,所以会拦截到一些请求静态页面的请求。
	* 如果请求中没有sign返回true,到Controller中去验证参数是否有效
	* 如果有则进行验证 是否被篡改
	* @author 李杰
	* @param request
	* @return 未被篡改 true,被篡改 false
	* @date 2016-4-22 上午11:46:59
	*/
	public boolean checkParam(HttpServletRequest request){
		//获取请求中的参数
		Map<String,String[]> map = request.getParameterMap();
		Map<String, String> newMap = new HashMap<String,String>();
		for (String str : map.keySet()) {
			newMap.put(str, map.get(str)[0]);
		}
		String sign = newMap.get("sign");
		newMap.remove("sign");
		if(sign == null){									//没有签名
			if(newMap.keySet().size() == 0){				//没有参数
				return true;
			}else{
				return false;								//请改为false再使用 如果出现有参数但是没有签名的情况 直接失败当前请求
			}
		}else{
			String paramCheckCode = "";
			Map<String, String> sortMap = new TreeMap<String, String>(new Comparator<String>() {@Override public int compare(String o1, String o2) {return o1.compareTo(o2);}});
			sortMap.putAll(newMap);
			for(String key : sortMap.keySet()){
				paramCheckCode += key+sortMap.get(key);
			}
			String result = StringUtils.MD5(paramCheckCode);
			if(result != null && result.equals(sign)){
				return true;
			}else{
				return false;
			}
		}
	}

}
