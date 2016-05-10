
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.AwardRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.CommissionPaymentRecordsEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.PlatformAccountRecordEntity;
import cn.springmvc.dao.CommissionissuedListDao; 
import cn.springmvc.dao.impl.SelectCommissionPaymentDaoImpl;
import cn.springmvc.service.CommissionPaymentService;
import cn.springmvc.service.CommissionissuedService;


/** 
 * 佣金发放统计
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-26 下午2:16:42  */
@Service("commissionPaymentServiceImpl")
public class CommissionPaymentServiceImpl implements CommissionPaymentService{
	@Resource(name="selectCommissionPaymentDaoImpl")
	private  SelectCommissionPaymentDaoImpl selectCommissionPaymentDaoImpl;

	@Override
	public List<CommissionPaymentRecordsEntity> CommissionPaymentRecords(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectCommissionPaymentDaoImpl.CommissionPaymentRecords(pageEntity);
	}
	@Override
	public List<CommissionPaymentRecordsEntity> CommissionStatisticsCount(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectCommissionPaymentDaoImpl.CommissionStatisticsCount(pageEntity);
	}
	@Override
	public List<PlatformAccountRecordEntity> PlatformAccountRecord(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return selectCommissionPaymentDaoImpl.PlatformAccountRecord(pageEntity);
	}
}

