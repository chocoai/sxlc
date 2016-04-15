

/** 
* @Title: LoanDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-14 上午9:13:09 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.LoanDao;

/** 
 * @author 刘利 
 * @Description: 项目放款
 * @since 
 * @date 2016-4-14 上午9:13:09  */
@Repository("loanDaoImpl")
public class LoanDaoImpl extends SqlSessionDaoSupport implements LoanDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int Loan(Map<String, Object> map) {

		 getSqlSession().selectOne("projectLoan.Loan",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(),0);

	}

}

