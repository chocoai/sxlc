
package cn.springmvc.dao.impl; 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.FinancialSettingDao;
import cn.springmvc.dao.HandleSystemSetDao;
import cn.springmvc.dao.SelectSystemSetDao;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;

@Component("handleSystemSetDaoImpl")
public class HandleSystemSetDaoImpl extends SqlSessionDaoSupport implements HandleSystemSetDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updateSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("SystemSetXML.updateSystemSet",systemSetEntity);
	}

	@Override
	public int insertSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("SystemSetXML.insertSystemSet",systemSetEntity);
	}

	@Override
	public int updateSystemInfoSet() {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().delete("SystemSetXML.updateSystemInfoSet");
	}

	@Override
	public int insertSystemInfoSet(SystemInfoSetEntity systemInfoSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("SystemSetXML.insertSystemInfoSet",systemInfoSetEntity);
	}

	
	
}

