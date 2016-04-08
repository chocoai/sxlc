package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.MediaReportsDao;
import cn.springmvc.dao.MediaReportsListDao;
import cn.springmvc.dao.impl.FriendshipLinkDaoImpl;
import cn.springmvc.dao.impl.FriendshipLinkListDaoImpl;
import cn.springmvc.dao.impl.MediaReportsDaoImpl;
import cn.springmvc.dao.impl.MediaReportsListDaoImpl;
import cn.springmvc.model.FriendshipUnitEntity;
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
		return mediaReportsDaoImpl.insertMediaReports(entity); 
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
		
		List<MediaReportsEntity> mediaReportsList = null;    
	 	mediaReportsList = mediaReportsListDaoImpl.selectMediaReportsAllpage(pageEntity);  
		return mediaReportsList; 
	}

	
	/* *  *  * @param id
	/* *  *  * @return * @see cn.springmvc.service.MediaReportsService#selectMediaReportsByID(int) */
	
	@Override
	public MediaReportsEntity selectMediaReportsByID(int id) {
		
		MediaReportsEntity mediaReportsEntity = mediaReportsListDaoImpl.selectMediaReportsByID(id);
		return mediaReportsEntity;
		
	}

}
