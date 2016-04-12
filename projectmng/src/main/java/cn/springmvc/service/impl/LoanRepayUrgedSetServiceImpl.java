package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.LoanRepayUrgedSetDao;
import cn.springmvc.dao.LoanRepayUrgedSetListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.LoanRepayUrgedSetDaoImpl;
import cn.springmvc.dao.impl.LoanRepayUrgedSetListDaoImpl;
import cn.springmvc.model.LoanRepayUrgedSetEntity; 
import cn.springmvc.service.LoanRepayUrgedSetService;
@Service("loanRepayUrgedSetServiceImpl")
public class LoanRepayUrgedSetServiceImpl implements LoanRepayUrgedSetService {
	@Resource(name="loanRepayUrgedSetDaoImpl")
	private LoanRepayUrgedSetDao loanRepayUrgedSetDaoImpl;  
	@Resource(name="loanRepayUrgedSetListDaoImpl")
	private LoanRepayUrgedSetListDao loanRepayUrgedSetListDaoImpl;  
	@Override
	public int insertLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询催收账单配置是否存在，不存在就新增，存在则修改
		int count = loanRepayUrgedSetListDaoImpl.selectLoanRepayUrgedSetIsExist();
		if(count == 0){ 
			return loanRepayUrgedSetDaoImpl.insertLoanRepayUrgedSet(entity); 
		}else{
			return loanRepayUrgedSetDaoImpl.updateLoanRepayUrgedSet(entity); 
		} 
		
	}

	@Override
	public int deleteLoanRepayUrgedSet(int id) {
		int result=loanRepayUrgedSetDaoImpl.deleteLoanRepayUrgedSet(id);
		return result;
	}

	@Override
	public LoanRepayUrgedSetEntity selectLoanRepayUrgedSetList() {
		LoanRepayUrgedSetEntity loanRepayUrgedSetEntity= loanRepayUrgedSetListDaoImpl.selectLoanRepayUrgedSet();
		return loanRepayUrgedSetEntity;
	}

}
