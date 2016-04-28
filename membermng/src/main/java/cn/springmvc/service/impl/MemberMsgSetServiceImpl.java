

/** 
* @Title: MemberMsgRecordServiceImpl.java 
* @Package cn.membermsgrecord.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午6:25:48 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.SendSetEntity; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MemberMsgSetDaoImpl;
import cn.springmvc.dao.impl.MemberMsgSetListDaoImpl;
import cn.springmvc.service.MemberMsgSetService;

/** 
 * @author 刘利 
 * @Description: 会员消息提醒设置
 * @since 
 * @date 2016-3-29 下午6:25:48  */
@Service("memberMsgSetServiceImpl")
public class MemberMsgSetServiceImpl implements MemberMsgSetService{
	@Resource(name="memberMsgSetDaoImpl")
	private MemberMsgSetDaoImpl memberMsgSetDaoImpl;
	@Resource(name="memberMsgSetListDaoImpl")
	private MemberMsgSetListDaoImpl memberMsgSetListDaoImpl;
	@Override
	public int insertMemberSmsSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenSms(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		} 
		result = memberMsgSetDaoImpl.insertMemberSmsSendSet(sendSetEntity);
		return result;
	}
	@Override
	public int insertMemberEmailSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenEmail(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		}
		result = memberMsgSetDaoImpl.insertMemberEmailSendSet(sendSetEntity);
		return result;
		
	}
	@Override
	public int insertMemberLetterSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenLetter(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		}
		result = memberMsgSetDaoImpl.insertMemberLetterSendSet(sendSetEntity);
		return result;
		
	}
	@Override
	public int updateMemberSmsSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenSms(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		}
		result = memberMsgSetDaoImpl.updateMemberSmsSendSet(sendSetEntity);
		return result;
		
	}
	@Override
	public int updateMemberEmailSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenEmail(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		}
		result = memberMsgSetDaoImpl.updateMemberEmailSendSet(sendSetEntity);
		return result;
		
	}
	@Override
	public int updateMemberLetterSendSet(SendSetEntity sendSetEntity) {
		
		int result = 0;
		if(sendSetEntity == null) {
			
			return -1;
		}
		//查询平台是否开通该类型的消息设置
		result = memberMsgSetListDaoImpl.selectIsOpenLetter(sendSetEntity.getTypeID());
		if( result == 0 ) {
			return -2;
		}
		result = memberMsgSetDaoImpl.updateMemberLetterSendSet(sendSetEntity);
		return result;
		
	}
	@Override
	public List<SendSetEntity> selectMessageTypeList() {
		
		return memberMsgSetListDaoImpl.selectMessageTypeList();
		
	}
	@Override
	public List<SendSetEntity> selectMemberSmsSendSet(long memberID) {
		
		return memberMsgSetListDaoImpl.selectMemberSmsSendSet(memberID);
		
	}
	@Override
	public List<SendSetEntity> selectMemberEmailSendSet(long memberID) {
		
		return memberMsgSetListDaoImpl.selectMemberEmailSendSet(memberID);
		
	}
	@Override
	public List<SendSetEntity> selectMemberLetterSendSet(long memberID) {
		
		return memberMsgSetListDaoImpl.selectMemberLetterSendSet(memberID);
		
	}
	@Override
	public int selectMemberSmsSendSetIsExist(Map<String, Object> map) {
		
		return memberMsgSetListDaoImpl.selectMemberSmsSendSetIsExist(map);
		
	}
	@Override
	public int selectMemberEmailSendSetIsExist(Map<String, Object> map) {
		
		return memberMsgSetListDaoImpl.selectMemberEmailSendSetIsExist(map);
		
	}
	@Override
	public int selectMemberLetterSendSetsExist(Map<String, Object> map) {
		
		return memberMsgSetListDaoImpl.selectMemberLetterSendSetsExist(map);
		
	} 
}

