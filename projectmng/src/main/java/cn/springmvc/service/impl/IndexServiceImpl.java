

/** 
* @Title: IndexServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-8 上午11:08:03 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.IndexDao;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.IndexStaticsEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.service.IndexService;
import cn.springmvc.util.ProjectStatus;

/** 
 * @author 刘利 
 * @Description: 网站首页
 * @since 
 * @date 2016-4-8 上午11:08:03  */
@Service("indexServiceImpl")
public class IndexServiceImpl implements IndexService {
	@Resource(name="indexDaoImpl")
	private  IndexDao indexDao;
	@Override
	public IndexStaticsEntity selectIndexStatistic() {  
		
		return  indexDao.selectIndexStatistic(DbKeyUtil.GetDbCodeKey()); 
		 

	}
	@Override
	public List<ProjectAppRecordEntity> selectInvestListIndex() {
		
		//查询数据列表
		List<ProjectAppRecordEntity> list=indexDao.selectInvestListIndex();
		
		int status=-1; 
		for(ProjectAppRecordEntity project:list){
			//判断标的状态
			status=ProjectStatus.GetProjectStatus(project);
			if(status==1){
				//预发布标的格式化时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm");
				try {
					Date d=sdf.parse(project.getStartDate());
					String timeStr=sdf.format(d);
					project.setStartDate(timeStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			project.setInvestStatu(status);
		}
		
		return list;
		
	}
	@Override
	public List<InvestEntity> selectInvestRecordIndex(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return indexDao.selectInvestRecordIndex(map);
		
	}
	@Override
	public List<CreditorTransferListEntity> selectCreditorTransferListIndex() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		//查询债权数据
		List<CreditorTransferListEntity> list=indexDao.selectCreditorTransferListIndex(map);
		
		//判断状态
		int status=-1;
		for(CreditorTransferListEntity entity:list){
			status=ProjectStatus.GetCreditorTransferStatus(entity);
			entity.setTransStatu(status);
		}
		return list;
	}
}

