package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppAutoSetEntity;
import cn.springmvc.model.ProjectAppMngFeeEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;
import cn.springmvc.model.ProjectPurposeEntity;
  


/**
 *  意向提交到申请相关
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-23 上午9:28:18  */
public interface ProjectAppRecordService {
	/** 
	* updateProjectPurposeById 借款意向打回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateProjectPurposeById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午7:11:50
	* @throws 
	*/
	public int updateProjectPurposeById(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* distributionOfFC  分配理财顾问
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: distributionOfFC 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午7:12:34
	* @throws 
	*/
	public int distributionOfFC(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* handleProjectAppRecord(提交意向为申请或保存草稿) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: handleProjectAppRecord 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-22 下午7:13:18
	* @throws 
	*/
	public int handleProjectAppRecord(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* insertProjectInvestRedPackage(添加项目惊喜红包配置) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertProjectInvestRedPackage 
	* @Description: TODO 
	* @param @param lEntities
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午7:14:19
	* @throws 
	*/
	public int insertProjectInvestRedPackage(List<ProjectInvestRedPackageEntity> lEntities,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* deleteProjectInvestRedPackageById(根据项目申请id 删除项目惊喜红包配置) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteProjectInvestRedPackageById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午7:14:58
	* @throws 
	*/
	public int deleteProjectInvestRedPackageById(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* insertProjectAppAttachment(添加项目目申请附件资料) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertProjectAppAttachment 
	* @Description: TODO 
	* @param @param list
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午7:17:36
	* @throws 
	*/
	public int insertProjectAppAttachment(List<ProjectAppAttachmentEntity> list,InsertAdminLogEntity entity, String[] sIpInfo);
	
	
	/** 
	* deleteProjectAppAttachment  根据项目申请id 删除所有项目申请附件资料 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: deleteProjectAppAttachment 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-22 下午8:28:42
	* @throws 
	*/
	public int deleteProjectAppAttachment(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo);

	/** 
	* selectAllProjectPurpose 借款意向分页条件查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllProjectPurpose 
	* @Description: TODO 
	* @param @param page
	* @param @return 设定文件 
	* @return List<ProjectPurposeEntity> 返回类型 
	* @date 2016-3-22 下午5:54:59
	* @throws 
	*/
	public List<ProjectPurposeEntity> selectAllProjectPurpose(PageEntity page);
	
	/** 
	* selectProjectPurposeById 根据借款意向id查询借款信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectPurposeById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return ProjectPurposeEntity 返回类型 
	* @date 2016-3-22 下午5:56:13
	* @throws 
	*/
	public ProjectPurposeEntity selectProjectPurposeById(Map<String, Object> map);
	
	
	/** 
	* selectProjectAppRecordById(根据意向记录id查询项目申请信息) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectAppRecordById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return ProjectAppRecordEntity 返回类型 
	* @date 2016-3-22 下午5:57:20
	* @throws 
	*/
	public ProjectAppRecordEntity selectProjectAppRecordById(Map<String, Object> map);
	
	
	/** 
	* selectProjectBaseInfoById(根据项目基本信息ID查询项目基本信息) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectBaseInfoById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return ProjectBaseInfoEntity 返回类型 
	* @date 2016-3-22 下午5:58:10
	* @throws 
	*/
	public ProjectBaseInfoEntity selectProjectBaseInfoById(Map<String, Object> map);
	
	
	/** 
	* selectProjectAppMngFeeById(根据项目申请id 查询项目费用设置) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectAppMngFeeById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return ProjectAppMngFeeEntity 返回类型 
	* @date 2016-3-22 下午5:59:15
	* @throws 
	*/
	public ProjectAppMngFeeEntity selectProjectAppMngFeeById(Map<String, Object> map);
	
	
	/** 
	* selectProjectAppAutoSetById(根据项目申请id 查询自动投标设置 ) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectAppAutoSetById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return ProjectAppAutoSetEntity 返回类型 
	* @date 2016-3-22 下午6:00:18
	* @throws 
	*/
	public ProjectAppAutoSetEntity selectProjectAppAutoSetById(Map<String, Object> map);
	
	
	/** 
	* selectProjectInvestRedPackageById(根据项目申请id 查询项目惊喜红包配置) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectInvestRedPackageById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<ProjectInvestRedPackageEntity> 返回类型 
	* @date 2016-3-22 下午6:02:15
	* @throws 
	*/
	public List<ProjectInvestRedPackageEntity> selectProjectInvestRedPackageById(Map<String, Object> map);
	
	
	/** 
	* selectProjectAppAttachmentById(根据项目申请id 查询项目申请附件资料) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectProjectAppAttachmentById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<ProjectAppAttachmentEntity> 返回类型 
	* @date 2016-3-22 下午6:03:38
	* @throws 
	*/
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachmentById(Map<String, Object> map);
	 
}
