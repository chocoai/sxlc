

/** 
* @Title: LuckyDrawListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午11:48:28 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.LotteryActivityEntity;
import cn.invitemastermng.model.LotteryRecordsEntity;
import cn.invitemastermng.model.PrizeInformationEntity;
import cn.springmvc.dao.LuckyDrawListDao;

/** 
 * @author 刘利 
 * @Description: 抽奖记录
 * @since 
 * @date 2016-4-15 上午11:48:28  */
@Repository("luckyDrawListDaoImpl")
public class LuckyDrawListDaoImpl extends SqlSessionDaoSupport implements
		LuckyDrawListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<LotteryRecordsEntity> getLotteryRecord(PageEntity page) {

		return getSqlSession().selectList("LuckyDraw.getLotteryRecord",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));

	}
	@Override
	public List<LotteryActivityEntity> selectLotteryActivity(PageEntity page) {
		
		return getSqlSession().selectList("LuckyDraw.selectLotteryActivity",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}
	@Override
	public List<PrizeInformationEntity> selectPrizeInformation(PageEntity page) {
		
		return getSqlSession().selectList("LuckyDraw.selectPrizeInformation",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}
	@Override
	public LotteryActivityEntity selectLotteryActivityByID(long lotteryID) {
		
		return getSqlSession().selectOne("LuckyDraw.selectLotteryActivityByID",lotteryID);
		
	}
	@Override
	public PrizeInformationEntity selectPrizeInformationByID(long prizeID) {
		
		return getSqlSession().selectOne("LuckyDraw.selectPrizeInformationByID",prizeID);
		
	}
	@Override
	public List<PrizeInformationEntity> selectPrizeByActID(PageEntity page) {
		
		return getSqlSession().selectList("LuckyDraw.selectPrizeByActID",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

}

