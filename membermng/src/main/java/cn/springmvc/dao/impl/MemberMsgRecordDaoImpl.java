

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

import cn.springmvc.dao.MemberMsgRecordDao;
 
/** 
 * @author 刘利 
 * @Description:会员站内消息 
 * @since 
 * @date 2016-3-29 下午5:42:58  */
@Repository("memberMsgRecordDaoImpl")
public class MemberMsgRecordDaoImpl extends SqlSessionDaoSupport  implements MemberMsgRecordDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updateMemberMsgIsRead(Map<String, Object> map) {
		
		return getSqlSession().update("memberMsgRecord.updateMemberMsgIsRead",map);
		
	}
 

}

