
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleLeveSetDao;
import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.MemberLevelEntity;



/** 
 * 会员等级设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午8:26:41  */
@Component("handleLeveSetDaoImpl")
public class HandleLeveSetDaoImpl extends SqlSessionDaoSupport implements HandleLeveSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertMemberLevel(MemberLevelEntity memberLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("LevelSetXML.insertMemberLevel", memberLevelEntity);
	}

	@Override
	public int updateMemberLevelById(MemberLevelEntity memberLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("LevelSetXML.updateMemberLevelById", memberLevelEntity);
	}

	@Override
	public int deleteMemberLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("LevelSetXML.deleteMemberLevelById", map);
	}

	@Override
	public int insertCreditLevel(CreditLevelEntity creditLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("LevelSetXML.insertCreditLevel", creditLevelEntity);
	}

	@Override
	public int updateCreditLevelById(CreditLevelEntity creditLevelEntity) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("LevelSetXML.updateCreditLevelById", creditLevelEntity);
	}

	@Override
	public int deleteCreditLevelById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("LevelSetXML.deleteCreditLevelById", map);
	}

	

}

