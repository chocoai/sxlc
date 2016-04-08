

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
import cn.springmvc.dao.MemberMsgSetListDao;
 

/** 
 * @author 刘利 
 * @Description:会员消息提醒设置
 * @since 
 * @date 2016-3-29 下午5:42:58  */
@Repository("memberMsgSetListDaoImpl")
public class MemberMsgSetListDaoImpl extends SqlSessionDaoSupport  implements MemberMsgSetListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public List<SendSetEntity> selectMessageTypeList() {
		
		return getSqlSession().selectList("sendSet.selectMessageTypeList");
		
	}
	@Override
	public List<SendSetEntity> selectMemberSmsSendSet(long memberID) {
		
		return getSqlSession().selectList("sendSet.selectMemberSmsSendSet",memberID);
		
	}
	@Override
	public List<SendSetEntity> selectMemberEmailSendSet(long memberID) {
		
		return getSqlSession().selectList("sendSet.selectMemberEmailSendSet",memberID);
		
	}
	@Override
	public List<SendSetEntity> selectMemberLetterSendSet(long memberID) {
		
		return getSqlSession().selectList("sendSet.selectMemberLetterSendSet",memberID);
		
	}
	@Override
	public int selectMemberSmsSendSetIsExist(Map<String, Object> map) {
		
		return getSqlSession().selectOne("sendSet.selectMemberSmsSendSetIsExist",map);
		
	}
	@Override
	public int selectMemberEmailSendSetIsExist(Map<String, Object> map) {
		
		return getSqlSession().selectOne("sendSet.selectMemberEmailSendSetIsExist",map);
		
	}
	@Override
	public int selectMemberLetterSendSetsExist(Map<String, Object> map) {
		
		return getSqlSession().selectOne("sendSet.selectMemberLetterSendSetsExist",map);
		
	}
	@Override
	public int selectIsOpenSms(long typeID) {
		
		return getSqlSession().selectOne("sendSet.selectIsOpenSms",typeID);
		
	}
	@Override
	public int selectIsOpenEmail(long typeID) {
		
		return getSqlSession().selectOne("sendSet.selectIsOpenEmail",typeID);
		
	}
	@Override
	public int selectIsOpenLetter(long typeID) {
		
		return getSqlSession().selectOne("sendSet.selectIsOpenLetter",typeID);
		
	}

}

