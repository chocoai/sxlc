

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
	 * @param  map {personalPhone,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0 不存在，大于0存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int selectPhoneIsExist(Map<String,Object> map);
	
	/**
	 * 修改会员手机号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {personalPhone,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功 -1该手机号码已存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int updatepersonPhone(Map<String,Object> map);
//	/**
//	 * 修改企业会员手机号
//	 * @author 刘利   
//	 * @Description: TODO 
//	 * @param  map {personalPhone,personalID(Company_ID)}
//	 * @param @return 设定文件 
//	 * @return int 返回类型 0失败，1成功
//	 * @date 2016-3-29 上午11:44:07
//	 */
//	public int updatecompanyPhone(Map<String,Object> map);
	/**
	 * 查询原绑定的手机号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberId会员ID
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-25 下午7:09:39
	 */
	public String selectOldPhone(long memberId);
	/**
	 * 查询原有电话号码是否输入正确
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {personalPhone,personalID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-25 下午8:19:21
	 */
	public int checkPhone(Map<String,Object> map);
}

