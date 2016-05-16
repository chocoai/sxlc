

package cn.springmvc.dao; 

import cn.springmvc.model.CreditorTransBaseEntity;
import cn.springmvc.model.ProjectBaseInfoEntitys;
import cn.springmvc.model.ProjectDetailEntity;

/** 
* @Title: ReplayProjectDetailListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午3:42:09 
* @version V5.0 */
 


/** 
 * @author 刘利 
 * @Description: 查询项目详情
 * @since 
 * @date 2016-4-1 下午3:42:09  */

public interface ReplayProjectDetailListDao {
	/** 
	 * 根据项目申请记录id查询项目详情   ProjectBaseInfoEntitys
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	ProjectDetailEntity  selectProjectDetailByID(long id);
	
	/**
	 * 根据项目申请id获取项目基本信息
	* selectProjectBaseInfoById	根据项目申请id获取项目基本信息
	* TODO(描述)
	* @author 张友  
	* * @Title: selectProjectBaseInfoById 
	* @Description: TODO 
	* @param  lId					项目申请id
	* @param @return 				项目基本信息
	* @return ProjectBaseInformationEntity 返回类型 
	* @date 2016-5-3 下午3:13:15
	* @throws	null
	 */
	ProjectBaseInfoEntitys selectProjectBaseInfoById(long lId); 
	
	/**
	 * 根据债券转让id获取债权基本信息  生成投资收益
	* selectCreditorTransInfoById			根据债券转让id获取债权基本信息  生成投资收益
	* TODO(描述)
	* @author 张友  
	* * @Title: selectCreditorTransInfoById 
	* @Description: TODO 
	* @param  lId							债权转让申请ID
	* @param @return 设定文件 
	* @return ProjectBaseInfoEntitys 返回类型 
	* @date 2016-5-9 下午8:32:18
	* @throws null
	 */
	CreditorTransBaseEntity selectCreditorTransInfoById(long lId);
}

