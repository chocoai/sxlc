
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.HandleRewarSetDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectRewarSetDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.RewardSetEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.QuickRechargeFeeService;
import cn.springmvc.service.RewarSetService;


@Service("rewarSetServiceImpl")
public class RewarSetServiceImpl implements
	RewarSetService {
	@Resource(name="selectRewarSetDaoImpl")
	private SelectRewarSetDaoImpl  selectRewarSetDaoImpl;
	@Resource(name="handleRewarSetDaoImpl")
	private HandleRewarSetDaoImpl  handleRewarSetDaoImpl;

	@Override
	public List<RewardSetEntity> selectRewarSetByType(PageEntity page) {
		// TODO Auto-generated method stub return null;
		return selectRewarSetDaoImpl.selectRewarSetByType(page);
	}


	@Override
	public RewardSetEntity selectMaxRewarSetByType(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectRewarSetDaoImpl.selectMaxRewarSetByType(map);
	}


	@Override
	public int insertRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleRewarSetDaoImpl.insertRewarSet(rewardSetEntity);
	}


	@Override
	public int updateRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleRewarSetDaoImpl.updateRewarSet(rewardSetEntity);
	}


	@Override
	public int deleteRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleRewarSetDaoImpl.deleteRewarSet(rewardSetEntity);
	}
	
}

