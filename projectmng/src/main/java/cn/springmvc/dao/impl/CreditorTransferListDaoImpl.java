

/** 
* @Title: CreditorTransferListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午11:26:42 
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
import cn.springmvc.dao.CreditorTransferListDao;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;

/** 
 * @author 刘利 
 * @Description: 债权转让 
 * @since 
 * @date 2016-4-6 上午11:26:42  */
@Repository("creditorTransferListDaoImpl")
public class CreditorTransferListDaoImpl extends SqlSessionDaoSupport implements CreditorTransferListDao {
	
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<CreditorTransferListEntity> selectCreditorTransferList(
			PageEntity pageEntity) {

		return getSqlSession().selectList("CreditorTransfer.selectCreditorTransferList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}
	@Override
	public CreditorTransferListEntity selectCreditorTransferDetail(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("CreditorTransfer.selectCreditorTransferDetail",map);
		
	}
	@Override
	public CreditorTransferListEntity selectCreditorAvailableaAmount(Map<String, Object> map) {
		
		return getSqlSession().selectOne("CreditorTransfer.selectCreditorAvailableaAmount",map);
		
	}
	@Override
	public List<InvestEntity> selectCreditorInvestRecordByctaId(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("investRecord.selectCreditorInvestRecordByctaId",map);
		
	}

}

