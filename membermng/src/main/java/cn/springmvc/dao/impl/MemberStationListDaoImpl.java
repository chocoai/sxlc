

/** 
* @Title: MemberStationListDaoImpl.java 
* @Package cn.memberstation.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午4:44:15 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.membermng.model.MemberStationLetterEntity;
import cn.springmvc.dao.MemberStationListDao;

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 会员站内信
 * @since 
 * @date 2016-3-29 下午4:44:15  */
@Repository("memberStationListDaoImpl")
public class MemberStationListDaoImpl extends SqlSessionDaoSupport implements MemberStationListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<MemberStationLetterEntity> selectSendLetter(PageEntity pageEntity) {
		
		return getSqlSession().selectList("memberStationLetter.selectSendLetter",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<MemberStationLetterEntity> selectRecLetter(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("memberStationLetter.selectRecLetter",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public MemberStationLetterEntity selectSendLetterDetail(Map<String,Object> map) {
		
		return getSqlSession().selectOne("memberStationLetter.selectSendLetterDetail",map);
		
	}

	@Override
	public MemberStationLetterEntity selectRecLetterDetail(Map<String,Object> map) {
		
		return getSqlSession().selectOne("memberStationLetter.selectRecLetterDetail",map);
		
	}

	@Override
	public long selectMemberID(String logname) {
		
		Long memberID = getSqlSession().selectOne("memberStationLetter.selectMemberID",logname);
		if(memberID == null) {
			memberID = (long) 0;
		}
		return memberID;
	}

}

