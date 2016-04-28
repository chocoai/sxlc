

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
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.ProjectPublishListDao;
import cn.springmvc.dao.projectPublishDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectAppRecordEntity; 
import cn.springmvc.model.ProjectImageEntity; 
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	 
 
	@Override
	public List<ProjectAppRecordEntity> selectProjectPublishList(
			PageEntity pageEntity) {
		
		return projectPublishListDaoImpl.selectProjectPublishList(pageEntity);
		
	}


	@Override
	public int insertProjectImage(List<ProjectImageEntity> ProjectImage,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = projectPublishDaoImpl.insertProjectImage(ProjectImage);
		if(result > 0) {
		    logentity.setsDetail("上传企业形象图");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

 	@Override
	public int publishProject(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
 		
 		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("checkid", id);
 		int result = projectPublishDaoImpl.publishProject(map);
 		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
			StringBuffer detail =new StringBuffer("发布项目");
		    if(map.get("checkStatu").toString().equals("1")) {
		    	detail.append("通过");
		    }else if(map.get("checkStatu").toString().equals("-1")){
		    	detail.append("打回");
		    } 
		    logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
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
	public int updateEndtime(ProjectAppProcessEntity projectAppProcessEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result =  projectPublishDaoImpl.updateEndtime(projectAppProcessEntity);
		if(result > 0) {
		    logentity.setsDetail("修改借款结束时间:"+projectAppProcessEntity.getEndDate());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}


	@Override
	public ProjectAppProcessEntity selectProjectEndtime(long projectID) {
		
		return  projectPublishListDaoImpl.selectProjectEndtime(projectID);
		
	}

 
}

