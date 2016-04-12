package cn.springmvc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.MemberInfo;




/***
 * 数据访问层基类
 * @author LiJie
 *
 */
@Repository("baseDao")
public class BaseDao extends SqlSessionDaoSupport{
	@Resource(name="")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
	public List<MemberInfo> getListByParam(PageEntity entity){
		return getSqlSession().selectList("",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
