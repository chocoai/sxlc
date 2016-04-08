

/** 
* @Title: ProjectAuitService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午12:58:13 
* @version V5.0 */
 
package cn.springmvc.service; 
 
import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;  
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectImageEntity;

/** 
 * @author 刘利 
 * @Description: 项目发布模块
 * @since 
 * @date 2016-3-23 下午12:58:13  */

public interface ProjectPublishService {
	/**
	 *  实现发布列表查询
	 *  @param pageEntity  分页实体 map{ProjectTitle(项目标题),Logname,startTime(提交申请时间),endTime(提交申请时间),
	 *                               pushstartTime(项目发布时间),pushendTime(项目发布时间),name(借款会员名称),
	 *                               investStatu(融资状态),order(1根据借款金额排序，2根据发布时间排序)}
	 *  @author 刘利 
	 *  @Description: 实现审核列表查询 
	 *  @return List<ProjectAppProcessEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectAppProcessEntity> selectProjectPublishList(PageEntity pageEntity);
	/**
	 * 上传企业形象图
	 * @author 刘利   
	 * @Description: 上传企业形象图
	 * @param @param projectCheckAttachList 
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int insertProjectImage(List<ProjectImageEntity> ProjectImage);
	/**
	 * 发布
	 * @author 刘利   
	 * @Description: 发布 
	 * @param map #{ApplyId}项目申请ID
				  #{Indexs},审批流程序号
				  #{checkStatu},审核结果
				  #{CheckRemark},审核意见
				  #{adminID},审核管理员 
				  #{startDate}投标开始时间
				  #{endDate},投标结束时间
				  #{ProcessID},审批点ID
				  #{sIndexs}上级审批流程序号 
	 * @return int 返回类型   -1 该项目已审核通过；-3 该项目该审核批次已审核； 1  审核通过  ,-4 上级审核批次未通过
	 * @date 2016-3-23 下午6:34:20
	 */
	public int publishProject(Map<String,Object> map);
	/**
	 * 根据查询项目申请ID企业形象图 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyId 项目申请ID
	 * @param @return 设定文件 
	 * @return List<ProjectImageEntity> 返回类型 
	 * @date 2016-3-23 下午9:29:38
	 */
	public List<ProjectImageEntity> selectProjectImageList(long applyId);
	/**
	 * 修改借款结束时间
	 * @author 刘利   
	 * @Description: 修改借款结束时间
	 * @param projectID 项目申请拒绝ID endDate  借款结束时间
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int updateEndtime(ProjectAppProcessEntity projectAppProcessEntity);
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

