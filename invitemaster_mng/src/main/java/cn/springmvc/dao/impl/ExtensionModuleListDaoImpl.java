

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

import cn.invitemastermng.model.CpsInviteSetEntity; 
import cn.invitemastermng.model.MemberInfoEntity;   
import cn.invitemastermng.model.SeoSetEntity;
import cn.invitemastermng.model.SeoSetTypeEntity;
import cn.springmvc.dao.ExtensionModuleListDao;

/** 
 * @author 刘利 
 * @Description: 推广模块
 * @since 
 * @date 2016-4-15 下午8:08:44  */
@Repository("extensionModuleListDaoImpl")
public class ExtensionModuleListDaoImpl extends SqlSessionDaoSupport implements
		ExtensionModuleListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<MemberInfoEntity> getIMapply(PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.getIM_apply",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
		
	}

	@Override
	public List<MemberInfoEntity> getIMInvite(PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.getIM_Invite",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<SeoSetEntity> getSEODisplay(PageEntity page) {
		
		return getSqlSession().selectList("Promotion_set.getSEO_Display",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public CpsInviteSetEntity selectCpsInviteSet() {
		
		return getSqlSession().selectOne("Promotion_set.selectCpsInviteSet");
		
	}

	@Override
	public SeoSetEntity getSEOSetByID(long seoSetID) {
		
		return getSqlSession().selectOne("Promotion_set.getSEOSetByID",seoSetID);
		
	}

	@Override
	public List<SeoSetTypeEntity> getSeoSetType() {
		
		return getSqlSession().selectList("Promotion_set.getSeoSetType");
		
	}

	@Override
	public int getInviteMasterSet() {
		
		Integer result = getSqlSession().selectOne("Promotion_set.getInviteMasterSet");
		if (result == null) { 
			result = 0;
		}
		return result;
	} 
}

