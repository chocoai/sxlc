

/** 
* @Title: ProjectPublishListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午8:53:43 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectImageEntity;

/** 
 * @author 刘利 
 * @Description: 项目发布模块
 * @since 
 * @date 2016-3-23 下午8:53:43  */

public interface ProjectPublishListDao {
	/**
	 *  实现发布列表查询
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 实现审核列表查询 
	 *  @return List<ProjectAppProcessEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectAppProcessEntity> selectProjectPublishList(PageEntity pageEntity);
	/**
	 * 根据查询项目申请ID企业形象图 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyId 项目申请ID 
	 * @return List<ProjectImageEntity> 返回类型 
	 * @date 2016-3-23 下午9:29:38
	 */
	public List<ProjectImageEntity> selectProjectImageList(long applyId);
	/**
	 *  查询借款结束日期
	 *  @param projectID  项目申请ID
	 *  @author 刘利 
	 *  @Description: 查询借款结束日期
	 *  @return  ProjectAppProcessEntity  
	 *  @date 2016-3-21 下午12:50:30
	 */
	public  ProjectAppProcessEntity selectProjectEndtime(long projectID);
}

