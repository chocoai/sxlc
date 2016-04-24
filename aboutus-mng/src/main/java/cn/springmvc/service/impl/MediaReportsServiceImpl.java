package cn.springmvc.service.impl;
 
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
 
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.MediaReportsDao;

import cn.springmvc.dao.MediaReportsListDao;  
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;

import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.service.MediaReportsService;
@Service("mediaReportsServiceImpl")
public class MediaReportsServiceImpl implements MediaReportsService {
	@Resource(name="mediaReportsDaoImpl")
	private MediaReportsDao mediaReportsDaoImpl;  
	@Resource(name="mediaReportsListDaoImpl")
	private MediaReportsListDao mediaReportsListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertMediaReports(MediaReportsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.
				selectMediaReportsIsExistByNAme(entity);
		if(mediaReportsEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result = mediaReportsDaoImpl.insertMediaReports(entity); 
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加媒体报道 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteMediaReportsByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsByID(id);
		int result = mediaReportsDaoImpl.deleteMediaReportsByID(id); 
		if(result == 1) {
			logentity.setsDetail("删除媒体报道 :"+mediaReportsEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMediaReportsByID(MediaReportsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsIsExistByNAme(entity);
		if(mediaReportsEntity != null){
			return -1;
		} 
		int result = mediaReportsDaoImpl.updateMediaReportsByID(entity); 
		if(result == 1) {
			logentity.setsDetail("修改媒体报道 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMediaReportsStatuByID(MediaReportsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsByID(entity.getId());
		int result = mediaReportsDaoImpl.updateMediaReportsStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用媒体报道 :"+mediaReportsEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用媒体报道 :"+mediaReportsEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<MediaReportsEntity> selectMediaReportsListpage(
			PageEntity pageEntity) {
		List<MediaReportsEntity> list  = mediaReportsListDaoImpl.selectMediaReportsAllpage(pageEntity);  
	 	PageUtil.ObjectToPage(pageEntity, list);
		return list; 
	}

	@Override
	public MediaReportsEntity selectMediaReportsByID(long id) {
		
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsByID(id);
		return mediaReportsEntity;
		
	}

	@Override
	public List<MediaReportsEntity> selectMediaReportsListIndex() {
		
		return  mediaReportsListDaoImpl.selectMediaReportsListIndex();
		
	}

}
