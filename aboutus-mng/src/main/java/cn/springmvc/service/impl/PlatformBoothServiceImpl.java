

/** 
* @Title: PlatformBoothServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:36:39 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.PlatformBoothDao;
import cn.springmvc.dao.PlatformBoothListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.PlatformBoothEntity;
import cn.springmvc.service.PlatformBoothService;

/** 
 * @author 刘利 
 * @Description: 平台四大宣传点
 * @since 
 * @date 2016-4-12 下午7:36:39  */
@Service("platformBoothServiceImpl")
public class PlatformBoothServiceImpl implements PlatformBoothService {
	@Resource(name="platformBoothListDaoImpl")
	private PlatformBoothListDao platformBoothListDao;
	@Resource(name="platformBoothDaoImpl")
	private PlatformBoothDao platformBoothDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public List<PlatformBoothEntity> selectPlatformBooth() {

		return platformBoothListDao.selectPlatformBooth();

	}

	@Override
	public int insertPlatformBooth(PlatformBoothEntity entity,
			InsertAdminLogEntity logentity, String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的平台宣传点是否存在,如果已存在则不插入  
		int result = platformBoothListDao.
				selectPlatformBoothIsExistByTitle(entity);
		
		if(result != 0){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		entity.setSgID(id);
		
        result = platformBoothDao.insertPlatformBooth(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加平台宣传点 :"+entity.getAsTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
		
	}

	@Override
	public int deletePlatformBoothByID(long id, InsertAdminLogEntity logentity,
			String[] sIpInfo) {
		
		PlatformBoothEntity platformBoothEntity= platformBoothListDao.selectPlatformBoothByID(id);
		int result = platformBoothDao.deletePlatformBoothByID(id); 
		if(result == 1) {
			logentity.setsDetail("删除平台宣传点 :"+platformBoothEntity.getAsTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
		
	}

	@Override
	public int updatePlatformBoothByID(PlatformBoothEntity entity,
			InsertAdminLogEntity logentity, String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的平台宣传点是否存在,如果已存在则不插入  
		int result = platformBoothListDao.
				selectPlatformBoothIsExistByTitle(entity);
		result = platformBoothDao.updatePlatformBoothByID(entity);
		if(result == 1) {
			logentity.setsDetail("修改平台宣传点 :"+entity.getAsTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
		
	}

	@Override
	public void selectPlatformBoothList(PageEntity pageEntity) {
		
		List<PlatformBoothEntity> platformBoothList = platformBoothListDao.
				selectPlatformBoothList(pageEntity);   
		PageUtil.ObjectToPage(pageEntity, platformBoothList);
	}

	@Override
	public PlatformBoothEntity selectPlatformBoothByID(long id) {
		
		return platformBoothListDao.selectPlatformBoothByID(id);
		
	}

	@Override
	public int updatePlatformBoothStatu(int statu, long sgID,
			InsertAdminLogEntity logentity, String[] sIpInfo) {
		
		PlatformBoothEntity platformBoothEntity= platformBoothListDao
				.selectPlatformBoothByID(sgID);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statu", statu);
		map.put("sgID", sgID);
		int result = platformBoothDao.updatePlatformBoothStatu(map);
		if(result == 1 && statu == 1) {
			logentity.setsDetail("启用平台宣传点 :"+platformBoothEntity.getAsTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && statu == 0){
			logentity.setsDetail("停用平台宣传点 :"+platformBoothEntity.getAsTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

}

