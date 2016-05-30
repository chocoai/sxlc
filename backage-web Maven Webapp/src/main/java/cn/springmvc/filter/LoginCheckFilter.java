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
import cn.springmvc.model.Admin;

public class LoginCheckFilter implements Filter{
	
	/**
	 * 排除登录拦截的路径(不需要拦截的路经)
	 */
	Set<String> exitRouts = new HashSet<String>();
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		exitRouts.add("longinInterface");
		exitRouts.add("forget_password");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		String requestUrl = request2.getRequestURI();
		String requestPath = "";
		if(requestUrl.indexOf(".") != -1){
			requestPath = requestUrl.substring(requestUrl.lastIndexOf("/")+1, requestUrl.lastIndexOf("."));
		}else{
			requestPath = "";
		}
		//System.out.println(exitRouts.contains(requestPath));
		if(!exitRouts.contains(requestPath) && !requestPath.equals("")){
			Admin admin = (Admin) ((HttpServletRequest)request).getSession().getAttribute("LoginPerson");
			if(admin == null){
				String requestType = request2.getHeader("X-Requested-With");//获取请求类型,这里我们页面用的Jquery的Ajax,所以可以这么用
				if(requestType != null && requestType.equals("XMLHttpRequest")){//Ajax请求
					String resultJson = "{\"status\":-100,\"det\":用户未登录}";
					response.getWriter().write(resultJson);
				}else{
					((HttpServletResponse)response).sendRedirect("/backage-web/");
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

