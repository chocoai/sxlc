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
* <br>
* 解密请求中的参数
* @author 李杰
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
		exitRout.add("openThirdAccountCallbackPage");				//开户回调1
		exitRout.add("openThirdAccountCallback");					//开户回调2
		exitRout.add("fundList");									//我要投资-获取投资列表
		exitRout.add("authorizedCallBack");							//二次分配授权
		exitRout.add("authorizedCallBackPage");						//二次分配授权
		exitRout.add("loanRechargeReturn");	
		exitRout.add("loanRechargeNotify");
		exitRout.add("loanList");									//我要投资-获取债权投资列表
		exitRout.add("debtInvestmentBack");							//债权投资回调
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		logger.info("ChechkParam_doFilter");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest 	servletRequest 		= (HttpServletRequest) request;
		String requestUrl = servletRequest.getRequestURI();
		String requestPath= requestUrl.substring(requestUrl.lastIndexOf("/")+1, requestUrl.lastIndexOf("."));
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
