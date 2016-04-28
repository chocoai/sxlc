

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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.CreditorTransferCheckListDao;
import cn.springmvc.model.CreditorTransferCheckEntity;

/** 
 * @author 刘利 
 * @Description: 债权转让管理
 * @since 
 * @date 2016-4-25 下午12:05:42  */
@Repository("creditorTransferCheckListDaoImpl")
public class CreditorTransferCheckListDaoImpl extends SqlSessionDaoSupport
						implements CreditorTransferCheckListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<CreditorTransferCheckEntity> selectCreditorTransferManager(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("CreditorTransferManager.selectCreditorTransferManager",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public CreditorTransferCheckEntity selectCreditorTransferDetailCheck(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("CreditorTransferManager.selectCreditorTransferDetailCheck",map);
		
	}
	@Override
	public String selectTransMaxTime(long ctaId) {
		
		return  getSqlSession().selectOne("CreditorTransferManager.selectTransMaxTime",ctaId);
		
	}

}

