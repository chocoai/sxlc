

/** 
* @Title: GenerateRepayListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:50:46 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;  

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.InviteMasterApplyDao;
import cn.springmvc.dao.InviteMasterApplyListDao;

/** 
 * @author 刘利 
 * @Description: 推荐达人
 * @since 
 * @date 2016-4-1 下午1:50:46  */
@Repository("inviteMasterApplyListDaoImpl")
public class InviteMasterApplyListDaoImpl extends SqlSessionDaoSupport implements InviteMasterApplyListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
 
	@Override
	public int selectInviteMasterApplyIsExist(long memberID) {
		
		return getSqlSession().selectOne("InviteMasterApply.selectInviteMasterApplyIsExist",memberID);
		
	} 
}

