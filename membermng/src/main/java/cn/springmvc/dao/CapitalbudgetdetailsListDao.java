

/** 
* @Title: MemberTradingRecordsDao.java 
* @Package cn.capitalbudgetdetails.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午4:43:37 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;

import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description: 资金收支明细 
 * @since 
 * @date 2016-3-30 下午4:43:37  */

public interface CapitalbudgetdetailsListDao {
	/**
	 * 查询会员交易记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   pageEntity
	 * @param @return 设定文件 
	 * @return List<MemberTradingRecordsEntity> 返回类型 
	 * @date 2016-3-30 下午4:46:30
	 */
	public List<MemberTradingRecordsEntity> selectMemberTradingRecords(PageEntity pageEntity);
	/**
	 * 查询会员交易记录详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   map
	 * @param @return 设定文件 
	 * @return MemberTradingRecordsEntity 返回类型 
	 * @date 2016-3-30 下午4:48:59
	 */
	public MemberTradingRecordsEntity selectTradingRecordsdetail(Map<String,Object> map);
	/**
	 * 分页查询会员充值记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   pageEntity
	 * @param @return 设定文件 
	 * @return List<MemberWithdrawalRechargeEntity> 返回类型 
	 * @date 2016-3-30 下午7:38:38
	 */
	public List<MemberWithdrawalRechargeEntity> selectRechargeList(PageEntity pageEntity);
	/**
	 * 分页查询会员提现记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * @param @return 设定文件 
	 * @return List<MemberWithdrawalRechargeEntity> 返回类型 
	 * @date 2016-3-30 下午7:40:02
	 */
	public List<MemberWithdrawalRechargeEntity> selectWithdrawalList(PageEntity pageEntity);
	/**
	 * 总的充值手续费
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:28
	 */
	public long selectTotalRechargeFee(Map<String,Object> map);
	/**
	 * 充值实际到账总额
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:28
	 */
	public long selectTotalRechargeReal(Map<String,Object> map);
	/**
	 * 总的提现手续费 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:29
	 */
	public long selectTotalWithdrawalFee(Map<String,Object> map);
	/**
	 * 总的实际到账提现金额
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:30
	 */
	public long selectTotalWithdrawalReal(Map<String,Object> map);
}

