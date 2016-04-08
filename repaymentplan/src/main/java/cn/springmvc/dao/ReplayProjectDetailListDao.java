

/** 
* @Title: ReplayProjectDetailListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午3:42:09 
* @version V5.0 */
 
package cn.springmvc.dao; 

import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 查询项目详情
 * @since 
 * @date 2016-4-1 下午3:42:09  */

public interface ReplayProjectDetailListDao {
	/** 
	 * 根据项目申请记录id查询项目详情  
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppRecordEntity  selectProjectDetailByID(int id);
	
}

