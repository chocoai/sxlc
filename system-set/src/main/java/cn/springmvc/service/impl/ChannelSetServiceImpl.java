
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.impl.HandleChannelSetDaoImpl;
import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectChannelSetDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SmsSettingsEntity;
import cn.springmvc.model.ThreeInterfaceEntity;
import cn.springmvc.service.ChannelSetService;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.QuickRechargeFeeService;



/** 
 * 第三方通道设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午4:16:51  */
@Service("channelSetServiceImpl")
public class ChannelSetServiceImpl implements
ChannelSetService {
	@Resource(name="selectChannelSetDaoImpl")
	private SelectChannelSetDaoImpl  selectChannelSetDaoImpl;
	@Resource(name="handleChannelSetDaoImpl")
	private HandleChannelSetDaoImpl  handleChannelSetDaoImpl;
	@Override
	public List<MessageTypeEntity> selectChannelSet() {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectChannelSet();
	}

	@Override
	public List<SmsSettingsEntity> selectSmsSettings(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectSmsSettings(pageEntity);
	}

	@Override
	public SmsSettingsEntity findSmsSettingsById(
			SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.findSmsSettingsById(settingsEntity);
	}

	@Override
	public int countSmsSettings(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return selectChannelSetDaoImpl.countSmsSettings(map);
	}

	@Override
	public List<Object> updateChannelSet(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return handleChannelSetDaoImpl.updateChannelSet(map);
	}

	@Override
	public List<Object> updateMessage(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return handleChannelSetDaoImpl.updateMessage(map);
	}

	@Override
	public int insertSmsSettings(SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.insertSmsSettings(settingsEntity);
	}

	@Override
	public int updateSmsSettingsById(SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updateSmsSettingsById(settingsEntity);
	}

	@Override
	public int updteSmsSettingsStatu(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updteSmsSettingsStatu(map);
	}

	@Override
	public MailSettingsEntity selectMailSettings() {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectMailSettings();
	}

	@Override
	public int updateMailSettings(MailSettingsEntity mailSettingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updateMailSettings(mailSettingsEntity);
	}

	@Override
	public int insertMailSettings(MailSettingsEntity mailSettingsEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.insertMailSettings(mailSettingsEntity);
	}

	@Override
	public List<ThreeInterfaceEntity> selectThreeInterface() {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectThreeInterface();
	}

	@Override
	public int updateThreeInterface(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updateThreeInterface(map);
	}

	@Override
	public int insertThreeInterface(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.insertThreeInterface(map);
	}
	
	

}

