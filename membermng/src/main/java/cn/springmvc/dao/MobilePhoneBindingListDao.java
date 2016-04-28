

/** 
* @Title: MobilePhoneBindingDao.java 
* @Package cn.securitycenter.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 上午11:32:31 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: 手机号绑定
 * @since 
 * @date 2016-3-29 上午11:32:31  */

public interface MobilePhoneBindingListDao {
	/**
	 * 查询手机号码是否已存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map
	 * @param @return 设定文件 
	 * @return int 返回类型 0不存在，1存在
	 * @date 2016-3-29 上午11:44:07
	 */
	public int selectPhoneIsExist(Map<String,Object> map);
	/**
	 * 查询原绑定的手机号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-25 下午7:09:39
	 */
	public String selectOldPhone(Map<String,Object> map);
	/**
	 * 查询原有电话号码是否输入正确
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-25 下午8:19:21
	 */
	public int checkPhone(Map<String,Object> map);
}

