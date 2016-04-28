

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

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.model.ProjectAppAttachmentEntity; 
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectCheckAttachDealEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectCheckRecordEntity;

/** 
 * @author 刘利 
 * @Description: 项目审核模块
 * @since 
 * @date 2016-3-23 下午12:58:13  */

public interface ProjectAuitService {
	/**
	 *  实现审核列表查询
	 *  @param pageEntity  分页实体 map{sIndexs(上级项目审批流程序号大于等于0)，ProjectTitle，Logname
	 *                              ，statu（1已审核，-1未审核），Indexs （当前审批活动点序号），name（借款人姓名）
	 *                              startTime，endTime,keys}
	 *  @author 刘利 
	 *  @Description: 实现审核列表查询 
	 *  @return List<ProjectAppRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectAppRecordEntity> selectProjectAuitList(PageEntity pageEntity); 
	/** 
	 * 根据项目申请记录id查询项目详情  
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppRecordEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	public  ProjectAppRecordEntity  selectProjectDetailByID(int id);
	
	/**
	 * 审核项目 
	 * @author 刘利   
	 * @Description: 审核项目  
	 * @param @param map  
	 * @return int 返回类型  -1 该项目已审核通过；-3 该项目该审核批次已审核；-2 借款标题已存在 ； 1  审核通过  
	 * @date 2016-3-23 下午3:46:38
	 */
	public int projectAudit(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 *  根据项目申请id查询项目申请审核附件
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID 
	 * @return List<ProjectAppAttachmentEntity> 返回类型 
	 * @date 2016-3-23 下午4:04:47
	 */
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(long projectID);
	/**
	 *  分页查询审核记录
	 *  @param pageEntity  分页实体 map{applyId(项目申请ID)}
	 *  @author 刘利 
	 *  @Description: 分页查询审核记录
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckRecordEntity> selectProjectCheckRecord(PageEntity pageEntity);
	/**
	 *  历史审核附件
	 *  @param pageEntity  分页实体  map{applyId}
	 *  @author 刘利 
	 *  @Description: 历史审核附件
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckAttachEntity> selectCheckAttachDeal(PageEntity pageEntity);
	/**
	 *  附件删除记录
	 *  @param pageEntity  分页实体  map{applyId}
	 *  @author 刘利 
	 *  @Description: 附件删除记录
	 *  @return List<ProjectCheckRecordEntity> 
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectCheckAttachEntity> selectCheckAttachDealDelete(PageEntity pageEntity);
	/**
	 * 审核项目 
	 * @author 刘利   
	 * @Description: 审核项目  
	 * @param map #{ApplyId}项目申请ID
	  			#{Indexs}当前审批流程序号
				#{projectTitle}项目名称
				#{uses}借款用途
				#{repaySource}还款来源
				#{amount}借款金额
				#{projectDescript},项目描述
				#{deadline},借款期限
				#{deadlineType},期限类型  0：天标 1：月标 2：年标
				#{repayWay},还款方式
				#{yearRate},年化利率
				#{minStart}, 起投金额 0：表示无限制
				#{increaseRange},加价幅度 0：表示无限制
				#{investMax},最大投资比例 
				#{investCountMax},最大投资笔数 0
				#{checkStatu} 1：通过 -1：打回  2通过需补齐资料
				#{CheckRemark},审核意见
				#{adminID},操作员
				#{checkid},审核意见ID
				#{ProcessID},审批点ID
				#{sIndexs},上一审批流程序号 
	 * @param affix 附件列表  附件名称,附件路径 ;附件名称,附件路径 ;附件名称,附件路径 
	 * @param adminID 操作员 
	 * @return int 返回类型  -1 该项目已审核通过；-3 该项目该审核批次已审核；-2 借款标题已存在 ； 1  审核通过  ,-4 上级审核批次未通过
	 * @date 2016-3-23 下午3:46:38
	 */
	public int projectAudit(Map<String,Object> map,String affix,long adminID,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 *  根据项目申请id查询项目审核附件
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectID 
	 * @return List<selectProjectCheckAttachTotal> 返回类型 
	 * @date 2016-3-23 下午4:04:47
	 */
	public List<ProjectCheckAttachEntity> selectProjectCheckAttachTotal(long projectID);
	/**
	 *  新增审核附件
	 * @author 刘利   
	 * @Description: TODO 
	 * @param projectCheckAttachList
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-24 下午6:01:05
	 */
	public int insertProjectCheckAttach(List<ProjectCheckAttachEntity> projectCheckAttachList);
	/**
	 * 根据附件编号,与审核记录ID删除审核附件一条 
	 * @author 刘利   
	 * @Description: 根据附件编号与审核记录ID删除审核附件 一条
	 * @param map {attachIndex(附件编号) appCheckId (审核记录ID)}
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int deleteProjectCheckAttachone(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 插入附件操作记录
	 * @author 刘利   
	 * @Description: 插入附件操作记录
	 * @param projectCheckAttachDealEntity 附件操作实体
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int insertCheckAttachone(ProjectCheckAttachDealEntity projectCheckAttachDealEntity);
}

