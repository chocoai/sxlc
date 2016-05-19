

/** 
* @Title: MamberBankCardService.java 
* @Package cn.bankcard.Service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 下午2:19:27 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map; 

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;

/** 
 * @author 刘利 
 * @Description: 会员银行卡管理
 * @since 
 * @date 2016-3-28 下午2:19:27  */

public interface MamberBankCardService {
	/**
	 * 查询银行信息列表
	 * @author 刘利   
	 * @Description: TODO  
	 * @return List<BankCodeEntity> 返回类型 
	 * @date 2016-3-28 下午2:14:53
	 */
	public List<BankCodeEntity> selectBankInfo();
	/**
	 *  查询省份信息
	 * @author 刘利   
	 * @Description: TODO  
	 * @return List<ProvinceDictionaryEntity> 返回类型 
	 * @date 2016-3-28 下午2:31:19
	 */
	public List<ProvinceDictionaryEntity> selectProvinceDictionary();
	/**
	 *  根据省份ID查询市区信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param provinceId 省份ID 
	 * @return List<CityDictionaryEntity> 返回类型 
	 * @date 2016-3-28 下午2:34:01
	 */
	public List<CityDictionaryEntity> selectCityDictionary(int provinceId);
	/**
	 *  新增会员银行卡
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  bankCardInfoEntity
	 * @param  memberBankCardEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 -1失败，-2：该银行卡已存在,1 ,成功 ，-3 该会员绑定银行卡已超过15张
	 * @date 2016-3-28 下午2:55:17
	 */
	public int insertMemberBackCard(BankCardInfoEntity bankCardInfoEntity,MemberBankCardEntity memberBankCardEntity);
	/**
	 * 查询会员已绑定银行卡列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {memberID,memberType}
	 * @return List<MemberBankCardEntity> 返回类型 
	 * @date 2016-3-28 下午3:23:56
	 */
	public List<MemberBankCardEntity> selectMemberBankCardList(Map<String,Object> map);
	/**
	 * 根据银行卡ID查询银行卡信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  bankCardId 银行卡ID
	 * @param @return 设定文件 
	 * @return BankCardInfoEntity 返回类型 
	 * @date 2016-3-28 下午3:36:48
	 */
	public BankCardInfoEntity selectMemberBankCardByID(long bankCardId,long memberID);
	/**
	 * 修改银行卡信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   bankCardInfoEntity, map{bankNo(银行卡号),receiveCard(会员银行卡ID )}
	 * @param @return 设定文件 
	 * @return int 返回类型 1：成功，0：失败,-2该银行卡号已存在-3,该银行卡不存在不能修改
	 * @date 2016-3-28 下午3:45:43
	 */
	public int updateBankCardInfo(BankCardInfoEntity bankCardInfoEntity,
			Map<String,Object> map,long memberID,int memberType);
	/**
	 * 移除银行卡
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  @param map{receiveCard 会员银行卡ID，memberID}
	 * @param @return 设定文件 
	 * @return int 返回类型 1:成功，0失败
	 * @date 2016-3-28 下午4:17:58
	 */
	public int deleteMemberBankCard(Map<String,Object> map);
}

