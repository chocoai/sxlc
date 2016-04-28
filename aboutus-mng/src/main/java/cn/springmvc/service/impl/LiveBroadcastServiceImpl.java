

/** 
* @Title: LiveBroadcastServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:55:43 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.LiveBroadcastDao;
import cn.springmvc.dao.LiveBroadcastListDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.LiveBroadcastEntity;
import cn.springmvc.service.LiveBroadcastService;

/** 
 * @author 刘利 
 * @Description: 实时播报
 * @since 
 * @date 2016-4-12 下午7:55:43  */
@Service("liveBroadcastServiceImpl")
public class  LiveBroadcastServiceImpl implements LiveBroadcastService {
	@Resource(name="liveBroadcastListImpl")
    private LiveBroadcastListDao  liveBroadcastListDao;
	@Resource(name="liveBroadcastImpl")
    private LiveBroadcastDao  liveBroadcastDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<LiveBroadcastEntity> selectLiveBroadcast() {
		
		return liveBroadcastListDao.selectLiveBroadcast();
		
	}
	@Override
	public int insertLiveBroadcast(String content,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = liveBroadcastDao.insertLiveBroadcast(content);
		if(result == 1) {
			logentity.setsDetail("新增轮播公告 :"+content);
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return 0;
	}

}

