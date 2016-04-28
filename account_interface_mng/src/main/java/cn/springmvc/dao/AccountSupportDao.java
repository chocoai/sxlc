
package cn.springmvc.dao; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.impl.DaoConstant;
import cn.sxlc.account.manager.model.InvestAccountFeeEntity;
import cn.sxlc.account.manager.model.UnUsedRedpacketsEntity;

public interface AccountSupportDao {
	 /**
     * 获取会员剩余代金券
     * GetRemainderVouchers		获取某个会员当前剩余代金券
     * TODO(描述)
     *
     * @param lMemberId			会员ID
     * @return long 返回类型
     * @throws
     * @author 张友
     * * @Title: GetRemainderVouchers
     * @Description: TODO
     * @date 2016-3-28 下午8:48:39
     */
    long getRemainderVouchers(long lMemberId);

    /**
     * 获取会员可用红包列表
     * GetMemberUnUsedRedpackets			获取会员可用红包列表
     * TODO(描述)
     *
     * @param lMemberId				会员ID
     * @return List<UnUsedRedpacketsEntity> 返回类型 			红包列表
     * @throws
     * @author 张友
     * * @Title: GetMemberUnUsedRedpackets
     * @Description: TODO
     * @date 2016-3-29 下午2:27:11
     */
    List<UnUsedRedpacketsEntity> getMemberUnUsedRedPackets(long lMemberId);
    
    /**
     * 
    * getGuaranteeInfo(这里用一句话描述这个方法的作用) 
    * TODO(描述)
    * @author 张友  
    * * @Title: getGuaranteeInfo 
    * @Description: TODO 
    * @param @param lProjectId
    * @param @return 设定文件 
    * @return InvestAccountFeeEntity 返回类型 
    * @date 2016-4-27 下午8:37:00
    * @throws
     */
    InvestAccountFeeEntity getGuaranteeInfo (long lProjectId);

    String getInvestMemberMark(long lMemberId);
}

