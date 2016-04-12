package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProductIntroduceDao;
import cn.springmvc.model.ProductIntroduceEntity;
import cn.springmvc.model.ProductIntroduceEntity;
@Repository("productIntroduceDaoImpl")
public class ProductIntroduceDaoImpl extends SqlSessionDaoSupport implements ProductIntroduceDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProductIntroduce(ProductIntroduceEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("Mapper.insertProductIntroduce", entity);
		return iResult;
	} 
	@Override
	public int updateProductIntroduceByID(ProductIntroduceEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateProductIntroduceByID", entity);
		return result;
	}

	@Override
	public int deleteProductIntroduceByID(int id) {
		int result = 0;
		result = getSqlSession().delete("Mapper.deleteProductIntroduceByID", id);
		return result;
	}

	@Override
	public int updateProductIntroduceStatuByID(ProductIntroduceEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateProductIntroduceStatuByID", entity);
		return result;
	}
 

}
