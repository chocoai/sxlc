
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectIntegralRuleDao;
import cn.springmvc.dao.SelectLeveSetDao;
import cn.springmvc.dao.SelectOverdueDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.MemberLevelEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;


@Component("selectLeveSetDaoImpl")
public class SelectLeveSetDaoImpl extends SqlSessionDaoSupport implements SelectLeveSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<MemberLevelEntity> selectAllMemberLevel(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("LevelSetXML.selectAllMemberLevel", pageEntity, new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}

	@Override
	public MemberLevelEntity findMemberLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("LevelSetXML.findMemberLevelById", map);
	}

	@Override
	public List<CreditLevelEntity> selectAllCreditLevel(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("LevelSetXML.selectAllCreditLevel", pageEntity, new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}

	@Override
	public CreditLevelEntity findCreditLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("LevelSetXML.findCreditLevelById", map);
	}

	
	
	

}

