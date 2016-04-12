

/** 
* @Title: projectAuitListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-24 下午4:04:26 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectCheckRecordEntity;

/** 
 * @author 刘利 
 * @Description: 项目审核查询模块
 * @since 
 * @date 2016-3-24 下午4:04:26  */

public interface ProjectAuitListDao {
	/**
	 *  实现审核列表查询
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 实现审核列表查询 
	 *  @return List<ProjectAppProcessEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectAppProcessEntity> selectProjectAuitList(PageEntity pageEntity);
	/** 
	 * 根据项目申请记录id查询项目详情  
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppProcessEntity  selectProjectDetailByID(int id);
	/**
	 *  根据项目申请id查询项目申请审核附件
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID
	 * @param @return 设定文件 
	 * @return List<ProjectAppAttachmentEntity> 返回类型 
	 * @date 2016-3-23 下午4:04:47
	 */
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(int projectID);
	/**
	 *  分页查询审核记录
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 分页查询审核记录
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckRecordEntity> selectProjectCheckRecord(PageEntity pageEntity);
	/**
	 *  历史审核附件
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 历史审核附件
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckAttachEntity> selectCheckAttachDeal(PageEntity pageEntity);
	/**
	 *  附件删除记录
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 附件删除记录
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckAttachEntity> selectCheckAttachDealDelete(PageEntity pageEntity);
	/**
	 *  根据项目申请id查询项目审核附件
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID
	 * @param @return 设定文件 
	 * @return List<selectProjectCheckAttachTotal> 返回类型 
	 * @date 2016-3-23 下午4:04:47
	 */
	public List<ProjectCheckAttachEntity> selectProjectCheckAttachTotal(int projectID);
	/**
	 *  查询附件的最大编号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID
	 * @param @return 设定文件 
	 * @return List<selectProjectCheckAttachTotal> 返回类型 
	 * @date 2016-3-23 下午4:04:47
	 */
	public int selectAttachindex();
}

