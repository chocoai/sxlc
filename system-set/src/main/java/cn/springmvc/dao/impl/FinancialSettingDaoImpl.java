
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.FinancialSettingDao;
import cn.springmvc.model.WithdrawalsFeeEntity;

@Component("financialSettingDaoImpl")
public class FinancialSettingDaoImpl extends SqlSessionDaoSupport implements FinancialSettingDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	/* * 
	 * 查看是否存在提现手续费设置
	 *  
	 *  *  * @return * @see cn.springmvc.dao.FinancialSettingDao#findWithdrawalsFee() */
	@Override
	public int findWithdrawalsFee(Map<String, Object> map) {
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("WithdrawalsFeeXml.countWithdrawalsFee",map);
	}
	
	/* * 
	 * 修改提现手续费设置
	 *  
	 *  *  * @param withdrawalsFeeEntity
	 */
	/* *  *  * @return * @see cn.springmvc.dao.FinancialSettingDao#updateWithdrawalsFee(cn.springmvc.model.WithdrawalsFeeEntity) */
	@Override
	public int updateWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("WithdrawalsFeeXml.updateWithdrawalsFee", withdrawalsFeeEntity);
	}
	
	/* * 
	 * 添加提现手续费设置
	 *  *  * @param withdrawalsFeeEntity
	 */
	/* *  *  * @return * @see cn.springmvc.dao.FinancialSettingDao#insertWithdrawalsFee(cn.springmvc.model.WithdrawalsFeeEntity) */
	@Override
	public int insertWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("WithdrawalsFeeXml.insertWithdrawalsFee",withdrawalsFeeEntity);
	
	}
	
	/* * 
	 * 查询提现手续费设置
	 *  *  * @return * @see cn.springmvc.dao.FinancialSettingDao#selectWithdrawalsFeeEntity() */
	@Override
	public WithdrawalsFeeEntity selectWithdrawalsFeeEntity() {
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("WithdrawalsFeeXml.selectWithdrawalsFee");
	}
}

