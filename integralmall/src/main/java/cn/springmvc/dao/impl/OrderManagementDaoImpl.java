package  cn.springmvc.dao.impl;
 
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
 
import cn.springmvc.dao.OrderManagementDao;
 
@Repository("orderManagementDaoImpl")
public class OrderManagementDaoImpl extends SqlSessionDaoSupport  implements OrderManagementDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int deliverGoods(Map<String, Object> map) {
		
		  getSqlSession().selectOne("OrderManage.deliverGoods",map);
		  return IntegerAndString.StringToInt(map.get("result").toString(),0);  
		
	}

	@Override
	public int CancelOrder(Map<String, Object> map) {
		
		 getSqlSession().selectOne("OrderManage.CancelOrder",map);
		  return IntegerAndString.StringToInt(map.get("result").toString(),0);  
		
	}
 
	 
}
