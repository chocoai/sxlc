package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AffairInfo;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.LotteryRecords;
import cn.invitemastermng.model.PrizeInformation;
import cn.invitemastermng.model.RedRecord;
import cn.invitemastermng.model.RedpacketsDetailRecord;
import cn.springmvc.dao.IRedPackageReadDao;


@Repository
public class RedPackageReadDaoImpl extends SqlSessionDaoSupport implements IRedPackageReadDao{


	@Override
	public List<RedRecord> redRecord(PageEntity entity) {
			
		return getSqlSession().selectList("redPackageDao.redRecord",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	};
	
	
	@Override
	public List<PrizeInformation> prizeInformations() {
		
		return getSqlSession().selectList("redPackageDao.prizeInformations");
	}
	
	
	@Override
	public List<LotteryRecords> winners(PageEntity entity) {
		
		return getSqlSession().selectList("redPackageDao.winners",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<LotteryManage> lotteryConfig(long lid) {
		
		return getSqlSession().selectList("redPackageDao.lotteryConfig",lid);
	}
	
	
	@Override
	public List<RedpacketsDetailRecord> redPackageConf(long aid) {
		
		return getSqlSession().selectList("redPackageDao.redPackageType", aid);
	}
	
	@Override
	public int BlackMemberJudgmentTow(long memberId, int mType) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("mType", mType);
		getSqlSession().selectOne("redPackageDao.BlackMemberJudgmentTow",map);
		int result = IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return result;
	}
	
	@Override
	public AffairInfo findLatelyInfo() {
		
		return getSqlSession().selectOne("redPackageDao.findLatelyInfo");
	}
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

