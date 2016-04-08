

/** 
* @Title: CapitalbudgetdetailsListDaoImpl.java 
* @Package cn.capitalbudgetdetails.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午4:51:41 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MyinvestEntity;
import cn.springmvc.dao.MyinvestListDao;

/**
 * 
 * @author 刘利 
 * @Description: 个人中心-我的投资
 * @since 
 * @date 2016-3-31 下午2:13:16
 */
@Repository("myinvestListDaoImpl")
public class MyinvestListDaoImpl extends SqlSessionDaoSupport  implements MyinvestListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public List<MyinvestEntity> selectMyinvestCollect(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyInvest.selectMyinvestCollect",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvestSettled(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyInvest.selectMyinvestSettled",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvesting(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyInvest.selectMyinvesting",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<InvestIncomeEntity> selectRealincome(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyInvest.selectRealincome",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<InvestIncomeEntity> selectInvestIncome(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyInvest.selectInvestIncome",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	 
}

