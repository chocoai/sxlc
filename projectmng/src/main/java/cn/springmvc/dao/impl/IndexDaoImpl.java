

/** 
* @Title: IndexDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-8 上午10:25:01 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.IndexDao;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.IndexStaticsEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 网站首页 
 * @since 
 * @date 2016-4-8 上午10:25:01  */
@Repository("indexDaoImpl")
public class IndexDaoImpl extends SqlSessionDaoSupport implements IndexDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public IndexStaticsEntity selectIndexStatistic(String sKey) {
		
		 return getSqlSession().selectOne("Index.selectIndexStatistic",sKey);
		
	}
	@Override
	public List<ProjectAppRecordEntity> selectInvestListIndex() {
		
		return getSqlSession().selectList("Index.selectInvestListIndex");
		
	}
	@Override
	public List<CreditorTransferListEntity> selectCreditorTransferListIndex(Map<String, Object> map) {
		
		return getSqlSession().selectList("Index.selectCreditorTransferListIndex",map);
		
	}
	@Override
	public List<InvestEntity> selectInvestRecordIndex(Map<String, Object> map) {
		
		return getSqlSession().selectList("Index.selectInvestRecordIndex",map);
		
	}

}

