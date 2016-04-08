
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleCreditorDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 债权转让设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("handleCreditorDaoImpl")
public class HandleCreditorDaoImpl extends SqlSessionDaoSupport implements HandleCreditorDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	/* * 
	 * 添加债权转让设置
	 *  *  * @param creditorEntity
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleCreditorDao#inserCreditor(cn.springmvc.model.CreditorEntity) */
	@Override
	public int inserCreditor(CreditorEntity creditorEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("CreditorXML.insertCreditor",creditorEntity);
	}

	
	/* * 
	 * 修改债权转让设置
	 *  *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleCreditorDao#updateCreditor(java.util.Map) */
	@Override
	public int updateCreditor(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("CreditorXML.updateCreditor", map);
	}
	
	
	
	

}

