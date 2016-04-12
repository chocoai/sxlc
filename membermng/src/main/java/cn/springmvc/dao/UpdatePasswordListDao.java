

/** 
* @Title: MobileEmailBindingDao.java 
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
 * @Description: 邮箱绑定
 * @since 
 * @date 2016-3-29 上午11:32:31  */

public interface UpdatePasswordListDao {
	/**
	 * 查询原始会员登录密码是否输入正确
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map
	 * @param @return 设定文件 
	 * @return int 返回类型 0不正确，1正确
	 * @date 2016-3-29 上午11:44:07
	 */
	public int checkPassword(Map<String,Object> map);
}

