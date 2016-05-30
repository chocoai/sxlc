
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.IMemberWriteDao;


@Repository
public class MemberInfoWriteDaoImpl extends SqlSessionDaoSupport implements IMemberWriteDao{

	
	public int individualMember(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.individualMember",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int login(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.login",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editMemberPersonalInfo(Map<String, Object> param) {
		
		getSqlSession().selectOne("memberInfoDaoImpl.editMemberPersonalInfo", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int editMemberComplanyInfo(Map<String, Object> param) {
		
		getSqlSession().selectOne("memberInfoDaoImpl.editMemberComplanyInfo", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int applyAddFriends(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.applyAddFriends", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	@Override
	public int agreeAapplyForFriend(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.agreeAapplyForFriend", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	@Override
	public int confirmReceipt(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.confirmReceipt",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), 0);
				
	}
	
	@Override
	public int sign(Map<String, Object> param) {
		//getSqlSession().insert("memberInfoDaoImpl.sign", param);
		return getSqlSession().insert("memberInfoDaoImpl.sign", param);
		
	}
	
	
	@Override
	public int TestTransaction(char chars, int chars2) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userName", chars+"_"+chars);
		param.put("userAge", chars2);
		getSqlSession().selectOne("memberInfoDaoImpl.testTransaction",param);
		return IntegerAndString.StringToInt(param.get("result").toString());
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}



}

