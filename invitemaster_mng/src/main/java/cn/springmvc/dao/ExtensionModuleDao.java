

/** 
* @Title: ExtensionModuleDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:05:47 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: 推广模块
 * @since 
 * @date 2016-4-15 下午8:05:47  */

public interface ExtensionModuleDao {
	/**
	 * SEO信息配置表设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午12:01:48
	 */
	public int seoSet(Map<String,Object> map);
    /**
     * SEO信息配置表删除
     * @author 刘利   
     * @Description: TODO 
     * @param map
     * @param @return 设定文件 
     * @return int 返回类型 
     * @date 2016-4-16 下午12:26:23
     */
	public int seoDelete(Map<String,Object> map);
	/**
	 * CPS推荐配置表修改，如果传入参数值为-1，不修改该参数 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午12:35:22
	 */
	public int CPSPromote(Map<String,Object> map);
	/**
	 * 推荐达人配置表修改
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午12:41:06
	 */
	public int inviteMasterSet(Map<String,Object> map);
	/**
	 * 推荐达人申请审核 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-16 下午1:40:19
	 */
	public int inviteMasterApplyCheck(Map<String,Object> map);
 
}

