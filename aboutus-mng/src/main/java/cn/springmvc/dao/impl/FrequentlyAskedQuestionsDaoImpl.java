package cn.springmvc.dao.impl;
 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.FrequentlyAskedQuestionsDao; 
import cn.springmvc.model.FrequentlyAskedQuestionsEntity; 
/**
 * 
* @author 刘利 
* @Description: 常见问题增加，删除，修改功能
* @since 
* @date 2016-3-19 下午8:00:49
 */
@Repository("frequentlyAskedQuestionsDaoImpl")
public class FrequentlyAskedQuestionsDaoImpl extends SqlSessionDaoSupport implements FrequentlyAskedQuestionsDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertFrequentlyAskedQuestions(
			FrequentlyAskedQuestionsEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("frequentlyAskedQuestions.insertFrequentlyAskedQuestions", entity);
		return iResult;
	}

	@Override
	public int updateFrequentlyAskedQuestionsByID(
			FrequentlyAskedQuestionsEntity entity) {
		
		int result=0;
		if(entity == null) {
			return result;
		}
		result=getSqlSession().update("frequentlyAskedQuestions.updateFrequentlyAskedQuestionsByID", entity);
		return result;
	}

	@Override
	public int deleteFrequentlyAskedQuestionsByID(int id) {
		
		int result = 0;
		result=getSqlSession().delete("frequentlyAskedQuestions.deleteFrequentlyAskedQuestionsByID", id);
		return result;
	}

	@Override
	public int updateFrequentlyAskedQuestionsStatuByID(
			FrequentlyAskedQuestionsEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		int result = 0;
		result = getSqlSession().update("frequentlyAskedQuestions.updateFrequentlyAskedQuestionsStatuByID", entity);
		return result;
	}
	  
}
