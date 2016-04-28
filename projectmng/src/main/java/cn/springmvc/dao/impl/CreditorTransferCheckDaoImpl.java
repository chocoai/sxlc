

/** 
* @Title: CreditorTransferCheckListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-25 下午12:05:42 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 
 

import java.util.Map;

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.CreditorTransferCheckDao;

import product_p2p.kit.datatrans.IntegerAndString;
  

/** 
 * @author 刘利 
 * @Description: 债权转让管理
 * @since 
 * @date 2016-4-25 下午12:05:42  */
@Repository("creditorTransferCheckDaoImpl")
public class CreditorTransferCheckDaoImpl extends SqlSessionDaoSupport
						implements CreditorTransferCheckDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int creditorTransAppCheck(Map<String, Object> map) {
		
		 getSqlSession().selectOne("CreditorTransferManager.creditorTransAppCheck",map);
		 return IntegerAndString.StringToInt(map.get("result").toString(), 0);
	}

	@Override
	public int updateTransMaxTime(Map<String, Object> map) {
		
		return getSqlSession().update("CreditorTransferManager.updateTransMaxTime",map);
		
	}
	 

}

