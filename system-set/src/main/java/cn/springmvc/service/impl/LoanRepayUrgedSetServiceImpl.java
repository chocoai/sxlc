package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.LoanRepayUrgedSetDao;
import cn.springmvc.dao.LoanRepayUrgedSetListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.LoanRepayUrgedSetEntity; 
import cn.springmvc.service.LoanRepayUrgedSetService;
@Service("loanRepayUrgedSetServiceImpl")
public class LoanRepayUrgedSetServiceImpl implements LoanRepayUrgedSetService {
	@Resource(name="loanRepayUrgedSetDaoImpl")
	private LoanRepayUrgedSetDao loanRepayUrgedSetDaoImpl;  
	@Resource(name="loanRepayUrgedSetListDaoImpl")
	private LoanRepayUrgedSetListDao loanRepayUrgedSetListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertLoanRepayUrgedSet(LoanRepayUrgedSetEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return -1;
		} 
		int result = 0;
		// 查询催收账单配置是否存在，不存在就新增，存在则修改
		int count = loanRepayUrgedSetListDaoImpl.selectLoanRepayUrgedSetIsExist();
		if(count == 0) { 
			result = loanRepayUrgedSetDaoImpl.insertLoanRepayUrgedSet(entity);  
		}else{
			result = loanRepayUrgedSetDaoImpl.updateLoanRepayUrgedSet(entity); 
		} 
		if(result == 1) {
			StringBuffer details = new StringBuffer("设置催收账单  :");
			if(entity.getBillDays() != -1) {
				details.append("到期前"+entity.getBillDays()+"天视为即将到期账单");
			}
			if(entity.getBillContent() != null&& entity.getBillContent()!="") {
				details.append("账单内容"+entity.getBillContent());
			}
			logentity.setsDetail(details.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return count;
	}

	@Override
	public int deleteLoanRepayUrgedSet() {
		
		return  loanRepayUrgedSetDaoImpl.deleteLoanRepayUrgedSet(); 
	}

	@Override
	public LoanRepayUrgedSetEntity selectLoanRepayUrgedSetList() {
		LoanRepayUrgedSetEntity loanRepayUrgedSetEntity= loanRepayUrgedSetListDaoImpl.selectLoanRepayUrgedSet();
		return loanRepayUrgedSetEntity;
	}

}
