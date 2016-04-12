

/** 
* @Title: MobileEmailBindingService.java 
* @Package cn.securitycenter.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 上午11:48:22 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-29 上午11:48:22  */

public interface EmailBindingService {
	/**
	 * 查询邮箱是否已存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalEmail}
	 * @param @return 设定文件 
	 * @return int 返回类型 0 不存在，大于0存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int selectEmailIsExist(Map<String,Object> map);
	/**
	 * 修改个人会员邮箱
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalEmail,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatepersonEmail(Map<String,Object> map);
	/**
	 * 修改企业会员邮箱
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalEmail,personalID(Company_ID)}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatecompanyEmail(Map<String,Object> map);
}

