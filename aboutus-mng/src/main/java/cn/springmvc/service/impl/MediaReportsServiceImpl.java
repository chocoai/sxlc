package cn.springmvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.MediaReportsDao;
import cn.springmvc.dao.MediaReportsListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.service.MediaReportsService;
@Service("mediaReportsServiceImpl")
public class MediaReportsServiceImpl implements MediaReportsService {
	@Resource(name="mediaReportsDaoImpl")
	private MediaReportsDao mediaReportsDaoImpl;  
	@Resource(name="mediaReportsListDaoImpl")
	private MediaReportsListDao mediaReportsListDaoImpl; 
	@Override
	public int insertMediaReports(MediaReportsEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsIsExistByNAme(entity);
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
		}
		return result;
	}

	@Override
	public int deleteMediaReportsByID(int id) {
		
		int result = mediaReportsDaoImpl.deleteMediaReportsByID(id); 
		return result;
	}

	@Override
	public int updateMediaReportsByID(MediaReportsEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsIsExistByNAme(entity);
		if(mediaReportsEntity != null){
			return -1;
		} 
		int result = mediaReportsDaoImpl.updateMediaReportsByID(entity); 
		return result;
	}

	@Override
	public int updateMediaReportsStatuByID(MediaReportsEntity entity) {
		
		int result = mediaReportsDaoImpl.updateMediaReportsStatuByID(entity); 
		return result;
	}

	@Override
	public List<MediaReportsEntity> selectMediaReportsListpage(
			PageEntity pageEntity) {
		List<MediaReportsEntity> list  = mediaReportsListDaoImpl.selectMediaReportsAllpage(pageEntity);  
	 	PageUtil.ObjectToPage(pageEntity, list);
		return list; 
	}

	
	/* *  *  * @param id
	/* *  *  * @return * @see cn.springmvc.service.MediaReportsService#selectMediaReportsByID(int) */
	
	@Override
	public MediaReportsEntity selectMediaReportsByID(int id) {
		
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsByID(id);
		return mediaReportsEntity;
		
	}

}
