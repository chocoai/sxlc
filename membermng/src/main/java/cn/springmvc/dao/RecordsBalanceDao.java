

/** 
* @Title: RecordsBalanceDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午1:50:09 
* @version V5.0 */
 
package cn.springmvc.dao; 
 
import java.util.List;
import java.util.Map;

import cn.membermng.model.InvestmentstatisticsEntity;
import cn.membermng.model.LoanCreditStatisticsEntity;
import cn.membermng.model.MemberRedpacketsEntity;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;

/** 
 * @author 刘利 
 * @Description: 查询会员账户信息 ,与红包信息，投资与借款收还款信息
 * @since 
 * @date 2016-3-22 下午1:50:09  */

public interface RecordsBalanceDao {
  
	/** 
	 * 根据会员id与会员type查询会员第三方账户金额
	 * @author 刘利   
	 * @Description: TODO 
	 * @param 根据会员id与会员type查询会员第三方账户金额 
	 * @return OwnTradingRecordsBalanceEntity 会员交易记录余额实体
	 * @date 2016-3-22 下午1:52:25 
	 */
	public OwnTradingRecordsBalanceEntity selectMemberBalance(Map<String,Object> map);
	
	/**
	 *  会员账户红包信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 
	 * @return List<MemberRedpacketsEntity> 会员红包记录列表
	 * @date 2016-3-22 下午2:26:20
	 */
	public List<MemberRedpacketsEntity> selectMembergift(int memberID);
	
	/** 
	 * 查询会员的红包个数
	 * @author 刘利   
	 * @Description: 查询会员的红包个数
	 * @param memberID 会员id 
	 * @return int 红包个数
	 * @date 2016-3-22 下午2:37:38
	 */
	public int selectMembergiftCount(int memberID);
	 /** 
     *  查询会员成功还款笔数
     * @author 刘利   
     * @Description: 查询会员成功还款笔数
     * @param  membereID 会员id 
     * @return long 返回类型  成功还款笔数
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectTotalreplay(int membereID); 
    /** 
     * 查询会员提前还款笔数
     * @author 刘利   
     * @Description: 查询会员提前还款笔数
     * @param  membereID 会员id 
     * @return long 返回类型  提前还款笔数
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectAdvanceReplay(int membereID);
    /** 
     * TODO(描述)
     * @author 刘利   
     * @Description: 查询会员逾期还款笔数
     * @param membereID 会员id 
     * @return long 返回类型  逾期还款笔数
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectTotalReplayOver(int membereID);
    /** 
     * TODO(描述)
     * @author 刘利   
     * @Description: 查询会员成功投资笔数
     * @param  membereID 会员id 
     * @return long 返回类型  成功投资笔数
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectTotalInvest(int membereID);
    /** 
     * TODO查询会员严重逾期还款笔数
     * @author 刘利   
     * @Description: 查询会员严重逾期还款笔数
     * @param   membereID 会员id 
     * @return long 返回类型  严重逾期
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectReplayOverLimit(int membereID);
    /** 
     * 查询会员逾期未还款笔数
     * @author 刘利   
     * @Description: 查询会员逾期未还款笔数
     * @param  membereID 会员id 
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public int selectTotalOverNotReplay(int membereID);
    /** 
     * 查询会员投资总额
     * @author 刘利   
     * @Description: 查询投资总额
     * @param  map{membereID 会员id} 
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public long selectMemberInvestTotal(Map<String, Object> map);
    /** 
     * 查询会员累计已收本金
     * @author 刘利   
     * @Description: 查询累计已收本金
     * @param  map{membereID 会员id} 
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public long selectRecvPrincipalTotal(Map<String, Object> map);
    /** 
     * 查询会员累计已收收益
     * @author 刘利   
     * @Description: 查询累计已收收益
     * @param  map{membereID 会员id }
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public long selectMemberReIncomeTotal(Map<String, Object> map);
    /** 
     * 查询会员累计应收本金
     * @author 刘利   
     * @Description: 查询累计应收
     * @param  map{membereID 会员id }
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public long selectSDRecvPrincipalTotal(Map<String, Object> map);
    /** 
     * 查询会员累计应收收益
     * @author 刘利   
     * @Description: 查询累计应收收益
     * @param  map{membereID 会员id }
     * @return long 返回类型  
     * @date 2016-3-21 下午4:26:58 
     */
    public long selectMemberSDIncomeTotal(Map<String, Object> map);
    /**
     * 根据会员id,与会员type查询会员第三方账户信息
     * @author 刘利   
     * @Description: TODO 
     * @param map查询参数
     * @return MemberThirdAuthInfoEntity 会员第三方授权实体
     * @date 2016-3-25 上午11:59:16
     */
    public MemberThirdAuthInfoEntity selectMemberThirdAuthInfo(Map<String,Object> map);
    /**
     * 会员借款信用统计
     * @author 刘利   
     * @Description: TODO 
     * @param  membereID
     * @param @return 设定文件 
     * @return LoanCreditStatisticsEntity 返回类型 
     * @date 2016-4-9 下午4:05:33
     */
    public LoanCreditStatisticsEntity selectLoanCreditStatistics(long membereID);
    /**
     * 会员借款信用统计
     * @author 刘利   
     * @Description: TODO 
     * @param  map {memberID sKey}
     * @param @return 设定文件 
     * @return InvestmentstatisticsEntity 返回类型 
     * @date 2016-4-9 下午4:05:33
     */
    public InvestmentstatisticsEntity selectInvestmentstatistics(Map<String, Object> map);
}

