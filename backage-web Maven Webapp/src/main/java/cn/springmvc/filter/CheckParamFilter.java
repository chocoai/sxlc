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

import org.apache.log4j.Logger;

import cn.springmvc.httpRequest.DecryptHttpServletRequest;

/***
* 拦截用户请求  重写请求对象 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-30 下午3:18:53 
*
 */
public class CheckParamFilter implements Filter{
	private Logger logger = Logger.getLogger(CheckParamFilter.class);
	Set<String> exitRout = new HashSet<String>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("ChechkParam_init");
		exitRout.add("login");										//登录不拦截
		exitRout.add("applyRequest");								//
		exitRout.add("backURL");								    //第三方回调 页面返回地址  不拦截
		exitRout.add("backServerURL");								//第三方回调 服务器返回地址  不拦截
		exitRout.add("pbackURL");									//担保机构开户
		exitRout.add("pbackServerURL");									//担保机构开户
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		logger.info("ChechkParam_doFilter");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest 	servletRequest 		= (HttpServletRequest) request;
//		String 				requestPath	 		= servletRequest.getRequestURI().replace("/backage-web/", "");
		String requestUrl = servletRequest.getRequestURI();
		String requestPath="";//请求路径标识
		if(requestUrl.lastIndexOf(".") > requestUrl.lastIndexOf("/")+1){
			requestPath= requestUrl.substring(requestUrl.lastIndexOf("/")+1, requestUrl.lastIndexOf("."));
		}else{
			requestPath= requestUrl.substring(requestUrl.lastIndexOf("/")+1);
		}
		if(exitRout.contains(requestPath)){
			chain.doFilter(request, response);
		}else{
			request = new DecryptHttpServletRequest(servletRequest);
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		logger.info("ChechkParam_destroy");
	}

}
