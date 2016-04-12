

/** 
* @Title: ProjectAuditServiceImpl.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午1:02:03 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.ProjectPublishListDao;
import cn.springmvc.dao.projectPublishDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectAuditDaoImpl;
import cn.springmvc.dao.impl.ProjectPublishDaoImpl;
import cn.springmvc.dao.impl.ProjectPublishListDaoImpl;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectCheckRecordEntity;
import cn.springmvc.model.ProjectImageEntity;
import cn.springmvc.service.ProjectAuitService;
import cn.springmvc.service.ProjectPublishService;

/** 
 * @author 刘利 
 * @Description: 项目发布模块
 * @since 
 * @date 2016-3-23 下午1:02:03  */
@Service("projectPublishServiceImpl")
public class ProjectPublishServiceImpl implements ProjectPublishService {

	@Resource(name="projectPublishDaoImpl")
	private projectPublishDao projectPublishDaoImpl; 
	@Resource(name="projectPublishListDaoImpl")
	private ProjectPublishListDao projectPublishListDaoImpl; 
	 
 
	@Override
	public List<ProjectAppProcessEntity> selectProjectPublishList(
			PageEntity pageEntity) {
		
		return projectPublishListDaoImpl.selectProjectPublishList(pageEntity);
		
	}


	@Override
	public int insertProjectImage(List<ProjectImageEntity> ProjectImage) {
		
		return projectPublishDaoImpl.insertProjectImage(ProjectImage);
		
	}

 	@Override
	public int publishProject(Map<String,Object> map) {
 		
 		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("checkid", id);
 		int result = projectPublishDaoImpl.publishProject(map);
 		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
 		return result;
	}

 	
	@Override
	public List<ProjectImageEntity> selectProjectImageList(long applyId) {
		
		return projectPublishListDaoImpl.selectProjectImageList(applyId);
		
	}


	@Override
	public int updateEndtime(ProjectAppProcessEntity projectAppProcessEntity) {
		
		return projectPublishDaoImpl.updateEndtime(projectAppProcessEntity);
		
	}


	@Override
	public ProjectAppProcessEntity selectProjectEndtime(long projectID) {
		
		return  projectPublishListDaoImpl.selectProjectEndtime(projectID);
		
	}

 
}

