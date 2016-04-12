

/** 
* @Title: MamberBankCardDaoImpl.java 
* @Package cn.bankcard.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 下午2:40:18 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.springmvc.dao.MamberBankCardDao;
/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-28 下午2:40:18  */
@Repository("memberBankCardDaoImpl")
public class MemberBankCardDaoImpl extends SqlSessionDaoSupport implements MamberBankCardDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertBankCardInfo(BankCardInfoEntity bankCardInfoEntity) {

		return getSqlSession().insert("bankInfo.insertBankCardInfo",bankCardInfoEntity);

	}
	@Override
	public int insertMemberBankCard(MemberBankCardEntity memberBankCardEntity) {
		
		return getSqlSession().insert("bankInfo.insertMemberBankCard",memberBankCardEntity);
		
	}
	@Override
	public int updateBankCardInfo(BankCardInfoEntity bankCardInfoEntity) {
		
		return getSqlSession().update("bankInfo.updateBankCardInfo",bankCardInfoEntity);
		
	}
	@Override
	public int deleteMemberBankCard(int receiveCard) {
		
		return getSqlSession().update("bankInfo.deleteMemberBankCard",receiveCard);
		
	}

}

