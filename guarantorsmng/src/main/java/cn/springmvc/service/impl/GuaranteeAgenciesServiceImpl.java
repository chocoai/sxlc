

/** 
* @Title: GuaranteeAgenciesServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午5:26:12 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
 
import cn.springmvc.dao.GuaranteeAgenciesListDao;
import cn.springmvc.model.GuranteeRecordEntity;
import cn.springmvc.model.MemberTradingRecordsEntity;
import cn.springmvc.service.GuaranteeAgenciesService;

/** 
 * @author 刘利 
 * @Description: 担保项目
 * @since 
 * @date 2016-4-13 下午5:26:12  */
@Service("guaranteeAgenciesServiceImpl")
public class GuaranteeAgenciesServiceImpl implements GuaranteeAgenciesService {
	@Resource(name="guaranteeAgenciesListDaoImpl")
	private GuaranteeAgenciesListDao guaranteeAgenciesListDao;

	@Override
	public void getGuaranteeproject(PageEntity pageEntity) {
		
		List<GuranteeRecordEntity> list = guaranteeAgenciesListDao.getGuaranteeproject(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
	}

	@Override
	public void getCompensatoryrecord(PageEntity pageEntity) {
		
		List<GuranteeRecordEntity> list = guaranteeAgenciesListDao.getCompensatoryrecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}

	@Override
	public void getReceivablerecords(PageEntity pageEntity) {
		
		List<GuranteeRecordEntity> list = guaranteeAgenciesListDao.getReceivablerecords(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}

	@Override
	public void getTransaction(PageEntity pageEntity) {
		
		List<MemberTradingRecordsEntity> list = guaranteeAgenciesListDao.getTransaction(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
}

