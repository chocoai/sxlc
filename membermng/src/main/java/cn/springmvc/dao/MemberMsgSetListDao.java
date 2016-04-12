

/** 
* @Title: MemberMsgRecordListDao.java 
* @Package cn.membermsgrecord.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:19:14 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.SendSetEntity;
 
/** 
 * @author 刘利 
 * @Description: 会员消息提醒设置
 * @since 
 * @date 2016-3-29 下午6:19:14  */

public interface MemberMsgSetListDao {
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
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:22:52
	 */
	public int selectMemberSmsSendSetIsExist(Map<String,Object> map);
	/**
	 * 根据会员ID与短信接收类型 查询会员该类型的邮件接收 设置是否存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:22:52
	 */
	public int selectMemberEmailSendSetIsExist(Map<String,Object> map);
	/**
	 * 根据会员ID与短信接收类型 查询会员该类型的站内信接收 设置是否存在 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:24:56
	 */
	public int selectMemberLetterSendSetsExist(Map<String,Object> map);
	/**
	 * 根据短信接收类型 查询平台是否开通 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  typeID 接收类型ID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:26:12
	 */
	public int selectIsOpenSms(long typeID);
	/**
	 * 根据邮件接收类型 查询平台是否开通
	 * @author 刘利   
	 * @Description: TODO 
	 * @param typeID 接收类型ID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:28:48
	 */
	public int selectIsOpenEmail(long typeID);
	/**
	 * 根据站内信接收类型 查询后台是否开通
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  typeID 接收类型ID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-30 上午11:31:15
	 */
	public int selectIsOpenLetter(long typeID);
}

