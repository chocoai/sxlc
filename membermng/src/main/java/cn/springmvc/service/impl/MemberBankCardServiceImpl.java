

/** 
* @Title: MemberBankCardServiceImpl.java 
* @Package cn.bankcard.Service.Impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 下午2:25:03 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
import cn.springmvc.dao.MamberBankCardDao;
import cn.springmvc.dao.MamberBankCardListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.MemberBankCardDaoImpl;
import cn.springmvc.dao.impl.MemberBankCardListDaoimpl;
import cn.springmvc.service.MamberBankCardService;
 

/** 
 * @author 刘利 
 * @Description: 会员银行卡管理
 * @since 
 * @date 2016-3-28 下午2:25:03  */
@Service("memberBankCardServiceImpl")
public class MemberBankCardServiceImpl implements MamberBankCardService{
	@Resource(name="memberBankCardListDaoimpl")
	private MamberBankCardListDao memberBankCardListDaoimpl; 
	@Resource(name="memberBankCardDaoImpl")
	private MamberBankCardDao memberBankCardDaoImpl; 
	@Override
	public List<BankCodeEntity> selectBankInfo() {
		
		return memberBankCardListDaoimpl.selectBankInfo();
		
	}
	@Override
	public List<ProvinceDictionaryEntity> selectProvinceDictionary() {
		
		return memberBankCardListDaoimpl.selectProvinceDictionary();
		
	}
	@Override
	public List<CityDictionaryEntity> selectCityDictionary(int provinceId) {
		
		return memberBankCardListDaoimpl.selectCityDictionary(provinceId);
		
	}
	@Override
	public int insertMemberBackCard(BankCardInfoEntity bankCardInfoEntity,
			MemberBankCardEntity memberBankCardEntity) {
		int result = -1;
		if( bankCardInfoEntity == null ) {
			return -1;
		}
		if( memberBankCardEntity == null ) {
			return -1;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bankNo", bankCardInfoEntity.getBankNo());
		map.put("receiveCard", 0); 
		//查询银行卡是否已存在
	    result = memberBankCardListDaoimpl.selectMemberBankCardByNo(map);
	    //该银行卡已存在
	    if( result > 0 ) {
	    	
	    	return -2;
	    }
	    IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		bankCardInfoEntity.setBankCardId(id);
		
	    result = memberBankCardDaoImpl.insertBankCardInfo(bankCardInfoEntity);
	    if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		//银行卡信息添加成功，添加会员银行卡信息表
		if(result ==1 ){
		    id = generatorUtil.GetId();
		    memberBankCardEntity.setReceiveCard(id);
			result = memberBankCardDaoImpl.insertMemberBankCard(memberBankCardEntity);
			
		    if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
		    }else{
				generatorUtil.SetIdUsed(id);
		    }
		}
		
		return result;
	}
	@Override
	public List<MemberBankCardEntity> selectMemberBankCardList(
			Map<String, Object> map) {
		
		return memberBankCardListDaoimpl.selectMemberBankCardList(map);
		
	}
	@Override
	public BankCardInfoEntity selectMemberBankCardByID(int bankCardId) {
		
		return memberBankCardListDaoimpl.selectMemberBankCardByID(bankCardId);
		
	}
	@Override
	public int updateBankCardInfo(BankCardInfoEntity bankCardInfoEntity,Map<String,Object> map) {
		
		int result = -1; 
		
		if(bankCardInfoEntity == null ) {
			return 0;
		} 
		//查询银行卡是否已存在
	    result = memberBankCardListDaoimpl.selectMemberBankCardByNo(map);
	    //该银行卡已存在
	    if( result > 0 ) {
	    	
	    	return -2;
	    }
	    result = memberBankCardDaoImpl.updateBankCardInfo(bankCardInfoEntity);
	    return result;
	}
	@Override
	public int deleteMemberBankCard(int receiveCard) {
		
		return memberBankCardDaoImpl.deleteMemberBankCard(receiveCard);
		
	}

}

