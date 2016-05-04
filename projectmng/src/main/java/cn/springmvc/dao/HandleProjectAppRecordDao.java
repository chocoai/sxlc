package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;


/** 
 * 借款申请相关操作类
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-22 下午7:09:59  */
public interface HandleProjectAppRecordDao {
	
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
	public int updateProjectPurposeById(Map<String, Object> map);
	
	
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
	public int distributionOfFC(Map<String, Object> map);
	
	
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
	public Map<String, Object> handleProjectAppRecord(Map<String, Object> map);
	
	
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
	public int insertProjectInvestRedPackage(List<ProjectInvestRedPackageEntity> lEntities);
	
	
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
	public int deleteProjectInvestRedPackageById(Map<String, Object> map);
	
	
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
	public int insertProjectAppAttachment(List<ProjectAppAttachmentEntity> list);
	
	
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
	public int deleteProjectAppAttachment(Map<String, Object> map);
}
