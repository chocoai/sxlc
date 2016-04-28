

/** 
* @Title: MamberBankCardDao.java 
* @Package cn.bankcard.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 下午2:11:50 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
 

/** 
 * @author 刘利 
 * @Description: 会员银行卡管理读
 * @since 
 * @date 2016-3-28 下午2:11:50  */

public interface MamberBankCardListDao {
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
	 * 查询该银行卡是否已存在
	 * @author 刘利    
	 * @param  map
	 * @param @return 设定文件 
	 * @return int 返回类型 0;不存子，大于0已存在
	 * @date 2016-3-28 下午3:01:23
	 */
	public int selectMemberBankCardByNo(Map<String,Object> map);
	/**
	 * 查询会员已绑定银行卡列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map 
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
	public BankCardInfoEntity selectMemberBankCardByID(long bankCardId);
	/**
	 * 查询该会员银行卡数量
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-14 下午3:23:08
	 */
	public int selectMemberBankCardCount(Map<String,Object> map);
	/**
	 * 查询该该银行卡是否存在
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-27 下午9:15:41
	 */
	public int selectMemberBankCardisExist(Map<String,Object> map);
}

