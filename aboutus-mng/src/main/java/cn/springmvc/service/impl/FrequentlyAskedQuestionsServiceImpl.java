package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.FrequentlyAskedQuestionsDao;
import cn.springmvc.dao.FrequentlyAskedQuestionsListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.FrequentlyAskedQuestionsDaoImpl;
import cn.springmvc.dao.impl.FrequentlyAskedQuestionsListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
import cn.springmvc.service.FrequentlyAskedQuestionsService;
@Service("frequentlyAskedQuestionsServiceImpl")
public class FrequentlyAskedQuestionsServiceImpl implements FrequentlyAskedQuestionsService {
	@Resource(name="frequentlyAskedQuestionsDaoImpl")
	private FrequentlyAskedQuestionsDao frequentlyAskedQuestionsDaoImpl;  
	@Resource(name="frequentlyAskedQuestionsListDaoImpl")
	private FrequentlyAskedQuestionsListDao frequentlyAskedQuestionsListDaoImpl;  
	@Override
	public int insertFrequentlyAskedQuestions(FrequentlyAskedQuestionsEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询常见问题是否存在，不存在就新增，存在则修改
		int count = frequentlyAskedQuestionsListDaoImpl.selectFrequentlyAskedQuestionsIsExist();
		if(count == 0) {
			
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			int result = frequentlyAskedQuestionsDaoImpl.insertFrequentlyAskedQuestions(entity); 
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
			}
			return result;
		}else{
			return frequentlyAskedQuestionsDaoImpl.updateFrequentlyAskedQuestionsByID(entity); 
		} 
		
	}

	@Override
	public int deleteFrequentlyAskedQuestions(int id) {
		
		int result=frequentlyAskedQuestionsDaoImpl.deleteFrequentlyAskedQuestionsByID(id); 
		return result;
	}
 

	@Override
	public int updateFrequentlyAskedQuestionsStatuByID(FrequentlyAskedQuestionsEntity entity) {
		
		int result = frequentlyAskedQuestionsDaoImpl.updateFrequentlyAskedQuestionsStatuByID(entity); 
		return result;
	}

	@Override
	public FrequentlyAskedQuestionsEntity selectFrequentlyAskedQuestionsList(int statu) {
		
		FrequentlyAskedQuestionsEntity productIntroduceEntity = frequentlyAskedQuestionsListDaoImpl.selectFrequentlyAskedQuestions(statu);
		return productIntroduceEntity;
	}

}
