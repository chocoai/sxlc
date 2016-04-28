

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
 
import cn.springmvc.dao.ExtensionModuleGiftDao;

/** 
 * @author 刘利 
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:07:57  */
@Repository("extensionModuleGiftDaoImpl")
public class ExtensionModuleGiftDaoImpl extends SqlSessionDaoSupport implements
				ExtensionModuleGiftDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public int FirstInvestRedpacketsSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.FirstInvestRedpacketsSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int deleteFirstInvestRedpacketsSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.deleteFirstInvestRedpacketsSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int MemberRedpacketsSet(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.MemberRedpacketsSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int RedpacketsAffairinsert(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.RedpacketsAffairinsert",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int RedpacketsAffairupdate(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.RedpacketsAffairupdate",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	}

	@Override
	public int RedpacketsAffairrelease(Map<String, Object> map) {
		
		getSqlSession().selectOne("ExtensionModule.RedpacketsAffairrelease",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);
		
	} 
}

