
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.SelectTransferableCreditsDao;
import cn.springmvc.model.TransferRulesEntity;
import cn.springmvc.model.TransferableCreditsEntity;



@Component("selectTransferableCreditsDaoImpl")
public class SelectTransferableCreditsDaoImpl extends SqlSessionDaoSupport implements SelectTransferableCreditsDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public TransferRulesEntity selectTransferRules(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("TransferableCreditsXML.selectTransferRules", map);
	}

	@Override
	public List<TransferableCreditsEntity> selectTransferableCredits(
			PageEntity page) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("TransferableCreditsXML.selectTransferableCredits", page,new RowBounds(page.getPageNum(), page.getPageSize()));
	}

	
}

