
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.HandleThreePartyDao;


/** 
 * 第三方交互相关操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-28 下午2:12:59  */
@Component("handleThreePartyDaoImpl")
public class HandleThreePartyDaoImpl extends SqlSessionDaoSupport implements HandleThreePartyDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertThirdInterfaceRecord(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ThreePartyXML.insertThirdInterfaceRecord", map);
	}

	@Override
	public int openAccountBack(Map<String, Object> map) {
			
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.openAccountBack",map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}

	@Override
	public Map<String, Object> rechargeBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.rechargeBack",map);
		return map;
	}
	@Override
	public Map<String, Object> authorizeBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.authorizeBack",map);
		return map;
	}
	@Override
	public int ProjectFail(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.ProjectFail",map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}

	@Override
	public int MemberWithdrawalBack_Qianduoduo(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.MemberWithdrawalBack_Qianduoduo",map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}

	@Override
	public int WithdraBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.WithdraBack",map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public String generateorderNo(String prefix) {
		Map<String, Object> map=new HashMap<String, Object>();
		// TODO Auto-generated method stub return null;
		map.put("orderNamePre", prefix);
		map.put("num", 14);
		getSqlSession().selectOne("ThreePartyXML.generateorderNo", map);
		String order="";
		order=map.get("newOrderNo").toString();
		return order;
	}
	
	@Override
	public int CreditorTransfer(Map<String, Object> map) {
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.CreditorTransfer", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public Map<String, Object> addInvestIncome(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.addInvestIncome", map);
		return map;
	}
	@Override
	public int updateProjrctTransStatu(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().update("ThreePartyXML.updateProjrctTransStatu", map);
	}
	@Override
	public int TransFail(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.TransFail", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public Map<String, Object> ReturnOfDeposit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.ReturnOfDeposit", map);
		return map;
	}
	@Override
	public int SurpriseRedBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub 
		getSqlSession().selectOne("ThreePartyXML.SurpriseRedBack", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public int DataTagBySurpriseRed(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.DataTagBySurpriseRed", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public int insertMemberTransferRecord(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ThreePartyXML.insertMemberTransferRecord", map);
	}
	@Override
	public int MemberTransferBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.MemberTransferBack", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public int PlatformAwardMoneyBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.PlatformAwardMoneyBack", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}

	@Override
	public int RepayBackQianduoduo(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.RepayBackQianduoduo", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public int AddVipPurchaseRecord(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().insert("ThreePartyXML.AddVipPurchaseRecord", map);
	}
	@Override
	public int PurchaseVipBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.PurchaseVipBack", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public int FangKuanLoan(long lApplyId,String sMerBillNo,String sOrderNos,int iStatu,
			String backInfoenc,String backinfo) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId(); 
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("lId", id);
		map.put("lApplyId", lApplyId);
		map.put("sMerBillNo", sMerBillNo);
		map.put("sOrderNos", sOrderNos);
		map.put("iStatu", iStatu);
		map.put("backInfoenc", backInfoenc);
		map.put("backinfo", backinfo);
		map.put("Skey",DbKeyUtil.GetDbCodeKey());
		getSqlSession().selectOne("ThreePartyXML.FuangKuan",map);
		int result =IntegerAndString.StringToInt(map.get("result").toString(),0);
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
        return result;
	}
	
	@Override
	public int insertInvestIncome(Map<String, Object> map) {
		
		getSqlSession().selectOne("investincomeList.insertInvestIncome",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);  
	}
	 
	@Override
	public int updateReplay(Map<String, Object> map) {
		
	    getSqlSession().selectOne("investincomeList.updateReplay",map);
	    return IntegerAndString.StringToInt(map.get("result").toString(),0);  
		
	}
	
	@Override
	public int CompensatoryRepayBack(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.CompensatoryRepayBack",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);  
	}
	
}

