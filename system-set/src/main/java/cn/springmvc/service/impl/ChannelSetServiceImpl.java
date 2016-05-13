
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleChannelSetDaoImpl;
import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectChannelSetDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MailHistoryEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SMSHistoryEntity;
import cn.springmvc.model.SendHistoryEntity;
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
	@Override
	public List<MessageTypeEntity> selectChannelSet() {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectChannelSet();
	}

	@Override
	public List<SmsSettingsEntity> selectSmsSettings(PageEntity pageEntity) {
		List<SmsSettingsEntity> list = selectChannelSetDaoImpl.selectSmsSettings(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
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

	
	/* *  *  * @param map
	/* *  *  * @param entity
	/* *  *  * @param sIpInfo
	/* *  *  * @return * @see cn.springmvc.service.ChannelSetService#updateChannelSet(java.util.Map, product_p2p.kit.optrecord.InsertAdminLogEntity, java.lang.String[]) */
	@Override
	public int updateChannelSet(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("设置是否发送该类型消息 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		handleChannelSetDaoImpl.updateChannelSet(map);
		//rulset ==1 成功
		 int rulset = IntegerAndString.StringToInt(map.get("rulset").toString(), -1);
		return rulset;
	}

	@Override
	public int updateMessage(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("设置类型消息发送内容 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		 handleChannelSetDaoImpl.updateMessage(map);
		 //rulset ==0 成功
		 int rulset = IntegerAndString.StringToInt(map.get("rulset").toString(), -1);
		return rulset;
	}

	@Override
	public int insertSmsSettings(SmsSettingsEntity settingsEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		settingsEntity.setId(generatorUtil.GetId());
		entity.setsDetail("添加单个短信通道设置 :"+settingsEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		int rule=0;
		rule = handleChannelSetDaoImpl.insertSmsSettings(settingsEntity);
		if (rule==1) {
			generatorUtil.SetIdUsed(settingsEntity.getId());
		}else {
			generatorUtil.SetIdUsedFail(settingsEntity.getId());
		}
		return rule;
	}

	@Override
	public int updateSmsSettingsById(SmsSettingsEntity settingsEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("修改单个短信通道设置 :"+settingsEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updateSmsSettingsById(settingsEntity);
	}

	@Override
	public int updteSmsSettingsStatu(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("启用禁用单个短信通道设置 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updteSmsSettingsStatu(map);
	}

	@Override
	public MailSettingsEntity selectMailSettings() {
		
		// TODO Auto-generated method stub return null;
		return selectChannelSetDaoImpl.selectMailSettings();
	}

	@Override
	public int updateMailSettings(MailSettingsEntity mailSettingsEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("修改邮件接口设置 :"+mailSettingsEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.updateMailSettings(mailSettingsEntity);
	}

	@Override
	public int insertMailSettings(MailSettingsEntity mailSettingsEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("添加邮件接口设置 :"+mailSettingsEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.insertMailSettings(mailSettingsEntity);
	}

	@Override
	public List<ThreeInterfaceEntity> selectThreeInterface(PageEntity pageEntity) {
		
		List<ThreeInterfaceEntity> list =  selectChannelSetDaoImpl.selectThreeInterface(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public int updateThreeInterface(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		
		entity.setsDetail("修改第三方接口:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return handleChannelSetDaoImpl.updateThreeInterface(map);
	}

	@Override
	public int insertThreeInterface(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		
		entity.setsDetail("添加第三方接口:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return handleChannelSetDaoImpl.insertThreeInterface(map);
	}

	@Override
	public List<MessageTypeEntity> selectChannelSetByPage(PageEntity pageEntity) {
		List<MessageTypeEntity> list = selectChannelSetDaoImpl.selectChannelSetByPage(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	
	@Override
	public List<MailHistoryEntity> MailHistory(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		 List<MailHistoryEntity> list =  selectChannelSetDaoImpl.MailHistory(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	@Override
	public List<SendHistoryEntity> SendHistory(PageEntity pageEntity) {
		List<SendHistoryEntity> list = selectChannelSetDaoImpl.SendHistory(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	@Override
	public List<SMSHistoryEntity> SMSHistory(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		List<SMSHistoryEntity> list =  selectChannelSetDaoImpl.SMSHistory(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}
	@Override
	public int SetEnableDisable(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("启用禁用短信类型接口:"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleChannelSetDaoImpl.SetEnableDisable(map);
	}
}

