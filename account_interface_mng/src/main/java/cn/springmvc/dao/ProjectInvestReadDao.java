package cn.springmvc.dao;

import cn.sxlc.account.manager.model.TransferSubmitEntity;

public interface ProjectInvestReadDao {

    /**
     * 获取最大可投金额
     * GetMaxInvestAmount	获取某个会员对某个项目的当前最大可投金额
     * TODO(描述)
     *
     * @param @param  lProjectId			项目id
     * @param @param  lMemberId				会员id
     * @param @param  sKey					加密，解密key值
     * @param @param  sIsAuto				是否自动投标		0：否	1：是
     * @param @return 设定文件
     * @return long 返回类型
     * @throws w
     * @author 张友
     * @Title: GetMaxInvestAmount
     * @Description: TODO
     * @date 2016-3-28 下午8:27:59
     */
    public long GetMaxInvestAmount(long lProjectId, long lMemberId, String sKey, short sIsAuto);

    /**
     * MemberInvestCheck	  会员项目投资，投资前信息处理
     * TODO(描述)
     *
     * @param lMemberId       会员ID
     * @param lProjectId      项目ID
     * @param sIsAuto         是否为自动投标	0:否	1：是
     * @param lAmount         投资总金额		(单位元，保留4位小数)
     * @param sRedpacketsInfo 红包使用金额		红包1ID,使用金额(单位元 格式：0.20元，保留2位小数);红包ID2,使用金额;
     * @param lVouchers       代金券金额		(单位元，保留4位小数)
     * @param sKey            加密解密key
     * @param lRedpackets     返回红包总额
     * @param sDirectPwd      定向标密码
     * @param @return         设定文件
     * @return String 返回类型 				验证成功返回:success  其他为失败原因
     * 1：验证成功 0：验证失败 -1：投资金额超过最大投资金额 -2：使用红包金额比例大于项目最高红包比例 -3：红包已经过期
     * -4：红包使用金额大于红包总额 -5：代金券使用金额大于代金券可用余额	-6：红包、代金券总和不能超过或等于投资总额
     * -7：您投资的笔数已达上限不能再投资
     * -8:不能超过自动投标比例上限 -9：自动投资未开始 -10:项目未开标 -11：投资金额超过剩余投资金额 -12：项目已满标（投标时间结束，投标满标）
     * -13:自己不能投资自己的借款	-14：余额不足 -15:定向标密码错误
     * @throws wu
     * @author 张友
     * @Title: MemberInvestCheck
     * @Description: TODO
     * @date 2016-3-29 下午3:49:00
     */
    public String MemberInvestCheck(long lMemberId, long lProjectId, short sIsAuto, long lAmount,
                                    String sRedpacketsInfo, long lVouchers, String sKey,
                                    long[] lRedpackets, String sDirectPwd);

    /**
     * 获取投资详情
     * GetInvestInfo 获取投资详情
     * TODO(描述)
     *
     * @param sIsAuto     自动投标	0：否 1：是
     * @param lMemberId   会员ID
     * @param lProjectId  项目ID
     * @param lAmount     投资总金额
     * @param lRedpackets 使用红包金额
     * @param lVouchers   使用代金券
     * @param sClient     使用客户端：0：pc 1：app 2：微信端
     * @param 设定文件
     * @return TransferSubmitEntity 返回类型 	返回调用投资接口对象
     * @throws w
     * @author 张友
     * @Title: GetInvestInfo
     * @Description: TODO
     * @date 2016-3-30 下午5:11:26
     */
    public TransferSubmitEntity GetInvestInfo(short sIsAuto, long lMemberId, long lProjectId, long lAmount,
                                              long lRedpackets, long lVouchers, short sClient);
    
    /**
     * 获取项目投资红包使用上限
    * GetRedpacketsInvestRate 获取项目投资红包使用上限
    * TODO 获取项目投资红包使用上限
    * @author 张友  
    * * @Title: GetRedpacketsInvestRate 
    * @Description: TODO 
    * @param @return 设定文件 
    * @return int 返回类型 
    * @date 2016-4-29 下午5:26:18
    * @throws
     */
    int GetRedpacketsInvestRate();
}

