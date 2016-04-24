package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IStaffInfoReadDao;
import cn.springmvc.model.StaffInfo;

@Component
public class StaffInfoReadDaoImpl extends SqlSessionDaoSupport implements IStaffInfoReadDao{

	
	
	@Override
	public List<StaffInfo> getListByParam(PageEntity pageEntity) {
		return getSqlSession().selectList("StaffInfoDaoImpl.getListByParam",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}
	
	@Override
	public StaffInfo findById(Map<String, Object> param) {
		
		return getSqlSession().selectOne("StaffInfoDaoImpl.findById",param);
	}
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
}

