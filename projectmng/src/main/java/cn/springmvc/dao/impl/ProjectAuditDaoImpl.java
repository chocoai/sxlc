

/** 
* @Title: ProjectAuitDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午12:58:55 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString; 
import cn.springmvc.dao.ProjectAuitDao; 
import cn.springmvc.model.ProjectCheckAttachDealEntity;
import cn.springmvc.model.ProjectCheckAttachEntity; 

/** 
 * @author 刘利 
 * @Description: 项目审核模块
 * @since 
 * @date 2016-3-23 下午12:58:55  */
@Repository("projectAuditDaoImpl")
public class ProjectAuditDaoImpl extends SqlSessionDaoSupport implements ProjectAuitDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	 
	@Override
	public int projectAudit(Map<String, Object> map) {
		
		 getSqlSession().selectOne("projectAudit.projectAudit",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0);
		
	}
	 
	 	
	@Override
	public int insertProjectCheckAttach(
			List<ProjectCheckAttachEntity> projectCheckAttachList) {
		
		int result = getSqlSession().insert("projectCheckAttach.insertProjectCheckAttach",projectCheckAttachList);
		//插入审核附件操作记录
		if(result > 1){
			result = getSqlSession().insert("projectCheckAttach.insertCheckAttach",projectCheckAttachList);
		}
		return result;
	}
	
 	
	@Override
	public int deleteProjectCheckAttach(
			List<ProjectCheckAttachEntity> projectCheckAttachList) {
		
		int result = getSqlSession().update("projectCheckAttach.deleteCheckAttach",projectCheckAttachList);
		//插入审核附件操作记录
		if(result > 1){
			result = getSqlSession().insert("projectCheckAttach.insertCheckAttach",projectCheckAttachList);
		}
		return result; 
	}

 	@Override
	public int deleteProjectCheckAttachone(Map<String,Object> map) {
		
 		int result = getSqlSession().delete("projectCheckAttach.deleteCheckAttachont",map); 
		return result;
	}

    @Override
	public int insertCheckAttachone(
			ProjectCheckAttachDealEntity projectCheckAttachDealEntity) {
		
		return getSqlSession().update("projectCheckAttach.insertCheckAttachone", projectCheckAttachDealEntity);
		
	}


	@Override
	public int updateProjectDetail(Map<String, Object> map) {
		
		 getSqlSession().selectOne("projectAudit.updateProjectDetail",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0);
		
	}


	@Override
	public int updateaffix(Map<String, Object> map) {
		
		 getSqlSession().selectOne("projectCheckAttach.updateaffix",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0);
		
	}
 
}

