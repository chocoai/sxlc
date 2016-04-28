package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.FrequentlyAskedQuestionsDao;
import cn.springmvc.dao.FrequentlyAskedQuestionsListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
import cn.springmvc.service.FrequentlyAskedQuestionsService;
@Service("frequentlyAskedQuestionsServiceImpl")
public class FrequentlyAskedQuestionsServiceImpl implements FrequentlyAskedQuestionsService {
	@Resource(name="frequentlyAskedQuestionsDaoImpl")
	private FrequentlyAskedQuestionsDao frequentlyAskedQuestionsDaoImpl;  
	@Resource(name="frequentlyAskedQuestionsListDaoImpl")
	private FrequentlyAskedQuestionsListDao frequentlyAskedQuestionsListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertFrequentlyAskedQuestions(FrequentlyAskedQuestionsEntity entity,
			InsertAdminLogEntity  logentity,String[] sIpInfo) {
		
		int result = 0;
		if(entity == null) {
			return -1;
		} 
		// 查询常见问题是否存在，不存在就新增，存在则修改
		int count = frequentlyAskedQuestionsListDaoImpl.selectFrequentlyAskedQuestionsIsExist();
		if(count == 0) {
			
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			result = frequentlyAskedQuestionsDaoImpl.insertFrequentlyAskedQuestions(entity); 
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
				logentity.setsDetail("添加常见问题 ");
			    optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
			
		}else{
			result = frequentlyAskedQuestionsDaoImpl.updateFrequentlyAskedQuestionsByID(entity); 
			if(result == 1) {
			    logentity.setsDetail("修改常见问题");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
		} 
		return result;
	}

	@Override
	public int deleteFrequentlyAskedQuestions(long id,InsertAdminLogEntity  
			logentity,String[] sIpInfo) {
		
		int result=frequentlyAskedQuestionsDaoImpl.deleteFrequentlyAskedQuestionsByID(id);
		if(result == 1) {
		    logentity.setsDetail("删除常见问题 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 

	@Override
	public int updateFrequentlyAskedQuestionsStatuByID(FrequentlyAskedQuestionsEntity entity, 
			InsertAdminLogEntity  logentity,String[] sIpInfo) {
		
		int result = frequentlyAskedQuestionsDaoImpl.updateFrequentlyAskedQuestionsStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用常见问题 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用常见问题 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public FrequentlyAskedQuestionsEntity selectFrequentlyAskedQuestionsList() {
		
		FrequentlyAskedQuestionsEntity productIntroduceEntity = frequentlyAskedQuestionsListDaoImpl.selectFrequentlyAskedQuestions();
		return productIntroduceEntity;
	}

}
