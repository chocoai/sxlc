

/** 
* @Title: MemberStationDaoImpl.java 
* @Package cn.memberstation.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 下午2:42:29 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 

import cn.membermng.model.MemberStationLetterEntity;
import cn.springmvc.dao.MemberStationDao;

/** 
 * @author 刘利 
 * @Description: 会员站内信
 * @since 
 * @date 2016-3-29 下午2:42:29  */
@Repository("memberStationDaoImpl")
public class MemberStationDaoImpl extends SqlSessionDaoSupport  implements MemberStationDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int deleteSendStationLetter(List<Integer> list) {
		
		return getSqlSession().update("memberStationLetter.deleteSendStationLetter", list);
		
	}

	@Override
	public int deleteRecStationLetter(List<Integer> list) {
		
		return getSqlSession().update("memberStationLetter.deleteRecStationLetter", list);
		
	}

	@Override
	public int updateRecStationReadlist(List<Integer> list) {
		
		return getSqlSession().update("memberStationLetter.updateRecStationReadlist", list);
		
	}

	@Override
	public int updateRecStationNotReadlist(List<Integer> list) {
		
		return getSqlSession().update("memberStationLetter.updateRecStationNotReadlist", list);
		
	}

	@Override
	public int addStationLetter(
			MemberStationLetterEntity memberStationLetterEntity) {
		
		return getSqlSession().insert("memberStationLetter.addStationLetter", memberStationLetterEntity);
		
	}

	@Override
	public int updateRecStationRead(int letterID) {
		
		return getSqlSession().update("memberStationLetter.updateRecStationRead", letterID);
		
	}
}

