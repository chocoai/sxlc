

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

public interface UpdatePasswordService {
	/**
	 * 修改会员登录密码
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {memberPwd,memberID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatepersonPassword(Map<String,Object> map); 
	/**
	 * 查询原始会员登录密码是否输入正确
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {memberPwd,memberID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0不正确，1正确
	 * @date 2016-3-29 上午11:44:07
	 */
	public int checkPassword(Map<String,Object> map);
}

