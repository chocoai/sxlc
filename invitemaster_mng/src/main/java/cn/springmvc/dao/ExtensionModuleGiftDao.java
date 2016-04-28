

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
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:05:47  */

public interface ExtensionModuleGiftDao { 
	//*************红包赠送配置***************//
	/**
	 * 会员首次投资红包赠送配置表设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午9:19:33
	 */
	public int FirstInvestRedpacketsSet(Map<String,Object> map);
	/**
	 * 删除会员首次投资红包赠送配置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午9:32:10
	 */
	public int deleteFirstInvestRedpacketsSet(Map<String,Object> map);
	/**
	 * 会员红包赠送配置表设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * open_Account:新注册会员开户赠送金额
	 * first_Recharge:首次充值赠送红包金额 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午9:44:02
	 */
	public int MemberRedpacketsSet(Map<String,Object> map);
	
	//*************赠送活动配置***************//
	/**
	 * 红包活动新增记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午10:07:59
	 */
	public int RedpacketsAffairinsert(Map<String,Object> map);
	/**
	 * 红包活动修改记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午10:19:55
	 */
	public int RedpacketsAffairupdate(Map<String,Object> map);
	/**
	 * 红包活动发布 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-18 上午11:46:09
	 */
	public int RedpacketsAffairrelease(Map<String,Object> map);
}

