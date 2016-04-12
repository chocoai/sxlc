
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleChannelSetDao;
import cn.springmvc.dao.HandleCreditorDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SmsSettingsEntity;


@Component("handleChannelSetDaoImpl")
public class HandleChannelSetDaoImpl extends SqlSessionDaoSupport implements HandleChannelSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<Object> updateChannelSet(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ChannelSetXML.updateChannelSet",map);
	}

	@Override
	public List<Object> updateMessage(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ChannelSetXML.updateMessage",map);
	}

	@Override
	public int insertSmsSettings(SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ChannelSetXML.insertSmsSettings", settingsEntity);
	}

	@Override
	public int updateSmsSettingsById(SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ChannelSetXML.updateSmsSettingsById", settingsEntity);
	}

	@Override
	public int updteSmsSettingsStatu(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ChannelSetXML.updteSmsSettingsStatu", map);
	}

	@Override
	public int updateMailSettings(MailSettingsEntity mailSettingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ChannelSetXML.updateMailSettings", mailSettingsEntity);
	}

	@Override
	public int insertMailSettings(MailSettingsEntity mailSettingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ChannelSetXML.insertMailSettings", mailSettingsEntity);
	}

	@Override
	public int updateThreeInterface(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ChannelSetXML.updateThreeInterface",map);
	}

	@Override
	public int insertThreeInterface(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ChannelSetXML.insertThreeInterface",map);
	}

	
	

}

