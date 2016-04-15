

/** 
* @Title: BorrowingManagementServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午2:12:54 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.BorrowingManagementListDao;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.service.BorrowingManagementService;

/** 
 * @author 刘利 
 * @Description: 借款管理
 * @since 
 * @date 2016-4-13 下午2:12:54  */
@Service("borrowingManagementServiceImpl")
public class BorrowingManagementServiceImpl implements
		BorrowingManagementService {
	@Resource(name="borrowingManagementListDaoImpl")
	private BorrowingManagementListDao borrowingManagementListDao;
	@Override
	public void getApplyFailure(PageEntity entity) {

		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getApplyFailure(entity);
		PageUtil.ObjectToPage(entity, list);
	}
	@Override
	public void getInReview(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getInReview(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void getNotRelease(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getNotRelease(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void getInvestment(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getInvestment(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void getForLending(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getForLending(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void getInvestFailure(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getInvestFailure(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}
	@Override
	public void getInPayment(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getInPayment(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
	@Override
	public void getSettlementOff(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getSettlementOff(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
	@Override
	public void getBorrowing(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = borrowingManagementListDao.getBorrowing(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
	@Override
	public void getInvestmentProject(PageEntity pageEntity) {
		
		List<InvestEntity>  list = borrowingManagementListDao.getInvestmentProject(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
	@Override
	public void getInvestmentRecord(PageEntity pageEntity) {
		
		List<InvestEntity>  list = borrowingManagementListDao.getInvestmentRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}

}

