

/** 
* @Title: MamberBankCardDao.java 
* @Package cn.bankcard.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-28 下午2:36:50 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.MemberBankCardEntity;
 

/** 
 * @author 刘利 
 * @Description: 会员银行卡管理写
 * @since 
 * @date 2016-3-28 下午2:36:50  */

public interface MamberBankCardDao {
	/**
	 * 插入银行卡信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param bankCardInfoEntity 银行卡信息实体 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-3-28 下午2:39:07
	 */
	public int insertBankCardInfo(BankCardInfoEntity bankCardInfoEntity);
	/**
	 * 插入会员银行卡信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param memberBankCardEntity 
	 * @return int 返回类型 返回类型 0失败，1成功
	 * @date 2016-3-28 下午2:46:52
	 */
	public int insertMemberBankCard(MemberBankCardEntity memberBankCardEntity);
	/**
	 * 修改银行卡信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   bankCardInfoEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 0：成功，1：失败
	 * @date 2016-3-28 下午3:45:43
	 */
	public int updateBankCardInfo(BankCardInfoEntity bankCardInfoEntity);
	/**
	 * 移除银行卡
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{receiveCard,memberID}
	 * @param @return 设定文件 
	 * @return int 返回类型 1:成功，0失败
	 * @date 2016-3-28 下午4:17:58
	 */
	public int deleteMemberBankCard(Map<String,Object> map);
}

