package cn.springmvc.filter; 

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product_p2p.kit.constant.Constant;

import cn.membermng.model.MemberInfo;

public class LoginCheckFilter implements Filter{
	
	/**
	 * 排除登录拦截的路径(不需要拦截的路经)
	 */
	Set<String> exitRouts = new HashSet<String>();
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		exitRouts.add("openThirdAccountCallbackPage");					//开户回调1
		exitRouts.add("openThirdAccountCallback");						//开户回调2
		exitRouts.add("authorizedCallBack");							//二次分配授权
		exitRouts.add("authorizedCallBackPage");						//二次分配授权
		exitRouts.add("loanRechargeNotify");							//绑定银行卡回调
		exitRouts.add("debtInvestmentBack");							//债权投资回调
		exitRouts.add("memberInvestmentPage");							//項目投資返回
		exitRouts.add("memberInvestmentvoid");							//項目投資返回
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		String requestUrl = request2.getRequestURI();
		String requestPath= requestUrl.substring(requestUrl.lastIndexOf("/")+1, requestUrl.lastIndexOf("."));
		if(!exitRouts.contains(requestPath)){
			MemberInfo memberInfo = (MemberInfo) ((HttpServletRequest)request).getSession().getAttribute(Constant.LOGINUSER);
			if(memberInfo == null){
				String requestType = request2.getHeader("X-Requested-With");//获取请求类型,这里我们页面用的Jquery的Ajax,所以可以这么用
				if(requestType != null && requestType.equals("XMLHttpRequest")){//Ajax请求
					String resultJson = "{\"status\":-100,\"det\":用户未登录}";
					response.getWriter().write(resultJson);
				}else{
					if(requestUrl.contains("foreground-web")){
						((HttpServletResponse)response).sendRedirect("/foreground-web/login.html");
					}else{
						((HttpServletResponse)response).sendRedirect("/login.html");
					}
				}
			}else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	
	}
	

}

