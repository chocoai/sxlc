

/** 
* @Title: BorrowingManagementListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午1:51:12 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.InvestEntity;
import cn.membermng.model.ProjectAppRecordEntity;
import cn.springmvc.dao.MyBorrowAndInvestListDao; 

/** 
 * @author 刘利 
 * @Description: 后台-会员管理-借款项目-投资项目
 * @since 
 * @date 2016-4-13 下午1:51:12  */
@Repository("myBorrowAndInvestListDaoImpl")
public class MyBorrowAndInvestListDaoImpl extends SqlSessionDaoSupport
		implements MyBorrowAndInvestListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<ProjectAppRecordEntity> getBorrowing(PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyBorrowAndInvest.getBorrowing",pageEntity.getMap(),new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<InvestEntity> getInvestmentProject(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("MyBorrowAndInvest.getInvestmentProject",pageEntity.getMap(),new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	 

}

