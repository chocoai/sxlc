package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.LoanRepayUrgedSetDao;
import cn.springmvc.model.LoanRepayUrgedSetEntity; 
@Repository("loanRepayUrgedSetDaoImpl")
public class LoanRepayUrgedSetDaoImpl extends SqlSessionDaoSupport implements LoanRepayUrgedSetDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("loanRepayUrgedSet.insertLoanRepayUrgedSet", entity);
		return iResult;
	} 
	@Override
	public int updateLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity) {
		int result=0;
		result=getSqlSession().update("loanRepayUrgedSet.updateLoanRepayUrgedSet", entity);
		return result;
	}

	@Override
	public int deleteLoanRepayUrgedSet(int id) {
		int result=0;
		result=getSqlSession().delete("loanRepayUrgedSet.deleteLoanRepayUrgedSet", id);
		return result;
	}
 
}
