

/** 
* @Title: PostLoanManageDao.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午7:16:55 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.PostLoanManageDao;
import cn.springmvc.model.LoanRepayUrgedRecordEntity;

/** 
 * @author 刘利 
 * @Description: 贷后监管
 * @since 
 * @date 2016-4-15 下午7:16:55  */
@Repository("postLoanManageDaoImpl")
public class PostLoanManageDaoImpl extends SqlSessionDaoSupport implements
		 PostLoanManageDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertLoanRepayUrgedRecord(
			LoanRepayUrgedRecordEntity loanRepayUrgedRecordEntity) {
        
		//Post_Loan_Manage.xml
		return getSqlSession().insert("Post_Loan_Manage.insertLoanRepayUrgedRecord",
				loanRepayUrgedRecordEntity);

	}
	@Override
	public int insertProjectAfterLoanInfo(Map<String, Object> map) {
		
		//ProjectAfterLoan.XML
		getSqlSession().insert("ProjectAfterLoanAttach.insertProjectAfterLoanInfo",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
	}
	@Override
	public int deleteProjectAfterLoanInfoByID(long infoId) {
		
		//ProjectAfterLoan.XML
		return getSqlSession().delete("ProjectAfterLoanAttach.deleteProjectAfterLoanInfoByID",infoId);
		
	}
	@Override
	public int deleteAfterLoanAttachByinfoId(long infoId) {
		
		//ProjectAfterLoan.XML
	    return getSqlSession().delete("ProjectAfterLoanAttach.deleteAfterLoanAttachByinfoId",infoId);
		
	}

}

