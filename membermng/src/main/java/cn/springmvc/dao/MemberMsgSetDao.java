

/** 
* @Title: MemberMsgRecordDao.java 
* @Package cn.membermsgrecord.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:14:26 
* @version V5.0 */
 
package cn.springmvc.dao; 

import cn.membermng.model.SendSetEntity;
 
/** 
 * @author 刘利 
 * @Description: 会员消息提醒配置
 * @since 
 * @date 2016-3-29 下午6:14:26  */

public interface MemberMsgSetDao {
	/**
	 * 设置会员短信发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberSmsSendSet(SendSetEntity sendSetEntity);
	/**
	 * 设置会员邮件发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberEmailSendSet(SendSetEntity sendSetEntity);
	/**
	 * 设置会员站内信发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberLetterSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改 会员短信发送类型 设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:54:31
	 */
	public int updateMemberSmsSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改会员邮件发送类型 设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:55:16
	 */
	public int updateMemberEmailSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改会员站内信发送类型设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:56:03
	 */
	public int updateMemberLetterSendSet(SendSetEntity sendSetEntity);
}

