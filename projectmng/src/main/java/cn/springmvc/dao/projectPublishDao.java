

/** 
* @Title: projectPublishDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午8:38:06 
* @version V5.0 */
 
package cn.springmvc.dao; 
 
import java.util.List;
import java.util.Map;

import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectImageEntity;
 

/** 
 * @author 刘利 
 * @Description: 项目发布
 * @since 
 * @date 2016-3-23 下午8:38:06  */

public interface projectPublishDao {
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
	 * @param @param projectAppProcessEntity 
	 * @return int 返回类型  -1 该项目已审核通过；-3 该项目该审核批次已审核； 1  审核通过  ,-4 上级审核批次未通过
	 * @date 2016-3-23 下午6:34:20
	 */
	public int publishProject(Map<String,Object> map);
	/**
	 * 修改借款结束时间
	 * @author 刘利   
	 * @Description: 修改借款结束时间
	 * @param projectID 项目申请拒绝ID
	 * @return int 返回类型 
	 * @date 2016-3-23 下午6:34:20
	 */
	public int updateEndtime(ProjectAppProcessEntity projectAppProcessEntity);
	/**
	 * 拒绝
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-5-13 下午5:15:57
	 */
	public int Refuse(long applyId);
	 
}

