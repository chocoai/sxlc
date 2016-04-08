

/** 
* @Title: MemberBankCardDaoimpl.java 
* @Package cn.bankcard.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 上午11:07:12 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
import cn.springmvc.dao.MamberBankCardListDao;

/** 
 * @author 刘利 
 * @Description: TODO会员银行卡管理读 
 * @since 
 * @date 2016-3-28 上午11:07:12  */
@Repository("memberBankCardListDaoimpl")
public class MemberBankCardListDaoimpl extends SqlSessionDaoSupport implements MamberBankCardListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<BankCodeEntity> selectBankInfo() { 
		return getSqlSession().selectList("bankInfo.selectBankInfo"); 
	}

	@Override
	public List<ProvinceDictionaryEntity> selectProvinceDictionary() {
		
		return getSqlSession().selectList("bankInfo.selectProvinceDictionary"); 
		
	}

	@Override
	public List<CityDictionaryEntity> selectCityDictionary(int provinceId) {
		
		return  getSqlSession().selectList("bankInfo.selectProvinceDictionary",provinceId);
		
	}

	@Override
	public int selectMemberBankCardByNo(Map<String, Object> map) {
		
		return getSqlSession().selectOne("bankInfo.selectMemberBankCardByNo",map);
		
	}

	@Override
	public List<MemberBankCardEntity> selectMemberBankCardList(
			Map<String, Object> map) {
		
		return getSqlSession().selectList("bankInfo.selectMemberBankCardList",map);
		
	}

	@Override
	public BankCardInfoEntity selectMemberBankCardByID(int bankCardId) {
		
		return getSqlSession().selectOne("bankInfo.selectMemberBankCardByID",bankCardId);
		
	}

}

