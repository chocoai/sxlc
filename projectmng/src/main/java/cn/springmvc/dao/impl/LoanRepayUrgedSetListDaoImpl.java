package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.LoanRepayUrgedSetListDao; 
import cn.springmvc.model.LoanRepayUrgedSetEntity;
@Repository("loanRepayUrgedSetListDaoImpl")
public class LoanRepayUrgedSetListDaoImpl  extends SqlSessionDaoSupport  implements LoanRepayUrgedSetListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public LoanRepayUrgedSetEntity selectLoanRepayUrgedSet() {
		LoanRepayUrgedSetEntity platroductIntroduceentity=new  LoanRepayUrgedSetEntity();
		platroductIntroduceentity=getSqlSession().selectOne("loanRepayUrgedSet.selectLoanRepayUrgedSet");
		return platroductIntroduceentity;
	}
	@Override
	public int selectLoanRepayUrgedSetIsExist() {
		int result=0;
		result=getSqlSession().selectOne("loanRepayUrgedSet.selectLoanRepayUrgedSetIsExist");
		return result;
	} 
 
}
