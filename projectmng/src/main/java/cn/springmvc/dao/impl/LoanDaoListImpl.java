

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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.LoanDao;
import cn.springmvc.dao.LoanDaoList;
import cn.springmvc.model.LoanProjectEntity;

/** 
 * @author 刘利 
 * @Description: 项目放款列表查询
 * @since 
 * @date 2016-4-14 上午9:13:09  */
@Repository("loanDaoListImpl")
public class LoanDaoListImpl extends SqlSessionDaoSupport implements LoanDaoList {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<LoanProjectEntity> selectLoanList(PageEntity pageEntity) {
		
		return getSqlSession().selectList("projectLoan.selectLoanList",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

		
	}
	
	 

}

