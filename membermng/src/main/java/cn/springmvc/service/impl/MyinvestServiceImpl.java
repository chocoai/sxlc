package cn.springmvc.service.impl;
 
import java.util.List; 
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import product_p2p.kit.pageselect.PageEntity; 
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MyinvestEntity;
import cn.springmvc.dao.MyinvestListDao;
import cn.springmvc.service.MyinvestService;

/** 
 * @author 刘利 
 * @Description: 个人中心-我的投资
 * @since 
 * @date 2016-3-31 下午2:16:18
 */
@Service("myinvestServiceImpl")
public class MyinvestServiceImpl implements MyinvestService{
	
	@Resource(name="myinvestListDaoImpl")
	private MyinvestListDao myinvestListDaoImpl;

	@Override
	public List<MyinvestEntity> selectMyinvestCollect(PageEntity pageEntity) {
		
		return myinvestListDaoImpl.selectMyinvestCollect(pageEntity);
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvestSettled(PageEntity pageEntity) {
		
		return myinvestListDaoImpl.selectMyinvestSettled(pageEntity);
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvesting(PageEntity pageEntity) {
		
		return myinvestListDaoImpl.selectMyinvesting(pageEntity);
		
	}

	@Override
	public List<InvestIncomeEntity> selectRealincome(PageEntity pageEntity) {
		
		return myinvestListDaoImpl.selectRealincome(pageEntity);
		
	}

	@Override
	public List<InvestIncomeEntity> selectInvestIncome(PageEntity pageEntity) {
		
		return myinvestListDaoImpl.selectInvestIncome(pageEntity);
		
	}
 
}

