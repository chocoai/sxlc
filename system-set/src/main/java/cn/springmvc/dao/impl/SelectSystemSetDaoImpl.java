
package cn.springmvc.dao.impl; 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.FinancialSettingDao;
import cn.springmvc.dao.SelectSystemSetDao;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;

@Component("selectSystemSetDaoImpl")
public class SelectSystemSetDaoImpl extends SqlSessionDaoSupport implements SelectSystemSetDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public SystemSetEntity findSystemSet() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("SystemSetXML.selectSystemSet");
	}

	@Override
	public SystemInfoSetEntity findSystemInfoSet() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("SystemSetXML.selectSystemInfoSet");
	}
	@Override
	public Integer findInterestMngFee() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("SystemSetXML.findInterestMngFee");
	}
	
}

