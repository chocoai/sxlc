package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.LawsRegulationsDao;
import cn.springmvc.dao.LawsRegulationsListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.LawsRegulationsDaoImpl;
import cn.springmvc.dao.impl.LawsRegulationsListDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.LawsRegulationsEntity;
import cn.springmvc.service.LawsRegulationsService;
@Service("lawsRegulationsServiceImpl")
public class LawsRegulationsServiceImpl implements LawsRegulationsService {
	@Resource(name="lawsRegulationsDaoImpl")
	private LawsRegulationsDao lawsRegulationsDaoImpl;  
	@Resource(name="lawsRegulationsListDaoImpl")
	private LawsRegulationsListDao lawsRegulationsListDaoImpl;  
	@Override
	public int insertLawsRegulations(LawsRegulationsEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询法律法规是否存在，不存在就新增，存在则修改
		int count = lawsRegulationsListDaoImpl.selectLawsRegulationsIsExist();
		if(count == 0) {
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			int result = lawsRegulationsDaoImpl.insertLawsRegulations(entity); 
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
			}
			return result; 
		}else{
			return lawsRegulationsDaoImpl.updateLawsRegulationsByID(entity); 
		} 
		
	}

	@Override
	public int deleteLawsRegulations(int id) {
		
		int result=lawsRegulationsDaoImpl.deleteLawsRegulationsByID(id); 
		return result;
	}
 

	@Override
	public int updateLawsRegulationsStatuByID(LawsRegulationsEntity entity) {
		
		int result = lawsRegulationsDaoImpl.updateLawsRegulationsStatuByID(entity); 
		return result;
	}

	@Override
	public LawsRegulationsEntity selectLawsRegulationsList(int statu) {
		
		LawsRegulationsEntity lawsRegulationsEntity = lawsRegulationsListDaoImpl.selectLawsRegulations(statu);
		return lawsRegulationsEntity;
	}

}
