

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
import cn.membermng.model.InvestEntity;
import cn.membermng.model.ProjectAppRecordEntity;
import cn.springmvc.dao.MyBorrowAndInvestListDao; 
import cn.springmvc.service.MyBorrowAndInvestService;

/** 
 * @author 刘利 
 * @Description: 借款管理
 * @since 
 * @date 2016-4-13 下午2:12:54  */
@Service("myBorrowAndInvestServiceImpl")
public class MyBorrowAndInvestServiceImpl implements
		MyBorrowAndInvestService {
	@Resource(name="myBorrowAndInvestListDaoImpl")
	private MyBorrowAndInvestListDao myBorrowAndInvestListDao;
	 
	@Override
	public void getBorrowing(PageEntity pageEntity) {
		
		List<ProjectAppRecordEntity>  list = myBorrowAndInvestListDao.getBorrowing(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
	@Override
	public void getInvestmentProject(PageEntity pageEntity) {
		
		List<InvestEntity>  list = myBorrowAndInvestListDao.getInvestmentProject(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}
 
}

