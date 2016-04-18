
package cn.springmvc.util; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
* @author 杨翰林
* @Description: 获取session 
* @since 
* @date 2016-4-15 下午2:02:43
 */
public class HttpSessionUtil {
	public static HttpSession getSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		return session;
	}
}

