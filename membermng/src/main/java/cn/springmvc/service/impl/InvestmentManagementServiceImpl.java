

/** 
* @Title: InvestmentManagementServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午7:08:01 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil; 
import cn.membermng.model.CreditorTransEntity;
import cn.membermng.model.InvestIncomeEntity;
import cn.springmvc.dao.InvestmentManagementListDao;
import cn.springmvc.service.InvestmentManagementService;

/** 
 * @author 刘利 
 * @Description: 我的债权 
 * @since 
 * @date 2016-4-13 下午7:08:01  */
@Service("investmentManagementServiceImpl")
public class InvestmentManagementServiceImpl implements	InvestmentManagementService {
	@Resource(name="investmentManagementListDaoImpl")
    private InvestmentManagementListDao investmentManagementListDao;
	@Override
	public void getCreditorTransfer(PageEntity pageEntity) {

		List<CreditorTransEntity> list = investmentManagementListDao.getCreditorTransfer(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
	}

	@Override
	public void getCreditorOut(PageEntity pageEntity) {

		List<CreditorTransEntity> list = investmentManagementListDao.getCreditorOut(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);

	}

	@Override
	public void getCreditorIn(PageEntity pageEntity) {

		List<CreditorTransEntity> list = investmentManagementListDao.getCreditorIn(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);

	}

	@Override
	public void getInvest(PageEntity pageEntity) {

		List<InvestIncomeEntity> list = investmentManagementListDao.getInvest(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);

	}

	@Override
	public void getCreditorOff(PageEntity pageEntity) {

		List<CreditorTransEntity> list = investmentManagementListDao.getCreditorOff(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 

	}

	@Override
	public void getCreditorTransferBack(PageEntity pageEntity) {
		
		List<CreditorTransEntity> list = investmentManagementListDao.getCreditorTransferBack(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		
	}

}

