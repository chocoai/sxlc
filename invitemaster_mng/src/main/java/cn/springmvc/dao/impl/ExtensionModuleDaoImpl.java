

/** 
* @Title: ExtensionModuleDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:07:57 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.ExtensionModuleDao;

/** 
 * @author 刘利 
 * @Description: 推广模块 
 * @since 
 * @date 2016-4-15 下午8:07:57  */
@Repository("extensionModuleDaoImpl")
public class ExtensionModuleDaoImpl extends SqlSessionDaoSupport implements
		ExtensionModuleDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int seoSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.SEOSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
	}

	@Override
	public int seoDelete(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.SEODelete",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int CPSPromote(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.CPSPromote",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int inviteMasterSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.inviteMasterSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int inviteMasterApplyCheck(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.inviteMasterApplyCheck",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}
 
}

