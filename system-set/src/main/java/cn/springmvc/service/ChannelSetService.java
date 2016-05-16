
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.AccountEscrowInterfaceEntity;
import cn.springmvc.model.MailHistoryEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.SMSHistoryEntity;
import cn.springmvc.model.SendHistoryEntity;
import cn.springmvc.model.SmsSettingsEntity;
import cn.springmvc.model.ThreeInterfaceEntity;






/** 
 * 第三方通道设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午4:14:51  */
public interface ChannelSetService {
	/** 
	* selectChannelSet 查看消息类型设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectChannelSet 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<MessageTypeEntity> 返回类型 
	* @throws 
	*/
	public List<MessageTypeEntity> selectChannelSet();
	
	
	/** 
	* selectChannelSetByPage 分页查看消息类型设置 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectChannelSetByPage 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<MessageTypeEntity> 返回类型 
	* @date 2016-4-26 下午4:28:50
	* @throws 
	*/
	public List<MessageTypeEntity> selectChannelSetByPage(PageEntity pageEntity);
	/** 
	* selectSmsSettings 分页查询短信通道设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectSmsSettings 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<SmsSettingsEntity> 返回类型 
	* @throws 
	*/
	public List<SmsSettingsEntity> selectSmsSettings(PageEntity pageEntity);
	
	
	/** 
	* findSmsSettingsById  根据id查询单个短信通道设置
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: findSmsSettingsById 
	* @Description: TODO 
	* @param @param settingsEntity
	* @param @return 设定文件 
	* @return SmsSettingsEntity 返回类型 
	* @throws 
	*/
	public SmsSettingsEntity findSmsSettingsById(SmsSettingsEntity settingsEntity);
	
	
	/** 
	* countSmsSettings 查询已启用短信通道个数 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: countSmsSettings 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int countSmsSettings(Map<String, Object> map);
	

	/** 
	* updateChannelSet  设置是否发送该类型消息
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateChannelSet 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 	0:失败 1：成功
	* @return List<Object> 返回类型 
	* @throws 
	*/
	public int updateChannelSet(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* updateMessage 设置类型消息发送内容
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateMessage 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<Object> 返回类型 
	* @throws 
	*/
	public int updateMessage(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertSmsSettings 添加单个短信通道设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertSmsSettings 
	* @Description: TODO 
	* @param @param settingsEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertSmsSettings(SmsSettingsEntity settingsEntity,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* updateSmsSettingsById 根据id修改单个短信通道设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateSmsSettingsById 
	* @Description: TODO 
	* @param @param settingsEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateSmsSettingsById(SmsSettingsEntity settingsEntity,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* updteSmsSettingsStatu 启用禁用单个短信通道设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updteSmsSettingsStatu 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updteSmsSettingsStatu(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* selectMailSettings 查询邮件接口设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectMailSettings 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return MailSettingsEntity 返回类型 
	* @throws 
	*/
	public MailSettingsEntity selectMailSettings();

	/** 
	* updateMailSettings 修改邮件接口设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateMailSettings 
	* @Description: TODO 
	* @param @param mailSettingsEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateMailSettings(MailSettingsEntity mailSettingsEntity,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertMailSettings 添加邮件接口设置 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertMailSettings 
	* @Description: TODO 
	* @param @param mailSettingsEntity
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertMailSettings(MailSettingsEntity mailSettingsEntity,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* selectThreeInterface 查询第三方接口路径设置信息 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: selectThreeInterface 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return List<ThreeInterfaceEntity> 返回类型 
	* @throws 
	*/
	public List<ThreeInterfaceEntity> selectThreeInterface(PageEntity pageEntity);
	

	/** 
	* updateThreeInterface 修改第三方接口路径 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateThreeInterface 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int updateThreeInterface(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	
	/** 
	* insertThreeInterface 添加第三方接口路径 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: insertThreeInterface 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @throws 
	*/
	public int insertThreeInterface(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
	
	/** 
	* MailHistory 分页查询邮件发送历史记录分页查询邮件发送历史记录 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: MailHistory 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<MailHistoryEntity> 返回类型 
	* @date 2016-4-28 上午11:35:40
	* @throws 
	*/
	public List<MailHistoryEntity> MailHistory(PageEntity pageEntity);
	
	/** 
	* SMSHistory 分页查询短信发送历史记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SMSHistory 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<SMSHistoryEntity> 返回类型 
	* @date 2016-4-28 下午12:01:37
	* @throws 
	*/
	public List<SMSHistoryEntity> SMSHistory(PageEntity pageEntity);
	
	/** 
	* SMSHistory 分页查询站内信发送历史记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SMSHistory 
	* @Description: TODO 
	* @param @param pageEntity
	* @param @return 设定文件 
	* @return List<SMSHistoryEntity> 返回类型 
	* @date 2016-4-28 下午12:01:37
	* @throws 
	*/
	public List<SendHistoryEntity> SendHistory(PageEntity pageEntity);
	
	/** 
	* SetEnableDisable 设置启用停用消息类型
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SetEnableDisable 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-29 上午10:36:45
	* @throws 
	*/
	public int SetEnableDisable(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);

	/**
	 *  查询托管平台接口类型表 
	 * TODO
	 * 创建日期：2016-5-13上午10:46:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return List<AccountEscrowInterfaceEntity>
	 */
	public List<AccountEscrowInterfaceEntity> TypeAccountInterface();
}

