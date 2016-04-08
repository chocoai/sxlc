package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo; 

import cn.springmvc.dao.MngTeamDao;
import cn.springmvc.dao.MngTeamListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MngTeamDaoImpl;
import cn.springmvc.dao.impl.MngTeamListDaoImpl;
import cn.springmvc.model.MngTeamEntity; 
import cn.springmvc.service.MngTeamService;
@Service("mngTeamServiceImpl")
public class MngTeamServiceImpl implements MngTeamService {
	@Resource(name="mngTeamDaoImpl")
	private MngTeamDao mngTeamDaoImpl;  
	@Resource(name="mngTeamListDaoImpl")
	private MngTeamListDao mngTeamListDaoImpl;  
	@Override
	public int insertMngTeam(MngTeamEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的媒体报道是否存在,如果已存在则不插入  
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = mngTeamDaoImpl.insertMngTeam(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result;  
	}

	@Override
	public int deleteMngTeamByID(int id) {
		
		int result = mngTeamDaoImpl.deleteMngTeamByID(id); 
		return result;
	}

	@Override
	public int updateMngTeamByID(MngTeamEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的媒体报道是否存在,如果已存在则不插入  
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		int result=mngTeamDaoImpl.updateMngTeamByID(entity); 
		return result;
	}

	@Override
	public int updateMngTeamStatuByID(MngTeamEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		int result = mngTeamDaoImpl.updateMngTeamStatuByID(entity); 
		return result;
	}

	@Override
	public List<MngTeamEntity> selectMngTeamListpage(PageEntity pageEntity) {
		
		List<MngTeamEntity> mngTeamList = null;    
	 	mngTeamList = mngTeamListDaoImpl.selectMngTeamAllpage(pageEntity);   
		return mngTeamList; 
	}
 
	
	@Override
	public MngTeamEntity selectMngTeamByID(int id) {
		
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamByID(id);
		return mngTeamEntity;
	}

}
