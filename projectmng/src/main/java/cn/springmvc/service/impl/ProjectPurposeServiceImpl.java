
package cn.springmvc.service.impl; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.ProjectPurposeDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectPurposeDaoImpl;
import cn.springmvc.model.ProjectPurposeEntity;
import cn.springmvc.service.ProjectPurposeService;
/**
 * 
* @author 刘利 
* @Description: 实现新增借款意向
* @since 
* @date 2016-3-18 下午7:13:25
 */
@Service("projectPurposeServiceImpl")
public class ProjectPurposeServiceImpl implements ProjectPurposeService {
	@Resource(name="projectPurposeDaoImpl")
	private ProjectPurposeDao projectPurposeDaoImpl;  
	@Override
	public int insertProjectPurpose(ProjectPurposeEntity entity) { 
		if(entity == null) {
			return 0;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
        int result= projectPurposeDaoImpl.insertProjectPurposeDao(entity);
        if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		}  
        return result;

	} 
}

