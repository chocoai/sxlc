
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectRewarSetDao;
import cn.springmvc.model.RewardSetEntity;



/** 
 * 提奖设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午10:07:00  */
@Component("selectRewarSetDaoImpl")
public class SelectRewarSetDaoImpl extends SqlSessionDaoSupport implements SelectRewarSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<RewardSetEntity> selectRewarSetByType(PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("RewarSetXML.selectRewarSetByType", page,new RowBounds(page.getPageNum(),page.getPageSize()));
	}

	@Override
	public RewardSetEntity selectMaxRewarSetByType(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("RewarSetXML.selectMaxTotalInvest",map);
	}
	
	

}

