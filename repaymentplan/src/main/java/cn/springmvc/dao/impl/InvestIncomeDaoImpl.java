

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

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.InvestIncomeDao;
import cn.springmvc.dao.InvestIncomeListDao;
import cn.springmvc.model.InvestIncomeEntity;
import cn.springmvc.model.InvestRecordInfoEntity;

/** 
 * @author 刘利 
 * @Description: 放款后生成收益计划
 * @since 
 * @date 2016-4-12 下午2:18:55  */
@Repository("investIncomeDaoImpl")
public class InvestIncomeDaoImpl extends SqlSessionDaoSupport implements
		InvestIncomeDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	 
	@Override
	public int insertInvestIncome(Map<String, Object> map) {
		
		getSqlSession().selectOne("investincome.insertInvestIncome",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);  
	}
	 
	@Override
	public int updateReplay(Map<String, Object> map) {
		
	    getSqlSession().selectOne("investincome.updateReplay",map);
	    return IntegerAndString.StringToInt(map.get("result").toString(),0);  
		
	}

}

