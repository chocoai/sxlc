
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.SmsSettingsEntity;



/** 
 * 第三方通道设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午4:00:53  */
public interface HandleChannelSetDao {
	
	/** 
	* updateChannelSet  设置是否发送该类型消息
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: updateChannelSet 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<Object> 返回类型 
	* @throws 
	*/
	public List<Object> updateChannelSet(Map<String, Object> map);
	
	
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
	public List<Object> updateMessage(Map<String, Object> map);
	
	
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
	public int insertSmsSettings(SmsSettingsEntity settingsEntity);
	
	
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
	public int updateSmsSettingsById(SmsSettingsEntity settingsEntity);
	
	
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
	public int updteSmsSettingsStatu(Map<String, Object> map);
	
	
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
	public int updateMailSettings(MailSettingsEntity mailSettingsEntity);
	
	
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
	public int insertMailSettings(MailSettingsEntity mailSettingsEntity);
	
	
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
	public int updateThreeInterface(Map<String, Object> map);
	
	
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
	public int insertThreeInterface(Map<String, Object> map);
}

