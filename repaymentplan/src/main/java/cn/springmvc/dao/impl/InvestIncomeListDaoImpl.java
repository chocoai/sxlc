

/** 
* @Title: InvestIncomeListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午2:18:55 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.InvestIncomeListDao;
import cn.springmvc.model.InvestIncomeEntity;
import cn.springmvc.model.InvestRecordInfoEntity;
import cn.springmvc.model.LoanRepayEntitys;

/** 
 * @author 刘利 
 * @Description: 放款后生成收益计划
 * @since 
 * @date 2016-4-12 下午2:18:55  */
@Repository("investIncomeListDaoImpl")
public class InvestIncomeListDaoImpl extends SqlSessionDaoSupport implements
		InvestIncomeListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<InvestRecordInfoEntity> selectInvestListByProjectID(
			Map<String, Object> map) {

		return getSqlSession().selectList("investincome.selectInvestListByProjectID",map);

	}
	@Override
	public InvestRecordInfoEntity selectInvestInfoByInvestID(long investID) {
		
		return getSqlSession().selectOne("investincome.selectInvestInfoByInvestID",investID);
		
	}
	@Override
	public List<LoanRepayEntitys> selectLoanRepayIDByapplyID(long applyID) {
		
		return  getSqlSession().selectList("investincome.selectLoanRepayIDByapplyID",applyID);
		 
	}
	 
	@Override
	public InvestIncomeEntity selectSumAmount(Map<String, Object> map) {
		
		return getSqlSession().selectOne("investincome.selectSumAmount",map);
		
	}
	@Override
	public String selectSDRecvMaxTime(long replayID) {
		
		return getSqlSession().selectOne("investincome.selectSDRecvMaxTime",replayID);
		
	}
	 

}

