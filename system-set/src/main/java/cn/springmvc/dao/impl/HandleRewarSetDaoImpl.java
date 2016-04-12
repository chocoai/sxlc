
package cn.springmvc.dao.impl; 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleRewarSetDao;
import cn.springmvc.dao.SelectRewarSetDao;
import cn.springmvc.model.RewardSetEntity;



/** 
 * 提奖设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午10:07:00  */
@Component("handleRewarSetDaoImpl")
public class HandleRewarSetDaoImpl extends SqlSessionDaoSupport implements HandleRewarSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("RewarSetXML.insertRewarSet",rewardSetEntity);
	}

	@Override
	public int updateRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("RewarSetXML.updateRewarSet",rewardSetEntity);
	}

	@Override
	public int deleteRewarSet(RewardSetEntity rewardSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("RewarSetXML.deleteRewarSet",rewardSetEntity);
	}
	
	

}

