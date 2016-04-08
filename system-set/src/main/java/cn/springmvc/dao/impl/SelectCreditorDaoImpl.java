
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

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
@Component("selectCreditorDaoImpl")
public class SelectCreditorDaoImpl extends SqlSessionDaoSupport implements SelectCreditorDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/* *  
	 * 查询债权转让设置
	 * *  * @return * @see cn.springmvc.dao.SelectCreditorDao#findAllCreditor() */
	@Override
	public CreditorEntity findAllCreditor() {
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("CreditorXML.selectCreditor");
	}
	
	
	

}

