package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.RecruitmentDao;
import cn.springmvc.dao.RecruitmentListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.RecruitmentDaoImpl;
import cn.springmvc.dao.impl.RecruitmentListDaoImpl;
import cn.springmvc.dao.impl.RecruitmentDaoImpl;
import cn.springmvc.dao.impl.RecruitmentListDaoImpl; 
import cn.springmvc.model.RecruitmentEntity;
import cn.springmvc.service.RecruitmentListService;
@Service("recruitmentServiceImpl")
public class RecruitmentServiceImpl implements RecruitmentListService {
	@Resource(name="recruitmentDaoImpl")
	private RecruitmentDao recruitmentDaoImpl; 
	@Resource(name="recruitmentListDaoImpl")
	private RecruitmentListDao recruitmentListDaoImpl; 
	@Override
	public int insertRecruitments(RecruitmentEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		//查询该职位是否存在 
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.selectRecruitmentIsExistByNAme(entity);
		if(recruitmentEntity != null) {
			return -1;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result =  recruitmentDaoImpl.insertRecruitment(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result; 
	}

	@Override
	public int deleteRecruitments(int id) {
		
		int result = recruitmentDaoImpl.deleteRecruitmentByID(id);
		return result;
	}

	@Override
	public int updateRecruitments(RecruitmentEntity entity) {
		
		//查询该职位是否存在 
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.selectRecruitmentIsExistByNAme(entity);
		if(recruitmentEntity != null) {
			return -1;
		}
		int result = recruitmentDaoImpl.updateRecruitmentByID(entity);
		return result;
	}

	@Override
	public int updateRecruitmentStatuByID(RecruitmentEntity entity) {
		int result = recruitmentDaoImpl.updateRecruitmentStatuByID(entity);
		return result;
	}

	@Override
	public List<RecruitmentEntity> selectRecruitmentsList(PageEntity pageEntity) {
		List<RecruitmentEntity> recruitmentList = null;    
		recruitmentList = recruitmentListDaoImpl.selectRecruitmentList(pageEntity);    
		return recruitmentList; 
	}
 
	@Override
	public RecruitmentEntity selectRecruitmentByID(int id) {
		
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.selectRecruitmentByID(id);
		return recruitmentEntity;
		
	}

}
