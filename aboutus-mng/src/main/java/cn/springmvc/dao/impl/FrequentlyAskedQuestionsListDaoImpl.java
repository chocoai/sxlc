package cn.springmvc.dao.impl; 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.FrequentlyAskedQuestionsListDao; 
import cn.springmvc.model.FrequentlyAskedQuestionsEntity; 
/**
 * 
* @author 刘利 
* @Description: 常见问题的查询类
* @since 
* @date 2016-3-19 下午8:02:30
 */
@Repository("frequentlyAskedQuestionsListDaoImpl")
public class FrequentlyAskedQuestionsListDaoImpl  extends SqlSessionDaoSupport  implements FrequentlyAskedQuestionsListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public FrequentlyAskedQuestionsEntity selectFrequentlyAskedQuestions() {
		
		return  getSqlSession().selectOne("frequentlyAskedQuestions.selectFrequentlyAskedQuestions"); 
	}

	@Override
	public int selectFrequentlyAskedQuestionsIsExist() {
		
		int result = 0;
		result = getSqlSession().selectOne("frequentlyAskedQuestions.selectFrequentlyAskedQuestionsIsExist");
		return result;
	}


}
