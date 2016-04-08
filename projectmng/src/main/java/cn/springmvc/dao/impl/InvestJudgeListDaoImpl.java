

/** 
* @Title: InvestJudgeListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午10:58:39 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.InvestJudgeListDao;

/** 
 * @author 刘利 
 * @Description: 投资确认按钮判断
 * @since 
 * @date 2016-3-25 上午10:58:39  */
@Repository("investJudgeListDaoImpl")
public class InvestJudgeListDaoImpl extends SqlSessionDaoSupport  implements InvestJudgeListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public long selectInvestAmountByMemID(Map<String, Object> map) {
		
		return getSqlSession().selectOne("investJuge.selectInvestAmountByMemID",map);
		
	}

 	@Override
	public int selectInvestCountByApplyID(long applyID) {
		
 		return getSqlSession().selectOne("investJuge.selectInvestCountByApplyID",applyID);
		
	}

	@Override
	public Map<String, Object> selectGiftInfobyID(Map<String, Object> map) {
		
		return getSqlSession().selectOne("investJuge.selectGiftInfobyID",map);
		
	}

	@Override
	public int selectRedpacketsRateMax() {
		
		return getSqlSession().selectOne("investJuge.selectRedpacketsRateMax");
		
	}
}

