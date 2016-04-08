package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.MemberAttestTypeDao;
import cn.springmvc.model.MemberAttestTypeEntity;
 
@Repository("memberAttestTypeDaoImpl")
public class MemberAttestTypeDaoImpl extends SqlSessionDaoSupport  implements MemberAttestTypeDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertMemberAttestType(MemberAttestTypeEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("memberAttestType.insertMemberAttestType", entity);
		return iResult;
	}

	@Override
	public int updateMemberAttestTypeByID(MemberAttestTypeEntity entity) {
		int result=0;
		result=getSqlSession().update("memberAttestType.updateMemberAttestTypeByID", entity);
		return result;
	}

	@Override
	public int deleteMemberAttestTypeByID(int id) {
		int result=0;
		result=getSqlSession().delete("memberAttestType.deleteMemberAttestTypeByID", id);
		return result;
	}

	@Override
	public int updateMemberAttestTypeStatuByID(MemberAttestTypeEntity entity) {
		int result=0;
		result=getSqlSession().update("memberAttestType.updateMemberAttestTypeStatuByID", entity);
		return result;
	}

}
