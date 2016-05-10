

/** 
* @Title: InvestmentManagementListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午7:00:57 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.CreditorTransEntity;
import cn.membermng.model.InvestIncomeEntity;
import cn.springmvc.dao.InvestmentManagementListDao;

/** 
 * @author 刘利 
 * @Description: 我的债权 
 * @since 
 * @date 2016-4-13 下午7:00:57  */
@Repository("investmentManagementListDaoImpl")
public class InvestmentManagementListDaoImpl extends SqlSessionDaoSupport
		implements InvestmentManagementListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<CreditorTransEntity> getCreditorTransfer(
			PageEntity pageEntity) {

		return getSqlSession().selectList("Investment_management.getCreditorTransfer",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}

	@Override
	public List<CreditorTransEntity> getCreditorOut(PageEntity pageEntity) {

		return getSqlSession().selectList("Investment_management.getCreditorOut",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));


	}

	@Override
	public List<CreditorTransEntity> getCreditorIn(PageEntity pageEntity) {

		return getSqlSession().selectList("Investment_management.getCreditorIn",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}

	@Override
	public List<InvestIncomeEntity> getInvest(PageEntity pageEntity) {

		return getSqlSession().selectList("Investment_management.getInvest",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}

	@Override
	public List<CreditorTransEntity> getCreditorOff(PageEntity pageEntity) {

		return getSqlSession().selectList("Investment_management.getCreditorOff",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}
	@Override
	public List<CreditorTransEntity> getCreditorTransferBack(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("Investment_management.getCreditorTransferBack",pageEntity.getMap(),
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

}

