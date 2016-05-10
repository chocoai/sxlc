

/** 
* @Title: ProjectAuitDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午12:55:27 
* @version V5.0 */
 
package cn.springmvc.dao; 
 
import java.util.List;
import java.util.Map;
 
import cn.springmvc.model.ProjectCheckAttachDealEntity;
import cn.springmvc.model.ProjectCheckAttachEntity; 

/** 
 * @author 刘利 
 * @Description: 借款审核模块
 * @since 
 * @date 2016-3-23 下午12:55:27  */

public interface ProjectAuitDao {  
	/**
	 * 审核项目 
	 * @author 刘利   
	 * @Description: 审核项目  
	 * @param @param map  
	 * @return int 返回类型  -1 该项目已审核通过；-3 该项目该审核批次已审核； 1  审核通过   -4 上级审核批次未通过
	 * @date 2016-3-23 下午3:46:38
	 */
	public int projectAudit(Map<String,Object> map); 
	/**
	 * 批量删除审核附件 
	 * @author 刘利   
	 * @Description: 批量删除审核附件 
	 * @param @param projectCheckAttachList 
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int deleteProjectCheckAttach(List<ProjectCheckAttachEntity> projectCheckAttachList);
	
	/**
	 * 上传审核附件 
	 * @author 刘利   
	 * @Description: 上传审核附件 
	 * @param @param projectCheckAttachList 
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int insertProjectCheckAttach(List<ProjectCheckAttachEntity> projectCheckAttachList);
	/**
	 * 根据附件编号,与审批记录id删除审核附件一条 
	 * @author 刘利   
	 * @Description: 根据附件编号与审核记录ID删除审核附件 一条
	 * @param attachIndex 附件编号
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int deleteProjectCheckAttachone(Map<String,Object> map);
	/**
	 * 插入附件操作记录
	 * @author 刘利   
	 * @Description: 插入附件操作记录
	 * @param projectCheckAttachDealEntity 附件操作实体
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int insertCheckAttachone(ProjectCheckAttachDealEntity projectCheckAttachDealEntity);
	
	/**
	 * 审核项目 -修改项目基本信息
	 * @author 刘利   
	 * @Description: 审核项目  
	 * @param @param map  
	 * @return int 返回类型   -3 该项目该审核批次已审核；-2 借款标题已存在 ； 1  修改成功  
	 * @date 2016-3-23 下午3:46:38
	 */
	public int updateProjectDetail(Map<String,Object> map); 
	
	/**
	 * 审核项目 
	 * @author 刘利   
	 * @Description: 审核项目  
	 * @param @param map  
	 * @return int   1 成功 0失败
	 * @date 2016-3-23 下午3:46:38
	 */
	public int updateaffix(Map<String,Object> map); 
}

