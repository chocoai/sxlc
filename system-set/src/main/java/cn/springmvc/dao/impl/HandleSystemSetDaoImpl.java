
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;

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
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("overdueInsteadDay", systemSetEntity.getOverdueInsteadDay());
		map.put("autoBackRate", systemSetEntity.getAutoBackRate());
		map.put("expirationReminderSet", systemSetEntity.getExpirationReminderSet());
		map.put("riskMarginRateMax", systemSetEntity.getRiskMarginRateMax());
		map.put("redpacketsRateMax", systemSetEntity.getRedpacketsRateMax());
		map.put("riskMarginType", systemSetEntity.getRiskMarginType());
		map.put("endDateRemind", systemSetEntity.getEndDateRemind());
		getSqlSession().selectOne("SystemSetXML.updateSystemSet",map);
		int i=IntegerAndString.StringToInt(map.get("rulet").toString(), -1);
		return i;
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

	
	@Override
	public Map<String, Object> setInterestMngFee(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("SystemSetXML.setInterestMngFee",map);
	}
}

