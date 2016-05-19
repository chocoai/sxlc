package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
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
		List<MyinvestEntity> list = myinvestListDaoImpl.selectMyinvestCollect(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvestSettled(PageEntity pageEntity) {
		List<MyinvestEntity> list = myinvestListDaoImpl.selectMyinvestSettled(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}

	@Override
	public List<MyinvestEntity> selectMyinvesting(PageEntity pageEntity) {
		List<MyinvestEntity> list = myinvestListDaoImpl.selectMyinvesting(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}

	@Override
	public List<InvestIncomeEntity> selectRealincome(PageEntity pageEntity) {
		List<InvestIncomeEntity> list = myinvestListDaoImpl.selectRealincome(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}

	@Override
	public List<InvestIncomeEntity> selectInvestIncome(PageEntity pageEntity) {
		List<InvestIncomeEntity> list = myinvestListDaoImpl.selectInvestIncome(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}
 
}

