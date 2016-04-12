

/** 
* @Title: MobilePhoneBindingService.java 
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
 * @Description: 修改手机号码绑定
 * @since 
 * @date 2016-3-29 上午11:48:22  */

public interface MobilePhoneBindingService {
	/**
	 * 查询手机号码是否已存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalPhone}
	 * @param @return 设定文件 
	 * @return int 返回类型 0 不存在，大于0存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int selectPhoneIsExist(Map<String,Object> map);
	/**
	 * 修改个人会员手机号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalPhone,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatepersonPhone(Map<String,Object> map);
	/**
	 * 修改企业会员手机号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalPhone,personalID(Company_ID)}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatecompanyPhone(Map<String,Object> map);
}

