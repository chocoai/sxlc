package cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.ProcessProjectDao;
import cn.springmvc.dao.ProcessProjectListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.service.ProcessProjectService; 
 /**
  * 
 * @author 刘利 
 * @Description: 项目审批流程 
 * @since 
 * @date 2016-3-19 下午5:15:15
  */
@Service("processProjectServiceImpl")
public class ProcessProjectServiceImpl implements ProcessProjectService {
	@Resource(name="processProjectListDaoImpl")
	private ProcessProjectListDao processProjectListDaoImpl;  
	@Resource(name="processProjectDaoImpl")
	private ProcessProjectDao processProjectDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertProcessProject(ProcessProjectEntity entity,InsertAdminLogEntity 
			entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		}   
		
		//查询项目审批活动点是否有效 
		int result = processProjectListDaoImpl.selectActivitiesProjectStatu(entity.getApID());
		if(result == 0) {
			return -1; 
		} 
		//查询项目审批流程序号 
		int indexs = processProjectListDaoImpl.selectProcessProjectindex();
		 
		entity.setIndexs(indexs+1); 
		 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId((int)id);
		result = processProjectDaoImpl.insertProcessProject(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		} 
		if(result == 1) { 
			entityLog.setsDetail("添加审批流程");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteProcessProjectByID(int id,
			InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		int result=processProjectDaoImpl.deleteProcessProjectByID(id); 
		if(result == 1) { 
			entityLog.setsDetail("删除审批流程");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	} 
	@Override
	public int updateProcessProjectStatuByID(ProcessProjectEntity entity,
			InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		int result=processProjectDaoImpl.updateProcessProjectStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			entityLog.setsDetail("启用审批流程 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			entityLog.setsDetail("停用审批流程 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public List<ProcessProjectEntity> selectProcessProjectListpage(PageEntity pageEntity) {
		
		List<ProcessProjectEntity> list=  processProjectListDaoImpl.selectProcessProjectAllpage(pageEntity);    
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public int moveAndDownProcessProjectByID(Map<String, Object> map,InsertAdminLogEntity 
			entityLog, String[] sIpInfo) {
		
		if(map == null) {
			return -1;
		}
		
		if(map.get("flag") == null) {
			return -1;
		} 
		
		//type 大于0上移,小于0下移
		int type = IntegerAndString.StringToInt(map.get("flag").toString(), 0);
		 
		int result=processProjectDaoImpl.moveAndDownProcessProjectByID(map);
		if(result == 1 && type > 0) {
			entityLog.setsDetail("上移审批流程 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}else if(result == 1 && type < 0){
			entityLog.setsDetail("下移审批流程 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public ProcessProjectEntity selectProcessProjectbyid(int id) {
		
		return  processProjectListDaoImpl.selectProcessProjectbyid(id); 
	}

	@Override
	public List<ProcessProjectEntity> selectProcessProjectList() {
		
		return  processProjectListDaoImpl.selectProcessProjectList(); 
		
	}

}
