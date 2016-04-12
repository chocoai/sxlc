package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.MemberAttestTypeListDao;
import cn.springmvc.model.MemberAttestTypeEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("memberAttestTypeListDaoImpl")
public class MemberAttestTypeListDaoImpl extends SqlSessionDaoSupport implements MemberAttestTypeListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public MemberAttestTypeEntity selectMemberAttestTypeIsExistByNAme(
			MemberAttestTypeEntity entity) {
		 
		return getSqlSession().selectOne("memberAttestType.selectMemberAttestTypeIsExistByNAme",entity); 
	}

	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestTypeAllpage(
			PageEntity pageEntity) {
		List<MemberAttestTypeEntity> memberAttestTypeList=null;
		memberAttestTypeList=getSqlSession().selectList("memberAttestType.selectMemberAttestTypeList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return memberAttestTypeList;
	}
	@Override
	public MemberAttestTypeEntity selectMemberAttestTypeIsExistById(int id) {
		MemberAttestTypeEntity memberAttestTypeEntity=null;
		memberAttestTypeEntity=(MemberAttestTypeEntity) getSqlSession().selectOne("memberAttestType.selectMemberAttestentity",id);
		return memberAttestTypeEntity;
	}
	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestTypeByMemberType(
			MemberAttestTypeEntity entity) {
		List<MemberAttestTypeEntity> memberAttestTypeList=null;
		memberAttestTypeList=getSqlSession().selectList("memberAttestType.selectMemberAttestByMemberType",entity);
		return memberAttestTypeList;
		
	}

}
