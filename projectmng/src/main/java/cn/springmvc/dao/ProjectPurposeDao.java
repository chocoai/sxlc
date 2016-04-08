
package cn.springmvc.dao; 

import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectPurposeEntity;
/**
 * 
* @author 刘利 
* @Description: 添加借款意向
* @since 
* @date 2016-3-18 下午7:06:20
 */
public interface ProjectPurposeDao {
	/**
	 * 添加借款意向
	 * @param entity  借款意向实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectPurposeDao(ProjectPurposeEntity entity); 
}

