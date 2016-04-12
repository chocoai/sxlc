
package cn.springmvc.service.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.impl.FinancialSettingDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.FinancialSettingService;


/** 
 * 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-12 上午10:30:02  */
@Service("financialSettingServiceImpl")
public class FinancialSettingServiceImpl implements FinancialSettingService{
	@Resource(name="financialSettingDaoImpl")
	private FinancialSettingDaoImpl financialSettingDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	/* * 
	 * 修改提现手续费
	 *  *  * @param withdrawalsFeeEntity
	 */
	/* *  *  * @return * @see cn.springmvc.service.FinancialSettingService#updateWithdrawalsFee(cn.springmvc.model.WithdrawalsFeeEntity) */
	@Override
	public int updateWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("修改提现手续费："+withdrawalsFeeEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
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
	public int insertWithdrawalsFee(WithdrawalsFeeEntity withdrawalsFeeEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("添加提现手续费："+withdrawalsFeeEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return financialSettingDaoImpl.insertWithdrawalsFee(withdrawalsFeeEntity);
	}
}

