

/** 
* @Title: MemberMsgRecordService.java 
* @Package cn.membermsgrecord.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午5:21:52 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.SendSetEntity;

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 会员消息提醒设置
 * @since 
 * @date 2016-3-29 下午5:21:52  */

public interface MemberMsgSetService {
	/**
	 * 设置会员短信发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberSmsSendSet(SendSetEntity sendSetEntity);
	/**
	 * 设置会员邮件发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberEmailSendSet(SendSetEntity sendSetEntity);
	/**
	 * 设置会员站内信发送类型 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功
	 * @date 2016-3-30 上午11:47:00
	 */
	public int insertMemberLetterSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改 会员短信发送类型 设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功  
	 * @date 2016-3-30 上午11:54:31
	 */
	public int updateMemberSmsSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改会员邮件发送类型 设置
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功
	 * @date 2016-3-30 上午11:55:16
	 */
	public int updateMemberEmailSendSet(SendSetEntity sendSetEntity);
	/**
	 * 修改会员站内信发送类型设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   sendSetEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1数据为空 -2平台未开通该类型的消息设置，0失败1成功
	 * @date 2016-3-30 上午11:56:03
	 */
	public int updateMemberLetterSendSet(SendSetEntity sendSetEntity);
	/**
	 * 查询平台消息类型列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<SendSetEntity> 返回类型 
	 * @date 2016-3-30 上午11:13:55
	 */
	public List<SendSetEntity> selectMessageTypeList();
	/**
	 *  根据会员ID查询会员勾选的短信接收类型
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  memberID 会员ID
	 * @param @return 设定文件 
	 * @return List<SendSetEntity> 返回类型 
	 * @date 2016-3-30 上午11:16:08
	 */
	public List<SendSetEntity> selectMemberSmsSendSet(long memberID);
	/**
	 *  根据会员ID查询会员勾选的邮件接收类型
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 会员ID
	 * @param @return 设定文件 
	 * @return List<SendSetEntity> 返回类型 
	 * @date 2016-3-30 上午11:19:08
	 */
	public List<SendSetEntity> selectMemberEmailSendSet(long memberID);
	/**
	 *  根据会员ID查询会员勾选的站内信接收类型
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  memberID 会员ID
	 * @param @return 设定文件 
	 * @return List<SendSetEntity> 返回类型 
	 * @date 2016-3-30 上午11:19:08
	 */
	public List<SendSetEntity> selectMemberLetterSendSet(long memberID);
	/**
	 * 根据会员ID与短信接收类型 查询会员该类型的短信接收 设置是否存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map {memberID,typeID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:22:52
	 */
	public int selectMemberSmsSendSetIsExist(Map<String,Object> map);
	/**
	 * 根据会员ID与短信接收类型 查询会员该类型的邮件接收 设置是否存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {memberID,typeID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:22:52
	 */
	public int selectMemberEmailSendSetIsExist(Map<String,Object> map);
	/**
	 * 根据会员ID与短信接收类型 查询会员该类型的站内信接收 设置是否存在 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {memberID,typeID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:24:56
	 */
	public int selectMemberLetterSendSetsExist(Map<String,Object> map);
 
}

