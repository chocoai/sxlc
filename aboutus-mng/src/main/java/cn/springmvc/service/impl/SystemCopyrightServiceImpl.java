package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
 
import cn.springmvc.dao.SystemCopyrightDao;
import cn.springmvc.dao.SystemCopyrightListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.service.SystemCopyrightService;
@Service("systemCopyrightServiceImpl")
public class SystemCopyrightServiceImpl implements SystemCopyrightService {
	@Resource(name="systemCopyrightDaoImpl")
	private SystemCopyrightDao systemCopyrightDao;  
	@Resource(name="systemCopyrightListDaoImpl")
	private SystemCopyrightListDao systemCopyrightListDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int insertSystemCopyright(String content,
			InsertAdminLogEntity logentity, String[] sIpInfo) {
		
		int result = 0;
		// 查询网站版权信息是否存在，不存在就新增，存在则修改
		int count = systemCopyrightListDao.selectSystemCopyrightIsExist();
		if(count == 0){
			result = systemCopyrightDao.insertSystemCopyright(content);
		}else {
			result = systemCopyrightDao.updateSystemCopyright(content);
		}
		if(result == 1) { 
			logentity.setsDetail("配置网站版权信息："+content);
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public String selectSystemCopyright() {
		 return systemCopyrightListDao.selectSystemCopyright();
	}

}
