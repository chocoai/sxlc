
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.HandleTransferableCreditsDao;
import cn.springmvc.dao.SelectTransferableCreditsDao;
import cn.springmvc.model.TransferRulesEntity;
import cn.springmvc.model.TransferableCreditsEntity;




/** 
 * 债权转让申请相关操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:33:18  */
@Component("handleTransferableCreditsDaoImpl")
public class HandleTransferableCreditsDaoImpl extends SqlSessionDaoSupport implements HandleTransferableCreditsDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Map<String, Object> creditorTransApp(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("TransferableCreditsXML.creditorTransApp", map);
	}

	
	
}

