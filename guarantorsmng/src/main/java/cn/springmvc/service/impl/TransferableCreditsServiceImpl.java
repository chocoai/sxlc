
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.dao.impl.HandleGuaranteeInfoDaoImpl;
import cn.springmvc.dao.impl.HandleTransferableCreditsDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
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
	IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();

	@Override
	public List<TransferableCreditsEntity> selectTransferableCredits(
			PageEntity page) {
		if(page == null || page.getMap()==null){
			return null;
		}
		TransferRulesEntity tra=new TransferRulesEntity();
		Map<String, Object> param = page.getMap();
		// TODO Auto-generated method stub return null;
		tra=selectTransferableCreditsDaoImpl.selectTransferRules(param);
		param.put("holdDate", tra.getHoldDay());
		param.put("repayMaxTime", tra.getInterestDay());
		param.put("repayMaxTime", tra.getRangeDay());
		List<TransferableCreditsEntity>  list=selectTransferableCreditsDaoImpl.selectTransferableCredits(page);
		PageUtil.ObjectToPage(page, list);
		return list;
	}
	@Override
	public int creditorTransApp(Map<String, Object> map) {
		long id=generatorUtil.GetId();
		map.put("ctaId", id);
		String sKey = DbKeyUtil.GetDbCodeKey();
		map.put("skey", sKey);
		// TODO Auto-generated method stub return null;
		handleTransferableCreditsDaoImpl.creditorTransApp(map);
		int result=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		if (result==1) {
			generatorUtil.SetIdUsed(id);
		}else {
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}

}

