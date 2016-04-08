

/** 
* @Title: CapitalbudgetdetailsService.java 
* @Package cn.capitalbudgetdetails.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午5:03:46 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 资金收支明细
 * @since 
 * @date 2016-3-30 下午5:03:46  */

public interface CapitalbudgetdetailsService {
	/**
	 * 查询会员交易记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity 
	 * <p> map {tradeTypeId(交易类型：-1全部);startrecordDate;endrecordDate;recorddays(近几周，几月，转换为天数)，sKey
	 *          order(1交易金额 降序,-1交易金额 升序，2 冻结金额 降序，-2 冻结金额 升序， 3待收本金 降序，-3 待收本金升序
	 *                4待收利息 降序,-4待收利息 升序，5 账户可用金额  降序，-5 账户可用金额 升序， 6待还本金 降序，-6 待还本金 升序
	 *                7待还利息 降序,-7待还利息 升序，8 待还逾期利息  降序，-8待还逾期利息 升序， 9待还逾期罚息 降序， -9 待还逾期罚息 升序
	 *                10总金额 降序， -10 总金额 升序
	 *          ),memberID,memberType}
	 * </p>         
	 * @param @return 设定文件 
	 * @return List<MemberTradingRecordsEntity> 返回类型 
	 * @date 2016-3-30 下午4:46:30
	 */
	public List<MemberTradingRecordsEntity> selectMemberTradingRecords(PageEntity pageEntity);
	/**
	 * 查询会员交易记录详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {tradeID(交易记录ID)}
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
	 * <p>
	 *   map{thirdMerBillno,startTime,endtimeTime,statu(-1所有),memberID,memberType
	 *   order(1充值金额 降序,-1充值金额 升序，2 交易时间 降序，-2 交易时间 升序， 3实际到账金额 降序，-3 实际到账金额 升序),sKey}
	 * </p>
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
	 * <p>
	 *   map{thirdMerBillno,startTime,endtimeTime,statu(-1所有),memberID,memberType
	 *   order(1提现金额 降序,-1提现金额 升序，2 交易时间 降序，-2 交易时间 升序， 3实际到账金额 降序，-3 实际到账金额 升序),sKey}
	 * </p>
	 * @param @return 设定文件 
	 * @return List<MemberWithdrawalRechargeEntity> 返回类型 
	 * @date 2016-3-30 下午7:40:02
	 */
	public List<MemberWithdrawalRechargeEntity> selectWithdrawalList(PageEntity pageEntity);
	/**
	 * 总的充值手续费
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {memberID,memberType }
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:28
	 */
	public long selectTotalRechargeFee(Map<String,Object> map);
	/**
	 * 充值实际到账总额
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {memberID,memberType }
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:28
	 */
	public long selectTotalRechargeReal(Map<String,Object> map);
	/**
	 * 总的提现手续费 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {memberID,memberType }
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:29
	 */
	public long selectTotalWithdrawalFee(Map<String,Object> map);
	/**
	 * 总的实际到账提现金额
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {memberID,memberType }
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-30 下午7:41:30
	 */
	public long selectTotalWithdrawalReal(Map<String,Object> map);
}

