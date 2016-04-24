
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.impl.HandleInterestMngFeeDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectInterestMngFeeDaoImpl;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.InterestMngFeeEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.IntegralRuleService;
import cn.springmvc.service.InterestMngFeeService;
import cn.springmvc.service.OverdueService;
import cn.springmvc.service.QuickRechargeFeeService;

/** 
 * 利息管理费 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("interestMngFeeServiceImpl")
public class InterestMngFeeServiceImpl implements InterestMngFeeService {
	@Resource(name="selectInterestMngFeeDaoImpl")
	private SelectInterestMngFeeDaoImpl  selectInterestMngFeeDaoImpl;
	@Resource(name="handleInterestMngFeeDaoImpl")
	private HandleInterestMngFeeDaoImpl  handleInterestMngFeeDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<InterestMngFeeEntity> selectAllInterestMngFee() {
		
		// TODO Auto-generated method stub return null;
		return selectInterestMngFeeDaoImpl.selectAllInterestMngFee();
	}


	@Override
	public int updateInterestMngFee(InterestMngFeeEntity interestMngFeeEntity,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("修改利息管理费设置:"+interestMngFeeEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleInterestMngFeeDaoImpl.updateInterestMngFee(interestMngFeeEntity);
	}


	@Override
	public int insertInterestMngFee(InterestMngFeeEntity interestMngFeeEntity,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("添加利息管理费设置:"+interestMngFeeEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleInterestMngFeeDaoImpl.insertInterestMngFee(interestMngFeeEntity);
	}
	
}

