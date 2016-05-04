package cn.springmvc.dao.impl;

import cn.springmvc.dao.AccountSupportDao;
import cn.sxlc.account.manager.model.InvestAccountFeeEntity;
import cn.sxlc.account.manager.model.UnUsedRedpacketsEntity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取管理员  账户信息
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-27 下午9:06:00
 */
@Repository("accountDaoSupport")
public class AccountDaoSupport extends SqlSessionDaoSupport implements AccountSupportDao{

    @Override
    @Resource(name = "sqlSessionFactoryR")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

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
    public long getRemainderVouchers(long lMemberId) {
        long lResult = 0;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("lMemberId", lMemberId);
        param.put(DaoConstant.PARAM_RESULT, 0);

        getSqlSession().selectOne("AccountDao.GetRemainderVouchers", param);

        lResult = IntegerAndString.StringToLong(param.get(DaoConstant.PARAM_RESULT).toString(), -1);

        return lResult;
    }

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
    public List<UnUsedRedpacketsEntity> getMemberUnUsedRedPackets(long lMemberId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("memberId", lMemberId);
        List<UnUsedRedpacketsEntity> list = getSqlSession().selectList("AccountDao.GetUnUsedRedpackets", param);
        return list;
    }
    
    /**
     * 
    * getGuaranteeInfo 获取项目担保机构 担保
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
    public InvestAccountFeeEntity getGuaranteeInfo (long lProjectId){

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("applyId", lProjectId);
        // 获取担保费 担保账户标识
        return getSqlSession().selectOne("AccountDao.GetGuaranteeInfo", param);

    }
    
    /**
     * 获取会员第三方账户信息
     */
    public String getInvestMemberMark(long lMemberId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("memberId", lMemberId);
        return getSqlSession().selectOne("AccountDao.GetInvestMemberMark",param);
    }
}
