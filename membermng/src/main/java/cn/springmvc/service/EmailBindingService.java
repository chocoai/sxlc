

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
	 * 查询邮箱是否已存在--不用了
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalEmail,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0 不存在，大于0存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int selectEmailIsExist(Map<String,Object> map);
	
	/**
	 * 修改会员邮箱
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalEmail,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功， -1邮箱已存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatepersonEmail(Map<String,Object> map);
//	/**
//	 * 修改企业会员邮箱 不用了都用一个
//	 * @author 刘利   
//	 * @Description: TODO 
//	 * @param  map {personalEmail,personalID(Company_ID)}
//	 * @param @return 设定文件 
//	 * @return int 返回类型 0失败，1成功
//	 * @date 2016-3-29 上午11:44:07
//	 */
//	public int updatecompanyEmail(Map<String,Object> map);
	
	/**
	 * 查看原绑定的邮箱
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberId 会员登录ID
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-25 下午7:45:52
	 */
	public String selectOldEmail(long memberId);
	/**
	 * 查看原有邮箱是否输入正确 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {personalEmail,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型  1正确，0不正确
	 * @date 2016-4-25 下午8:10:04
	 */
	public int checkEmail(Map<String,Object> map);
}

