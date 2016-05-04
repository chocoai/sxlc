

/** 
* @Title: investListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午12:56:38 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.HandleProjectAppRecordDao;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;



/** 
 * 意向提交到申请相关
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-23 上午9:20:11  */
@Repository("handleProjectAppRecrdDaoImpl")
public class HandleProjectAppRecrdDaoImpl extends SqlSessionDaoSupport implements HandleProjectAppRecordDao {
	
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updateProjectPurposeById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ProjectAppRecordXML.updateProjectPurposeById", map);
	}

	@Override
	public int distributionOfFC(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ProjectAppRecordXML.distributionOfFC", map);
	}

	@Override
	public Map<String, Object> handleProjectAppRecord(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ProjectAppRecordXML.handleProjectAppRecord",map);
	}

	@Override
	public int insertProjectInvestRedPackage(
			List<ProjectInvestRedPackageEntity> lEntities) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ProjectAppRecordXML.insertProjectInvestRedPackage", lEntities);
	}

	@Override
	public int deleteProjectInvestRedPackageById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("ProjectAppRecordXML.deleteProjectInvestRedPackageById", map);
	}

	@Override
	public int insertProjectAppAttachment(List<ProjectAppAttachmentEntity> list) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ProjectAppRecordXML.insertProjectAppAttachment", list);
	}

	@Override
	public int deleteProjectAppAttachment(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("ProjectAppRecordXML.deleteProjectAppAttachment", map);
	}
	
}

