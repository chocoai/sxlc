

/** 
* @Title: NewbieExperienceListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:15:17 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.NewbieExperienceRecordsEntity;
import cn.invitemastermng.model.NewbieExperienceSetEntity;
import cn.springmvc.dao.NewbieExperienceListDao;

/** 
 * @author 刘利 
 * @Description: 新手体验标
 * @since 
 * @date 2016-4-15 下午2:15:17  */
@Repository("newbieExperienceListDaoImpl")
public class NewbieExperienceListDaoImpl extends SqlSessionDaoSupport implements
		NewbieExperienceListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<NewbieExperienceRecordsEntity> getExperienceIncome(
			PageEntity page) {

		return getSqlSession().selectList("Newbie_Experience.getExperienceIncome",page.getMap(),
				new RowBounds(page.getPageNum(),page.getPageSize()));

	}
	@Override
	public NewbieExperienceSetEntity getNewbieExperienceSet() {
		String skey =  DbKeyUtil.GetDbCodeKey();
		return getSqlSession().selectOne("Newbie_Experience.getNewbieExperienceSet",skey);
		
	}
	@Override
	public NewbieExperienceSetEntity getNewbieExperienceSetIndex() {
		String skey =  DbKeyUtil.GetDbCodeKey();
		return getSqlSession().selectOne("Newbie_Experience.getNewbieExperienceSetIndex",skey);
		
	}

}

