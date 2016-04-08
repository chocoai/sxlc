
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.RepaymentIn;
import cn.springmvc.dao.impl.IMyLoanReadDao;
import cn.springmvc.service.IMyLoanService;



/***
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午10:14:52 
*
*/
@Service
public class MyLoanServiceImpl implements IMyLoanService {

	
	@Resource(name="myLoanReadDaoImpl")
	private IMyLoanReadDao myLoanReadDao;
	
	@Override
	public List<Financing> financings(PageEntity entity) {
		
		return myLoanReadDao.financings(entity);
	}
	
	
	
	@Override
	public List<Financing> endOfFinancing(PageEntity entity) {
		
		return myLoanReadDao.endOfFinancing(entity);
	}
	
	
	
	@Override
	public List<RepaymentIn> repaymentIns(PageEntity entity) {
		
		return myLoanReadDao.repaymentIns(entity);
	}
	
	
	@Override
	public List<InvestmentRecord> investRecord(PageEntity entity) {
		
		return myLoanReadDao.investRecord(entity);
	}
	
	
	@Override
	public List<LoanRepay> loanRepay(PageEntity entity) {
		
		return myLoanReadDao.loanRepay(entity);
	}

	
	@Override
	public List<FlowLabel> flowLabelS(PageEntity entity) {
		
		return myLoanReadDao.flowLabelS(entity);
	}
}

