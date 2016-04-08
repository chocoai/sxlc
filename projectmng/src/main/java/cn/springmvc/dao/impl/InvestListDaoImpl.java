

/** 
* @Title: investListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午12:56:38 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.InvestListDao;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 实现借款项目列表查询 
 * @since 
 * @date 2016-3-21 下午12:56:38  */
@Repository("investListDaoImpl")
public class InvestListDaoImpl extends SqlSessionDaoSupport implements InvestListDao {
	
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	 
	@Override
	public List<ProjectAppRecordEntity> selectInvestList(PageEntity pageEntity) {

		List<ProjectAppRecordEntity> projectAppRecordList = null;
		projectAppRecordList = getSqlSession().selectList("investList.selectInvestListfront",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
        return projectAppRecordList;
	}

}

