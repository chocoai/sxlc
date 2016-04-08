package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.ExpertTeamDao;
import cn.springmvc.dao.ExpertTeamListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.ExpertTeamEntity;  
import cn.springmvc.service.ExpertTeamService;
/**
 * 
* @author 刘利 
* @Description: 实现专家顾问的增删改查功能
* @since 
* @date 2016-3-19 下午7:32:30
 */
@Service("expertTeamServiceImpl")
public class ExpertTeamServiceImpl implements ExpertTeamService {
	@Resource(name="expertTeamDaoImpl")
	private ExpertTeamDao expertTeamDaoImpl;  
	@Resource(name="expertTeamListDaoImpl")
	private ExpertTeamListDao expertTeamListDaoImpl;  
	@Override
	public int insertExpertTeam(ExpertTeamEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的专家顾问是否存在,如果已存在则不插入  
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamIsExistByNAme(entity);
		if(expertTeamEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		entity.setId(id);
		
        int result = expertTeamDaoImpl.insertExpertTeam(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result; 
	} 
	@Override
	public int deleteExpertTeamByID(int id) {
		
		int result = expertTeamDaoImpl.deleteExpertTeamByID(id); 
		return result;
	}

	@Override
	public int updateExpertTeamByID(ExpertTeamEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的专家顾问是否存在,如果已存在则修改
		ExpertTeamEntity expertTeamEntity = expertTeamListDaoImpl.selectExpertTeamIsExistByNAme(entity);
		if(expertTeamEntity != null){
			return -1;
		} 
		int result = expertTeamDaoImpl.updateExpertTeamByID(entity);
		
		return result;
	}

	@Override
	public int updateExpertTeamStatuByID(ExpertTeamEntity entity) {
		
		int result = expertTeamDaoImpl.updateExpertTeamStatuByID(entity); 
		return result;
	}

	@Override
	public List<ExpertTeamEntity> selectExpertTeamListpage(PageEntity pageEntity) {
		
		List<ExpertTeamEntity> expertTeamList = null;    
	 	expertTeamList = expertTeamListDaoImpl.selectExpertTeamAllpage(pageEntity);  
		return expertTeamList; 
	}
	 
	@Override
	public ExpertTeamEntity selectExpertTeamByID(int id) {
		
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamByID(id);
		return expertTeamEntity;
		
	}
	@Override
	public List<ExpertTeamEntity> selectExpertTeamfront() {
		
		return expertTeamListDaoImpl.selectExpertTeamfront();
		
	}

}
