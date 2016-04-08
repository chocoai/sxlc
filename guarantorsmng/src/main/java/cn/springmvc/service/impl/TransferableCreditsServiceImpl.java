
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.impl.HandleGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.HandleTransferableCreditsDaoImpl;
import cn.springmvc.dao.impl.SelectGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.SelectTransferableCreditsDaoImpl;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.model.TransferRulesEntity;
import cn.springmvc.model.TransferableCreditsEntity;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.TransferableCreditsService;



@Service("transferableCreditsServiceImpl")
public class TransferableCreditsServiceImpl implements
TransferableCreditsService {
	@Resource(name="selectTransferableCreditsDaoImpl")
	private SelectTransferableCreditsDaoImpl  selectTransferableCreditsDaoImpl;
	@Resource(name="handleTransferableCreditsDaoImpl")
	private HandleTransferableCreditsDaoImpl  handleTransferableCreditsDaoImpl;

	@Override
	public List<TransferableCreditsEntity> selectTransferableCredits(
			PageEntity page) {
		TransferRulesEntity tra=new TransferRulesEntity();
		// TODO Auto-generated method stub return null;
		tra=selectTransferableCreditsDaoImpl.selectTransferRules(page.getMap());
		page.getMap().put("holdDate", tra.getHoldDay());
		page.getMap().put("repayMaxTime", tra.getInterestDay());
		page.getMap().put("repayMaxTime", tra.getRangeDay());
		return selectTransferableCreditsDaoImpl.selectTransferableCredits(page);
	}
	@Override
	public Map<String, Object> creditorTransApp(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return handleTransferableCreditsDaoImpl.creditorTransApp(map);
	}

}

