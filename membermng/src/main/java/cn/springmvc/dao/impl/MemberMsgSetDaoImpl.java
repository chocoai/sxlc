

/** 
* @Title: MemberMsgRecordListDaoImpl.java 
* @Package cn.membermsgrecord.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午5:42:58 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.membermng.model.SendSetEntity;
import cn.springmvc.dao.MemberMsgSetDao;

import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description:会员消息提醒设置
 * @since 
 * @date 2016-3-29 下午5:42:58  */
@Repository("memberMsgSetDaoImpl")
public class MemberMsgSetDaoImpl extends SqlSessionDaoSupport  implements MemberMsgSetDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 

	@Override
	public int insertMemberSmsSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().insert("sendSet.insertMemberSmsSendSet", sendSetEntity);
		
	}

	@Override
	public int insertMemberEmailSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().insert("sendSet.insertMemberEmailSendSet", sendSetEntity);
		
	}

	@Override
	public int insertMemberLetterSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().insert("sendSet.insertMemberLetterSendSet", sendSetEntity);
		
	}

	@Override
	public int updateMemberSmsSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().update("sendSet.updateMemberSmsSendSet", sendSetEntity);
		
	}

	@Override
	public int updateMemberEmailSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().update("sendSet.updateMemberEmailSendSet", sendSetEntity);
		
	}

	@Override
	public int updateMemberLetterSendSet(SendSetEntity sendSetEntity) {
		
		return getSqlSession().update("sendSet.updateMemberLetterSendSet", sendSetEntity);
		
	}
 

}

