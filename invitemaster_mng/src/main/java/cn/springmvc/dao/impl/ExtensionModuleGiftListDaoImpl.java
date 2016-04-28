

/** 
* @Title: ExtensionModuleListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:08:44 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.FirstInvestRedpacketsSetEntity; 
import cn.invitemastermng.model.MemberRedpacketsEntity;
import cn.invitemastermng.model.MemberRedpacketsSetEntity;
import cn.invitemastermng.model.RedpacketsAffairEntity; 
import cn.invitemastermng.model.RedpacketsDetailRecordEntity;
import cn.springmvc.dao.ExtensionModuleGiftListDao; 

/** 
 * @author 刘利 
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:08:44  */
@Repository("extensionModuleGiftListDaoImpl")
public class ExtensionModuleGiftListDaoImpl extends SqlSessionDaoSupport implements
				ExtensionModuleGiftListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<RedpacketsAffairEntity> getRedpacketsAffair(PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.getRedpackets_Affair",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<MemberRedpacketsEntity> getRedpacketsreceive(PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.getRedpackets_receive",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public MemberRedpacketsSetEntity selectMemberRedpacketsSet() {
		
		return getSqlSession().selectOne("Promotion_set.selectMemberRedpacketsSet");
		
	}

	@Override
	public FirstInvestRedpacketsSetEntity selectFIInvestRedSetByID(long fiRpID) {
		
		return getSqlSession().selectOne("Promotion_set.selectFIInvestRedSetByID",fiRpID);
		
	}

	@Override
	public List<FirstInvestRedpacketsSetEntity> selectFIInvestRedSetList(
			PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.selectFIInvestRedSetList",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}
	@Override
	public RedpacketsAffairEntity selectRedpacketsAffairbyID(long affairID) {
		
		return getSqlSession().selectOne("Promotion_set.selectRedpacketsAffairbyID",affairID);
		
	}
	@Override
	public List<RedpacketsDetailRecordEntity> selectRedpacketsDetailbyaffairID(
			long affairID) {
		
		return getSqlSession().selectList("Promotion_set.selectRedpacketsDetailbyaffairID",affairID);
		
	} 
}

