
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleOverdueDao;
import cn.springmvc.model.OverdueEntity;

/** 
 * 债权转让设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("handleOverdueDaoImpl")
public class HandleOverdueDaoImpl extends SqlSessionDaoSupport implements HandleOverdueDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
	/* *  
	 * 添加逾期程度设置
	 * *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleOverdueDao#insertOverdueLimit(java.util.Map) */
	@Override
	public int insertOverdueLimit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("OverdueXML.insertOverdueLimit", map);
	}

	
	/* *  
	 * 修改逾期程度设置
	 * *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleOverdueDao#updateOverdueLimit(java.util.Map) */
	@Override
	public int updateOverdueLimit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("OverdueXML.updateOverdueLimit",map);
	}

	
	/* * 
	 * 添加逾期天数设置
	 *  *  * @param overdueEntity
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleOverdueDao#insertOverdue(cn.springmvc.model.OverdueEntity) */
	@Override
	public int insertOverdue(OverdueEntity overdueEntity) {
		// TODO Auto-generated method stub return 0;
		return  getSqlSession().insert("OverdueXML.insertOverdue", overdueEntity);
	}

	
	/* * 
	 * 删除逾期天数设置
	 *  *  * @param map
	 */
	/* *  *  * @return * @see cn.springmvc.dao.HandleOverdueDao#deleteOverdue(java.util.Map) */
	@Override
	public int deleteOverdue(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("OverdueXML.deleteOverdue",map);
	}

}

