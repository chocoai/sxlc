

/** 
* @Title: NewbieExperienceServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:18:31 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.invitemastermng.model.NewbieExperienceRecordsEntity;
import cn.invitemastermng.model.NewbieExperienceSetEntity;
import cn.springmvc.dao.NewbieExperienceDao;
import cn.springmvc.dao.NewbieExperienceListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.NewbieExperienceService;

/** 
 * @author 刘利 
 * @Description: 新手体验标
 * @since 
 * @date 2016-4-15 下午2:18:31  */
@Service("newbieExperienceServiceImpl")
public class NewbieExperienceServiceImpl implements NewbieExperienceService {
	@Resource(name="newbieExperienceListDaoImpl")
    private NewbieExperienceListDao newbieExperienceListDao;
	@Resource(name="newbieExperienceDaoImpl")
    private NewbieExperienceDao newbieExperienceDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public void getExperienceIncome(
			PageEntity page) {

		List<NewbieExperienceRecordsEntity> list = newbieExperienceListDao.getExperienceIncome(page);
		PageUtil.ObjectToPage(page, list);
	}
	@Override
	public int NewbieExperienceSet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = newbieExperienceDao.NewbieExperienceSet(map);
		if(result == 1) { 
			logentity.setsDetail("新手体验标设置");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }
		return newbieExperienceDao.NewbieExperienceSet(map); 
		
	}
	@Override
	public NewbieExperienceSetEntity getNewbieExperienceSet() {
		
		return newbieExperienceListDao.getNewbieExperienceSet();
		
	}
	@Override
	public NewbieExperienceSetEntity getNewbieExperienceSetIndex() {
		
		return newbieExperienceListDao.getNewbieExperienceSetIndex();
		
	}

}

