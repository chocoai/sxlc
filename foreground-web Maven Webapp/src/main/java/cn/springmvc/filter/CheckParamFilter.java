package cn.springmvc.filter;
import java.io.IOException;

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
* @since 
* @date 2016-3-30 下午3:18:53 
*
 */
public class CheckParamFilter implements Filter{
	private Logger logger = Logger.getLogger(CheckParamFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("ChechkParam_init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		logger.info("ChechkParam_doFilter");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest 	servletRequest 		= (HttpServletRequest) request;
		String 				requestPath	 		= servletRequest.getRequestURI().replace("/backage-web/", "");
		if (requestPath.equals("applyRequest") || requestPath.equals("login")) {		//过滤不拦截的请求
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
