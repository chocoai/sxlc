package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.VIPSetSubDao;
import cn.springmvc.model.VIPSetSubEntity; 
@Repository("vipSetSubDaoImpl")
public class VIPSetSubDaoImpl extends SqlSessionDaoSupport implements VIPSetSubDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertVIPSetSub(VIPSetSubEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("vipSetSub.insertVIPSetSub", entity);
		return iResult;
	} 
	@Override
	public int updateVIPSetSub(VIPSetSubEntity entity) {
		int result=0;
		result=getSqlSession().update("vipSetSub.updateVIPSetSub", entity);
		return result;
	}

	@Override
	public int deleteVIPSetSub(int id) {
		int result=0;
		result=getSqlSession().delete("vipSetSub.deleteVIPSetSub", id);
		return result;
	}
 
}
