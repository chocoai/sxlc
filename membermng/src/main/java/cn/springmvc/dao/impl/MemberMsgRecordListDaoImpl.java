

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

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.membermng.model.MemberMsgRecordEntity;
import cn.springmvc.dao.MemberMsgRecordListDao;

import product_p2p.kit.pageselect.PageEntity; 
/** 
 * @author 刘利 
 * @Description:会员站内消息 
 * @since 
 * @date 2016-3-29 下午5:42:58  */
@Repository("memberMsgRecordListDaoImpl")
public class MemberMsgRecordListDaoImpl extends SqlSessionDaoSupport  implements MemberMsgRecordListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<MemberMsgRecordEntity> selectMemberMsgList(PageEntity pageEntity) {
		
		return getSqlSession().selectList("memberMsgRecord.selectMemberMsgList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

}

