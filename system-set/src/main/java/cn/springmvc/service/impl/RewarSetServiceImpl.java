
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.impl.HandleRewarSetDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectRewarSetDaoImpl;
import cn.springmvc.model.RewardSetEntity;
import cn.springmvc.service.RewarSetService;


@Service("rewarSetServiceImpl")
public class RewarSetServiceImpl implements
	RewarSetService {
	@Resource(name="selectRewarSetDaoImpl")
	private SelectRewarSetDaoImpl  selectRewarSetDaoImpl;
	@Resource(name="handleRewarSetDaoImpl")
	private HandleRewarSetDaoImpl  handleRewarSetDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<RewardSetEntity> selectRewarSetByType(PageEntity page) {
		// TODO Auto-generated method stub return null;
		List<RewardSetEntity> list = selectRewarSetDaoImpl.selectRewarSetByType(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}


	@Override
	public RewardSetEntity selectMaxRewarSetByType(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectRewarSetDaoImpl.selectMaxRewarSetByType(map);
	}


	@Override
	public int insertRewarSet(RewardSetEntity rewardSetEntity,InsertAdminLogEntity entity, String[] sIpInfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		rewardSetEntity.setId(id);
		int result = handleRewarSetDaoImpl.insertRewarSet(rewardSetEntity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			entity.setsDetail("添加提奖设置:"+rewardSetEntity.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		}
		return result;
	}


	@Override
	public int updateRewarSet(RewardSetEntity rewardSetEntity,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail(" 修改提奖设置 :"+rewardSetEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleRewarSetDaoImpl.updateRewarSet(rewardSetEntity);
	}


	@Override
	public int deleteRewarSet(RewardSetEntity rewardSetEntity,InsertAdminLogEntity entity, String[] sIpInfo) {
		entity.setsDetail("删除提奖设置:"+rewardSetEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleRewarSetDaoImpl.deleteRewarSet(rewardSetEntity);
	}
	
}

