package cn.springmvc.service;

import java.util.List;
 
import cn.springmvc.model.ProjectPurposeEntity;
  
/**
 * 
* @author 刘利 
* @Description: 实现新增借款意向 
* @since 
* @date 2016-3-18 下午7:11:31
 */
public interface ProjectPurposeService {
	/**
	 * 新增借款意向
	 * @param entity 会员认证类型实体
	 * @return 0：数据为空;1:添加成功
	 */
	public int insertProjectPurpose(ProjectPurposeEntity entity); 
	 
}
