package cn.springmvc.Util;

import java.text.SimpleDateFormat;
import java.util.Date;


/***
 * 字符串帮助类
 * @author LiJie
 *
 */
public class StringUtils {

	
	
	/***
	 * 格式化时间
	 * @param patten					格式默认为 yyyy-MM-dd
	 * @param date						默认为当前时间
	 * @return							字符串时间
	 */
	public static String fromtDate(String pattern,Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern == null ? "yyyy-MM-dd": pattern);
		return dateFormat.format(date == null ? new Date():date);
	}
	
	
	/***
	* 格式化当前时间
	* @author 李杰
	* @Title: fromString
	* @return 当前时间按照 yyyy-MM-dd 的格式
	* @Description: TODO
	* @date 2016-3-22 下午2:04:28
	 */
	public static String fromString(){
		return fromtDate(null, null);
	}
	
	
	
	
	
}
