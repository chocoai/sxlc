
package cn.springmvc.util; 

import javax.servlet.http.HttpServletRequest;
/**
 * 
* @author 杨翰林
* @Description: 获取访问url 
* @since 
* @date 2016-4-18 上午10:41:02
 */
public class LoadUrlUtil {

	public static String getFullURL(HttpServletRequest request) {

		 StringBuffer url = request.getRequestURL();
		 if (request.getQueryString() != null) {
		  url.append('?');
		  url.append(request.getQueryString());
		 }
		 return url.toString();
	}
}

