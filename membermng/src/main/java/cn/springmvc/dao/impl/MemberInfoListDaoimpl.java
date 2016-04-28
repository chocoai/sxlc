

/** 
* @Title: MemberInfoListDaoimpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 上午9:23:29 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.CompanyInfoEntity;
import cn.membermng.model.MemberInfoEntity;
import cn.membermng.model.PersonalBaseInfoEntity;
import cn.springmvc.dao.MemberInfoList;

/** 
 * @author 刘利 
 * @Description: 查询会员信息
 * @since 
 * @date 2016-3-21 上午9:23:29  */
@Repository("memberInfoListDaoimpl")
public class MemberInfoListDaoimpl extends SqlSessionDaoSupport  implements MemberInfoList{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
 	public List<MemberInfoEntity> selectMemberInfoAllpage(PageEntity pageEntity) {
		
 		List<MemberInfoEntity> memberInfoList = null;
 		memberInfoList=getSqlSession().selectList("memberInfo.selectMemberInfoList",pageEntity,
 				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return memberInfoList;
		
	}
	@Override
	public PersonalBaseInfoEntity selectMemberInfoPersonByID(long personID) {
		
		PersonalBaseInfoEntity personalBaseInfoEntity = getSqlSession().
				selectOne("memberInfo.selectMemberInfoPersonByID",personID);
		return personalBaseInfoEntity;
	
		
	}

	 
	@Override
	public CompanyInfoEntity selectMemberInfoCompanByID(long personID) {
		
		CompanyInfoEntity companyInfoEntity = getSqlSession().
				selectOne("memberInfo.selectMemberInfoCompanByID",personID);
		return companyInfoEntity;
		
	}

}

