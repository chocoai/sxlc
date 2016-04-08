
package cn.springmvc.service.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.FinancialSettingDaoImpl;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.FinancialSettingService;

@Service("financialSettingServiceImpl")
public class FinancialSettingServiceImpl implements FinancialSettingService{
	@Resource(name="financialSettingDaoImpl")
	private FinancialSettingDaoImpl financialSettingDaoImpl;
	
	
	/* * 
	 * 修改提现手续费
	 *  *  * @param withdrawalsFeeEntity
	 */
	/* *  *  * @return * @see cn.springmvc.service.FinancialSettingService#updateWithdrawalsFee(cn.springmvc.model.WithdrawalsFeeEntity) */
	@Override
	public int updateWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity) {
		
		// TODO Auto-generated method stub return 0;
		return financialSettingDaoImpl.updateWithdrawalsFee(withdrawalsFeeEntity);
	}
	
	/* * 
	 * 查询提现手续费
	 *  *  * @return * @see cn.springmvc.service.FinancialSettingService#selectWithdrawalsFee() */
	@Override
	public WithdrawalsFeeEntity selectWithdrawalsFee() {
		
		// TODO Auto-generated method stub return null;
		return financialSettingDaoImpl.selectWithdrawalsFeeEntity();
	}
	
	/* *  
	 * 查询是否存在提现手续费
	 * *  * @return * @see cn.springmvc.service.FinancialSettingService#findWithdrawalsFee() */
	@Override
	public int findWithdrawalsFee(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return financialSettingDaoImpl.findWithdrawalsFee(map);
	}
	
	/* * 
	 * 如果不存在提现手续费 则添加
	 *  *  * @return * @see cn.springmvc.service.FinancialSettingService#insertWithdrawalsFee() */
	@Override
	public int insertWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity) {
		
		// TODO Auto-generated method stub return 0;
		return financialSettingDaoImpl.insertWithdrawalsFee(withdrawalsFeeEntity);
	}
}

