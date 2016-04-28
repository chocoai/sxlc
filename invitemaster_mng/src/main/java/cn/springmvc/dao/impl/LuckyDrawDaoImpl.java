

/** 
* @Title: LotteryManageDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午10:19:35 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.LuckyDrawDao;

/** 
 * @author 刘利 
 * @Description: 抽奖管理
 * @since 
 * @date 2016-4-15 上午10:19:35  */
@Repository("luckyDrawDaoImpl")
public class LuckyDrawDaoImpl extends SqlSessionDaoSupport implements LuckyDrawDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public int LotteryManageSet(Map<String, Object> map) { 
		
		getSqlSession().selectOne("LuckyDraw.LotteryManageSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}
	@Override
	public int LotterySet(Map<String, Object> map) {
		
		getSqlSession().selectOne("LuckyDraw.LotterySet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}
	@Override
	public int PrizeDelete(Map<String, Object> map) {
		
		getSqlSession().selectOne("LuckyDraw.PrizeDelete",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}
	@Override
	public int PrizeSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("LuckyDraw.PrizeSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
		
	}

}

